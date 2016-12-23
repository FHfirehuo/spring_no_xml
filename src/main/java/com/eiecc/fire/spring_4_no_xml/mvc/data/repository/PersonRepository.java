package com.eiecc.fire.spring_4_no_xml.mvc.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

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

	// 查询方法的结果可以通过关键字first或top来限制，它们可以互换使用。 可选的数字值可以追加到top /
	// first，以指定要返回的最大结果大小。 如果省略该数字，则假定结果大小为1。
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
	 * 这样写法是错误的。 Method must not have Pageable *and* Sort parameter. Use sorting
	 * capabilities on Pageble instead! Offending method:
	 */
	// Page<Person> findByName(String name, Sort sort, Pageable pageable);

	/***
	 * 错误的，请看Pageable的实现类PageRequest
	 */
	// Page<Person> findAll(String name, Sort sort, Pageable pageable);

	Person findFirstByOrderByNameAsc();

	Person findTopByOrderByAgeDesc();

	Slice<Person> findTop3ByName(String name, Pageable pageable);

	// 可以通过使用Java 8 Stream <T>作为返回类型来递增地处理查询方法的结果。
	// 不是简单地将查询结果包装在流数据存储中，而是使用特定方法来执行流传输。
	// @Query("select u from User u")
	// Stream<Person> findAllByCustomQueryAndStream();

	// Stream<Person> readAllByFirstnameNotNull();

	// @Query("select u from User u")
	// Stream<Person> streamAllPaged(Pageable pageable);

	// 可以使用Spring的异步方法执行功能来异步地执行存储库查询。
	// 这意味着该方法将在调用时立即返回，并且实际的查询执行将发生在已经提交到Spring任务执行器的任务中。
	//@Async
	//Future<Person> findByName(String name); // Use java.util.concurrent.Futureas return type.

	// @Async
	// CompletableFuture<Person> findOneByFirstname(String firstname); //Use a
	// Java 8 java.util.concurrent.CompletableFuture as return type.

	@Async
	ListenableFuture<Person> findOneByName(String name); // Use a org.springframework.util.concurrent.ListenableFuture
																	// as return
																	// type.

	// @Query注释允许通过将nativeQuery标志设置为true来执行本机查询。
	@Query(value = "SELECT * FROM USERS WHERE EMAIL = ?1", nativeQuery = true)
	Person findByEmailAddress(String email);

	// 所谓本地查询，就是使用原生的sql语句（根据数据库的不同，在sql的语法或结构方面可能有所区别）进行查询数据库的操作。

	// 目前不支持对本地查询执行动态排序，因为我们必须操作实际的已声明的查询，
	// 我们无法对本地SQL执行此操作。 但是，您可以通过自己指定计数查询来使用本机查询进行分页：

	// 使用@Query的查询方法中声明本机计数查询以进行分页
	//@Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1", countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1", nativeQuery = true)
	//Page<Person> findByName(String name, Pageable pageable);
	
	
}
