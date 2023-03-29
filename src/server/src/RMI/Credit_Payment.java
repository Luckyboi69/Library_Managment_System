package RMI;

public class Credit_Payment implements PaymentStrategy{
    String Card_Type;
    String Card_number;
    String  ZIP_Code;
    String  CVV;

    public String getCard_Type() {
        return Card_Type;
    }

    public void setCard_Type(String Card_Type) {
        this.Card_Type = Card_Type;
    }

    public String getCard_number() {
        return Card_number;
    }

    public void setCard_number(String Card_number) {
        this.Card_number = Card_number;
    }

    public String getZIP_Code() {
        return ZIP_Code;
    }

    public void setZIP_Code(String ZIP_Code) {
        this.ZIP_Code = ZIP_Code;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public Credit_Payment(String Card_Type, String Card_number, String ZIP_Code, String CVV) {
        this.Card_Type = Card_Type;
        this.Card_number = Card_number;
        this.ZIP_Code = ZIP_Code;
        this.CVV = CVV;
    }
    
    @Override
    public void pay(int price) {
        System.out.println(price +" paid with credit/debit card");

    }
}
