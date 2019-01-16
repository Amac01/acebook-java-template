package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	private final PostRepository postRepository;

	@Autowired
	public HomeController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/greeting")
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}



	//Write a GET request which shows the post on a view
//	@RequestMapping(value = "/hello")
	@GetMapping("/hello")
	public String hello(Model model){
		/* (without a database) Post post = new Post("It's a Good day! ", 1l);
		Post content = new Post("It's a good day!", 1l);
		model.addAttribute("post", post);
		model.addAttribute("day", content);
		*/

		model.addAttribute("posts", postRepository.findAll());
		model.addAttribute("post", new Post());
		return "hello";
	}

	@PostMapping("/newpost")
	public String tableau(@ModelAttribute Post post){
		postRepository.save(post);

		return "redirect:/hello";
	}


}
