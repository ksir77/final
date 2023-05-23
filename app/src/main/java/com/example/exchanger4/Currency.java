package com.example.exchanger4;

public class Currency {
    private String name;
    private double buyPrice;
    private double sellPrice;

    public Currency(String name, double buyPrice, double sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }
}
