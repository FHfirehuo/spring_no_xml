package com.eiecc.fire.spring_4_no_xml.mvc.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.Person;

public class CustomerSpecs {

	public static Specification<Person> personFromHefei(){
		return new Specification<Person>(){

			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				return cb.equal(root.get("address"), "合肥");
			}
			
		};
		
	}
}
