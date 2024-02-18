package com.nowon.bullti.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nowon.bullti.domain.entity.Member;
import com.nowon.bullti.domain.entity.Role;

import jakarta.validation.Valid;

import com.nowon.bullti.domain.entity.MemberRepository;

@Controller
public class SignupController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new Member());
        return "management/views/signup";
    }

    @PostMapping("/signup")
    public String processSignup(@Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "management/views/signup";
        }

        // Encode password
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        // Set default role as USER
        member.getMemberRoles().add(Role.USER);

        memberRepository.save(member);
        return "redirect:/management/views/login";  // Redirect to login after successful signup
    }
}