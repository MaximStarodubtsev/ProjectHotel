package by.starodubtsev.controller;

import by.starodubtsev.Model.Room;
import by.starodubtsev.service.ServiceRooms;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class LoginController {

    @Autowired
    ServiceRooms serviceRooms;

    @ModelAttribute
    public void message(Model model) {
        model.addAttribute("loginMessage", "hello");
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        serviceRooms.getAll().stream().forEach(x->System.out.println(x));
        System.out.println("Hello");
        response.addCookie(new Cookie("hello", "hello"));
        return "login";
    }
}
