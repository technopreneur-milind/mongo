package com.example.demo;

import static java.util.Arrays.*;
import static java.util.Collections.*;

import org.bson.Document;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Filters.*; 

/*
 * collection.insertMany(asList(
        Document.parse("{ item: 'journal', qty: 25, size: { h: 14, w: 21, uom: 'cm' }, status: 'A' }"),
        Document.parse("{ item: 'notebook', qty: 50, size: { h: 8.5, w: 11, uom: 'in' }, status: 'A' }"),
        Document.parse("{ item: 'paper', qty: 100, size: { h: 8.5, w: 11, uom: 'in' }, status: 'D' }"),
        Document.parse("{ item: 'planner', qty: 75, size: { h: 22.85, w: 30, uom: 'cm' }, status: 'D' }"),
        Document.parse("{ item: 'postcard', qty: 45, size: { h: 10, w: 15.25, uom: 'cm' }, status: 'A' }")
));
 */

@Component
public class MongoQueryEmbNested extends MongoParent {

	public String findMatch()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("size", Document.parse("{ h: 14, w: 21, uom: 'cm' }"))).spliterator());
	}
	
	public String findNestedField()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("size.uom", "in")).spliterator());
	}
	
	public String findNestedFieldWithAnd()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(and(
		        lt("size.h", 15),
		        eq("size.uom", "in"),
		        eq("status", "D"))).spliterator());
	}
	
}
