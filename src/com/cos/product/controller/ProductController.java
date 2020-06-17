package com.cos.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.HomesUserDatabase;

import com.cos.product.action.Action;
import com.cos.product.action.action.countDESCAction;
import com.cos.product.action.action.deleteProcAction;
import com.cos.product.action.action.firstAction;
import com.cos.product.action.action.homeAction;
import com.cos.product.action.action.priceDESCAction;




@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.setAttribute("path", request.getContextPath());
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		action.execute(request, response);
	}
	public Action router(String cmd) {
		if (cmd.equals("home")) {
		return new homeAction() ;			
		}else if (cmd.equals("price")) {
			return new priceDESCAction();
		}else if (cmd.equals("count")) {
			return new countDESCAction();
		}else if (cmd.equals("first")) {
			return new firstAction();
		}else if (cmd.equals("delete")) {
			return new deleteProcAction();
		}
		return null;
	}
}
