package at.cb.inskriptionen;

import at.cb.inskriptionen.model.UniEnrolment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculateInscriptions();
    }

    public void calculateInscriptions() {
        try {
            List<UniEnrolment> enrolments = loadUniEnrolments("https://service.stmk.gv.at/ogd/OGD_Data_ABT17/statistik/STUD/STMK_STUD_UNI.csv");

            // Key: Integer year
            // Value: Integer enrolments
            Map<Integer, Integer> enrolmentsPerYear = new HashMap<>();

            for(UniEnrolment e : enrolments){
                int currentEnrolments = enrolmentsPerYear.getOrDefault(e.getYear(), 0);
                currentEnrolments += e.getEnroledTotal();
                enrolmentsPerYear.put(e.getYear(), currentEnrolments);
            }

            enrolmentsPerYear.forEach((year, numberOfEnrolments) -> {
                System.out.printf("%d: %6d %n", year, numberOfEnrolments);
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<UniEnrolment> loadUniEnrolments(
            String csvPath) throws IOException {
        List<UniEnrolment> enrolments = new ArrayList<>();

        try (InputStream is = new URL(csvPath).openStream();
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(is));) {
            String strLine;

            boolean firstLine = true;
            //Read File Line By Line
            while ((strLine = reader.readLine()) != null) {
                // Print the content on the console
                System.out.println(strLine);

                if(firstLine || strLine.length() < 10){
                    firstLine = false;
                    continue; // mit der nächsten Zeile weitermachen
                }

                // line to object
                UniEnrolment uniEnrolment = lineToUniEnrolment(strLine);

                // Objekt in die Liste einfügen
                enrolments.add(uniEnrolment);
            }
        }

        return enrolments;
    }

    private UniEnrolment lineToUniEnrolment(String line){
        // Line aufspalten
        String[] split = line.split(";");
        String uniName = split[5];
        int men = Integer.parseInt(split[6]);
        int women = Integer.parseInt(split[7]);
        int year = Integer.parseInt(split[9].substring(0, 4));

        return new UniEnrolment(uniName, men, women, year);
    }
}
