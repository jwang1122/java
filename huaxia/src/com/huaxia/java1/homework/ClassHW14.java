package com.huaxia.java1.homework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClassHW14 {
	static ArrayList<Customer> customers = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		Customer john = new Customer("John");
		john.setMember(true);
		john.setMemberType("Premium");
		customers.add(john);
		Customer bowen = new Customer("Bowen");
		bowen.setMember(true);
		bowen.setMemberType("Gold");
		customers.add(bowen);
		
		Visit visit = new Visit("John", getDate("2021-01-20"));
		visit.setProductExpense(29.54);
		visit.setServiceExpense(12.99);
		
		visit = new Visit("John", getDate("2021-01-21"));
		visit.setProductExpense(100);
		visit.setServiceExpense(10);
		
		double johnTotal = john.totalExpenses();
		System.out.printf("The total expense is %.2f\n",johnTotal);
		System.out.println(29.54+12.99+100+10);
	}
	
	static Date getDate(String date) throws Exception{
		return (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
	}

}

class Customer{
	private String name;
	private boolean member = false;
	private String memberType;
	private ArrayList<Visit> visits = new ArrayList<>();
	
	public Customer(String name) {
		this.name = name;
	}

	public void addVisit(Visit visit) {
		visits.add(visit);
	}
	
	public double totalExpenses() {
		double total = 0;
		for(Visit v: visits) {
			total += v.getTotalExpense();
		}
		return total;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return name;
	}
	
}

class Visit{
	private Customer customer;
	private Date date;
	private double serviceExpense;
	private double productExpense;
	
	public Visit(String name, Date date) {
		customer = new Customer(name);
		boolean findExisting = false;
		for(Customer c : ClassHW14.customers) {
			if (c.getName().equals(name)) {
				customer = c;
				findExisting = true;
			}
		}
		this.date = date; 
		customer.addVisit(this);
		if (!findExisting) {
			ClassHW14.customers.add(customer);
		}
	}

	public String getName() {
		return customer.getName();
	}
	
	public double getTotalExpense() {
		return serviceExpense + productExpense;
	}
	public double getServiceExpense() {
		return serviceExpense;
	}

	public void setServiceExpense(double serviceExpense) {
		double discount = 0;
		if(customer.isMember()) {
			DiscountRate rate = new DiscountRate();
			discount = rate.getServiceDiscountRate(customer.getMemberType());
		}
		this.serviceExpense = serviceExpense * (1 - discount);
	}

	public double getProductExpense() {
		return productExpense;
	}

	public void setProductExpense(double productExpense) {
		double discount = 0;
		if(customer.isMember()) {
			DiscountRate rate = new DiscountRate();
			discount = rate.getProductDiscountRate(customer.getMemberType());
		}
		this.productExpense = productExpense * (1.0 - discount);
	}
	
	public String toString() {
		return customer.getName() + ": " + date;
	}
}

class DiscountRate{
	private double serviceDiscountPremium = 0.2;
	private double serviceDiscountGold = 0.15;
	private double serviceDiscountSilver = 0.1;
	private double productDiscountPremium = 0.1;
	private double productDiscountGold = 0.1;
	private double productDiscountSilver = 0.1;
	
	public double getServiceDiscountRate(String type) {
		switch(type) {
		case "Premium":
			return productDiscountPremium;
		case "Gold":
			return serviceDiscountGold;
		case "Silver":
			return serviceDiscountSilver;
		default:
			return 0;
		}
	}
	
	public double getProductDiscountRate(String type) {
		switch(type) {
		case "Premium":
			return serviceDiscountPremium;
		case "Gold":
			return productDiscountGold;
		case "Silver":
			return productDiscountSilver;
		default:
			return 0;
		}		
	}
}