package hello;

/**
 * Created by Hicham on 03-07-16.
 */
public class Greeting {

    private final long id;
    private final String content;
    private final String surname;

    public Greeting(long id, String content, String surname) {
        this.id = id;
        this.content = content;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSurname(){
        return surname;
    }
}
