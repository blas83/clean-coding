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
        while (itr.hasNext()) {
            sor = itr.next();
            sor = sor.replaceAll("( )+", " ");
            System.out.println(sor);

            String[] splitString = sor.split(" ");
            System.out.println("Elem0:" + splitString[0]);
            
        }

    }
}
