package br.com.tokiomarine.payschedulertokiomarine.validation.service;


import br.com.tokiomarine.payschedulertokiomarine.constants.MessageConstants;
import br.com.tokiomarine.payschedulertokiomarine.exceptions.NotFoundException;
import br.com.tokiomarine.payschedulertokiomarine.validation.dto.AccountUserDto;
import br.com.tokiomarine.payschedulertokiomarine.validation.repository.AccountUserRepository;
import br.com.tokiomarine.payschedulertokiomarine.validation.service.model.AccountUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    AccountUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return repository.findByCpf(cpf);
    }

    public AccountUserModel userRegistration(AccountUserDto accountUserDto) throws NotFoundException {
        UserDetails user = repository.findByCpf(accountUserDto.getCpf());
        if (user != null) throw new NotFoundException(MessageConstants.USE_CPF);

        String encryptedPassword = new BCryptPasswordEncoder().encode(accountUserDto.getPassword());
        AccountUserModel accountUserModel = new AccountUserModel(accountUserDto.getName(),
                accountUserDto.getCpf(),
                encryptedPassword);
        System.out.println(accountUserModel.getBalance());
        return repository.save(accountUserModel);
    }

}
