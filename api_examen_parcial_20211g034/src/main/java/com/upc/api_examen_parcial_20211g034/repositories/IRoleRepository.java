package com.upc.api_examen_parcial_20211g034.repositories;

import com.upc.api_examen_parcial_20211g034.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
