public class DailyTemperature {

    Integer min;
    Integer max;

    Integer lineNumber;

    String lineId;

    public DailyTemperature(Integer min, Integer max, Integer lineNumber) {
        this.min = min;
        this.max = max;
        this.lineNumber = lineNumber;
    }

    public DailyTemperature(Integer min, Integer max, String lineId) {
        this.min = min;
        this.max = max;
        this.lineId = lineId;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getTemperatureDifference() {
        return this.max - this.min;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    @Override
    public String toString() {
        return "DailyTemperature{" +
                "min=" + min +
                ", max=" + max +
                ", diff=" + getTemperatureDifference() +
                ", lineNumber=" + lineNumber +
                ", lineId=" + lineId +
                '}';
    }
}
