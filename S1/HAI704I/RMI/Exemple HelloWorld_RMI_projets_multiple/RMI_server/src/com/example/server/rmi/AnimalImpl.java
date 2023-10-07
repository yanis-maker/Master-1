package com.example.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.example.common.rmi.Animal;
import com.example.common.rmi.AnimalFolder;

public class AnimalImpl extends UnicastRemoteObject  implements Animal {
	
	private String Name;
	private String Race;
	private String MasterName;
	private Espece espece;
	private AnimalFolder dossier;

	public AnimalImpl(String n, Espece e, String r, String m_n, AnimalFolder d) throws RemoteException{
		this.Name=n;
		this.Race=r;
		this.MasterName=m_n;
		this.espece=new Espece(e.getNom());
		this.dossier=new AnimalFolderImpl(d.getEtat(),d.getRemarque());
		
	}
	
	public String getName() throws RemoteException{
		return this.Name;
	}
	public String getMasterName() throws RemoteException{
		return this.MasterName;
	}
	public String getEspece() throws RemoteException{
		return this.espece.getNom();
	}
	public String getRace() throws RemoteException{
		return this.Race;
	}
	
	public String toStringAnimal() throws RemoteException{
		return "Nom: "+this.Name + ", Race: " + this.Race + ", Nom du maitre: " + this.MasterName;
	}
	
	public String sayHello() throws RemoteException{
    	return "Hello, world!";
        }
	
	public void setFolder(String e, String r) throws RemoteException{
		this.dossier.setEtat(e);
		this.dossier.setRemarque(r);
	}
	
	public String toStringFolder() throws RemoteException{
		return this.dossier.toStringF();
	}
	
	public String toStringEspece() throws RemoteException{
		return this.espece.toString();
	}
}