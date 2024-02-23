package com.nowon.bullti.security.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.nowon.bullti.domain.entity.member.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 1. Extract User Details (Role)
        MyUser userDetails = (MyUser) authentication.getPrincipal(); // Assuming you're using MyUser

        // 2. Apply Redirect Logic Based on Role
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("Role"))) {
            setDefaultTargetUrl("/"); // Replace with your store dashboard URL
        } else {
            setDefaultTargetUrl("/"); // Standard user landing page
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
	
}
