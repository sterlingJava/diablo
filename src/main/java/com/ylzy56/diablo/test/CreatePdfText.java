package com.ylzy56.diablo.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ylzy56.diablo.common.utils.PdfFontUtils;
import com.ylzy56.diablo.common.utils.StringTimeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreatePdfText {
    
    public static void main(String[] args) {
        System.out.println("===========start=============");
        try {
            Document doc = createPdf("F:\\test\\test.pdf");
            //生成  合同文件
            createFile(doc);
            createImage(doc);
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===========end=============");
    }
    
    /**
     * 创建一个pdf并打开
     * @param outpath  pdf路径
     */
    public static Document createPdf(String outpath) throws DocumentException, IOException {
        //页面大小
        //Rectangle rect = new Rectangle(PageSize.A4.rotate());//文档横方向
        Rectangle rect = new Rectangle(PageSize.A4);//文档竖方向
        //如果没有则创建
        File saveDir = new File(outpath);
        File dir = saveDir.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Document doc = new Document(rect);
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(outpath));
        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
        //文档属性
        doc.addTitle("Title@wpixel");
        doc.addAuthor("Author@wpixel");
        doc.addSubject("Subject@wpixel");
        doc.addKeywords("Keywords@wpixel");
        doc.addCreator("Creator@wpixel");
        //页边空白
        doc.setMargins(40, 40, 40, 40);
        //打开文档
        doc.open();
        return doc;
    }
    
    public static void createFile(Document doc) throws DocumentException{
        doc.add(PdfFontUtils.getFont(1, "合作协议"));
        doc.add(PdfFontUtils.getFont(6, "甲方： 小丁涛"));
        doc.add(PdfFontUtils.getFont(6, "乙方： 大丁涛"));
        doc.add(PdfFontUtils.getFont(6, "时间："+ StringTimeUtils.getTimeString()));
        doc.add(PdfFontUtils.getFont(6, "地点： 南京市建邺区"));
        Paragraph text05 = PdfFontUtils.getFont(5, "《根据中华人民共和国合同法》的有关规定，经甲、乙双方友好协商，本着长期平等合作.....吧啦吧啦吧啦吧啦吧啦吧啦吧啦吧啦");
        doc.add(text05);
        
        //一、合作方式及条件
        doc.add(PdfFontUtils.getFont(2, "一、合作方式及条件"));
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.双方本着密切配合、分工协作、保证质量、按期完成的原则，共同做好工作。 "));
        
        //二、权利义务
        doc.add(PdfFontUtils.getFont(2, "二、权利义务"));
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.双方本着密切配合、分工协作、保证质量、按期完成的原则，共同做好工作。 "));
        
        //三、其他
        doc.add(PdfFontUtils.getFont(2, "三、其他"));
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.自定义 "));
        
        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "甲方：（盖章）")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "乙方：（盖章）")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "法定代表人或负责人签章")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "法定代表人或负责人签章")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "地址：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "地址：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "开户银行：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "开户银行：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "邮编：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "邮编：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "授权代理人：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "项目经理：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "电话：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell.setBorder(Rectangle.NO_BORDER);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "电话：")));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        doc.add(table);
    }

    public static void createImage(Document doc) throws DocumentException, IOException {
        Image image1 = Image.getInstance("C:\\Users\\yf\\Desktop\\bizhi\\bd_logo.png");
        // 设置图片位置的x轴和y周
        image1.setAbsolutePosition(300f, 100f);
        // 设置图片的宽度和高度
        image1.scaleAbsolute(200, 100);
        // 将图片1添加到pdf文件中
        doc.add(image1);
    }
    
}