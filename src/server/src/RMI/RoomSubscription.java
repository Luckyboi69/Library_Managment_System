package RMI;

public class RoomSubscription {
    private PaymentStrategy ps;
    String Start_Date;
    String End_Date;
    //sc

    public RoomSubscription() {
    }

    public PaymentStrategy getPs() {
        return ps;
    }

    public void setPs(PaymentStrategy ps) {
        this.ps = ps;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(String Start_Date) {
        this.Start_Date = Start_Date;
    }

    public String getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(String End_Date) {
        this.End_Date = End_Date;
    }

    public RoomSubscription(PaymentStrategy ps, String Start_Date, String End_Date) {
        this.ps = ps;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
    }
   public void pay(PaymentStrategy x, int price){
       x.pay(price);
   }
}
