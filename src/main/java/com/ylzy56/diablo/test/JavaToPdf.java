package com.ylzy56.diablo.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.apache.poi.ss.util.CellUtil.FONT;

/**
 * Created by lujianing on 2017/5/7.
 */
public class JavaToPdf {

    private static final String DEST = "target/HelloWorld.pdf";
    private static final String FONT = "ht.TTF";


    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        Font f1 = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        document.add(new Paragraph("丁涛是小狗",f1));
        document.close();
        writer.close();
    }
}
