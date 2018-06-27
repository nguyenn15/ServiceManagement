package Model;


import android.widget.Button;

public class ListItem {

    private String description;
    private String buttonText;

    public ListItem( String description, String buttonText) {

        this.description = description;
        this.buttonText=buttonText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }
}
