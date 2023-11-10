package it.betacom.print;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.betacom.model.Conto;
import it.betacom.model.Movimento;

public class StampaEstrattoConto {
	public static void stampaEstrattoConto(LocalDate dataStampa, Conto conto, String directoryPath) {
		
		try {
			DecimalFormat formato = new DecimalFormat("0.00");
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(directoryPath));
			document.open();
			document.add(new Paragraph("Estratto conto del " + dataStampa + " | Titolare: " + conto.getTitolare()));
			document.add(new Paragraph("Movimenti:"));
			document.add(new Paragraph("| Data | Tipo di operazione | Quantità | Saldo parziale |"));
			for(Movimento m : conto.getListaMovimenti()) {
				document.add(new Paragraph("| " + m.getDataOperazione().toString() +
										  " | " + m.getTipoOperazione().toString() +
										  " | " + formato.format(m.getImportoMovimento()) +
										  " | " + formato.format(m.getSaldoDopoMovimento()) + 
										  " |"));
			}
			double interessiMaturati = conto.generaInteressi();
			document.add(new Paragraph(" Interessi maturati al " + dataStampa + " lordi: " + formato.format(interessiMaturati)));
			document.add(new Paragraph(" Interessi maturati al " + dataStampa + " netti: " + formato.format((interessiMaturati - (interessiMaturati * 0.26)))));
			document.add(new Paragraph(" Saldo finale: " + formato.format((conto.getSaldo() + (interessiMaturati - (interessiMaturati*0.26))))));
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
