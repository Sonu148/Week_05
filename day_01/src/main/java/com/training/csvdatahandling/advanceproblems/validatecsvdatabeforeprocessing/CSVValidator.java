package com.training.csvdatahandling.advanceproblems.validatecsvdatabeforeprocessing;
import java.io.*;
import java.util.*;

public class CSVValidator {
    public static void main(String[] args) {
        String csvFile = "src/main/java/com/training/csvdatahandling/advanceproblems/validatecsvdatabeforeprocessing/students.csv";
        List<String[]> invalidRows = new ArrayList<>();
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneRegex = "^[0-9]{10}$";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            reader.readLine(); // Skip header
            String line;

            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                String email = record[1];
                String phone = record[2];
                if (!email.matches(emailRegex) || !phone.matches(phoneRegex)) {
                    invalidRows.add(record);
                    System.out.println("Invalid row: " + Arrays.toString(record));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
