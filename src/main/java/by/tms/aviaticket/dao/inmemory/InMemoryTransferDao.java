package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.TransferDao;
import by.tms.aviaticket.dao.exception.NotFoundDaoException;
import by.tms.aviaticket.entity.Transfer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("transferDao")
public class InMemoryTransferDao implements TransferDao {
    private List<Transfer> transferList = new ArrayList<>();
    private long nextId = 1;

    @Override
    public List<Transfer> getAllByDeparture(String city) {
        List<Transfer> transferByCity = transferList
                .stream()
                .filter(transfer -> transfer.getPlaceOfDeparture().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return transferByCity;
    }

    @Override
    public List<Transfer> getAllByArrival(String city) {
        List<Transfer> transferByCity = transferList
                .stream()
                .filter(transfer -> transfer.getPlaceOfArrival().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return transferByCity;
    }

    @Override
    public void save(Transfer transfer) {
        transfer.setId(nextId++);
        transferList.add(transfer);
    }

    @Override
    public List<Transfer> getAll() {
        return new ArrayList<>(transferList);
    }

    @Override
    public Optional<Transfer> getById(long id) {
        return transferList.stream().filter(item -> item.getId() == id).findFirst();
    }

    @Override
    public void update(long id, Transfer transfer) throws NotFoundDaoException {
        int index = transferList.indexOf(getById(id).orElseThrow(() -> new NotFoundDaoException("Airplane not found")));
        transfer.setId(id);
        transferList.set(index, transfer);
    }

    @Override
    public void delete(long id) throws NotFoundDaoException {
        transferList.remove(getById(id).orElseThrow(() -> new NotFoundDaoException("Airplane not found")));
    }
}
