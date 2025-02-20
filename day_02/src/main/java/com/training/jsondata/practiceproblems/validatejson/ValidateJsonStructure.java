package com.training.jsondata.practiceproblems.validatejson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ValidateJsonStructure {
    public static void main(String[] args) {
        // Sample JSON strings (valid and invalid examples)
        String validJson = "{\"name\":\"Sonu\",\"age\":21}";
        String invalidJson = "{\"name\":\"Aman\", \"age\":22";  // Missing closing brace

        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Validate the valid JSON string
        validateJson(validJson, mapper);  // Should print: Valid JSON structure.

        // Validate the invalid JSON string
        validateJson(invalidJson, mapper);  // Should print: Invalid JSON structure.
    }

    public static void validateJson(String jsonString, ObjectMapper mapper) {
        try {
            // Attempt to parse the JSON string
            JsonNode node = mapper.readTree(jsonString);

            // If no exception is thrown, the JSON is valid
            System.out.println("Valid JSON structure.");
        } catch (JsonProcessingException e) {
            // If an exception is thrown, the JSON is invalid
            System.out.println("Invalid JSON structure: ");
        }
    }
}
