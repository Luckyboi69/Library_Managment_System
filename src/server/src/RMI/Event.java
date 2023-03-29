package RMI;

class Event {
    private int Event_id;
    private String Description;
    private String Event_Date;
    private String Event_title;
    private int Event_capacity;



    public Event(int Event_id, String Description, String Event_Date, String Event_title, int Event_capacity) {
        this.Event_id = Event_id;
        this.Description = Description;
        this.Event_Date = Event_Date;
        this.Event_title = Event_title;
        this.Event_capacity = Event_capacity;
        
    }



   

    public Event() {
        
    }

  

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setEvent_Date(String Event_Date) {
        this.Event_Date = Event_Date;
    }

    public void setEvent_title(String Event_title) {
        this.Event_title = Event_title;
    }

    public void setEvent_capacity(int Event_capacity) {
        this.Event_capacity = Event_capacity;
    }

   

    public String getDescription() {
        return Description;
    }

    public String getEvent_Date() {
        return Event_Date;
    }

    public String getEvent_title() {
        return Event_title;
    }

    public int getEvent_capacity() {
        return Event_capacity;
    }

    public int getEvent_id() {
        return Event_id;
    }

    public void setEvent_id(int Event_id) {
        this.Event_id = Event_id;
    }
  
}
