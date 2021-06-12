package by.tms.aviaticket.dao;


import by.tms.aviaticket.entity.Transfer;

import java.util.List;

public interface TransferDao {
    List<Transfer> getAllByDeparture(String city);
    List<Transfer> getAllByArrival(String city);
}
