package com.test;

import com.App;
import com.bean.TokenReqInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    
    @Test
    public void test004() throws Exception{
        this.getPartnerToken();
       // System.in.read();
        Thread.sleep(5000);
    }

    private String getPartnerToken() throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append("https://iam.cn-north-1.myhuaweicloud.com/v3/auth/tokens");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        TokenReqInfo tr = this.createPartnerTokenReqInfo();
        ObjectMapper om = new ObjectMapper();
        String requestData = om.writeValueAsString(tr);
//        System.out.println(requestData);
        HttpEntity<String> requestEntity = new HttpEntity(requestData, headers);
        ResponseEntity<String> respEntity = this.httpsRestTemplate.postForEntity(buf.toString(), requestEntity, String.class, new Object[0]);
        System.out.println(requestEntity.getBody());
        System.out.println(requestEntity);
        String token = (String)respEntity.getHeaders().get("X-Subject-Token").get(0);
        System.out.println(token);
        return token;
    }

    private TokenReqInfo createPartnerTokenReqInfo() {
        String domainName = "wfmc10";
        String name = "wfmc10";
        String password = "Huawei12#$";
        TokenReqInfo tokenReq = new TokenReqInfo();
        tokenReq.getAuth().getScope().getDomain().setName(domainName);
        tokenReq.getAuth().getIdentity().getMethods().add("password");
        tokenReq.getAuth().getIdentity().getPassword().getUser().setName(name);
        tokenReq.getAuth().getIdentity().getPassword().getUser().setPassword(password);
        tokenReq.getAuth().getIdentity().getPassword().getUser().getDomain().setName(domainName);
        return tokenReq;
    }
}
