package com.pm.myshop.reportServiceImpl;

import com.pm.myshop.daoReport.CustomerReportDao;
import com.pm.myshop.domain.Test;
import com.pm.myshop.reportService.CustomerReportSerivce;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sunil
 */
@Service
//@Transactional
public class CustomerReportServiceImpl implements CustomerReportSerivce {

    @Autowired
    private CustomerReportDao customerReportDao;

 

//    @SuppressWarnings("unchecked")
//    public void downloadXLS(HttpServletResponse response) throws  ClassNotFoundException, JRException {
//        DynamicReport dr = Layouter.buildReportLayout();
//        HashMap params = new HashMap();
//        params.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, sessionFactory.getCurrentSession());
//        JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);
//        JasperPrint jp = JasperFillManager.fillReport(jr, params);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Exporter.exportToXLS(jp, baos);
//        String fileName = "SalesReport.xls";
//        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
//        response.setContentType("application/vnd.ms-excel");
//        response.setContentLength(baos.size());
//        Writer.write(response, baos);
//    }

    @Override
    public List<Test> getAllCustomer() {
//        System.out.println("Inside list");
//        JasperReportBuilder report=DynamicReports.report();
//        report.columns(Columns.column("Id", "id",DataTypes.integerType()),
//        report.columns(Columns.column("Name", "name",DataTypes.stringType())),
//        report.columns(Columns.column("Address", "address",DataTypes.stringType())),
//        report.columns(Columns.column("Salary", "salary",DataTypes.integerType()))
//                .title(Components.text("Customer Report").setHorizontalAlignment(HorizontalAlignment.CENTER))
//		  .pageFooter(Components.pageXofY())
//                 .setDataSource("SELECT id, first_name, last_name, date FROM customers", 
//                                  connection);
//        try {
//            report.show();
//            report.toPdf(new FileOutputStream("c:/report.pdf"));
//        }  catch (DRException e) {
//		e.printStackTrace();
//	}catch (FileNotFoundException e) {
//		e.printStackTrace();
//	}

        return customerReportDao.getAllCustomer();
    }

}
