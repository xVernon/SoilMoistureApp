package com.example.SoilMoisture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChartDataService {

    public List <ChartData> generateData() {
        File gpxfile = new File("/data/data/com.example.SoilMoisture/files/text/stats.txt");

        String dataTextFromFile = null;
        try {
            dataTextFromFile = readFile(gpxfile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List <ChartData> dataString = new ArrayList<>();
        for(String str : dataTextFromFile.split("<")){
            List<String> listString = new ArrayList<>();
            str.replace("<","");
            for(String str2 : str.split("/")){
                str2.replace("/","");
                listString.add(str2);

            }
            System.out.println(listString.get(0));
            ChartData chart = new ChartData(Integer.parseInt(listString.get(0)),
                    Integer.parseInt(listString.get(1)),
                    Integer.parseInt(listString.get(2)),
                    Integer.parseInt(listString.get(3)),
                    Integer.parseInt(listString.get(4)),
                    Float.parseFloat(listString.get(5)));

            dataString.add(chart);
        }
    return dataString;
    }


    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

}
