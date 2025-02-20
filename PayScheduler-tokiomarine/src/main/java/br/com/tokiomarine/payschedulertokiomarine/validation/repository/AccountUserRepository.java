package br.com.tokiomarine.payschedulertokiomarine.validation.repository;

import br.com.tokiomarine.payschedulertokiomarine.validation.service.model.AccountUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface AccountUserRepository extends JpaRepository<AccountUserModel, Long> {

    UserDetails findByCpf(String cpf);

    AccountUserModel findByOriginAccount(String account);

    @Modifying
    @Transactional
    @Query("UPDATE AccountUserModel a SET a.balance = a.balance - :amount WHERE a.originAccount = :accountNumber")
    int updateBalance(@Param("accountNumber") String accountNumber, @Param("amount") BigDecimal amount);


}
