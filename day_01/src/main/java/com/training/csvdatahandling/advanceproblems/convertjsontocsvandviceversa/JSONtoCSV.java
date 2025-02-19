package com.training.csvdatahandling.advanceproblems.convertjsontocsvandviceversa;

import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

public class JSONtoCSV {
    public static void main(String[] args) {
        String jsonFile = "src/main/java/com/training/csvdatahandling/advanceproblems/convertjsontocsvandviceversa/students.json";
        String csvFile = "src/main/java/com/training/csvdatahandling/advanceproblems/convertjsontocsvandviceversa/students.csv";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserialize JSON into a List of Maps
            List<Map<String, Object>> students = objectMapper.readValue(new File(jsonFile), List.class);

            // Create a BufferedWriter to write CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                writer.write("ID,Name,Age\n");

                // Iterate through the list and write each record to CSV
                for (Map<String, Object> student : students) {
                    // Ensure proper handling of fields to avoid potential null or type issues
                    String id = String.valueOf(student.get("id"));
                    String name = String.valueOf(student.get("name"));
                    String age = String.valueOf(student.get("age"));

                    writer.write(id + "," + name + "," + age + "\n");
                }
            }
            System.out.println("CSV file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
