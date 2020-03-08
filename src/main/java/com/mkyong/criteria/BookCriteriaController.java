package com.mkyong.criteria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCriteriaController {

	@Autowired
	private BookCriteriaService bookCriteriaService;
	
	//localhost:8080/insertBookRecords
	@GetMapping("/insertBookRecords")
	public ResponseEntity<?> insertBookRecords(){
		
		bookCriteriaService.insertDummyBookRecords();
		return new ResponseEntity<>("All books got saved successfully...",HttpStatus.OK);
	}
	//localhost:8080/getAllBooks
	@GetMapping("/getAllBooks")
	public ResponseEntity<?> getAllBooks(){
		List<Book> allBooks = bookCriteriaService.getAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}
	//
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") long id){
		Book book = bookCriteriaService.getBookById(id);
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	//localhost:8080/getAllBooksByCriteriaBuilder
	@GetMapping("/getAllBooksByCriteriaBuilder")
	public ResponseEntity<?> getAllBooksByCriteriaBuilder(){
		List<Book> allBooksByCB = bookCriteriaService.getAllBooksByCB();
		return new ResponseEntity<>(allBooksByCB,HttpStatus.OK);
		
	}
	@GetMapping("/getBookByIdByCB")
	public ResponseEntity<?> getBookByIdByCB(){
		List<Book> allBooksByIdCB = bookCriteriaService.getBookByIdByCB();
		return new ResponseEntity<>(allBooksByIdCB,HttpStatus.OK);
	}
	@GetMapping("/getBooksByDTOs")
	public ResponseEntity<?> getBooksByDTOs(){
		List<BookValue> allBooksByIdCB = bookCriteriaService.getPartialValues();
		return new ResponseEntity<>(allBooksByIdCB,HttpStatus.OK);
	}
	
	
}
