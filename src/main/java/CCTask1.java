import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CCTask1 {

    public static List<String> readLinesFromFile(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try
        {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {

            // do something
            e.printStackTrace();
        }
        return lines;
    }

    private static boolean validate(String line) {
        if (line.startsWith("Dy")
                || line.isEmpty()
                || line.startsWith("mo")) {
            return false;
        }

        return true;
    }

    private static DailyTemperature getDailyTemperature(String line) throws Exception {

        DailyTemperature dailyTemperature = null;
        String[] lineItem = line.split(" ");
        Integer lineNumber = Integer.valueOf(lineItem[0]);

        Integer max = Integer.valueOf(lineItem[1]);
        Integer min = Integer.valueOf(lineItem[2]);
        dailyTemperature = new DailyTemperature(min, max, lineNumber);

        System.out.println(dailyTemperature.toString());

        return dailyTemperature;
    }

    public static void main(String[] args) throws Exception {

        List<String> fileLines = readLinesFromFile("src/main/resources/weather.dat");

        int lineNumber = 0;
        List<DailyTemperature> dailyTemperatures = new ArrayList<>();
        for (String line : fileLines) {
            lineNumber++;

            line = cleanLine(line);

            if (!validate(line)) {
                continue;
            }

            try {
                dailyTemperatures.add(getDailyTemperature(line));
            } catch (Exception e) {
                //
            }
        }

        DailyTemperature minTempDiffDay = getMinTempDiffDay(dailyTemperatures);

        System.out.println("Minimum érték:" + minTempDiffDay.getTemperatureDifference());
        System.out.println("Min érték sora:" + minTempDiffDay.getLineNumber());
    }

    private static DailyTemperature getMinTempDiffDay(List<DailyTemperature> dailyTemperatures) {
        DailyTemperature minDiffDay = null;
        for (DailyTemperature dailyTemperature : dailyTemperatures) {
            if (minDiffDay == null || dailyTemperature.getTemperatureDifference() < minDiffDay.getTemperatureDifference()) {
                minDiffDay = dailyTemperature;
            }
        }
        return minDiffDay;
    }

    private static String cleanLine(String line) {
        line = line.trim();
        line = line.replaceAll("( )+", " ");
        //System.out.println(sor);
        return line;
    }
}
