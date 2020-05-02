package com.gang.common.lib.utils;

import com.alibaba.fastjson.JSONObject;
import com.gang.common.lib.exception.CommonException;
import com.gang.common.lib.type.DefaultProperties;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname HttpClientUtils
 * @Description TODO
 * @Date 2019/12/25 21:46
 * @Created by zengzg
 */
public final class HttpClientUtils {

    private final static Logger LOG = LoggerFactory.getLogger(HttpClientUtils.class);

    private HttpClientUtils() {
    }

    // 请求超时时间
    private static int SOCKET_TIMEOUT = 300000;
    // 传输超时时间
    private static int CONNECT_TIMEOUT = 300000;

    private static String HTTP_GET = "GET";
    private static String HTTP_POST = "POST";

    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;

    /**
     * @param syncPath
     * @param type
     * @param headerMap
     * @param paramMap
     * @param body
     * @return
     */
    public static String doHttpHandle(String syncPath, String type, Map<String, String> headerMap,
                                      Map<String, String> paramMap, JSONObject body) {

        HttpClient httpclient =
                HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm)
                        .setConnectionManagerShared(true).build();

        try {
            URIBuilder builder = new URIBuilder(syncPath);

            if (paramMap != null) {
                paramMap.keySet().forEach(item -> {
                    // 注意 : 空字符串有意义
                    if (null != paramMap.get(item)) {
                        builder.setParameter(item, paramMap.get(item));
                    }
                });
            }

            URI uri = builder.build();
            LOG.info("------> Azure real list path :{} <-------", builder.toString());
            HttpRequestBase request = null;

            switch (type) {
                case DefaultProperties.HTTP_GET:
                    request = new HttpGet(uri);
                    break;
                case DefaultProperties.HTTP_PUT:
                    request = new HttpPut(uri);
                    break;
                case DefaultProperties.HTTP_PATCH:
                    request = new HttpPatch(uri);
                    break;
                case DefaultProperties.HTTP_POST:
                    request = new HttpPost(uri);
                    break;
                case DefaultProperties.HTTP_DELETE:
                    request = new HttpDelete(uri);
                    break;
                default:
                    throw new CommonException("No Http Request Type");
            }

            // Build Header Start --------------
            if (headerMap != null) {
                for (String key : headerMap.keySet()) {
                    request.addHeader(key, headerMap.get(key));
                }
            }

            if (body != null) {
                HttpEntity entity = null;
                if ("application/x-www-form-urlencoded".equals(headerMap.get("Content-Type"))) {
                    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                    body.keySet().forEach(item -> {
                        pairs.add(new BasicNameValuePair(item, body.getString(item)));
                    });
                    entity = new UrlEncodedFormEntity(pairs, "UTF-8");
                } else {
                    entity = new StringEntity(body.toJSONString());
                }
                if (DefaultProperties.HTTP_POST.equals(type)) {
                    ((HttpPost) request).setEntity(entity);
                } else if (DefaultProperties.HTTP_PATCH.equals(type)) {
                    ((HttpPatch) request).setEntity(entity);
                }
            }

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            String responseBody = null;
            if (entity != null) {
                responseBody = EntityUtils.toString(entity, "UTF-8");
            }

            // Error Edit
            if (responseBody != null && responseBody.length() > 20
                    && responseBody.substring(0, 20).contains("odata.error")) {
                LOG.error("E----> Http Send Error :{}", responseBody);
            }

            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("E----> error :{} -- content :{}", e.getClass(), e.getMessage());
        }
        return null;
    }

    /**
     * @param url
     * @param body
     * @return
     */
    public static String sendHttpPost(String url, String body) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(body, Charset.forName("UTF-8")));
        CloseableHttpResponse httpResponse = null;

        // 返回值内容
        String content = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                LOG.info("Response status:" + httpResponse.getStatusLine());
                content = EntityUtils.toString(entity, "utf-8");
                LOG.info("Response content:" + content);
                LOG.info("Content length:" + content.length());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOG.info("Error exception:" + e.getMessage());
            e.printStackTrace();

        } finally {
            if (httpResponse != null) {
                close(httpResponse);
            }
            close(httpClient);
        }

        return content;

    }

    public void test() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://www.baidu.com");
            CloseableHttpResponse response = httpClient.execute(httpget);
            HttpEntity httpEntity = response.getEntity();
            String strResult = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String doGet(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
        CloseableHttpResponse httpResponse = null;
        // 返回值内容
        String content = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                LOG.info("Response status:" + httpResponse.getStatusLine());
                content = EntityUtils.toString(entity, "utf-8");
                LOG.info("Response content:" + content);
                LOG.info("Content length:" + content.length());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOG.info("Error exception:" + e.getMessage());
            e.printStackTrace();

        } finally {
            if (httpResponse != null) {
                close(httpResponse);
            }
            close(httpClient);
        }

        return content;
    }

    private static <T extends java.io.Closeable> void close(T t) {
        try {
            if (t != null) {
                t.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 无需SSL 证书 Post 请求
     * 如果调用 https 接口的时候出现了例如 SSLExeption 类报错 , 可能是缺少 SSL 证书的原因
     * 此时 , 需要配置 SSL 证书 ,或者调用该接口
     *
     * @param postUrl
     * @param paramJson
     * @param token
     * @return
     */
    public static String doPostNoSSL(String postUrl, String paramJson, String token) {
        String resultStr = ""; // 返回结果
        try {

            //            1、创建httpClient
            //            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpClient buildSSLCloseableHttpClient = buildSSLCloseableHttpClient();

            System.setProperty("jsse.enableSNIExtension", "false");
            HttpPost httpPost = new HttpPost(postUrl);

            httpPost.setHeader("Authorization", "Bearer " + token);

            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT)
                    .setConnectTimeout(CONNECT_TIMEOUT).build();

            httpPost.setConfig(requestConfig);

            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            // 放入请求参数
            StringEntity data = new StringEntity(paramJson, Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            // 发送请求，接收结果
            CloseableHttpResponse response = buildSSLCloseableHttpClient.execute(httpPost);

            // 4.获取响应对象中的响应码
            StatusLine statusLine = response.getStatusLine();
            int responseCode = statusLine.getStatusCode();

            System.out.println(responseCode);

            if (responseCode == 200) {
                // 打印响应内容
                resultStr = EntityUtils.toString(response.getEntity(), "UTF-8");

                // 5. 可以接收和发送消息
                HttpEntity entity = response.getEntity();
                // 6.从消息载体对象中获取操作的读取流对象
                InputStream input = entity.getContent();

            } else {
                System.out.println("响应失败! : " + response.toString());
            }
            buildSSLCloseableHttpClient.close();

        } catch (Exception e) {
            LOG.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }

        return resultStr;
    }

    /**
     * 构建无需 Https SSL 证书 的 Client
     *
     * @return
     * @throws Exception
     */
    private static CloseableHttpClient buildSSLCloseableHttpClient() throws Exception {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            // 信任所有
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();
        // ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /**
     * 辅助生成Header 请求头
     *
     * @param type
     * @return
     */
    public static Map<String, String> helperHeader(String type) {
        Map<String, String> headMap = new HashMap<>();

        switch (type) {
            case DefaultProperties.HTTP_CONTENT_JSON:
                headMap.put(DefaultProperties.CONTENT_TYPE, DefaultProperties.HTTP_CONTENT_JSON);
                break;
            default:
        }

        return headMap;
    }
}
