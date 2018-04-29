package com.soecode.lyf.utils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.hssf.util.Region;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.Row;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.atc.daizhang.beans.GlKmyeView;
//
///**
// * 数量核算科目余额excel导出工具类
// * @author rqx
// * @创建时间 2017-03-20 上午 10:30:30
// * @修改人
// * @修改时间
// *
// */
public class SlhsKmyeExcelUtils {
//
//    private static Logger logger = LoggerFactory.getLogger(SlhsKmyeExcelUtils.class);
//
//    /**
//     * 导入表头开始行数据
//     */
//    private static final int HEAD_SRART_ROW = 2;
//
//    /**
//     * 导入数据开始行
//     */
//    private static final int DATA_START_ROW = 4;
//
//    //List<GlKmyeView> resList
//    /**
//     * 批量打印凭证页面信息
//     * @param slhsList 数量核算科目余额数据
//     * @param path 文件路径
//     * @param folder 文件夹名称
//     * @param filename 文件名称
//     * @param company 公司名称
//     * @param context 导出的内容
//     * @param kjnd 会计年度
//     * @param kjqj 会计期间
//     * @throws Exception
//     */
//    public static void exportSlhsKmyeExcel(List<GlKmyeView> slhsList, String path, String folder, String filename, String company, String context,
//            Integer slhsXsd, Integer kmyeXsd) throws Exception {
//        logger.info("BEGIN CREATING SlhsExcel Excel TYPE 1.");
//        creatSlhsKmyeExcel(slhsList, path, folder, filename, company, context, slhsXsd, kmyeXsd);
//        logger.info("SlhsExcel TYPE 1 Excel HAS BEEN CREATED.");
//    }
//
//    @SuppressWarnings("deprecation")
//    private static void creatSlhsKmyeExcel(List<GlKmyeView> slhsList, String path, String folder, String filename, String company, String context,
//            Integer slhsXsd, Integer kmyeXsd) {
//        try {
//            File a = new File(path + File.separator + folder); //创建一个文件
//            if (!a.exists()) {
//                a.mkdir();
//            }
//            String filePath = path + File.separator + folder + File.separator + filename + "temp.xls"; //excel输出流的的路径
//            HSSFWorkbook wb = new HSSFWorkbook();
//            HSSFSheet sheet = wb.createSheet(company + "【数量核算科目余额表】"); //创建sheet名称
//            //创建表头
//            creatTableHeadRow(wb, sheet, HEAD_SRART_ROW);
//            //创建内容
//            creatRowData(slhsList, wb, sheet, company, slhsXsd, kmyeXsd);
//            //设置表格的顶端信息，在第一行进行设置
//            Row headRow = sheet.createRow(0);
//            headRow.setHeightInPoints(25);
//            Cell cell = headRow.createCell(0);
//            // 四个参数分别是：起始行，起始列，结束行，结束列
//            sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 17));
//            CellStyle style = wb.createCellStyle();
//            setCellDataAndStyle(wb, style, cell, "数量金额科目余额表", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 14, Font.BOLDWEIGHT_BOLD,
//                    (short) -1, (short) -1, (short) -1, (short) -1);
//
//            FileOutputStream fileOut = null;
//            try {
//                filePath = filePath.replace("temp.xls", ".xls");
//                fileOut = new FileOutputStream(filePath);
//                wb.write(fileOut);
//            } finally {
//                if (fileOut != null)
//                    fileOut.close();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 创建科目余额数量核算表头数据
//     * @param workbook  工作簿
//     * @param sheet     工作表格
//     * @param startIndex    表头开始行
//     */
//    @SuppressWarnings("deprecation")
//    private static void creatTableHeadRow(HSSFWorkbook workbook, HSSFSheet sheet, int startIndex) {
//        CellStyle style = workbook.createCellStyle();
//        Row headrow = sheet.createRow(startIndex - 1); //获取需要写入的表头行
//        Row headNextRow = sheet.createRow(startIndex); //获取需要写入的表头行另一行
//        headrow.setHeightInPoints(22);
//        headNextRow.setHeightInPoints(22);
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //设置垂直对齐方式
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //单元的样式设置为居中对齐
//        style.setBorderBottom((short) 1); //设置下部边框
//        style.setBorderLeft((short) 1); //设置做不边框
//        style.setBorderRight((short) 1); //设置右部边框
//        style.setBorderTop((short) 1); //设置顶部边框
//        Font font = workbook.createFont();
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD); //设置字体的大小和样式
//        font.setFontHeightInPoints((short) 11);
//        style.setFont(font);
//        //设置第一行表头数据
//        for (int i = 0; i < 18; i++) {
//            Cell cell = headrow.createCell(i);
//            if (i == 0) {
//                sheet.setColumnWidth(i, 256 * 22);
//                cell.setCellValue("科目编码"); //设置单元格的内容
//            } else if (i == 1) {
//                sheet.setColumnWidth(i, 256 * 22);
//                cell.setCellValue("科目名称"); //设置单元格的内容
//            } else if (i == 2) {
//                cell.setCellValue("期初余额"); //设置单元格的内容
//            } else if (i == 6) {
//                cell.setCellValue("本期借方发生额"); //设置单元格的内容
//            } else if (i == 8) {
//                cell.setCellValue("本期贷方发生额"); //设置单元格的内容
//            } else if (i == 10) {
//                cell.setCellValue("本年累计借方发生额"); //设置单元格的内容
//            } else if (i == 12) {
//                cell.setCellValue("本年累计贷方发生额"); //设置单元格的内容
//            } else if (i == 14) {
//                cell.setCellValue("期末余额"); //设置单元格的内容
//            } else {
//                cell.setCellValue(""); //设置单元格的内容
//            }
//            cell.setCellStyle(style);
//        }
//        //设置第二行表头数据
//        for (int i = 0; i < 18; i++) {
//            Cell cell = headNextRow.createCell(i);
//            if (i == 2 || i == 14) {
//                sheet.setColumnWidth(i, 256 * 7);
//                cell.setCellValue("方向"); //设置单元格的内容
//            } else if (i == 3 || i == 6 || i == 8 || i == 10 || i == 12 || i == 15) {
//                sheet.setColumnWidth(i, 256 * 14);
//                cell.setCellValue("数量"); //设置单元格的内容
//            } else if (i == 4 || i == 16) {
//                sheet.setColumnWidth(i, 256 * 14);
//                cell.setCellValue("单价"); //设置单元格的内容
//            } else if (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 17) {
//                sheet.setColumnWidth(i, 256 * 14);
//                cell.setCellValue("金额"); //设置单元格的内容
//            } else {
//                cell.setCellValue(""); //设置单元格的内容
//            }
//            cell.setCellStyle(style);
//        }
//        // 四个参数分别是：起始行，起始列，结束行，结束列
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 0, startIndex - 1 + 1, (short) 0)); //合并科目编码
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 1, startIndex - 1 + 1, (short) 1)); //合并科目名称
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 2, startIndex - 1, (short) 5)); //合并期初余额
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 6, startIndex - 1, (short) 7)); //本期借方发生额
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 8, startIndex - 1, (short) 9)); //本期贷方发生额
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 10, startIndex - 1, (short) 11)); //本年累计借方发生额
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 12, startIndex - 1, (short) 13)); //本年累计贷方发生额
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) 14, startIndex - 1, (short) 17)); //期末余额
//
//    }
//
//    /**
//    *
//    * @param slhsList   数量核算数据
//    * @param wb         工作簿
//    * @param sheet      工作表格
//    * @param company    公司名称
//    */
//    private static void creatRowData(List<GlKmyeView> slhsList, HSSFWorkbook wb, HSSFSheet sheet, String company, Integer slhsXsd, Integer kmyeXsd) {
//        Integer startIndex = DATA_START_ROW - 1; //数据开始行
//        CellStyle style = wb.createCellStyle();
//        CellStyle style1 = wb.createCellStyle();
//        CellStyle style2 = wb.createCellStyle();
//        if (slhsList != null && !slhsList.isEmpty()) {
//            for (GlKmyeView data : slhsList) {
//                String kmbm = data.getkKmbm(); //科目编码
//                String kmmc = getKmmc(data.getkKmqc(), data.getkKmnm()); //科目名称
//                String kmfx = data.getkKmfx() - 1 == 0 ? "借" : "贷"; //科目方向
//                BigDecimal qcslhs = BigDecimal.ZERO; //期初数量核算
//                BigDecimal qcye = BigDecimal.ZERO; //期初余额
//                BigDecimal qmSlhs = BigDecimal.ZERO; //期末数量核算
//                BigDecimal qmye = BigDecimal.ZERO; //期末余额
//                if (data.getkKmfx() - 1 == 0) {
//                    qcslhs = data.getKmyeSlhs().getQcSlhsJf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);
//                    qcye = data.getQcJf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);
//                    qmSlhs = data.getKmyeSlhs().getQmSlhsJf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);
//                    qmye = data.getQmJf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);
//                } else {
//                    qcslhs = data.getKmyeSlhs().getQcSlhsDf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);
//                    qcye = data.getQcDf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);
//                    qmSlhs = data.getKmyeSlhs().getQmSlhsDf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);
//                    qmye = data.getQmDf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);
//                }
//                BigDecimal bqjfSlhs = data.getKmyeSlhs().getBqSlhsJf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP); //本期借方数量核算
//                BigDecimal bqdfSlhs = data.getKmyeSlhs().getBqSlhsDf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP); //本期贷方数量核算
//                BigDecimal bqjfYe = data.getBqJf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP); //本期借方余额
//                BigDecimal bqdfYe = data.getBqDf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP); //本期贷方余额
//                BigDecimal bnljJfSlhs = data.getKmyeSlhs().getBnljSlhsJf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP); //本年累计借方数量核算
//                BigDecimal bnljDfSlhs = data.getKmyeSlhs().getBnljSlhsDf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP); //本年累计贷方数量核算
//                BigDecimal bnljJfYe = data.getBnljJf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);//本年累计借方余额
//                BigDecimal bnljDfYe = data.getBnljDf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);//本年累计贷方余额
//                BigDecimal qcDj = BigDecimal.ZERO; //期初数量核算单价
//                if (qcslhs.compareTo(BigDecimal.ZERO) != 0) {
//                    qcDj = qcye.divide(qcslhs, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//                BigDecimal qmDj = BigDecimal.ZERO;
//                if (qmSlhs.compareTo(BigDecimal.ZERO) != 0) {
//                    qmDj = qmye.divide(qmSlhs, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//                Row row = sheet.createRow(startIndex);
//                row.setHeightInPoints(21);
//                //科目编码
//                Cell cell0 = row.createCell(0);
//                setCellDataAndStyle(wb, style, cell0, kmbm, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                        (short) 1, (short) 1, (short) 1, (short) 1);
//                //科目名称
//                Cell cell1 = row.createCell(1);
//                setCellDataAndStyle(wb, style, cell1, kmmc, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                        (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期初余额方向
//                Cell cell2 = row.createCell(2);
//                setCellDataAndStyle(wb, style1, cell2, kmfx, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                        (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期初数量核算
//                Cell cell3 = row.createCell(3);
//                setCellDataAndStyle(wb, style2, cell3, qcslhs.compareTo(BigDecimal.ZERO) == 0 ? "" : qcslhs.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期初单价
//                Cell cell4 = row.createCell(4);
//                setCellDataAndStyle(wb, style2, cell4, qcDj.compareTo(BigDecimal.ZERO) == 0 ? "" : qcDj.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期初余额
//                Cell cell5 = row.createCell(5);
//                setCellDataAndStyle(wb, style2, cell5, qcye.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //本期数量核算借方发生额
//                Cell cell6 = row.createCell(6);
//                setCellDataAndStyle(wb, style2, cell6, bqjfSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : bqjfSlhs.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //本期科目余额发生额
//                Cell cell7 = row.createCell(7);
//                setCellDataAndStyle(wb, style2, cell7, bqjfYe.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //本期数量核算贷方发生额
//                Cell cell8 = row.createCell(8);
//                setCellDataAndStyle(wb, style2, cell8, bqdfSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : bqdfSlhs.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //本期科目余额贷方发生额
//                Cell cell9 = row.createCell(9);
//                setCellDataAndStyle(wb, style2, cell9, bqdfYe.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //本年累计数量核算借方发生额
//                Cell cell10 = row.createCell(10);
//                setCellDataAndStyle(wb, style2, cell10, bnljJfSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : bnljJfSlhs.toString(),
//                        HSSFCellStyle.ALIGN_RIGHT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1,
//                        (short) 1);
//
//                //本年累计科目余额借方发生额
//                Cell cell11 = row.createCell(11);
//                setCellDataAndStyle(wb, style2, cell11, bnljJfYe.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //本年累数量核算贷方发生额
//                Cell cell12 = row.createCell(12);
//                setCellDataAndStyle(wb, style2, cell12, bnljDfSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : bnljDfSlhs.toString(),
//                        HSSFCellStyle.ALIGN_RIGHT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1,
//                        (short) 1);
//
//                //本年累计科目余额贷方发生额
//                Cell cell13 = row.createCell(13);
//                setCellDataAndStyle(wb, style2, cell13, bnljDfYe.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末余额方向
//                Cell cell14 = row.createCell(14);
//                setCellDataAndStyle(wb, style1, cell14, kmfx, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                        (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末数量核算
//                Cell cell15 = row.createCell(15);
//                setCellDataAndStyle(wb, style2, cell15, qmSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : qmSlhs.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末单价
//                Cell cell16 = row.createCell(16);
//                setCellDataAndStyle(wb, style2, cell16, qmDj.compareTo(BigDecimal.ZERO) == 0 ? "" : qmDj.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末科目余额
//                Cell cell17 = row.createCell(17);
//                setCellDataAndStyle(wb, style2, cell17, qmye.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                startIndex++;
//
//            }
//        }
//    }
//
//    /**
//     * 设置科目名称登记
//     * @param kmmc  原科目名称
//     * @param kmnm  原科目内码
//     * @return
//     */
//    private static String getKmmc(String kmmc, String kmnm) {
//        if (!StringUtil.isBlank(kmnm)) {
//            String fix = "";
//            for (int i = 0; i < kmnm.length() / 4 - 1; i++) {
//                fix += "  ";
//            }
//            kmmc = fix + kmmc;
//        }
//        return kmmc;
//    }
//
//    /**
//     * 设置各个单元格的各种属性
//     * @param workBook 工作簿
//     * @param style excel表格样式
//     * @param cell 单元格
//     * @param value 单元格内容
//     * @param color 单元格字体颜色
//     * @param align 单元格字体的对齐方式
//     * @param fontSize 单元格的字体的大小
//     * @param fontWeight 单元格字体的粗细样式
//     * @param topBorder 顶部边框
//     * @param bottomBorder 下部边框
//     * @param leftBordr 左侧边框
//     * @param rightBorder 右侧边框
//     */
//    private static void setCellDataAndStyle(HSSFWorkbook workBook, CellStyle style, Cell cell, String value, short align, short fontColor,
//            short fontSize, short fontWeight, short topBorder, short bottomBorder, short leftBordr, short rightBorder) {
//        if (style == null) {
//            style = workBook.createCellStyle();
//        }
//        Font font = workBook.createFont(); //单元格的字体
//        cell.setCellValue(value); //设置内容
//        font.setBoldweight(fontWeight); //字体的样式
//        font.setColor(fontColor); //字体颜色
//        font.setFontHeightInPoints(fontSize); //单元格字体
//        style.setAlignment(align); //设置单元格对齐方式
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //设置垂直对齐方式
//        if (bottomBorder - (-1) != 0) {
//            style.setBorderBottom(bottomBorder); //设置下部边框
//        }
//        if (leftBordr - (-1) != 0) {
//            style.setBorderLeft(leftBordr); //设置做不边框
//        }
//        if (rightBorder - (-1) != 0) {
//            style.setBorderRight(rightBorder); //设置右部边框
//        }
//        if (topBorder - (-1) != 0) {
//            style.setBorderTop(topBorder); //设置顶部边框
//        }
//        style.setFont(font);
//        cell.setCellStyle(style);
//    }
//
}
