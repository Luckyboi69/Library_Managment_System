package RMI;

class Document {
    enum documentsType  {Pdf, Doc, Docx};
    private String type;
    private String size;
    private String Title;

    public Document(String type, String size, String Title) {
        this.type = type;
        this.size = size;
        this.Title = Title;
    }

//    public documentsType getType() {
//        return type;
//    }
//
//    public void setType(documentsType type) {
//        this.type = type;
//    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

}
