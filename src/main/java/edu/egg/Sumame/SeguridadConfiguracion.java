package edu.egg.Sumame;

import edu.egg.Sumame.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(10)
public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("usuarioServicio")
	public UsuarioServicio usuarioServicio;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http
        .authorizeRequests()
            .antMatchers("/css/", "/js/", "/img/*")
            .permitAll().and()
        .formLogin()
            .loginPage("/")
            .loginProcessingUrl("/logincheck")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/loginsuccess")
            .permitAll().and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/?logout")
            .permitAll().and()
        .csrf().disable();
	}

}
