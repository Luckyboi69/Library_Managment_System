package RMI;

class Feedback {
    private int feedbackID;
    private String Title;
    private String Description;
    private int experienceRate; // form 0 to 10

    public Feedback(int feedbackID, String Title, String Description, int experienceRate) {
        this.feedbackID = feedbackID;
        this.Title = Title;
        this.Description = Description;
        this.experienceRate = experienceRate;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getExperienceRate() {
        return experienceRate;
    }

    public void setExperienceRate(int experienceRate) {
        this.experienceRate = experienceRate;
    }
    
    
}
