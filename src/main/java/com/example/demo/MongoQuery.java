package com.example.demo;

import org.springframework.stereotype.Component;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static com.mongodb.client.model.Filters.*; 

/**
 * collection.insertMany(asList(
        Document.parse("{ item: 'journal', qty: 25, size: { h: 14, w: 21, uom: 'cm' }, status: 'A' }"),
        Document.parse("{ item: 'notebook', qty: 50, size: { h: 8.5, w: 11, uom: 'in' }, status: 'A' }"),
        Document.parse("{ item: 'paper', qty: 100, size: { h: 8.5, w: 11, uom: 'in' }, status: 'D' }"),
        Document.parse("{ item: 'planner', qty: 75, size: { h: 22.85, w: 30, uom: 'cm' }, status: 'D' }"),
        Document.parse("{ item: 'postcard', qty: 45, size: { h: 10, w: 15.25, uom: 'cm' }, status: 'A' }")
));
 * @author Milind
 *
 */
@Component
public class MongoQuery extends MongoParent {

	public String findEq()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("status", "D")).spliterator());
	}
	
	public String findIn()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(in("status", "A", "D")).spliterator());
	}
	
	public String findAnd()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(and(eq("status", "A"), lt("qty", 30))).spliterator());
	}
	
	public String findOr()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(or(eq("status", "A"), lt("qty", 30))).spliterator());
	}
	
	public String findAndOr()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(and(eq("status", "A"),
	            or(lt("qty", 30), regex("item", "^p")))).spliterator());
	}
	
	
}
