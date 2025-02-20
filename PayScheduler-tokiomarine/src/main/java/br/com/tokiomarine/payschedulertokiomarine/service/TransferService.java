package br.com.tokiomarine.payschedulertokiomarine.service;

import br.com.tokiomarine.payschedulertokiomarine.constants.MessageConstants;
import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.exceptions.NotFoundException;
import br.com.tokiomarine.payschedulertokiomarine.repository.TaxRepository;
import br.com.tokiomarine.payschedulertokiomarine.repository.TransferRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.mapper.TransferMapper;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import br.com.tokiomarine.payschedulertokiomarine.validation.repository.AccountUserRepository;
import br.com.tokiomarine.payschedulertokiomarine.validation.service.model.AccountUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private AccountUserRepository accountUserRepository;

    public TransferModel newTransfer(TransferDto transferDto) throws NotFoundException {

        AccountUserModel originAccount = accountUserRepository.findByOriginAccount(transferDto.getOriginAccount());
        double balanceParse = originAccount.getBalance().doubleValue();

        if (transferDto.getValue()>balanceParse) {
            throw new NotFoundException(MessageConstants.NO_BALANCE);
        }

        Optional<TaxModel> taxBetween = taxRepository.findTaxBetween(calculateDaysBetween(LocalDate.now(), transferDto.getAppointmentDate()));
        TaxModel taxModel = taxBetween.orElseThrow(() -> new NotFoundException(MessageConstants.TAX_NOT_FOUND));
        TransferModel transferModel = new TransferMapper().transferDtotoTransferModel(transferDto);
        transferModel.setTaxModel(taxModel);


        double newBalance = (transferDto.getValue() - balanceParse);
        accountUserRepository.updateBalance( originAccount.getOriginAccount(), BigDecimal.valueOf(newBalance));

        return repository.save(transferModel);

    }

    public List<TransferModel> filterByOriginAccount(String originAccount) {
        List<TransferModel> transfers = repository.findAllByOriginAccount(originAccount);
        if(transfers.isEmpty()) throw new NotFoundException(MessageConstants.ACCOUNT_NOT_FOUND);
        return transfers;
    }

    public static long calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException(MessageConstants.INVALID_DATE);
        }
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

}
