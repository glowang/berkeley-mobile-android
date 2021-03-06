package com.asuc.asucmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class DiningHall extends FoodPlace{


    @SerializedName("breakfast_menu")
    private ArrayList<FoodItem> breakfastMenu;

    @SerializedName("lunch_menu")
    private ArrayList<FoodItem> lunchMenu;

    @SerializedName("dinner_menu")
    private ArrayList<FoodItem> dinnerMenu;

    @SerializedName("limited_lunch_menu")
    private ArrayList<FoodItem> limitedLunchMenu;

    @SerializedName("limited_dinner_menu")
    private ArrayList<FoodItem> limitedDinnerMenu;

    @SerializedName("breakfast_open")
    private Date breakfastOpen;

    @SerializedName("breakfast_close")
    private Date breakfastClose;

    @SerializedName("lunch_open")
    private Date lunchOpen;

    @SerializedName("lunch_close")
    private Date lunchClose;

    @SerializedName("dinner_open")
    private Date dinnerOpen;

    @SerializedName("dinner_close")
    private Date dinnerClose;

    @SerializedName("limited_lunch_open")
    private Date limitedLunchOpen;

    @SerializedName("limited_lunch_close")
    private Date limitedLunchClose;

    @SerializedName("limited_dinner_open")
    private Date limitedDinnerOpen;

    @SerializedName("limited_dinner_close")
    private Date limitedDinnerClose;


    public DiningHall(String id, String name, ArrayList<FoodItem> breakfastMenu,
                      ArrayList<FoodItem> lunchMenu, ArrayList<FoodItem> dinnerMenu,
                      ArrayList<FoodItem> limitedLunchMenu, ArrayList<FoodItem> limitedDinnerMenu, Date breakfastOpen, Date breakfastClose,
                      Date lunchOpen, Date lunchClose, Date dinnerOpen, Date dinnerClose,
                      Date limitedLunchOpen, Date limitedLunchClose, Date limitedDinnerOpen, Date limitedDinnerClose, String imageUrl) {
        this.id = id;
        this.name = name;
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
        this.limitedLunchMenu = limitedLunchMenu;
        this.limitedDinnerMenu = limitedDinnerMenu;
        this.breakfastOpen = breakfastOpen;
        this.breakfastClose = breakfastClose;
        this.lunchOpen = lunchOpen;
        this.lunchClose = lunchClose;
        this.dinnerOpen = dinnerOpen;
        this.dinnerClose = dinnerClose;
        this.limitedLunchOpen = limitedLunchOpen;
        this.limitedLunchClose = limitedLunchClose;
        this.limitedDinnerOpen = limitedDinnerOpen;
        this.limitedDinnerClose = limitedDinnerClose;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<FoodItem> getBreakfastMenu() {
        return breakfastMenu;
    }

    public ArrayList<FoodItem> getLunchMenu() {
        return lunchMenu;
    }

    public ArrayList<FoodItem> getDinnerMenu() {
        return dinnerMenu;
    }

    public ArrayList<FoodItem> getLimitedLunchMenu() {
        return limitedLunchMenu;
    }

    public ArrayList<FoodItem> getLimitedDinnerMenu() {
        return limitedDinnerMenu;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Date getBreakfastOpening() {
        return breakfastOpen;
    }

    public Date getBreakfastClosing() {
        return breakfastClose;
    }

    public Date getLunchOpening() {
        return lunchOpen;
    }

    public Date getLunchClosing() {
        return lunchClose;
    }

    public Date getDinnerOpening() {
        return dinnerOpen;
    }

    public Date getDinnerClosing() {
        return dinnerClose;
    }

    public Date getLimitedLunchOpen() {
        return limitedLunchOpen;
    }

    public Date getLimitedLunchClosing() {
        return limitedLunchClose;
    }

    public Date getLimitedDinnerOpen() {
        return limitedDinnerOpen;
    }

    public Date getLimitedDinnerClosing() {
        return limitedDinnerClose;
    }

    /**
     * isBreakfastOpen() returns whether or not breakfast is open. The same goes for the other
     * three open methods.
     *
     * @return Boolean indicating if a certain dining hall menu is open or not.
     */
    public boolean isBreakfastOpen() {
        if (breakfastOpen == null || breakfastClose == null) {
            return false;
        }

        Date currentTime = new Date();
        return currentTime.after(breakfastOpen) && currentTime.before(breakfastClose);
    }

    public boolean isLunchOpen() {
        if (lunchOpen == null || lunchClose == null) {
            return false;
        }

        Date currentTime = new Date();
        return currentTime.after(lunchOpen) && currentTime.before(lunchClose);
    }

    public boolean isDinnerOpen() {
        if (dinnerOpen == null || dinnerClose == null) {
            return false;
        }

        Date currentTime = new Date();
        return currentTime.after(dinnerOpen) && currentTime.before(dinnerClose);
    }

    public boolean isLimitedLunchOpen() {
        if (limitedLunchOpen == null || limitedLunchClose == null) {
            return false;
        }

        Date currentTime = new Date();
        return currentTime.after(limitedLunchOpen) && currentTime.before(limitedLunchClose);
    }

    public boolean isLimitedDinnerOpen() {
        if (limitedDinnerOpen == null || limitedDinnerClose == null) {
            return false;
        }

        Date currentTime = new Date();
        return currentTime.after(limitedDinnerOpen) && currentTime.before(limitedDinnerClose);
    }

    public boolean limitedLunchToday() {
        return limitedLunchOpen != null && limitedLunchClose != null;
    }

    public boolean limitedDinnerToday() {
        return limitedDinnerOpen != null && limitedDinnerClose != null;
    }

    public boolean isOpen() {
        return isBreakfastOpen() | isLunchOpen() | isDinnerOpen() | isLimitedLunchOpen() | isLimitedDinnerOpen();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreakfastMenu(ArrayList<FoodItem> breakfastMenu) {
        this.breakfastMenu = breakfastMenu;
    }

    public void setLunchMenu(ArrayList<FoodItem> lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public void setDinnerMenu(ArrayList<FoodItem> dinnerMenu) {
        this.dinnerMenu = dinnerMenu;
    }

    public void setLimitedLunchMenu(ArrayList<FoodItem> limitedLunchMenu) {
        this.limitedLunchMenu = limitedLunchMenu;
    }

    public void setLimitedDinnerMenu(ArrayList<FoodItem> limitedDinnerMenu) {
        this.limitedDinnerMenu = limitedDinnerMenu;
    }

    public Date getBreakfastOpen() {
        return breakfastOpen;
    }

    public void setBreakfastOpen(Date breakfastOpen) {
        this.breakfastOpen = breakfastOpen;
    }

    public Date getBreakfastClose() {
        return breakfastClose;
    }

    public void setBreakfastClose(Date breakfastClose) {
        this.breakfastClose = breakfastClose;
    }

    public Date getLunchOpen() {
        return lunchOpen;
    }

    public void setLunchOpen(Date lunchOpen) {
        this.lunchOpen = lunchOpen;
    }

    public Date getLunchClose() {
        return lunchClose;
    }

    public void setLunchClose(Date lunchClose) {
        this.lunchClose = lunchClose;
    }

    public Date getDinnerOpen() {
        return dinnerOpen;
    }

    public void setDinnerOpen(Date dinnerOpen) {
        this.dinnerOpen = dinnerOpen;
    }

    public Date getDinnerClose() {
        return dinnerClose;
    }

    public void setDinnerClose(Date dinnerClose) {
        this.dinnerClose = dinnerClose;
    }

    public void setLimitedLunchOpen(Date limitedLunchOpen) {
        this.limitedLunchOpen = limitedLunchOpen;
    }

    public Date getLimitedLunchClose() {
        return limitedLunchClose;
    }

    public void setLimitedLunchClose(Date limitedLunchClose) {
        this.limitedLunchClose = limitedLunchClose;
    }

    public void setLimitedDinnerOpen(Date limitedDinnerOpen) {
        this.limitedDinnerOpen = limitedDinnerOpen;
    }

    public Date getLimitedDinnerClose() {
        return limitedDinnerClose;
    }

    public void setLimitedDinnerClose(Date limitedDinnerClose) {
        this.limitedDinnerClose = limitedDinnerClose;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "DiningHall{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", breakfastMenu=" + breakfastMenu +
                ", lunchMenu=" + lunchMenu +
                ", dinnerMenu=" + dinnerMenu +
                ", limitedLunchMenu=" + limitedLunchMenu +
                ", limitedDinnerMenu=" + limitedDinnerMenu +
                ", breakfastOpen=" + breakfastOpen +
                ", breakfastClose=" + breakfastClose +
                ", lunchOpen=" + lunchOpen +
                ", lunchClose=" + lunchClose +
                ", dinnerOpen=" + dinnerOpen +
                ", dinnerClose=" + dinnerClose +
                ", limitedLunchOpen=" + limitedLunchOpen +
                ", limitedLunchClose=" + limitedLunchClose +
                ", limitedDinnerOpen=" + limitedDinnerOpen +
                ", limitedDinnerClose=" + limitedDinnerClose +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
