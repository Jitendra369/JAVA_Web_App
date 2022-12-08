package com.tec.blog.entities;

// class for categories table in Database
public class Categories {
	private int cate_id;
	private String cate_name;
	private String cate_description;
	
	
	
	public Categories() {
		super();
	}


//	constructor with ID
	public Categories(int cate_id, String cate_name, String cate_description) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.cate_description = cate_description;
	}

//	constructor with no ID
	public Categories(String cate_name, String cate_description) {
		super();
		this.cate_name = cate_name;
		this.cate_description = cate_description;
	}



	public int getCate_id() {
		return cate_id;
	}



	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}



	public String getCate_name() {
		return cate_name;
	}



	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}



	public String getCate_description() {
		return cate_description;
	}



	public void setCate_description(String cate_description) {
		this.cate_description = cate_description;
	}

	@Override
	public String toString() {
		return "Categories [cate_id=" + cate_id + ", cate_name=" + cate_name + ", cate_description=" + cate_description
				+ "]";
	}
	
	
	

}
