package rachitsinha.lmsdemo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rachitsinha.lmsdemo.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByIsbn(String isbn);
	
	List<Book> findByTitleContainingIgnoreCase(String title);
}
