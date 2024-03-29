package controller.app.restservice;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.CategoryDao;

import dao.viewDao.BoxOfficeSchedulingViewDao;
import entity.AuthCredential;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mi on 12/21/16.
 */
@RestController
@RequestMapping("/api")
public class Test2Controller {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    BoxOfficeSchedulingViewDao boxOfficeSchedulingViewDao;

    @RequestMapping(value="/pdf/download")
    public void generateSamplePdf(Authentication authintication,HttpServletResponse response){
        System.out.println((AuthCredential) authintication.getPrincipal());
        String fileName = "report.pdf";
        Document document = new Document();
        // response.setContentType("application/force-download");
        // response.setHeader("Content-Transfer-Encoding", "binary");
        // response.setHeader("Content-Disposition","attachment; filename=\"" + fileName+"\" ");




        //     response.setContentLength(10);
        //response.setContentLength(-1);

        int counter = 1;
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            Font regular = new Font(Font.FontFamily.HELVETICA, 12);
            Font bold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Phrase p = new Phrase("REPORT TITLE ", bold);


            document.add(p);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(50);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setWidths(new int[]{1, 1});
            table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            table.addCell("Name: " );
            table.addCell("Jhone  ");
            table.addCell("Surname: ");
            table.addCell("Doe");
            document.add(table);
            document.add(new Paragraph("First Line"));
            document.add(new Paragraph("Second Line"));
            document.add( Chunk.NEWLINE );
            document.add(new Paragraph("Third Line"));
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
        }catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.close();
    }
    @RequestMapping(value="/gc")
    public ResponseEntity<?> gc(){
        Runtime rt = Runtime.getRuntime();


        Map<String,Long> gcInfo = new HashMap<>();
        gcInfo.put("Total_JVM_Memory",rt.totalMemory());
        gcInfo.put("Before_GC_Memory",rt.freeMemory());
        rt.gc();
        gcInfo.put("After_GC_Memory",rt.freeMemory());

        return ResponseEntity.status(HttpStatus.OK).body(gcInfo);
    }
    @RequestMapping(value="/schedule_view")
    public ResponseEntity<?> scheduleView(){
        return ResponseEntity.status(HttpStatus.OK).body(boxOfficeSchedulingViewDao.getByScheduleId(18 ));
    }
    @RequestMapping(value="/app/auth/sync")
    public synchronized ResponseEntity<?> sync(Authentication authintication){
        System.out.println((AuthCredential) authintication.getPrincipal());
        System.out.println("Waiting for service "+Thread.currentThread().getName());

            System.out.println("Got Lock for service"+Thread.currentThread().getName());
            try {
                System.out.println("Sleeping........ "+Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("About to get out........"+Thread.currentThread().getName());

        System.out.println("Out now "+Thread.currentThread().getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
