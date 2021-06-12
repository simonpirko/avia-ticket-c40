package by.tms.aviaticket.service;

import by.tms.aviaticket.dao.TransferDao;
import by.tms.aviaticket.entity.Flight;
import by.tms.aviaticket.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("searchService")
public class SearchService {
    @Autowired
    @Qualifier("transferDao")
    private TransferDao transferDao;

    public List<Flight> find(String from, String to, LocalDate departure, int count) {
        List<Flight> resultList = new ArrayList<>();

        List<Transfer> tmp = new ArrayList<>();
        for (Transfer transfer : transferDao.getAllByDeparture(from)) {
            if (transfer.getPlaceOfDeparture().equals(from)
                    && transfer.getPlaceOfArrival().equalsIgnoreCase(to)
                    && transfer.getDateOfDeparture().toLocalDate().equals(departure)) {
                Flight flight = createFlight(transfer);
                resultList.add(flight);
            } else {
                if (transfer.getPlaceOfDeparture().equals(from)
                        && transfer.getDateOfDeparture().toLocalDate().equals(departure)) {
                    tmp.add(transfer);
                }
            }
        }

        for (Transfer transfer1 : transferDao.getAllByArrival(to)) {
            for (Transfer transfer2 : tmp) {
                if (transfer1.getPlaceOfDeparture().equals(transfer2.getPlaceOfArrival())
                        && transfer1.getPlaceOfArrival().equals(to)
                        && transfer1.getDateOfDeparture().isAfter(transfer2.getDateOfArrival())
                ) {
                    Flight flight = createFlight(transfer2, transfer1);
                    resultList.add(flight);
                }
            }
        }
        return resultList;
    }

    private Flight createFlight(Transfer... transfers){
        List<Transfer> transferList = new ArrayList<>(Arrays.asList(transfers));
        int totalDistance = 0;
        for (Transfer transfer : transfers) {
            totalDistance += transfer.getDistance();
        }
        Flight flight = new Flight();
        flight.setTransferList(transferList);
        flight.setTotalDistance(totalDistance);
        return flight;
    }
}
