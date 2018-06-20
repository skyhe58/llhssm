package com.soecode.lyf.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.StringUtils;

import java.io.FileOutputStream;

public class testPdfThird{
    public static void main(String[] args) throws Exception {
        float[] widths = {144, 113, 191};
        FileOutputStream fos = new FileOutputStream("testPdfThird.pdf");

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
        document.setPageSize(PageSize.A4);//设置A4
        document.open();

        PdfPTable table = new PdfPTable(widths);
        table.setTotalWidth(458);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        Object[][] datas = {{"区域", "总销售额(万元)", "总利润(万元)简单的表格"}, {"江苏省" , 9045,  2256}, {"广东省", 3000, 690}};
        for(int i = 0; i < datas.length; i++) {
            for(int j = 0; j < datas[i].length; j++) {
                PdfPCell pdfCell = new PdfPCell(); //表格的单元格
                String content = "a"+String.valueOf(i)+String.valueOf(j);
                Paragraph paragraph = new Paragraph(content, getPdfChineseFont());
                pdfCell.setPhrase(paragraph);
                table.addCell(pdfCell);
            }
        }


        document.add(table); //pdf文档中加入table
        document.close();

    }
    public static Font getPdfChineseFont() throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
                BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
        return fontChinese;
    }
}