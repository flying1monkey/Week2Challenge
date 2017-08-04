package edu.berliner.week2challenge.controllers;

import edu.berliner.week2challenge.Employment;
import edu.berliner.week2challenge.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("add", new Employment());
        return "addemployment";
    }

    @PostMapping("/addemployment")//book add
    public String submitJob(@ModelAttribute("add")Employment job, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "addemployment";
        }
        //get days employed
        jobs.save(job);
        return "jobadded";
    }

    @GetMapping("/viewcv")
    public String viewcv(Model model)
    {
        return "viewcv";
    }

}
