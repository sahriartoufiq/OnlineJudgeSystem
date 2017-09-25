package ojs.web;

import ojs.domain.db.Users;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.instrument.Instrumentation;


@Controller
@RequestMapping("/")
public class AppController {
	private static final Logger log = Logger.getLogger(SubmissionController.class);
//@Scheduled(fixedDelay = 20)
//public void t()
//{
//	log.debug("asssssssssssaaaaaaa");
//}

	@RequestMapping(value = { "/a"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {


		return "submitCode";
	}

	@RequestMapping(value = { "/products"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
}