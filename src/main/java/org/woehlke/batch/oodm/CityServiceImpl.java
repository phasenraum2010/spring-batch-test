package org.woehlke.batch.oodm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tw on 28.03.17.
 */
@Service
@Transactional(propagation= Propagation.REQUIRED,readOnly = true)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW,readOnly = false)
    public void create(City city) {
        cityDao.create(city);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW,readOnly = false)
    public int deleteAll() {
        return cityDao.deleteAll();
    }
}
