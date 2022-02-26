package com.example.SoilMoisture;

import java.util.ArrayList;
import java.util.List;

public class CollectionData {

    private ChartDataService chartDataService;

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
