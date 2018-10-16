package ojs.web;

import ojs.db.ProblemsDB;
import ojs.db.UserRepository;
import ojs.domain.db.Problems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by sahriar on 1/2/17.
 */

@Controller
public class ProblemController {

    @Autowired
    ProblemsDB problemsDB;
    @Autowired
    UserRepository userRepository;


    public ProblemController(ProblemsDB problemsDB, UserRepository userRepository) {

        this.problemsDB = problemsDB;
        this.userRepository = userRepository;

    }


    @RequestMapping(value = "saveProblem", method = RequestMethod.GET)
    public String submit(Model model) {

        Problems problems = new Problems();
        model.addAttribute(problems);

        return "problems";

    }

    @RequestMapping(value = "saveProblem", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("problems") Problems problems,
                         BindingResult result,
                         ModelMap model) {

        String loc = "../Desktop/";
        problems.setUsers(userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()));
        int pbId = problemsDB.save(problems);
        MultipartFile pblm = problems.getProblm();
        MultipartFile input = problems.getInput();
        MultipartFile output = problems.getOutput();

        try {

            pblm.transferTo(new File(loc + pbId + ".pdf"));
            output.transferTo(new File(loc + pbId + "output.txt"));
            input.transferTo(new File(loc + pbId + "input.txt"));

        } catch (IOException e) {

            e.printStackTrace();

        }

        return "problems";

    }

}