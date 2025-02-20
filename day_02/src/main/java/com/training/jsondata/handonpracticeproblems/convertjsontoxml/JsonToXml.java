package com.training.jsondata.handonpracticeproblems.convertjsontoxml;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Aman\", \"age\":30}";

        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(json);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}
