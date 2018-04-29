package com.soecode.lyf.utils;
//
//import com.atc.daizhang.beans.constants.system.InvoiceConstant;
//import com.atc.daizhang.beans.jxc.ChCbjzb;
//import com.atc.daizhang.beans.jxc.ChCh;
//import com.atc.daizhang.beans.jxc.ChDjView;
//import com.atc.daizhang.beans.jxc.ChDjmx;
//import com.atc.daizhang.beans.jxc.ChHz;
//import com.atc.daizhang.beans.jxc.ChLlsc;
//import com.atc.daizhang.beans.jxc.ChLlscView;
//import com.atc.daizhang.framework.common.utils.DateUtils;
//import com.atc.daizhang.framework.common.utils.StringUtil;
//import com.atc.daizhang.framework.common.utils.StringUtils;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.util.CellRangeAddress;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by llh on 2018-03-30
// */
public class CbhsExportUtils {
//
//    private static Logger logger = LoggerFactory.getLogger(InvoiceConstant.LOG_NAME.SALARY_LOG);
//
//    /**
//     * 销售成本结转导出excel
//     *
//     * @param path
//     * @param
//     * @param qymc
//     */
//    public static void exportXscbjzInfo(String path, List<ChCbjzb> list, String qymc, Integer kjnd, Integer kjqj) throws Exception {
//        try {
//            SXSSFWorkbook wookBook = new SXSSFWorkbook(1000);
//            Sheet sheet = wookBook.createSheet("销售成本结转表");
//
//            String[] headers = {"日期", "存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"};
//
//            Row headRow = sheet.createRow(0);
//            headRow.setHeightInPoints(25);
//            Cell cell = headRow.createCell(0);
//            // 四个参数分别是：起始行，结束行，起始列，结束列
//            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
//            CellStyle style = wookBook.createCellStyle();
//
////            //第一行数据
//            setCellDataAndStyle(wookBook, style, null, cell, qymc + "销售成本结转表", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            List<String> headerList = Arrays.asList(headers);
//            Map<String, CellRangeAddress> mergeParam = new HashMap<String, CellRangeAddress>();
//            for (int i = 0; i < headerList.size(); i++) {
//                mergeParam.put(headerList.get(i), new CellRangeAddress(1, 1, i, i));
//            }
//            // 设置表头数据
//            setExcelHeader(wookBook, sheet, 2, headerList, mergeParam);
//
//            // 设置excel内容数据
//            int startIndex = 2;
//            setExcelXscbjzInfo(list, sheet, startIndex, headerList, wookBook, kjnd, kjqj);
//
//            FileOutputStream fileOut = null;
//            try {
//                path = path.replace("temp.xls", ".xls");
//                fileOut = new FileOutputStream(path);
//                wookBook.write(fileOut);
//            } finally {
//                if (fileOut != null) {
//                    fileOut.close();
//                    wookBook.dispose();
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw e;
//        }
//    }
//
//    /**
//     * 设置excel表头数据
//     *
//     * @param workbook
//     * @param sheet
//     * @param startIndex
//     * @param headerList
//     */
//    private static void setExcelHeader(SXSSFWorkbook workbook, Sheet sheet, int startIndex, List<String> headerList,
//                                       Map<String, CellRangeAddress> mergeParam) {
//
//        CellStyle style = workbook.createCellStyle();
//        Row headrow = sheet.createRow(startIndex - 1); //获取需要写入的表头行
//        Row headNextRow = sheet.createRow(startIndex); //获取需要写入的表头行另一行
//        headrow.setHeightInPoints(22);
//        headNextRow.setHeightInPoints(22);
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //设置垂直对齐方式
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //单元的样式设置为居中对齐
//        style.setBorderBottom((short) 1); //设置下部边框
//        style.setBorderLeft((short) 1); //设置左部边框
//        style.setBorderRight((short) 1); //设置右部边框
//        style.setBorderTop((short) 1); //设置顶部边框
//
//        Font font = workbook.createFont();
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD); //设置字体的大小和样式
//        font.setFontHeightInPoints((short) 11);
//        style.setFont(font);
//
//        //设置第一行表头数据
//        for (int i = 0; i < headerList.size(); i++) {
//            int index = mergeParam.get(headerList.get(i)).getLastColumn();
//            Cell cell = headrow.createCell(index);
//            cell.setCellStyle(style);
//            cell.setCellValue(headerList.get(i));
//            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            style.setFillForegroundColor(new HSSFColor.PALE_BLUE().getIndex());
//            sheet.setColumnWidth(i, headerList.get(i).getBytes().length * 256); // 设置单元格宽度
//        }
//
//    }
//
//    /**
//     * 销售成本结转excel内容
//     *
//     * @param
//     * @param sheet
//     * @param startIndex
//     * @param headerList
//     * @param workbook
//     */
//    private static void setExcelXscbjzInfo(List<ChCbjzb> list, Sheet sheet, int startIndex, List<String> headerList, SXSSFWorkbook workbook, Integer kjnd, Integer kjqj) {
//        CellStyle style = workbook.createCellStyle();
//        Font font = workbook.createFont();
//
//        for (int j = 0; j < list.size(); j++) {
//            ChCbjzb bean = list.get(j);
//            String content = "";
//            Row row = sheet.createRow(startIndex + j);
//            row.setHeightInPoints(20);
//            //"日期", "存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"
//            for (int i = 0; i < headerList.size(); i++) {
//                //日期
//                Cell cellX = row.createCell(i);
//                if ("日期".equals(headerList.get(i))) {
//                    //根据当前传入kjnd，kjqj计算当月最后一天
//                    content = DateUtils.format(DateUtils.getLastDayOfMonth(kjnd,kjqj));
//                    // 日期设置宽度
//                    setColumnWidth(content, headerList.get(i), "日期", sheet, i);
//
//                } else if ("存货名称".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//                    // 存货名称设置宽度
//                    setColumnWidth(content, headerList.get(i), "存货名称", sheet, i);
//
//                } else if ("规格型号".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//                    // 规格型号设置宽度
//                    setColumnWidth(content, headerList.get(i), "规格型号", sheet, i);
//
//                } else if ("单位".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//                    // 单位设置宽度
//                    setColumnWidth(content, headerList.get(i), "单位", sheet, i);
//
//                } else if ("类别".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//                    // 类别设置宽度
//                    setColumnWidth(content, headerList.get(i), "类别", sheet, i);
//
//                } else if ("数量".equals(headerList.get(i))) {
//                    content = null == bean.getkSl() ? BigDecimal.ZERO .setScale(6).toPlainString() : bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 数量设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//                } else if ("单价".equals(headerList.get(i))) {
//                    content = null == bean.getkDj() ? BigDecimal.ZERO .setScale(6).toPlainString() : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 单价设置宽度
//                    setColumnWidth(content, headerList.get(i), "单价", sheet, i);
//
//                } else if ("金额".equals(headerList.get(i))) {
//                    content = null == bean.getkJe() ? BigDecimal.ZERO .setScale(2).toPlainString() : bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                }
//
//                // 写入单元格数据
//                setCellDataAndStyle(workbook, style, font, cellX, content, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            }
//        }
//        if(CollectionUtils.isNotEmpty(list)){
//            //合计
//            Integer hjRow = startIndex+list.size();
//            Row row = sheet.createRow(hjRow);
//            row.setHeightInPoints(20);
//            Cell cell = null;
//            for(int i = 0;i<5;i++){
//                cell = row.createCell(i);
//                setCellDataAndStyle(workbook, style, null, cell, "", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                        Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            }
//            sheet.addMergedRegion(new CellRangeAddress(hjRow, hjRow , 0, 4));
//            Cell cellHj = sheet.getRow(hjRow).getCell(0);
//            setCellDataAndStyle(workbook, style, null, cellHj, "合计", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            //数量，金额合计
//            String slHj = list.stream().filter(chCbjzb -> chCbjzb.getkSl()!=null).map(ChCbjzb::getkSl).reduce(BigDecimal.ZERO,BigDecimal::add).setScale(6,BigDecimal.ROUND_HALF_UP).toPlainString();
//            String jeHj = list.stream().filter(chCbjzb -> chCbjzb.getkJe()!=null).map(ChCbjzb::getkJe).reduce(BigDecimal.ZERO,BigDecimal::add).setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString();
//
//            setCellDataAndStyle(workbook, style, null, row.createCell(5), slHj, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(6), "——", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(7), jeHj, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//        }
//    }
//
//
//    /**
//     * 设置各个单元格的各种属性
//     *
//     * @param workBook     工作簿
//     * @param style        excel表格样式
//     * @param cell         单元格
//     * @param value        单元格内容
//     * @param align        单元格字体颜色
//     * @param align        单元格字体的对齐方式
//     * @param fontSize     单元格的字体的大小
//     * @param fontWeight   单元格字体的粗细样式
//     * @param topBorder    顶部边框
//     * @param bottomBorder 下部边框
//     * @param leftBordr    左侧边框
//     * @param rightBorder  右侧边框
//     */
//    private static void setCellDataAndStyle(SXSSFWorkbook workBook, CellStyle style, Font font, Cell cell, String value, short align, short fontColor,
//                                            short fontSize, short fontWeight, short topBorder, short bottomBorder, short leftBordr, short rightBorder) {
//        if (style == null) {
//            style = workBook.createCellStyle();
//        }
//        if (font == null) {
//            font = workBook.createFont(); //单元格的字体
//        }
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
//            style.setBorderLeft(leftBordr); //设置左边框
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
//    /**
//     * 为特殊列设定宽度
//     *
//     * @param content
//     * @param header
//     * @param headerBase
//     * @param sheet
//     * @param i
//     */
//    private static void setColumnWidth(String content, String header, String headerBase, Sheet sheet, int i) {
//
//        if (headerBase.equals(header)) {
//            // 特殊列明等于当前传入列名
//            if (content.getBytes().length > header.getBytes().length) {
//                // 当列值大于列名宽度 使用列值的宽度
//                sheet.setColumnWidth(i, content.getBytes().length* 500); // 设置单元格宽度
//            } else {
//                // 否则使用列名的宽度
//                sheet.setColumnWidth(i, header.getBytes().length * 500); // 设置单元格宽度
//            }
//        }
//    }
//
//
//    /**
//     * 材料领用汇总导出excel
//     *
//     * @param path
//     * @param qymc
//     * @paramC
//     */
//    public static void exportCllyhzbInfo(String path, List<ChLlscView> list, String qymc,Integer kjnd,Integer kjqj) throws Exception {
//        try {
//            SXSSFWorkbook wookBook = new SXSSFWorkbook(1000);
//            Sheet sheet = wookBook.createSheet("材料领用汇总表");
//
//            String[] headers = {"存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"};
//
//            Row headRow = sheet.createRow(0);
//            headRow.setHeightInPoints(25);
//            Cell cell = headRow.createCell(0);
//            // 四个参数分别是：起始行，结束行，起始列，结束列
//            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
//            CellStyle style = wookBook.createCellStyle();
//
////            //第一行数据
//            setCellDataAndStyle(wookBook, style, null, cell, qymc + "领用汇总表", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            //第二行 日期
//            Row row = sheet.createRow(1);
//            row.setHeightInPoints(20);
//            Cell cellX = row.createCell(0);
//            sheet.addMergedRegion(new CellRangeAddress(1, 1 , 0, 6));
//            setCellDataAndStyle(wookBook, style, null, cellX, kjnd+"年"+kjqj+"月", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            List<String> headerList = Arrays.asList(headers);
//            Map<String, CellRangeAddress> mergeParam = new HashMap<String, CellRangeAddress>();
//            for (int i = 0; i < headerList.size(); i++) {
//                mergeParam.put(headerList.get(i), new CellRangeAddress(1, 1, i, i));
//            }
//            // 设置表头数据
//            setExcelHeader(wookBook, sheet, 3, headerList, mergeParam);
//
//            // 设置excel内容数据
//            int startIndex = 3;
//            setExcelCllyhzbInfo(list, sheet, startIndex, headerList, wookBook);
//
//            FileOutputStream fileOut = null;
//            try {
//                path = path.replace("temp.xls", ".xls");
//                fileOut = new FileOutputStream(path);
//                wookBook.write(fileOut);
//            } finally {
//                if (fileOut != null) {
//                    fileOut.close();
//                    wookBook.dispose();
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw e;
//        }
//    }
//
//    /**
//     * 材料领用汇总excel内容
//     *
//     * @param
//     * @param sheet
//     * @param startIndex
//     * @param headerList
//     * @param workbook
//     */
//    private static void setExcelCllyhzbInfo(List<ChLlscView> list, Sheet sheet, int startIndex, List<String> headerList, SXSSFWorkbook workbook) {
//        CellStyle style = workbook.createCellStyle();
//        Font font = workbook.createFont();
//        for (int j = 0; j < list.size(); j++) {
//            ChLlscView bean = list.get(j);
//            String content = "";
//            Row row = sheet.createRow(startIndex + j);
//            row.setHeightInPoints(20);
//            //"日期", "存货名称", "规格型号", "单位", "类别", "数量", "单价", "金额"
//            for (int i = 0; i < headerList.size(); i++) {
//                //日期
//                Cell cellX = row.createCell(i);
//                if ("存货名称".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//                    // 存货名称设置宽度
//                    setColumnWidth(content, headerList.get(i), "存货名称", sheet, i);
//
//                } else if ("规格型号".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//                    // 规格型号设置宽度
//                    setColumnWidth(content, headerList.get(i), "规格型号", sheet, i);
//
//                } else if ("单位".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//                    // 单位设置宽度
//                    setColumnWidth(content, headerList.get(i), "单位", sheet, i);
//
//                } else if ("类别".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//                    // 类别设置宽度
//                    setColumnWidth(content, headerList.get(i), "类别", sheet, i);
//
//                } else if ("数量".equals(headerList.get(i))) {
//                    content = null == bean.getkSl() ? BigDecimal.ZERO .setScale(6).toPlainString() : bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 数量设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//
//                } else if ("单价".equals(headerList.get(i))) {
//                    content = null == bean.getkDj() ? BigDecimal.ZERO .setScale(6).toPlainString() : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 单价设置宽度
//                    setColumnWidth(content, headerList.get(i), "单价", sheet, i);
//
//                } else if ("金额".equals(headerList.get(i))) {
//                    content = null == bean.getkJe() ? BigDecimal.ZERO .setScale(2).toPlainString() : bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                }
//
//                // 写入单元格数据
//                setCellDataAndStyle(workbook, style, font, cellX, content, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            }
//        }
//        if(CollectionUtils.isNotEmpty(list)){
//            Integer hjRow = list.size()+3;
//            Row row = sheet.createRow(hjRow);
//            row.setHeightInPoints(20);
//            Cell cell = null;
//            for(int i = 0;i<4;i++){
//                cell = row.createCell(i);
//                setCellDataAndStyle(workbook, style, null, cell, "", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                        Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            }
//            sheet.addMergedRegion(new CellRangeAddress(hjRow, hjRow , 0, 3));
//            Cell cellHj = sheet.getRow(hjRow).getCell(0);
//            setCellDataAndStyle(workbook, style, null, cellHj, "合计", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            //数量，金额合计
//            String slHj = list.stream().filter(chLlsc->chLlsc.getkSl()!=null).map(ChLlsc::getkSl).reduce(BigDecimal.ZERO,BigDecimal::add).setScale(6,BigDecimal.ROUND_HALF_UP).toPlainString();
//            String jeHj = list.stream().filter(chLlsc->chLlsc.getkJe()!=null).map(ChLlsc::getkJe).reduce(BigDecimal.ZERO,BigDecimal::add).setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString();
//
//            setCellDataAndStyle(workbook, style, null, row.createCell(4), slHj, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(5), "——", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(6), jeHj, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//        }
//
//    }
//
//    /**
//     * 生产成本分摊表导出excel
//     *
//     * @param path
//     * @param qymc
//     * @paramC
//     */
//    public static void exportSccbftbInfo(String path, List<ChCh> list, String qymc,Integer kjnd,Integer kjqj) throws Exception {
//        try {
//            SXSSFWorkbook wookBook = new SXSSFWorkbook(1000);
//            Sheet sheet = wookBook.createSheet("生产成本分摊表");
//
//            String[] headers = {"名称", "规格型号", "单位", "类别", "数量", "销售收入", "成本单价", "成本", "直接材料", "直接人工", "制造费用", "其他费用"};
//
//            Row headRow = sheet.createRow(0);
//            headRow.setHeightInPoints(25);
//            Cell cell = headRow.createCell(0);
//            // 四个参数分别是：起始行，结束行，起始列，结束列
//            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
//            CellStyle style = wookBook.createCellStyle();
//            style.setFillBackgroundColor(HSSFColor.PALE_BLUE.index);
//            cell.setCellStyle(style);
////            //第一行数据
//            setCellDataAndStyle(wookBook, style, null, cell, qymc + "生产成本分摊", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            //第二行 日期
//            Row row = sheet.createRow(1);
//            row.setHeightInPoints(20);
//            Cell cellX = row.createCell(0);
//            sheet.addMergedRegion(new CellRangeAddress(1, 1 , 0, 11));
//            setCellDataAndStyle(wookBook, style, null, cellX, kjnd+"年"+kjqj+"月", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            List<String> headerList = Arrays.asList(headers);
//            Map<String, CellRangeAddress> mergeParam = new HashMap<String, CellRangeAddress>();
//            for (int i = 0; i < headerList.size(); i++) {
//                mergeParam.put(headerList.get(i), new CellRangeAddress(1, 1, i, i));
//            }
//            // 设置表头数据
//            setExcelHeader(wookBook, sheet, 3, headerList, mergeParam);
//
//            // 设置excel内容数据
//            int startIndex = 3;
//            setExcelSccbftbInfo(list, sheet, startIndex, headerList, wookBook);
//
//            FileOutputStream fileOut = null;
//            try {
//                path = path.replace("temp.xls", ".xls");
//                fileOut = new FileOutputStream(path);
//                wookBook.write(fileOut);
//            } finally {
//                if (fileOut != null) {
//                    fileOut.close();
//                    wookBook.dispose();
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw e;
//        }
//    }
//
//    /**
//     * 生产成本分摊表excel内容
//     *
//     * @param
//     * @param sheet
//     * @param startIndex
//     * @param headerList
//     * @param workbook
//     */
//    private static void setExcelSccbftbInfo(List<ChCh> list, Sheet sheet, int startIndex, List<String> headerList, SXSSFWorkbook workbook) {
//        CellStyle style = workbook.createCellStyle();
//        Font font = workbook.createFont();
//        for (int j = 0; j < list.size(); j++) {
//            ChCh bean = list.get(j);
//            //最后一行总合计不加
////            if(!"合计".equals(bean.getkChbh())) {
//            String content = "";
//            Row row = sheet.createRow(startIndex + j);
//            row.setHeightInPoints(20);
//            //"名称", "规格型号", "单位", "类别", "数量", "销售收入", "成本单价","成本","直接材料","直接人工","制造费用","其他费用"
//            for (int i = 0; i < headerList.size(); i++) {
//                Cell cellX = row.createCell(i);
//                if ("名称".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkChmc()) ? "" : bean.getkChmc();
//                    // 存货名称设置宽度
//                    setColumnWidth(content, headerList.get(i), "名称", sheet, i);
//
//                } else if ("规格型号".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//                    // 规格型号设置宽度
//                    setColumnWidth(content, headerList.get(i), "规格型号", sheet, i);
//
//                } else if ("单位".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//                    // 单位设置宽度
//                    setColumnWidth(content, headerList.get(i), "单位", sheet, i);
//
//                } else if ("类别".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getChlbmc()) ? "" : bean.getChlbmc();
//                    // 类别设置宽度
//                    setColumnWidth(content, headerList.get(i), "类别", sheet, i);
//
//                } else if ("数量".equals(headerList.get(i))) {
//                    content = null == bean.getkBqwgrksl() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkBqwgrksl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 数量设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//
//                } else if ("销售收入".equals(headerList.get(i))) {
//                    content = null == bean.getkBqxssr() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqxssr().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 单价设置宽度
//                    setColumnWidth(content, headerList.get(i), "销售收入", sheet, i);
//
//                } else if ("成本单价".equals(headerList.get(i))) {
//                    content = null == bean.getkDj() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "成本单价", sheet, i);
//                } else if ("成本".equals(headerList.get(i))) {
//                    content = null == bean.getkBqzcb() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqzcb().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "成本", sheet, i);
//                } else if ("直接材料".equals(headerList.get(i))) {
//                    content = null == bean.getkBqzjclcb() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqzjclcb().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "直接材料", sheet, i);
//                } else if ("直接人工".equals(headerList.get(i))) {
//                    content = null == bean.getkBqzjrgcb() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqzjrgcb().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "直接人工", sheet, i);
//                } else if ("制造费用".equals(headerList.get(i))) {
//                    content = null == bean.getkBqzzfycb() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqzzfycb().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "制造费用", sheet, i);
//                } else if ("其他费用".equals(headerList.get(i))) {
//                    content = null == bean.getkBqqtcb() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqqtcb().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "其他费用", sheet, i);
//                }
//
//                // 写入单元格数据
//                setCellDataAndStyle(workbook, style, font, cellX, content, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            }
//        }
//        //合计单元格
//        if (CollectionUtils.isNotEmpty(list)) {
//            Integer hjRow = list.size() + 2;
//            Cell cellX = sheet.getRow(hjRow).getCell(0);
//            sheet.addMergedRegion(new CellRangeAddress(hjRow, hjRow, 0, 3));
//            setCellDataAndStyle(workbook, style, null, cellX, "合计", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//        }
//    }
//
//    /**
//     * 出入库单明细导出excel
//     *
//     * @param path
//     * @param qymc
//     * @paramC
//     */
//    public static void exportCrkdmxbInfo(String path, List<ChDjView> list, String qymc) throws Exception {
//        try {
//            SXSSFWorkbook wookBook = new SXSSFWorkbook(1000);
//            Sheet sheet = wookBook.createSheet("出入库单明细表");
//
//            String[] headers = {"日期", "存货名称", "规格型号", "单位", "类别", "出入库类型", "数量", "单价", "金额", "总合计"};
//
//            Row headRow = sheet.createRow(0);
//            headRow.setHeightInPoints(25);
//            Cell cell = headRow.createCell(0);
////             四个参数分别是：起始行，结束行，起始列，结束列
//            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
//            CellStyle style = wookBook.createCellStyle();
//
////            //第一行数据
//            setCellDataAndStyle(wookBook, style, null, cell, qymc + "出入库单明细表", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            List<String> headerList = Arrays.asList(headers);
//            Map<String, CellRangeAddress> mergeParam = new HashMap<String, CellRangeAddress>();
//            for (int i = 0; i < headerList.size(); i++) {
//                mergeParam.put(headerList.get(i), new CellRangeAddress(1, 1, i, i));
//            }
//            // 设置表头数据
//            setExcelHeader(wookBook, sheet, 2, headerList, mergeParam);
//
//            // 设置excel内容数据
//            int startIndex = 2;
//            setExcelCrkdmxbInfo(list, sheet, startIndex, headerList, wookBook);
//
//            FileOutputStream fileOut = null;
//            try {
//                path = path.replace("temp.xls", ".xls");
//                fileOut = new FileOutputStream(path);
//                wookBook.write(fileOut);
//            } finally {
//                if (fileOut != null) {
//                    fileOut.close();
//                    wookBook.dispose();
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw e;
//        }
//    }
//
//    /**
//     * 出入库单明细excel内容
//     *
//     * @param
//     * @param sheet
//     * @param startIndex
//     * @param headerList
//     * @param workbook
//     */
//    private static void setExcelCrkdmxbInfo(List<ChDjView> list, Sheet sheet, int startIndex, List<String> headerList, SXSSFWorkbook workbook) {
//        CellStyle style = workbook.createCellStyle();
//        Font font = workbook.createFont();
//        int rows = 0;
//        int startRows = 0;
//        int hjRows = 0;
//        BigDecimal slHj = BigDecimal.ZERO;
//        BigDecimal jeHj = BigDecimal.ZERO;
//
//        for (ChDjView chDjView : list) {
//            List<ChDjmx> chDjmxList = chDjView.getChDjmxList();
//
//            startRows = startIndex + rows;
//            for (ChDjmx bean : chDjmxList) {
//                Row row = sheet.createRow(startIndex + rows);
//                rows++;
//                hjRows++;
//                row.setHeightInPoints(20);
////                "日期", "存货名称", "规格型号", "单位", "类别", "出入库类型", "数量","单价","金额","总合计"
//                for (int i = 0; i < headerList.size(); i++) {
//                    String content = "";
//                    //日期
//
//                    Cell cellX = row.createCell(i);
//
//                    if ("存货名称".equals(headerList.get(i))) {
//                        content = StringUtil.isBlank(bean.getkChmc()) ? "" : bean.getkChmc();
//                        // 规格型号设置宽度
//                        setColumnWidth(content, headerList.get(i), "存货名称", sheet, i);
//
//                    } else if ("规格型号".equals(headerList.get(i))) {
//                        content = StringUtils.isEmpty(bean.getkGgxh()) ? "" : bean.getkGgxh();
//                        // 单位设置宽度
//                        setColumnWidth(content, headerList.get(i), "规格型号", sheet, i);
//
//                    } else if ("单位".equals(headerList.get(i))) {
//                        content = StringUtil.isBlank(bean.getkJldw()) ? "" : bean.getkJldw();
//                        // 类别设置宽度
//                        setColumnWidth(content, headerList.get(i), "单位", sheet, i);
//
//                    } else if ("类别".equals(headerList.get(i))) {
//                        content = StringUtil.isBlank(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//                        // 类别设置宽度
//                        setColumnWidth(content, headerList.get(i), "类别", sheet, i);
//
//                    }
//                    else if ("数量".equals(headerList.get(i))) {
//                        content = null == bean.getkSl() ? BigDecimal.ZERO .setScale(6).toPlainString() : bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                        // 单价设置宽度
//                        setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//                        if(null != bean.getkSl()){
//                            slHj = slHj.add(bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP));
//                        }
//
//                    } else if ("单价".equals(headerList.get(i))) {
//                        content = null == bean.getkDj() ? BigDecimal.ZERO .setScale(6).toPlainString() : bean.getkDj().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                        // 金额设置宽度
//                        setColumnWidth(content, headerList.get(i), "单价", sheet, i);
//                    } else if ("金额".equals(headerList.get(i))) {
//                        content = null == bean.getkJe() ? BigDecimal.ZERO .setScale(2).toPlainString() : bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                        // 金额设置宽度
//                        setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                        if(null != bean.getkJe()){
//                            jeHj = jeHj.add(bean.getkJe().setScale(2, BigDecimal.ROUND_HALF_UP));
//                        }
//                    }
//
//                    // 写入单元格数据
//                    setCellDataAndStyle(workbook, style, font, cellX, content, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                            Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//
//                }
//
//            }
//
//            //统一处理
//            //日期
//            sheet.addMergedRegion(new CellRangeAddress(startRows, startRows + chDjmxList.size() - 1 , 0, 0));
//            Cell dataCell = sheet.getRow(startRows).getCell(0);
//            String dataContent = chDjmxList.get(0).getkZdrq() == null ? "" : DateUtils.format(chDjmxList.get(0).getkZdrq());
//            sheet.setColumnWidth(0,dataContent.getBytes().length * 450);
//            dataCell.setCellValue(dataContent);
//
//            //出入库类型
//            sheet.addMergedRegion(new CellRangeAddress(startRows, startRows + chDjmxList.size() - 1 , 5, 5));
//            Cell lxCell = sheet.getRow(startRows).getCell(5);
//            String lxContent =  StringUtil.isBlank(chDjmxList.get(0).getkYwlxmc()) ? "" : chDjmxList.get(0).getkYwlxmc();
//            sheet.setColumnWidth(0,lxContent.getBytes().length * 450);
//            lxCell.setCellValue(lxContent);
//
//            //总合计
//            sheet.addMergedRegion(new CellRangeAddress(startRows, startRows + chDjmxList.size() - 1 , 9, 9));
//            Cell hjCell = sheet.getRow(startRows).getCell(9);
//            String hjContent =  chDjView.getJehj() == null ? BigDecimal.ZERO.setScale(2).toPlainString() : chDjView.getJehj().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//            if(hjContent.getBytes().length>"总合计".getBytes().length){
//                sheet.setColumnWidth(0,hjContent.getBytes().length * 450);
//            }else{
//                sheet.setColumnWidth(0,"总合计".getBytes().length * 450);
//            }
//            hjCell.setCellValue(hjContent);
//
//        }
//        if(CollectionUtils.isNotEmpty(list)){
//            //合计
//            Integer hjRow = hjRows+2;
//            Row row = sheet.createRow(hjRow);
//            row.setHeightInPoints(20);
//            Cell cell = null;
//            for(int i = 0;i<6;i++){
//                cell = row.createCell(i);
//                setCellDataAndStyle(workbook, style, null, cell, "", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                        Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            }
//            sheet.addMergedRegion(new CellRangeAddress(hjRow, hjRow , 0, 5));
//
//            Cell cellHj = sheet.getRow(hjRow).getCell(0);
//            setCellDataAndStyle(workbook, style, null, cellHj, "合计", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(6), slHj.toPlainString(), HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(7), "——", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(8), jeHj.toPlainString(), HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            String zhj = list.stream().filter(chDjView -> chDjView.getJehj()!=null).map(ChDjView::getJehj).reduce(BigDecimal.ZERO,BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//            setCellDataAndStyle(workbook, style, null, row.createCell(9), zhj, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//        }
//    }
//
//    /**
//     * 库存汇总导出excel
//     *
//     * @param path
//     * @param qymc
//     * @paramC
//     */
//    public static void exportHcyebInfo(String path, List<ChHz> list, String qymc,Integer kjnd,Integer kjqj) throws Exception {
//        try{
//            SXSSFWorkbook wookBook = new SXSSFWorkbook(1000);
//            Sheet sheet = wookBook.createSheet("库存汇总");
//
//            Row headRow = sheet.createRow(0);
//            headRow.setHeightInPoints(25);
//            Cell cell = headRow.createCell(0);
//            // 四个参数分别是：起始行，结束行，起始列，结束列
//            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 15));
//            CellStyle style = wookBook.createCellStyle();
//
//            //第一行数据
//            setCellDataAndStyle(wookBook, style, null, cell, qymc + "领用汇总表", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            //第二行 日期
//            Row row = sheet.createRow(1);
//            row.setHeightInPoints(20);
//            Cell cellX = row.createCell(0);
//            sheet.addMergedRegion(new CellRangeAddress(1, 1 , 0, 15));
//            setCellDataAndStyle(wookBook, style, null, cellX, kjnd+"年"+kjqj+"月", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            //"存货名称", "规格型号", "单位", "类别", "期初库存数量", "期初库存单价", "期初库存金额" ,  "本期入库数量","本期入库金额","暂估入库数量","暂估入库金额","本期出库数量","本期出库金额",  "期末库存数量", "期末库存单价", "期末库存金额"
//            String[] firstHeaders = { "存货名称", "规格型号", "单位", "类别","期初库存","本期入库","暂估入库","本期出库","期末库存"};
//            String[] secondHeader = { "期初库存*数量", "期初库存*单价", "期初库存*金额","本期入库*数量","本期入库*金额","暂估入库*数量","暂估入库*金额","本期出库*数量","本期出库*金额", "期末库存*数量","期末库存*单价","期末库存*金额"};
//            String[] headers =      { "存货名称", "规格型号", "单位", "类别","期初库存数量", "期初库存单价", "期初库存金额","本期入库数量","本期入库金额","暂估入库数量","暂估入库金额","本期出库数量","本期出库金额", "期末库存数量","期末库存单价","期末库存金额"};
//
//            //  表头数据
//            List<String> fHeaderList = Arrays.asList(firstHeaders);
//            Map<String, CellRangeAddress> mergeParam = new HashMap<String, CellRangeAddress>();
//            int contentFirstRow = 2;
//            for (int i = 0; i < fHeaderList.size(); i++) {
//                if (i <= 3) {
//                    mergeParam.put(fHeaderList.get(i), new CellRangeAddress(contentFirstRow, contentFirstRow+1, i, i));
//                } else if (fHeaderList.get(i).equals("期初库存")) {
//                    // 期初库存
//                    mergeParam.put(fHeaderList.get(i), new CellRangeAddress(contentFirstRow, contentFirstRow,  4, 6));
//                }else if (fHeaderList.get(i).equals("本期入库")) {
//                    // 本期入库
//                    mergeParam.put(fHeaderList.get(i), new CellRangeAddress(contentFirstRow, contentFirstRow,  7, 8));
//                }
//                else if (fHeaderList.get(i).equals("暂估入库")) {
//                    // 暂估入库
//                    mergeParam.put(fHeaderList.get(i), new CellRangeAddress(contentFirstRow, contentFirstRow, 9, 10));
//                }
//              else if (fHeaderList.get(i).equals("本期出库")) {
//                    // 本期出库
//                    mergeParam.put(fHeaderList.get(i), new CellRangeAddress(contentFirstRow, contentFirstRow, 11, 12));
//                }else if (fHeaderList.get(i).equals("期末库存")) {
//                    // 期末库存
//                    mergeParam.put(fHeaderList.get(i), new CellRangeAddress(contentFirstRow, contentFirstRow, 13, 15));
//                }
//            }
//
//            // 设置第一行表头数据 (firstHeaders{})
//            setHcyebExcelHeader(wookBook, sheet, contentFirstRow+1, fHeaderList, mergeParam);
//
//            // 第二行表头数据
//            List<String> sHeaderList = Arrays.asList(secondHeader);
//            Map<String, CellRangeAddress> merge2Param = new HashMap<String, CellRangeAddress>();
//            for (int i = 0; i < sHeaderList.size(); i++) {
//                merge2Param.put(sHeaderList.get(i), new CellRangeAddress(contentFirstRow+1, contentFirstRow+1, i + 4, i + 4));
//            }
//            // 设置第二行表头数据(secondHeader{})
//            setHcyebExcelHeader(wookBook, sheet, contentFirstRow+2, sHeaderList, merge2Param);
//
//            for (String fHead : fHeaderList) {
//                sheet.addMergedRegion(mergeParam.get(fHead));
//            }
//
//            // 设置excel内容数据
//            int startIndex = contentFirstRow+2;
//            List<String> headerList = Arrays.asList(headers);
//            setExcelHcyebInfo(list, sheet, startIndex, headerList, wookBook);
//
//            FileOutputStream fileOut = null;
//            try {
//                path = path.replace("temp.xls", ".xls");
//                fileOut = new FileOutputStream(path);
//                wookBook.write(fileOut);
//            } finally {
//                if (fileOut != null) {
//                    fileOut.close();
//                    wookBook.dispose();
//                }
//            }
//
//        }
//        catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw e;
//        }
//    }
//
//    /**
//     * 设置库存汇总excel表头数据
//     *
//     * @param workbook
//     * @param sheet
//     * @param startIndex
//     * @param headerList
//     */
//    private static void setHcyebExcelHeader(SXSSFWorkbook workbook, Sheet sheet, int startIndex, List<String> headerList,
//                                       Map<String, CellRangeAddress> mergeParam) {
//
//        CellStyle style = workbook.createCellStyle();
//        Row headrow = sheet.createRow(startIndex - 1); //获取需要写入的表头行
//        Row headNextRow = sheet.createRow(startIndex); //获取需要写入的表头行另一行
//        headrow.setHeightInPoints(22);
//        headNextRow.setHeightInPoints(22);
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //设置垂直对齐方式
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //单元的样式设置为居中对齐
//        style.setBorderBottom((short) 1); //设置下部边框
//        style.setBorderLeft((short) 1); //设置左部边框
//        style.setBorderRight((short) 1); //设置右部边框
//        style.setBorderTop((short) 1); //设置顶部边框
//
//        Font font = workbook.createFont();
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD); //设置字体的大小和样式
//        font.setFontHeightInPoints((short) 11);
//        style.setFont(font);
//
//        //设置第一行表头数据
//        for (int i = 0; i < headerList.size(); i++) {
//            int index = mergeParam.get(headerList.get(i)).getFirstColumn();
//            if (headerList.get(i).equals("期初库存")) {
//                // 为了空白格子做处理
//                for (int j = mergeParam.get("期初库存").getFirstColumn() + 1; j < mergeParam.get("期初库存").getLastColumn() + 1; j++) {
//                    Cell cell = headrow.createCell(j);
//                    cell.setCellStyle(style);
//                }
//            }else if(headerList.get(i).equals("本期入库")){
//                // 为了空白格子做处理
//                for (int j = mergeParam.get("本期入库").getFirstColumn() + 1; j < mergeParam.get("本期入库").getLastColumn() + 1; j++) {
//                    Cell cell = headrow.createCell(j);
//                    cell.setCellStyle(style);
//                }
//            }else if(headerList.get(i).equals("暂估入库")){
//                // 为了空白格子做处理
//                for (int j = mergeParam.get("暂估入库").getFirstColumn() + 1; j < mergeParam.get("暂估入库").getLastColumn() + 1; j++) {
//                    Cell cell = headrow.createCell(j);
//                    cell.setCellStyle(style);
//                }
//            }else if(headerList.get(i).equals("本期出库")){
//                // 为了空白格子做处理
//                for (int j = mergeParam.get("本期出库").getFirstColumn() + 1; j < mergeParam.get("本期出库").getLastColumn() + 1; j++) {
//                    Cell cell = headrow.createCell(j);
//                    cell.setCellStyle(style);
//                }
//            }else if(headerList.get(i).equals("期末库存")){
//                // 为了空白格子做处理
//                for (int j = mergeParam.get("期末库存").getFirstColumn() + 1; j < mergeParam.get("期末库存").getLastColumn() + 1; j++) {
//                    Cell cell = headrow.createCell(j);
//                    cell.setCellStyle(style);
//                }
//            }
//            String cellValue =  headerList.get(i);
//            if (StringUtil.isNotBlank(cellValue) && cellValue.indexOf("*") != -1) {
//                String[] arr = cellValue.split("[*]");
//                List list = Arrays.asList(arr);
//                cellValue = (String) list.get(list.size() - 1);
//            }
//            Cell cell = headrow.createCell(index);
//            cell.setCellStyle(style);
//            cell.setCellValue(cellValue);
//            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            style.setFillForegroundColor(new HSSFColor.PALE_BLUE().getIndex());
//            sheet.setColumnWidth(i, headerList.get(i).getBytes().length * 256); // 设置单元格宽度
//        }
//
//    }
//
//    /**
//     * 库存汇总excel内容
//     *
//     * @param
//     * @param sheet
//     * @param startIndex
//     * @param headerList/chhzList
//     * @param workbook
//     */
//    private static void setExcelHcyebInfo(List<ChHz> list, Sheet sheet, int startIndex, List<String> headerList, SXSSFWorkbook workbook) {
//        CellStyle style = workbook.createCellStyle();
//        Font font = workbook.createFont();
//
//        for (int j = 0; j < list.size(); j++) {
//            ChHz bean = list.get(j);
//            String content = "";
//            Row row = sheet.createRow(startIndex + j);
//            row.setHeightInPoints(20);
//            //"存货名称", "规格型号", "单位", "类别","期初库存数量", "期初库存单价", "期初库存金额","本期入库数量","本期入库金额","暂估入库数量","暂估入库金额","本期出库数量","本期出库金额", "期末库存数量","期末库存单价","期末库存金额"
//            for (int i = 0; i < headerList.size(); i++) {
//
//                Cell cellX = row.createCell(i);
//                if ("存货名称".equals(headerList.get(i))) {
//                    content = null == bean.getkChmc() ? "" : bean.getkChmc();
//                    // 存货名称设置宽度
//                    setColumnWidth(content, headerList.get(i), "存货名称", sheet, i);
//
//                } else if ("规格型号".equals(headerList.get(i))) {
//                    content = StringUtil.isBlank(bean.getkGgxh()) ? "" : bean.getkGgxh();
//                    // 规格型号设置宽度
//                    setColumnWidth(content, headerList.get(i), "规格型号", sheet, i);
//
//                } else if ("单位".equals(headerList.get(i))) {
//                    content = StringUtils.isEmpty(bean.getkJldw()) ? "" : bean.getkJldw();
//                    // 单位设置宽度
//                    setColumnWidth(content, headerList.get(i), "单位", sheet, i);
//
//                } else if ("类别".equals(headerList.get(i))) {
//                    content = StringUtil.isBlank(bean.getkChlbmc()) ? "" : bean.getkChlbmc();
//                    // 类别设置宽度
//                    setColumnWidth(content, headerList.get(i), "类别", sheet, i);
//
//                } else if ("期初库存数量".equals(headerList.get(i))) {
//                    content = null == bean.getkQcjcsl() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkQcjcsl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 数量设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
////                    if(null != bean.getkQcjcsl()){
////                        qcHjSl = qcHjSl.add(bean.getkSl().setScale(6, BigDecimal.ROUND_HALF_UP));
////                    }
//                } else if ("期初库存单价".equals(headerList.get(i))) {
//                    content = null == bean.getkQcjcdj() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkQcjcdj().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 单价设置宽度
//                    setColumnWidth(content, headerList.get(i), "单价", sheet, i);
//
//                } else if ("期初库存金额".equals(headerList.get(i))) {
//                    content = null == bean.getkQcjcje() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkQcjcje().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                } else if ("本期入库数量".equals(headerList.get(i))) {
//                    content = null == bean.getkBqrksl() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkBqrksl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//                } else if ("本期入库金额".equals(headerList.get(i))) {
//                    content = null == bean.getkBqrkje() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqrkje().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                } else if ("暂估入库数量".equals(headerList.get(i))) {
//                    content = null == bean.getkZgrksl() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkZgrksl().setScale(6).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//                } else if ("暂估入库金额".equals(headerList.get(i))) {
//                    content = null == bean.getkZgrkje() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkZgrkje().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                } else if ("本期出库数量".equals(headerList.get(i))) {
//                    content = null == bean.getkBqcksl() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkBqcksl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//                } else if ("本期出库金额".equals(headerList.get(i))) {
//                    content = null == bean.getkBqckje() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkBqckje().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                } else if ("期末库存数量".equals(headerList.get(i))) {
//                    content = null == bean.getkQmjcsl() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkQmjcsl().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "数量", sheet, i);
//                } else if ("期末库存单价".equals(headerList.get(i))) {
//                    content = null == bean.getkQmjcdj() ? BigDecimal.ZERO.setScale(6).toPlainString() : bean.getkQmjcdj().setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "单价", sheet, i);
//                } else if ("期末库存金额".equals(headerList.get(i))) {
//                    content = null == bean.getkQmjcje() ? BigDecimal.ZERO.setScale(2).toPlainString() : bean.getkQmjcje().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//                    // 金额设置宽度
//                    setColumnWidth(content, headerList.get(i), "金额", sheet, i);
//                }
//
//                // 写入单元格数据
//                setCellDataAndStyle(workbook, style, font, cellX, content, HSSFCellStyle.ALIGN_LEFT, HSSFColor.BLACK.index, (short) 10,
//                        Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            }
//        }
//
//        if (CollectionUtils.isNotEmpty(list)) {
//            //合计
//            Integer hjRow = list.size() + startIndex;
//            Row row = sheet.createRow(hjRow);
//            row.setHeightInPoints(20);
//            Cell cell = null;
//            for (int i = 0; i < 4; i++) {
//                cell = row.createCell(i);
//                setCellDataAndStyle(workbook, style, null, cell, "", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                        Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//            }
//            sheet.addMergedRegion(new CellRangeAddress(hjRow, hjRow, 0, 3));
//            Cell cellHj = sheet.getRow(hjRow).getCell(0);
//            setCellDataAndStyle(workbook, style, null, cellHj, "合计", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_BOLD, (short) -1, (short) -1, (short) -1, (short) -1);
//
//            //数量，金额合计
//            String qcHjSl = list.stream().filter(chHz -> chHz.getkQcjcsl() != null).map(ChHz::getkQcjcsl).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String qcHjJe = list.stream().filter(chHz -> chHz.getkQcjcje() != null).map(ChHz::getkQcjcje).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String bqrkHjSl = list.stream().filter(chHz -> chHz.getkBqrksl() != null).map(ChHz::getkBqrksl).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String bqrkHjJe = list.stream().filter(chHz -> chHz.getkBqrkje() != null).map(ChHz::getkBqrkje).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String zgHjSl = list.stream().filter(chHz -> chHz.getkZgrksl() != null).map(ChHz::getkZgrksl).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String zgHjJe = list.stream().filter(chHz -> chHz.getkZgrkje() != null).map(ChHz::getkZgrkje).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String bqckHjSl = list.stream().filter(chHz -> chHz.getkBqcksl() != null).map(ChHz::getkBqcksl).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String bqckHjJe = list.stream().filter(chHz -> chHz.getkBqckje() != null).map(ChHz::getkBqckje).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String qmHjSl = list.stream().filter(chHz -> chHz.getkQmjcsl() != null).map(ChHz::getkQmjcsl).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(6, BigDecimal.ROUND_HALF_UP).toPlainString();
//            String qmHjJe = list.stream().filter(chHz -> chHz.getkQmjcje() != null).map(ChHz::getkQmjcje).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//
//            setCellDataAndStyle(workbook, style, null, row.createCell(4), qcHjSl, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(5), "——", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(6), qcHjJe, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(7), bqrkHjSl, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(8), bqrkHjJe, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(9), zgHjSl, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(10), zgHjJe, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(11), bqckHjSl, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(12), bqckHjJe, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(13), qmHjSl, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) 1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(14), "——", HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//            setCellDataAndStyle(workbook, style, null, row.createCell(15), qmHjJe, HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLACK.index, (short) 12,
//                    Font.BOLDWEIGHT_NORMAL, (short) -1, (short) -1, (short) -1, (short) -1);
//        }
//    }
//
}
