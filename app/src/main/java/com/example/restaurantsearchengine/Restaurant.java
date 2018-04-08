package com.example.restaurantsearchengine;

public class Restaurant{
	
	private String name;
	private String category;
	private String address;
	private String city;
	private String zip;
	private String state;
	private String weblink;

//setters
	
public void setName(String name){
	this.name = name;
}

public void setCategory(String category){
	this.category = category;
}

public void setAddress(String address){
	this.name = address;
}

public void setCity(String city){
	this.city = city;
}

public void setZip(String zip){
	this.zip = zip;
}

public void setState(String state){
	this.state = state;
}

public void setWebLink(String weblink){
	this.weblink = weblink;
}


//getters

public String getName(){
	return name;
}

public String getCategory(){
	return category;
}

public String getAddress(){
	return address;
}

public String getCity(){
	return city;
}

public String getZip(){
	return zip;
}

public String getState(){
	return state;
}

public String getWebLink(){
	return weblink;
}
}
