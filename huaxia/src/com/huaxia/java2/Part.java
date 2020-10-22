package com.huaxia.java2;

public class Part implements Comparable<Part>{
	private String make;
	private String model;
	private int year;
	private String uuid;
	private int count = 0;

	public Part(String model, String make, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	@Override
	public int compareTo(Part other) {
		int i = make.compareTo(other.getMake());
		if (i != 0) {
			return i;
		}
		i = model.compareTo(other.getModel());
		if (i != 0) {
			return i;
		}
		int year2 = other.getYear();
		if (year == year2)
			return 0;
		if (year < year2)
			return -1;
		return 1;
	}

	public void addCount() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Part [make=" + make + ", year=" + year + ", model=" + model + "] - " + count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
