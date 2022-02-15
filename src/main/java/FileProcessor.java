import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    List<String> fileLines = new ArrayList<>();

    public FileProcessor(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    private static boolean validate(String line) {
        if (line.contains("Team")
                || line.isEmpty()
                || line.contains("------")) {
            return false;
        }

        return true;
    }

    public DailyTemperature transform(String line) throws Exception {

        DailyTemperature dailyTemperature = null;
        String[] lineItem = line.split(" ");
        String lineId = String.valueOf(lineItem[1]);

        Integer max = Integer.valueOf(lineItem[6]);
        Integer min = Integer.valueOf(lineItem[8]);
        dailyTemperature = new DailyTemperature(min, max, lineId);

        System.out.println(dailyTemperature.toString());

        return dailyTemperature;
    }

    public DailyTemperature getDayWithMinimalTemperatureDifference() {

        List<DailyTemperature> dailyTemperatures = new ArrayList<>();
        for (String line : fileLines) {
            line = cleanLine(line);

            if (!validate(line)) {
                continue;
            }

            try {
                dailyTemperatures.add(transform(line));
            } catch (Exception e) {
                //
            }
        }

        DailyTemperature minDiffDay = null;
        for (DailyTemperature dailyTemperature : dailyTemperatures) {
            if (minDiffDay == null || Math.abs(dailyTemperature.getTemperatureDifference()) < Math.abs(minDiffDay.getTemperatureDifference())) {
                minDiffDay = dailyTemperature;
            }
        }
        return minDiffDay;
    }

    private String cleanLine(String line) {
        line = line.trim();
        line = line.replaceAll("( )+", " ");

        return line;
    }
}
