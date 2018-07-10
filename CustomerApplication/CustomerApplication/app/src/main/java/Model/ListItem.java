package Model;




public class ListItem {

    private String description;
    private String status;


    public ListItem(String description, String status) {

        this.description = description;
        this.status=status;

    }

     public String getDescription() {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
