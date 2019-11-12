package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@RestController
public class AppController {
    @Autowired
    private FormRepository repository;
    @Autowired
    private FormValidator validator;

    @RequestMapping("/")
    public String index() {
        return "loan form api";
    }

    @RequestMapping("/form/{id}")
    public ResponseEntity<LoanForm> getForm(@PathVariable String id) {
        Optional<LoanForm> res = repository.findById(Integer.parseInt(id));
        return ResponseEntity.of(res);
    }

    @RequestMapping("/forms")
    public List<LoanForm> getAllForms() {
        Iterable<LoanForm> res = repository.findAll();
        return toList(res);
    }

    @PostMapping("/add")
    public ResponseEntity addForm(@RequestBody LoanForm form) {
        validator.calculateResult(form);
        repository.save(form);
        return ResponseEntity.ok(HttpStatus.OK);
    }

//
//    @RequestMapping("/addByUrl")
//    public String addForm(@RequestParam Map<String, String> allParams) {
//        LoanForm form = new LoanForm();
//        form.setfName(allParams.get("fName"));
//        form.setlName(allParams.get("lName"));
//        form.setBirthDate(new Date(System.currentTimeMillis()));
//        form.setPrivateId(allParams.get("privateId"));
//        form.setEmployer(allParams.get("employer"));
//        form.setSalary(Integer.parseInt(allParams.get("salary")));
//        form.setMonthlyLiability(Integer.parseInt(allParams.get("monthlyLiability")));
//        form.setRequestedAmount(Integer.parseInt(allParams.get("requestedAmount")));
//        validator.calculateResult(form);
//        repository.save(form);
//        return "added form with id: " + form.getFormId();
//    }

    @RequestMapping("forms/setresult/{id}")
    public ResponseEntity setResult(@PathVariable String id, @RequestParam String result) {
        if (result.equals("approved") || result.equals("rejected") || result.equals("custom")) {
            Optional<LoanForm> res = repository.findById(Integer.parseInt(id));
            if (res.isPresent()) {
                LoanForm form = (LoanForm) res.get();
                form.setResult(result);
                repository.save(form);
                return ResponseEntity.ok(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("form with given id does not exist", HttpStatus.NOT_FOUND);
            }

        } else return new ResponseEntity<>("result should be one of: approved/rejected/custom", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity deleteForm(@PathVariable String id) {
        Optional<LoanForm> res = repository.findById(Integer.parseInt(id));
        if (res.isPresent()) {
            repository.deleteById((Integer.parseInt(id)));
            return ResponseEntity.ok(HttpStatus.OK);
        } else return new ResponseEntity<>("form with given id does not exist", HttpStatus.NOT_FOUND);
    }

    private List<LoanForm> toList(Iterable<LoanForm> iterable) {
        List<LoanForm> lst = new ArrayList<LoanForm>();
        for (LoanForm lf : iterable) {
            lst.add(lf);
        }
        return lst;
    }
}
