package cp.Traduler.controller;

import cp.Traduler.domain.User;
import cp.Traduler.domain.UserFormDto;
import cp.Traduler.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping(value = "/join")
    public String join(Model model){
        model.addAttribute("UserFormDto", new UserFormDto());
        return "join";
    }


    @PostMapping(value = "/join")
    public String join(@Valid  UserFormDto userFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "join";
        }
        try{
            userService.saveUser(userFormDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("UserFormDto",new UserFormDto());
            return "join";
        }
        return "redirect:/";
    }


}
