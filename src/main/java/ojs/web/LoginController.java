package ojs.web;

import ojs.db.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sahriar on 12/25/16.
 */
@Controller
@RequestMapping("/loginaa")
public class LoginController {

    private static final Logger log = Logger.getLogger(SecurityController.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        ModelAndView model = new ModelAndView();
        String error = "";
        model.addObject(error);

        return "login";
    }
}
