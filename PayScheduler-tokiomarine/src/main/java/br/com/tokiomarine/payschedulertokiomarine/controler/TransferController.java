package br.com.tokiomarine.payschedulertokiomarine.controler;


import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.service.TransferService;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="transferencia")
public class TransferController {

    @Autowired
    private TransferService service;

    @PostMapping
    public ResponseEntity<TransferModel> transfer (@Valid @RequestBody TransferDto transfer){
        TransferModel transferModel = service.newTransfer(transfer);
        return ResponseEntity.ok().body(transferModel);
    }

    @GetMapping(value = "listar")
    public ResponseEntity<List<TransferModel>> listTransfers (@PathVariable String account){
        List<TransferModel> transferModels = service.filterByOriginAccount(account);
        return ResponseEntity.ok().body(transferModels);
    }
}
