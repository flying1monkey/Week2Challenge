package edu.berliner.week2challenge;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Employment
{
    @Id
//    @SequenceGenerator(name = "seq", sequenceName = "ORACLE_SEQ")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @Size(min=2,max=30) String name;
    @NotNull @Size(min=2, max=30) String email;
    @NotNull @Size(min=2, max=30) String org;
    @NotNull Date startDate;
    @NotNull Date endDate;
    int daysEmployed;

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

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public int getDaysEmployed()
    {
        return daysEmployed;
    }

    public void setDaysEmployed(int daysEmployed)
    {
        this.daysEmployed = daysEmployed;
    }
}
