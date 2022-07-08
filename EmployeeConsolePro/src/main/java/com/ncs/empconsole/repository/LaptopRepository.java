package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.empconsole.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}
