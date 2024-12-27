package com.example.scards;

public class Card {
    private String name;
    private String imagePath;
    private String qrCodePath;

    public Card(String name, String imagePath, String qrCodePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.qrCodePath = qrCodePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }
}
