package com.training.jsondata.handonpracticeproblems.validateemailfieldusingjson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EmailValidater {

    public static void main(String[] args) {
        try {
            // Load the JSON schema from a file
            FileInputStream schemaInputStream = new FileInputStream("src/main/java/com/training/handonpracticeproblems/validateemailfieldusingjson/email-schema.json");
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaInputStream));
            Schema schema = SchemaLoader.load(jsonSchema);

            // Load the JSON data to validate
            File jsonFile = new File("src/main/java/com/training/handonpracticeproblems/validateemailfieldusingjson/data.json"); // JSON file with email field
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            JSONObject jsonData = new JSONObject(jsonNode.toString());

            // Validate the JSON data against the schema
            schema.validate(jsonData);
            System.out.println("The email field is valid.");
        } catch (Exception e) {
            // Handle validation failure
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
