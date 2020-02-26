package edu.egg.Sumame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.egg.Sumame.entidades.Empresa;
import edu.egg.Sumame.servicios.EmpresaServicio;
import edu.egg.Sumame.servicios.UsuarioServicio;

@SpringBootApplication
public class SumameApplication {
	
	@Autowired
	private UsuarioServicio usuarioServicio;

	public static void main(String[] args) {
		SpringApplication.run(SumameApplication.class, args);
		
		EmpresaServicio servicio = new EmpresaServicio();
		
		servicio.formularioEmpresa("Ocho", "56", "4305352", "lalala@gmail.com", "direccion", "1", "1");
		
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
	}

}
