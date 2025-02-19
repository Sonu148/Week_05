package com.training.csvdatahandling.advanceproblems.mergetwocsvfiles;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "src/main/java/com/training/csvdatahandling/advanceproblems/mergetwocsvfiles/students1.csv";
        String file2 = "src/main/java/com/training/csvdatahandling/advanceproblems/mergetwocsvfiles/students2.csv";
        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            reader1.readLine(); // Skip header
            String line;

            while ((line = reader1.readLine()) != null) {
                String[] record = line.split(",");
                studentData.put(record[0], record); // Store by ID
            }

            try (BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
                reader2.readLine(); // Skip header
                while ((line = reader2.readLine()) != null) {
                    String[] record = line.split(",");
                    String[] studentRecord = studentData.get(record[0]);
                    if (studentRecord != null) {
                        System.out.println(String.join(",", studentRecord[0], studentRecord[1], studentRecord[2], record[1], record[2]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
