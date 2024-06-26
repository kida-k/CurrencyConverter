package org.example.CurrencyData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonFileReader {
    private static final String JSON_FILE_PATH = "org/example/CurrencyData/data.json";

    private ObjectMapper objectMapper;
    private JsonNode jsonData;

    public JsonFileReader() throws IOException {
        this.objectMapper = new ObjectMapper();
        try (InputStream inputStream = JsonFileReader.class.getClassLoader().getResourceAsStream(JSON_FILE_PATH)) {
            if (inputStream == null) {
                throw new IOException("Cannot find resource: " + JSON_FILE_PATH);
            }
            this.jsonData = objectMapper.readTree(inputStream);
        }
    }

    public double getData(String currency) {
        JsonNode currencyNode = jsonData.path("data").path(currency);
        if (!currencyNode.isMissingNode()) {
            return currencyNode.path("value").asDouble();
        } else {
            // Handle case where currency is not found
            System.err.println("Currency not found: " + currency);
            return 0.0;  // Or throw an exception or return an appropriate value
        }
    }
}
