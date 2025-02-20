package com.training.jsondata.handonpracticeproblems.convertcsvtojson;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;

public class CsvToJson {
        public static void main(String[] args) throws Exception {
            File csvFile = new File("data.csv");
            CsvMapper csvMapper = new CsvMapper();

            // Read CSV file into JsonNode
            JsonNode jsonNode = csvMapper.readTree(csvFile);

            // Print JSON
            System.out.println(jsonNode.toString());
        }
    }
