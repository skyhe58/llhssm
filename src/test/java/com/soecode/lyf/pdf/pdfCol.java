package com.soecode.lyf.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by llh on 2018-04-28
 */
public class pdfCol {
    public static void main(String[] args) throws Exception {
        insertTable();
    }

    public static void insertTable() throws Exception {

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        FileOutputStream fos = new FileOutputStream("pdfCol合并单元格.pdf");
        // 使用PDFWriter进行写文件操作
        PdfWriter.getInstance(document, fos);
        document.open();

        // 中文字体(现在高版本的不支持中文包)
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);// 中文、12、正常

        int colNumber = 6;

        // PdfPTable[PdfPTable[PdfPCell[Paragraph]]]
        // 创建有6列的表格
        PdfPTable datatable = new PdfPTable(colNumber);
        // 定义表格的宽度
        int[] cellsWidth = {1, 1, 1, 1, 1, 1};
        datatable.setWidths(cellsWidth);// 单元格宽度
        // datatable.setTotalWidth(300f);//表格的总宽度
        datatable.setWidthPercentage(100);// 表格的宽度百分比

        datatable.getDefaultCell().setPadding(2);// 单元格的间隔
        datatable.getDefaultCell().setBorderWidth(2);// 边框宽度
        // 设置表格的底色
        datatable.getDefaultCell().setBackgroundColor(BaseColor.GREEN);
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

//         PdfPTable[PdfPCell[Paragraph]]
        String[] tableHeader = new String[]{"a","b","c","d","e","f"};
        String[] tableCont = new String[]{"1","2","3","4","5","6"};
        // 添加表头元素
        for (int i = 0; i < colNumber; i++) {
            datatable.addCell(new Paragraph(tableHeader[i], fontChinese));
        }
        // 添加表格的内容
        for (int i = 0; i < colNumber; i++) {
            datatable.addCell(new Paragraph(tableCont[i], fontChinese));
        }

        // 空白表格
        for (int i = 0; i < colNumber; i++) {
            PdfPCell cell = new PdfPCell(new Paragraph(""));
            cell.setFixedHeight(10);// 单元格高度
            datatable.addCell(cell);
        }
        datatable.setSpacingAfter(40f);// 设置表格下面空白行
        document.add(datatable);// 把表格加入文档

        // 跨行跨列表格
        PdfPTable table = new PdfPTable(5); // 3列表格
        PdfPCell cell; // 单元格
//        cell = new PdfPCell(new Phrase("跨5列", fontChinese));
//        cell.setColspan(5);// 跨3列
//        table.addCell(cell);

        cell = new PdfPCell(new Phrase("跨2行", fontChinese));
        cell.setRowspan(2);// 跨2行
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("a跨2列", fontChinese));
        cell.setColspan(2);// 跨3列
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("b跨2列", fontChinese));
        cell.setColspan(2);// 跨3列
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");

        document.add(table);

//        // 表格的嵌套
        PdfPTable tableFather = new PdfPTable(4);
        tableFather.setSpacingBefore(20f);// 设置表格上面空白行
        // 1行2列
        PdfPTable nested1 = new PdfPTable(2);
        nested1.addCell("1.1");
        nested1.addCell("1.2");
        // 2行1列
        PdfPTable nested2 = new PdfPTable(1);
        nested2.addCell("2.1");
        nested2.addCell("2.2");

        // 将表格插入到指定位置
        for (int k = 0; k < 12; ++k) {
            if (k == 1) {
                tableFather.addCell(nested1);
            } else if (k == 6) {
                tableFather.addCell(nested2);
            } else {
                tableFather.addCell("cell " + k);
            }
        }
        document.add(tableFather);

        document.close();
    }
}