package com.eiecc.fire.spring_4_no_xml.mvc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.Person;
/***
 * 其实应该并入PersonRepository接口的，只是为了便于区分不同的功能
 * @author fire
 *
 *jpa提供的基于准则查询的方式
 */
public interface PersonRepository2 extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

	
}
