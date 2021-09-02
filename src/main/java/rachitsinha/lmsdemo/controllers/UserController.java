package rachitsinha.lmsdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rachitsinha.lmsdemo.models.User;
import rachitsinha.lmsdemo.repos.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserRepository userRepo;

	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@GetMapping("/all")
	List<User> all() {
		return userRepo.findAll();
	}
	
	@PostMapping("/add")
	User add(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PostMapping("/update/{id}")
	User update(@RequestBody User newUser, @PathVariable Long id) {
		return userRepo.findById(id)
				.map(user -> {
					user.setName(newUser.getName());
					user.setPhone(newUser.getPhone());
					user.setDateOfBirth(newUser.getDateOfBirth());
					return userRepo.save(user);
				}).orElseThrow(() -> {
					throw new RuntimeException("User not found with id: " + id);
				});
				
	}
	
	@PostMapping("/delete/{id}")
	void delete(@PathVariable Long id) {
		userRepo.deleteById(id);
	}
	
	
}
