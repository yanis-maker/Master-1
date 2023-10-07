import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class ZebreIntension {
	
	public static void main(String[] args) {
		
		Model model= new Model("Zebre");
		
		// Création des variables
		IntVar blu = model.intVar("Blue", 1, 5);	// blu est une variable entière dont le nom est "Blue" est le domaine [1,5]
		IntVar gre = model.intVar("Green", 2, 5); 
		IntVar ivo = model.intVar("Ivory", 1, 5);         
		IntVar red = model.intVar("Red", 1, 5);         
		IntVar yel = model.intVar("Yellow", 1, 5);   
				
		IntVar eng = model.intVar("English", 1, 5);         
		IntVar jap = model.intVar("Japanese", 1, 5);         
		IntVar nor = model.intVar("Norwegian", 1, 1);         
		IntVar spa = model.intVar("Spanish", 1, 5);         
		IntVar ukr = model.intVar("Ukrainian", 1, 5);         
			
		IntVar cof = model.intVar("Coffee", 1, 5);         
		IntVar mil = model.intVar("Milk", 3, 3);         
		IntVar ora = model.intVar("Orange Juice", 1, 5);         
		IntVar tea = model.intVar("Tea", 1, 5);         
		IntVar wat = model.intVar("Water", 1, 5);         
				
		IntVar dog = model.intVar("Dog", 1, 5);         
		IntVar fox = model.intVar("Fox", 1, 5);         
		IntVar hor = model.intVar("Horse", 1, 5);         
		IntVar sna = model.intVar("Snail", 1, 5);         
		IntVar zeb = model.intVar("Zebra", 1, 5);         
			    
		IntVar che = model.intVar("Chesterfield", 1, 5);         
		IntVar koo = model.intVar("Kool", 1, 5);         
		IntVar luc = model.intVar("Lucky Strike", 1, 5);         
		IntVar old = model.intVar("Old Gold", 1, 5);         
		IntVar par = model.intVar("Parliament", 1, 5);
		
		//Création des contraintes
		model.allDifferent(blu,gre,red,ivo,yel).post();
		model.allDifferent(eng,jap,nor,spa,ukr).post();
		model.allDifferent(cof,mil,ora,tea,wat).post();
		model.allDifferent(dog,fox,hor,sna,zeb).post();
		model.allDifferent(che,koo,luc,old,par).post();
		
		
		model.arithm(eng,"=",red).post();
		model.arithm(spa,"=",dog).post();
		model.arithm(cof,"=",gre).post();
		model.arithm(ukr,"=",tea).post();
		model.arithm(eng,"=",red).post();
		model.arithm(gre,"=",ivo,"+",1).post();
		model.arithm(old,"=",sna).post();
		model.arithm(koo,"=",yel).post();
		model.distance(che,fox,"=", 1).post();
		model.distance(koo,hor,"=", 1).post();
		model.arithm(luc,"=",ora).post();
		model.arithm(jap,"=",par).post();
		model.distance(nor,blu,"=", 1).post();
		
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
        /*
        Blue = 2
		Green = 5
		Ivory = 4
		Red = 3
		Yellow = 1
		English = 3
		Japanese = 5
		Norwegian = 1
		Spanish = 4
		Ukrainian = 2
		Coffee = 5
		Milk = 3
		Orange Juice = 4
		Tea = 2
		Water = 1
		Dog = 4
		Fox = 1
		Horse = 2
		Snail = 3
		Zebra = 5
		Chesterfield = 2
		Kool = 1
		Lucky Strike = 4
		Old Gold = 3
		Parliament = 5
        */
	}

}
