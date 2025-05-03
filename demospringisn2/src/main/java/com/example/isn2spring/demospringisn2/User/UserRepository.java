package com.example.isn2spring.demospringisn2.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,String > {

    User findByName(String name);

    @Query(value="Select * from Users where name= :name", nativeQuery = true)
    User getuserbynameUser(@Param("name")String name);

}
