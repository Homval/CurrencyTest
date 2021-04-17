package ru.khomyakov;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static final String URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    public static void main( String[] args ) throws IOException {
        Map<String, Double> map = new HashMap<>();

        try(FileReader reader = new FileReader(URL)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray valute = (JSONArray) jsonObject.get("Valute");

            for (Object o : valute) {
                JSONObject inner = (JSONObject) o;
                String name = (String) inner.get("Name");
                double current = Double.parseDouble((String) inner.get("Value"));
                double previous = Double.parseDouble((String) inner.get("Previous"));
                map.put(name, Math.abs(current - previous));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).limit(5).forEach(entry -> System.out.println(entry.getKey()));

    }
}
