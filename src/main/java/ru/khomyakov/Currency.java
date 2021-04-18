package ru.khomyakov;

public class Currency {
    private String ID;
    private String NumCode;
    private String CharCode;
    private int Nominal;
    private String Name;
    private double Value;
    private double Previous;

    public Currency(String ID, String numCode, String charCode, int nominal, String name, double value, double previous) {
        this.ID = ID;
        NumCode = numCode;
        CharCode = charCode;
        Nominal = nominal;
        Name = name;
        Value = value;
        Previous = previous;
    }

    public double getValue() {
        return Value;
    }

    public double getPrevious() {
        return Previous;
    }

    @Override
    public String toString() {
        return "{" +
                "ID = " + ID + '\n' + '\t' +
                "NumCode = " + NumCode + '\n' + '\t' +
                "CharCode = " + CharCode + '\n' + '\t' +
                "Nominal = " + Nominal + '\n' + '\t' +
                "Name = " + Name + '\n' + '\t' +
                "Value = " + Value + '\n' + '\t' +
                "Previous = " + Previous +
                '}';
    }
}
