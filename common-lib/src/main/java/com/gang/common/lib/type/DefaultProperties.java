package com.gang.common.lib.type;

/**
 * @Classname HttpRequestProperties
 * @Description TODO
 * @Date 2020/4/28 16:22
 * @Created by zengzg
 */
public final class DefaultProperties {

    private DefaultProperties() {
    }

    public static final String HTTP_GET = "GET";

    public static final String HTTP_POST = "POST";

    public static final String HTTP_PUT = "PUT";

    public static final String HTTP_DELETE = "DELETE";

    public static final String HTTP_PATCH = "PATCH";

    public static final String HTTP_CONTENT_TEXT = "text/xml;charset=utf-8";
    public static final String HTTP_CONTENT_JSON = "application/json;charset=utf-8";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String HTTP_CONTENT_FORM = "application/x-www-form-urlencoded";
    public static final String HTTP_CONTENT_XML = "application/xml";
    public static final String HTTP_CONTENT_TEXT_PLAIN = "text/plain";

    public static final String CHARSET_GBK = "GBK";
    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String DATE_TIMEZONE = "GMT+8";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
