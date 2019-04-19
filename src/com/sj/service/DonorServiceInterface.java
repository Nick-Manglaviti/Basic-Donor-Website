package com.sj.service;

import java.util.List;

import com.sj.model.Donor;

/**
 * @author sj
 *
 */
public interface DonorServiceInterface {
	
	public void addDonor(Donor donor);

	public List<Donor> listDonors();
	
	public Donor getDonor(int empid);
	
	public void deleteDonor(Donor donor);
}
