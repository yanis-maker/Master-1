package web.service;

import javax.xml.ws.Endpoint;

public class MathWebServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080", new MathWebService());
		System.err.println("server ready");

	}

}
