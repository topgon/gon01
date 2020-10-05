package org.gon.domain;

import lombok.Data;

@Data
public class Criteria {

	private int pageNum;
	private int amount;

	public Criteria() {
		// TODO Auto-generated constructor stub
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
}
