package br.com.tokiomarine.payschedulertokiomarine.service;

import br.com.tokiomarine.payschedulertokiomarine.dto.TaxDto;
import br.com.tokiomarine.payschedulertokiomarine.repository.TaxRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.mapper.TaxMapper;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    @Autowired
    private TaxRepository taxRepository;

    public TaxModel saveTax(TaxDto taxDto) {
        TaxModel taxModel = new TaxMapper().taxDtotoTaxModel(taxDto);
        return taxRepository.save(taxModel);
    }

}
