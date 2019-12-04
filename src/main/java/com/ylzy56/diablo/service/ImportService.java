package com.ylzy56.diablo.service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class ImportService {





    /*
     * 比较两个时间点相差多少年。
     */
    public int[] compareTime(Date entryDate){
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(new Date());
        end.setTime(entryDate);

        if (start.getTimeInMillis() > end.getTimeInMillis()){
            start.setTime(entryDate);
            end.setTime(new Date());
        }
        int year=end.get(Calendar.YEAR)-start.get(Calendar.YEAR);
        int month=end.get(Calendar.MONTH)-start.get(Calendar.MONTH);
        int day=end.get(Calendar.DAY_OF_MONTH)-start.get(Calendar.DAY_OF_MONTH);
        if (day <0){
            month-=1;
            day+=30;
        }
        if(month>=0){

            if(day>=0){

            }else{
                month-=1;
                day+=30;
            }
        }else{
            year-=1;
            month+=12;
        }
        int[] ints = {year,month,day};
        return ints;

    }


    /**
     * 处理上传的文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public List<List<String>> getBankListByExcel(InputStream in, String fileName) throws Exception {
        List<List<String>> list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = 2; j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<String> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
//                    cell.setCellType(CellType.STRING);
                    cell = row.getCell(y);
                    String cellString = getCellString(cell);
                    li.add(cellString);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    //把EXCEL Cell原有数据转换成String类型
    private String getCellString(Cell cell) {
        if(cell==null) return "";

        String cellSring="";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING: // 字符串
                cellSring = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                double d = cell.getNumericCellValue();
                NumberFormat nf = NumberFormat.getInstance();
                cellSring = nf.format(d);
//                cellSring=String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell)){

                    Date date = cell.getDateCellValue();

                    DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");//HH:mm:ss

                    cellSring = df2.format(date);
                }
                break;

            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                cellSring=String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_FORMULA: // 公式
                cellSring=String.valueOf(cell.getCellFormula());
                break;
            case HSSFCell.CELL_TYPE_BLANK: // 空值
                cellSring="";
                break;
            case HSSFCell.CELL_TYPE_ERROR: // 故障
                cellSring="";
                break;
            default:
                cellSring="ERROR";
                break;
        }
        return cellSring;
    }





    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }



    /**
     * 根据身份证的号码算出当前身份证持有者的性别和年龄 18位身份证
     *
     * @return
     * @throws Exception
     */
//    public static Map<String, Object> getCarInfo(String CardCode)throws Exception {
//        if (CardCode.length()==15){
//            return getCarInfo15W(CardCode);
//        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        String sex;
//        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
//            sex = "女";
//        } else {
//            sex = "男";
//        }
//        int year=Integer.parseInt(CardCode.substring(6, 10));
//        String zodia[]={"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
//        int i=(year-4)%12;
//        //获取生肖
//        String value=zodia[i];
//
//        //获取户籍
//        String nativePlace= NativePlace.getNativePlace(Integer.valueOf(CardCode.substring(0,6)));
//        map.put("sex", sex);
//        map.put("birthday",CardCode.substring(6, 14));
//        map.put("animalZodiac",value);
//        map.put("nativePlace",nativePlace);
//        return map;
//    }

    /**
     * 15位身份证的验证
     *
     * @param
     * @throws Exception
     */
//    public static Map<String, Object> getCarInfo15W(String card)
//            throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        String uyear = "19" + card.substring(6, 8);// 年份
//        String uyue = card.substring(8, 10);// 月份
//        // String uday=card.substring(10, 12);//日
//        String usex = card.substring(14, 15);// 用户的性别
//        String sex;
//        if (Integer.parseInt(usex) % 2 == 0) {
//            sex = "女";
//        } else {
//            sex = "男";
//        }
//        Date date = new Date();// 得到当前的系统时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String fyear = format.format(date).substring(0, 4);// 当前年份
//        String fyue = format.format(date).substring(5, 7);// 月份
////         String fday=format.format(date).substring(8,10);
//        int age = 0;
//        if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
//            age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;
//        } else {// 当前用户还没过生
//            age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
//        }
//
//        String zodia[]={"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
//        int i=(Integer.valueOf(uyear)-4)%12;
//        String value=zodia[i];
//
//        //获取户籍
//        String nativePlace= NativePlace.getNativePlace(Integer.valueOf(card.substring(0,6)));
//        map.put("sex", sex);
//        map.put("birthday","19"+card.substring(6, 12));
//        map.put("animalZodiac",value);
//        map.put("nativePlace",nativePlace);
//        return map;
//    }
}
