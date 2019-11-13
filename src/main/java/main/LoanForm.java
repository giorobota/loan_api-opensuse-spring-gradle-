package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class LoanForm {
    @Id
    @GeneratedValue
    private int formId;
    private String fName;
    private String lName;
    private Date birthDate;
    private String privateId;
    private String employer;
    private int salary;
    private int monthlyLiability;
    private int requestedAmount;
    private int requestedTerm;
    private String result;
//test
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPrivateId() {
        return privateId;
    }

    public void setPrivateId(String privateId) {
        this.privateId = privateId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    @Override
    public String toString() {
        return "LoanForm{" +
                "formId=" + formId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", birthDate=" + birthDate +
                ", privateId='" + privateId + '\'' +
                ", employer='" + employer + '\'' +
                ", salary=" + salary +
                ", monthlyLiability=" + monthlyLiability +
                ", requestedAmount=" + requestedAmount +
                ", requestedTerm=" + requestedTerm +
                '}';
    }



}
