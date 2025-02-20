package com.training.jsondata.practiceproblems.parsejsonandfilterrecords;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class JsonFilter {
    public static void main(String[] args) throws IOException {
        String jsonArray = "[{\"name\":\"Aman\", \"age\":26}, {\"name\":\"Satyam\", \"age\":22}, {\"name\":\"Sonu\", \"age\":22}]";

        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Parse JSON array into JsonNode
        JsonNode node = mapper.readTree(jsonArray);

        // Create a list to hold filtered results
        List<JsonNode> filteredList = new ArrayList<>();

        // Iterate over the JSON array and filter out records where age > 25
        Iterator<JsonNode> elements = node.elements();
        while (elements.hasNext()) {
            JsonNode person = elements.next();
            int age = person.get("age").asInt();
            if (age > 25) {
                filteredList.add(person);
            }
        }

        // Print the filtered JSON array
        String filteredJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredList);
        System.out.println(filteredJson);
    }
}
