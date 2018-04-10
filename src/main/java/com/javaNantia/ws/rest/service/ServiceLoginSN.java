package com.javaNantia.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javaNantia.ws.rest.vo.VOUsuario;

@Path("/loginNantia")
public class ServiceLoginSN {
	
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response validaUsuario(VOUsuario voUsuario) {
		int cod = 401;
		voUsuario.setUsuarioValido(false);
		if(voUsuario.getUsuario().equals("pepe") && voUsuario.getContrasenia().equals("123")) {
			voUsuario.setUsuarioValido(true);
			cod = 200;
		/*
		 * @PathParam("usu") String usu,@PathParam("con") String con
		VOUsuario voUsuario = new VOUsuario();
		voUsuario.setUsuarioValido(false);
		if(usu.equals("pepe") && con.equals("123")) {
			voUsuario.setUsuario(usu);
			voUsuario.setContrasenia(con);
			voUsuario.setUsuarioValido(true);
		*/			 
			 
		}
		return Response.status(cod).entity(voUsuario).build();
	}
	

}
