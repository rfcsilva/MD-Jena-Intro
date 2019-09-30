package md2018;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class P03 {
	
	// This class is to check the appropriate installation of the Jena framework
	public static void main(String[] args) {
		// create an empty Model
		Model model = ModelFactory.createDefaultModel();
		System.out.println(model);
	}

}
