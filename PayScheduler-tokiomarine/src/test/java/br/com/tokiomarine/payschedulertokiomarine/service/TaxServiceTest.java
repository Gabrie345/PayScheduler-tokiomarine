package br.com.tokiomarine.payschedulertokiomarine.service;

import br.com.tokiomarine.payschedulertokiomarine.dto.TaxDto;
import br.com.tokiomarine.payschedulertokiomarine.repository.TaxRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.mapper.TaxMapper;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class TaxServiceTest {

    @Mock
    private TaxRepository taxRepository;

    @Mock
    private TaxMapper taxMapper;

    @InjectMocks
    private TaxService taxService;

    private TaxDto taxDto;
    private TaxModel taxModel;

    @BeforeEach
    void setUp() {
        taxDto = new TaxDto(1, 10, 100.0, 5.0);
        taxModel = new TaxModel(1, 1, 10, 100.0, 5.0);
    }

    @Test
    void shouldSaveTaxSuccessfully() {
        when(taxMapper.taxDtotoTaxModel(any())).thenReturn(taxModel);
        when(taxRepository.save(any())).thenReturn(taxModel);

        TaxModel savedTax = taxService.saveTax(taxDto);

        assertThat(savedTax).isNotNull();


    }
}