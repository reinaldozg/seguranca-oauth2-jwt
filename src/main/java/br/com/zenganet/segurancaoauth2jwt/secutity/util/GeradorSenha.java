package br.com.zenganet.segurancaoauth2jwt.secutity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
		System.out.println(encoder.encode("@ngul@r0"));

	}

}
