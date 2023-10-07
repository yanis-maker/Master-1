package pt1_jena;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		

		 Model model1 = ModelFactory.createDefaultModel();

         RDFDataMgr.read(model1, "file1.ttl");


         List<Property> properties = new ArrayList<>();
         model1.listStatements().forEachRemaining(stmt -> {
             Property prop = stmt.getPredicate();
             if (!properties.contains(prop)) {
                 properties.add(prop);
             }
         });


         properties.forEach(prop -> System.out.println(prop.getLocalName()));
		// TODO Auto-generated method stub
		String nsfoaf = "http://xmlns.com/foaf/0.1/";
		String nsmusic = "http://www.kanzaki.com/ns/music#";
		String nsrdfs = "http://www.w3.org/2000/01/rdf-schema#";
		String nsschema = "http://schema.org/";
		String jupiterURI = "http://example.com/jupiter";
		String mozartURI = "http://example.com/mozart";
		String orchestreURI = "http://example.com/orchLondre";
		String spouseURI = "http://example.com/constanceWeber";
		String fatherURI = "http://example.com/leopoldMozart";
		String abbadoURI = "http://example.com/abbado";
		String allegroURI = "http://example.com/allegro";
		String menuettoURI = "http://example.com/menuetto";
		String andanteURI = "http://example.com/andante";
		String moltoURI = "http://example.com/molto";
		String fluteURI = "http://example.com/la_flute_enchantee";

		Model model = ModelFactory.createDefaultModel();

		model.setNsPrefix("foaf", nsfoaf);
		model.setNsPrefix("music", nsmusic);
		model.setNsPrefix("rdfs", nsrdfs);
		model.setNsPrefix("schema", nsschema);

		Resource jupiter = model.createResource(jupiterURI)
				.addProperty(RDF.type, model.createResource("http://www.kanzaki.com/ns/music#Symphony"))
				.addProperty(model.createProperty(nsrdfs + "label"), "41 Symphonie en ut majeu Jupiter")
				.addProperty(model.createProperty(nsmusic + "recordedBy"), model.createResource(orchestreURI))
				.addProperty(model.createProperty(nsmusic + "recordyear"), "1980")
				.addProperty(model.createProperty(nsmusic + "composer"), model.createResource(mozartURI));

		Resource mozart = model.createResource(mozartURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Composer"))
				.addProperty(RDF.type, model.createResource(nsfoaf + "Person"))
				.addProperty(model.createProperty(nsfoaf + "spouse"), model.createResource(spouseURI))
				.addProperty(model.createProperty(nsfoaf + "father"), model.createResource(fatherURI))
				.addProperty(model.createProperty(nsfoaf + "deathplace"), "Vienne")
				.addProperty(model.createProperty(nsfoaf + "birthplace"), "Salzbourg")
				.addProperty(model.createProperty(nsfoaf + "deathday"), "1791-12-05")
				.addProperty(model.createProperty(nsfoaf + "birthday"), "1756-01-27")
				.addProperty(model.createProperty(nsfoaf + "name"), "Wolfgang Amadeus Mozart");

		Resource father = model.createResource(fatherURI).addProperty(RDF.type, model.createResource(nsfoaf + "Person"))
				.addProperty(model.createProperty(nsfoaf + "name"), "Leopold Mozart");

		Resource spouse = model.createResource(spouseURI).addProperty(RDF.type, model.createResource(nsfoaf + "Person"))
				.addProperty(model.createProperty(nsfoaf + "name"), "Constance Weber");

		Resource orchestre = model.createResource(orchestreURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Orchestra"))
				.addProperty(model.createProperty(nsmusic + "conductor"), model.createResource(abbadoURI))
				.addProperty(model.createProperty(nsschema + "location"), "Londre")
				.addProperty(model.createProperty(nsschema + "name"), "Orchestre Symphonique de Londre");

		Resource abbado = model.createResource(abbadoURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Conductor"))
				.addProperty(RDF.type, model.createResource(nsfoaf + "Person"))
				.addProperty(model.createProperty(nsfoaf + "name"), "Claudio Abbado");

		Resource allegro = model.createResource(allegroURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Movement"))
				.addProperty(model.createProperty(nsmusic + "partOf"), model.createResource(jupiterURI))
				.addProperty(model.createProperty(nsmusic + "title"), "Allegro Vivace");

		Resource andante = model.createResource(andanteURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Movement"))
				.addProperty(model.createProperty(nsmusic + "partOf"), model.createResource(jupiterURI))
				.addProperty(model.createProperty(nsmusic + "title"), "Andante Cantabile");

		Resource menuetto = model.createResource(menuettoURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Movement"))
				.addProperty(model.createProperty(nsmusic + "partOf"), model.createResource(jupiterURI))
				.addProperty(model.createProperty(nsmusic + "title"), "Menuetto");

		Resource molto = model.createResource(moltoURI)
				.addProperty(RDF.type, model.createResource(nsmusic + "Movement"))
				.addProperty(model.createProperty(nsmusic + "partOf"), model.createResource(jupiterURI))
				.addProperty(model.createProperty(nsmusic + "title"), "Molto");

		Resource flute = model.createResource(fluteURI).addProperty(RDF.type, model.createResource(nsmusic + "Opera"))
				.addProperty(model.createProperty(nsmusic + "composer"), model.createResource(mozartURI))
				.addProperty(model.createProperty(nsmusic + "title"), "La flute enchantée");

		try {
			FileWriter writerXML = new FileWriter("xml_result.rdf");
			model.write(writerXML);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writerTTL = new FileWriter("turtle_result.ttl");
			model.write(writerTTL, "TURTLE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writerJSON = new FileWriter("json_result.json");
			model.write(writerJSON, "JSON-LD");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writerTRIPLE = new FileWriter("triple_result.txt");
			model.write(writerTRIPLE, "N-TRIPLE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// model.write(System.out,"TURTLE");
		// model.write(System.out);
		// model.write(System.out,"JSON-LD");
		// model.write(System.out,"N-TRIPLE");
	}

}
