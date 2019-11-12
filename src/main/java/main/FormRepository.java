package main;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FormRepository extends CrudRepository<LoanForm, Integer> {

}
