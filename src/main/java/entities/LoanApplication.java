package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {
    @Id
    @GeneratedValue
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private User user;

    private Integer userId;
    private String employer;
    @NotNull
    private int salary;
    @NotNull
    private int monthlyLiability;
    @NotNull
    private int requestedAmount;
    @NotNull
    private int requestedTerm;

    private Date requestDate;
    private String result;

    public int getUserId() {
        return userId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getMonthlyLiability() {
        return monthlyLiability;
    }

    public void setMonthlyLiability(int monthlyLiability) {
        this.monthlyLiability = monthlyLiability;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getRequestedTerm() {
        return requestedTerm;
    }

    public void setRequestedTerm(int requestedTerm) {
        this.requestedTerm = requestedTerm;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
