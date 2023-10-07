package web.service;

import javax.jws.WebService;

@WebService(endpointInterface="web.service.IMathWebService")
public class MathWebService implements IMathWebService {

	@Override
	public int addd(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}

	@Override
	public int substract(int i, int j) {
		// TODO Auto-generated method stub
		return i-j;
	}

	@Override
	public int multiply(int i, int j) {
		// TODO Auto-generated method stub
		return i*j;
	}

	@Override
	public int divide(int i, int j) {
		// TODO Auto-generated method stub
		return i/j;
	}

}
