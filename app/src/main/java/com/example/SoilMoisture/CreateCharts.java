package com.example.SoilMoisture;

import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class CreateCharts {

    private PieChart chart1;
    private BarChart chart2;
    private PieChart chart3;

    public void CreatePieChart(float lastMeasurmentValue, View view) {

        PieChart pieChart = (PieChart) view.findViewById(R.id.chart1);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        Legend l = pieChart.getLegend();
        l.setEnabled(false);

        pieChart.setCenterText(String.valueOf(lastMeasurmentValue)+" %\nLast Measurment");
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setCenterTextSize(20f);

        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setRotationEnabled(false);
        pieChart.setHoleColor(Color.TRANSPARENT);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(lastMeasurmentValue, ""));
        entries.add(new PieEntry(100.0f-lastMeasurmentValue));

        PieDataSet set = new PieDataSet(entries,"");

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.argb(170,60,210,255));
        colors.add(Color.TRANSPARENT);


        set.setColors(colors);

        PieData data = new PieData(set);

        data.setValueTextSize(12f);
        data.setValueTextColor(Color.TRANSPARENT);

        pieChart.setData(data);
        //pieChart.invalidate(); // refresh

    }

    public void CreateBarChart(List<Float> floatEntry, View view) {
        BarChart barChart = (BarChart) view.findViewById(R.id.chart2);
        //barChart.setOnChartValueSelectedListener(this);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.getDescription().setEnabled(false);
        Legend l1 = barChart.getLegend();
        l1.setEnabled(false);

        barChart.setMaxVisibleValueCount(30);

        barChart.setDrawGridBackground(false);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextColor(Color.WHITE);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setTextColor(Color.WHITE);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        // chart.setDrawLegend(false);

        List<BarEntry> barEntry = new ArrayList<>();
        float value;
        //List<Float> entries11 = new ArrayList<>();
        for (int i = 0; i < floatEntry.size(); i++) {
            value = floatEntry.get(i);
            barEntry.add(new BarEntry(i+1, value));
        }



        BarDataSet set1 = new BarDataSet(barEntry, "BarDataSet");

        BarData data1 = new BarData(set1);
        data1.setValueTextColor(Color.WHITE);
        data1.setBarWidth(0.8f); // set custom bar width
        barChart.setData(data1);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars

        barChart.setData(data1);
    }

    public void CreateAvgChart(List<Float> floatEntry, View view) {
        PieChart pieChart2 = (PieChart) view.findViewById(R.id.chart3);

        double sum = 0;
        double avg = 0;
        float avg2 = 0;
        for(int i = 0; i < floatEntry.size(); i++)
            sum += floatEntry.get(i);

        if(sum != 0)
        {
            avg = sum/floatEntry.size();
            avg2 = (float) (Math.floor(avg * 100) / 100);
        }

        pieChart2.setUsePercentValues(true);
        pieChart2.getDescription().setEnabled(false);
        Legend l2 = pieChart2.getLegend();
        l2.setEnabled(false);

        pieChart2.setCenterText(String.valueOf(avg2)+" %");
        pieChart2.setCenterTextColor(Color.WHITE);
        pieChart2.setCenterTextSize(20f);

        pieChart2.setHoleRadius(58f);
        pieChart2.setTransparentCircleRadius(61f);
        pieChart2.setRotationEnabled(false);
        pieChart2.setHoleColor(Color.TRANSPARENT);

        List<PieEntry> entries3 = new ArrayList<>();

        entries3.add(new PieEntry(avg2, ""));
        entries3.add(new PieEntry(100.0f-avg2));

        PieDataSet set3 = new PieDataSet(entries3,"");

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.argb(170,60,210,255));
        colors.add(Color.TRANSPARENT);

        set3.setColors(colors);

        PieData data3 = new PieData(set3);

        data3.setValueTextSize(12f);
        data3.setValueTextColor(Color.TRANSPARENT);

        pieChart2.setData(data3);
    }
}
