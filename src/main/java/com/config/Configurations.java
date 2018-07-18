package com.config;

import com.utils.HttpsClientRequestFactory;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;


/**
 * Copyright
 * FileName: Configurations
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/18 23:05
 * @since 1.0.0
 */
@SpringBootConfiguration
public class Configurations {

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 80);
        Proxy proxy = new Proxy(Proxy.Type.HTTP,socketAddress);
        //factory.setProxy(proxy);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

    @Bean
    public RestTemplate httpsRestTemplate() {
        HttpsClientRequestFactory factory = new HttpsClientRequestFactory();
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 80);
        Proxy proxy = new Proxy(Proxy.Type.HTTP,socketAddress);
        //factory.setProxy(proxy);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }


    //设置代理
    public void test() {

        HttpHost httpHost = new HttpHost("localhost", 80);
        HttpClientBuilder builder = HttpClientBuilder.create().setProxy(httpHost);
        CloseableHttpClient build = builder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(build);

        RestTemplate restTemplate = new RestTemplate(factory);
    }

}
