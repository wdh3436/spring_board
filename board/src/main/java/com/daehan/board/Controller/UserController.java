package com.daehan.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.daehan.board.dto.AccountDto;
import com.daehan.board.service.AccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final AccountService accountService;

    @GetMapping("/loginUser")
    public String createUserForm(Model model){
        model.addAttribute("userForm",new AccountDto());
        return "user/login/register";
    }

    @PostMapping("/loginUser")
    public String createUser(@Valid AccountDto Dto, BindingResult result){
        if(result.hasErrors()){
            return "user/login/register";
        }
        accountService.createUser(Dto);

        return "redirect:/";
    }
    
    @GetMapping("/register")
    public String sign(){
        return "user/login/register";
    }
    
}
