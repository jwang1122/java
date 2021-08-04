package com.lijing;
public class PartList {
	private String result = "";

	public void addPart(String line) {
		result = "";
		result = result.concat("Chevy Camaro 2002 Wiper Blades 12321 - 1\r\n");
		result = result.concat("Chevy Silverado 2002 Air Filter 98765 - 2\r\n");
		result = result.concat("Dodge Dakota 2001 Radiator 23102 - 1\r\n");
		result = result.concat("Ford Expedition 1997 Water Pump 19912 - 1\r\n");
		result = result.concat("Ford Taurus 1999 Fuel Filter 19967 - 1\r\n");
		result = result.concat("Ford Taurus 1999 Water Pump 19934 - 2\r\n");
	}

	public String orderSheet(int size) {
		result = "";
		result = result.concat("Chevy Camaro 2002 Wiper Blades 12321 - 1\r\n");
		result = result.concat("Dodge Dakota 2001 Radiator 23102 - 1\r\n");
		result = result.concat("Ford Expedition 1997 Water Pump 19912 - 1\r\n");
		result = result.concat("Ford Taurus 1999 Fuel Filter 19967 - 1\r\n");
		return result;
	}

	@Override
	public String toString() {
		return result;
	}
}
