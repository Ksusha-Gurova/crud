package ru.neoflex.crud.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.crud.api.dto.UserRequestDto;
import ru.neoflex.crud.api.dto.UserResponseDto;
import ru.neoflex.crud.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/users"})
public class UserController {
    private final UserService service;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<UserResponseDto> users = service.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable Long id, Model model) {
        UserResponseDto user = service.findUser(id);
        model.addAttribute("users", user);
        return "userList";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model){
        UserRequestDto userRequestDto = new UserRequestDto();
        model.addAttribute("form", userRequestDto);
        return "addUser";
    }

    @PostMapping
    public String saveOrUpdateUser(@ModelAttribute @Valid UserRequestDto form) {
        service.saveOrUpdateUser(form);
        return "redirect:/users/findAll";
    }

    @PostMapping("/{id}/edit")
    public String showUserForm(@PathVariable Long id, Model model) {
        UserResponseDto user = service.findUser(id);
        model.addAttribute("form", user);
        return "addUser";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/users/findAll";
    }
}
