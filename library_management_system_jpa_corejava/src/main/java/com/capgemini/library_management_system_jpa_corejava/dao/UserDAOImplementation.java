package com.capgemini.library_management_system_jpa_corejava.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.BooksBorrowedDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;
import com.capgemini.library_management_system_jpa_corejava.exception.ValidationException;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jpa_corejava.service.AdminService;

public class UserDAOImplementation implements UserDAO {

	@Override
	public boolean register(InformationDto user) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			System.out.println("User inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}

	}
//
//	@Override
//	public boolean auth(String email, String password) {
//		EntityManagerFactory factory=null;
//		EntityManager manager=null;
//		EntityTransaction transaction=null;
//		InformationDto admin=null;
//		boolean flag = false;
//		
//		try {
//			factory=Persistence.createEntityManagerFactory("TestPersistence");
//			manager=factory.createEntityManager();
//			String jpql="select i from InformationDto i where i.email=:email and i.password=:password";
//			TypedQuery<InformationDto> query=manager.createQuery(jpql,InformationDto.class);
//			query.setParameter("email",email);
//			query.setParameter("password",password);
//			admin=query.getSingleResult();
//			if(admin == null)
//			{
//				flag = false;
//			}
//			else {
//				flag = true;
//			}
//		}catch(Exception e) {
//		e.printStackTrace();
//		}
//		
//		manager.close();
//		factory.close();
//		return flag;
//	
//	}

	@Override
	public List<BookDTO> searchBookTitle(String bookName) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		List<BookDTO> list = null;
		
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager=factory.createEntityManager();
			String jpql="select b from BookDTO b where b.bookTitle=:title";
			TypedQuery<BookDTO> query=manager.createQuery(jpql,BookDTO.class);
			query.setParameter("title",bookName);
		    list=query.getResultList();
		}catch(Exception e) {
		e.printStackTrace();
	
		}
		
		manager.close();
		factory.close();
		return list;
	
	}

	@Override
	public List<BookDTO> searchBookAuthor(String bookAuthor) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		List<BookDTO> list = null;
		
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager=factory.createEntityManager();
			String jpql="select b from BookDTO b where b.bookAuthor=:author";
			TypedQuery<BookDTO> query=manager.createQuery(jpql,BookDTO.class);
			query.setParameter("author",bookAuthor);
		    list=query.getResultList();
		}catch(Exception e) {
		e.printStackTrace();
	
		}
		
		manager.close();
		factory.close();
		return list;


	}

	@Override
	public List<BookDTO> searchBookType(String bookType) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		List<BookDTO> list = null;
		
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager=factory.createEntityManager();
			String jpql="select b from BookDTO b where b.bookType=:type";
			TypedQuery<BookDTO> query=manager.createQuery(jpql,BookDTO.class);
			query.setParameter("type",bookType);
		    list=query.getResultList();
		}catch(Exception e) {
		e.printStackTrace();
	
		}
		
		manager.close();
		factory.close();
		return list;


	}

	@Override
	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> getBooksInfo() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=factory.createEntityManager();
		String jpql="select b from BookDTO b";
		TypedQuery<BookDTO> query=manager.createQuery(jpql,BookDTO.class);
		List<BookDTO> recordList=query.getResultList();
		System.out.println("Info");
		manager.close();
		factory.close();
		return recordList;
	}

	@Override
	public boolean requestBook(int bookId, int userId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookDTO b where b.bookId = :bbid");
			Query	s = q.setParameter("bbid", bookId);
			List count = s.getResultList();
			int c = count.size();
			if(c != 0) {

				Query q1 =	manager.createQuery("select u.name from InformationDto u where id=:id");
				q1.setParameter("id", userId);
				List qq =  q1.getResultList();
				Query q2 = manager.createQuery("select b.bookTitle from BookDTO b where bookId=:bid");
				q2.setParameter("bid", bookId);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from InformationDto e where id=:id");
				q3.setParameter("id", userId);
				List qq3 = q3.getResultList();
				Query req = manager.createNativeQuery("insert into RequestDTO (bookId,email,bookTitle,id,name) values (?,?,?,?,?)");
				req.setParameter(1, bookId);
				req.setParameter(2,qq3.get(0));
				req.setParameter(3, qq1.get(0));
				req.setParameter(4, userId);
				req.setParameter(5, qq.get(0));
				
				
				req.executeUpdate();
				transaction.commit();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		
		return false;	



	}

	@Override
	public boolean returnBook(int bookId, int userId) {
		EntityManagerFactory factory = null;
		
		
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BooksBorrowedDTO b where b. booksBorrowedDtoPrimaryKey.bookId = :bid");
			q.setParameter("bid", bookId);	
			List count = q.getResultList();
			int s = count.size();
			if(s >= 0) {
				Query q1 =	manager.createQuery("select u.name from InformationDto u where id=:id");
				q1.setParameter("id", userId);
				List qq =  q1.getResultList();
				Query q2 = manager.createQuery("select b.bookTitle from BookDTO b where b.bookId=:bid");
				q2.setParameter("bid", bookId);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from InformationDto e where id=:id");
				q3.setParameter("id", userId);
				List qq3 = q3.getResultList();
				Query req = manager.createNativeQuery("insert into RequestDTO (bookId,email,bookTitle,id,name) values (?,?,?,?,?)");
				req.setParameter(1, bookId);
				req.setParameter(2,qq3.get(0));
				req.setParameter(3, qq1.get(0));
				req.setParameter(4, userId);
				req.setParameter(5, qq.get(0));
				int count1 = req.executeUpdate();
				transaction.commit();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

	
}