package com.example.demo;

import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Projections.*;

/**
 * collection.insertMany(asList(
    Document.parse("{ item: 'journal', status: 'A', size: { h: 14, w: 21, uom: 'cm' }, instock: [ { warehouse: 'A', qty: 5 }]}"),
    Document.parse("{ item: 'notebook', status: 'A',  size: { h: 8.5, w: 11, uom: 'in' }, instock: [ { warehouse: 'C', qty: 5}]}"),
    Document.parse("{ item: 'paper', status: 'D', size: { h: 8.5, w: 11, uom: 'in' }, instock: [ { warehouse: 'A', qty: 60 }]}"),
    Document.parse("{ item: 'planner', status: 'D', size: { h: 22.85, w: 30, uom: 'cm' }, instock: [ { warehouse: 'A', qty: 40}]}"),
    Document.parse("{ item: 'postcard', status: 'A', size: { h: 10, w: 15.25, uom: 'cm' }, "
            + "instock: [ { warehouse: 'B', qty: 15 }, { warehouse: 'C', qty: 35 } ] }")
));
 * @author Milind
 *
 */
@Component
public class MongoSelectFields extends MongoParent {

	public String selectAll()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("status", "A")).spliterator());
	}
	
	public String selectSpecific()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("status", "A")).projection(include("item", "status")).spliterator());
	}
	
	public String suppressId()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("status", "A"))
		        .projection(fields(include("item", "status"), excludeId())).spliterator());
	}
	
	public String excludeFields()
	{
		return toJson(getCollection(COLLECTION_INVENTORY).find(eq("status", "A")).projection(exclude("item", "status")).spliterator());
	}
	

	
	
}
