package hu.alerant.cc.third;

public class ResultItem {

    ComparedItem comparedItem;

    Integer result;

    public ResultItem() {
    }

    public ResultItem(ComparedItem comparedItem, Integer result) {
        this.comparedItem = comparedItem;
        this.result = result;
    }

    public ComparedItem getComparedItem() {
        return comparedItem;
    }

    public void setComparedItem(ComparedItem comparedItem) {
        this.comparedItem = comparedItem;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
