package hu.alerant.cc.third;

public class ComparedItem {

    Integer lowValue;
    Integer highValue;

    String itemId;

    public ComparedItem(Integer min, Integer max, String lineId) {
        this.lowValue = min;
        this.highValue = max;
        this.itemId = lineId;
    }

    public Integer getLowValue() {
        return lowValue;
    }

    public void setLowValue(Integer lowValue) {
        this.lowValue = lowValue;
    }

    public Integer getHighValue() {
        return highValue;
    }

    public void setHighValue(Integer highValue) {
        this.highValue = highValue;
    }

    public Integer getDifference() {
        return this.highValue - this.lowValue;
    }

    public Integer getAbsDifference() {
        return Math.abs(this.highValue - this.lowValue);
    }
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "ComparedItem{" +
                "itemId=" + itemId +
                ", lowValue=" + lowValue +
                ", highValue=" + highValue +
                ", diff=" + getDifference() +
                '}';
    }
}

