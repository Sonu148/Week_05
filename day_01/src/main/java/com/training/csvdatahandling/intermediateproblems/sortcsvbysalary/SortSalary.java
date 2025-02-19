package com.training.csvdatahandling.intermediateproblems.sortcsvbysalary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortSalary {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/training/csvdatahandling/intermediateproblems/sortcsvbysalary/employees.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] record = line.split(",");
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        records.sort((record1, record2) -> {
            try {
                double salary1 = Double.parseDouble(record1[2]);
                double salary2 = Double.parseDouble(record2[2]);
                return Double.compare(salary2, salary1);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        });

        System.out.println("Top 5 Highest-Paid Employees:");
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] record = records.get(i);
            System.out.println("Name: " + record[0] + ", Salary: " + record[2]);
        }
    }
}
