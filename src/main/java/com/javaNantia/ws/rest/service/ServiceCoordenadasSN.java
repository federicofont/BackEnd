package com.javaNantia.ws.rest.service;

import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javaNantia.ws.rest.persistencia.Coordenadas;
import com.javaNantia.ws.rest.vo.VOCoordenadas;

//@CrossOrigin(origins={"http://localhost:4200", "http://localhost:4242", "http://localhost:4243"});

@Path("/coordenadasNantia")
public class ServiceCoordenadasSN {
	
	@GET
	@Path("/nombreCliente")
	@Produces({MediaType.APPLICATION_JSON})	
	public Response buscarCoordenadas(@PathParam("nombreCliente") String nombreCliente) {

		VOCoordenadas voCoordenadas = new VOCoordenadas();
		voCoordenadas = Coordenadas.buscarCoordenadas("Soda Nantia");
		
		String reqHead = req.getHeaderValue("Access-Control-Request-Headers");

        if(null != reqHead && !reqHead.equals(null)){
            resp.header("Access-Control-Allow-Headers", reqHead);
        }
		
 //return voCoordenadas;
		return Response.status(200).entity(voCoordenadas).build();
		
	}

}
