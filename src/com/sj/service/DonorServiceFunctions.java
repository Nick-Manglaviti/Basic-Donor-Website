package com.sj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sj.dao.DonorDaoInterface;
import com.sj.model.Donor;

/**
 * @author sj
 *
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DonorServiceFunctions implements DonorServiceInterface {

	@Autowired
	private DonorDaoInterface donorDaoInterface;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDonor(Donor donor) {
		donorDaoInterface.addDonor(donor);
	}
	
	public List<Donor> listDonors() {
		return donorDaoInterface.listDonors();
	}

	public Donor getDonor(int empid) {
		return donorDaoInterface.getDonor(empid);
	}
	
	public void deleteDonor(Donor donor) {
		donorDaoInterface.deleteDonor(donor);
	}

}
