package com.example.SoilMoisture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CollectionData {

    private ChartDataService chartDataService;

    public Date GetLastMeasurmentDate() {
        chartDataService = new ChartDataService();

        Date date;

        List<ChartData> chartDataList = chartDataService.generateData();
        List<Date> dateDataMeasurment = new ArrayList<>();
        for (ChartData chartData : chartDataList) {
            date = new Date(chartData.getYear() + 2000, chartData.getMonth()-1,
                    chartData.getDay(),
                    Integer.parseInt(chartData.getHour()),
                    Integer.parseInt(chartData.getMinute()));
            dateDataMeasurment.add(date);
        }
        date = Collections.max(dateDataMeasurment);
        return date;
    }

    public String ReturnLastMeasurmentTime(Date date) {
        chartDataService = new ChartDataService();
        String time = null;
        String minutes = String.valueOf(date.getMinutes());
        String hours = String.valueOf(date.getHours());
        if(date.getMinutes() >= 0 && date.getMinutes() <=9) minutes = "0" + date.getMinutes();
        if(date.getHours() >= 0 && date.getHours() <=9) hours = "0" + date.getHours();
        time = hours + ":" + minutes;
        return time;
    }

    public String ReturnLastMeasurmentDateShortVersion(Date date) {
        chartDataService = new ChartDataService();
        String shortVersionDate = null;
        String day = String.valueOf(date.getDate());
        String month = String.valueOf(date.getMonth()+1);
        String year = String.valueOf(date.getYear());
        if(date.getDate() >= 0 && date.getDate() <=9) day = "0" + date.getDate();
        if(date.getMonth() >= 0 && date.getMonth() <=9) month = "0" + (date.getMonth()+1);
        shortVersionDate = day + "." + month + "." + year;
        return shortVersionDate;
    }

    public float GetLastMeasurment(Date date) {
        chartDataService = new ChartDataService();

        int year, month, day, hour, minute;
        float lastMeasurment = 0;

        year = date.getYear() - 2000;
        month = date.getMonth() + 1;
        day = date.getDate();
        hour = date.getHours();
        minute = date.getMinutes();

        List<ChartData> chartDataList = chartDataService.generateData();
        for (ChartData chartData : chartDataList) {
            if (chartData.getDay() == day &&
                    chartData.getMonth() == month &&
                    chartData.getYear() == year &&
                    Integer.parseInt(chartData.getHour()) == hour &&
                    Integer.parseInt(chartData.getMinute()) == minute) {
                lastMeasurment = chartData.getMeasurment();
            }
        }
        return lastMeasurment;
    }

    public List<Float> CollectionDailyData(int day, int month, int year) {
        chartDataService = new ChartDataService();

        List<ChartData> chartDataList = chartDataService.generateData();
        List<Float> floatDataMeasurment = new ArrayList<>();
        for (ChartData chartData : chartDataList) {
            if (chartData.getDay() == day &&
                    chartData.getMonth() == month &&
                    chartData.getYear() == year) {
                floatDataMeasurment.add(chartData.getMeasurment());
            }
        }
        return floatDataMeasurment;
    }

    public List<String> GetTimeOfMeasurment(int day, int month, int year) {
        chartDataService = new ChartDataService();
        String hour;
        String minute;

        String time;
        List<ChartData> chartDataList = chartDataService.generateData();
        List<String> timeDataList = new ArrayList<>();

        for (ChartData chartData : chartDataList) {
            if (chartData.getDay() == day &&
                    chartData.getMonth() == month &&
                    chartData.getYear() == year) {
                hour = chartData.getHour();
                minute = chartData.getMinute();
                time = hour + ":" + minute;
                timeDataList.add(time);
            }
        }
        return timeDataList;
    }

    public float AverageMeasurmentPerDay(List<Float> floatDataMeasurment)
    {
        int listSize = floatDataMeasurment.size();
        float sumOfMeasurments = 0;

        for(float i : floatDataMeasurment)
        {
            sumOfMeasurments += i;
        }

        if(sumOfMeasurments == 0) return 0;
        return sumOfMeasurments/listSize;
    }
}
