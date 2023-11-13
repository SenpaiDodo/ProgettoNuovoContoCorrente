package it.betacom.model;

import java.time.LocalDate;

public class ContoCorrente extends Conto {
	
	public ContoCorrente(String titolare, LocalDate dataApertura, double saldo, double tassoInteresse) {
		super(titolare, dataApertura, saldo, tassoInteresse);
	}

	@Override
	public void preleva(LocalDate dataMovimento, double importo) {
		if(importo <= super.saldo) {
			double tempSaldo = super.saldo - importo;
			super.saldo = super.saldo - importo;
			super.listaMovimenti.add(new Movimento(dataMovimento, TipoOperazione.PRELIEVO, importo, tempSaldo));
		}
	}

	@Override
	public void versa(LocalDate dataMovimento, double importo) {
		double tempSaldo = super.saldo + importo;
		super.saldo = super.saldo + importo;
		super.listaMovimenti.add(new Movimento(dataMovimento, TipoOperazione.VERSAMENTO, importo, tempSaldo));
	}

	@Override
	public void estrattoConto(LocalDate dataStampa, String directoryPath) {
		super.estrattoConto(dataStampa, directoryPath);
	}
	
	@Override
	public void chiusuraConto(LocalDate dataStampa, String directoryPath) {
		super.chiusuraConto(dataStampa, directoryPath);
	}
}
