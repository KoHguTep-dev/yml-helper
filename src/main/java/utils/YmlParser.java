package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YmlParser {

    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory())
            .setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);

    public List<Map<Object, Object>> parseYml(byte[] source) {
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> dataset = new HashMap<>();
        List<Map<Object, Object>> views = new ArrayList<>();

        try {
            map = objectMapper.readValue(source, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse dataset config for ", e);
        }

        dataset = (Map<Object, Object>) map.get("dataset");
        views = (List<Map<Object, Object>>) dataset.get("view-configurations");

        return views;

    }

}
