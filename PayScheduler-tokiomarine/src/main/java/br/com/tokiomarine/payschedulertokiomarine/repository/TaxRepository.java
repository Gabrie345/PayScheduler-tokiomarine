package br.com.tokiomarine.payschedulertokiomarine.repository;


import br.com.tokiomarine.payschedulertokiomarine.service.model.TaxModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository<TaxModel,Long> {

    @Query(value = "SELECT ID,MAX_DAYS,MIN_DAYS,TAXA,VALOR FROM TAX_RATE WHERE :day BETWEEN min_days AND max_days", nativeQuery = true)
    Optional<TaxModel> findTaxBetween(@Param("day") long day);

}
