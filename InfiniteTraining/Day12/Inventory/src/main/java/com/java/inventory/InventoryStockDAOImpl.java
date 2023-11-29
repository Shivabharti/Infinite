package com.java.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InventoryStockDAOImpl implements InventoryStockDAO{
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String AddStock(InventoryStock stock) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String getMaxStockIdQuery = "SELECT MAX(StockId) FROM stock";
		pst = connection.prepareStatement(getMaxStockIdQuery);
		ResultSet resultSet = pst.executeQuery();
		 int maxStockId = 0;
         if (resultSet.next()) {
             String maxStockIdStr = resultSet.getString(1);
             if (maxStockIdStr != null && maxStockIdStr.matches("S\\d+")) {
                 maxStockId = Integer.parseInt(maxStockIdStr.substring(1));
             }
         }
         maxStockId++;
        String newStockId = String.format("S%03d", maxStockId);
		String cmd = "Insert into stock(StockId,ItemName,Price,quantityAvail) values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, newStockId);
		pst.setString(2, stock.getItemName());
		pst.setDouble(3, stock.getPrice());
		pst.setInt(4, stock.getQuantityAvail());
        pst.executeUpdate();
		return "Item inserted";
	}
	

	@Override
	public InventoryStock searchStock(String stockId) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd = "select * from stock where stockid=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, stockId);
		ResultSet rs = pst.executeQuery();
		InventoryStock inv_stock=null;
		while(rs.next()) {
			inv_stock=new InventoryStock();
			inv_stock.setStockId(rs.getString("stockid"));
			inv_stock.setItemName(rs.getString("ItemName"));
			inv_stock.setPrice(rs.getDouble("price"));
			inv_stock.setQuantityAvail(rs.getInt("QuantityAvail"));
		}
		return inv_stock;
	}

}
