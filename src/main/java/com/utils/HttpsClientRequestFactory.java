package com.utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Copyright
 * FileName: HttpsClientRequestFactory
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/18 23:06
 * @since 1.0.0
 */
public class HttpsClientRequestFactory extends SimpleClientHttpRequestFactory {


    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {


        try {
            if (!(connection instanceof HttpsURLConnection)) {
                throw new RuntimeException("not is https request");
            }

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;

            TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }
                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());

            httpsURLConnection.setSSLSocketFactory(new MySSLSocketFactory(sslContext.getSocketFactory()));
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            super.prepareConnection(httpsURLConnection,httpMethod);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
