package ojs.web;

import ojs.db.UserRepository;
import ojs.domain.db.UserRoles;
import ojs.domain.db.Users;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by toufiq on 12/19/16.
 */

@Controller
public class RegisterController {
    private static final Logger log = Logger.getLogger(SecurityController.class);
@Autowired
UserRepository userRepository;
public RegisterController(UserRepository userRepository)
{
    this.userRepository=userRepository;
}

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model)
    {
//        Users users=new Users();
//        model.addAttribute(users);
        //return new ModelAndView("register","users",new Users());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registeruser(@Valid @ModelAttribute("users") Users users,BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "register";
//        }
        log.debug(users.getEmail());

        userRepository.save(users);

return "redirect:/";
    }

}
