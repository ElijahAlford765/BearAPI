package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BearsRepository extends JpaRepository<Bears, Integer> {

    List<Bears> getBearsByDescription(String Description);

    @Query(value = "select * from Bears b where b.age >= ?1", nativeQuery = true)
    List<Bears> getAgeBears(double age);

    @Query(value = "select * from Bears b where b.name like %?1% ", nativeQuery = true)
    List<Bears> getBearsByName(String name);
}