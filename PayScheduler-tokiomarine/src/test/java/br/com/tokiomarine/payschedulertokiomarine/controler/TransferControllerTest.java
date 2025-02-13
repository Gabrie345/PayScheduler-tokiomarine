package br.com.tokiomarine.payschedulertokiomarine.controler;

import br.com.tokiomarine.payschedulertokiomarine.dto.TaxDto;
import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.service.TaxService;
import br.com.tokiomarine.payschedulertokiomarine.service.TransferService;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class TransferControllerTest {

    @Mock
    private TransferService transferService;

    @InjectMocks
    private TransferController transferController;

    @Test
    void shouldSuccessfullyTransfer(){
        TaxModel taxModel = new TaxModel(1, 1, 10, 100.0, 5.0);
        TransferModel transferModel =new TransferModel(
                1L,
                LocalDate.of(2025, 2, 13),
                LocalDate.of(2025, 2, 20),
                taxModel,
                1500.00,
                "1234560000",
                "6543210000"
        );
        TransferDto transferDto = new TransferDto(
                "1234560000",
                "1234560000",
                1500.00,
                LocalDate.of(2025, 2, 20)
        );

        when(transferService.newTransfer(any())).thenReturn(transferModel);
        ResponseEntity<TransferModel> response = transferController.transfer(transferDto);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    void shouldSuccessfullyListTransfers(){
        TaxModel taxModel = new TaxModel(1, 1, 10, 100.0, 5.0);
        List<TransferModel> transfers = List.of(
                new TransferModel(1L, LocalDate.of(2025, 2, 13), LocalDate.of(2025, 2, 20), taxModel, 1500.00, "1234560000", "6543210000"),
                new TransferModel(2L, LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 15), taxModel, 2000.00, "1234560000", "9876540000")
        );
        when(transferService.filterByOriginAccount(any())).thenReturn(transfers);
        ResponseEntity<List<TransferModel>> response = transferController.listTransfers("1234560000");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldSuccessfullyListTransfersdontFindaccount(){
        TaxModel taxModel = new TaxModel(1, 1, 10, 100.0, 5.0);
        List<TransferModel> transfers = List.of(
        );
        when(transferService.filterByOriginAccount(any())).thenReturn(transfers);
        ResponseEntity<List<TransferModel>> response = transferController.listTransfers("");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}