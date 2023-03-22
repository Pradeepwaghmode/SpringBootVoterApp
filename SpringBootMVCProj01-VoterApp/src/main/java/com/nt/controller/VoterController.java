package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.service.CandidateHelperImpl;
import com.nt.module.Users_info;
import com.nt.module.VoterReport;
import com.nt.service.IVoterService;

@Controller

public class VoterController {

	@Autowired
	private IVoterService service;
	private Users_info currentUser;

	@GetMapping("/home")
	public String showHomePage() {
		System.out.println("VoterController.showHomePage()");
		return "home";
	}

	@GetMapping("/login1")
	public String loginPage(@ModelAttribute("emp1") Users_info user) {
		System.out.println("VoterController.showHomePage()");
		return "loginFrm";
	}

	@PostMapping("/login1")
	public String loginverification(@ModelAttribute("emp1") Users_info user, Map<String, Object> map,
			@ModelAttribute("can") CandidateHelperImpl can, RedirectAttributes atr) {
		System.out.println("VoterController.loginverification()");
		String conformation = service.UserValidation(user);
		System.out.println(conformation);

		if (conformation.equalsIgnoreCase("admin")) {
			map.put("msg", "Admin Login succefully !!");
			CandidateHelperImpl currentUser = service.candiateInfo();
			map.put("currentUser", currentUser);
			List<VoterReport> list = service.getAllreport();
			map.put("report", list);
			return "admin";
		} else if (conformation.equalsIgnoreCase("yes")) {
			map.put("msg", "Login succefully !!");
			return "voting";

		}
		atr.addFlashAttribute("msg", "Bad credential , Please Enter Valide user name or Password !!");

		return "redirect:login1";
	}

	@PostMapping("/votting")
	public String VotingCount(@ModelAttribute("can") CandidateHelperImpl can, Map<String, Object> map,
			RedirectAttributes atr) {

		String msg = service.candidateVoting(can);
		atr.addFlashAttribute("msg", msg);
		atr.addFlashAttribute("msg1", "msg1");
		return "redirect:home";
	}

	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute("emp") Users_info user) {
		System.out.println("registration form load ");

		return "registerFrm";
	}

	@PostMapping("/register")
	public String registerVoter(@ModelAttribute("emp") Users_info user, RedirectAttributes atr) {
		System.out.println("VoterController.registerVoter()");
		user.setFlag("notdone");
		String msg = service.saveUser(user);
		atr.addFlashAttribute("msg", msg);
		atr.addFlashAttribute("msg1", "msg1");
		return "redirect:home";
	}

	@GetMapping("/denied")
	public String accessDenied() {
		return "denied";
	}

	@GetMapping("/logout")
	public String logout(RedirectAttributes atr) {

		currentUser = service.CurrentUser();
		System.out.println("VoterController.showHomePage()");
		atr.addFlashAttribute("msg", currentUser.getUsername() + " is logged out succuefully !!");
		return "redirect:home";
	}
}
