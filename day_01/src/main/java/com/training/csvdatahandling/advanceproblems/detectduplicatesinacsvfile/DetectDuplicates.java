package com.training.csvdatahandling.advanceproblems.detectduplicatesinacsvfile;
import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/training/csvdatahandling/advanceproblems/detectduplicatesinacsvfile/students.csv";
        Set<String> seen = new HashSet<>();
        List<String[]> duplicates = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                String recordString = String.join(",", record);

                if (!seen.add(recordString)) {
                    duplicates.add(record);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate Records:");
                duplicates.forEach(d -> System.out.println(Arrays.toString(d)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
