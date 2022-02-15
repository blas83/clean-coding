import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileReader {

    Path path;

    public FileReader(Path path) {
        this.path = path;
    }

    public List<String> readLinesFromFile()
    {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            // do something
            e.printStackTrace();
        }
        return lines;
    }

}
