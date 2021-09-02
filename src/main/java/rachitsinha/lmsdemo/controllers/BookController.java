package rachitsinha.lmsdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rachitsinha.lmsdemo.models.Book;
import rachitsinha.lmsdemo.models.Inventory;
import rachitsinha.lmsdemo.repos.BookRepository;
import rachitsinha.lmsdemo.repos.InventoryRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	private final BookRepository bookRepo;
	private final InventoryRepository inventoryRepo;

	public BookController(BookRepository bookRepo, InventoryRepository inventoryRepo) {
		this.bookRepo = bookRepo;
		this.inventoryRepo = inventoryRepo;
	}

	@GetMapping("/all")
	List<Book> all() {
		return bookRepo.findAll();
	}

	@PostMapping("/add")
	Book add(@RequestBody Book book) {
		Book newBook = bookRepo.save(book);
		inventoryRepo.save(new Inventory(newBook.getIsbn(), newBook.getId()));
		return newBook;
	}

	@PostMapping("/update/{id}")
	Book update(@RequestBody Book newBook, @PathVariable Long id) {
		return bookRepo.findById(id).map(book -> {
			book.setTitle(newBook.getTitle());
			book.setIsbn(newBook.getIsbn());
			book.setCost(newBook.getCost());
			return bookRepo.save(book);
		}).orElseThrow(() -> {
			throw new RuntimeException("Book not found with id: " + id);
		});

	}

	@PostMapping("/delete/{id}")
	void delete(@PathVariable Long id) {
		bookRepo.deleteById(id);
	}
	
	@GetMapping("/findByTitle/{title}")
	List<Book> getBooksByTitle(@PathVariable String title) {
		return bookRepo.findByTitleContainingIgnoreCase(title);
	}
	
	@GetMapping("/findByIsbn/{isbn}")
	List<Book> getBooksByIsbn(@PathVariable String isbn) {
		return bookRepo.findByIsbn(isbn);
	}
}
