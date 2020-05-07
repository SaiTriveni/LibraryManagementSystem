package library_management_system_spring_angular.dao;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import library_management_system_spring_angular.dto.BookDto;
import library_management_system_spring_angular.dto.BookIssueDetailsDto;
import library_management_system_spring_angular.dto.InformationDto;

@Repository
public class AdminDAOImplementation implements AdminDAO {

	@PersistenceUnit
	EntityManagerFactory factory;
	
	EntityManager manager = null;
	EntityTransaction transaction = null;
	InformationDto admin = null;
	List<BookDto> list = null;

	@Override
	public boolean register(InformationDto admin) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
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
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean auth(String email, String password) {

		boolean flag = false;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select i from InformationDto i where i.email=:email and i.password=:password";
			TypedQuery<InformationDto> query = manager.createQuery(jpql, InformationDto.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			admin = query.getSingleResult();
			if (admin == null) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		manager.close();
		factory.close();
		return flag;

	}

	@Override
	public boolean addBook(BookDto book) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
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
		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public List<BookDto> searchBookTitle(String bookTitle) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDTO b where b.bookTitle=:title";
			TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
			query.setParameter("title", bookTitle);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}

		manager.close();
		factory.close();
		return list;
	}

	@Override
	public List<BookDto> searchBookAuthor(String bookAuthor) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDTO b where b.bookAuthor=:author";
			TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
			query.setParameter("author", bookAuthor);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}

		manager.close();
		factory.close();
		return list;

	}

	@Override
	public List<BookDto> searchBookType(String bookType) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDTO b where b.bookType=:type";
			TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
			query.setParameter("type", bookType);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}

		manager.close();
		factory.close();
		return list;

	}

	@Override
	public boolean updateBook(BookDto book) {


		EntityManager manager = factory.createEntityManager();
		BookDto bean = manager.find(BookDto.class, book.getBookId());
		manager.remove(bean);
		BookDto updatedBean = new BookDto();
		boolean isUpdated = false;
		if (bean != null) {
			try {
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				
				if (book.getBookTitle().length() == 0 || book.getBookTitle() == null) {
					updatedBean.setBookTitle(bean.getBookTitle());
				} else {
					updatedBean.setBookTitle(book.getBookTitle());
				}
				
				if (book.getBookAuthor().length() == 0 || book.getBookAuthor() == null) {
					updatedBean.setBookAuthor(book.getBookAuthor());
				} else {
					updatedBean.setBookAuthor(book.getBookAuthor());
				}
				
				if (book.getBookType().length() == 0 || book.getBookType() == null) {
					updatedBean.setBookType(book.getBookType());
				} else {
					updatedBean.setBookType(book.getBookType());
				}
				
				if (book.getBookPublisher().length() == 0 || book.getBookPublisher() == null) {
					updatedBean.setBookPublisher(book.getBookPublisher());
				} else {
					updatedBean.setBookPublisher(book.getBookPublisher());
				}
				
			
				updatedBean.setBookId(book.getBookId());
				manager.persist(updatedBean);
				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				manager.close();
			}

		}
		return isUpdated;

	}

	@Override
	public boolean removeBook(int bookId) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookDto record = manager.find(BookDto.class, bookId);
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
	public List<BookDto> getBookIds() {
		System.out.println("start Get bookIds");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select b.book_Id from BookDTO b";
		TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
		List<BookDto> recordList = query.getResultList();
		System.out.println("Get bookIds");
		return recordList;
	}

	@Override
	public List<BookDto> getBooksInfo() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select b from BookDTO b";
		TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
		List<BookDto> recordList = query.getResultList();
		System.out.println("Info");
		manager.close();
		factory.close();
		return recordList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean issueBook(int bookId, int userId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		@SuppressWarnings("unused")
		BookIssueDetailsDto b = new BookIssueDetailsDto();
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("select b from BookDTO b where b.bookId = :bbid");
			Query query1 = query.setParameter("bbid", bookId);
			List count = query1.getResultList();
			System.out.println(count);
			int S = count.size();
			if (S >= 1) {
				Query q1 = manager.createQuery(
						"select r from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
				q1.setParameter("id", userId);
				q1.setParameter("bid", bookId);
				List count1 = q1.getResultList();
				int s = count1.size();
				System.out.println(s);
				if (s >= 1) {
					Query q2 = manager.createQuery("select count(id) as idCount from BooksBorrowedDTO b where id=:id");
					q2.setParameter("id", userId);
					List count2 = q2.getResultList();
					int s1 = count2.size();
					if (s1 >= 1) {
						int noOfBooksBorrowed = count2.indexOf(0);
						if (noOfBooksBorrowed < 3) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							LocalDate date = LocalDate.now();
							Calendar c = Calendar.getInstance();
							c.setTime(new java.util.Date());
							c.add(Calendar.DATE, 15);
							String date1 = sdf.format(c.getTime());
							Query userEmail = manager
									.createQuery("select u.email from InformationDto u  where id = :id");
							userEmail.setParameter("id", userId);
							List userEmail1 = userEmail.getResultList();
							Query q3 = manager.createNativeQuery(
									"insert into BookIssue (id,bookId,email,issueDate,returnDate) values (? , ? , ? , ? , ?) ");
							q3.setParameter(1, userId);
							q3.setParameter(2, bookId);
							q3.setParameter(3, userEmail1.get(0));
							q3.setParameter(4, date);
							q3.setParameter(5, date1);
							int count3 = q3.executeUpdate();
							if (count3 != 0) {
								Query userEmail4 = manager
										.createQuery("select u.email from InformationDto u where id = :id");
								userEmail4.setParameter("id", userId);
								List userEmail44 = userEmail4.getResultList();
								Query q4 = manager.createNativeQuery(
										"insert into BooksBorrowedDTO (id,bookId,email) values (?,?,?)");
								q4.setParameter(1, userId);
								q4.setParameter(2, bookId);
								q4.setParameter(3, userEmail44.get(0));
								q4.executeUpdate();

								Query q5 = manager.createQuery(
										"delete from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
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
		@SuppressWarnings("unused")
		BookDto res = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery(
					"select b from BookIssueDetails b where b.id = :id and b.bookIssueDetailsPrimaryKey.bookId = :bid");
			q.setParameter("id", userId);
			q.setParameter("bid", bookId);
			@SuppressWarnings("rawtypes")
			List count = q.getResultList();
			int i = count.size();
			if (i >= 1) {
				Query q1 = manager.createQuery(
						"select r from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
				q1.setParameter("id", userId);
				q1.setParameter("bid", bookId);
				// q1.setParameter("type", "return");
				@SuppressWarnings("rawtypes")
				List count1 = q1.getResultList();
				int i1 = count1.size();
				if (i1 >= 1) {
					Query q3 = manager.createQuery(
							"delete from BookIssueDetails b where b.bookIssueDetailsPrimaryKey.bookId = :bid and id =:id");
					q3.setParameter("bid", bookId);
					q3.setParameter("id", userId);
					q3.executeUpdate();
					Query q4 = manager.createQuery(
							"delete from BooksBorrowedDTO b where b.booksBorrowedDtoPrimaryKey.bookId = :bid and id = :id");
					q4.setParameter("bid", bookId);
					q4.setParameter("id", userId);
					q4.executeUpdate();
					Query q5 = manager.createQuery(
							"delete from RequestDTO r where r.id = :id and r.requestDtoPrimaryKey.bookId = :bid");
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