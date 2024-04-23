package com.example.classproject;

public class DataItem {
    private String itemDescription;
    private String itemPrice;
    private int thumbnailImage;
    private String itemLongDescription;
    private String itemURL;

    public DataItem(String itemDescription, String itemPrice,int thumbnailImage, String itemLongDescription, String itemURL) {
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.thumbnailImage = thumbnailImage;
        this.itemLongDescription = itemLongDescription;
        this.itemURL = itemURL;
    }//END constructor DataItem

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getThumbnailImage() {
        return thumbnailImage;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice= itemPrice;
    }

    public void setThumbnailImage(int thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getItemLongDescription() {
        return itemLongDescription;
    }

    public void setItemLongDescription(String itemLongDescription) {
        this.itemLongDescription = itemLongDescription;
    }

    public String getItemURL() {
        return itemURL;
    }

    public void setItemURL(String itemURL) {
        this.itemURL = itemURL;
    }

}
