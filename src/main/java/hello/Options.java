package hello;

/**
 * Created by Hicham on 05-07-16.
 */
public class Options {

    private final long id;
    private final String name;

    public Options (long id, String name){

        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
