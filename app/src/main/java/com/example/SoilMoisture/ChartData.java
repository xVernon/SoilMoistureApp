package com.example.SoilMoisture;

import java.util.ArrayList;
import java.util.List;

public class ChartData {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private float measurment;

    List <Object> dataList = new ArrayList<Object>();

    public ChartData(int day, int month, int year, int hour, int minute, float measurment) {
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
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
