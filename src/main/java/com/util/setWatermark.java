package com.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class setWatermark {

    public static void setWatermark(BufferedOutputStream bos, InputStream input,
                                    String waterMarkName, String watermark, int permission) throws DocumentException,
            IOException {
        PdfReader reader = new PdfReader(input);
        PdfStamper stamper = new PdfStamper(reader, bos);
        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);
        PdfGState gs = new PdfGState();
        for (int i = 1; i < total; i++) {
//                content = stamper.getOverContent(i);// 在内容上方加水印
            content = stamper.getUnderContent(i);//在内容下方加水印
            gs.setFillOpacity(0.2f);
            // content.setGState(gs);
            content.beginText();
//                content.setColorStroke(BaseColor.WHITE);
            content.setColorFill(BaseColor.LIGHT_GRAY);
            content.setFontAndSize(base, 50);
            content.setTextMatrix(70, 200);
            content.showTextAligned(Element.ALIGN_CENTER, watermark, 300,350, 55);
//            Image image = Image.getInstance("D:/fish.jpg");
			/*img.setAlignment(Image.LEFT | Image.TEXTWRAP);
			img.setBorder(Image.BOX);
			img.setBorderWidth(10);
			img.setBorderColor(BaseColor.WHITE);
			img.scaleToFit(1000, 72);//大小
			img.setRotationDegrees(-30);//旋转 */
//            image.setAbsolutePosition(200, 206); // set the first background image of the absolute
//            image.scaleToFit(200,200);
//
////                image.setTransparency();
//            content.addImage(image);

            content.setColorFill(BaseColor.BLACK);
            content.setFontAndSize(base, 8);
            content.showTextAligned(Element.ALIGN_CENTER, "下载时间："
                    + waterMarkName + "", 300, 10, 0);
            content.endText();

        }
        stamper.close();
    }



}
