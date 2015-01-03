/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.util.CardDetails;
import com.pm.myshop.util.ConversionJson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunil
 */
@RestController
@Controller
public class CardController {

    private CardDetails cardVerification = new CardDetails();

    @RequestMapping(value = "/cardInfo", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> checkCardDetails() {
        try {
            System.out.println("call here" + cardVerification.getCardNumber());
            //CardDetails cardVerification = new CardDetails();
            return new ResponseEntity<>(cardVerification, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    public boolean checkConnection() {
        try {
            // create default HTTP Client
            DefaultHttpClient httpClient = new DefaultHttpClient();
            // Create new getRequest with below mentioned URL
            HttpGet getRequest = new HttpGet("http://localhost:8080/CardValidator/test");
            // Add additional header to getRequest which accepts application/xml data
            getRequest.addHeader("accept", "application/json");
            // Execute your request and catch response
            HttpResponse response = httpClient.execute(getRequest);
            // Check for HTTP response code: 200 = success
            if (response.getStatusLine().getStatusCode() != 200) {
                // throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
                return false;
            }
            // Get-Capture Complete application/xml body response
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            System.out.println("============Output:============");

            // Simply iterate through XML response and show on console.
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                //convertJSONData(output);
                return true;
            }

            httpClient.getConnectionManager().shutdown();

        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String authenticateCard() {

        cardVerification.setCardNumber("1234567891234567");
        cardVerification.setCardType("Visa");
        cardVerification.setTotalBalance(50);

        try {
            Properties props = PropertiesLoaderUtils.loadAllProperties("cardApplication.properties");
            cardVerification.setUsername(props.getProperty("username"));   //Card Application username
            cardVerification.setPassword(props.getProperty("password"));   //Card Application password 
            //PropertyPlaceholderConfigurer props2 = new PropertyPlaceholderConfigurer();
            //props2.setProperties(props);
        } catch (IOException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean checkStatus = checkConnection();
        if (checkStatus == true) {
            return "success";
        } else {
            return "fail";
        }
    }

    public void convertJSONData(String data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ConversionJson cardVerification = mapper.readValue(data, ConversionJson.class);
            System.out.println("card verification " + cardVerification.getUsername() + "::" + cardVerification.getPassword());
        } catch (Exception e) {
        }
    }

    public CardDetails getCardVerification() {
        return cardVerification;
    }

    public void setCardVerification(CardDetails cardVerification) {
        this.cardVerification = cardVerification;
    }

}
