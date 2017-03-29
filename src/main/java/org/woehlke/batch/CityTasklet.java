package org.woehlke.batch;

import org.woehlke.batch.conf.Config;
import org.woehlke.batch.oodm.City;
import org.woehlke.batch.oodm.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tw on 28.03.17.
 */
@Component
public class CityTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final CityService cityService;

    private final Config config;

    @Autowired
    public CityTasklet(CityService cityService, Config config) {
        this.cityService = cityService;
        this.config = config;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("RemoteAddress: "+config.getRemoteAddress());
        log.info("Username: "+config.getSecurity().getUsername());
        log.info("Thomas: "+config.getThomas());
        for(String role:config.getSecurity().getRoles()){
            log.info("Role: "+role);
        }
        for(String willy:config.getWilly()){
            log.info("Willy: "+willy);
        }
        log.info("--------------------------------------------------");
        int number = cityService.deleteAll();
        log.info("deleteted "+number+" cities");
        City c1 = new City();
        c1.setName("Berlin");
        c1.setState("Berlin");
        City c2= new City();
        c2.setName("Bochum");
        c2.setState("NRW");
        City c3= new City();
        c3.setName("Frankfurt");
        c3.setState("Hessen");
        cityService.create(c1);
        cityService.create(c2);
        cityService.create(c3);
        for(City c:cityService.findAll()){
            log.info(c.toString());
        }
        return RepeatStatus.FINISHED;
    }

    
}
