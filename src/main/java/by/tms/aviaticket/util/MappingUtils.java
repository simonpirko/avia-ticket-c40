package by.tms.aviaticket.util;

import by.tms.aviaticket.dao.AirplaneDao;
import by.tms.aviaticket.entity.Transfer;
import by.tms.aviaticket.entity.dto.TransferCreateDto;
import by.tms.aviaticket.service.exception.AirplaneNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MappingUtils {
    private final AirplaneDao airplaneDao;

    public MappingUtils(AirplaneDao airplaneDao) {
        this.airplaneDao = airplaneDao;
    }

    public Transfer mapToTransferEntity(TransferCreateDto transferCreateDto) throws AirplaneNotFoundException {
        Transfer transfer = new Transfer();
        transfer.setDateOfDeparture(transferCreateDto.getDateOfDeparture());
        transfer.setDateOfArrival(transferCreateDto.getDateOfArrival());
        transfer.setPlaceOfDeparture(transferCreateDto.getPlaceOfDeparture());
        transfer.setPlaceOfArrival(transferCreateDto.getPlaceOfArrival());
        transfer.setDistance(transferCreateDto.getDistance());
        transfer.setAirplane(airplaneDao.getById(transferCreateDto.getAirplaneId()).orElseThrow(AirplaneNotFoundException::new));
        return transfer;
    }

    public TransferCreateDto mapToCreateTransferDto(Transfer transfer) {
        TransferCreateDto transferCreateDto = new TransferCreateDto();
        transferCreateDto.setDateOfDeparture(transfer.getDateOfDeparture());
        transferCreateDto.setDateOfArrival(transfer.getDateOfArrival());
        transferCreateDto.setPlaceOfDeparture(transfer.getPlaceOfDeparture());
        transferCreateDto.setPlaceOfArrival(transfer.getPlaceOfArrival());
        transferCreateDto.setDistance(transfer.getDistance());
        transferCreateDto.setAirplaneId(transfer.getAirplane().getId());
        return transferCreateDto;
    }
}
