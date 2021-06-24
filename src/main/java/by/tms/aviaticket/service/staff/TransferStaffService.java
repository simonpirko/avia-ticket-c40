package by.tms.aviaticket.service.staff;

import by.tms.aviaticket.dao.TransferDao;
import by.tms.aviaticket.dao.exception.NotFoundDaoException;
import by.tms.aviaticket.entity.Transfer;
import by.tms.aviaticket.service.exception.TransferNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferStaffService {
    private final TransferDao transferDao;

    public TransferStaffService(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    public List<Transfer> getAll() {
        return transferDao.getAll();
    }

    public void create(Transfer transfer) {
        transferDao.save(transfer);
    }

    public Transfer get(long id) throws TransferNotFoundException {
        return transferDao.getById(id).orElseThrow(TransferNotFoundException::new);
    }

    public void update(long id, Transfer transfer) throws TransferNotFoundException {
        try {
            transferDao.update(id, transfer);
        } catch (NotFoundDaoException e) {
            throw new TransferNotFoundException();
        }
    }

    public void delete(long id) throws TransferNotFoundException {
        try {
            transferDao.delete(id);
        } catch (NotFoundDaoException e) {
            throw new TransferNotFoundException();
        }
    }
}
