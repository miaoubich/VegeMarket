package com.miaoubich.vegestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miaoubich.vegestore.custom.exception.EmptyFieldsException;
import com.miaoubich.vegestore.model.Vegetable;
import com.miaoubich.vegestore.repository.VegetableRepository;

@Service
public class VegetableService {

	@Autowired
	private VegetableRepository vegeRepository;

	public Vegetable upsertVege(Vegetable vegetable) {

		if (vegetable.getName().isEmpty() || vegetable.getFridge().isEmpty())
			throw new EmptyFieldsException(HttpStatus.BAD_REQUEST, "Fields are Mandatory!");

		Vegetable existVege = vegeRepository.findById(vegetable.getId()).orElse(null);
		if(existVege != null) {
			existVege.setName(vegetable.getName());
			existVege.setQuantity(vegetable.getQuantity());
			existVege.setPrice(vegetable.getPrice());
			existVege.setFridge(vegetable.getFridge());
			
			return vegeRepository.save(existVege);
		}
		System.out.println("Vegetable: " + vegetable);
		return vegeRepository.save(vegetable);
	}

}
