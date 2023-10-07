package com.example.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

//import com.example.server.rmi.Espece;

public interface CabinetVeto extends Remote{
	
	public Animal getPatient(String nom) throws RemoteException;
	public void addPatient(String n, String e, String r, String m_n, String etat_sante, String remarque) throws RemoteException;
	public String removePatient(String n) throws RemoteException;
	public int getSize() throws RemoteException;
	public void printPatients() throws RemoteException;
}
