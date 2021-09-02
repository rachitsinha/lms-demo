package rachitsinha.lmsdemo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rachitsinha.lmsdemo.models.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	List<Inventory> findByIsbn(String isbn);
}
