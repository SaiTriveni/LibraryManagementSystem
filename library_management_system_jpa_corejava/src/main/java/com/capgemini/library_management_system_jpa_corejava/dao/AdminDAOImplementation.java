package com.capgemini.library_management_system_jpa_corejava.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.BookIssueDetails;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public class AdminDAOImplementation implements AdminDAO {
	
	

	@Override
	public boolean register(InformationDto admin) {
		EntityManagerFactory factory=null;
			EntityManager manager=null;
			EntityTransaction transaction=null;
			try {
				factory=Persistence.createEntityManagerFactory("TestPersistence");
				manager = factory.createEntityManager();
				transaction = manager.getTransaction();
				transaction.begin();
				manager.persist(admin);
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
				
		
	

	@Override
	public boolean auth(String email, String password) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		InformationDto admin=null;
		boolean flag = false;
		
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager=factory.createEntityManager();
			String jpql="select i from InformationDto i where i.email=:email and i.password=:password";
			TypedQuery<InformationDto> query=manager.createQuery(jpql,InformationDto.class);
			query.setParameter("email",email);
			query.setParameter("password",password);
			admin=query.getSingleResult();
			if(admin == null)
			{
				flag = false;
			}
			else {
				flag = true;
			}
		}catch(Exception e) {
		e.printStackTrace();
		}
		
		manager.close();
		factory.close();
		return flag;
		
	}

	@Override
	public boolean addBook(BookDTO book) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(book);
			System.out.println("book inserted");
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

	@Override
	public List<BookDTO> searchBookTitle(String bookTitle) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		List<BookDTO> list = null;
		
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager=factory.createEntityManager();
			String jpql="select b from BookDTO b where b.bookTitle=:title";
			TypedQuery<BookDTO> query=manager.createQuery(jpql,BookDTO.class);
			query.setParameter("title",bookTitle);
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
	public boolean updateBook(int bookId, String bookAuthor) {
		
	
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("TestPersistence");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			BookDTO record=manager.find(BookDTO.class,bookId);
			record.setBookAuthor(bookAuthor);
			System.out.println("record updated");
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		
		}
	}

	@Override
	public boolean removeBook(int bookId) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookDTO record = manager.find(BookDTO.class,bookId);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookDTO> getBookIds() {
		System.out.println("start Get bookIds");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=factory.createEntityManager();
		String jpql="select b.book_Id from BookDTO b";
		TypedQuery<BookDTO> query=manager.createQuery(jpql,BookDTO.class);
		List<BookDTO> recordList=query.getResultList();
		System.out.println("Get bookIds");
		return recordList;
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
	public boolean issueBook(int bookId, int userId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		BookIssueDetails b = new BookIssueDetails();
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookDTO b where b.bookId = :bbid");
			Query	ss = q.setParameter("bbid", bookId);
			List count = ss.getResultList();
			System.out.println(count);
			int S = count.size();
			if(S>=1) {
				Query q1 = manager.createQuery("select r from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
				 q1.setParameter("id",userId);
			 q1.setParameter("bid", bookId);
				List count1 = q1.getResultList();
				int s = count1.size();
				System.out.println(s);
				if(s>=1) {
					Query q2 = manager.createQuery("select count(id) as idCount from BooksBorrowedDTO b where id=:id");
					q2.setParameter("id",userId);
					List count2 = q2.getResultList();
					int s1 = count2.size();
					if(s1>=1) {
						int noOfBooksBorrowed =  count2.indexOf(0);
						if(noOfBooksBorrowed<3) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							LocalDate date = LocalDate.now();
							Calendar c = Calendar.getInstance();
								c.setTime(new java.util.Date());
								c.add(Calendar.DATE, 15);
								String date1 =	sdf.format(c.getTime());
								Query userEmail = manager.createQuery("select u.email from InformationDto u  where id = :id");
								userEmail.setParameter("id", userId);
								List userEmail1 = userEmail.getResultList();
							Query q3 = manager.createNativeQuery("insert into BookIssue (id,bookId,email,issueDate,returnDate) values (? , ? , ? , ? , ?) ");
							q3.setParameter(1, userId);
							q3.setParameter(2 , bookId);
							q3.setParameter(3, userEmail1.get(0));
							q3.setParameter(4, date);
							q3.setParameter(5, date1);
							int count3 = q3.executeUpdate();
							if(count3 != 0) {
								Query userEmail4 = manager.createQuery("select u.email from InformationDto u where id = :id");
								userEmail4.setParameter("id", userId);
								List userEmail44 = userEmail4.getResultList();
								Query q4 = manager.createNativeQuery("insert into BooksBorrowedDTO (id,bookId,email) values (?,?,?)");
								q4.setParameter(1, userId);
								q4.setParameter(2, bookId);
								q4.setParameter(3, userEmail44.get(0));
								q4.executeUpdate();
							
							Query q5 = manager.createQuery("delete from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
							q5.setParameter("id", userId);
							q5.setParameter("bid", bookId);
							q5.executeUpdate();
							transaction.commit();
							return true;
							}
							
						}
						
						
					}
				}
				
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
	public boolean returnBook(int userId, int bookId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		BookDTO res = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookIssueDetails b where b.id = :id and b.bookIssueDetailsPrimaryKey.bookId = :bid");
			q.setParameter("id", userId);
			q.setParameter("bid", bookId);
			List count = q.getResultList();
			int i = count.size();
			if(i>=1) {
				Query q1 = manager.createQuery("select r from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
				q1.setParameter("id", userId);
				q1.setParameter("bid", bookId);
				//q1.setParameter("type", "return");
				List count1 = q1.getResultList();
				int i1 = count1.size();
				if(i1>=1) {
					Query q3 = manager.createQuery("delete from BookIssueDetails b where b.bookIssueDetailsPrimaryKey.bookId = :bid and id =:id");
					q3.setParameter("bid", bookId);
					q3.setParameter("id", userId);
					q3.executeUpdate();
					Query q4 = manager.createQuery("delete from BooksBorrowedDTO b where b.booksBorrowedDtoPrimaryKey.bookId = :bid and id = :id");
					q4.setParameter("bid", bookId);
					q4.setParameter("id", userId);
					q4.executeUpdate();
					Query q5 = manager.createQuery("delete from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
					q5.setParameter("id", userId);
					q5.setParameter("bid", bookId);
					q5.executeUpdate();
					transaction.commit();
					return true;
				}
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