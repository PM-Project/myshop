/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.util.CardDetails;
import com.pm.myshop.util.ConversionJson;
import com.pm.myshop.util.SalesBasedDetails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunil
 */
@RestController
@Controller
public class CardController {

    private CardDetails cardVerification = new CardDetails();
    SalesBasedDetails basedDetails = new SalesBasedDetails();

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

    @RequestMapping(value = "/card", method = RequestMethod.POST)
    public String authenticateCard(@RequestParam("cardNo") String cardNo, @RequestParam("balance") String balance, @RequestParam("ccv") String ccv) {
        //
//        String cardNo = "1234567891234567";
        String cardNumber = encryptCardNumber(cardNo);
//        System.out.println("STRING IS>>> " + cardNumber);

        cardVerification.setCardNumber(cardNumber);
        cardVerification.setTotalBalance(Double.parseDouble(balance));
        cardVerification.setCvv(ccv);

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

    @RequestMapping(value = "/fin", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> financeDetails1() {
        try {
            basedDetails.setItem("shoes");
            basedDetails.setPrice(21.0);

            return new ResponseEntity<>(basedDetails, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/finance", method = RequestMethod.GET)
    public String financeDetails() {
        try {
            System.out.println("CALL FINANCE");
            createFinanceConnection();

        } catch (Exception ex) {

        }
        return null;
    }

    public boolean createFinanceConnection() {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet("http://localhost:8080/Finance/tran/fin");
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
            System.out.println("============Output FINANCE:============");

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

    public SalesBasedDetails getBasedDetails() {
        return basedDetails;
    }

    public void setBasedDetails(SalesBasedDetails basedDetails) {
        this.basedDetails = basedDetails;
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
