package RMI;



class RoomDuration {
    private String StartDate;
    private String EndDate;
    private boolean Reserved;

    public RoomDuration() {
    }

    public RoomDuration(String StartDate, String EndDate) {
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Reserved = false;
    }

    

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public boolean isReserved() {
        return Reserved;
    }

    public void setReserved(boolean Reserved) {
        this.Reserved = Reserved;
    }
    
    
    
}
