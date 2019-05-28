package com.example.androidlogin.Retrofit;

public class MenuItem {
    private String status;
    private String message;
    private FoodPrice[] allItems;

    public FoodPrice[] getFoodPrice(){
        return allItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
