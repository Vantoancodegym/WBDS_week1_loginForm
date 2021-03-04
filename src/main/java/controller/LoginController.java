package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserService userService=new UserService();
    @GetMapping("")
    public ModelAndView showFormLogin(){
        ModelAndView modelAndView=new ModelAndView("login");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView login(@ModelAttribute User user){
        User check=userService.checkLogin(user);
        String mess="";
        if (check==null) mess="login fail";
        else mess="welcome "+user.getAccount();
        return new ModelAndView("login","mess",mess);
    }
}
