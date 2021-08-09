package com.example.waiter.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Menu implements Serializable {
    private int quantity;

    @SerializedName("thumbImage")
    @Expose
    private String thumbImage;

    public Menu(String thumbImage, String nameMenu, Integer priceMenu) {
        this.thumbImage = thumbImage;
        this.nameMenu = nameMenu;
        this.priceMenu = priceMenu;
    }


    @SerializedName("nameMenu")
    @Expose
    private String nameMenu;
    @SerializedName("priceMenu")
    @Expose
    private Integer priceMenu;

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public Integer getPriceMenu() {
        return priceMenu;
    }

    public void setPriceMenu(Integer priceMenu) {
        this.priceMenu = priceMenu;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
