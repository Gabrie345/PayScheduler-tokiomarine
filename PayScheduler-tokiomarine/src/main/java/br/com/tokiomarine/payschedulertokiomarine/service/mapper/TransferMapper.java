package br.com.tokiomarine.payschedulertokiomarine.service.mapper;

import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TransferMapper {
    public TransferModel transferDtotoTransferModel(TransferDto dto) {
        TransferModel model = new TransferModel();
        model.setOriginAccount(dto.getOriginAccount());
        model.setDestinationAccount(dto.getDestinationAccount());
        model.setValue(dto.getValue());
        model.setAppointmentDate(dto.getAppointmentDate());
        model.setDateTransfer(LocalDate.now());
        return model;
    }
}
