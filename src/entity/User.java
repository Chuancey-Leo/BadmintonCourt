package entity;

public class User {
    //用户id
    private String userId;
    //个人预订或取消场地的花费
    private String bookingPrice;
    //预订或取消记录
    private PriceTime priceTime;
    //是否预订了场地
    private boolean isBooking = true;
    //预订的场地名字
    private String bookingName;


    public String toString() {
        return userId+priceTime.getDate()+priceTime.getTimeSegment()+bookingName;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getBookingPrice() {
        return bookingPrice;
    }
    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }
    public boolean isBooking() {
        return isBooking;
    }
    public void setBooking(boolean booking) {
        isBooking = booking;
    }
    public String getBookingName() {
        return bookingName;
    }
    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }
    public PriceTime getPriceTime() {
        return priceTime;
    }
    public void setPriceTime(PriceTime priceTime) {
        this.priceTime = priceTime;
    }
}
