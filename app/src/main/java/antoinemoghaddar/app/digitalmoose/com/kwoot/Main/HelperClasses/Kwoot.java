package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

/**
 * Created by gebruiker on 17/11/2017.
 */

public class Kwoot {

    private String author, text, location, date;
    private static int likes;

    public Kwoot(String author, String text, String location, String date) {
        this.author = author;
        this.text = text;
        this.location = location;
        this.date = date;
    }

    public Kwoot(String text, String location, String date) {
        this.text = text;
        this.location = location;
        this.date = date;
    }

    public Kwoot(String text, String author) {
        this.text = text;
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public static void addLikes() {
        Kwoot.likes++;
    }
}
