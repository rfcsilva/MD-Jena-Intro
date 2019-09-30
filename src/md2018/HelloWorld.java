package md2018;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

	@SuppressWarnings(value = "unused")
	private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);

	// Creates a single triple
	public static void main(String[] args) {
		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource programmatically
		// creates the resource
		Resource someone = model.createResource("http://campus.fct.unl.pt/student");
		// creates and adds the triple
		someone.addProperty(model.createProperty("http://campus.fct.unl.pt/property"), "Hello World");
		model.write(System.out,"N-TRIPLES");
	}
	
}
