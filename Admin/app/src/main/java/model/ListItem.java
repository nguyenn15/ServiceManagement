package model;


public class ListItem {

    private int id;
    private String status;
    private int idCustomer;

    public ListItem(int id, String status, int idCustomer) {

        this.id = id;
        this.status=status;
        this.idCustomer=idCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
