import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CCTask1 {

    public static List<String> readFileInList(String fileName)
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

    public static void main(String[] args) throws Exception {

        List l = readFileInList("src/main/resources/weather.dat");

        Iterator<String> itr = l.iterator();
        String sor = null;
        Float minimum = Float.MAX_VALUE;
        String minSor = null;
        Float min = null;
        Float max = null;

        int i = 0;
        while (itr.hasNext()) {
            sor = itr.next();

            if (i == 0 || i == 1) {
                i++;
                continue;
            }
            i++;


            sor = sor.trim();
            sor = sor.replaceAll("( )+", " ");
            System.out.println(sor);

            String[] splitString = sor.split(" ");
            String sorszam = splitString[0];
            try {
                max = Float.valueOf(splitString[1]);
                min = Float.valueOf(splitString[2]);
            } catch (Exception e) {
                continue;
            }

            Float kulonbseg = max - min;
            if (kulonbseg < minimum) {
                minimum = kulonbseg;
                minSor = sorszam;
            }
            System.out.println("Min:" + minimum);
            System.out.println("Min Sor:" + minSor);

        }

    }
}
