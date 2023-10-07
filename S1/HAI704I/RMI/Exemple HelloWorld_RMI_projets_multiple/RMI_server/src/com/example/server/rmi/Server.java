package com.example.server.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.example.server.rmi.AnimalFolderImpl;
import com.example.server.rmi.Espece;

public class Server {
	/* CONSTRUCTOR */
	public Server() {
		
	}
	
	/* METHODS */
	//@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "./security/security.policy");
		System.setSecurityManager(new SecurityManager());
		try {
			
			//AnimalImpl obj = new AnimalImpl("Roxy",new Espece("Chien","13 ans"),"Akita","Jean",new AnimalFolderImpl("Malade","Il casse les couilles"));
			CabinetVetoImpl obj=new CabinetVetoImpl("Vetocita");
			Registry registry = LocateRegistry.createRegistry(1099);
			
			if (registry == null)
				System.err.println("Registry not found on port 1099");
			else {
				registry.bind("Hello", obj);
				System.err.println("Server ready");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}