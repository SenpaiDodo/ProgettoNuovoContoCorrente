package it.betacom.model;

import java.time.LocalDate;

public class Movimento {
	private LocalDate dataOperazione;
	private TipoOperazione tipoOperazione;
	private double importoMovimento;
	private double saldoDopoMovimento;
	
	public Movimento(LocalDate dataOperazione, TipoOperazione tipoOperazione, double importoMovimento,
			double saldoDopoMovimento) {
		super();
		this.dataOperazione = dataOperazione;
		this.tipoOperazione = tipoOperazione;
		this.importoMovimento = importoMovimento;
		this.saldoDopoMovimento = saldoDopoMovimento;
	}
	
	public LocalDate getDataOperazione() {
		return dataOperazione;
	}
	public TipoOperazione getTipoOperazione() {
		return tipoOperazione;
	}
	public double getImportoMovimento() {
		return importoMovimento;
	}
	public double getSaldoDopoMovimento() {
		return saldoDopoMovimento;
	}
	public void setDataOperazione(LocalDate dataOperazione) {
		this.dataOperazione = dataOperazione;
	}
	public void setTipoOperazione(TipoOperazione tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}
	public void setImportoMovimento(double importoMovimento) {
		this.importoMovimento = importoMovimento;
	}
	public void setSaldoDopoMovimento(double saldoDopoMovimento) {
		this.saldoDopoMovimento = saldoDopoMovimento;
	}
	
}
