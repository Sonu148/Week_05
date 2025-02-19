package com.training.csvdatahandling.intermediateproblems.modifysalary;

import java.io.*;

public class Employee {

    public static void main(String[] args) {

        // file path of the employee list
        String filePath = "src/main/java/com/training/csvdatahandling/intermediateproblems/modifysalary/employees.csv";
        String newFilePath = "src/main/java/com/training/csvdatahandling/intermediateproblems/modifysalary/employees_updated.csv";

        // using file reader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(newFilePath))) {

            String line;
            // Flag to handle header
            boolean isFirstLine = true;

            // Looping to read each line from the CSV
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isFirstLine) {
                    bw.write(line);
                    bw.newLine();
                    isFirstLine = false;
                    continue;
                }

                // Modify the salary for IT department employees
                if (data[1].equals("IT")) {
                    int oldSalary = Integer.parseInt(data[2]);
                    int newSalary = oldSalary + (oldSalary * 10 / 100); // Increase by 10%
                    data[2] = String.valueOf(newSalary);
                }

                // Write the updated data to the new file
                bw.write(String.join(",", data));
                bw.newLine();

                System.out.println(data[0] + ", " + data[1] + ", " + data[2]);
            }

        } catch (IOException e) {
            System.out.println("File not found or an error occurred!");
            e.printStackTrace();
        }
    }
}
