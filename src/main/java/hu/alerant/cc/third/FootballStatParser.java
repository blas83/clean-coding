package hu.alerant.cc.third;

public class FootballStatParser extends RowParser {

    @Override
    public boolean validate(String line) {
        if (line.contains("Team")
                || line.isEmpty()
                || line.contains("------")) {
            return false;
        }

        return true;
    }

    @Override
    Integer getDifference(ComparedItem stat) {
        return stat.getAbsDifference();
    }

    @Override
    Integer getLineIdColumn() {
        return 1;
    }

    @Override
    Integer getFirstValueColumn() {
        return 8;
    }

    @Override
    Integer getSecondValueColumn() {
        return 6;
    }
}
