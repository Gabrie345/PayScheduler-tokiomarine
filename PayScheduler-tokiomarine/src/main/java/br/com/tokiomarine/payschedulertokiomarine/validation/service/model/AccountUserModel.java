package br.com.tokiomarine.payschedulertokiomarine.validation.service.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Table(name = "ACCOUNT_USER_INFORMATION")
@Entity
public class AccountUserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_account", nullable = false, length = 10, unique = true)
    private String originAccount;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;


    public AccountUserModel(String name, String cpf, String password) {
        this.originAccount = generateAccountNumber();
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.balance = generateInitialBalance();
    }


    public AccountUserModel() {
        this.originAccount = generateAccountNumber();
    }

    private BigDecimal generateInitialBalance() {
        Random random = new Random();
        int amount = 1000 + random.nextInt(9001);
        return BigDecimal.valueOf(amount);
    }

    private String generateAccountNumber() {
        Random random = new Random();
        long number = Math.abs(1000000000L + random.nextLong() % 9000000000L);
        return String.valueOf(number);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
