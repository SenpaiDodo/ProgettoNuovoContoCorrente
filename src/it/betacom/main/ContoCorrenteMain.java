package it.betacom.main;

import java.time.LocalDate;

import it.betacom.factory.ContoCorrenteFactory;
import it.betacom.model.Conto;

public class ContoCorrenteMain {

	public static void main(String[] args) {
		
		String path = "./estrattoConto/";
		
		Conto cc = ContoCorrenteFactory.buildConto("Giorgio", LocalDate.of(2021, 02, 02), 0, "Conto Corrente");
		cc.versa(LocalDate.of(2021, 05, 02), 500);
		cc.preleva(LocalDate.of(2021, 07, 02), 100);
		cc.estrattoConto(LocalDate.of(2021, 12, 31), path + "EC_" + cc.getTitolare() + "_20211231.pdf");
		
		cc.versa(LocalDate.of(2022, 07, 02), 500);
		cc.preleva(LocalDate.of(2022, 11, 30), 100);
		cc.estrattoConto(LocalDate.of(2022, 12, 31), path + "EC_" + cc.getTitolare() + "_20221231.pdf");
		
		cc.versa(LocalDate.of(2023, 01, 04), 500);
		cc.preleva(LocalDate.of(2023, 02, 01), 100);
		cc.chiusuraConto(LocalDate.of(2023, 12, 31), path + "EC_" + cc.getTitolare() + "_20231231.pdf");
		
		Conto cd = ContoCorrenteFactory.buildConto("Marco", LocalDate.of(2021, 02, 02), 0, "Conto Deposito");
		cd.versa(LocalDate.of(2021, 05, 02), 500);
		cd.preleva(LocalDate.of(2021, 07, 02), 100);
		cd.estrattoConto(LocalDate.of(2021, 12, 31), path + "EC_" + cd.getTitolare() + "_20211231.pdf");
		
		cd.versa(LocalDate.of(2022, 07, 02), 500);
		cd.preleva(LocalDate.of(2022, 11, 30), 100);
		cd.estrattoConto(LocalDate.of(2022, 12, 31), path + "EC_" + cd.getTitolare() + "_20221231.pdf");
		
		cd.versa(LocalDate.of(2023, 01, 04), 500);
		cd.preleva(LocalDate.of(2023, 02, 01), 100);
		cd.chiusuraConto(LocalDate.of(2023, 12, 31), path + "EC_" + cd.getTitolare() + "_20231231.pdf");
		
		Conto ci = ContoCorrenteFactory.buildConto("Anna", LocalDate.of(2021, 02, 02), 0, "Conto di Investimento");
		ci.versa(LocalDate.of(2021, 05, 02), 500);
		ci.preleva(LocalDate.of(2021, 07, 02), 100);
		ci.estrattoConto(LocalDate.of(2021, 12, 31), path + "EC_" + ci.getTitolare() + "_20211231.pdf");
		
		ci.versa(LocalDate.of(2022, 07, 02), 500);
		ci.preleva(LocalDate.of(2022, 11, 30), 100);
		ci.estrattoConto(LocalDate.of(2022, 12, 31), path + "EC_" + ci.getTitolare() + "_20221231.pdf");
		
		ci.versa(LocalDate.of(2023, 01, 04), 500);
		ci.preleva(LocalDate.of(2023, 02, 01), 100);
		ci.chiusuraConto(LocalDate.of(2023, 12, 31), path + "EC_" + ci.getTitolare() + "_20231231.pdf");
	}
}
