package com.sj.dao;

import java.util.List;

import com.sj.model.Donor;

/**
 * @author sj
 *
 */
public interface DonorDaoInterface {
	
	public void addDonor(Donor donor);

	public List<Donor> listDonors();
	
	public Donor getDonor(int empid);
	
	public void deleteDonor(Donor donor);
}
