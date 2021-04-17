package ru.khomyakov;

import java.util.Map;

public class CurrencyReport {
    private String Date;
    private String PreviousDate;
    private String PreviousURL;
    private String TimeStamp;
    private Map<String, Currency> Valute;

    public CurrencyReport(String date, String previousDate, String previousURL, String timeStamp, Map<String, Currency> valute) {
        Date = date;
        PreviousDate = previousDate;
        PreviousURL = previousURL;
        TimeStamp = timeStamp;
        Valute = valute;
    }

    public Map<String, Currency> getValute() {
        return Valute;
    }
}
