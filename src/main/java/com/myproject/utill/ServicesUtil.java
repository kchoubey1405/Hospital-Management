package com.myproject.utill;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Collection;
import java.util.Random;

import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;


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

	public static String generateEAN13BarcodeImage(String barcodeText) {
	   try{
		EAN13Bean barcodeGenerator = new EAN13Bean();
	    BitmapCanvasProvider canvas = 
	      new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

	    barcodeGenerator.generateBarcode(canvas, barcodeText);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(canvas.getBufferedImage(), "jpg", baos);
	    baos.flush();
	    byte[] imageInByte = baos.toByteArray();


	    String encoded = Base64.getEncoder().encodeToString("Hello".getBytes());
	    return encoded;
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
