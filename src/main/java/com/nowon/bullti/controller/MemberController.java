package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nowon.bullti.domain.dto.MemberSaveDTO;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService memberService;
    
    @GetMapping("/login")
    public String loginForm(@RequestParam(value="error",required = false) String error, @RequestParam(value="exception", required = false) String exception , Model model) {
        model.addAttribute("error", false); // Initially no error
        model.addAttribute("logout", false); // Initially not logged out
        return "members/login"; // Returns the login view
    }

	/*
	 * @PostMapping("/login") public String loginFailed(Model model) {
	 * model.addAttribute("error", true); // Display error on failure return
	 * "list/list"; }
	 */

    @GetMapping("/logout")
    public String logoutSuccessful(Model model) {
        model.addAttribute("logout", true); // Indicate logout
        return "members/login";
    }
    
    
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new Member());
        return "members/signup";
    }

    @PostMapping("/signup")
    public String processSignup(@Valid MemberSaveDTO memberSaveDTO, BindingResult result) {
    	
    	
    	 memberService.saveMember(memberSaveDTO); 
        return "redirect:/login";  // Redirect to login after successful signup
    }
    
}