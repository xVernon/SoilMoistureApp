package com.example.SoilMoisture;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stats extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    public static final String EXTRA_TEXT1 = "com.example.a531calculator.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 = "com.example.a531calculator.example.EXTRA_TEXT2";
    public static final String EXTRA_NUMBER2 = "com.example.a531calculator.example.EXTRA_NUMBER2";

    boolean clicked = false;
    private PieChart chart1;
    private BarChart chart2;
    private PieChart chart3;
    private ChartDataService chartDataService;
    private CollectionData collectionData;
    private Date date;
    private CreateCharts createCharts;

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        TextView text = (TextView) findViewById(R.id.textView14);
        TextView text24 = (TextView) findViewById(R.id.textView24);
        TextView text25 = (TextView) findViewById(R.id.textView25);
        TextView text38 = (TextView) findViewById(R.id.textView38);
        TextView text39 = (TextView) findViewById(R.id.textView39);

        chartDataService = new ChartDataService();
        collectionData = new CollectionData();
        createCharts = new CreateCharts();
        date = collectionData.GetLastMeasurmentDate();
        String lastMeasurmentTime;
        String lastMeasurmentDateShortVersion;
        float lastMeasurmentValue;
        List<Float> listOfMeasurment = new ArrayList<>();
        listOfMeasurment = collectionData.CollectionDailyData(25,02,22);

        lastMeasurmentTime = collectionData.ReturnLastMeasurmentTime(date);
        lastMeasurmentDateShortVersion = collectionData.ReturnLastMeasurmentDateShortVersion(date);
        lastMeasurmentValue = collectionData.GetLastMeasurment(date);

        text24.setText(lastMeasurmentTime);
        text25.setText(lastMeasurmentDateShortVersion);
        text38.setText("Entire Period");
        text39.setText("Average\nmeasurement");
        text.setText(ChooseOption.choosenOption);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.argb(170,60,210,255));
        colors.add(Color.TRANSPARENT);

        createCharts.CreatePieChart(lastMeasurmentValue, viewGroup);
        createCharts.CreateBarChart(listOfMeasurment, viewGroup);
        createCharts.CreateAvgChart(listOfMeasurment, viewGroup);
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