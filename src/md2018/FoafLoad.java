package md2018;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

public class FoafLoad {

	public static void main(String[] args) {
		// create an empty Model
		Model model = ModelFactory.createDefaultModel();
		
		// load the file from the local disk. Note the way the URL is a relative one
		model.read("file:src/graph-cd.n3");	
		
		// Output the loaded graph by iterating over the existing triples in the memory model
		StmtIterator iter = model.listStatements();
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement();
			Resource subject = stmt.getSubject();
			Resource predicate = stmt.getPredicate();
			RDFNode object = stmt.getObject();

			//TODO: Make a method for printing depending on resource type
			System.out.print("spo(");
			if(subject.isAnon()) 
				System.out.print("_:"+subject.toString());
			else
				System.out.print("<"+subject.toString()+">");

			// The predicate can only contain URIs
			if(predicate.isAnon()) 
				// In standard RDF this is not possible
				System.out.print(",_:"+predicate.toString()+",");
			else
				System.out.print(",<"+predicate.toString()+">,");
			
			// Object can be anything
			if (object.isAnon()) {
				System.out.print("_:"+object.toString());				
			} else if (object.isURIResource()) {
				System.out.print("<"+object.toString()+">");
			} else if (object.isLiteral()) {
				System.out.print("\"" + object.toString() + "\"");
			}
			System.out.println(").");
		}

	}

}
