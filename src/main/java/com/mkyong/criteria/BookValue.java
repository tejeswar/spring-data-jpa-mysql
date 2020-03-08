package com.mkyong.criteria;

public class BookValue {

	private long id;
	 private String name;
	    private String authorName;
	    private float price;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public BookValue(String name, String authorName, float price) {
			super();
			this.name = name;
			this.authorName = authorName;
			this.price = price;
		}
		public BookValue(String authorName, float price) {
			super();
			this.authorName = authorName;
			this.price = price;
		}
	    
	    
	    
	
}
