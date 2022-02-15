import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/resources/football.dat");
        FileReader fileReader = new FileReader(path);
        List<String> fileLines = fileReader.readLinesFromFile();



        FileProcessor fileProcessor = new FileProcessor(fileLines);

        DailyTemperature minTempDiffDay = fileProcessor.getDayWithMinimalTemperatureDifference();

        System.out.println("Minimum érték:" + minTempDiffDay.getTemperatureDifference());
        System.out.println("Min érték sora:" + minTempDiffDay.getLineNumber());
        System.out.println("Min érték azonosítója:" + minTempDiffDay.getLineId());
    }
}
