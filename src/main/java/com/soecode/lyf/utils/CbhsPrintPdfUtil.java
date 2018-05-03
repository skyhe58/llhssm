//package com.soecode.lyf.utils;
//
//import com.atc.daizhang.beans.jxc.ChCbjzb;
//import com.atc.daizhang.beans.jxc.ChCh;
//import com.atc.daizhang.beans.jxc.ChDjView;
//import com.atc.daizhang.beans.jxc.ChDjmx;
//import com.atc.daizhang.beans.jxc.ChHz;
//import com.atc.daizhang.beans.jxc.ChLlscView;
//import com.atc.daizhang.framework.common.utils.DateUtils;
//import com.atc.daizhang.framework.common.utils.StringUtil;
//import com.atc.daizhang.framework.common.utils.StringUtils;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by llh on 2018-04-28
// */
//
//public class CbhsPrintPdfUtil {
//
//    /**
//     * 出入库单
//     *
//     * @param djList
//     * @param kjnd
//     * @param kjqj
//     * @param filePath
//     * @throws Exception
//     */
//    public static void ckdPdfPrint(List<ChDjView> djList, Integer kjnd, Integer kjqj, String filePath, String qymc) throws Exception {
//        FileOutputStream fos = new FileOutputStream(filePath + File.separator + "出入库单明细.pdf");
//
//        Document document = new Document();
//        //设置A4
//        document.setPageSize(PageSize.A4);
//        Float pageWidth = PageSize.A4.getWidth();
//        PdfWriter writer = PdfWriter.getInstance(document, fos);
//        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
//        document.setMargins(30, 30, 30, 30);
//        document.open();
//
//        //支持中文
//        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
//                BaseFont.NOT_EMBEDDED);
//
//        List<String> headerList = Arrays.asList(new String[]{"品名", "规格型号", "计量单位", "数量", "单价", "金额"});
//
//        PdfPTable tableHeader = new PdfPTable(3);
//        tableHeader.setWidthPercentage(100);
//
//        tableHeader.addCell(createCell("", 20, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, 0));
//        tableHeader.addCell(createCell("出库单", 20, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, 0));
//        tableHeader.addCell(createCell("", 8, bfChinese, null, null, Paragraph.ALIGN_RIGHT, null, 0));
//
//        PdfPTable tableHeaderDate = new PdfPTable(2);
//        tableHeaderDate.setWidthPercentage(100);
//        String rq = DateUtils.format(DateUtils.getLastDayOfMonth(kjnd,kjqj));
//        tableHeaderDate.addCell(createCell("供应商:", 15, bfChinese, null, null, Paragraph.ALIGN_LEFT, null, 0));
//        tableHeaderDate.addCell(createCell("日期  : "+ rq + "\n", 14, bfChinese, null, null, Paragraph.ALIGN_RIGHT, null, 0));
//
//
//        /**设置内容*/
//        for (int i = 0; i < djList.size(); i++) {
//            BigDecimal slHj = BigDecimal.ZERO;
//            BigDecimal jeHj = BigDecimal.ZERO;
//            //fixme
////        for (int i = 0; i < menu.size(); i++) {
//
//            PdfPTable tableContent = new PdfPTable(6);
//            //设置宽度
//            tableContent.setWidthPercentage(100);
//            tableContent.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//            //表头
//            for (int k = 0; k < headerList.size(); k++) {
//                tableContent.addCell(createCell(headerList.get(k), 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            }
//
//            List<ChDjmx> chDjViewList = djList.get(i).getChDjmxList();
//
//            int rows = chDjViewList.size() > 6 ? chDjViewList.size() : 6;
//            for (int j = 0; j < rows; j++) {
//                if (j >= chDjViewList.size()) {
//                    for (int col = 0; col < 6; col++) {
//                        tableContent.addCell(createCell(" ", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//                    }
//                    continue;
//                }
//
//                ChDjmx bean = chDjViewList.get(j);
//                //"品名", "规格型号", "计量单位", "数量", "单价", "金额"
//                String chmc = null == bean.getkChmc() ? "" : bean.getkChmc();
//                String ggxh = null == bean.getkGgxh() ? "" : bean.getkGgxh();
//                String jldw = null == bean.getkJldw() ? "" : bean.getkJldw();
//                BigDecimal sl = null == bean.getkSl() ? BigDecimal.ZERO : bean.getkSl().setScale(0, BigDecimal.ROUND_HALF_UP);
//                String dj = null == bean.getkDj() ? "" : bean.getkDj().toPlainString();
//                BigDecimal je = null == bean.getkJe() ? BigDecimal.ZERO : bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//                slHj = slHj.add(sl);
//                jeHj = jeHj.add(je);
//
//                tableContent.addCell(createCell(chmc + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//                tableContent.addCell(createCell(ggxh + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//                tableContent.addCell(createCell(jldw + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//                tableContent.addCell(createCell(sl + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//                tableContent.addCell(createCell(dj + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//                tableContent.addCell(createCell(je + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            }
//            //合计
//            tableContent.addCell(createCell("合计" + "\n", 14, bfChinese, 5, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(jeHj + "\n", 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            //底边
//            PdfPTable tableFoot = new PdfPTable(3);
//            tableFoot.setWidthPercentage(100);
//            tableFoot.addCell(createCell("单位名称:"+qymc + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_LEFT, null, 0));
//            tableFoot.addCell(createCell("经办人:" + "\n", 8, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//            tableFoot.addCell(createCell("送货人:" + "\n", 8, bfChinese, null, Paragraph.ALIGN_LEFT, null, 0));
//
//            PdfPCell ctableHeader = new PdfPCell();
//            ctableHeader.setBorder(0);
//            ctableHeader.addElement(tableHeader);
//
//            PdfPCell cHeaderDate = new PdfPCell();
//            cHeaderDate.setBorder(0);
//            cHeaderDate.addElement(tableHeaderDate);
//
//            PdfPCell cContent = new PdfPCell();
//            cContent.setBorder(0);
//            cContent.addElement(tableContent);
//
//            PdfPCell cFoot = new PdfPCell();
//            cFoot.setBorder(0);
//            cFoot.addElement(tableFoot);
//
//            PdfPTable table = new PdfPTable(1);
//            table.setWidthPercentage(100);
//
//            table.addCell(ctableHeader);
//            table.addCell(cHeaderDate);
//            table.addCell(cContent);
//            table.addCell(cFoot);
//
//            //设置每页打印两个父表格内容（账单），达到两个就新建一页
//            if (i >= 2 && (i % 2 == 0)) {
//                document.newPage(); //新建一页
//            }
////            table.setSpacingAfter(60f);
//
//            table.setTotalWidth(pageWidth - 60);
//            if (i % 2 == 0) {
//                //-得到层
//                PdfContentByte tContent = writer.getDirectContent();
//                //-写入绝对位置
//                table.writeSelectedRows(0, -1, 0, -1, 30, 782, tContent);
//            } else {
//                //-得到层
//                PdfContentByte tContent = writer.getDirectContent();
//                //-写入绝对位置
//                table.writeSelectedRows(0, 11, 0, -1, 30, 401, tContent);
//            }
//            System.out.println("table--总宽度--" + table.getTotalWidth());
//            System.out.println("Page--总高度--" + document.getPageSize().toString());
//
//            //pdf文档中加入table
////            document.add(table);
//
//        }
//        document.close();
//
//    }
//
//    //fixme 临时
//    private static PdfPCell createCell(String content, int fontsize, BaseFont font, Integer colspan, Integer rowspan, Integer align, BaseColor borderColor, Integer border) {
//        Paragraph pagragraph = new Paragraph(content, new Font(font, fontsize, Font.NORMAL));
//        PdfPCell cell = new PdfPCell(pagragraph);
////        cell.setNoWrap(true);//单元格是否自动换行
//        cell.setFixedHeight(30);
//        // 上中下，Element对象   设置垂直位置
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        if (null != border) {
//            cell.setBorder(border);
//        }
//        if (align != null) {
//            //设置水平位置
//            cell.setHorizontalAlignment(align);
//        }
//        if (colspan != null && colspan > 1) {
//            cell.setColspan(colspan);
//        }
//        if (rowspan != null && rowspan > 1) {
//            cell.setRowspan(rowspan);
//        }
//        if (borderColor != null) {
//            cell.setBorderColor(borderColor);
//        }
////        if (bgColor != null) {
////            cell.setBackgroundColor(bgColor);
////        }
//        return cell;
//    }
//
////    /**
////     * 设置字体
////     * @return
////     * @throws Exception
////     */
////    public static Font getPdfChineseFont() throws Exception {
////        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
////                BaseFont.NOT_EMBEDDED);
////        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
////        return fontChinese;
////    }
//
//    /**
//     * @param content     内容
//     * @param fontsize    字体大小
//     * @param font        字体
//     * @param colspan     列合并单元数量
//     * @param align       排列方式
//     * @param borderColor 边框颜色
//     * @return
//     */
//    private static PdfPCell createCell(String content, int fontsize, BaseFont font, Integer colspan, Integer align, BaseColor borderColor, Integer border) {
//        Paragraph pagragraph = new Paragraph(content, new Font(font, fontsize, Font.NORMAL));
//        PdfPCell cell = new PdfPCell(pagragraph);
////        cell.setNoWrap(true);//单元格是否自动换行
//        cell.setFixedHeight(30);
//        // 上中下，Element对象   设置垂直位置
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        if (null != border) {
//            cell.setBorder(border);
//        }
//        if (align != null) {
//            //设置水平位置
//            cell.setHorizontalAlignment(align);
//        }
//        if (colspan != null && colspan > 1) {
//            cell.setColspan(colspan);
//        }
//        if (borderColor != null) {
//            cell.setBorderColor(borderColor);
//        }
////        if (bgColor != null) {
////            cell.setBackgroundColor(bgColor);
////        }
//        return cell;
//    }
//
//    /**
//     * 销售成本结转表
//     *
//     * @param chCbjzbList
//     * @param kjnd
//     * @param kjqj
//     * @param filePath
//     * @param qymc
//     * @throws Exception
//     */
//    public static void xxcbPdfPrint(List<ChCbjzb> chCbjzbList, Integer kjnd, Integer kjqj, String filePath, String qymc) throws Exception {
//        FileOutputStream fos = new FileOutputStream(filePath + File.separator + "销售成本结转表.pdf");
//
//        Document document = new Document();
//        //设置A4
//        document.setPageSize(PageSize.A4.rotate());
//        PdfWriter writer = PdfWriter.getInstance(document, fos);
//        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
//        document.setMargins(30, 30, 30, 30);
//        document.open();
//
//
//        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
//                BaseFont.NOT_EMBEDDED);
//
//
//        Font fontChinese = new Font(bfChinese, 20, Font.NORMAL);
//        PdfPTable tableHeader = new PdfPTable(1);
//
//        List<String> headerList = Arrays.asList(new String[]{"日期", "存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"});
//
//        PdfPTable table = new PdfPTable(1);
//        table.setWidthPercentage(100);
//
//        //标题
//        String content = qymc + "销售成本结转表";
//        Paragraph pagragraph = new Paragraph(content, fontChinese);
//        PdfPCell cell = new PdfPCell(pagragraph);
//        cell.setBorder(0);
//        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
//        tableHeader.addCell(cell);
//
//
//        PdfPTable tableContent = new PdfPTable(new float[]{1.5f, 4, 1, 1f, 4, 2, 2, 2});
//        //设置宽度
//        tableContent.setWidthPercentage(100);
//        tableContent.setHorizontalAlignment(Element.ALIGN_CENTER);
//        //表头
//        for (int k = 0; k < headerList.size(); k++) {
//            tableContent.addCell(createCell(headerList.get(k), 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//        }
//
//        BigDecimal slHj = BigDecimal.ZERO;
//        BigDecimal jeHj = BigDecimal.ZERO;
//
//        /**设置内容*/
//        for (int i = 0; i < chCbjzbList.size(); i++) {
//
//            ChCbjzb bean = chCbjzbList.get(i);
//            //"日期", "存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"
//            String rq = DateUtils.format(DateUtils.getLastDayOfMonth(kjnd, kjqj));
//            String chmc = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//            String ggxh = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//            String dw = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//            String lb = StringUtils.isEmpty(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//            BigDecimal sl = null == bean.getkSl() ? BigDecimal.ZERO.setScale(6) : bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal dj = null == bean.getkDj() ? BigDecimal.ZERO.setScale(6) : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal je = null == bean.getkJe() ? BigDecimal.ZERO.setScale(2) : bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            slHj = slHj.add(sl);
//            jeHj = jeHj.add(dj);
//
//            tableContent.addCell(createCell(rq + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(chmc + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(ggxh + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(dw + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(lb + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(sl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(dj + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(je + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//        }
//        tableContent.addCell(createCell("合计", 10, bfChinese, 5, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(slHj.toPlainString(), 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("——", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(jeHj.toPlainString(), 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        //当前页能放多少就放多少
//        table.setSplitLate(false);
//        //tableContent.getDefaultCell().setMinimumHeight(30);
//
//        PdfPCell c1 = new PdfPCell();
//        c1.setBorder(0);
//        c1.addElement(tableHeader);
//
//        PdfPCell c2 = new PdfPCell();
//        c2.setBorder(0);
//        c2.addElement(tableContent);
//
//        table.addCell(c1);
//        table.addCell(c2);
//        document.add(table);
//
//        document.close();
//
//    }
//
//    /**
//     * 生产成本分摊表
//     *
//     * @param list
//     * @param kjnd
//     * @param kjqj
//     * @param filePath
//     * @param qymc
//     * @throws Exception
//     */
//    public static void sccbPdfPrint(List<ChCh> list, Integer kjnd, Integer kjqj, String filePath, String qymc) throws Exception {
//        FileOutputStream fos = new FileOutputStream(filePath + File.separator + qymc + "生产成本分摊表.pdf");
//
//        Document document = new Document();
//        //设置A4
//        document.setPageSize(PageSize.A4.rotate());
//        PdfWriter writer = PdfWriter.getInstance(document, fos);
//        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
//        document.setMargins(30, 30, 30, 30);
//        document.open();
//
//
//        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
//                BaseFont.NOT_EMBEDDED);
//        Font fontChinese = new Font(bfChinese, 20, Font.NORMAL);
//
//        PdfPTable table = new PdfPTable(1);
//        table.setWidthPercentage(100);
//
//        PdfPTable tableHeader = new PdfPTable(1);
//        PdfPTable tableHeaderDate = new PdfPTable(1);
//
//        List<String> headerList = Arrays.asList(new String[]{"名称", "规格型号", "单位", "类别", "数量", "销售收入", "成本单价", "成本", "直接材料", "直接人工", "制造费用", "其他费用"});
//
//
//        //标题
//        String content = qymc + "生产成本分摊表";
//
//        tableHeader.addCell(createCell(content + "\n", 18, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//
//        tableHeaderDate.addCell(createCell(kjnd + "年" + kjqj + "月" + "\n", 15, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//
//
//        PdfPTable tableContent = new PdfPTable(12);
//        //设置宽度
//        tableContent.setWidthPercentage(100);
//        //表头
//        for (int k = 0; k < headerList.size(); k++) {
//            tableContent.addCell(createCell(headerList.get(k), 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//        }
//
//        BigDecimal slHj = BigDecimal.ZERO;
//        BigDecimal xssrHj = BigDecimal.ZERO;
//
//        BigDecimal cbHj = BigDecimal.ZERO;
//        BigDecimal zjclHj = BigDecimal.ZERO;
//        BigDecimal zjrgHj = BigDecimal.ZERO;
//        BigDecimal zzfyHj = BigDecimal.ZERO;
//        BigDecimal qtfyHj = BigDecimal.ZERO;
//
//        /**设置内容*/
//        for (int i = 0; i < list.size() - 1; i++) {
//            ChCh bean = list.get(i);
//
//            //"名称", "规格型号", "单位", "类别", "数量", "销售收入","成本单价","成本","直接材料","直接人工","制造费用", "其他费用"
//            String mc = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//            String ggxh = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//            String dw = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//            String lb = StringUtils.isEmpty(bean.getChlbmc()) ? "" : bean.getChlbmc();
//            BigDecimal sl = null == bean.getkBqwgrksl() ? BigDecimal.ZERO.setScale(6) : bean.getkBqwgrksl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal xssr = null == bean.getkBqxssr() ? BigDecimal.ZERO.setScale(2) : bean.getkBqxssr().setScale(2, BigDecimal.ROUND_HALF_UP);
//            BigDecimal cbdj = null == bean.getkDj() ? BigDecimal.ZERO.setScale(6) : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal cb = null == bean.getkBqzcb() ? BigDecimal.ZERO.setScale(2) : bean.getkBqzcb().setScale(2, BigDecimal.ROUND_HALF_UP);
//            BigDecimal zjcl = null == bean.getkBqzjclcb() ? BigDecimal.ZERO.setScale(2) : bean.getkBqzjclcb().setScale(2, BigDecimal.ROUND_HALF_UP);
//            BigDecimal zjrg = null == bean.getkBqzjrgcb() ? BigDecimal.ZERO.setScale(2) : bean.getkBqzjrgcb().setScale(2, BigDecimal.ROUND_HALF_UP);
//            BigDecimal zzfy = null == bean.getkBqzzfycb() ? BigDecimal.ZERO.setScale(2) : bean.getkBqzzfycb().setScale(2, BigDecimal.ROUND_HALF_UP);
//            BigDecimal qtfy = null == bean.getkBqqtcb() ? BigDecimal.ZERO.setScale(2) : bean.getkBqqtcb().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            slHj = slHj.add(sl);
//            xssrHj = xssrHj.add(xssr);
//            cbHj = cbHj.add(cbHj);
//            zjclHj = zjclHj.add(zjcl);
//            zjrgHj = zjrgHj.add(zjcl);
//            zzfyHj = zzfyHj.add(zzfy);
//            qtfyHj = qtfyHj.add(qtfy);
//
//            tableContent.addCell(createCell(mc + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(ggxh + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(dw + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(lb + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(sl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(xssr + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(cbdj + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(cb + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(zjcl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(zjrg + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(zzfy + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(qtfy + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//        }
//        tableContent.addCell(createCell("合计" + "\n", 10, bfChinese, 4, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(slHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(xssrHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("——" + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(cbHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(zjclHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(zjrgHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(zzfyHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(qtfyHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        //当前页能放多少就放多少
//        table.setSplitLate(false);
//        //tableContent.getDefaultCell().setMinimumHeight(30);
//
//        PdfPCell c1 = new PdfPCell();
//        c1.setBorder(0);
//        c1.addElement(tableHeader);
//
//        PdfPCell c3 = new PdfPCell();
//        c3.setBorder(0);
//        c3.addElement(tableHeaderDate);
//
//        PdfPCell c2 = new PdfPCell();
//        c2.setBorder(0);
//        c2.addElement(tableContent);
//
//        table.addCell(c1);
//        table.addCell(c3);
//        table.addCell(c2);
//        document.add(table);
//
//        document.close();
//
//    }
//
//    /**
//     * 领用汇总表
//     *
//     * @param list
//     * @param kjnd
//     * @param kjqj
//     * @param filePath
//     * @param qymc
//     * @throws Exception
//     */
//    public static void lyhzPdfPrint(List<ChLlscView> list, Integer kjnd, Integer kjqj, String filePath, String qymc) throws Exception {
//        FileOutputStream fos = new FileOutputStream(filePath + File.separator + qymc + "领用汇总表.pdf");
//
//        Document document = new Document();
//        //设置A4
//        document.setPageSize(PageSize.A4.rotate());
//        PdfWriter writer = PdfWriter.getInstance(document, fos);
//        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
//        document.setMargins(30, 30, 30, 30);
//        document.open();
//
//
//        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
//                BaseFont.NOT_EMBEDDED);
//
//        PdfPTable table = new PdfPTable(1);
//        table.setWidthPercentage(100);
//
//        PdfPTable tableHeader = new PdfPTable(1);
//        PdfPTable tableHeaderDate = new PdfPTable(1);
//
//        List<String> headerList = Arrays.asList(new String[]{"存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"});
//
//
//        //标题
//        String content = qymc + "领用汇总表";
//
//        tableHeader.addCell(createCell(content + "\n", 18, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//
//
//
//        tableHeaderDate.addCell(createCell(kjnd + "年" + kjqj + "月" + "\n", 15, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//
//
//        PdfPTable tableContent = new PdfPTable(7);
//        //设置宽度
//        tableContent.setWidthPercentage(100);
////        tableContent.setHorizontalAlignment(Element.ALIGN_CENTER);
//        //表头
//        for (int k = 0; k < headerList.size(); k++) {
//            tableContent.addCell(createCell(headerList.get(k), 14, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//        }
//
//        BigDecimal slHj = BigDecimal.ZERO;
//        BigDecimal jeHj = BigDecimal.ZERO;
//
//        /**设置内容*/
//        for (int i = 0; i < list.size(); i++) {
//
//            ChLlscView bean = list.get(i);
//            //"存货名称", "规格型号", "单位", "类别", "数量", "单价","金额"
//            String mc = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//            String ggxh = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//            String dw = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//            String lb = StringUtil.isBlank(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//            BigDecimal sl = null == bean.getkSl() ? BigDecimal.ZERO.setScale(6) : bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal dj = null == bean.getkDj() ? BigDecimal.ZERO.setScale(6) : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal je = null == bean.getkJe() ? BigDecimal.ZERO.setScale(2) : bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            slHj = slHj.add(sl);
//            jeHj = jeHj.add(dj);
//
//            tableContent.addCell(createCell(mc + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(ggxh + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(dw + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(lb + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(sl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(dj + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(je + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//        }
//        tableContent.addCell(createCell("合计", 10, bfChinese, 4, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(slHj.toPlainString(), 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("——", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(jeHj.toPlainString(), 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        //当前页能放多少就放多少
//        table.setSplitLate(false);
//        //tableContent.getDefaultCell().setMinimumHeight(30);
//
//        PdfPCell c1 = new PdfPCell();
//        c1.setBorder(0);
//        c1.addElement(tableHeader);
//
//        PdfPCell c3 = new PdfPCell();
//        c3.setBorder(0);
//        c3.addElement(tableHeaderDate);
//
//        PdfPCell c2 = new PdfPCell();
//        c2.setBorder(0);
//        c2.addElement(tableContent);
//
//        table.addCell(c1);
//        table.addCell(c3);
//        table.addCell(c2);
//        document.add(table);
//
//        document.close();
//
//    }
//
//    /**
//     * 库存汇总表
//     *
//     * @param list
//     * @param kjnd
//     * @param kjqj
//     * @param filePath
//     * @param qymc
//     * @throws Exception
//     */
//    public static void kchzPdfPrint(List<ChHz> list, Integer kjnd, Integer kjqj, String filePath, String qymc) throws Exception {
//        FileOutputStream fos = new FileOutputStream(filePath + File.separator + qymc + "库存汇总表.pdf");
//
//        Document document = new Document();
//        //设置A4
//        document.setPageSize(PageSize.A4.rotate());
//        PdfWriter writer = PdfWriter.getInstance(document, fos);
//        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
//        document.setMargins(30, 30, 30, 30);
//        document.open();
//
//
//        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
//                BaseFont.NOT_EMBEDDED);
//        Font fontChinese = new Font(bfChinese, 20, Font.NORMAL);
//
//        PdfPTable table = new PdfPTable(1);
//        table.setWidthPercentage(100);
//
//        PdfPTable tableHeader = new PdfPTable(1);
//        PdfPTable tableHeaderDate = new PdfPTable(1);
//        //标题
//        String content = qymc + "库存汇总表";
//
//        tableHeader.addCell(createCell(content + "\n", 18, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//
//        tableHeaderDate.addCell(createCell(kjnd + "年" + kjqj + "月" + "\n", 15, bfChinese, null, Paragraph.ALIGN_CENTER, null, 0));
//
//
////        List<String> firstHeaderList = Arrays.asList(new String[]{"存货名称", "规格型号", "单位", "类别", "期初库存", "本期入库"});
////        List<String> secondHeaderList = Arrays.asList(new String[]{"期初数量", "期初单价", "期初金额", "本期数量", "本期金额"});
//
//        PdfPTable tableContent = new PdfPTable(16);
//        //设置宽度
//        tableContent.setWidthPercentage(100);
//
//        tableContent.addCell(createCell("存货名称", 10, bfChinese, null, 2, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("规格型号", 10, bfChinese, null, 2, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("单位", 10, bfChinese, null, 2, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("类别", 10, bfChinese, null, 2, Paragraph.ALIGN_CENTER, null, null));
//
//        tableContent.addCell(createCell("期初库存", 10, bfChinese, 3, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("本期入库", 10, bfChinese, 2, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("暂估入库", 10, bfChinese, 2, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("本期出库", 10, bfChinese, 2, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("期末库存", 10, bfChinese, 3, null, Paragraph.ALIGN_CENTER, null, null));
//
//        tableContent.addCell(createCell("数量", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("单价", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("金额", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        tableContent.addCell(createCell("数量", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("金额", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        tableContent.addCell(createCell("数量", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("金额", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        tableContent.addCell(createCell("数量", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("金额", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        tableContent.addCell(createCell("数量", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("单价", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("金额", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
////        cell = new PdfPCell(new Paragraph("存货名称", fontChinese));
////        cell.setRowspan(2);// 跨2行
////        tableContent.addCell(cell);
////
////        cell = new PdfPCell(new Paragraph("规格型号", fontChinese));
////        cell.setRowspan(2);// 跨2行
////        tableContent.addCell(cell);
////
////        cell = new PdfPCell(new Paragraph("单位", fontChinese));
////        cell.setRowspan(2);// 跨2行
////        tableContent.addCell(cell);
////
////        cell = new PdfPCell(new Paragraph("规格型号", fontChinese));
////        cell.setRowspan(2);// 跨2行
////        tableContent.addCell(cell);
////
////
////
////        cell = new PdfPCell(new Paragraph("期初库存", fontChinese));
////        cell.setColspan(3);// 跨3列
////        tableContent.addCell(cell);
////        cell = new PdfPCell(new Paragraph("本期入库", fontChinese));
////        cell.setColspan(2);// 跨3列
////        tableContent.addCell(cell);
////        cell = new PdfPCell(new Paragraph("暂估入库", fontChinese));
////        cell.setColspan(2);// 跨3列
////        tableContent.addCell(cell);
////        cell = new PdfPCell(new Paragraph("本期出库", fontChinese));
////        cell.setColspan(2);// 跨3列
////        tableContent.addCell(cell);
////        cell = new PdfPCell(new Paragraph("期末库存", fontChinese));
////        cell.setColspan(3);// 跨3列
////        tableContent.addCell(cell);
////
////
////        tableContent.addCell("数量");
////        tableContent.addCell("单价");
////        tableContent.addCell("金额");
////
////        tableContent.addCell("数量");
////        tableContent.addCell("金额");
////
////        tableContent.addCell("数量");
////        tableContent.addCell("金额");
////
////        tableContent.addCell("数量");
////        tableContent.addCell("金额");
////
////        tableContent.addCell("数量");
////        tableContent.addCell("单价");
////        tableContent.addCell("金额");
//
//
////        PdfPTable tableContent = new PdfPTable(10);
////        //设置宽度
////        tableContent.setWidthPercentage(100);
////        tableContent.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//        //表头
//        //第一行表头
////        tableContent.addCell(createCell("存货名称", 14, bfChinese, null,2,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("规格型号", 14, bfChinese, null,2,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("单位", 14, bfChinese, null,2,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("类别", 14, bfChinese, null,2,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("期初库存", 14, bfChinese, 3,null,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("本期入库", 14, bfChinese, 3,null,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("期初数量", 14, bfChinese, null,null,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("期初单价", 14, bfChinese, null,null,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("期初金额", 14, bfChinese, null,null,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("本期数量", 14, bfChinese, null,null,Paragraph.ALIGN_CENTER , null, null));
////        tableContent.addCell(createCell("本期金额", 14, bfChinese, null,null,Paragraph.ALIGN_CENTER , null, null));
////        for (int k = 0; k < headerList.size(); k++) {
////            tableContent.addCell(createCell(headerList.get(k), 14, bfChinese, null,Paragraph.ALIGN_CENTER , null, null));
////        }
//
//        BigDecimal qcrkSlHj = BigDecimal.ZERO;
//        BigDecimal qcrkJeHj = BigDecimal.ZERO;
//
//        BigDecimal bqrkSlHj = BigDecimal.ZERO;
//        BigDecimal bqrkJeHj = BigDecimal.ZERO;
//
//        BigDecimal zgrkSlHj = BigDecimal.ZERO;
//        BigDecimal zgrkJeHj = BigDecimal.ZERO;
//
//        BigDecimal bqckSlHj = BigDecimal.ZERO;
//        BigDecimal bqckJeHj = BigDecimal.ZERO;
//
//        BigDecimal qmkcSlHj = BigDecimal.ZERO;
//        BigDecimal qmkcjeHj = BigDecimal.ZERO;
//
//        /**设置内容*/
//        for (int i = 0; i < list.size(); i++) {
//
//            ChHz bean = list.get(i);
//
//            // "存货名称", "规格型号", "单位", "类别", "期初库存",      "本期入库"，   暂估入库，  本期出库，   期末库存
//            // "存货名称", "规格型号", "单位", "类别", 数量,单价,金额	    数量,金额   	数量	,金额   数量,金额   数量,单价,金额
//            String chmc = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//            String ggxh = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//            String dw = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//            String lb = StringUtil.isBlank(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//            BigDecimal qcrkSl = null == bean.getkQcjcsl() ? BigDecimal.ZERO.setScale(6) : bean.getkQcjcsl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal qcrkDj = null == bean.getkQcjcdj() ? BigDecimal.ZERO.setScale(6) : bean.getkQcjcdj().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal qcrkJe = null == bean.getkQcjcje() ? BigDecimal.ZERO.setScale(2) : bean.getkQcjcje().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            BigDecimal bqrkSl = null == bean.getkBqrksl() ? BigDecimal.ZERO.setScale(6) : bean.getkBqrksl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal bqrkJe = null == bean.getkBqrkje() ? BigDecimal.ZERO.setScale(2) : bean.getkBqrkje().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            BigDecimal zgrkSl = null == bean.getkZgrksl() ? BigDecimal.ZERO.setScale(6) : bean.getkZgrksl().setScale(6);
//            BigDecimal zgrkJe = null == bean.getkZgrkje() ? BigDecimal.ZERO.setScale(2) : bean.getkZgrkje().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            BigDecimal bqckSl = null == bean.getkBqcksl() ? BigDecimal.ZERO.setScale(6) : bean.getkBqcksl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal bqckJe = null == bean.getkBqckje() ? BigDecimal.ZERO.setScale(2) : bean.getkBqckje().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            BigDecimal qmkcSl = null == bean.getkQmjcsl() ? BigDecimal.ZERO.setScale(6) : bean.getkQmjcsl().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal qmkcDj = null == bean.getkQmjcdj() ? BigDecimal.ZERO.setScale(6) : bean.getkQmjcdj().setScale(6, BigDecimal.ROUND_HALF_UP);
//            BigDecimal qmkcje = null == bean.getkQmjcje() ? BigDecimal.ZERO.setScale(2) : bean.getkQmjcje().setScale(2, BigDecimal.ROUND_HALF_UP);
//
//            qcrkSlHj = qcrkSlHj.add(qcrkSl);
//            qcrkJeHj = qcrkJeHj.add(qcrkJe);
//
//            bqrkSlHj = bqrkSlHj.add(bqrkSl);
//            bqrkJeHj = bqrkJeHj.add(bqrkJe);
//
//            zgrkSlHj = zgrkSlHj.add(zgrkSl);
//            zgrkJeHj = zgrkJeHj.add(zgrkJe);
//
//            bqckSlHj = bqckSlHj.add(bqckSl);
//            bqckJeHj = bqckJeHj.add(bqckJe);
//
//            qmkcSlHj = qmkcSlHj.add(qmkcSl);
//            qmkcjeHj = qmkcjeHj.add(qmkcje);
//
//            tableContent.addCell(createCell(chmc + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(ggxh + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(dw + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(lb + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            tableContent.addCell(createCell(qcrkSl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(qcrkDj + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(qcrkJe + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            tableContent.addCell(createCell(bqrkSl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(bqrkJe + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            tableContent.addCell(createCell(zgrkSl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(zgrkJe + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            tableContent.addCell(createCell(bqckSl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(bqckJe + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//            tableContent.addCell(createCell(qmkcSl + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(qmkcDj + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//            tableContent.addCell(createCell(qmkcje + "\n", 10, bfChinese, null, Paragraph.ALIGN_CENTER, null, null));
//
//        }
//
//        tableContent.addCell(createCell("合计" + "\n", 10, bfChinese, 4, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(qcrkSlHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("——" + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(qcrkJeHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(bqrkSlHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(bqrkJeHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(zgrkSlHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(zgrkJeHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(bqckSlHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(bqckJeHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(qmkcSlHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell("——" + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//        tableContent.addCell(createCell(qmkcjeHj + "\n", 10, bfChinese, null, null, Paragraph.ALIGN_CENTER, null, null));
//
//        //当前页能放多少就放多少
//        table.setSplitLate(false);
//        //tableContent.getDefaultCell().setMinimumHeight(30);
//
//        PdfPCell c1 = new PdfPCell();
//        c1.setBorder(0);
//        c1.addElement(tableHeader);
//
//        PdfPCell c3 = new PdfPCell();
//        c3.setBorder(0);
//        c3.addElement(tableHeaderDate);
//
//        PdfPCell c2 = new PdfPCell();
//        c2.setBorder(0);
//        c2.addElement(tableContent);
//
//        table.addCell(c1);
//        table.addCell(c3);
//        table.addCell(c2);
//        document.add(table);
//
//        document.close();
//
//    }
//
//
//}
