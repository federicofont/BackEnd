package com.javaNantia.ws.rest.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javaNantia.ws.rest.vo.VOCoordenadas;

public class Coordenadas {
	
	public static VOCoordenadas buscarCoordenadas(String nombreCliente) {
		
				
		VOCoordenadas voCoordenadas = new VOCoordenadas();
		int idCliente = buscarIdCliente(nombreCliente);
		String corLat = "", corLan = "";
		
		Conexion conexion = new Conexion();
		
		Connection con;
		try {
			
			con = conexion.crearConexion();
			
			Statement st = con.createStatement();
			String sql="SELECT * FROM \"Coordenadas\" WHERE \"CorIdCliente\" = " + idCliente;
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){
				corLat = rs.getString(1);
				corLan = rs.getString(2);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		voCoordenadas.setCorLan(corLan);
		voCoordenadas.setCorLat(corLat);
		voCoordenadas.setIdCliente(idCliente);
		
		return voCoordenadas;
	}
	
	public static int buscarIdCliente(String nombreCliente) {
		
		Conexion conexion = new Conexion();
		int idCliente = 0;
		Connection con;
		try {			
			con = conexion.crearConexion();
			Statement st = con.createStatement();
			String sql="SELECT \"idCliente\" FROM \"Clientes\" WHERE \"Nombre\" = '"+ nombreCliente +"'";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){
				idCliente = Integer.parseInt(rs.getString(1));
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return idCliente;
	}


}
