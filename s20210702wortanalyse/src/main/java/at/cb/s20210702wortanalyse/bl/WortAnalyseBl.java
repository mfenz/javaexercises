package at.cb.s20210702wortanalyse.bl;

import at.cb.s20210702wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class WortAnalyseBl {
    private String urlDokumentA;
    private String urlDokumentB;

    private String textDokumentA;
    private String textDokumentB;

    public WortAnalyseBl(String urlDokumentA, String urlDokumentB){
        this.urlDokumentA = urlDokumentA;
        this.urlDokumentB = urlDokumentB;
    }

    public void init() throws IOException {
        // Text für Dokument A laden
        InputStream inputStreamA = new URL(urlDokumentA).openStream();
        String textA = PdfReader.readPdf(inputStreamA);
        inputStreamA.close();

        InputStream inputStreamB = new URL(urlDokumentB).openStream();
        String textB = PdfReader.readPdf(inputStreamB);
        inputStreamB.close();

        // Sonderzeichen aus Text löschen
        textDokumentA = replaceSpecialChars(textA);
        textDokumentB = replaceSpecialChars(textB);
    }

    /**
     * Entfernt alle Sonderzeichen aus dem übergebenen String
     * @param text String mit Sonderzeichen
     * @return String (Text) ohne Sonderzeichen
     */
    private String replaceSpecialChars(String text){
        String[] special = {".", ",", "(", ")", "-", ":", "?",
                "!", "\n", "\r", ";", "@", "$", "\"", "'", "%", "&"};
        for(String s : special){
            text = text.replace(s, "");
        }
        return text;
    }

    public Set<String> textToSet(String text){
        // String anhand der Leerzeichen in einzelne Wörter aufteilen
        String[] split = text.split(" ");

        Set<String> set = new TreeSet<>(Arrays.asList(split));
        return set;
    }

    public void printDocumentInfo(){
        // Set für Document A
        Set<String> wordsDocA = textToSet(textDokumentA);

        // Set für Document B
        Set<String> wordsDocB = textToSet(textDokumentB);

        // Ausgabe der Anzahl an verschiedenen Wörtern
        System.out.printf("Anzahl der verschiedenen Wörter: %d%n", wordsDocA.size());

//        System.out.println("Wörter im Dokument:");
//        for(String word : wordsDocA){
//            System.out.println(word);
//        }

        // Ermitteln Sie die Wörter die nur im Dokument A vorkommen
        // a ohne b
        Set<String> aOhneB = new TreeSet<>(wordsDocA);
        aOhneB.removeAll(wordsDocB);

        System.out.println();
        System.out.println();
        System.out.println("A ohne B:");
        for(String word : aOhneB){
            System.out.println(word);
        }
    }
}
