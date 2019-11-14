package repositories;

import entities.LoanApplication;
import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface LoanFormRepository extends JpaRepository<LoanApplication, Integer> {
    List<LoanApplication> findAllByUserId(int userId);
    List<LoanApplication> findAllByRequestDate(Date date);
    void deleteByUserId(int userId);
}
