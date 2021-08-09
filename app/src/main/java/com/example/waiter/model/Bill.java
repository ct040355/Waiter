package com.example.waiter.model;

public class Bill {
    private String nameBill;
    private String imageBill;
    private int idBill;

    public Bill(String nameBill, String imageBill, int priceBill, int tBill, int quantityBill) {
        this.nameBill = nameBill;
        this.imageBill = imageBill;
        this.priceBill = priceBill;
        this.tBill = tBill;
        this.quantityBill = quantityBill;
    }
    public Bill(){}
    private int priceBill;
    private int tBill;

    public int getPriceBill() {
        return priceBill;
    }

    public void setPriceBill(int priceBill) {
        this.priceBill = priceBill;
    }

    public int gettBill() {
        return tBill;
    }

    public void settBill(int tBill) {
        this.tBill = tBill;
    }

    public int getQuantityBill() {
        return quantityBill;
    }

    public void setQuantityBill(int quantityBill) {
        this.quantityBill = quantityBill;
    }

    private int quantityBill;

    public String getNameBill() {
        return nameBill;
    }

    public void setNameBill(String nameBill) {
        this.nameBill = nameBill;
    }

    public String getImageBill() {
        return imageBill;
    }

    public void setImageBill(String imageBill) {
        this.imageBill = imageBill;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }
}
