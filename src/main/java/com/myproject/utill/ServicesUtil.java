package com.myproject.utill;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Contains utility functions to be used by Services
 * 
 * @author VINU
 * @version R1
 */

public class ServicesUtil {

	public static final String NOT_APPLICABLE = "N/A";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	public static boolean isEmptyNumber(Integer str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	

	public static boolean isEmpty(String str) {

		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(BigDecimal o) {
		if (o == null || BigDecimal.ZERO.compareTo(o) == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Collection<?> o) {
		if (o == null || o.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Integer num) {
		if ((num == null) || (num == 0)) {
			return true;
		}
		return false;
	}

	public static HashMap<String , String> generateEAN13BarcodeImage(String barcodeText) {
		HashMap<String , String> response = new HashMap<>();
		Document document = new Document();
		String url = "C:\\Barcodes\\"+barcodeText+".pdf";
		response.put("FilePath" , url);
		try{
			new File("C:\\Barcodes").mkdir();
		   PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url));
		   document.open();
		   PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
		   BarcodeEAN barcodeEAN = new BarcodeEAN();
		   barcodeEAN.setCodeType(BarcodeEAN.EAN13);
		   barcodeEAN.setCode(barcodeText);
		   Image codeEANImage = barcodeEAN.createImageWithBarcode(pdfContentByte, null, null);
//		   codeEANImage.setAbsolutePosition(20, 600);
//		   codeEANImage.scalePercent(100);
		   document.add(codeEANImage);
			document.close();
			String img = Base64.getEncoder().encodeToString(Files.readAllBytes(new File(url).toPath()));
			response.put("Barcode" , img);
			return response;
	   }catch(Exception e){
		   System.err.println(e.getMessage());
	   }
	   return null;
	}
	
	public static long generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
}
