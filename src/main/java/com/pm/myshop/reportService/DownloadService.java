/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.reportService;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.myshop.daoReport.CustomerReportDao;
import com.pm.myshop.domain.Test;
import com.pm.myshop.util.ReportColumn;
import com.pm.myshop.util.Templates;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.export;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sunil
 */
@Service("downloadService")
@Transactional
public class DownloadService {

    @Autowired
    private CustomerReportDao customerReportDao;

    @SuppressWarnings("unchecked")
    public void downloadPDF(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, JRException {
        String path = request.getSession().getServletContext().getRealPath(File.separator);
        String filePath = path + "report.pdf";
        JasperPdfExporterBuilder pdfExporter = export.pdfExporter(filePath);
        try {
            JasperReportBuilder report = report();
            for (ReportColumn column : createColumns()) {
                report.addColumn(col.column(column.getTitle(), column.getField(), (DRIDataType) type.detectType(column.getDataType())));
            }
            report
                    .setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("Customer Report"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .toPdf(pdfExporter);

        } catch (DRException e) {
            e.printStackTrace();
        }

        File pdfFile = new File(filePath);
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + "report.pdf");
        response.setContentLength((int) pdfFile.length());

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(pdfFile);
            OutputStream responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
        } catch (Exception ex) {
            Logger.getLogger(DownloadService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    public void downloadXLS(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, JRException {
        String path = request.getSession().getServletContext().getRealPath(File.separator);
        String filePath = path + "report.xls";
        JasperXlsExporterBuilder xlsExporter = export.xlsExporter(filePath)
                .setDetectCellType(true)
                .setIgnorePageMargins(true)
                .setWhitePageBackground(false)
                .setRemoveEmptySpaceBetweenColumns(true);
        try {
            JasperReportBuilder report = report();
            for (ReportColumn column : createColumns()) {
                report.addColumn(col.column(column.getTitle(), column.getField(), (DRIDataType) type.detectType(column.getDataType())));
            }
            report
                    .setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("Customer Report"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .toXls(xlsExporter);

        } catch (DRException e) {
            e.printStackTrace();
        }

        File xlsFile = new File(filePath);
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment; filename=" + "report.xls");
        response.setContentLength((int) xlsFile.length());

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(xlsFile);
            OutputStream responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
        } catch (Exception ex) {
            Logger.getLogger(DownloadService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    public void downloadHTML(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, JRException {
        String path = request.getSession().getServletContext().getRealPath(File.separator);
        String filePath = path + "report.html";
        //String imagePath=request.getSession().getServletContext().getRealPath("resources/images/myshop-logo.png");
        JasperHtmlExporterBuilder htmlExporter = export.htmlExporter(filePath);
                //.setImagesDirName("images/logo.png").setOutputImagesToDir(false);
        try {
            JasperReportBuilder report = report();
            for (ReportColumn column : createColumns()) {
                report.addColumn(col.column(column.getTitle(), column.getField(), (DRIDataType) type.detectType(column.getDataType())));
            }
            
            
            report
                     .setTemplate(Templates.reportTemplate)
                   // .title(Templates.createTitleComponent("HtmlReport"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .toHtml(htmlExporter);

        } catch (DRException e) {
            e.printStackTrace();
        }

        File xlsFile = new File(filePath);
        response.setContentType("text/html");
        response.addHeader("Content-Disposition", "attachment; filename=" + "report.html");
        response.setContentLength((int) xlsFile.length());

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(xlsFile);
            OutputStream responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
        } catch (Exception ex) {
            Logger.getLogger(DownloadService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Test> getAllCustomer() {
        return customerReportDao.getAllCustomer();
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("sn", "name", "address","startDate","endDate");
        int counter = 1;
        for (int i = 0; i < getAllCustomer().size(); i++) {
            dataSource.add(String.valueOf(counter++), getAllCustomer().get(i).getName(), getAllCustomer().get(i).getAddress(),getAllCustomer().get(i).getToDate(),getAllCustomer().get(i).getToDate());
        }

        return dataSource;
    }

    private List<ReportColumn> createColumns() {
        List<ReportColumn> columns = new ArrayList<ReportColumn>();
        columns.add(new ReportColumn("S.No", "sn", "string"));
        columns.add(new ReportColumn("Name", "name", "string"));
        columns.add(new ReportColumn("Address", "address", "string"));
        columns.add(new ReportColumn("StartDate", "startDate", "date"));
        columns.add(new ReportColumn("EndDate", "endDate", "date"));
        return columns;
    }

}
