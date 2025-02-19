package com.training.csvdatahandling.advanceproblems.convertcsvdataintojavaobjects;
import java.io.*;
import java.util.*;
public class CSVToJavaObject {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/training/csvdatahandling/advanceproblems/convertcsvdataintojavaobjects/students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            String line;

            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                students.add(new Student(record[0], record[1], record[2]));
            }

            students.forEach(s -> System.out.println(s.id + " " + s.name + " " + s.age));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}