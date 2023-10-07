package com.example.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.example.common.rmi.AnimalFolder;

public class AnimalFolderImpl extends UnicastRemoteObject implements AnimalFolder{
	
	private String etat;
	private String remarque;
	
	public AnimalFolderImpl(String e, String r) throws RemoteException {
		this.etat=e;
		this.remarque=r;
	}
	
	public String getEtat() throws RemoteException {
		return this.etat;
	}
	
	public String getRemarque()throws RemoteException {
		return this.remarque;
	}
	
	public void setEtat(String e)throws RemoteException {
		this.etat=e;
	}
	
	public void setRemarque(String r) throws RemoteException {
		this.remarque=r;
	}
	
	public String toStringF() throws RemoteException {
		return "Etat de l'animal : "+this.etat+". Remarque : "+this.remarque;
	}
	
}
