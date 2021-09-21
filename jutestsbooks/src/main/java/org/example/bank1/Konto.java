package org.example.bank1;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Konto {

    private List<Transaktion> transaktionen = new ArrayList<>();

    public double getKontostand(){
        return transaktionen.stream().mapToDouble(d -> d.getBetrag()).sum();
    }

    public int getAnzahlTransaktionen(){
        return transaktionen.size();
    }

    public void addTransaktion(Transaktion ... transaktionen){
        this.transaktionen.addAll(Arrays.stream(transaktionen).collect(Collectors.toList()));
    }

    public Map<Integer, List<Transaktion>> gruppiereTransaktionenNachJahr(){
        return transaktionen.stream().collect(Collectors.groupingBy(transaktion -> transaktion.getDatum().getYear()));
    }

    public <K> Map<K, List<Transaktion>> groupBy(Function<Transaktion, K> fx) {
        return transaktionen
                .stream()
                .collect(Collectors.groupingBy(fx));
    }
}
