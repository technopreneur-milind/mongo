package com.example.demo;


import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;


public abstract class MongoParent {
	@Autowired
	protected MongoClient mongoClient;

	protected MongoCollection<Document> getCollection(String collectionName) {
		return mongoClient.getDatabase(DATABASE_DEMO).getCollection(collectionName);
	}
	
	protected static final String RETURN_SUCCESS = " Task successfully Completed";
	protected static final String DATABASE_DEMO = "demom";
	protected static final String COLLECTION_INVENTORY = "inventory";

	protected static String toJson(Spliterator<Document> spliterator) {
		return StreamSupport.stream(spliterator, false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
	}
}
