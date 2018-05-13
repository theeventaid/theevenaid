package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;

@ControllerAdvice
public class UserControllerAdvice {

	@ModelAttribute("user")
	public User populateUser(Principal principal, Model model) {
		return principal == null ? new User() : (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
