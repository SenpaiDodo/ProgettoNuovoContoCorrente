package it.betacom.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.betacom.print.StampaEstrattoConto;

public abstract class Conto {
	protected String titolare;
	protected LocalDate dataApertura;
	protected double saldo;
	protected List<Movimento> listaMovimenti;
	protected double tassoInteresseGiornaliero;
	protected static final Logger logger = LogManager.getLogger("Conto");

	public Conto(String titolare, LocalDate dataApertura, double saldo, double tassoInteresseGiornaliero) {
		this.titolare = titolare;
		this.dataApertura = dataApertura;
		this.saldo = saldo + 1000.0;
		this.listaMovimenti = new ArrayList<Movimento>();
		this.tassoInteresseGiornaliero = tassoInteresseGiornaliero;
		this.listaMovimenti.add(new Movimento(dataApertura, TipoOperazione.APERTURA_CONTO, saldo + 1000.0, saldo + 1000.0));
	}

	public String getTitolare() {
		return titolare;
	}

	public LocalDate getDataApertura() {
		return dataApertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<Movimento> getListaMovimenti() {
		return listaMovimenti;
	}

	public double getTassoInteresseGiornaliero() {
		return tassoInteresseGiornaliero;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public void setDataApertura(LocalDate dataApertura) {
		this.dataApertura = dataApertura;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setListaMovimenti(List<Movimento> listaMovimenti) {
		this.listaMovimenti = listaMovimenti;
	}

	public abstract void preleva(LocalDate dataMovimento, double importo);

	public abstract void versa(LocalDate dataMovimento, double importo);
	
	public void estrattoConto(LocalDate dataStampa, String directoryPath) {
		double interessiMaturati = this.generaInteressi();
		this.listaMovimenti.add(new Movimento(dataStampa, TipoOperazione.ESTRATTO_CONTO, 0, this.saldo = this.saldo + (interessiMaturati - (interessiMaturati*0.26))));
		StampaEstrattoConto.stampaEstrattoConto(dataStampa, this, directoryPath);
	}
	
	public void chiusuraConto(LocalDate dataStampa, String directoryPath) {
		double interessiMaturati = this.generaInteressi();
		this.listaMovimenti.add(new Movimento(dataStampa, TipoOperazione.CHIUSURA_CONTO, 0, this.saldo = this.saldo + (interessiMaturati - (interessiMaturati*0.26))));
		StampaEstrattoConto.stampaEstrattoConto(dataStampa, this, directoryPath);
	}

	public double generaInteressi() {
		double tempInteressi = 0.0;
		for (int i = 1; i < this.listaMovimenti.size(); i++) {
            LocalDate date1 = this.listaMovimenti.get(i - 1).getDataOperazione();
            LocalDate date2 = this.listaMovimenti.get(i).getDataOperazione();
            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            System.out.println(daysBetween);
			tempInteressi = tempInteressi + (this.listaMovimenti.get(i - 1).getSaldoDopoMovimento() * this.tassoInteresseGiornaliero * daysBetween);
		}
		return tempInteressi;
	}
}
