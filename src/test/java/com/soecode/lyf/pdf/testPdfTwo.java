package com.soecode.lyf.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by llh on 2018-04-26
 */
public class testPdfTwo {
    public static void main(String[] args) throws DocumentException, IOException {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("testPdfTwo.pdf"));
        //打开文件
        document.open();

        //中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese);

        //添加内容
        document.add(new Paragraph("ceshi 测试"));

        // 3列的表.
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100); // 宽度填充比例
        table.setSpacingBefore(10f); // 前间距（上）
        table.setSpacingAfter(10f); // 后间距

        List<PdfPRow> listRow = table.getRows();
        //设置列宽
        float[] columnWidths = { 1f, 2f, 3f };
        table.setWidths(columnWidths);

//        //行1
        PdfPCell cells1[]= new PdfPCell[3];
        PdfPRow row1 = new PdfPRow(cells1);
//
//        //单元格
        cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
//        cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
//        cells1[0].setPaddingLeft(20);//左填充20
//        cells1[0].setFixedHeight(10);//设置宽度
//        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
////
        cells1[1] = new PdfPCell(new Paragraph("222"));
        cells1[2] = new PdfPCell(new Paragraph("333"));


        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        String[] headers = {"名字","vegetarian","calories"};
        List<String> headerList = Arrays.asList(headers);
        PdfPRow rowM0 = null;
        for (int i =0;i<4;i++) {
//            PdfPRow rowM0 = null;
//            PdfPCell pdfCell = new PdfPCell(); //表格的单元格
            PdfPCell cells0[]= new PdfPCell[3];
            rowM0 = new PdfPRow(cells0);
            for (int j = 0; j<headerList.size();j++) {

                if(headerList.get(j).equals("名字")){
                    String content =menu.get(i).getName();
                    cells0[j] = new PdfPCell(new Paragraph(content,font));
//                    Paragraph paragraph = new Paragraph(content, font);
//                    pdfCell.setPhrase(paragraph);
//                    table.addCell(pdfCell);
                    System.out.println("--填充内容--"+content);
                } else if(headerList.get(j).equals("vegetarian")){
                    String content =menu.get(i).isVegetarian()+"";

                    cells0[j] = new PdfPCell(new Paragraph(content,font));

                    System.out.println("--填充内容--"+content);
                }else if(headerList.get(j).equals("calories")){
                    String content =menu.get(i).getCalories()+"";

                    cells0[j] = new PdfPCell(new Paragraph(content,font));

                    System.out.println("--填充内容--"+content);
                }
            }
            System.out.println("---"+i);
            listRow.add(rowM0);


        }

//        //行2
//        PdfPCell cells2[]= new PdfPCell[3];
//        PdfPRow row2 = new PdfPRow(cells2);
//        cells2[0] = new PdfPCell(new Paragraph("444"));

//        //行3
//        PdfPCell cells3[]= new PdfPCell[3];
//        PdfPRow row3 = new PdfPRow(cells3);
//        cells3[0] = new PdfPCell(new Paragraph("555"));
//        //把第一行添加到集合
//        listRow.add(row1);
//        listRow.add(row2);
//        listRow.add(rowM0);
//        listRow.add(row3);
        //把表格添加到文件中
        document.add(table);
//        document.add(new Phrase("hello word"));
        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
