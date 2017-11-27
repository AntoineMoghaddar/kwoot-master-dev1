package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses;

/**
 * Created by gebruiker on 17/11/2017.
 */

public class User {

    private String username, password, gender;

    public User(String username, String password, String gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
