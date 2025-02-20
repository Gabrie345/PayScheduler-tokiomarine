package br.com.tokiomarine.payschedulertokiomarine;

import br.com.tokiomarine.payschedulertokiomarine.repository.TaxRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public void run(String... args) throws Exception {
        taxRepository.save(new TaxModel(0, 0, 0, 3.00, 2.5));
        taxRepository.save(new TaxModel(1, 1, 10, 12.00, 0.0));
        taxRepository.save(new TaxModel(2, 11, 20, 0.00, 8.2));
        taxRepository.save(new TaxModel(3, 21, 30, 0.00, 6.9));
        taxRepository.save(new TaxModel(4, 31, 40, 0.00, 4.7));
        taxRepository.save(new TaxModel(5, 41, 50, 0.00, 1.7));
    }
}
