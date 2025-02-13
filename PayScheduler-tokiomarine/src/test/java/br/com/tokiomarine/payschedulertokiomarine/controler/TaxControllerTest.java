package br.com.tokiomarine.payschedulertokiomarine.controler;

import br.com.tokiomarine.payschedulertokiomarine.dto.TaxDto;
import br.com.tokiomarine.payschedulertokiomarine.service.TaxService;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TaxControllerTest {


    @Mock
    private TaxService taxService;

    @InjectMocks
    private TaxController taxController;

    @Test
    void shouldSuccessfullyRegister() throws Exception {
        TaxDto taxDto = new TaxDto(1, 10, 100, 5.0);
        TaxModel taxModel = new TaxModel(1, 1, 10, 100.0, 5.0);

        when(taxService.saveTax(any())).thenReturn(taxModel);

        ResponseEntity<TaxModel> response = taxController.saveTax(taxDto);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }
}
