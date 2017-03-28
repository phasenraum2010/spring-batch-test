package hello;

import hello.oodm.City;
import hello.oodm.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tw on 28.03.17.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    private final CityService cityService;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate, CityService cityService) {
        this.jdbcTemplate = jdbcTemplate;
        this.cityService = cityService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM people", new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet rs, int row) throws SQLException {
                    return new Person(rs.getString(1), rs.getString(2));
                }
            });

            for (Person person : results) {
                log.info("Found <" + person + "> in the database.");
            }

            for(City city: cityService.findAll()){
                log.info(city.toString());
            }
        }
    }
}
