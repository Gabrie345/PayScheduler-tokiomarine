package br.com.tokiomarine.payschedulertokiomarine.validation.repository;

import br.com.tokiomarine.payschedulertokiomarine.validation.service.model.AccountUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountUserRepository extends JpaRepository<AccountUserModel, Long> {

    UserDetails findByCpf(String cpf);
}
