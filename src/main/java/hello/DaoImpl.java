package hello;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * Created by Hicham on 08-07-16.
 */
@Component
public class DaoImpl implements Dao {

    private EntityManagerFactory entityManagerFactory;

    public DaoImpl() {

        entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );

    }

    @Override
    public Collection<Hero> getAllHeroes() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Collection<Hero> result = entityManager.createQuery("from Hero" , Hero.class).getResultList();
        entityManager.getTransaction();
        entityManager.close();
        return result;

    }

    @Override
    public void deleteById(Long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Hero where id = :id").setParameter("id",id).executeUpdate(); //remove l'id
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Hero add(Hero hero) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(hero);
        entityManager.getTransaction().commit();
        entityManager.close();
        return hero;
    }


    @Override
    public void update(Hero hero) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(hero);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
