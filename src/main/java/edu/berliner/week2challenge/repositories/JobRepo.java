package edu.berliner.week2challenge.repositories;

import edu.berliner.week2challenge.Employment;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Employment,Long>
{
}
