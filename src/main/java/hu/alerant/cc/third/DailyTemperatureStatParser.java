package hu.alerant.cc.third;

public class DailyTemperatureStatParser extends RowParser {

    @Override
    public boolean validate(String line) {
        if (line.contains("Dy")
                || line.isEmpty()
                || line.contains("mo")) {
            return false;
        }

        return true;
    }

    @Override
    Integer getDifference(ComparedItem stat) {
        return stat.getDifference();
    }

    @Override
    Integer getLineIdColumn() {
        return 0;
    }

    @Override
    Integer getFirstValueColumn() {
        return 1;
    }

    @Override
    Integer getSecondValueColumn() {
        return 2;
    }
}
