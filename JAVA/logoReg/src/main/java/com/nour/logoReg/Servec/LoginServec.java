package com.nour.logoReg.Servec;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nour.logoReg.Model.Login;
import com.nour.logoReg.Repository.LogRepository;

@Service
public class LoginServec {
@Autowired
private LogRepository logRepo;

public Login register(Login newUser, BindingResult result)
{
	Optional <Login> potentialLogin=logRepo.findByEmail(newUser.getEmail());
	if(potentialLogin.isPresent())
	{
		result.rejectValue("email", "registerErrors", "this email is taken");
	}
	if(!newUser.getPassword().equals(newUser.getConfirm()))
	{
		result.rejectValue("confirm", "registerErrors", "password dont match");
	}
	if(result.hasErrors())
	{
		return null;
	}
	else
	{
		String hashedPW=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);
		return logRepo.save(newUser);
	}
	}

}
