package entity;

import java.util.List;

public class Court {
    //Court名字
    private String name;
    //预订与取消的用户信息
    private List<User> userList;
    //总收入
    private int sumPrice;
    //价格区间
    private List<PriceTime> priceTimeList;


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

}
