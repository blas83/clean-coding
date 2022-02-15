package hu.alerant.cc.third;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileProcessor {

    Path path;

    RowParser rowParser;

    List<String> lines;

    public FileProcessor(Path path, RowParser rowParser) {
        this.path = path;
        this.rowParser = rowParser;

        lines = readLinesFromFile();
    }

    public ResultItem getMinDifference() {
        ResultItem difference = rowParser.getMinDifference(lines);

        return difference;
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
