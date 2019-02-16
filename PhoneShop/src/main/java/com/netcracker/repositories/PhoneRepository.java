package com.netcracker.repositories;

import com.netcracker.entities.Phone;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
