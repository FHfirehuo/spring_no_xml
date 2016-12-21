package com.eiecc.fire.spring_4_no_xml.mvc.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	/***
	 * 
	 * 通过名字相等查询，参数为name. 相当于jpsl: select p from Person p where p.name=?1
	 */
	List<Person> findByName(String name);

	/***
	 *
	 * 通过名字like查询，参数为name. 相当于jpql:select p from Person p where p.name like ?1
	 */
	List<Person> findByNameLike(String name);

	/***
	 *
	 * 通过名字和地址查询，参数为name和address. 相当于jpql:select p from Person p where p.name =
	 * ?1 and p.address = ?2
	 */
	List<Person> findByNameAndAddress(String name, String address);

	/***
	 *
	 * 获得符合查询条件的前10条数据
	 */
	List<Person> findFirst10ByName(String name);

	/***
	 *
	 * 获得符合查询条件的前30条数据
	 */
	List<Person> findFirst30ByName(String name);

	@Query("select p from Person p where p.address = ?1")
	List<Person> findByAddress(String address);

	@Query("select p from Person p where p.address = :address")
	List<Person> findByAddress2(@Param("address") String address);

	@Modifying // 表示一个方法应该被视为修改查询。
	@Transactional
	@Query("update Person p set p.name=?1")
	int setName(String name);

	/***
	 * 排序
	 * 
	 * @param name
	 * @param sort
	 * @return
	 */
	List<Person> findByName(String name, Sort sort);

	/***
	 * 分页
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Person> findByName(String name, Pageable pageable);

	/***
	 * 排序分页(未测试)
	 * @param name
	 * @param sort
	 * @param pageable
	 * @return
	 * 应该是错误的，请看Pageable的实现类PageRequest
	 */
	Page<Person> findByName(String name, Sort sort, Pageable pageable);
	
	/***
	 * (未测试)
	 * 应该是错误的，请看Pageable的实现类PageRequest
	 */
	Page<Person> findAll(String name, Sort sort, Pageable pageable);
}
