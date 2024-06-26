package com.ProductStore.ctl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ProductStore.entity.UserEntity;
import com.ProductStore.repository.UserRepository;

@Controller
public class UserRegPageCtl {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String regPage() {
        return "index";
    }

    @GetMapping("/userRegistration")
    public String uregPage() {
        return "userRegistration";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(HttpServletRequest request, @ModelAttribute("form") UserEntity user, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email already exists.");
            return "userRegistration";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match.");
            return "userRegistration";
        }
        userRepository.save(user);
        return "redirect:/login";
        // userRepository.save(user);
        // model.addAttribute("msg", "User Register Successfully");
        // return "login";
    }
}
