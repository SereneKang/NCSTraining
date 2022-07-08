package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Laptop;
import com.ncs.empconsole.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;
	
	@Override
	public Laptop addLaptop(Laptop laptop) {
		
		Laptop savedLaptop=laptopRepository.save(laptop);
		
		return savedLaptop;
	}

	@Override
	public List<Laptop> getAllLaptop() {
		
		return laptopRepository.findAll();
	}

	@Override
	public Laptop getLaptopById(int lcode) {
		
		return laptopRepository.findById(lcode).get();
	}

}
