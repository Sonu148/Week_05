package com.training.jsondata.handonpracticeproblems.mergetwojsonfileintosinglejsonobject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFileToJsonObject {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read the two JSON files into JsonNode objects
            JsonNode json1 = mapper.readTree(new File("src/main/java/com/training/jsondata/handonpracticeproblems/mergetwojsonfileintosinglejsonobject/file1.json"));
            JsonNode json2 = mapper.readTree(new File("src/main/java/com/training/jsondata/handonpracticeproblems/mergetwojsonfileintosinglejsonobject/file2.json"));

            // Ensure that both json1 and json2 are of ObjectNode type before merging
            if (json1.isObject() && json2.isObject()) {
                // Cast JsonNode to ObjectNode for modification
                ObjectNode objectNode1 = (ObjectNode) json1;
                ObjectNode objectNode2 = (ObjectNode) json2;

                // Merge json2 into json1
                objectNode1.setAll(objectNode2);

                // Print the merged JSON object
                System.out.println(objectNode1.toPrettyString());
            } else {
                System.out.println("Both JSON files must contain JSON objects.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
