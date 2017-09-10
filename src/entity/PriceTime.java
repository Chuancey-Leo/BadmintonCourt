package entity;

public class PriceTime {
    //yyyy-MM-dd
    private String date;
    //hh:mm~hh:mm
    private String timeSegment;
    //对应的价格
    private int price;

    public PriceTime(String date, String timeSegment) {
        this.date = date;
        this.timeSegment = timeSegment;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTimeSegment() {
        return timeSegment;
    }
    public void setTimeSegment(String timeSegment) {
        this.timeSegment = timeSegment;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
