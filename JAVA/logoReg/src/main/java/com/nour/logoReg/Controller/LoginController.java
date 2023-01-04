package com.nour.logoReg.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nour.logoReg.Model.Login;
import com.nour.logoReg.Model.LoginUser;
import com.nour.logoReg.Servec.LoginServec;

@Controller
public class LoginController {

	@Autowired
	private LoginServec LoginServec;

    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new Login());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") Login newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	LoginServec.register(newUser, result);
        
        if(result.hasErrors()) {
            
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        session.setAttribute("user_id", newUser.getId());
        session.setAttribute("userName", newUser.getUserName());
        return "redirect:/home";
    }
   @GetMapping("/logout")
   public String  logout(HttpSession seshRogan)
   {
	   seshRogan.invalidate();
	   return "redirect:/";
   }
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
           BindingResult result, Model model, HttpSession session) {
       
       // Add once service is implemented:
        Login login = LoginServec.login(newLogin, result);
   
       if(result.hasErrors()) {
           model.addAttribute("newUser", new Login());
           return "index.jsp";
       }
   
       // No errors! 
       // TO-DO Later: Store their ID from the DB in session, 
       // in other words, log them in.
       session.setAttribute("user_id", login.getId());
      ;
       session.setAttribute("userName", login.getUserName());
       return "redirect:/home";
   }
	
	
	
}
