package com.training.csvdatahandling.advanceproblems.readlargecsvfileefficiently;
import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/training/csvdatahandling/advanceproblems/readlargecsvfileefficiently/large_file.csv";
        int chunkSize = 2;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + count + " records");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
