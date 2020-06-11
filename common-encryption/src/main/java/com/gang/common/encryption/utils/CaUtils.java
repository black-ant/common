package com.gang.common.encryption.utils;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/**
 * @Classname CaUtils
 * @Description CA 证书工具类
 * @Date 2020/6/10 23:19
 * @Created by zengzg
 */
public class CaUtils {

    public static final String KEY_STORE = "JKS";

    public static final String X509 = "X.509";

    public static final String SunX509 = "SunX509";

    public static final String SSL = "SSL";

    /**
     * 获取KeyStore
     *
     * @param keyStorePath
     * @param password
     * @return KeyStore
     * @throws Exception
     */
    public static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
        FileInputStream fis = new FileInputStream(keyStorePath);
        KeyStore ks = KeyStore.getInstance(KEY_STORE);
        ks.load(fis, password.toCharArray());
        fis.close();
        return ks;
    }

    /**
     * 获取Certificate
     *
     * @param certificatePath
     * @return Certificate
     * @throws Exception
     */
    public static Certificate getCertificate(String certificatePath) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance(X509);
        FileInputStream fis = new FileInputStream(certificatePath);
        Certificate certificate = certificateFactory.generateCertificate(fis);
        fis.close();
        return certificate;
    }

    /**
     * 获取私钥
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return PrivateKey
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String keyStorePath, String alias, String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password.toCharArray());
        return privateKey;
    }

    /**
     * 获取公钥
     *
     * @param certificatePath
     * @return PublicKey
     * @throws Exception
     */
    public static PublicKey getPublicKey(String certificatePath) throws Exception {
        Certificate certificate = getCertificate(certificatePath);
        PublicKey publicKey = certificate.getPublicKey();
        return publicKey;
    }

    /**
     * 获取公钥
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return PublicKey
     * @throws Exception
     */
    public static PublicKey getPublicKey(String keyStorePath, String alias, String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        Certificate cert = ks.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();
        return publicKey;
    }

    //    /**
    //     * Key转换为Pem格式
    //     *
    //     * @param Key
    //     * @return 字符串(Pem格式)
    //     * @throws Exception
    //     */
    //    public static String changeKeyToPem(Key key) throws Exception {
    //        PEMWriter pemWriter;
    //        try {
    //            Writer writer = new StringWriter();
    //            pemWriter = new PEMWriter(writer);
    //            pemWriter.writeObject(key);
    //            pemWriter.flush();
    //            pemWriter.close();
    //            return writer.toString();
    //        } finally {
    //            pemWriter = null;
    //        }
    //    }

    /**
     * 获得SSLSocketFactory
     *
     * @param password
     * @param keyStorePath
     * @param trustKeyStorePath
     * @return SSLSocketFactory
     * @throws Exception
     */
    public static SSLSocketFactory getSSLSocketFactory(String password, String keyStorePath,
                                                       String trustKeyStorePath) throws Exception {
        // 初始化密钥库
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(SunX509);
        KeyStore keyStore = getKeyStore(keyStorePath, password);
        keyManagerFactory.init(keyStore, password.toCharArray());
        // 初始化信任库
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(SunX509);
        KeyStore trustkeyStore = getKeyStore(trustKeyStorePath, password);
        trustManagerFactory.init(trustkeyStore);
        // 初始化SSL上下文
        SSLContext ctx = SSLContext.getInstance(SSL);
        ctx.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory sf = ctx.getSocketFactory();
        return sf;
    }

    /**
     * 获取密钥对
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return KeyPair
     * @throws Exception
     */
    public static KeyPair getKeyPair(String keyStorePath, String alias, String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        Key key = ks.getKey(alias, password.toCharArray());
        if (key instanceof PrivateKey) {
            Certificate cert = ks.getCertificate(alias);
            PublicKey publicKey = cert.getPublicKey();
            return new KeyPair(publicKey, (PrivateKey) key);
        } else {
            return null;
        }
    }

}
