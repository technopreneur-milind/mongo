package com.example.demo;

import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import org.bson.BsonType;
import org.springframework.stereotype.Component;
import static com.mongodb.client.model.Projections.*;

/**
 * collection.insertMany(asList(
        Document.parse("{'_id': 1, 'item': null}"),
        Document.parse("{'_id': 2}")
));
 * @author Milind
 *
 */
@Component
public class MongoGetNull extends MongoParent {
	public String selectNull1()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("item", null)).spliterator());
	}
	
	public String selectNull2()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(type("item", BsonType.NULL)).spliterator());
	}
	
	public String checkexist(boolean exist)
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(exists("item", exist)).spliterator());
	}
}
