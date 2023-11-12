package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
