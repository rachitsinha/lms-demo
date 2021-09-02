package rachitsinha.lmsdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import rachitsinha.lmsdemo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
