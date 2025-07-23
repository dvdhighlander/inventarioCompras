package com.co.sales.inventory.api.model;

public class CompraResponse {

	private int producto_id;
	private int cantidadCompra;
	private double valorTotalCompra;
	private String responseMessage;

	
	public int getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	public int getCantidadCompra() {
		return cantidadCompra;
	}
	public void setCantidadCompra(int cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public double getValorTotalCompra() {
		return valorTotalCompra;
	}
	public void setValorTotalCompra(double valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}
	
	
}
