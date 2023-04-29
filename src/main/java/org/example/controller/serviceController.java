package org.example.controller;

import org.example.dto.UserRegistrationDto;
import org.example.model.User;
import org.example.service.regissterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("api")
public class serviceController {

    @Autowired()
    private regissterServiceImpl registerServiceImpl;
    @PostMapping("/register")
    public String register(
            @Valid @RequestBody HashMap<String, Object> body) throws Exception {
        try {
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto((java.lang.String) body.get("firstName"), (java.lang.String) body.get("lastName"), (java.lang.String) body.get("email"), (java.lang.String) body.get("password"));
            registerServiceImpl.save(userRegistrationDto);
            return "Successful register";
        } catch (Exception ee) {
            return "Fail register";
        }
    }

    @PostMapping("/sum")
    public String sum(
            @Valid @RequestBody HashMap<String, Object> body) throws Exception {
        try {
            Integer a = (Integer) body.get("a");
            Integer b = (Integer) body.get("b");
            return "Sum success result=" + (a + b);
        } catch (Exception ee) {
            return "Sum failed";
        }
    }

    @PostMapping("/verify")
    public String verify(
            @Valid @RequestBody HashMap<String, Object> body) throws Exception {
        try {
            User user = registerService.sendUserByUsername((String) body.get("email"));
            AtomicBoolean result= new AtomicBoolean(false);
            user.getRoles().stream().forEach((e) -> {
                if (e!=null)
                    result.set(true);
            });
            if(true == result.get()){
                return "welcome"+user.getFirstName();
            }else{
                return "logout";
            }
        } catch (Exception ee) {
            return "Sum failed";
        }
    }

}