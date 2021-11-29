package at.cb.s20211122wortanalyse.bl;

import at.cb.s20211122wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
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

    public void removeWordsBeginningOrEndingWithA(){
        System.out.println("--- remove words beginning or ending with a ---");
        Set<String> words = contentToSet(contentA);

        // Zum Löschen während dem Iterieren wird ein Iterator benötigt
        Iterator<String> iter = words.iterator();

        // Jedes Element im Set ansehen
        while (iter.hasNext()){
            // Element aus dem Set holen
            String word = iter.next();

            if(word.startsWith("a") || word.startsWith("A") || word.endsWith("a") || word.endsWith("A")){
                // Wort aus der Collection löschen
                iter.remove();
            }
        }

        for(String word : words){
            System.out.println(word);
        }
    }

    public void countWords(){
        // Wie oft kommt jedes Wort im Dokument vor?
        // --> Zähle die Häufigkeit der Wörter

        String[] words = contentA.split(" ");

        // String Key: Wort
        // Integer Value: Anzahl
        Map<String, Integer> wordOccurences = new HashMap<>();

        for(String word : words){
            word = word.toLowerCase();

            // Wie oft ist "word" bisher vorgekommen, falls noch nie --> 0
            int count = wordOccurences.getOrDefault(word, 0);

            count++;

            // Neuen count in die Map geben
            wordOccurences.put(word, count);
        }

        wordOccurences.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

    }

}
