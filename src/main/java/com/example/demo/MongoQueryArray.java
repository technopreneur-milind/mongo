package com.example.demo;

import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import org.bson.Document;
import org.springframework.stereotype.Component;

/**
 * collection.insertMany(asList(
        Document.parse("{ item: 'journal', qty: 25, tags: ['blank', 'red'], dim_cm: [ 14, 21 ] }"),
        Document.parse("{ item: 'notebook', qty: 50, tags: ['red', 'blank'], dim_cm: [ 14, 21 ] }"),
        Document.parse("{ item: 'paper', qty: 100, tags: ['red', 'blank', 'plain'], dim_cm: [ 14, 21 ] }"),
        Document.parse("{ item: 'planner', qty: 75, tags: ['blank', 'red'], dim_cm: [ 22.85, 30 ] }"),
        Document.parse("{ item: 'postcard', qty: 45, tags: ['blue'], dim_cm: [ 10, 15.25 ] }")
));
 * @author Milind
 *
 */
@Component
public class MongoQueryArray extends MongoParent {

	public String match()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("tags", asList("red", "blank"))).spliterator());
	}
	
	public String matchWithoutOrder()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(all("tags", asList("red", "blank"))).spliterator());
	}
	
	public String query()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(elemMatch("dim_cm", Document.parse("{ $gt: 22, $lt: 30 }"))).spliterator());
	}
	/** second element in the array dim_cm is greater than 25:*/
	public String queryArrayIndex()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(gt("dim_cm.1", 25)).spliterator());
	}
	
	/** second element in the array dim_cm is greater than 25:*/
	public String queryArrayLength()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(size("tags", 3)).spliterator());
	}
	
	
}
