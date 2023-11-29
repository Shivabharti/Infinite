package com.java.inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchStockMain {

	public static void main(String[] args) {
		String stockId;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Stock Id");
		stockId= sc.next();
		InventoryStockDAO dao= new InventoryStockDAOImpl();
		try {
			InventoryStock stock= dao.searchStock(stockId);
			if(stock!=null) {
				System.out.println(stock);
			}else {
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
