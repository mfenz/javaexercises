package at.cb.calculator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CalculatorBl {
    private String historyFileName;

    public CalculatorBl(String historyFileName){
        this.historyFileName = historyFileName;
    }

    public float addition(float a, float b){
        return a + b;
    }

    public float subtraction(float a, float b){
        return a - b;
    }

    public float multiplication(float a, float b){
        return a * b;
    }

    public float division(float a, float b){
        return a / b;
    }

    public void saveHistoryToFile(List<String> histories) throws IOException {
        Path file = Paths.get(historyFileName);
        Files.write(file, histories, StandardCharsets.UTF_8);
    }

    public List<String> loadHistoryFromFile() throws IOException {
        Path file = Paths.get(historyFileName);
        return Files.readAllLines(file);
    }

    public boolean deleteHistoryFile() throws IOException {
        Path file = Paths.get(historyFileName);
        return Files.deleteIfExists(file);
    }
}
