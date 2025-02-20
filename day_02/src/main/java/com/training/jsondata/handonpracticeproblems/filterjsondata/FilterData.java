package com.training.jsondata.handonpracticeproblems.filterjsondata;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;

public class FilterData {

        public static void main(String[] args) throws IOException {
            String jsonData = "[{\"name\":\"Aman\", \"age\":30}, {\"name\":\"Sonu\", \"age\":22}, {\"name\":\"Srijan\", \"age\":23}]";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonData);

            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode user = elements.next();
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println("Name: " + user.get("name").asText() + ", Age: " + age);
                }
            }
        }
    }

