package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import appli.document.PDFDocument;

public class DocumentControleur implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case "PDF":
			PDFDocument pdf = new PDFDocument("fichePaie");
			ArrayList<String> lines = new ArrayList<String>();
			lines.add("Nom : ");
			pdf.textPDF(lines);
			break;

		default:
			break;
		}

	}

}
