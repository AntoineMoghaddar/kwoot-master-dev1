package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses;

/**
 * Created by gebruiker on 17/11/2017.
 */

public class Kwoot {

    private String author, text, location, date;
    private static int likes;

    public Kwoot() {
        //Needed for Firebase
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

    public static void setLikes(int likes) {
        Kwoot.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public static void addLikes() {
        Kwoot.likes++;
    }


    @Override
    public String toString() {
        return "Kwoot{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
