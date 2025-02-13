package br.com.tokiomarine.payschedulertokiomarine.service;

import br.com.tokiomarine.payschedulertokiomarine.constants.MessageConstants;
import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.exceptions.TaxNotFoundException;
import br.com.tokiomarine.payschedulertokiomarine.repository.TaxRepository;
import br.com.tokiomarine.payschedulertokiomarine.repository.TransferRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.mapper.TransferMapper;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository repository;

    @Autowired
    private TaxRepository taxRepository;

    public TransferModel newTransfer(TransferDto transferDto) throws TaxNotFoundException {

        Optional<TaxModel> taxBetween = taxRepository.findTaxBetween(calculateDaysBetween(LocalDate.now(), transferDto.getAppointmentDate()));
        TaxModel taxModel = taxBetween.orElseThrow(() -> new TaxNotFoundException(MessageConstants.TAX_NOT_FOUND));
        TransferModel transferModel = new TransferMapper().transferDtotoTransferModel(transferDto);
        transferModel.setTaxModel(taxModel);

        return repository.save(transferModel);

    }

    public List<TransferModel> filterByOriginAccount(String originAccount) {
        return repository.findAllByOriginAccount(originAccount);
    }

    public static long calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException(MessageConstants.INVALID_DATE);
        }
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

}
