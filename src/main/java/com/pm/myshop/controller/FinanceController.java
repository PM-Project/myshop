/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FinanceController {
    @Autowired
    HttpSession session;


    @RequestMapping(value = "/addFinance", method = RequestMethod.GET)
    public @ResponseBody
    String authenticateCard(@RequestParam("cardNo") String cardNo, @RequestParam("price") double price) throws IOException {
        System.out.println("CALL FINANCE APPLICATIOn");
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet("http://localhost:8080/Finance/add?cardNo="+cardNo+"&price="+price);
            
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
}
