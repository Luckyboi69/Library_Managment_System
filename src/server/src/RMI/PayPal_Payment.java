package RMI;

public class PayPal_Payment implements PaymentStrategy{
    String UserNmae;
    String PassWord;

    public PayPal_Payment() {
        
    }
    public String getUserNmae() {
        return UserNmae;
    }

    public void setUserNmae(String UserNmae) {
        this.UserNmae = UserNmae;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    

    public PayPal_Payment(String UserNmae, String PassWord) {
        this.UserNmae = UserNmae;
        this.PassWord = PassWord;
    }

    @Override
    public void pay(int price) {
        System.out.println(price + " paid using Paypal."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
