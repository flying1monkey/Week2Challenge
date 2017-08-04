package edu.berliner.week2challenge.controllers;

import edu.berliner.week2challenge.Employment;
import edu.berliner.week2challenge.repositories.JobRepo;
import static java.time.temporal.ChronoUnit.DAYS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class MainController
{
    @Autowired
    JobRepo jobs;

    @GetMapping("/starthere")
    public String startPage()
    {
        return "starthere";
    }

    @GetMapping("/addemployment")
    public String addJob(Model model)
    {
        model.addAttribute("job", new Employment());
        return "addemployment";
    }

    @PostMapping("/addemployment")//
    public String submitJob(@ModelAttribute("job")Employment job, BindingResult bindingResult)
    {
        //error checking
        if(bindingResult.hasErrors())
        {
            return "addemployment";
        }

        //check for valid null fields
        if(job.getEmail().isEmpty())
        {
            job.setEmail("");
        }
        if(job.getOrg().isEmpty())
        {
            job.setOrg("");
        }
        if(job.getEndDate()==null)

        {
            System.out.println("end null!");
            job.setEndDate(LocalDate.now());
        }
        //calculate days employed
        job.setDaysEmployed(DAYS.between(job.getStartDate(), job.getEndDate()));
        //save the job to the database
        jobs.save(job);
        return "jobadded";
    }

    @GetMapping("/viewcv")
    public String viewcv(Model model)
    {
        Iterable <Employment> jobList = jobs.findAll();
        model.addAttribute("jobList", jobList);
        return "viewcv";
    }

}
