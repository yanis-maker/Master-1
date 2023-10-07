package web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IMathWebService {

	@WebMethod
	int addd(int i, int j);
	
	@WebMethod
	int substract(int i, int j);
	
	@WebMethod
	int multiply(int i,int j);
	
	@WebMethod
	int divide(int i, int j);
}
