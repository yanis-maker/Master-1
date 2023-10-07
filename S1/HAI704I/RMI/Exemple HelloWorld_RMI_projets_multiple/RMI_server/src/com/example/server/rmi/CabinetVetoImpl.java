package com.example.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.example.common.rmi.Animal;
import com.example.common.rmi.AnimalFolder;
import com.example.common.rmi.CabinetVeto;

public class CabinetVetoImpl extends UnicastRemoteObject implements CabinetVeto {
	
	private String name;
	private int nb_patient;
	private Animal[] patients;

	protected CabinetVetoImpl(String n) throws RemoteException {
		this.name=n;
		this.nb_patient=0;
		this.patients= new Animal[0]; 
	}

	@Override
	public Animal getPatient(String nom) throws RemoteException{
		// TODO Auto-generated method stub
		for(int i=0;i<this.nb_patient;i++) {
			if(this.patients[i].getName().equals(nom)) {
				return this.patients[i];
			}
		}
		System.out.println("Il n'y a aucun animla portant le nom : "+nom+" dans ce cabinet");
		return null ;
	}

	public void addPatient(String n, String e, String r, String m_n, String etat_sante, String remarque) throws RemoteException {
		// TODO Auto-generated method stub
		Animal[] new_patients=new Animal[this.nb_patient+1];
		for(int i=0;i<this.nb_patient;i++) {
			new_patients[i]=this.patients[i];
		}
		
		this.patients=new_patients;
		Espece specie=new Espece(e);
		AnimalFolderImpl dossier=new AnimalFolderImpl(etat_sante,remarque);
		this.patients[this.nb_patient]=new AnimalImpl(n, specie, r, m_n, dossier);
		this.nb_patient+=1;
		
	}

	@Override
	public String removePatient(String n) throws RemoteException {
		// TODO Auto-generated method stub
		if(this.nb_patient==0) {
			return "Le cabinet est déja vide";
		}
		else {
			Animal[] new_patients=new Animal[this.nb_patient-1];
			int indice_p=0;
			if(this.nb_patient==1){
				this.patients=new_patients;
				this.nb_patient-=1;
				return "Opération réussi, l'animal ne fais plus partie du cabinet, Le cabinet est maintenant vide";
			}
			else {
				int i=0;
				boolean trouve=false;
				while(i<this.nb_patient && !trouve) {
					if(!this.patients[i].getName().equals(n)) {
						new_patients[i]=this.patients[i];
						i++;
					}
					else {
						indice_p=i;
						trouve=true;
					}
				}
				//System.out.println(trouve);
				if(!trouve) {return "Cette Animal n'est pas dans ce cabinet";}
				if(indice_p!=this.nb_patient-1) {
					for(int j=indice_p+1;j<this.nb_patient;j++) {
						new_patients[j-1]=this.patients[j];
					}
				}
				
				this.patients=new_patients;
				this.nb_patient-=1;
				return "Opération réussi, l'animal ne fais plus partie du cabinet";
			}
		}
	}

	@Override
	public int getSize() throws RemoteException {
		// TODO Auto-generated method stub
		return this.nb_patient;
	}
	
	public void printPatients() throws RemoteException {
		for(int i=0;i<this.nb_patient;i++) {
			System.out.println(this.patients[i].toStringAnimal());
		}
	}

}
