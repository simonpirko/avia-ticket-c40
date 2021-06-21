package by.tms.aviaticket.service.staff;

import by.tms.aviaticket.dao.AirplaneDao;
import by.tms.aviaticket.dao.exception.NotFoundDaoException;
import by.tms.aviaticket.entity.Airplane;
import by.tms.aviaticket.service.exception.AirplaneNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneStaffService {
    private final AirplaneDao airplaneDao;

    public AirplaneStaffService(AirplaneDao airplaneDao) {
        this.airplaneDao = airplaneDao;
    }

    public List<Airplane> getAll() {
        return airplaneDao.getAll();
    }

    public void create(Airplane airplane) {
        airplaneDao.save(airplane);
    }

    public Airplane get(long id) throws AirplaneNotFoundException {
        return airplaneDao.getById(id).orElseThrow(AirplaneNotFoundException::new);
    }

    public void update(long id, Airplane airplane) throws AirplaneNotFoundException {
        try {
            airplaneDao.update(id, airplane);
        } catch (NotFoundDaoException e) {
            throw new AirplaneNotFoundException();
        }
    }

    public void delete(long id) throws AirplaneNotFoundException {
        try {
            airplaneDao.delete(id);
        } catch (NotFoundDaoException e) {
            throw new AirplaneNotFoundException();
        }
    }
}
