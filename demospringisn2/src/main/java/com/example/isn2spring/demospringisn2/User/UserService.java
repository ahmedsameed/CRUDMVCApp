package com.example.isn2spring.demospringisn2.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserRepository userRepository;


    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<String> getUsersName(){
        //return userRepository.findAll();
        List<String> ahmed= userRepository.findAll().stream().map(User::getName).collect(Collectors.toList());
        return ahmed;
    }
    public User updateUsersName(String email, String newname){
        //return userRepository.findAll();
        Optional<User> place= userRepository.findById(email);
        User currentUser=place.get();
        currentUser.setName(newname);

        return userRepository.save(currentUser);
        
    }

    public User createUser(String email, String newname, String password){
        //return userRepository.findAll();
        User currentUser=new User(email, password, newname);
        
     

        return userRepository.save(currentUser);
        
    }

    public void deleteUser(String email){
        //return userRepository.findAll();
        userRepository.deleteById(email);
        //return 1;


        
 
    }

}
