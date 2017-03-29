package org.woehlke.batch.oodm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.batch.conf.Config;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by tw on 28.03.17.
 */
@Service
@Transactional(propagation= Propagation.REQUIRED,readOnly = true)
public class CityServiceImpl implements CityService {

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    private final CityDao cityDao;

    private final Config config;

    @Autowired
    public CityServiceImpl(CityDao cityDao, Config config) {
        this.cityDao = cityDao;
        this.config = config;
    }

    @PostConstruct
    public void checkConfig() {
        log.info("RemoteAddress: "+config.getRemoteAddress());
        log.info("Username: "+config.getSecurity().getUsername());
        log.info("Thomas: "+config.getThomas());
        for(String role:config.getSecurity().getRoles()){
            log.info("Role: "+role);
        }
        for(String willy:config.getWilly()){
            log.info("Willy: "+willy);
        }
    }

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
