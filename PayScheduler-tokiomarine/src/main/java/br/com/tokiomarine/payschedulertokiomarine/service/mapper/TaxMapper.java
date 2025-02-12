package br.com.tokiomarine.payschedulertokiomarine.service.mapper;

import br.com.tokiomarine.payschedulertokiomarine.dto.TaxDto;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.springframework.stereotype.Component;

@Component
public class TaxMapper {

    public TaxModel taxDtotoTaxModel(TaxDto dto) {
        return new TaxModel(
                0,
                dto.getMinDays(),
                dto.getMaxDays(),
                dto.getValue(),
                dto.getTax()
        );
    }

}
