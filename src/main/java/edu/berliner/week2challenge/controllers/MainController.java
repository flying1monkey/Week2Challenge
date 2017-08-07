package edu.berliner.week2challenge.controllers;

/*
 *This program allows a user to input their name, email address, Company, and start and end dates for a job,
 *and outputs a basic CV, which includes the number of days they worked at the company.
 *It also allows the user to see all the input they've entered.
 *
 *
 * @author Jesse Berliner
 */


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

    //start page
    @GetMapping("/starthere")
    public String startPage()
    {
        return "starthere";
    }

    //Add job page
    @GetMapping("/addemployment")
    public String addJob(Model model)
    {
        model.addAttribute("job", new Employment());
        return "addemployment";
    }

    //add job page after submission
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
            job.setEndDate(LocalDate.now());
        }
        //calculate days employed
        job.setDaysEmployed(DAYS.between(job.getStartDate(), job.getEndDate()));
        //save the job to the database
        jobs.save(job);
        return "jobadded";
    }

    //cv page-shows a single job
    @GetMapping("/viewcv")
    public String viewcv(Model model)
    {
        Iterable <Employment> jobList = jobs.findAll();
        model.addAttribute("jobList", jobList);
        return "viewcv";
    }





}
