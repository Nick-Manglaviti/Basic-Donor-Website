package com.sj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.model.Donor;

/**
 * @author sj
 *
 */
@Repository("employeeDao")
public class DonorFunctions implements DonorDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addDonor(Donor donor) {
		sessionFactory.getCurrentSession().saveOrUpdate(donor);
	}

	@SuppressWarnings("unchecked")
	public List<Donor> listDonors() {
		return (List<Donor>) sessionFactory.getCurrentSession().createCriteria(Donor.class).list();
	}

	public Donor getDonor(int empid) {
		return (Donor) sessionFactory.getCurrentSession().get(Donor.class, empid);
	}

	public void deleteDonor(Donor donor) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Donor WHERE empid = "+donor.getD_Id()).executeUpdate();
	}

}
