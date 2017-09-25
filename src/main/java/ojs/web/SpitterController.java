package ojs.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/*import spittr.Spitter;
import spittr.data.SpitterRepository;*/

@Controller
@RequestMapping("/spitter")
public class SpitterController {

  //private SpitterRepository spitterRepository;

 /* @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }*/
  
  @RequestMapping(value="/registe", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new SpitterForm());
    return "registerForm";
  }
  
//  @RequestMapping(value="/register", method=POST)
//  public String processRegistration(
//      @RequestPart(value="profilePictures", required=false) Part fileBytes,
//      RedirectAttributes redirectAttributes,
//      @Valid Spitter spitter,
//      Errors errors) throws IOException {
//    if (errors.hasErrors()) {
//      return "registerForm";
//    }
//    
//    spitterRepository.save(spitter);
//    redirectAttributes.addAttribute("username", spitter.getUsername());
//    redirectAttributes.addFlashAttribute(spitter);
//    return "redirect:/spitter/" + spitter.getUsername();
//  }
  
  @RequestMapping(value="/registe", method=POST)
  public String processRegistration(
      @Valid SpitterForm spitterForm,
      Errors errors) throws IllegalStateException, IOException {
    JOptionPane.showMessageDialog(null, "sdsd");
   /* if (errors.hasErrors()) {
      return "registerForm";
    }
    */
    JOptionPane.showMessageDialog(null, "asas");
  //  Spitter spitter = spitterForm.toSpitter();
    //spitterRepository.save(spitter);
    MultipartFile profilePicture = spitterForm.getProfilePicture();
    profilePicture.transferTo(new File("/tmp/sahriar.jpg"));
    return "redirect:/";
  }
  
/*  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(
          @PathVariable String username, Model model) {
    if (!model.containsAttribute("spitter")) {
      model.addAttribute(
          spitterRepository.findByUsername(username));
    }
    return "profile";
  }*/
  
}
