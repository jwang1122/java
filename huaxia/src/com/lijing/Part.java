package com.lijing;


public class Part implements Comparable<Part>{
	private String make;
	private String model;
	private String year;
	private String partDes = "";

	public Part(String line) {
		String[] items = line.split(" ");
		int len = items.length;
		make = items[len-3];
		model = items[len-2];
		year = items[len-1];
		for(int i=0; i<len-3; i++) {
			partDes = partDes.concat(items[i]).concat(" ");
		}
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
		i = year.compareTo(other.getYear());
		if (i != 0) {
			return i;
		}
		i = partDes.compareTo(other.getDescription());
		if (i != 0) {
			return i;
		}
		return 0;
	}

	public String getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getDescription() {
		return partDes;
	}

	@Override
	public String toString() {
		return make + " " + model + " " + year + " " + partDes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((partDes == null) ? 0 : partDes.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		if (partDes == null) {
			if (other.partDes != null)
				return false;
		} else if (!partDes.equals(other.partDes))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}


}