package edu.egg.Sumame.servicios;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.egg.Sumame.entidades.Usuario;
import edu.egg.Sumame.enumeraciones.TipoUsuario;
import edu.egg.Sumame.errores.ErrorServicio;
import edu.egg.Sumame.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
//	@Autowired
//	private NotificacionServicio notificacionServicio;
	
	@Transactional
	public void registrar(String mail, String contraseña, String contraseña2, TipoUsuario tipoUsuario) throws ErrorServicio {
		
		validar(mail, contraseña, contraseña2, tipoUsuario);
		
		Usuario usuario = new Usuario();
		usuario.setMail(mail);
		usuario.setTipoUsuario(tipoUsuario);
		
		String encriptada = new BCryptPasswordEncoder().encode(contraseña);
		usuario.setContraseña(encriptada);
		usuario.setAlta(new Date());
	
		usuarioRepositorio.save(usuario);
		
	}
	
	@Transactional
	public void modificar(String mail, String contraseña, String contraseña2, TipoUsuario tipoUsuario, String id) throws ErrorServicio {
		
		validar(mail, contraseña, contraseña2, tipoUsuario);
		
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Usuario usuario = respuesta.get();
			usuario.setMail(mail);
			
			String encriptada = new BCryptPasswordEncoder().encode(contraseña);
			usuario.setContraseña(encriptada);
			
			usuarioRepositorio.save(usuario);
		} else { 
			throw new ErrorServicio("No se encuentra el usuario solicitado");
			}
		
	}
	
	@Transactional
	public void deshabilitar (String id) throws ErrorServicio {
		
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Usuario usuario= respuesta.get();
			usuario.setBaja(new Date());
			usuarioRepositorio.save(usuario);
		} else {
			throw new ErrorServicio("No se encuentra el usuario solicitado");
		}
	}
	
	private void validar( String mail, String contraseña, String contraseña2, TipoUsuario tipoUsuario) throws ErrorServicio {
		
		if (mail == null || mail.isEmpty()) {
			throw new ErrorServicio("El mail del usuario no puede ser nulo");
		}
		
		if (contraseña == null || contraseña.isEmpty() || contraseña.length() <= 6) {
			throw new ErrorServicio("La contraseña de usuario no puede ser nula y debe tener al menos seis digitos");
		}
		
		if (!contraseña.equals(contraseña2)) {
			throw new ErrorServicio("Las contraseñas deben ser guales.");			
		}
		
		if (tipoUsuario == null) {
			throw new ErrorServicio("El tipo de Usuario no puede ser nulo");
		}
		
	}
	
	@Transactional
	public void habilitar (String id) throws ErrorServicio {
		
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Usuario usuario= respuesta.get();
			usuario.setBaja(null);
			usuarioRepositorio.save(usuario);
		} else {
			throw new ErrorServicio("No se encuentra el usuario solicitado");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.buscarPorMail(mail);
		return null;
	}

}
