package web.service;

import javax.jws.WebService;

@WebService(endpointInterface="web.service.MathebService")
public class MathWebServiceImpl implements MathebService {
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
