package io;

import model.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<Entry> fromUrl(URL url) throws IOException {
        List<Entry> entries = new ArrayList<>();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        boolean firstLine = true;
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            if(firstLine){
                // skip header
                firstLine = false;
                continue;
            }
            System.out.println(inputLine);
            entries.add(lineToEntry(inputLine));
        }
        in.close();
        return entries;
    }

    private static Entry lineToEntry(String line){
        // Line: KALW-202105;B00-9;ALTERSGR65-1;C11-2;29
        String[] split = line.split(";");
        int year = Integer.parseInt(split[0].substring(5, 9));
        int kw = Integer.parseInt(split[0].substring(9, 11));
        Entry.AgeGroup ageGroup;
        if(split[2].equalsIgnoreCase("ALTERSGR65-1")){
            ageGroup = Entry.AgeGroup.U65;
        } else {
            ageGroup = Entry.AgeGroup.AB65;
        }
        Entry.Gender gender;
        if(split[3].equalsIgnoreCase("C11-1")){
            gender = Entry.Gender.MALE;
        } else {
            gender = Entry.Gender.FEMALE;
        }
        int deaths = Integer.parseInt(split[4]);
        return new Entry(year, kw, ageGroup, gender, deaths);
    }
}
