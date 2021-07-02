package at.cb.s20210702wortanalyse;

import at.cb.s20210702wortanalyse.bl.WortAnalyseBl;
import at.cb.s20210702wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WortAnalyse {
    public static void main(String[] args) {

        WortAnalyseBl bl = new WortAnalyseBl("https://www.lugiland.de/wp-content/uploads/" +
                "2019/05/schachnovelle.pdf");
        try {
            bl.init();
            bl.printDocumentInfo();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
