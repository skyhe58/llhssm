package com.soecode.lyf.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Itext 的基本使用
 * 内容注释
 *
 * Document ： PDF对象
 * Rectangle ：页面对象
 * Table、PdfPTable ： 表格对象
 * Phrase短语对象 : a List of Chunks with leading
 * Paragraph : a Phrase with extra properties and a newline ，新段落另起一行
 * PdfPCell ：单元格对象
 *
 * Created by llh on 2018-04-26
 */
public class testPdfFour {

    public static void main(String[] args) throws Exception {
        List<Dish> menu = Arrays.asList(
                new Dish("porkrrrrrrrrrrrrrrr", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        //        float[] widths = {144, 113, 191};
        //写出文件的位置
        FileOutputStream fos = new FileOutputStream("testPdfFour--.pdf");

        //1-创建文本对象 Document
        Document document = new Document();
//        document = new Document(PageSize.A4.rotate());// 横向打印

        //为pdf添加属性信息 （添加的属性测试没找到在哪体现，有知道的可告知 谢谢）
//        document.addAuthor("作者llh");
//        document.addTitle("标题llh");
//        document.addSubject("主题llh");
//        document.addKeywords("关键字llh");

        //设置纸张（A4)
        document.setPageSize(PageSize.A4);
        //设置左，右，上，下边距
        document.setMargins(30, 30, 50, 30);

        // 2-初始化 pdf输出对象 PdfWriter
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        //设置PDF文档外观，可不设置（未测出效果）
        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);  //PdfWriter.PageModeUseThumbs – 缩略图可见

        Float pageHeight = PageSize.A4.getHeight();
        Float pageWidth = PageSize.A4.getWidth();
        System.out.println("page高度=" + pageHeight + "，  宽度" + pageWidth + "  ---document--" + document.getPageSize());

        // 3-打开 Document
        document.open();

        //BaseFont-确认支持中文
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

        //设置字体
        Font fontChinese = new Font(bfChinese, 20, Font.NORMAL);

        PdfPTable table1 = new PdfPTable(1);

        String content = "出库单";
        Paragraph pagragraph = new Paragraph(content, fontChinese);  //Paragraph : a Phrase with extra properties and a newline
       /* //设置段落属性 （未测试）
        pagragraph.setAlignment(Element.ALIGN_JUSTIFIED);// 对齐方式

        pagragraph.setIndentationLeft(12);// 左缩进
        pagragraph.setIndentationRight(12);// 右缩进
        pagragraph.setFirstLineIndent(24);// 首行缩进

        pagragraph.setLeading(20f);// 行间距
        pagragraph.setSpacingBefore(5f);// 设置上面空白
        pagragraph.setSpacingAfter(10f);// 设置段落下空白*/

        //        PdfPCell cell = new PdfPCell();
        //        Paragraph p = new Paragraph("table title");
        //        p.setAlignment(1);
        //        p.setSpacingBefore(15f);
        //        cell.addElement(p);
        //        cell.setBorder(0);

        PdfPCell cell = new PdfPCell(pagragraph);
        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER); //设置水平位置
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置垂直位置
        //        table1.setTotalWidth(458);
        table1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table1.addCell(cell);
        // table1.addCell(createCell("table title sample",14,bfChinese,null,Paragraph.ALIGN_RIGHT,null)); //封装方法

        List<String> headerList = Arrays.asList(new String[] { "名字", "vegetarian", "calories" }); //打印内容中表格的表头

        for (int i = 0; i < menu.size(); i++) {
            PdfPTable tableHeader = new PdfPTable(3);
            //设置宽度
            tableHeader.setWidthPercentage(100);
            tableHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPTable tableContent = new PdfPTable(new float[] { 144, 113, 191 });
            //        table2.setTotalWidth(458);
            tableContent.setWidthPercentage(100);
            tableContent.setHorizontalAlignment(Element.ALIGN_CENTER);
            //表头
            for (int k = 0; k < headerList.size(); k++) {
                tableContent.addCell(createCell(headerList.get(k) + " " + i, 14, bfChinese, null, null, null));
            }

            //内容不满6行，填充空格到6行
            for (int j = 0; j < 6; j++) {
                if (j > 0) {
                    for (int col = 0; col < 3; col++) {
                        tableContent.addCell(createCell(" ", 14, bfChinese, null, null, null));
                    }
                    continue;
                }
                tableContent.addCell(createCell(menu.get(i).getName(), 14, bfChinese, null, null, null));
                tableContent.addCell(createCell(menu.get(i).isVegetarian() + "", 14, bfChinese, null, null, null));
                tableContent.addCell(createCell(menu.get(i).getCalories() + "", 14, bfChinese, null, null, null));

            }

            //开始测试时demo内容
            //        for(int i = 0; i < menu.size(); i++) {
            //            for(int j = 0; j < headerList.size(); j++) {
            //                PdfPCell pdfCell = new PdfPCell(); //表格的单元格
            //                if(headerList.get(j).equals("名字")){
            ////                    String content = menu.get(i).getName();
            ////                    Paragraph paragraph = new Paragraph(content, getPdfChineseFont());
            ////                    pdfCell.setPhrase(paragraph);
            //                    table2.addCell(createCell(menu.get(i).getName(),14,bfChinese,null,null,null));
            //                }else if(headerList.get(j).equals("vegetarian")){
            ////                    String content = menu.get(i).isVegetarian()+"";
            ////                    Paragraph paragraph = new Paragraph(content, getPdfChineseFont());
            ////                    pdfCell.setPhrase(paragraph);
            //                    table2.addCell(createCell(menu.get(i).isVegetarian()+"",14,bfChinese,null,null,null));
            //                }else if(headerList.get(j).equals("calories")){
            ////                    String content = menu.get(i).getCalories()+"";
            ////                    Paragraph paragraph = new Paragraph(content, getPdfChineseFont());
            ////                    pdfCell.setPhrase(paragraph);
            //                    table2.addCell(createCell(menu.get(i).getCalories()+"",14,bfChinese,null,null,null));
            //                }
            //
            //            }

            PdfPTable table = new PdfPTable(1);

            PdfPCell c1 = new PdfPCell();
            c1.setBorder(0);
            c1.addElement(table1);

            PdfPCell c3 = new PdfPCell();
            c3.setBorder(0);
            c3.addElement(tableHeader);

            PdfPCell c2 = new PdfPCell();
            c2.setBorder(0);
            c2.addElement(tableContent);

            //将子表格按顺序全部添加到父表格中
            table.addCell(c1);
            table.addCell(c3);
            table.addCell(c2);

            //设置每页打印两个父表格内容（账单），达到两个就新建一页
            if (i >= 2 && (i % 2 == 0)) {
                document.newPage(); //新建一页
            }
            table.setSpacingAfter(60f);//设置表格下面空白

            //添加水印
            PdfContentByte under = writer.getDirectContentUnder();
            //            PdfContentByte under = writer.getDirectContent();

            //打开设置水印的文本
            under.beginText();
            //BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
            under.setFontAndSize(bfChinese, 18);
            //             under.setTextMatrix(30, 30);
            under.showTextAligned(Element.ALIGN_LEFT, "水印.......summer........", 230, 660, 45);

            under.showTextAligned(Element.ALIGN_LEFT, "水印.......summer........", 230, 240, 45);

            //设置透明度 （暂未测出效果）
            //            PdfGState gstate = new PdfGState();
            //            gstate.setStrokeOpacity(0.1f);
            //            under.setGState(gstate);

            //关闭设置水印的文本
            under.endText();

            //写入绝对位置时不需要添加document.add(table)
            table.setTotalWidth(pageWidth - 60);
            if (i % 2 == 0) {
                PdfContentByte tContent = writer.getDirectContent(); //-得到层
                table.writeSelectedRows(0, -1, 0, -1, 30, 782, tContent); //-写入绝对位置
            } else {
                PdfContentByte tContent = writer.getDirectContent(); //-得到层
                table.writeSelectedRows(0, 11, 0, -1, 30, 351, tContent); //-写入绝对位置
            }
            System.out.println("table--总宽度--" + table.getTotalWidth());

            /**往 Document 添加内容 ， 写入绝对位置时不需要添加document.add(table)，不然会重复打印 */
            //  document.add(table); //pdf文档中加入table2

        }

        // 关闭 Document
        document.close();

    }

    //    /**
    //     * 设置字体
    //     * @return
    //     * @throws Exception
    //     */
    //    public static Font getPdfChineseFont() throws Exception {
    //        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
    //                BaseFont.NOT_EMBEDDED);
    //        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
    //        return fontChinese;
    //    }

    /**
     *
     * @param content 内容
     * @param fontsize 字体大小
     * @param font 字体
     * @param colspan 列合并单元数量
     * @param align 排列方式
     * @param borderColor 边框颜色
     * @return
     */
    private static PdfPCell createCell(String content, int fontsize, BaseFont font, Integer colspan, Integer align, BaseColor borderColor) {
        Paragraph pagragraph = new Paragraph(content, new Font(font, fontsize));
        PdfPCell cell = new PdfPCell(pagragraph);
        cell.setFixedHeight(25);
        cell.setNoWrap(true);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 上中下，Element对象
        if (align != null)
            cell.setHorizontalAlignment(align);
        if (colspan != null && colspan > 1)
            cell.setColspan(colspan);
        if (borderColor != null)
            cell.setBorderColor(borderColor);
        //        if (bgColor != null)
        //            cell.setBackgroundColor(bgColor);
        return cell;
    }

}
