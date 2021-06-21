package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.AirplaneDao;
import by.tms.aviaticket.dao.exception.NotFoundDaoException;
import by.tms.aviaticket.entity.Airplane;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryAirplaneDao implements AirplaneDao {
    private final List<Airplane> list = new ArrayList<>();
    private long nextId = 1;

    @Override
    public void save(Airplane airplane) {
        airplane.setId(nextId++);
        list.add(airplane);
    }

    @Override
    public List<Airplane> getAll() {
        return new ArrayList<>(list);
    }

    @Override
    public Optional<Airplane> getById(long id) {
        return list.stream().filter((item) -> item.getId() == id).findFirst();
    }

    @Override
    public void update(long id, Airplane airplane) throws NotFoundDaoException {
        int index = list.indexOf(getById(id).orElseThrow(() -> new NotFoundDaoException("Airplane not found")));
        airplane.setId(id);
        list.set(index, airplane);
    }

    @Override
    public void delete(long id) throws NotFoundDaoException {
        Airplane findAirplane = getById(id).orElseThrow(() -> new NotFoundDaoException("Airplane not found"));
        list.remove(findAirplane);
    }

    @Override
    public boolean contains(long id) {
        return list.stream().anyMatch(item -> item.getId() == id);
    }
}
