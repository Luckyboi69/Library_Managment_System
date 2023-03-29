package RMI;

public class Report {
    private int ReportID ;
    private String ReprotDescription;
    private int AccountID;

    public Report(int ReportID, String ReprotDescription, int AccountID) {
        this.ReportID = ReportID;
        this.ReprotDescription = ReprotDescription;
        this.AccountID = AccountID;
    }

    public Report() {
    }

    public int getReportID() {
        return ReportID;
    }

    public void setReportID(int ReportID) {
        this.ReportID = ReportID;
    }

    public String getReprotDescription() {
        return ReprotDescription;
    }

    public void setReprotDescription(String ReprotDescription) {
        this.ReprotDescription = ReprotDescription;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }
    
}
