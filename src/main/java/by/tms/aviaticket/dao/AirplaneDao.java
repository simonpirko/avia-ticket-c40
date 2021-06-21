package by.tms.aviaticket.dao;

import by.tms.aviaticket.dao.exception.NotFoundDaoException;
import by.tms.aviaticket.entity.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneDao {
    void save(Airplane airplane);
    List<Airplane> getAll();
    Optional<Airplane> getById(long id);
    void update(long id, Airplane airplane) throws NotFoundDaoException;
    void delete(long id) throws NotFoundDaoException;
    boolean contains(long id);
}
