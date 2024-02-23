<<<<<<< HEAD
package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    
    @GetMapping("/login")
    public String loginForm(@RequestParam(value="error",required = false) String error, @RequestParam(value="exception", required = false) String exception , Model model) {
        model.addAttribute("error", false); // Initially no error
        model.addAttribute("logout", false); // Initially not logged out
        return "management/views/login"; // Returns the login view
    }

	/*
	 * @PostMapping("/login") public String loginFailed(Model model) {
	 * model.addAttribute("error", true); // Display error on failure return
	 * "list/list"; }
	 */

    @GetMapping("/logout")
    public String logoutSuccessful(Model model) {
        model.addAttribute("logout", true); // Indicate logout
        return "management/views/login";
    }
    
    
    
    
=======
package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    
    @GetMapping("/login")
    public String loginForm(@RequestParam(value="error",required = false) String error, @RequestParam(value="exception", required = false) String exception , Model model) {
        model.addAttribute("error", false); // Initially no error
        model.addAttribute("logout", false); // Initially not logged out
        return "management/views/login"; // Returns the login view
    }

	/*
	 * @PostMapping("/login") public String loginFailed(Model model) {
	 * model.addAttribute("error", true); // Display error on failure return
	 * "list/list"; }
	 */

    @GetMapping("/logout")
    public String logoutSuccessful(Model model) {
        model.addAttribute("logout", true); // Indicate logout
        return "management/views/login";
    }
    
    
    
    
>>>>>>> refs/remotes/choose_remote_name/master
}