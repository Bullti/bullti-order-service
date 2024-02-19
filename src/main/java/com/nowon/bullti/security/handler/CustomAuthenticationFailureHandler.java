package com.nowon.bullti.security.handler;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	 @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

	        String errorMessage; 

	        if (exception instanceof BadCredentialsException) {
	            errorMessage = "Invalid username or password"; 
	        } else if (exception instanceof UsernameNotFoundException) {
	            errorMessage = "Username not found"; 
	        } else if (exception instanceof InternalAuthenticationServiceException) {
	            errorMessage = "Internal error. Please contact administrator"; 
	        } else {
	            errorMessage = "Unknown authentication error"; 
	        }

	        // Encoding in case of Korean, etc.
	        errorMessage = URLEncoder.encode(errorMessage, "UTF-8"); 

	        setDefaultFailureUrl("/login?error=true&message=" + errorMessage); 

	        super.onAuthenticationFailure(request, response, exception);
	    }
	
}
