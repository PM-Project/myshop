/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.reports;

import com.pm.myshop.domain.UserLogin;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pm.myshop.reportService.DownloadService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

/**
 *
 * @author sunil
 */
@Controller
@RequestMapping("vendor/download")
public class VendorReport {

    @Resource(name = "downloadService")
    private DownloadService downloadService;
    
   
    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public void getPDF(@AuthenticationPrincipal UserLogin user,HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, JRException {
        System.out.println("Received request to download report as an PDF");
        downloadService.downloadPDF(request, response,user);
    }
    
    @RequestMapping(value = "/xls", method = RequestMethod.GET)
    public void getXLS(HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, JRException {
        System.out.println("Received request to download report as an XLS");
        downloadService.downloadXLS(request, response);
    }
    
    @RequestMapping(value = "/ht", method = RequestMethod.GET)
    public void getHtml(HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, JRException {
        System.out.println("Received request to download report as an XLS");
        downloadService.downloadHTML(request, response);
    }
}
