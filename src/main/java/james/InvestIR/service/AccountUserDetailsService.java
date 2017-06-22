package james.InvestIR.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import james.InvestIR.domain.ImplUsuario;
import james.InvestIR.repository.ContaRepository;

/**
 * Created by rodrigo on 2/21/17.
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {

	private final ContaRepository contaRepository;

	@Autowired
	public AccountUserDetailsService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.contaRepository.findByUsername(username)
				.map(conta -> new ImplUsuario(conta.getUsername(), conta.getSenha(), conta.isAtivo(),
						conta.isAtivo(), conta.isAtivo(), conta.isAtivo(),
						// AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
						conta.getPapeis().stream().map(papel -> new SimpleGrantedAuthority(papel.getPapel()))
								.collect(Collectors.toList()),
						conta.getUsuario()))
				.orElseThrow(() -> new UsernameNotFoundException("couldn't find " + username + "!"));
	}
}