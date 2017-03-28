package org.woehlke.batch;

import org.woehlke.batch.oodm.City;
import org.woehlke.batch.oodm.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.woehlke.batch.oodm.Person;
import org.woehlke.batch.oodm.PersonService;

/**
 * Created by tw on 28.03.17.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final CityService cityService;

    private final PersonService personService;

    @Autowired
    public JobCompletionNotificationListener(CityService cityService, PersonService personService) {
        this.cityService = cityService;
        this.personService = personService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            for (Person person : personService.findAll()) {
                log.info("Found <" + person + "> in the database.");
            }

            for(City city: cityService.findAll()){
                log.info(city.toString());
            }
        }
    }
}
