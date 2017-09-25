package ojs.web;

import ojs.db.Submission;
import ojs.db.UserRepository;
import ojs.domain.db.Submissions;
import ojs.service.JudgeService;
import org.apache.log4j.Logger;
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
 * Created by sahriar on 12/19/16.
 */

@Controller
public class SubmissionController {
    private static final Logger log = Logger.getLogger(SubmissionController.class);
    @Autowired
    Submission submission;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JudgeService judgeService;

    @Autowired
    public SubmissionController(Submission submission, JudgeService judgeService, UserRepository userRepository) {
        this.submission = submission;
        this.judgeService = judgeService;
        this.userRepository = userRepository;

    }

    @RequestMapping(value = "/submitCode", method = RequestMethod.GET)
    public String submit(Model model) {
        Submissions submissions = new Submissions();
        model.addAttribute(submissions);
        return "submitCode";
    }

    @RequestMapping(value = "/submitCode", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("submissions") Submissions submissions,
                         BindingResult result, ModelMap model) {
        log.debug("..........." + submissions.getLanguage());
        //log.debug("......"+submissions.getProblems().getId());
        submissions.setUsers(userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()));
        int subId = submission.save(submissions);

        submissions.setId(subId);
        MultipartFile code = submissions.getCodeFile();
       // String dest = "/home/sahriar/Desktop/ojs/" + subId + ".c";
        String dest = "../Desktop/" + subId + ".c";
        try {
            code.transferTo(new File(dest));
        } catch (IOException e) {
            log.debug("....." + e);
        }

        submissions.setJudgeResult(judgeService.judgeSubmissions(submissions));
        submission.update(submissions);
        return "submitCode";
    }

    @RequestMapping(value = "/viewSubmissions", method = RequestMethod.GET)
    public String viewSubmissions(Model model) {
        model.addAttribute("sub", submission.getSubmissions());
        return "viewSubmissions";
    }

}
