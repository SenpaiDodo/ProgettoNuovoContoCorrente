package it.betacom.main;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class CalcolaDistanzaDate {
    public static void main(String[] args) {
        ArrayList<LocalDate> dateList = new ArrayList<>();
        // Aggiungi le date alla lista
        dateList.add(LocalDate.of(2023, 1, 1));
        dateList.add(LocalDate.of(2023, 1, 5));
        dateList.add(LocalDate.of(2023, 1, 10));
        dateList.add(LocalDate.of(2023, 1, 15));

        // Calcola i giorni tra le date
        for (int i = 1; i < dateList.size(); i++) {
            LocalDate date1 = dateList.get(i - 1);
            LocalDate date2 = dateList.get(i);
            long daysBetween = Period.between(date1, date2).getDays();
            System.out.println("Distanza tra " + date1 + " e " + date2 + ": " + daysBetween + " giorni");
        }
    }
}