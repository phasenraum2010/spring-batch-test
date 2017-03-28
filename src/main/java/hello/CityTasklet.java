package hello;

import hello.oodm.City;
import hello.oodm.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tw on 28.03.17.
 */
@Component
public class CityTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final CityService cityService;

    @Autowired
    public CityTasklet(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
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
        return RepeatStatus.CONTINUABLE;
    }

    
}
