package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Laptop;

@Service
public interface LaptopService {

	public Laptop addLaptop(Laptop laptop);
	public List<Laptop> getAllLaptop();
	public Laptop getLaptopById(int lcode);
}
