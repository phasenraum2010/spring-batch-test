package org.woehlke.batch;

import org.woehlke.batch.oodm.CityService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tw on 28.03.17.
 */
@Controller
public class CityController {
    
    private final CityService cityService;
    
    private final JobLauncher jobLauncher;

    private final Job importUserJob;

    @Autowired
    public CityController(CityService cityService, JobLauncher jobLauncher, Job importUserJob) {
        this.cityService = cityService;
        this.jobLauncher = jobLauncher;
        this.importUserJob = importUserJob;
    }
    
    @RequestMapping("/")
    public String greeting(Model model) {
        model.addAttribute("cities",cityService.findAll());
        return "hallo";
    }

    @RequestMapping("/start")
    public String startJob(Model model) throws Exception {
        jobLauncher.run(importUserJob, new JobParameters());
        return "start";
    }
}
