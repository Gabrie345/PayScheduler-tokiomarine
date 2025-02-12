package br.com.tokiomarine.payschedulertokiomarine.controler;


import br.com.tokiomarine.payschedulertokiomarine.dto.TaxDto;
import br.com.tokiomarine.payschedulertokiomarine.service.TaxService;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="tax")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping(value="save")
    public ResponseEntity<TaxModel> saveTax (@Valid @RequestBody TaxDto taxDto){

        TaxModel taxModel = taxService.saveTax(taxDto);
        return ResponseEntity.ok().body(taxModel);
    }

}
