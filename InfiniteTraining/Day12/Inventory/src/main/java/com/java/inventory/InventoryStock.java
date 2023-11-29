package com.java.inventory;

public class InventoryStock {
	private String stockId;
	private String itemName;
	private double price;
	private int quantityAvail;
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityAvail() {
		return quantityAvail;
	}
	public void setQuantityAvail(int quantityAvail) {
		this.quantityAvail = quantityAvail;
	}
	@Override
	public String toString() {
		return "InventoryStock [stockId=" + stockId + ", itemName=" + itemName + ", price=" + price + ", quantityAvail="
				+ quantityAvail + "]";
	}
	public InventoryStock(String stockId, String itemName, double price, int quantityAvail) {
		super();
		this.stockId = stockId;
		this.itemName = itemName;
		this.price = price;
		this.quantityAvail = quantityAvail;
	}
	public InventoryStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
