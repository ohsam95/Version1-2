package com.cos.product.action.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.cos.product.action.Action;
import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;
import com.google.gson.Gson;

public class deleteProcAction implements Action{
	
	public void execute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		ProductRepository productRepository = ProductRepository.getinstance();
		int result = productRepository.deleteById(id);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.print(result);
			
			
			List<Product> products = productRepository.first();
//			request.setAttribute("products", products);
			
			Gson gson = new Gson();
			String productJson = gson.toJson(products);
	
			
			response.setCharacterEncoding("UTF-8");
			out.println(productJson);
			}
	
	
	};

