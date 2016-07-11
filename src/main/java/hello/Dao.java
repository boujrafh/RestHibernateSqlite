package hello;

import java.util.Collection;

/**
 * Created by Hicham on 08-07-16.
 */
public interface Dao {


    Collection<Hero> getAllHeroes();

    void deleteById(Long id);

    Hero add(Hero hero);

    void update(Hero hero);
}
