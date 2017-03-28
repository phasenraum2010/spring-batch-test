package org.woehlke.batch.oodm;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by tw on 28.03.17.
 */
@Repository
public class CityDaoImpl implements CityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<City> findAll() {
        return entityManager.createQuery("select c from City c",City.class).getResultList();
    }

    @Override
    public void create(City city) {
        entityManager.persist(city);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("delete from City c").executeUpdate();
    }
}
