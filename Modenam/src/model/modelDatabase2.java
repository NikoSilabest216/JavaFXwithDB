package model;//5/30/2021//
import javafx.beans.property.SimpleStringProperty;
//Niko Silabest//
//IntelliJ IDEA//
public class modelDatabase2 {
    public String getUser() {
        return user.get();
    }


    public void setUser(String user) {
        this.user.set(user);
    }

    public String getPass() {
        return pass.get();
    }


    public void setPass(String pass) {
        this.pass.set(pass);
    }

    public final SimpleStringProperty user;
    public final SimpleStringProperty pass;

    public modelDatabase2(String fuser, String fpass)
    {
        this.user =new SimpleStringProperty(fuser);
        this.pass = new SimpleStringProperty(fpass);
    }

}
