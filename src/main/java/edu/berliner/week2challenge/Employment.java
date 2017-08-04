package edu.berliner.week2challenge;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Employment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @Size(min=1,max=30) String name;
    @Size(max=30) String email;
    @Size(max=30) String org;
    @NotNull LocalDate startDate;
    LocalDate endDate;
    long daysEmployed;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getOrg()
    {
        return org;
    }

    public void setOrg(String org)
    {
        this.org = org;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public long getDaysEmployed()
    {
        return daysEmployed;
    }

    public void setDaysEmployed(long daysEmployed)
    {
        this.daysEmployed = daysEmployed;
    }

}
