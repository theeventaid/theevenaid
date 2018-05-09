package com.tgj.eventaid.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.UserRepository;
import com.tgj.eventaid.services.RecaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api")
public class RecaptchaController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RecaptchaService captchaService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> signup(@Valid User user,
                                    @RequestParam(name="g-recaptcha-response") String recaptchaResponse,
                                    HttpServletRequest request, Model model){

        String ip = request.getRemoteAddr();
        String captchaVerifyMessage =
                captchaService.verifyRecaptcha(ip, recaptchaResponse);

        if ( StringUtils.isNotEmpty(captchaVerifyMessage)) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", captchaVerifyMessage);

            System.out.println(response);

//            model.addAttribute("recaptcha_error", ResponseEntity.badRequest()
//                    .body(response));
            model.addAttribute("recaptcha_error", "Please verify your identity with the Captcha");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/register");
            return new ResponseEntity<String>(headers,HttpStatus.FOUND);

//            return  ResponseEntity.badRequest().body(response);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated_on(LocalDateTime.now());
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/");
//        return ResponseEntity.ok().build();
        return new ResponseEntity<String>(headers,HttpStatus.FOUND);
    }
}
