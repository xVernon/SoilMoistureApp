package com.example.SoilMoisture;

import java.util.ArrayList;
import java.util.List;

public class ChartData {

    private int day;
    private int month;
    private int year;
    private String hour;
    private String minute;
    private float measurment;

    List <Object> dataList = new ArrayList<Object>();

    public ChartData(int day, int month, int year, String hour, String minute, float measurment) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.measurment = measurment;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public float getMeasurment() {
        return measurment;
    }

    public void setMeasurment(float measurment) {
        this.measurment = measurment;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }
}
