package com.nour.logoReg.Repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nour.logoReg.Model.Login;
@Repository 
public interface LogRepository extends CrudRepository<Login,Long>{
//List<Login>findAll();
Optional<Login> findByEmail(String email);
}
