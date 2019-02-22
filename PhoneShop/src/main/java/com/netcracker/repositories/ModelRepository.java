package com.netcracker.repositories;

import com.netcracker.entities.PhoneModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends CrudRepository<PhoneModel, Long> {
    List<PhoneModel> findByName(String name);
}
