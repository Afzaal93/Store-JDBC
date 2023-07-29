package com.afzaal.model.Utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF_generator {
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filename="C:\\Users\\Techskilkl\\Desktop\\afzaalpdf\\new.pdf"; 
		Document document = new Document();
		PdfWriter.getInstance(document,new FileOutputStream(filename));
		document.open();
		 Paragraph paragraph = new Paragraph("Hello Afzal Bhai Mahan Hai");
		 document.add(paragraph); 
		document.close();
		System.out.println("Done");
	} 
}
