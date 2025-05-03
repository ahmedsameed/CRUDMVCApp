package com.example.isn2spring.demospringisn2.User;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String email){
        try{  
        userService.deleteUser(email);
            return "ss";   
            } catch (Exception e) {
                return e.getMessage();
            }      
    }
    @PostMapping("/createuser")
    public String createUser(@RequestParam String email, @RequestParam String newname,@RequestParam  String password) {
        try{  
            userService.createUser(email, newname, password);
                return "ss";   
                } catch (Exception e) {
                    return e.getMessage();
                }
        
    }
    
    @GetMapping("/userd")
    public List<String> getUsername(@RequestParam String Id){   
        return userService.getUsersName();
    }

    @PutMapping("user/{id}")
    public ResponseEntity<String> updateusername(@PathVariable String id, @RequestBody String newname) {
        try {
            System.out.println(id);
            System.out.println(newname);
            userService.updateUsersName(id, newname);
            return ResponseEntity.ok("dd");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ISSUE");
        }
    }

   

}

    


