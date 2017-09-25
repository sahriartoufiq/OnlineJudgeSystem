package ojs.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	private static final Logger logger = Logger.getLogger(FileUploadController.class);

//	@Autowired
//	SubmissionService submissionService;
//	@Autowired
//	 public FileUploadController(SubmissionService submissionService) {
//		// TODO Auto-generated constructor stub
//		this.submissionService=submissionService;
//	}
//
//  @RequestMapping(method=RequestMethod.GET)
//  public String uploadForm(Model model) {
//	  Code code=new Code();
//    model.addAttribute(code);
//	  return "up";
//  }
//
//  @RequestMapping(method=RequestMethod.POST)
//  public String processUpload(@Valid Code code, Errors errors) throws IllegalStateException, IOException {
//	    /*if (errors.hasErrors()) {
//	        return "up";
//	      }*/
//
//	    //JOptionPane.showMessageDialog(null, "sdsd");
//	    /* if (errors.hasErrors()) {
//	       return "registerForm";
//	     }
//	     */
//	     //JOptionPane.showMessageDialog(null, "asas");
//	   //  Spitter spitter = spitterForm.toSpitter();
//	     //spitterRepository.save(spitter);
//	    //code.setLoc(loc)
//	  //JOptionPane.showMessageDialog(null, "befor");
//	  logger.debug("...................before.....................");
//	     MultipartFile profilePicture = code.getProfilePicture();
//	  //JOptionPane.showMessageDialog(null, "after");
//	     String location="/sahriar.jpg";
//	  logger.debug("..................after................");
//	     profilePicture.transferTo(new File(location));
//	     code.setLoc(location);
//	   //  JOptionPane.showMessageDialog(null, code.toString());
//
//	     Code2 code2=new Code2();
//	    		 code2=code.convertToCode2();
//	     code2.setJudge("na");
//	   //  JOptionPane.showMessageDialog(null, code2.toString());
//	     submissionService.save(code2);
//	     return "redirect:/";
//  }
  
}
