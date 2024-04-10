package PP_3_1_2.controller;


import PP_3_1_2.model.User;
import PP_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    // Все юзеры

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    // добавить юзера
    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "new";
    }

    //добавить юзера
    @PostMapping(value = "/create")
    public String create(@ModelAttribute("newUser") User user) {
        userService.add(user);
        return "redirect:/";
    }

    // изменить юзера
    @GetMapping(value = "/editUser/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        User user = userService.showUser(id);
        model.addAttribute("editUser", user);
        return "edit";
    }

    //изменить юзера
    @PostMapping(value = "/update")
    public String update(@ModelAttribute("editUser") User user, Long id) {
        userService.update(id, user);
        return "redirect:/";
    }

    //удалить юзера
    @GetMapping(value = "/deleteUser/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
