package com.soecode.lyf.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import sun.applet.Main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by llh on 2018-04-26
 */
public class testPdf_Feiye {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
////Step 1—Create a Document.
//        Document document = new Document();
////Step 2—Get a PdfWriter instance.
//        PdfWriter.getInstance(document, new FileOutputStream("a.pdf"));
////Step 3—Open the Document.
//        document.open();
////Step 4—Add content.
//        document.add(new Paragraph("Hello World"));
////Step 5—Close the Document.
//        document.close();

        //页面大小
        Rectangle rect = new Rectangle(PageSize.A4.rotate());
//页面背景色
//        rect.setBackgroundColor(BaseColor.ORANGE);

        Document doc = new Document(rect);

        PdfWriter writer = PdfWriter.getInstance(doc,  new FileOutputStream("testPdf_Feiye.pdf"));
        doc.open();
        doc.add(new Paragraph("test Pdf内容 test"));//FIXME  汉字不显示
//PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

//文档属性
        doc.addTitle("test 标题");
        doc.addAuthor("Author@llh");
        doc.addSubject("Subject@iText sample");
        doc.addKeywords("Keywords@iText");
        doc.addCreator("Creator@iText");

//页边空白
//        doc.setMargins(10, 20, 30, 40);
        doc.setMargins(50, 50, 50, 50);  //FIXME 第一页没起作用

        doc.add(new Paragraph("1"));
        doc.add(new Paragraph("2"));
//        doc.add(new Paragraph(Document.getVersion()));

        //第2页
        doc.newPage();
//        writer.setPageEmpty(false);
        doc.add(new Paragraph("3"));

        //第3页
        doc.newPage();
        doc.add(new Paragraph("New page"));

        //第4页
        doc.newPage();
        List list = new ArrayList();
//        for (int i = 0; i < 10; i++) {
//            ListItem item = new ListItem(String.format("%s: %d movies",
//                    "country" + (i + 1), (i + 1) * 100), new Font(
//                    Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE));
//            List movielist = new ArrayList();
////            movielist.setLowercase(List.LOWERCASE);
//            for (int j = 0; j < 5; j++) {
//                ListItem movieitem = new ListItem("Title" + (j + 1));
//                List directorlist = new ArrayList();
//                for (int k = 0; k < 3; k++) {
//                    directorlist.add(String.format("%s, %s", "Name1" + (k + 1),
//                            "Name2" + (k + 1)));
//                }
//                movieitem.add((Element) directorlist);
//                movielist.add(movieitem);
//            }
//            item.add((Element) movielist);
//            list.add(item);
//        }
//        doc.add((Element) list);

        doc.close();
    }
}
