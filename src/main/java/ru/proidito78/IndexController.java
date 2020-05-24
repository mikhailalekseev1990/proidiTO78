package ru.proidito78;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String greetingForm(Model model) {
		Index index = new Index();
		model.addAttribute("index", index);
		index.setMessage(null);
		return "index";
	}

	@PostMapping("/index")
	public String greetingSubmit(@ModelAttribute Index index) {
		index.sendMail();
		index.setMessage(null);
		return "result";
	}

}