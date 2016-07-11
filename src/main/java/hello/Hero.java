package hello;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Hicham on 07-07-16.
 */
@Entity
public class Hero {

    private Long id;
    private String name;

    //constructor par défaut
    Hero(){
        // this form used by Hibernate
    }

    public Hero(String name) {
        // for application use, to create new hero
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment" , strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
