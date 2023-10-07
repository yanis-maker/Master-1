import java.util.Scanner;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class NReine {
	
	private static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model model=new Model("Reines");
		
		System.out.println("*** Nb Reines : ***\n\n");
		int nbR;
		Scanner s =new Scanner(System.in);
		nbR = s.nextInt();
		
		IntVar [] t=model.intVarArray("r",nbR,0,nbR-1);
		model.allDifferent(t).post();
		
		for(int i=0;i<nbR-1;i++) {
			for(int j=i+1;j<nbR;j++) {
				model.arithm(t[i],"!=",t[j]).post();
				model.distance(t[i],t[j],"!=",j-i).post();
			}
		}
		
		// Affichage du réseau de contraintes créé
        System.out.println("*** Réseau Initial ***");
        System.out.println(model);
        

        //Calcul de la première solution
        if(model.getSolver().solve()) {
        	System.out.println("\n\n*** Première solution ***");        
        	System.out.println(model);
        }
        else {
        	System.out.println("Aucune solution");
        }

               
    	// Calcul de toutes les solutions
    	System.out.println("\n\n*** Autres solutions ***");        
        while(model.getSolver().solve()) {    	
            System.out.println("Sol "+ model.getSolver().getSolutionCount()+"\n"+model);
	    }	    
 
        
        // Affichage de l'ensemble des caractéristiques de résolution
      	System.out.println("\n\n*** Bilan ***");        
        model.getSolver().printStatistics();
	}
}
