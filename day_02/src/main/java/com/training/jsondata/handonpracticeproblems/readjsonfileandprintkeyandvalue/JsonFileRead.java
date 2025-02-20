package com.training.jsondata.handonpracticeproblems.readjsonfileandprintkeyandvalue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class JsonFileRead {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file into JsonNode
            JsonNode rootNode = mapper.readTree(new File("data.json"));

            // Iterate through keys and values
            Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                Entry<String, JsonNode> field = fields.next();
                System.out.println("Key: " + field.getKey() + ", Value: " + field.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
