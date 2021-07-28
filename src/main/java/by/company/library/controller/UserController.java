package by.company.library.controller;

import by.company.library.domain.dto.UserDto;
import by.company.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @PostMapping("/home_page")
    public String greetingSubmit(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("passportNo", userDto.getPassportNo());
        model.addAttribute("password", userDto.getPassword());
        UserDto user = userService.getUserByPassport(userDto.getPassportNo());
        if (user == null || !userDto.getPassword().equals(user.getPassword())) return "error";

        return "redirect:/books/list";
    }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("users", userDto);
        return "create_account";
    }

    @PostMapping("/save")
    public String saveUsers(@ModelAttribute("users") UserDto userDto) {
        // save the user
        userService.add(userDto);
        return "redirect:/users/login";
    }
}
