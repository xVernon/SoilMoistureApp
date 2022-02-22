package com.example.SoilMoisture;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class stats extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    public static final String EXTRA_TEXT1 = "com.example.a531calculator.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 = "com.example.a531calculator.example.EXTRA_TEXT2";
    public static final String EXTRA_NUMBER2 = "com.example.a531calculator.example.EXTRA_NUMBER2";

    boolean clicked = false;
    private PieChart chart1;
    private BarChart chart2;
    private PieChart chart3;

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        TextView text = (TextView) findViewById(R.id.textView14);
        TextView text24 = (TextView) findViewById(R.id.textView24);
        TextView text25 = (TextView) findViewById(R.id.textView25);
        TextView text38 = (TextView) findViewById(R.id.textView38);
        TextView text39 = (TextView) findViewById(R.id.textView39);

        text24.setText("15:24");
        text25.setText("23.01.22");
        text38.setText("Entire Period");
        text39.setText("Average\nmeasurement");
        text.setText(chooseOption.choosenOption);

        //PIECHART

        PieChart pieChart = (PieChart) findViewById(R.id.chart1);

        float measure = (float) 60.8;

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        Legend l = pieChart.getLegend();
        l.setEnabled(false);

        pieChart.setCenterText(String.valueOf(measure)+" %\nLast Measure");
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setCenterTextSize(20f);

        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setRotationEnabled(false);
        pieChart.setHoleColor(Color.TRANSPARENT);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(measure, ""));
        entries.add(new PieEntry(100.0f-measure));

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




        //PIECHART

        //BARCHART

        BarChart barChart = (BarChart) findViewById(R.id.chart2);

        barChart.setOnChartValueSelectedListener(this);

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

        List<BarEntry> entries1 = new ArrayList<>();
        List<Float> entries11 = new ArrayList<>();
        entries1.add(new BarEntry(1f, 20f));
        entries1.add(new BarEntry(2f, 60f));
        entries1.add(new BarEntry(3f, 45f));
        entries1.add(new BarEntry(4f, 78f));
        entries1.add(new BarEntry(5f, 42f));
        entries1.add(new BarEntry(6f, 75f));

        entries11.add(20f);
        entries11.add(60f);
        entries11.add(45f);
        entries11.add(78f);
        entries11.add(42f);
        entries11.add(75f);

        BarDataSet set1 = new BarDataSet(entries1, "BarDataSet");

        BarData data1 = new BarData(set1);
        data1.setValueTextColor(Color.WHITE);
        data1.setBarWidth(0.8f); // set custom bar width
        barChart.setData(data1);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars

        barChart.setData(data1);

        //BARCHART


        //AVGCHART


        PieChart pieChart2 = (PieChart) findViewById(R.id.chart3);

        double sum = 0;
        for(int i = 0; i < entries11.size(); i++)
            sum += entries11.get(i);

        double avg = sum/entries11.size();
        float avg2 = (float) (Math.floor(avg * 100) / 100);

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

        set3.setColors(colors);

        PieData data3 = new PieData(set3);

        data3.setValueTextSize(12f);
        data3.setValueTextColor(Color.TRANSPARENT);

        pieChart2.setData(data3);


        //pieChart.invalidate(); // refresh

        //AVGCHART

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}