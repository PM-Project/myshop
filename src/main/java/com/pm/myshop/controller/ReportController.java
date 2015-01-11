/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.UserLogin;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pm.myshop.service.impl.ReportServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author sunil
 */
@Controller
@RequestMapping("vendor/download")
public class ReportController {

    @Resource(name = "downloadService")
    private ReportServiceImpl downloadService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/pdf/{fromDate}/{toDate}", method = RequestMethod.GET)
    public void getPDF(@AuthenticationPrincipal UserLogin user,
            @PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate,
            HttpServletRequest request,
            HttpServletResponse response, Model model) throws ClassNotFoundException, JRException {
        System.out.println("Received request to download report as an PDF");
        downloadService.pdfDayWise(request, response, user, fromDate, toDate);
    }

    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public void getPDF(@AuthenticationPrincipal UserLogin user, HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, JRException {
        System.out.println("Received request to download report as an PDF");
        downloadService.downloadPDF(request, response, user);
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
