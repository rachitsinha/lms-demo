package rachitsinha.lmsdemo.repos;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rachitsinha.lmsdemo.models.UserBook;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {
	UserBook findByUserIdAndBookId(Long userId, Long bookId);
	@Query("select ub from UserBook ub where ub.returnDate = null")
	List<UserBook> findBorrowed();
	
	@Query("select ub from UserBook ub where ub.returnDate = null AND ub.userId = :userId")
	List<UserBook> findBorrowedByUser(@Param("userId") Long userId);
	
	@Modifying
	@Transactional
	@Query("Update UserBook u set u.returnDate = :returnDate where u.userId = :userId AND u.bookId = :bookId AND u.returnDate = null")
	int returnBook(@Param("userId") Long userId, @Param("bookId") Long bookId, @Param("returnDate") LocalDate returnDate);
}
