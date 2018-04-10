package com.javaNantia.ws.rest.vo;

public class VOCoordenadas {
	private String CorLat;
	private String CorLan;
	private int idCliente;
	
	
	public VOCoordenadas(){
	   }
	
	public String getCorLat() {
		return CorLat;
	}
	public void setCorLat(String corLat) {
		CorLat = corLat;
	}
	public String getCorLan() {
		return CorLan;
	}
	public void setCorLan(String corLan) {
		CorLan = corLan;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
