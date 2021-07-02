package at.cb.s20210702wortanalyse;

import at.cb.s20210702wortanalyse.bl.WortAnalyseBl;
import at.cb.s20210702wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class WortAnalyse {
    public static void main(String[] args) {

        WortAnalyseBl bl = new WortAnalyseBl("https://www.lugiland.de/wp-content/uploads/" +
                "2019/05/schachnovelle.pdf", "http://www.digbib.org/Franz_Kafka_1883/Die_Verwandlung_.pdf");
        try {
            bl.init();
            bl.printDocumentInfo();
        } catch (IOException e){
            e.printStackTrace();
        }

        // Map<Stadtname, Map<Bezirksname, Einwohner>>
        Map<String, Map<String, Integer>>
    }


}
