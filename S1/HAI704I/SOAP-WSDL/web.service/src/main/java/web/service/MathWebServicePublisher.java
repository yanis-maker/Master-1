package web.service;

import javax.xml.ws.Endpoint;

public class MathWebServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/mathwebservice", new MathWebServiceImpl());
		System.err.println("Server ready");

	}

}
