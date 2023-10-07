package com.example.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.example.common.rmi.AnimalFolder;

public interface Animal extends Remote{
	String getName() throws RemoteException;
	String getMasterName() throws RemoteException;
	String getEspece() throws RemoteException;
	String getRace() throws RemoteException;
	String toStringAnimal() throws RemoteException;
	String sayHello() throws RemoteException;
	String toStringFolder() throws RemoteException;
	void setFolder(String e, String r) throws RemoteException;
	String toStringEspece() throws RemoteException;
}