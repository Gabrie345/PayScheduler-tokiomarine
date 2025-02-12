package br.com.tokiomarine.payschedulertokiomarine.service;

import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.repository.TransferRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.mapper.TransferMapper;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepository repository;

    public TransferModel newTransfer(TransferDto transferDto) {
        TransferModel transferModel = new TransferMapper().transferDtotoTransferModel(transferDto);
        return repository.save(transferModel);

    }
    public List<TransferModel> filterByOriginAccount(String originAccount) {
        return repository.findAllByOriginAccount(originAccount);
    }

}
