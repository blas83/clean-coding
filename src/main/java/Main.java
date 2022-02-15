import hu.alerant.cc.third.ComparedItem;
import hu.alerant.cc.third.DailyTemperatureStatParser;
import hu.alerant.cc.third.FootballStatParser;
import hu.alerant.cc.third.ResultItem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        //Path path = Paths.get("src/main/resources/football.dat");
        //FileReader fileReader = new FileReader(path);
        //List<String> fileLines = fileReader.readLinesFromFile();


        // második feladat
        //FileProcessor fileProcessor = new FileProcessor(fileLines);
        //DailyTemperature minTempDiffDay = fileProcessor.getDayWithMinimalTemperatureDifference();

        // harmadik feladat
        Path path = Paths.get("src/main/resources/weather.dat");
        DailyTemperatureStatParser dailyTemperatureStatParser = new DailyTemperatureStatParser();
        hu.alerant.cc.third.FileProcessor fileProcessor = new hu.alerant.cc.third.FileProcessor(path, dailyTemperatureStatParser);
        ResultItem minDifference = fileProcessor.getMinDifference();

        System.out.println("Minimum érték:" + minDifference.getResult());
        System.out.println("Min érték azonosítója:" + minDifference.getComparedItem().getItemId());

        minDifference = null;
        path = Paths.get("src/main/resources/football.dat");
        FootballStatParser footballStatParser = new FootballStatParser();
        fileProcessor = new hu.alerant.cc.third.FileProcessor(path, footballStatParser);
        minDifference = fileProcessor.getMinDifference();

        System.out.println("Minimum érték:" + minDifference.getResult());
        System.out.println("Min érték azonosítója:" + minDifference.getComparedItem().getItemId());
    }
}
