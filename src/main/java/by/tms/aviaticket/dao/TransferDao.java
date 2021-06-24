package by.tms.aviaticket.dao;


import by.tms.aviaticket.dao.exception.NotFoundDaoException;
import by.tms.aviaticket.entity.Transfer;

import java.util.List;
import java.util.Optional;

public interface TransferDao {
    List<Transfer> getAllByDeparture(String city);
    List<Transfer> getAllByArrival(String city);
    void save(Transfer transfer);
    List<Transfer> getAll();
    Optional<Transfer> getById(long id);
    void update(long id, Transfer transfer) throws NotFoundDaoException;
    void delete(long id) throws NotFoundDaoException;
}
