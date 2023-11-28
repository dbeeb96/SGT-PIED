package com.sgtpied.sgt.admin.repositories;

import com.sgtpied.sgt.admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findByFirstnameAndLastname(String firstname, String lastname);

	public static void deleteById(int id) {
		UserRepository.deleteById(id);
	}

}
