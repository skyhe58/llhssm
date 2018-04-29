package com.soecode.lyf.utils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.atc.daizhang.beans.slhs.GlKmyeSlhsMxzVo;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
///**
// * 数量核算明细账打印PDF工具类
// * @author rqx
// * @创建时间 2017-03-21
// * @修改人
// * @修改时间
// *
// */
public class SlhsKmyeMxzPDFUtil {
//
//    private static Logger logger = LoggerFactory.getLogger(SlhsKmyeMxzPDFUtil.class);
//
//    /**
//     * 批量打印凭证页面信息
//     * @param slhsList 数量核算科目余额数据
//     * @param path 文件路径
//     * @param folder 文件夹名称
//     * @param company 公司名称
//     * @param context 明细账账期信息
//     * @param slhsXsd 数量核算保留小数点
//     * @param kmyeXsd 科目余额保留小数点
//     * @throws Exception
//     */
//    public static void exportSlhsKmyePDF(List<GlKmyeSlhsMxzVo> slhsList, String path, String folder, String company, String context, Integer slhsXsd,
//            Integer kmyeXsd) throws Exception {
//        logger.info("BEGIN CREATING SlhsExcel Excel TYPE 1.");
//        creatSlhsKmyePDF(slhsList, path, folder, company, context, slhsXsd, kmyeXsd);
//        logger.info("SlhsExcel TYPE 1 Excel HAS BEEN CREATED.");
//    }
//
//    //创建数量核算科目余额明细账PDF方法
//    private static void creatSlhsKmyePDF(List<GlKmyeSlhsMxzVo> slhsList, String path, String folder, String company, String context, Integer slhsXsd,
//            Integer kmyeXsd) {
//        try {
//
//            String filPath = path + File.separator + folder + "_SlhsMXZ.pdf"; //文件路径
//            //创建一个PDF文件。默认为A4纸张
//            Document doc = new Document(PageSize.A4.rotate());
//            initPDF(doc, filPath, company);
//            creatKmyeMxzPDF(doc, slhsList, company, context, slhsXsd, kmyeXsd);
//            doc.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 初始化PDF
//     * @param doc
//     * @param path
//     * @throws DocumentException
//     * @throws FileNotFoundException
//     */
//    private static void initPDF(Document doc, String path, String company) throws FileNotFoundException, DocumentException {
//        doc.setMargins(30, 30, 0, 0);
//        PdfWriter.getInstance(doc, new FileOutputStream(path));
//        doc.open();
//        doc.addTitle(company + "数量金额明细账");
//        doc.addAuthor("yzf");
//        doc.addSubject("数量金额明细账");
//    }
//
//    private static void creatKmyeMxzPDF(Document document, List<GlKmyeSlhsMxzVo> slhsList, String company, String context, Integer slhsXsd,
//            Integer kmyeXsd) throws DocumentException {
//        //表格列宽度
//        float[] widths = { 1.3f, 1f, 1.5f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 0.5f, 1.1f, 1.1f, 1.1f };
//        if (slhsList != null && !slhsList.isEmpty()) {
//            List<DataObj> printData = getDataList(slhsList, company, context);
//            int size = printData.size();
//            int pageCount = 0;
//            for (DataObj data : printData) {
//                PdfPTable table = new PdfPTable(widths);
//                table.setWidthPercentage(100);
//                table.setPaddingTop(0);
//                table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
//                printTableTitle(document, data.getTitle(), data.getZy(), data.getDate());
//                printTableHeader(document, table);
//                printTableContent(document, data.getMxzList(), table, slhsXsd, kmyeXsd, data.getZy());
//                printTableFoot(document, data.getFoot(), table);
//                document.add(table);
//                pageCount++;
//                if (pageCount - size != 0)
//                    document.newPage();
//            }
//        }
//    }
//
//    /**
//     * 打印结账单的标题
//     * @param documentExt
//     * @param zy 科目信息
//     * @param rq   账期
//     * @throws DocumentException
//     */
//    private static void printTableTitle(Document document, String title, String zy, String rq) throws DocumentException {
//
//        float[] widths = { 1f, 1f, 1f };
//        PdfPTable tablex = new PdfPTable(widths);
//        tablex.setWidthPercentage(100);
//
//        int defaultFontsize = 12;
//        float defaultCellHeigth = 20f;
//        if (PageSize.A4.equals(document.getPageSize()))
//            defaultFontsize = 12;
//
//        tablex.addCell(generateCell("", defaultFontsize + 2, 30f, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 3, 1));
//
//        tablex.addCell(generateCell(title, defaultFontsize + 2, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 3, 1));
//
//        tablex.addCell(generateCell("", defaultFontsize + 2, 10f, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 3, 1));
//
//        tablex.addCell(generateCell(zy, defaultFontsize, defaultCellHeigth, Element.ALIGN_LEFT, Element.ALIGN_MIDDLE, 0, 1, 1, 20));
//
//        tablex.addCell(generateCell(rq, defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 1, 1, 20));
//
//        tablex.addCell(generateCell("", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 1, 1, 20));
//
//        tablex.addCell(generateCell("", defaultFontsize + 2, 5f, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 3, 1));
//
//        document.add(tablex);
//
//    }
//
//    /**
//     * 打印每个表格的表头信息
//     * @param document
//     * @throws DocumentException
//     */
//    private static void printTableHeader(Document document, PdfPTable tablex) throws DocumentException {
//
//        int defaultFontsize = 11;
//        float defaultCellHeigth = 20f;
//        if (PageSize.A4.equals(document.getPageSize()))
//            defaultFontsize = 11;
//        //第一行数据
//        tablex.addCell(generateCell("日期", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 2));
//        tablex.addCell(generateCell("凭证字号", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 2));
//        tablex.addCell(generateCell("摘要", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 2));
//        tablex.addCell(generateCell("借方", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 3, 1));
//        tablex.addCell(generateCell("贷方", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 3, 1));
//        tablex.addCell(generateCell("余额", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 4, 1));
//
//        //第二行数据
//        tablex.addCell(generateCell("数量", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 1));
//        tablex.addCell(generateCell("单价", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 1));
//        tablex.addCell(generateCell("金额", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 1));
//
//        tablex.addCell(generateCell("数量", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//        tablex.addCell(generateCell("单价", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//        tablex.addCell(generateCell("金额", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//
//        tablex.addCell(generateCell("方向", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//        tablex.addCell(generateCell("数量", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//        tablex.addCell(generateCell("单价", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//        tablex.addCell(generateCell("金额", defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1));
//
//    }
//
//    /**
//     * 打印表格内容
//     * @param dataList
//     * @throws DocumentException
//     */
//    private static void printTableContent(Document document, List<GlKmyeSlhsMxzVo> mxzList, PdfPTable tablex, Integer slhsXsd, Integer kmyeXsd,
//            String zy) throws DocumentException {
//
//        int defaultFontsize = 10;
//        float defaultCellHeigth = 20f;
//        if (PageSize.A4.equals(document.getPageSize())) {
//            defaultFontsize = 10;
//        }
//        if (mxzList != null && !mxzList.isEmpty()) {
//            //595,842
//            int size = mxzList.size(); //一共条数
//            float totalHeight = 595f;
//            float initHight = 135;
//            float printHeight = initHight;
//            for (GlKmyeSlhsMxzVo data : mxzList) {
//
//                BigDecimal slhsJf = data.getSlhsJf(); //数量额核算借方
//                BigDecimal jf = data.getJf(); //借方金额
//                BigDecimal slhsJfDj = BigDecimal.ZERO; //数量核算借方单价
//                if (slhsJf.compareTo(BigDecimal.ZERO) != 0) {
//                    slhsJfDj = jf.divide(slhsJf, slhsXsd, BigDecimal.ROUND_HALF_UP);
//                }
//
//                BigDecimal slhsDf = data.getSlhsDf(); //数量核算贷方
//                BigDecimal df = data.getDf(); //贷方金额
//                BigDecimal slhsDfDj = BigDecimal.ZERO;
//                if (slhsDf.compareTo(BigDecimal.ZERO) != 0) {
//                    slhsDfDj = df.divide(slhsDf, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//
//                BigDecimal slhsYe = data.getSlhsYe(); //数量核算余额
//                BigDecimal ye = data.getYe();
//                BigDecimal yeDj = BigDecimal.ZERO;
//                if (slhsYe.compareTo(BigDecimal.ZERO) != 0) {
//                    yeDj = ye.divide(slhsYe, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//
//                //日期
//                tablex.addCell(
//                        generateCell(data.getRq(), defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //凭证字号
//                tablex.addCell(
//                        generateCell(data.getPzzh(), defaultFontsize, defaultCellHeigth, Element.ALIGN_LEFT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//
//                //摘要
//                if (data.getZy().trim().equals("期初余额") || data.getZy().trim().equals("本期合计") || data.getZy().trim().equals("本年累计")) {
//                    tablex.addCell(
//                            generateCell("   " + data.getZy(), defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_LEFT, Element.ALIGN_MIDDLE, -1));
//                } else {
//                    tablex.addCell(
//                            generateCell(data.getZy(), defaultFontsize, defaultCellHeigth, Element.ALIGN_LEFT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                }
//                //数量核算借方
//                tablex.addCell(
//                        generateCell(slhsJf.compareTo(BigDecimal.ZERO) == 0 ? "" : slhsJf.setScale(slhsXsd, BigDecimal.ROUND_HALF_UP).toString(),
//                                defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //数量核算借方单价
//                tablex.addCell(generateCell(slhsJfDj.compareTo(BigDecimal.ZERO) == 0 ? "" : slhsJfDj.toString(), defaultFontsize - 1,
//                        defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //借方余额
//                tablex.addCell(generateCell(jf.compareTo(BigDecimal.ZERO) == 0 ? "" : jf.setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP).toString(),
//                        defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//
//                //贷方数量
//                tablex.addCell(
//                        generateCell(slhsDf.compareTo(BigDecimal.ZERO) == 0 ? "" : slhsDf.setScale(slhsXsd, BigDecimal.ROUND_HALF_UP).toString(),
//                                defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //贷方单价
//                tablex.addCell(generateCell(slhsDfDj.compareTo(BigDecimal.ZERO) == 0 ? "" : slhsDfDj.toString(), defaultFontsize - 1,
//                        defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //贷方金额
//                tablex.addCell(generateCell(df.compareTo(BigDecimal.ZERO) == 0 ? "" : df.setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP).toString(),
//                        defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//
//                //科目方向
//                tablex.addCell(
//                        generateCell(data.getYefx(), defaultFontsize, defaultCellHeigth, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //数量余额
//                tablex.addCell(
//                        generateCell(slhsYe.compareTo(BigDecimal.ZERO) == 0 ? "" : slhsYe.setScale(slhsXsd, BigDecimal.ROUND_HALF_UP).toString(),
//                                defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //余额单价
//                tablex.addCell(generateCell(yeDj.compareTo(BigDecimal.ZERO) == 0 ? "" : yeDj.toString(), defaultFontsize - 1, defaultCellHeigth,
//                        Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                //余额
//                tablex.addCell(generateCell(ye.compareTo(BigDecimal.ZERO) == 0 ? "" : ye.setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP).toString(),
//                        defaultFontsize - 1, defaultCellHeigth, Element.ALIGN_RIGHT, Element.ALIGN_MIDDLE, -1, 1, 1, 20));
//                printHeight += 20f;
//                if (printHeight % totalHeight == 0 && (printHeight - initHight) / defaultCellHeigth != size) {
//                    totalHeight = 595f;
//                    printHeight = 95;
//                    tablex.addCell(generateCell("", defaultFontsize, 20f, Element.ALIGN_CENTER, Element.ALIGN_MIDDLE, 0, 13, 1, 20));
//                    tablex.addCell(generateCell(zy, defaultFontsize + 2, 30f, Element.ALIGN_LEFT, Element.ALIGN_MIDDLE, 0, 13, 1, 20));
//                    printTableHeader(document, tablex);
//                }
//            }
//        }
//
//    }
//
//    /**
//     * 创建表格foot数据
//     * @param document  操作文件
//     * @param company   公司信息
//     * @throws DocumentException
//     */
//    private static void printTableFoot(Document document, String company, PdfPTable tablex) throws DocumentException {
//
//        int defaultFontsize = 11;
//        float defaultCellHeigth = 23f;
//        if (PageSize.A4.equals(document.getPageSize()))
//            defaultFontsize = 11;
//        tablex.addCell(generateCell(company, defaultFontsize, defaultCellHeigth, Element.ALIGN_LEFT, Element.ALIGN_MIDDLE, 0, 13, 1, 20));
//
//    }
//
//    /**
//     * 设置pdf单元格数据
//     * @param titlename             表格内容
//     * @param fontsize              字体大小
//     * @param cellHeigth            单元格高度
//     * @param horizontalAlignment   垂直对齐方式
//     * @param verticalAlignment     水平对齐方式
//     * @param properties            其他属性，详情看代码
//     * @return
//     */
//    private static PdfPCell generateCell(String titlename, int fontsize, float cellHeigth, int horizontalAlignment, int verticalAlignment,
//            int... properties) {
//        int border = -1; //边框，默认为没有
//        int colspan = 1; //单元格列合并数据
//        int rowspan = 1; //行合并数据
//        int font = 0; //字体
//        for (int i = 0; i < properties.length; i++) {
//            switch (i) {
//            case 0:
//                border = properties[i];
//                break;
//            case 1:
//                colspan = properties[i];
//                break;
//            case 2:
//                rowspan = properties[i];
//                break;
//            case 3:
//                font = properties[i];
//                break;
//            default:
//                border = properties[i];
//                break;
//            }
//        }
//        PdfPCell cell = new PdfPCell(new Phrase(titlename, new Font(getBaseFont(font), fontsize)));
//        cell.setHorizontalAlignment(horizontalAlignment);
//        cell.setVerticalAlignment(verticalAlignment);
//        cell.setFixedHeight(cellHeigth);
//        cell.setColspan(colspan); //合并列
//        cell.setRowspan(rowspan); //合并行
//        if (border != -1)
//            cell.setBorder(border);
//        return cell;
//    }
//
//    /**
//     * 获取单元格字体数据
//     * @param font
//     * @return
//     */
//    private static BaseFont getBaseFont(int... font) {
//        BaseFont bf = null;
//        try {
//            if (font.length == 0 || font[0] == 0)
//                bf = BaseFont.createFont("msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            else
//                bf = BaseFont.createFont("simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        } catch (DocumentException | IOException e) {
//            logger.warn("getBaseFont发生异常.", e);
//        }
//        return bf;
//    }
//
//    /**
//     * 将待打印的数据转换成打印的模板数据
//     * @param slhsList  数量核算明细账数据
//     * @param company   公司名称
//     * @param kjnd      会计年度
//     * @param kjqj      会计期间
//     * @return
//     */
//    public static List<DataObj> getDataList(List<GlKmyeSlhsMxzVo> mxzList, String company, String context) {
//        List<DataObj> resList = new ArrayList<>();
//        if (mxzList != null && !mxzList.isEmpty()) {
//            Map<String, List<GlKmyeSlhsMxzVo>> mxzMap = getSlhsMxzMap(mxzList);
//            List<String> setList = new ArrayList<String>(mxzMap.keySet());
//            Collections.sort(setList);
//            for (String kmnm : setList) {
//                DataObj obj = new DataObj();
//                List<GlKmyeSlhsMxzVo> dataList = mxzMap.get(kmnm);
//                obj.setMxzList(dataList);
//                obj.setDate(context);
//                if (dataList.get(0) != null && dataList.get(0).getKmmc() != null) {
//                    obj.setTitle(dataList.get(0).getKmmc() + "  数量金额明细账");
//                } else {
//                    obj.setTitle("数量金额明细账");
//                }
//                if (dataList.get(0) != null && dataList.get(0).getKmmc() != null && dataList.get(0).getKmbm() != null) {
//                    obj.setZy("科目： " + dataList.get(0).getKmbm() + "  " + dataList.get(0).getKmmc());
//                } else {
//                    obj.setZy("科目： ");
//                }
//                obj.setFoot("公司名称：  " + company);
//                resList.add(obj);
//            }
//        }
//        return resList;
//    }
//
//    /**
//     * 获取数量核算明细账Map
//     * @param slhsList
//     * @return
//     */
//    private static Map<String, List<GlKmyeSlhsMxzVo>> getSlhsMxzMap(List<GlKmyeSlhsMxzVo> slhsList) {
//        Map<String, List<GlKmyeSlhsMxzVo>> map = new HashMap<>();
//        if (slhsList != null && !slhsList.isEmpty()) {
//            for (GlKmyeSlhsMxzVo data : slhsList) {
//                if (!map.keySet().contains(data.getKmnm())) {
//                    map.put(data.getKmnm(), new ArrayList<GlKmyeSlhsMxzVo>());
//                }
//                map.get(data.getKmnm()).add(data);
//            }
//        }
//        return map;
//    }
//
//    /**
//     * 每一页表格内容封装的Bean
//     * @author rqx
//     *
//     */
//    static class DataObj {
//        /**
//         * 表头
//         */
//        private String title;
//
//        /**
//         * 摘要
//         */
//        private String zy;
//
//        /**
//         * 日期
//         */
//        private String date;
//
//        /**
//         * 明细账List
//         */
//        private List<GlKmyeSlhsMxzVo> mxzList;
//
//        /**
//         * 表格foot
//         */
//        private String foot;
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getZy() {
//            return zy;
//        }
//
//        public void setZy(String zy) {
//            this.zy = zy;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public List<GlKmyeSlhsMxzVo> getMxzList() {
//            return mxzList;
//        }
//
//        public void setMxzList(List<GlKmyeSlhsMxzVo> mxzList) {
//            this.mxzList = mxzList;
//        }
//
//        public String getFoot() {
//            return foot;
//        }
//
//        public void setFoot(String foot) {
//            this.foot = foot;
//        }
//
//    }
//
}
