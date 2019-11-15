package controllers;

import entities.LoanApplication;
import entities.User;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.LoanFormRepository;
import repositories.UserRepository;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoanFormRepository formRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping("users/deleteall")
    public void deteleAllUsers(){
        userRepository.deleteAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.of(user);
    }
    @GetMapping("user/byprivateid/{privateId}")
    public ResponseEntity getUserByPrivateId(@PathVariable String privateId){
        return ResponseEntity.of(userRepository.findByPrivateId(privateId));
    }

    @PostMapping("/users/add")
    public ResponseEntity addUser(@RequestBody User user) {
        String privateId = user.getPrivateId();
        Optional<User> res = userRepository.findByPrivateId(privateId);
        if (res.isPresent()) {
            return new ResponseEntity<>("User with that privateId already exists", HttpStatus.BAD_REQUEST);
        } else {
            userRepository.save(user);
            return ResponseEntity.ok(HttpStatus.OK);
        }
    }

    @PostMapping("users/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        Optional<User> res = userRepository.findById(id);
        if(res.isPresent()){
            // ??
            formRepository.deleteByUser(res.get());
            userRepository.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }else return new ResponseEntity<>("user with that id does not exist", HttpStatus.NOT_FOUND);

    }

    @PostMapping("users/deletebypid/{privateId}")
    public ResponseEntity deleteUserByPrivateId(@PathVariable String privateId) {
        userRepository.deleteByPrivateId(privateId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
