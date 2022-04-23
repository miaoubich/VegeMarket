package com.miaoubich.vegestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miaoubich.vegestore.model.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

}
