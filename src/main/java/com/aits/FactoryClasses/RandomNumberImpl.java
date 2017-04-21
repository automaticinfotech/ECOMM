package com.aits.FactoryClasses;

import org.springframework.stereotype.Repository;

@Repository
public class RandomNumberImpl implements IRandomNumber {

	@Override
	public int genrateRandomNumber() {
		
		return (int)(Math.random()*9000)+1000;
	}

}
