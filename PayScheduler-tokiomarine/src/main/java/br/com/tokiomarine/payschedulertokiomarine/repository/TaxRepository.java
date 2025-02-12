package br.com.tokiomarine.payschedulertokiomarine.repository;


import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<TaxModel,Long> {

}
