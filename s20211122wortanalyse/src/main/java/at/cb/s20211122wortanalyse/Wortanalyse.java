package at.cb.s20211122wortanalyse;

import at.cb.s20211122wortanalyse.bl.WortanalyseBL;
import at.cb.s20211122wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Wortanalyse {
    public static void main(String[] args) {
        WortanalyseBL bl = new WortanalyseBL(
                "http://www.digbib.org/Franz_Kafka_1883/Die_Verwandlung_.pdf",
                "http://www.digbib.org/Johann_Wolfgang_von_Goethe_1749/Faust_I_.pdf");
        try {
            bl.init();
            bl.removePunctuationMarks();
            //bl.printWordsWithoutDuplicates();
            bl.printWordsInAThatAreNotInB();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
