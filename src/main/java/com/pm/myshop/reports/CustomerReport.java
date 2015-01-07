/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.reports;

import com.pm.myshop.reportService.CustomerReportSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sunil
 */
@Controller
//@RequestMapping(value = "/customer/reports")
public class CustomerReport {

    @Autowired
    private CustomerReportSerivce customerReportSerivce;
    
    
    //@RequestMapping(value = "/reports", params = {"format"}, method = RequestMethod.GET)
    //public String report(@RequestParam("format") String format, @RequestParam(value = "status", required = false, defaultValue = "true") Boolean status, ModelMap modelMap) {
     @RequestMapping(value = "/reports", method = RequestMethod.GET)  
    public String report(ModelMap modelMap) {
    
       
        System.out.println("Report panel>>>>>>>>>>");
         boolean status=true;
         String format="pdf";
        modelMap.addAttribute("datasource", customerReportSerivce.getAllCustomer());
        modelMap.addAttribute("show", status);
 
        if (format.equalsIgnoreCase("pdf")) {
            return "pdfReport";
        } else if (format.equalsIgnoreCase("xls")) {
            return "xlsReport";
        } else if (format.equalsIgnoreCase("csv")) {
            return "csvReport";
        } else {
            return "htmlReport";
        }
    }
    
    

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String showCustomerReport() {
        System.out.println("Download page reports");
        //customerReportSerivce.getAllCustomer();
        return "downloadpage";
    }

    @RequestMapping(value = "/download/xls", method = RequestMethod.GET)
    public ModelAndView doCustomerReportXLS(ModelAndView modelAndView) {
        
        System.out.println("CALL HERE");
        customerReportSerivce.getAllCustomer();
//        Map<String,Object> parameterMap = new HashMap<String,Object>();
//        parameterMap.put("datasource", myshop);
//         modelAndView = new ModelAndView("xlsReport", parameterMap);
        
        
        modelAndView = new ModelAndView();
        return modelAndView;
    }

    
}    
