package com.eiecc.fire.spring_4_no_xml.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eiecc.fire.spring_4_no_xml.mvc.data.repository.PersonRepository;
import com.eiecc.fire.spring_4_no_xml.mvc.data.repository.PersonRepository2;
import com.eiecc.fire.spring_4_no_xml.mvc.domain.Person;
import static com.eiecc.fire.spring_4_no_xml.mvc.specs.CustomerSpecs.*;

@Service
public class PersonService {

	private PersonRepository2 personRepository2;

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository2 personRepository2, PersonRepository personRepository) {
		this.personRepository2 = personRepository2;
		this.personRepository = personRepository;
	}

	public void testCustomerSpecs() {
		List<Person> people = personRepository2.findAll(personFromHefei());
	}

	public void pageSort() {
		List<Person> people = personRepository.findByName("xx", new Sort(Direction.ASC, "age"));

		Page<Person> people2 = personRepository.findByName("xx", new PageRequest(0, 10));

		Page<Person> people3 = personRepository.findByName("xx",
				new PageRequest(0, 10, new Sort(Direction.ASC, "age")));

		Page<Person> people4 = personRepository.findAll(new PageRequest(0, 10, Direction.ASC, "age"));

		/***
		 * createdate倒序，id正序
		 */
		Sort sort = new Sort(Sort.Direction.DESC, "createdate").and(new Sort(Sort.Direction.ASC, "id"));
		Pageable pageable = new PageRequest(1, 10, sort);
		/***
		 * 一个倒序一个正序
		 */
		Page<Person> people5 = personRepository.findAll(pageable);
	}
	
	public void java8Stream() {
		//流可能会封装基础数据存储特定资源，因此必须在使用后关闭。 您可以使用close（）方法或使用Java 7 try-with-resources块手动关闭流。
		//try (Stream<User> stream = repository.findAllByCustomQueryAndStream()) {
		//	  stream.forEach(…);
		//	}
		
		//不是所有的Spring Data模块都支持Stream <T>作为返回类型。
	}
}
