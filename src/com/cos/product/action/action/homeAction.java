package com.cos.product.action.action;

import java.util.List;

import javax.servlet.RequestDispatcher;

import com.cos.product.action.Action;
import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;

public class homeAction implements Action{
	
	public void execute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
			ProductRepository productRepository = ProductRepository.getinstance();
			List<Product> products = productRepository.home();
			request.setAttribute("products", products);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
			dis.forward(request, response);
			}

	
	};

