package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MongoApplication {

	@Autowired
	private MongoInsert mongoInsert;
	
	@Autowired
	private MongoQuery mongoQuery;
	
	@Autowired
	private MongoQueryEmbNested mongoQueryEmbNested;
	
	@Autowired
	private MongoQueryArray mongoQueryArray;
	
	@Autowired
	private MongoSelectFields mongoSelectFields;
	
	@Autowired
	private MongoGetNull mongoGetNull;

	@RequestMapping("/insert")
	public String insert() {
		return mongoInsert.insert();
	}

	@RequestMapping("/findInsert")
	public String findInsert() {
		return mongoInsert.findInsert();
	}
	
	@RequestMapping("/insertMany")
	public String insertMany() {
		return mongoInsert.insertMany();
	}
	
	@RequestMapping("/findEq")
	public String findEq()
	{
		return mongoQuery.findEq();
	}
	@RequestMapping("/findIn")
	public String findIn()
	{
		return mongoQuery.findIn();
	}
	@RequestMapping("/findAnd")
	public String findAnd()
	{
		return mongoQuery.findAnd();
	}
	@RequestMapping("/findOr")
	public String findOr()
	{
		return mongoQuery.findOr();
	}
	
	@RequestMapping("/findAndOr")
	public String findAndOr()
	{
		return mongoQuery.findAndOr();
	}
	
	@RequestMapping("/findEmbNestMatch")
	public String findEmbNestMatch()
	{
		return mongoQueryEmbNested.findMatch();
	}
	
	@RequestMapping("/findNested")
	public String findNestedField()
	{
		return mongoQueryEmbNested.findNestedField();
	}
	
	@RequestMapping("/findNestedWithAnd")
	public String findNestedFieldWithAnd()
	{
		return mongoQueryEmbNested.findNestedFieldWithAnd();
	}
	
	@RequestMapping("/queryArray/match")
	public String queryArray_match()
	{
		return mongoQueryArray.match();
	}
	
	@RequestMapping("/queryArray/matchWithoutOrder")
	public String  queryArray_matchWithoutOrder()
	{
		return mongoQueryArray.matchWithoutOrder();
	}
	
	@RequestMapping("/queryArray/query")
	public String  queryArray_query()
	{
		return mongoQueryArray.query();
	}
	
	@RequestMapping("/queryArray/queryArrayIndex")
	public String  queryArray_queryArrayIndex()
	{
		return mongoQueryArray.queryArrayIndex();
	}
	
	@RequestMapping("/queryArray/queryArrayLength")
	public String  queryArray_queryArrayLength()
	{
		return mongoQueryArray.queryArrayLength();
	}
	
	@RequestMapping("/selectFields/selectAll")
	public String  selectFields_selectAll()
	{
		return mongoSelectFields.selectAll();
	}
	@RequestMapping("/selectFields/selectSpecific")
	public String  selectFields_selectSpecific()
	{
		return mongoSelectFields.selectSpecific();
	}
	@RequestMapping("/selectFields/suppressId")
	public String  selectFields_suppressId()
	{
		return mongoSelectFields.suppressId();
	}
	@RequestMapping("/selectFields/excludeFields")
	public String  selectFields_excludeFields()
	{
		return mongoSelectFields.excludeFields();
	}
	
	@RequestMapping("/getnull/selectNull1")
	public String  getnull_selectNull1()
	{
		return mongoGetNull.selectNull1();
	}
	@RequestMapping("/getnull/selectNull2")
	public String  getnull_selectNull2()
	{
		return mongoGetNull.selectNull2();
	}
	@RequestMapping("/getnull/checkexist")
	public String  getnull_checkexist(@RequestParam(value="exist",required=false ) String exist)
	{
		return mongoGetNull.checkexist(Boolean.valueOf(exist));
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

}
