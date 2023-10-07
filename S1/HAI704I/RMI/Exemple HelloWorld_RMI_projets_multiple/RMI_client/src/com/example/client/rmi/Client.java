package com.example.client.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.example.common.rmi.Animal;
import com.example.common.rmi.CabinetVeto;
import com.example.common.rmi.AnimalFolder;

public class Client {
	private Client() {}
	
	public static void main(String[] args) {
		String host = (args.length < 1)? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			//Animal obj = (Animal) registry.lookup("Hello");
			CabinetVeto obj = (CabinetVeto) registry.lookup("Hello");
			/*System.out.println(obj);
			String response = obj.sayHello();*/
			Scanner scan= new Scanner(System.in);
			obj.addPatient("Rocky","berger","chien","Louis","Bonne santé","C'est un boss");
			obj.printPatients();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}