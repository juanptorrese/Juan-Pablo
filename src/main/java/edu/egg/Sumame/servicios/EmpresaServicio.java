package edu.egg.Sumame.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.egg.Sumame.entidades.Departamento;
import edu.egg.Sumame.entidades.Domicilio;
import edu.egg.Sumame.entidades.Empresa;
import edu.egg.Sumame.entidades.Provincia;
import edu.egg.Sumame.entidades.Usuario;
import edu.egg.Sumame.repositorios.DepartamentoRepositorio;
import edu.egg.Sumame.repositorios.DomicilioRepositorio;
import edu.egg.Sumame.repositorios.EmpresaRepositorio;
import edu.egg.Sumame.repositorios.ProvinciaRepositorio;
import edu.egg.Sumame.repositorios.UsuarioRepositorio;

@Service
public class EmpresaServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private EmpresaRepositorio empresaRepositorio;
	
	@Autowired
	private DomicilioRepositorio domicilioRepositorio;
	
	@Autowired
	private ProvinciaRepositorio provinciaRepositorio;
	
	@Autowired
	private DepartamentoRepositorio departamentoRepositorio;
	
	@Transactional
	public void formularioEmpresa (String nombre, String cuil, String telefono, String mail, String sector, String direccion, String idProvincia, String idDepartamento) {
		
		Provincia provincia = provinciaRepositorio.getOne(idProvincia);
		Departamento departamento = departamentoRepositorio.getOne(idDepartamento);		
		
		Usuario usuario = usuarioRepositorio.buscarPorMail(mail);
		
		Domicilio domicilio= new Domicilio();
		domicilio.setDireccion(direccion);
		domicilio.setDepartamento(departamento);
		domicilio.setProvincia(provincia);
		domicilio.setDepartamento(departamento);
		
		domicilio= domicilioRepositorio.save(domicilio);
		
		Empresa empresa= new Empresa();
		empresa.setNombre(nombre);
		empresa.setCuil(cuil);
		empresa.setTelefono(telefono);
		empresa.setMail(usuario.getMail());
		empresa.setSectorEmpresarial(sector);
		empresa.setDomicilio(domicilio);
		
		empresaRepositorio.save(empresa);		
		
	}

}
