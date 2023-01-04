package com.nour.BookClub.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nour.BookClub.Models.Book;
import com.nour.BookClub.Models.LoginUser;
import com.nour.BookClub.Models.User;
import com.nour.BookClub.Servec.BookServec;
import com.nour.BookClub.Servec.UserServce;

@Controller
public class UserController {
	@Autowired
	private UserServce userServ;
	
	@Autowired
	private BookServec bookServ;
	// Show the authentication page
	@GetMapping("/")
	public String loginPage(@ModelAttribute("newUser") User newUser,
							@ModelAttribute("newLogin") LoginUser newLogin,
							Model model) {
		
	      model.addAttribute("newUser", new User());
	      model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	// Register === Process register from === POST
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		
		 // call a register method in the service
        userServ.register(newUser, result);
		
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // Store their ID from the DB in session, 
        session.setAttribute("user_id", newUser.getId());
        session.setAttribute("userName", newUser.getUserName());
        return "redirect:/home";
    }
	
	// === Render the success page ===
	@GetMapping("/home")
	public String success(HttpSession s , Model model) {
		Long userId = (Long) s.getAttribute("user_id");
		
		if(userId == null) {
			return "redirect:/";
		}
		List <Book> allBooks  = bookServ.allBooks();
		model.addAttribute("allMybooks", allBooks);
		String userName = (String) s.getAttribute("userName");
		return "home.jsp";
	}
	
	// Login === Process login from === POST
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
       ;
        session.setAttribute("userName", user.getUserName());
        return "redirect:/home";
    }
	
	@GetMapping("/logout")
	public String logout(HttpSession sesh) {
		sesh.invalidate();
		return "redirect:/login";
	}
}
