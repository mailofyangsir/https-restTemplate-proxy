package com.test;

import com.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Copyright
 * FileName: SirTest
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/18 23:30
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SirTest {

    @Resource
    @Qualifier("httpsRestTemplate")
    RestTemplate httpsRestTemplate;

    @Resource
    @Qualifier("restTemplate")
    RestTemplate restTemplate;
    @Test
    public void test001(){
        System.out.println(restTemplate);
        System.err.println(httpsRestTemplate);
    }

    @Test
    public void test002(){
        String s = restTemplate.getForObject("https://www.baidu.com", String.class);
        System.out.println(s);
    }

    @Test
    public void test003(){
        String s = httpsRestTemplate.getForObject("https://www.baidu.com", String.class);
        System.out.println(s);
    }
}
