package com.web.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class WebServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String URL = "http://localhost:8080/EmarketService/WebService/product/get?first=0&max=10";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ResteasyClient client = new ResteasyClientBuilder().build();
		WebTarget target = client.target(URL);
		String json = target.request().get(String.class);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
		
	}
	
}
