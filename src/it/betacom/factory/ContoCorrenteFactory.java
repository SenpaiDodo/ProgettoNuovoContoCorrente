package it.betacom.factory;

import java.time.LocalDate;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.betacom.model.*;

public class ContoCorrenteFactory {
	protected static final Logger loggerFactory = LogManager.getLogger("ContoCorrenteFactory");
	
	public static Conto buildConto(String titolare, LocalDate dataApertura, double saldo, String tipoConto) {
		if(tipoConto.equals("Conto Corrente")) {
			return new ContoCorrente(titolare, dataApertura, saldo, (0.07/365));
			
		} else if(tipoConto.equals("Conto Deposito")) {
			return new ContoDeposito(titolare, dataApertura, saldo, (0.10/365));

		} else if(tipoConto.equals("Conto di Investimento")) {
			Random random = new Random();
			int min = -100;
			int max = 100;
			
			int randomNumber = random.nextInt(max - min + 1) + min;
			double tassoInteressePercentuale = (double) randomNumber / 100;
			loggerFactory.info("Percentuale annuo conto di investimetno: " + tassoInteressePercentuale);
			
			return new ContoInvestimento(titolare, dataApertura, saldo, (tassoInteressePercentuale/365));
		} else {
			throw new IllegalArgumentException("Tipo computer non riconosciuto");
		}
	}
}