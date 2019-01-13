package com.example.demo;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.util.Collections;

import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class MongoInsert extends MongoParent {

	public String insert() {
		Document canvas = new Document("item", "canvas").append("qty", 99).append("tags",
				Collections.singletonList("cotton"));

		Document size = new Document("h", 21).append("w", 15.1).append("uom", "cm");
		canvas.put("size", size);

		getCollection(COLLECTION_INVENTORY).insertOne(canvas);
		return RETURN_SUCCESS;
	}

	public String insertMany() {
		Document journal = new Document("item", "journal").append("qty", 25).append("tags", asList("blank", "red"));

		Document journalSize = new Document("h", 14).append("w", 21).append("uom", "cm");
		journal.put("size", journalSize);

		Document mat = new Document("item", "mat").append("qty", 85).append("tags", singletonList("gray"));

		Document matSize = new Document("h", 27.9).append("w", 35.5).append("uom", "cm");
		mat.put("size", matSize);

		Document mousePad = new Document("item", "mousePad").append("qty", 25).append("tags", asList("gel", "blue"));

		Document mousePadSize = new Document("h", 19).append("w", 22.85).append("uom", "cm");
		mousePad.put("size", mousePadSize);

		getCollection(COLLECTION_INVENTORY).insertMany(asList(journal, mat, mousePad));
		return RETURN_SUCCESS;
	}

	public String findInsert() {
		return toJson(getCollection(COLLECTION_INVENTORY).find(new Document()).spliterator());
	}
}
