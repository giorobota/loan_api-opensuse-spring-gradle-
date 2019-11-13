package entities;

import javax.persistence.*;

@Entity
public class LoanApplication {
    @Id
    @GeneratedValue
    private int formId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    private String employer;
    private int salary;
    private int monthlyLiability;
    private int requestedAmount;
    private int requestedTerm;
    private String result;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

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
