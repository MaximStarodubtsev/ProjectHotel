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

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class RoomsController {

    @Autowired
    ServiceRooms serviceRooms;

    @ModelAttribute
    public void message(Model model, HttpServletRequest request) {
        model.addAttribute("validRoomMessage", "hello");
    }

    @GetMapping("/rooms")
    public String rooms(Model model){
        return "rooms";
    }

    @PostMapping("/rooms")
    public String rooms(Model model, HttpServletRequest request){

        serviceRooms.save(new Room(Integer.valueOf(request.getParameter("number")),
                Room.Places.valueOf(request.getParameter("places")),
                Room.Level.valueOf(request.getParameter("level")),
                Integer.valueOf(request.getParameter("rent"))));
        return "rooms";
    }
}
