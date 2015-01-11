/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpResponse;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunil
 */
@RestController
@Controller
public class CardController {

    @Autowired
    HttpSession session;
    
    
    @RequestMapping(value = "/validatecard", method = RequestMethod.GET)
    public @ResponseBody
    String authenticateCard(@RequestParam("cardNo") String cardNo, @RequestParam("balance") double balance, @RequestParam("cvv") String cvv) throws IOException {

        DefaultHttpClient httpClient = new DefaultHttpClient();

        String encCard = encryptCardNumber(cardNo);

        HttpGet getRequest = new HttpGet("http://localhost:8080/Team4_CardValidator/validate?cardNo=" + encCard + "&balance=" + balance + "&cvv=" + cvv);

        
        getRequest.addHeader(BasicScheme.authenticate(
                new UsernamePasswordCredentials("admin", "admin"),"UTF-8", false));

        HttpResponse response = httpClient.execute(getRequest);

        
        if (response.getStatusLine().getStatusCode() != 200) {
            session.setAttribute("cardvalidation", "fail");
            return "fail";
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output;
        

        while ((output = br.readLine()) != null) {
            session.setAttribute("cardvalidation", output);
            return output;
        }

        httpClient.getConnectionManager().shutdown();

        session.setAttribute("cardvalidation", "fail");
        return "fail";
    }

    public String encryptCardNumber(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
