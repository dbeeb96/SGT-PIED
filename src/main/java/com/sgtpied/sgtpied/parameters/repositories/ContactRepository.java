package com.sgtpied.sgtpied.parameters.repositories;

import com.sgtpied.sgtpied.parameters.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
