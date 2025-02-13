package br.com.tokiomarine.payschedulertokiomarine.service;

import br.com.tokiomarine.payschedulertokiomarine.constants.MessageConstants;
import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.exceptions.NotFoundException;
import br.com.tokiomarine.payschedulertokiomarine.repository.TaxRepository;
import br.com.tokiomarine.payschedulertokiomarine.repository.TransferRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class TransferServiceTest {

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private TaxRepository taxRepository;

    @InjectMocks
    private TransferService transferService;

    private TransferDto transferDto;
    private TransferModel transferModel;
    private TaxModel taxModel;

    @BeforeEach
    void setUp() {
        taxModel = new TaxModel(1, 1, 10, 100.0, 5.0);

        transferDto = new TransferDto(
                "1234560000",
                "6543210000",
                1500.00,
                LocalDate.of(2025, 2, 20)
        );

        transferModel = new TransferModel(
                1L,
                LocalDate.now(),
                transferDto.getAppointmentDate(),
                taxModel,
                transferDto.getValue(),
                transferDto.getOriginAccount(),
                transferDto.getDestinationAccount()
        );

    }

    @Test
    void shouldSuccessfullyCreateNewTransfer() {
        when(taxRepository.findTaxBetween(anyLong())).thenReturn(Optional.of(taxModel));
        when(transferRepository.save(any())).thenReturn(transferModel);

        TransferModel result = transferService.newTransfer(transferDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(transferDto.getValue(), result.getValue());
        Assertions.assertEquals(transferDto.getOriginAccount(), result.getOriginAccount());
    }
    @Test
    void shouldThrowExceptionWhenNoTaxFound() {
        when(taxRepository.findTaxBetween(anyLong())).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            transferService.newTransfer(transferDto);
        });

        assertThat(exception.getMessage()).isEqualTo(MessageConstants.TAX_NOT_FOUND);

    }
    @Test
    void shouldFilterByOriginAccountSuccessfully() {
        when(transferRepository.findAllByOriginAccount(anyString())).thenReturn(List.of(transferModel));

        List<TransferModel> result = transferService.filterByOriginAccount("1234560000");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(transferDto.getValue(), result.get(0).getValue());
    }

    @Test
    void shouldThrowExceptionWhenNoTransfersFound() {
        when(transferRepository.findAllByOriginAccount(anyString())).thenReturn(List.of());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            transferService.filterByOriginAccount("1234560000");
        });

        assertThat(exception.getMessage()).isEqualTo(MessageConstants.ACCOUNT_NOT_FOUND);

    }
}