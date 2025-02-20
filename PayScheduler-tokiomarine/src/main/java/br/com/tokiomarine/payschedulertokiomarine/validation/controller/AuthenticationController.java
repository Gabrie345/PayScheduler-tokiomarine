package br.com.tokiomarine.payschedulertokiomarine.validation.controller;


import br.com.tokiomarine.payschedulertokiomarine.validation.dto.AccountUserDto;
import br.com.tokiomarine.payschedulertokiomarine.validation.dto.AuthenticationDto;
import br.com.tokiomarine.payschedulertokiomarine.validation.service.AuthorizationService;
import br.com.tokiomarine.payschedulertokiomarine.validation.service.TokenService;
import br.com.tokiomarine.payschedulertokiomarine.validation.service.model.AccountUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AuthorizationService serviceAuthorization;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(data.getCpf(), data.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken((AccountUserModel) authenticate.getPrincipal());
        ((AccountUserModel) authenticate.getPrincipal()).setPassword(token);
        return ResponseEntity.ok(authenticate.getPrincipal());
    }

    @PostMapping("/register")
    public ResponseEntity<AccountUserModel> register(@RequestBody @Valid AccountUserDto data){
        AccountUserModel accountUser = serviceAuthorization.userRegistration(data);
        return ResponseEntity.ok(accountUser);

    }

}
