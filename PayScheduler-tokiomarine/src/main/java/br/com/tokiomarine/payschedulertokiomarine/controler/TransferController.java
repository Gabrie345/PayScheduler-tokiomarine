package br.com.tokiomarine.payschedulertokiomarine.controler;


import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value="transferencia")
public class TransferController {

    @PostMapping
    public ResponseEntity<TransferDto> transfer (@Valid @RequestBody TransferDto transfer){

        return ResponseEntity.ok().body(transfer);
    }

    @PostMapping
    public ResponseEntity<List<TransferDto>> listTransfers (String account){

        return null;
    }
}
