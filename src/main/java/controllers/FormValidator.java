package controllers;


import entities.LoanApplication;
import entities.User;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Map;

@Configuration
public class FormValidator {


    private Map<Character, Integer> charValues;

    private static final int approvalThreshold = 3500;
    private static final int rejectThreshold = 2500;


    public static final int ERROR = 2;
    public static final int OK = 1;

    public FormValidator() {
        charValues = Helper.getCharMap();
    }

    public void calculateResult(LoanApplication form, User user) {
        String fName = user.getfName();
        int nameScore = 0;
        for (int i = 0; i < fName.length(); i++) {
            char ch = fName.charAt(i);
            nameScore += charValues.get(ch);
        }
//        System.out.println(nameScore);
        Calendar c = Calendar.getInstance();
        c.setTime(user.getBirthDate());
        //month starts from 0
        int birthdayScore = c.get(Calendar.YEAR) - (c.get(Calendar.MONTH) + 1) - c.get(Calendar.DAY_OF_YEAR);
        double totalScore = nameScore + birthdayScore + (double) form.getSalary() * 1.5 - form.getMonthlyLiability() * 3;
        System.out.println(totalScore);
        if (totalScore > approvalThreshold) {
            form.setResult("approved");

        } else if (totalScore < rejectThreshold) {
            form.setResult("rejected");

        } else form.setResult("custom");
    }

//    public int validateForm(LoanForm form) {
//        if(user.getfName() == null){
//            return ERROR;
//        }else return OK;
//    }
}
