package br.com.tokiomarine.payschedulertokiomarine;

import br.com.tokiomarine.payschedulertokiomarine.repository.TransferRepository;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDate;

@SpringBootApplication
public class PaySchedulerTokiomarineApplication {



	public static void main(String[] args) {
		SpringApplication.run(PaySchedulerTokiomarineApplication.class, args);
	}



}
