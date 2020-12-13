package com.huaxia.java2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FilterSimulation {
    public static void main(String[] args) {
 
        Map<String, Integer> orgCriteriaMap = new HashMap<>();
        orgCriteriaMap.put("org1", 30);
        orgCriteriaMap.put("org2", 35);
        orgCriteriaMap.put("org3", 40);
 
        Stream<Employee> myEmpListStream = new ArrayList<Employee>() {
			private static final long serialVersionUID = 1L;

			{
                add(new Employee("org1", "1", "Tom", 25));
                add(new Employee("org1", "2", "Peter", 32));
                add(new Employee("org1", "3", "Steve", 35));
                add(new Employee("org2", "1", "Phill", 33));
                add(new Employee("org2", "2", "Dale", 36));
                add(new Employee("org2", "3", "Mike", 38));
                add(new Employee("org3", "1", "Pete", 38));
                add(new Employee("org3", "2", "Jim", 36));
                add(new Employee("org3", "3", "Todd", 42));
 
            }
        }.stream();
 
        Stream<Employee> filteredEmployeeList = myEmpListStream
                .filter(x -> x.age > (int) orgCriteriaMap.get(x.organizationId));
        filteredEmployeeList.forEach(x -> System.out.printf("Name:%s(%d) Org:%s\n",x.name,x.age,x.organizationId));
 
    }
}
