package entity;

import java.util.ArrayList;
import java.util.List;

public class Court {
    //Court名字
    private String name;
    //预订与取消的用户信息
    private List<User> userList = new ArrayList<>();
    //总收入
    private int sumPrice;
    //价格区间
    private List<PriceTime> priceTimeList = new ArrayList<PriceTime>(){{
        add(new PriceTime("9:00~12:00",30));
        add(new PriceTime("12:00~18:00",50));
        add(new PriceTime("18:00~20:00",80));
        add(new PriceTime("20:00~22:00",60));
    }};

    private List<PriceTime> priceWeekendList = new ArrayList<PriceTime>(){{
        add(new PriceTime("9:00~12:00",40));
        add(new PriceTime("12:00~18:00",50));
        add(new PriceTime("18:00~22:00",60));
    }};


    public Court(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getUserList() {
        return userList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public int getSumPrice() {
        return sumPrice;
    }
    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
    public List<PriceTime> getPriceTimeList() {
        return priceTimeList;
    }
    public void setPriceTimeList(List<PriceTime> priceTimeList) {
        this.priceTimeList = priceTimeList;
    }
    public void addUser(User user) {
        this.userList.add(user);
    }
    public List<PriceTime> getPriceWeekendList() {
        return priceWeekendList;
    }
    public void setPriceWeekendList(List<PriceTime> priceWeekendList) {
        this.priceWeekendList = priceWeekendList;
    }
}
