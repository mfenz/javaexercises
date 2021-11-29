package at.cb.s20211122wortanalyse.bl;

import at.cb.s20211122wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WortanalyseBL {
    private String urlDocumentA;
    private String urlDocumentB;

    // Der gesamte Text des PDF-Dokuments
    private String contentA;
    private String contentB;

    public WortanalyseBL(String urlDocumentA, String urlDocumentB){
        this.urlDocumentA = urlDocumentA;
        this.urlDocumentB = urlDocumentB;
    }

    public void init() throws IOException {
        // content initialisieren
        try (InputStream is = new URL(urlDocumentA).openStream()){
            contentA = PdfReader.readPdf(is);
        }
        try(InputStream is = new URL(urlDocumentB).openStream()){
            contentB = PdfReader.readPdf(is);
        }
    }

    public void removePunctuationMarks(){
        String[] punctuationMarks = {".", ",", "?", ";", ":", "!", "\n"};
        for(String punctuationMark : punctuationMarks){
            contentA = contentA.replace(punctuationMark, "");
            contentB = contentB.replace(punctuationMark, "");
        }
    }

    public void printContent(){
        System.out.println(contentA);
    }

    public void printWordsWithoutDuplicates(){


        // Zuerst den String in die einzelnen Wörter aufteilen
        Set<String> words = contentToSet(contentA);

        System.out.println("--- Einzelnen Wörter des Dokuments: --- ");
        for(String word : words){
            System.out.println(word);
        }

        System.out.println("--- Wie viele Wörter ohne Duplikate enthält das Buch? --- ");
        System.out.println(words.size());
    }

    public Set<String> contentToSet(String content){
        String[] contentSplit = content.split(" ");

        Set<String> words = new TreeSet<>(
                Arrays.asList(contentSplit)
                        .stream()
                        .map(word -> word.strip())
                        .collect(Collectors.toList())
        );
        return words;
    }

    public void printWordsInAThatAreNotInB(){
        Set<String> wordsA = contentToSet(contentA);
        Set<String> wordsB = contentToSet(contentB);

        // A ohne B
        wordsA.removeAll(wordsB);

        System.out.println("--- Wörter nur in A und nicht in B --- ");
        for(String word : wordsA)
        {
            System.out.println(word);
        }
    }

    // Überprüfe ob der Inhalt von zwei Sets gleich ist


    // Welche Wörter kommen nur im DocA und im DocB vor?
    public void printWordsThatAreNotInAAndB(){
        // Alle Worte bis auf jene die A und B gemeinsam haben
        Set<String> wordsA = contentToSet(contentA);
        Set<String> wordsB = contentToSet(contentB);

        // A ohne B
        wordsA.removeAll(wordsB);

        // B ohne A
        wordsB.removeAll(wordsA);

        Set<String> result = new TreeSet<>();
        result.addAll(wordsA);
        result.addAll(wordsB);
    }

}
