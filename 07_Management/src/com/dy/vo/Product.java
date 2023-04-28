package com.dy.vo;

public class Product {
	    private String id; //상품아이디
	    private String name; //상품명
	    private int price;	//상품가격
	    private String description;	//부가설명
	    private int stock;	//재고
	    
	    public Product() {}
	    
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public Product(String id, String name, int price, String description, int stock) {
			this.id = id;
			this.name = name;
			this.price = price;
			this.description = description;
			this.stock = stock;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
		}

	
	
	
	    
		
}
