package hu.alerant.cc.third;

import java.util.ArrayList;
import java.util.List;

abstract class RowParser {

    abstract boolean validate(String line);

    //abstract ComparedItem transform(String line);

    abstract Integer getDifference(ComparedItem stat);

    abstract Integer getLineIdColumn();

    abstract Integer getFirstValueColumn();

    abstract Integer getSecondValueColumn();

    public ResultItem getMinDifference(List<String> lines) {

        List<ComparedItem> stats = new ArrayList<>();
        for (String line : lines) {
            line = cleanLine(line);

            if (!validate(line)) {
                continue;
            }

            try {
                stats.add(transform(line));
            } catch (Exception e) {
                //
            }
        }

        ResultItem minDifference = new ResultItem();
        for (ComparedItem stat : stats) {
            if (minDifference.getResult() == null || getDifference(stat) < minDifference.getResult()) {
                minDifference.setComparedItem(stat);
                minDifference.setResult(getDifference(stat));
            }
        }
        return minDifference;
    }

    private String cleanLine(String line) {
        line = line.trim();
        line = line.replaceAll("( )+", " ");

        return line;
    }

    public ComparedItem transform(String line) {
        ComparedItem dailyTemperatureStat = null;
        String[] lineItem = line.split(" ");
        String lineId = String.valueOf(lineItem[getLineIdColumn()]);

        Integer maxTemperature = Integer.valueOf(lineItem[getFirstValueColumn()]);
        Integer minTemperature = Integer.valueOf(lineItem[getSecondValueColumn()]);
        dailyTemperatureStat = new ComparedItem(minTemperature, maxTemperature, lineId);

        System.out.println(dailyTemperatureStat.toString());

        return dailyTemperatureStat;
    }
}
