/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pm.myshop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author kunda_000
 */

@Controller
public class FilesController
{
    
    @RequestMapping("/pictures/{thumb}/{fileName}")
    @ResponseBody
    public void viewFiles(
            @PathVariable("fileName") String fileName,@PathVariable("thumb") String thumb,
            HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try{
            
            String path = request.getRealPath("/");
            
            response.setContentType("image/jpeg");
            
            InputStream inputStream = new FileInputStream(path+"../../files/"+thumb+"/"+fileName+".jpg");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            response.getWriter().print("File Not Found");
        }
        
    }
   
    
}
