package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.TransferDao;
import by.tms.aviaticket.entity.Transfer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("transferDao")
public class InMemoryTransferDao implements TransferDao {
    private List<Transfer> transferList = new ArrayList<>();

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
}
