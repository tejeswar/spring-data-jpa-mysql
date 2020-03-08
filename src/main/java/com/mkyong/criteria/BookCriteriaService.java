package com.mkyong.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookCriteriaService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	private EntityManager em;
	public void insertDummyBookRecords() {
		
		
		Book book1 = new Book("Java", "Tapnesh", 10);
		Book book2 = new Book("Kafka", "Rakesh", 100);
		Book book3 = new Book("Sql", "Teju", 5);
		
		List<Book> listOfBooks = new ArrayList<>();
		listOfBooks.add(book1);listOfBooks.add(book2);
		listOfBooks.add(book3);
		
		bookRepository.saveAll(listOfBooks);
		System.out.println("All books got saved from service layer...");
		System.out.println("Entity Manager Factory is : "+emf);
	}
	
	public List<Book> getAllBooks() {
		Iterable<Book> iterable = bookRepository.findAll();
		System.out.println("Entity Manager Factory is : "+emf);
		List<Book> allBooks  = StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
				
				return allBooks;
	}
	
	public List<Book> getAllBooksByDtos() {
		Iterable<Book> iterable = bookRepository.findAll();
		System.out.println("Entity Manager Factory is : "+emf);
		List<Book> allBooks  = StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
				
				return allBooks;
	}
	public Book getBookById(long id) {
		System.out.println("Entity Manager Factory is : "+emf);
		return bookRepository.findById(id).get();
	}

//https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/criteria-select.html	
public List<Book> getAllBooksByCB() {
	
	CriteriaBuilder cb = emf.getCriteriaBuilder();
	CriteriaQuery q = cb.createQuery(Book.class);
	Root root = q.from(Book.class);
	q.select(root);

	List<Book> books = em.createQuery(q).getResultList();
	return books;
}

public List<BookValue> getPartialValues(){
	List<BookValue> books = em.createQuery("SELECT new com.mkyong.criteria.BookValue(b.authorName, b.price) FROM Book b").getResultList();
    return books;
}

public List<Book> getBookByIdByCB() {
	
	CriteriaBuilder criteriaBuilder = emf.getCriteriaBuilder();
	CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
	Root root = criteriaQuery.from(Book.class);
	criteriaQuery.select(root);
	criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));
	

	List books = em.createQuery(criteriaQuery).getResultList();
	return books;
}
/*
Query query = em.createQuery("SELECT b FROM Book b");
//https://thoughts-on-java.org/hibernate-tips-difference-join-left-join-fetch-join/
List<Author> authors = em.createQuery("SELECT a FROM Author a JOIN a.books b WHERE b.title LIKE '%Hibernate%'", Author.class).getResultList();
List<Object[]> authors = em.createQuery("SELECT a, b FROM Author a LEFT JOIN a.books b WHERE a.lastName = 'Janssen'").getResultList();

List<Author> authors = em.createQuery("SELECT a FROM Author a JOIN FETCH a.books b WHERE b.title LIKE '%Hibernate%'", Author.class).getResultList();

*/
//https://www.baeldung.com/spring-data-criteria-queries
//https://www.baeldung.com/jpa-criteria-api-in-expressions
/*
@Override
List<Book> findBooksByAuthorNameAndTitle(String authorName, String title) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
 
    Root<Book> book = cq.from(Book.class);
    List<Predicate> predicates = new ArrayList<>();
     
    if (authorName != null) {
        predicates.add(cb.equal(book.get("author"), authorName));
    }
    if (title != null) {
        predicates.add(cb.like(book.get("title"), "%" + title + "%"));
    }
    cq.where(predicates.toArray(new Predicate[0]));
 
    return em.createQuery(cq).getResultList();
}
*/

}
