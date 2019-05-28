package br.com.zenganet.segurancaoauth2jwt.secutity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.zenganet.segurancaoauth2jwt.model.Usuario;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = -5622849465389758809L;

	private Usuario usuario;

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
