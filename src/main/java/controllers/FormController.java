package controllers;

import entities.LoanApplication;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.LoanFormRepository;
import repositories.UserRepository;


import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class FormController {

    @Autowired
    private LoanFormRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FormValidator validator;

    @GetMapping("/forms")
    public List<LoanApplication> getAllForms(){
        return loanRepository.findAll();
    }
    @PostMapping("forms/deleteall")
    public void deleteAllForms(){
        loanRepository.deleteAll();
    }
    @GetMapping("/form/{id}")
    public ResponseEntity<LoanApplication> getForm(@PathVariable int id){
        Optional<LoanApplication> res = loanRepository.findById(id);
        return ResponseEntity.of(res);
    }

    @GetMapping("/forms/byuser/{userId}")
    public List<LoanApplication> getFormsByUser(@PathVariable int userId ){
        return loanRepository.findAllByUserId(userId);
    }

    @GetMapping("/forms/byprivateid/{privateId}")
    public List<LoanApplication> getFormsByPrivateId(@PathVariable String privateId){
        Optional<User> res = userRepository.findByPrivateId(privateId);
        if(res.isPresent()){
            User user = res.get();
            return loanRepository.findAllByUserId(user.getId());
        }else{
            return new ArrayList<>();
        }
    }
    @PostMapping("/forms/add")
    public ResponseEntity addForm(@RequestBody LoanApplication form){
       Optional<User> res = userRepository.findById(form.getUserId());
       if(res.isPresent()) {
           validator.calculateResult(form, res.get());
           Date now = new Date(System.currentTimeMillis());
           form.setRequestDate(now);
           loanRepository.save(form);
           return ResponseEntity.ok(HttpStatus.OK);
       }else return new ResponseEntity<>("user with that id does not exist", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/forms/delete/{id}")
    public ResponseEntity deleteForm(@PathVariable int id){
        loanRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("forms/bydate/{date}")
    public List<LoanApplication> getByDate(@PathVariable Date date){
        return loanRepository.findAllByRequestDate(date);
    }


}
