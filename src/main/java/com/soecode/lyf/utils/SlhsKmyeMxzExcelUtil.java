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
//import com.atc.daizhang.beans.slhs.GlKmyeSlhsMxzVo;
//
///**
// * 数量核算科目余额明细账excel工具类
// * @author rqx
// * @创建时间 2017-03-21
// * @修改人
// * @修改时间
// *
// */
public class SlhsKmyeMxzExcelUtil {
//
//    private static Logger logger = LoggerFactory.getLogger(SlhsKmyeMxzExcelUtil.class);
//
//    /**
//     * 单条导出excel时表头开始行
//     */
//    private static final Integer SINGLE_HEAD_START_INDEX = 4;
//
//    /**
//     * 单条导出excel数据开始行
//     */
//    private static final Integer SINGLE_DATA_START_INDEX = 6;
//
//    /**
//     * 批量导出excel数据开始行
//     *
//     */
//    private static final Integer MULTIPLE_DATA_START_INDEX = 5;
//
//    /**
//     * 批量导出excel表头开始行
//     */
//    private static final Integer MUTIPLE_HEAD_START_INDEX = 3;
//
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
//     * @param slhsXsd 数量核算保留小数点
//     * @param kmyeXsd 科目余额保留小数点
//     * @param type 1：单条excel导出，2：批量excel导出
//     * @param kmxx 单条导出时科目信息
//     * @throws Exception
//     */
//    public static void exportSlhsKmyeExcel(List<GlKmyeSlhsMxzVo> slhsList, String path, String folder, String filename, String company,
//            String context, Integer slhsXsd, Integer kmyeXsd, String type, String kmxx) throws Exception {
//        logger.info("BEGIN CREATING SlhsExcel Excel TYPE 1.");
//        creatSlhsKmyeExcel(slhsList, path, folder, filename, company, context, slhsXsd, kmyeXsd, type, kmxx);
//        logger.info("SlhsExcel TYPE 1 Excel HAS BEEN CREATED.");
//    }
//
//    @SuppressWarnings("deprecation")
//    private static void creatSlhsKmyeExcel(List<GlKmyeSlhsMxzVo> slhsList, String path, String folder, String filename, String company,
//            String context, Integer slhsXsd, Integer kmyeXsd, String type, String kmxx) {
//        try {
//            File a = new File(path + File.separator + folder); //创建一个文件
//            if (!a.exists()) {
//                a.mkdir();
//            }
//            String filePath = path + File.separator + folder + File.separator + filename + "temp.xls"; //excel输出流的的路径
//            HSSFWorkbook wb = new HSSFWorkbook();
//            HSSFSheet sheet = wb.createSheet(company + "【数量金额明细账表】"); //创建sheet名称
//            //标题数据
//            creatTitleData(wb, sheet, context, type, kmxx);
//            //表头数据
//            if ("1".equals(type)) {
//                creatTableHeadRow(wb, sheet, SINGLE_HEAD_START_INDEX, type);
//            } else {
//                creatTableHeadRow(wb, sheet, MUTIPLE_HEAD_START_INDEX, type);
//            }
//            //表格内容数据
//            if ("1".equals(type)) {
//                creatRowData(slhsList, wb, sheet, company, slhsXsd, kmyeXsd, SINGLE_DATA_START_INDEX, type);
//            } else {
//                creatRowData(slhsList, wb, sheet, company, slhsXsd, kmyeXsd, MULTIPLE_DATA_START_INDEX, type);
//            }
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
//     * 创建exceL标题数据
//     * @param wb        工作簿
//     * @param sheet     工作表格
//     * @param context   标题内容
//     * @param type      导出类型，1：单条导出，2:批量导出
//     * @param km
//     */
//    @SuppressWarnings("deprecation")
//    private static void creatTitleData(HSSFWorkbook wb, HSSFSheet sheet, String context, String type, String kmxx) {
//        //设置表格的顶端信息，在第一行进行设置
//        Row headRow = sheet.createRow(0);
//        headRow.setHeightInPoints(25);
//        Cell cell = headRow.createCell(0);
//        // 四个参数分别是：起始行，起始列，结束行，结束列
//        if ("1".equals(type)) {
//            sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 12));
//            sheet.addMergedRegion(new Region(1, (short) 0, 1, (short) 12));
//        } else {
//            sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 13));
//            sheet.addMergedRegion(new Region(1, (short) 0, 1, (short) 13));
//        }
//        CellStyle style = wb.createCellStyle();
//        setCellDataAndStyle(wb, style, cell, "数量金额明细账表", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 14, Font.BOLDWEIGHT_BOLD,
//                (short) -1, (short) -1, (short) -1, (short) -1);
//
//        //设置账期数据
//        Row headnextRow = sheet.createRow(1);
//        headnextRow.setHeightInPoints(20);
//        Cell cell1 = headnextRow.createCell(0);
//        CellStyle style1 = wb.createCellStyle();
//        setCellDataAndStyle(wb, style1, cell1, context, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                (short) -1, (short) -1, (short) -1, (short) -1);
//
//        //设置科目信息
//        if ("1".equals(type)) {
//            Row kmrow = sheet.createRow(2);
//            Cell cell2 = kmrow.createCell(0);
//            kmrow.setHeightInPoints(20);
//            CellStyle style2 = wb.createCellStyle();
//            setCellDataAndStyle(wb, style2, cell2, kmxx, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                    (short) -1, (short) -1, (short) -1, (short) -1);
//            sheet.addMergedRegion(new Region(2, (short) 0, 2, (short) 12));
//        }
//
//    }
//
//    /**
//     * 创建导出的excel表头信息
//     * @param workbook      工作簿
//     * @param sheet         表格
//     * @param startIndex    数据开始行
//     * @param type          类型，1：表示单条导出，2：表示批量导出
//     */
//    private static void creatTableHeadRow(HSSFWorkbook workbook, HSSFSheet sheet, int startIndex, String type) {
//        CellStyle style = workbook.createCellStyle(); //表格样式
//        Row headRow = sheet.createRow(startIndex - 1); //表格第一行
//        Row headNextRow = sheet.createRow(startIndex); //表格第二行
//        headRow.setHeightInPoints(22);
//        headNextRow.setHeightInPoints(22);
//        //批量导出时
//        int start = 0;
//        int end = 13;
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
//        if ("2".equals(type)) {
//            start = 1;
//            end = 14;
//            //设置第一行第一列
//            Cell cell = headRow.createCell(0);
//            sheet.setColumnWidth(0, 256 * 25);
//            cell.setCellValue("科目");
//            cell.setCellStyle(style);
//            //设置第二行第一列
//            Cell cell1 = headNextRow.createCell(0);
//            cell1.setCellValue("科目");
//            cell1.setCellStyle(style);
//        }
//        //第一行数据
//        for (int i = start; i < end; i++) {
//            Cell cell = headRow.createCell(i);
//            if (i == start) {
//                sheet.setColumnWidth(i, 256 * 17);
//            }
//            if (i == start + 1) {
//                sheet.setColumnWidth(i, 256 * 12);
//            }
//            if (i == start + 2) {
//                sheet.setColumnWidth(i, 256 * 22);
//            }
//            if (i == start) {
//                cell.setCellValue("日期");
//            } else if (i == start + 1) {
//                cell.setCellValue("凭证字号");
//            } else if (i == start + 2) {
//                cell.setCellValue("摘要");
//            } else if (i == start + 3) {
//                cell.setCellValue("借方");
//            } else if (i == start + 6) {
//                cell.setCellValue("贷方");
//            } else if (i == start + 9) {
//                cell.setCellValue("余额");
//            } else {
//                cell.setCellValue("");
//            }
//            cell.setCellStyle(style);
//        }
//        //第二行数据
//        for (int i = start; i < end; i++) {
//            Cell cell = headNextRow.createCell(i);
//            if (i == start + 3 || i == start + 6 || i == start + 10) {
//                sheet.setColumnWidth(i, 256 * 14);
//                cell.setCellValue("数量"); //设置单元格的内容
//            } else if (i == start + 4 || i == start + 7 || i == start + 11) {
//                sheet.setColumnWidth(i, 256 * 14);
//                cell.setCellValue("单价"); //设置单元格的内容
//            } else if (i == start + 5 || i == start + 8 || i == start + 12) {
//                sheet.setColumnWidth(i, 256 * 14);
//                cell.setCellValue("金额"); //设置单元格的内容
//            } else if (i == start + 9) {
//                sheet.setColumnWidth(i, 256 * 7);
//                cell.setCellValue("方向"); //设置单元格的内容
//            } else {
//                cell.setCellValue(""); //设置单元格的内容
//            }
//            cell.setCellStyle(style);
//        }
//        //合并单元格
//        if ("2".equals(type)) {
//            sheet.addMergedRegion(new Region(startIndex - 1, (short) 0, startIndex - 1 + 1, (short) 0)); //合并科目编码
//        }
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) start, startIndex - 1 + 1, (short) start));
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) (start + 1), startIndex - 1 + 1, (short) (start + 1)));
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) (start + 2), startIndex - 1 + 1, (short) (start + 2)));
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) (start + 3), startIndex - 1, (short) (start + 5)));
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) (start + 6), startIndex - 1, (short) (start + 8)));
//        sheet.addMergedRegion(new Region(startIndex - 1, (short) (start + 9), startIndex - 1, (short) (start + 12)));
//    }
//
//    /**
//     * 创建表格内容方法
//     * @param slhsList     明细账数据List
//     * @param wb           工作簿
//     * @param sheet        表格
//     * @param company      公司
//     * @param slhsXsd      数量核算保留小数点
//     * @param kmyeXsd      科目余额保留小数点
//     * @param index        数据开始行
//     * @param type         导出类型1：单条excel导出，2：批量excel导出
//     */
//    private static void creatRowData(List<GlKmyeSlhsMxzVo> slhsList, HSSFWorkbook wb, HSSFSheet sheet, String company, Integer slhsXsd,
//            Integer kmyeXsd, Integer index, String type) {
//        if (slhsList != null && !slhsList.isEmpty()) {
//            Integer startIndex = index - 1; //数据开始行
//            CellStyle style = wb.createCellStyle(); //左对齐
//            CellStyle style1 = wb.createCellStyle(); //居中对齐
//            CellStyle style2 = wb.createCellStyle(); //右对齐
//            CellStyle style3 = wb.createCellStyle(); //右对齐
//            int start = 0;
//            if ("2".equals(type)) {
//                start = 1;
//            }
//            for (GlKmyeSlhsMxzVo data : slhsList) {
//                //借方
//                BigDecimal jfSlhs = data.getSlhsJf() == null ? BigDecimal.ZERO : data.getSlhsJf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);//借方数量核算
//                BigDecimal jsJe = data.getJf() == null ? BigDecimal.ZERO : data.getJf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP); //借方金额
//                BigDecimal jfDj = BigDecimal.ZERO; //借方数量核算单价
//                if (jfSlhs.compareTo(BigDecimal.ZERO) != 0) {
//                    jfDj = jsJe.divide(jfSlhs, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//
//                //贷方
//                BigDecimal dfSlhs = data.getSlhsDf() == null ? BigDecimal.ZERO : data.getSlhsDf().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);//贷方数量核算
//                BigDecimal dfJe = data.getDf() == null ? BigDecimal.ZERO : data.getDf().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);//贷方金额
//                BigDecimal dfDj = BigDecimal.ZERO; //贷方数量核算单价
//                if (dfSlhs.compareTo(BigDecimal.ZERO) != 0) {
//                    dfDj = dfJe.divide(dfSlhs, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//
//                //期末余额
//                BigDecimal ye = data.getYe() == null ? BigDecimal.ZERO : data.getYe().setScale(kmyeXsd, BigDecimal.ROUND_HALF_UP);//期末余额
//                BigDecimal slhsYe = data.getSlhsYe() == null ? BigDecimal.ZERO : data.getSlhsYe().setScale(slhsXsd, BigDecimal.ROUND_HALF_UP);//数量核算科目余额
//                BigDecimal qmyeDj = BigDecimal.ZERO;
//                if (slhsYe.compareTo(BigDecimal.ZERO) != 0) {
//                    qmyeDj = ye.divide(slhsYe, slhsXsd, BigDecimal.ROUND_HALF_UP).abs();
//                }
//                Row row = sheet.createRow(startIndex);
//                row.setHeightInPoints(21);
//                if ("2".equals(type)) {
//                    //科目信息
//                    Cell _cell = row.createCell(0);
//                    setCellDataAndStyle(wb, style, _cell, data.getKm(), HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                            Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//                }
//
//                //日期
//                Cell cell0 = row.createCell(start);
//                setCellDataAndStyle(wb, style1, cell0, data.getRq(), HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //凭证字号
//                Cell cell1 = row.createCell(start + 1);
//                setCellDataAndStyle(wb, style, cell1, data.getPzzh(), HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //摘要
//                String zy = data.getZy();
//                Cell cell2 = row.createCell(start + 2);
//                if (zy.trim().equals("期初余额") || zy.trim().equals("本期合计") || zy.trim().equals("本年累计")) {
//                    zy = "   " + zy;
//                    setCellDataAndStyle(wb, style3, cell2, zy, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_BOLD,
//                            (short) 1, (short) 1, (short) 1, (short) 1);
//                } else {
//                    setCellDataAndStyle(wb, style, cell2, zy, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL,
//                            (short) 1, (short) 1, (short) 1, (short) 1);
//                }
//
//                //借方数量核算
//                Cell cell3 = row.createCell(start + 3);
//                setCellDataAndStyle(wb, style2, cell3, jfSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : jfSlhs.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //借方数量核算单价
//                Cell cell4 = row.createCell(start + 4);
//                setCellDataAndStyle(wb, style2, cell4, jfDj.compareTo(BigDecimal.ZERO) == 0 ? "" : jfDj.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //借方金额
//                Cell cell5 = row.createCell(start + 5);
//                setCellDataAndStyle(wb, style2, cell5, jsJe.toString(), HSSFCellStyle.ALIGN_RIGHT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //贷方数量核算
//                Cell cell6 = row.createCell(start + 6);
//                setCellDataAndStyle(wb, style2, cell6, dfSlhs.compareTo(BigDecimal.ZERO) == 0 ? "" : dfSlhs.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //贷方单价
//                Cell cell7 = row.createCell(start + 7);
//                setCellDataAndStyle(wb, style2, cell7, dfDj.compareTo(BigDecimal.ZERO) == 0 ? "" : dfDj.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //贷方金额
//                Cell cell8 = row.createCell(start + 8);
//                setCellDataAndStyle(wb, style2, cell8, dfJe.toString(), HSSFCellStyle.ALIGN_RIGHT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //科目方向
//                Cell cell9 = row.createCell(start + 9);
//                setCellDataAndStyle(wb, style1, cell9, data.getYefx(), HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末数量核算
//                Cell cell10 = row.createCell(start + 10);
//                setCellDataAndStyle(wb, style2, cell10, slhsYe.compareTo(BigDecimal.ZERO) == 0 ? "" : slhsYe.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末数量核算单价
//                Cell cell11 = row.createCell(start + 11);
//                setCellDataAndStyle(wb, style2, cell11, qmyeDj.compareTo(BigDecimal.ZERO) == 0 ? "" : qmyeDj.toString(), HSSFCellStyle.ALIGN_RIGHT,
//                        HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//
//                //期末余额
//                Cell cell12 = row.createCell(start + 12);
//                setCellDataAndStyle(wb, style2, cell12, ye.toString(), HSSFCellStyle.ALIGN_RIGHT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) 1, (short) 1, (short) 1, (short) 1);
//                startIndex++;
//
//            }
//        }
//
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
//
//    }
//
}
