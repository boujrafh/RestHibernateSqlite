package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by Hicham on 07-07-16.
 */
@RestController
public class HeroController {


    private final Dao dao;

    @Autowired
    public HeroController(Dao dao) {
        this.dao = dao;
    }

    @RequestMapping("app/heroes")
    Collection<Hero> getHereos(){
        return dao.getAllHeroes();
    }


    @RequestMapping( value = "app/heroes/{id}" , method = DELETE)
    void deleteHero (@PathVariable Long id ){
        dao.deleteById(id);
    }

    @RequestMapping(value = "app/heroes", method = POST)
    public Hero add (@RequestBody Hero hero) {
           if (hero != null ) {
           dao.add(hero);
        }
        return hero;
    }

    @RequestMapping(value = "app/heroes/{id}" , method = PUT)
    void  updateHero (@PathVariable Long id , @RequestBody Hero hero ) {

        hero.setId(id);
        dao.update(hero);
    }



    //méthode 1 : juste afficher sur le serveur angular Hero et Richard
    /*
    private List<Hero> heroes = Arrays.asList(new Hero(123L , "Richard"));


    @RequestMapping("app/heroes")

    //@CrossOrigin(origins = "http://localhost:3000") , il faudra le faire à chaque fois donc on cela directement dans la class Application
    List<Hero> getHeroes() {
        return heroes;
    }

    */

    /*
    //Méthode 2 créer un map et faire une GET / PUT / DELETE. pour comprendre se référer au méthode dans Angluar httpRequest

    private Map<Long , Hero >heroes;
    private final AtomicLong counter = new AtomicLong();

    public HeroController() {
        heroes = new HashMap<>();
        heroes.put(counter.get(), new Hero (counter.get() , "Richard"));
    }

    @RequestMapping("app/heroes")
    Collection<Hero> getHereos(){
        return heroes.values();
    }

    @RequestMapping( value = "app/heroes/{id}" , method = DELETE)
    void deleteHero (@PathVariable Long id){
        heroes.remove(id);
    }

    @RequestMapping(value = "app/heroes", method = POST)
    public Hero add (@RequestBody Hero hero) {

        Long id = counter.incrementAndGet() ;

        if (hero != null ) {
           hero.setId(id);
            heroes.put(id, hero);
        }
        return hero;
    }

    @RequestMapping(value = "app/heroes/{id}" , method = PUT)
    void  updateHero (@PathVariable Long id , @RequestBody Hero hero ) {

        hero.setId((id));
        heroes.put(id, hero);
    }
*/

//avec Hibernate


}
