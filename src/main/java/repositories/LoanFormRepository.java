package repositories;

import entities.LoanApplication;
import org.springframework.data.repository.CrudRepository;

public interface LoanFormRepository extends CrudRepository<LoanApplication, Integer> {
}
