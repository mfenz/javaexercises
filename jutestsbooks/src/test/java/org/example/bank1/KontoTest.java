package org.example.bank1;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class KontoTest {

    Konto konto;
    Transaktion txGeburtstag = new Transaktion(200, "Geburtstag", LocalDate.of(2020, 6, 1));
    Transaktion txFirmaGehalt = new Transaktion(3000.5, "Firma Gehalt", LocalDate.of(2020, 5, 1));
    Transaktion txStrom = new Transaktion(-600.12, "Firma Gehalt", LocalDate.of(2021, 4, 15));

    @BeforeEach
    public void initBeforeEach(){
        konto = new Konto();
    }

    @Test
    public void neuesKontoKontostand0(){
        Konto konto = new Konto();
        double kontostand = konto.getKontostand();
        assertEquals(0, kontostand, "Neues Konto soll Kontostand 0 haben");
    }

    @Test
    public void neuesKontoKeineTransaktion(){
        Konto konto = new Konto();
        int anzTransaktionen = konto.getAnzahlTransaktionen();
        assertEquals(0, anzTransaktionen, "Neues Konto muss 0 Transaktionen haben");
    }

    @Test
    public void neuesKontoZweiTransaktionenHinzuPruefeAnzahl(){
        Konto konto = new Konto();
        Transaktion t1 = new Transaktion(10.5, "Einzahlung", LocalDate.now());
        Transaktion t2 = new Transaktion(-5.5, "Einzahlung", LocalDate.now());
        konto.addTransaktion(t1);
        konto.addTransaktion(t2);

        int anzTransaktionen = konto.getAnzahlTransaktionen();
        assertEquals(2, anzTransaktionen, "Beim Einfügen von zwei Transaktionen müssen 2 Transaktionen im Konto sein");
    }

    // Refactoring auf vararg

    @Test
    public void neuesKontoZweiTransaktionenHinzuPruefeKontostand(){
        Konto konto = new Konto();
        Transaktion t1 = new Transaktion(10.5, "Einzahlung", LocalDate.now());
        Transaktion t2 = new Transaktion(-5.5, "Einzahlung", LocalDate.now());
        konto.addTransaktion(t1, t2);

        double kontostand = konto.getKontostand();
        assertEquals(5.0, kontostand, "Kontostand nach zwei Transaktionen müsse 5 betragen");
    }

    @Test
    public void groupTransactionsInsideKontoByYear(){
        konto.addTransaktion(txFirmaGehalt, txGeburtstag, txStrom);
        //Map<Integer, List<Transaktion>> transaktionenProJahr = konto.gruppiereTransaktionenNachJahr();
        Map<Integer, List<Transaktion>> transaktionenProJahr = konto.groupBy(tx -> tx.getDatum().getYear());

        assertThat(transaktionenProJahr)
                .containsKey(2020)
                .containsValues(Arrays.asList(txFirmaGehalt, txGeburtstag));

        assertThat(transaktionenProJahr)
                .containsKey(2021)
                .containsValues(List.of(txStrom));
    }

    @BeforeAll
    public static void initBeforeAll(){

    }


    @Nested
    @DisplayName("is empty")
    class IsEmpty {
        @Test
        @DisplayName("")
        public void t(){
            String x = "";
            List<String> str = List.of("asf");
            assertTrue(true);
        }
    }

}