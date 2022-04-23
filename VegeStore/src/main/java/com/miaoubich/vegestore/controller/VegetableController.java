package com.miaoubich.vegestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miaoubich.vegestore.model.Vegetable;
import com.miaoubich.vegestore.service.VegetableService;

@RestController
@RequestMapping("/api/vegetable")
public class VegetableController {

	@Autowired
	private VegetableService vegeService;
	
	@PostMapping("/upsert")
	public ResponseEntity<Vegetable> addOrUpdate(@RequestBody Vegetable vegetable){
		Vegetable upsertVege = vegeService.upsertVege(vegetable);
		return new ResponseEntity<Vegetable>(upsertVege, HttpStatus.CREATED);
	}
}
