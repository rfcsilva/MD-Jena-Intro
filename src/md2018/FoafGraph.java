package md2018;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoafGraph {

	@SuppressWarnings(value = "unused")
	private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);

	// some definitions
	static String personURI = "http://nova-lincs.di.fct.unl.pt/person/184";
	static String givenName = "Carlos";
	static String familyName = "Viegas Damásio";
	static String fullName = givenName + " " + familyName;

	public static void main(String[] args) {
		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource programmatically
		Resource eu = model.createResource(personURI);
		
		// Add my name and coordinates
		eu.addProperty( VCARD.FN, fullName)
		  .addProperty( VCARD.N, model.createResource().addProperty(VCARD.Given, givenName).addProperty(VCARD.Family, familyName))
		  .addProperty( VCARD.GEO, model.createResource("geo:38.661445,-9.2057587"))
		  ;

		// Output of the constructed graph in several formats
		System.out.println("JSON-LD format");
		model.write(System.out, "JSON-LD");
		System.out.println("\nN3 format");
		model.write(System.out, "N3");
		System.out.println("\nN-Triples format");
		model.write(System.out, "N-Triples");
		System.out.println("\nRDF/XML format");
		model.write(System.out, "RDF/XML");
		System.out.println("\nRDF/XML abbrev format");
		model.write(System.out, "RDF/XML-Abbrev");

	}

}
