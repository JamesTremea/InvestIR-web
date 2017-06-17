package james.InvestIR.domain;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;

/**
 * Created by James on 06/05/17.
 */

public class ImplUsuario  {								// extends User

    private Usuario usuario;

//    public ImplUsuario(String username, String password, Collection<? extends GrantedAuthority> authorities) {
 //       super(username, password, authorities);
 //   }

//    public ImplUsuario(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//    }
//
//    public ImplUsuario(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Usuario usuario) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//        this.usuario = usuario;
//     }

    public Usuario getUsuario() {
		return usuario;
	}

    public void setUsuario (Usuario usuario) {
        this.usuario = usuario;
    }
}
