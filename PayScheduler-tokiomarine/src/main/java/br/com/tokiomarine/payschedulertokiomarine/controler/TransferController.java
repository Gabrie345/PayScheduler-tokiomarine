package br.com.tokiomarine.payschedulertokiomarine.controler;


import br.com.tokiomarine.payschedulertokiomarine.dto.TransferDto;
import br.com.tokiomarine.payschedulertokiomarine.service.TransferService;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="transferencia")
public class TransferController {

    @Autowired
    private TransferService service;

    @PostMapping
    public ResponseEntity<TransferDto> transfer (@Valid @RequestBody TransferDto transfer){

        return ResponseEntity.ok().body(transfer);
    }

    @PostMapping
    public ResponseEntity<List<TransferModel>> listTransfers (String account){
        //ResponseEntity.ok(service.findAll());
        return null;
    }
}
