package at.cb.minmax.operations;

import java.util.List;

/**
 * Sucht das Minimum und das Maximum in einer Liste mit Hilfe von Schleifen
 */
public class MinMaxWithLoop implements MinMaxFinder{
    @Override
    public int findMin(List<Integer> values) {
        int kleinste = values.get(0);
        // enhanced for Schleife
        for(int zahl : values){
            // wenn aktuelle Zahl kleiner ist als bisher kleinste Zahl
            if(zahl < kleinste){
                // kleinste Zahl mit aktueller Zahl ersetzen
                kleinste = zahl;
            }
        }
        return kleinste;
    }

    @Override
    public int findMax(List<Integer> values) {
        int groesste = values.get(0);
        for(int i = 0; i < values.size(); i++){
            if(values.get(i) > groesste){
                groesste = values.get(i);
            }
        }
        return groesste;
    }
}
