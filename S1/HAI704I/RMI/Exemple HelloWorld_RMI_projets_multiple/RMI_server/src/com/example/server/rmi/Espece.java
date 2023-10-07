package com.example.server.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.Remote;

public class Espece implements Serializable {
	
	private String nom;
	
	
	public Espece(String n) {
		this.nom=n;
	}
	
	public String getNom() throws RemoteException{
		return this.nom;
	}

	
	@Override
	public String toString() {
		return "Espece : "+this.nom;
	}
	
	



}
