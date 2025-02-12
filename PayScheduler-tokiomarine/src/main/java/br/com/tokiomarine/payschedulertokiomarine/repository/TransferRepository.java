package br.com.tokiomarine.payschedulertokiomarine.repository;


import br.com.tokiomarine.payschedulertokiomarine.service.model.TransferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransferRepository extends JpaRepository<TransferModel,Long> {

    List<TransferModel> findAllByOriginAccount(String originAccount);
}


