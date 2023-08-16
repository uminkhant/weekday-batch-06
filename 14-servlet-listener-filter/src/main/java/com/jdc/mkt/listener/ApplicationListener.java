package com.jdc.mkt.listener;

import java.io.BufferedReader;
import java.io.FileReader;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.ProductLoader;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		 
		var context = sce.getServletContext();
		var path = context.getRealPath("/files/data.txt");
		var loader = new ProductLoader();
		try(BufferedReader br = 
				new BufferedReader(new FileReader(path))){
			String str = "";
			while((str =br.readLine()) != null ) {
				var arr = str.split(" ");
				Product p = new Product(arr[0], arr[1], Integer.parseInt(arr[2]));
				loader.addProduct(p);
			}
			context.setAttribute("products", loader.getList());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Context Initialized");
	}
	
	
	
//	@Override
//	public void contextDestroyed(ServletContextEvent sce) {
//		System.out.println("Destroyed Initialized");
//	}
}
