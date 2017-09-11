# 题目:羽毛球馆

**运行环境**：
- **JDK 1.8**
- **Junit  4.12**
- **IntelliJ IDEA**
		
## 代码结构
├── dao **数据接口**
│   └── impl **数据接口实现**
├── entity **实体**
├── Controller.java **控制类**
├── Main.java **运行入口**
├── service **业务层接口**
│   └── implService **业务层实现**
└── util **工具**

## 如何运行该程序
在src根目录中,运行Main.java中的main()函数
```
[示例运行结果1]

abcdefghijklmnopqrst1234567890
> Error: the booking is invalid!
U001 2016-06-02 22:00~22:00 A
> Error: the booking is invalid!
U002 2017-08-01 19:00~22:00 A
> Success: the booking is accepted!
U003 2017-08-02 13:00~17:00 B
> Success: the booking is accepted!
U004 2017-08-03 15:00~16:00 C
> Success: the booking is accepted!
U005 2017-08-05 09:00~11:00 D
> Success: the booking is accepted!

> 收入汇总
> ---
场地:A
> 2017-08-01 19:00~22:00 200元
> 小计:200元
>
场地:B
> 2017-08-02 13:00~17:00 200元
> 小计:200元
>
场地:C
> 2017-08-03 15:00~16:00 50元
> 小计:50元
>
场地:D
> 2017-08-05 09:00~11:00 80元
> 小计:80元
>
> ---
> 总计:530元

[示例运行结果2]

U002 2017-08-01 19:00~22:00 A
> Success: the booking is accepted!
U003 2017-08-01 18:00~20:00 A
> Error: the booking conflicts with existing bookings!
U002 2017-08-01 19:00~22:00 A C
> Success: the booking is accepted!
U002 2017-08-01 19:00~22:00 A C
> Error: the booking being cancelled does not exist!
U003 2017-08-01 18:00~20:00 A
> Success: the booking is accepted!
U003 2017-08-02 13:00~17:00 B
> Success: the booking is accepted!

> 收入汇总
> ---
场地:A
> 2017-08-01 18:00~20:00 160元
> 2017-08-01 19:00~22:00 违约金 100元
> 小计:260元
>
场地:B
> 2017-08-02 13:00~17:00 200元
> 小计:200元
>
场地:C
> 小计:0元
>
场地:D
> 小计:0元
>
> ---
> 总计:460元
```


## 关于单元测试

本程序使用**Junit  4.12**进行单元测试,测试数据仅为开发过程中为了验证程序的正确性,完整性
