package rachitsinha.lmsdemo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rachitsinha.lmsdemo.models.Inventory;
import rachitsinha.lmsdemo.models.UserBook;
import rachitsinha.lmsdemo.models.UserBookRequest;
import rachitsinha.lmsdemo.models.UserBookResponse;
import rachitsinha.lmsdemo.repos.InventoryRepository;
import rachitsinha.lmsdemo.repos.UserBookRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	private final InventoryRepository inventoryRepo;
	private final UserBookRepository userBookRepo;
	
	
	public InventoryController(InventoryRepository inventoryRepo, UserBookRepository userBookRepo) {
		this.inventoryRepo = inventoryRepo;
		this.userBookRepo = userBookRepo;
	}
	
	@PostMapping("/borrow")
	UserBookResponse borrowBook(@RequestBody UserBookRequest request) {
		List<Inventory> inventory = inventoryRepo.findByIsbn(request.getIsbn());
		if(inventory != null && inventory.size() > 0) {
			UserBook userBook = userBookRepo.save(new UserBook(
					inventory.get(0).getBookId(), 
					request.getUserId(), 
					LocalDate.now(), 
					null));
			inventoryRepo.deleteById(inventory.get(0).getId());
			return new UserBookResponse(userBook, "Borrow action successful");
		}
		return new UserBookResponse(null, "Borrow action failed");
	}
	
	@PostMapping("/return")
	UserBookResponse returnBook(@RequestBody UserBookRequest request) {
		int result = userBookRepo.returnBook(request.getUserId(), request.getBookId(), LocalDate.now());
		if(result > 0) {
			inventoryRepo.save(new Inventory(request.getIsbn(), request.getBookId()));
			return new UserBookResponse(null, "Return action successful");
		} else {
			return new UserBookResponse(null, "Return action failed");
		}
		
	}
	
	@GetMapping("/availablebookscount")
	long getNumberOfAvailableBooks() {
		return inventoryRepo.count();
	}
	
	@GetMapping("/availablebookscount/{isbn}")
	long getNumberOfAvailableBooksByIsbn(@PathVariable String isbn) {
		return inventoryRepo.findByIsbn(isbn).size();
	}
	
	@GetMapping("/borrowedbookscount")
	long getNumberOfBorrowedBooks() {
		return userBookRepo.findBorrowed().size();
	}
	
	@GetMapping("/borrowedbookscount/{userId}")
	long getNumberOfBorrowedBooks(@PathVariable Long userId) {
		return userBookRepo.findBorrowedByUser(userId).size();
	}
}
