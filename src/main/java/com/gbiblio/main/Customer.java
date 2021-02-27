package com.gbiblio.main;

public class Customer {
	 
//    private Long id;
//    private String name;
//    
//	public Customer() {
//		super();
//	}
//	public Customer(Long id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//    // getters/setters, custom hashcode/equals
//	
//	@Override
//    public boolean equals(Object obj) {
//        return (this.id.equals(((Customer) obj).id)
//                && this.name.equals(((Customer) obj).name));
//    }
	
	private int id;
    private String name;
	 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//    public boolean equals(Object obj) {
//      return (this.id == ((Customer) obj).id
//              && this.name.equals(((Customer) obj).name));
//    }
//	
//	@Override
//	public int hashCode() {
//	    return id;
//	}
	
	
	
}