package com.example.demo;

import org.springframework.stereotype.Component;
import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import org.bson.BsonType;
import org.springframework.stereotype.Component;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Updates.*;

/**
 * db.inventory.insertMany( [
   { item: "canvas", qty: 100, size: { h: 28, w: 35.5, uom: "cm" }, status: "A" },
   { item: "journal", qty: 25, size: { h: 14, w: 21, uom: "cm" }, status: "A" },
   { item: "mat", qty: 85, size: { h: 27.9, w: 35.5, uom: "cm" }, status: "A" },
   { item: "mousepad", qty: 25, size: { h: 19, w: 22.85, uom: "cm" }, status: "P" },
   { item: "notebook", qty: 50, size: { h: 8.5, w: 11, uom: "in" }, status: "P" },
   { item: "paper", qty: 100, size: { h: 8.5, w: 11, uom: "in" }, status: "D" },
   { item: "planner", qty: 75, size: { h: 22.85, w: 30, uom: "cm" }, status: "D" },
   { item: "postcard", qty: 45, size: { h: 10, w: 15.25, uom: "cm" }, status: "A" },
   { item: "sketchbook", qty: 80, size: { h: 14, w: 21, uom: "cm" }, status: "A" },
   { item: "sketch pad", qty: 95, size: { h: 22.85, w: 30.5, uom: "cm" }, status: "A" }
] );
 * @author Milind
 *
 */

@Component
public class MongoUpdate extends MongoParent {
	
	public String updateOne()
	{
		return getCollection(COLLECTION_INVENTORY).updateOne(eq("item", "paper"),
		        combine(set("size.uom", "cm"), set("status", "P"), currentDate("lastModified"))).toString();
	}

}
