package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CommaSeparatedPersistenceService implements PersistenceService{
    @Override
    public void save(String text, File file) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        StringBuilder sb = new StringBuilder();
        while (tokenizer.hasMoreTokens()){
            sb.append(tokenizer.nextToken()).append(",");
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
