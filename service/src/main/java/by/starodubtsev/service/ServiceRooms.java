package by.starodubtsev.service;

import by.starodubtsev.DAO.DAORooms;
import by.starodubtsev.Model.Room;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Data
@Component
@Qualifier("ServiceRooms")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ServiceRooms {

    @Autowired
    DAORooms daoRooms;
    public ArrayList<Room> getAll() {
        return daoRooms.getAll();
    }

    public void save(Room room){ daoRooms.save(room);}
}
