package com.java.inventory;

import java.sql.SQLException;

public interface InventoryStockDAO {

	String AddStock(InventoryStock stock) throws ClassNotFoundException, SQLException;
	InventoryStock searchStock(String stockId) throws ClassNotFoundException, SQLException;	
}
