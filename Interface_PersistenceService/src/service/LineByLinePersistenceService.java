package service;

import java.io.*;
import java.util.StringTokenizer;

public class LineByLinePersistenceService implements PersistenceService{
    @Override
    public void save(String text, File file) {
        StringTokenizer tokenizer = new StringTokenizer(text);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            while (tokenizer.hasMoreTokens()){
                String token = tokenizer.nextToken();
                bw.write(token);
                bw.newLine();
            }
            bw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
