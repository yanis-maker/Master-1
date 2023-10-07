package com.example.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AnimalFolder extends Remote{
	String getEtat() throws RemoteException;
	String getRemarque() throws RemoteException;
	void setEtat(String e) throws RemoteException;
	void setRemarque(String r) throws RemoteException;
	String toStringF() throws RemoteException;
}
