package appli.document;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFDocument {

	private String name;
	private String source;

	public PDFDocument() {
		this("", "sansNom");
	}

	public PDFDocument(String name) {
		this("", name);
	}

	public PDFDocument(String source, String name) {
		this.setName(name);
		this.setSource(source);
	}

	public void blankPDF() {
		PDDocument doc = null;

		doc = new PDDocument();
		doc.addPage(new PDPage());

		try {
			doc.save(this.getSource() + "/" + this.getName() + ".pdf");
			doc.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void textPDF(ArrayList<String> lignes) {
		PDDocument doc = null;
		PDPage page = null;

		doc = new PDDocument();
		page = new PDPage();
		doc.addPage(page);
		PDFont font = PDType1Font.TIMES_ROMAN;
		try {
			PDPageContentStream content = new PDPageContentStream(doc, page);
			content.beginText();
			content.setFont(font, 12);
			content.moveTextPositionByAmount(100, 700);
			for (String line : lignes) {
				content.drawString(line);
			}

			content.endText();
			content.close();

			doc.save(this.getSource() + "/" + this.getName() + ".pdf");
			doc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
