package ru.khomyakov;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.*;

public class App {
    public static final String URL_STRING = "https://www.cbr-xml-daily.ru/daily_json.js";

    public static void main( String[] args ) throws IOException {
        Map<String, Currency> currencyMap;
        Type reportType = new TypeToken<CurrencyReport>() {}.getType();

        URL url = new URL(URL_STRING);
        InputStreamReader reader = new InputStreamReader(url.openStream());

        CurrencyReport report = new Gson().fromJson(reader, reportType);

        currencyMap = report.getValute();

        currencyMap.entrySet().stream().sorted((o1, o2) -> {
            Double o1comp = Math.abs(o1.getValue().getValue() - o1.getValue().getPrevious());
            Double o2comp = Math.abs(o2.getValue().getValue() - o2.getValue().getPrevious());
            return o2comp.compareTo(o1comp);
        }).limit(5).forEach(entry -> System.out.println(entry.getKey()));
    }
}


