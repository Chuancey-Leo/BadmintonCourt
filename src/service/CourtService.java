package service;

import entity.Court;
import entity.User;

import java.util.List;

/**
 * 对于场地的相关操作接口
 */
public interface CourtService {

    //场地预订
    public void booking(User user, Court court);
    //取消预订
    public void cancel(User user, Court court);
    //场地总的收入
    public void sum(List<Court> courts);
}
