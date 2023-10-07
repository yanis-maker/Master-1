
public class UtilisiationDictionnaire {
	public static void main(String[] args) {
		IDictionary ordred_dico=new OrdredDictionary();
		System.out.println("Tableau vide ? | "+ ordred_dico.isEmpty() + "| Taille: "+ordred_dico.getSize());
		ordred_dico.put("Histrion","L'histrion désigne un des acteurs, spécialement des mimes, qui jouait, accompagné à la flûte, les ludi scaenici en Étrurie.");
		System.out.println("Tableau vide ? | "+ ordred_dico.isEmpty() + "| Taille: "+ordred_dico.getSize());
		System.out.println("Definition de Histrion : "+ordred_dico.get("Histrion"));
	}

}
