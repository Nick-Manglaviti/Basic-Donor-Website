


package com.sj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sj.bean.DonorBean;
import com.sj.model.Donor;
import com.sj.service.DonorServiceInterface;

/**
 * @author sj
 *
 */
@Controller
public class DonorController {
	
	@Autowired
	private DonorServiceInterface donorServiceInterface;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveDonor(@ModelAttribute("command") DonorBean donorBean, 
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("hi"+donorBean);
		Date date = new Date();
		donorBean.setDdate(date);
		if(donorBean.validateFields().equals("Success")) {
			model.put("errMessage", "");
			Donor donor = prepareModel(donorBean);
			donorServiceInterface.addDonor(donor);
			return new ModelAndView("redirect:/add.html");
		} else {
			model.put("donors",  prepareListofBean(donorServiceInterface.listDonors()));
			model.put("errMessage", donorBean.validateFields());
			return new ModelAndView("addDonor", model);
		}
	}

	@RequestMapping(value="/donors", method = RequestMethod.GET)
	public ModelAndView listDonors() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("donors",  prepareListofBean(donorServiceInterface.listDonors()));
		return new ModelAndView("donorsList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addDonor(@ModelAttribute("command")  DonorBean donorBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("donors",  prepareListofBean(donorServiceInterface.listDonors()));
		return new ModelAndView("addDonor", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editDonor(@ModelAttribute("command")  DonorBean donorBean,
			BindingResult result) {
		donorServiceInterface.deleteDonor(prepareModel(donorBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("donor", null);
		model.put("donors",  prepareListofBean(donorServiceInterface.listDonors()));
		return new ModelAndView("addDonor", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteDonor(@ModelAttribute("command")  DonorBean donorBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareDonorBean(donorServiceInterface.getDonor(donorBean.getId())));
		model.put("employees",  prepareListofBean(donorServiceInterface.listDonors()));
		return new ModelAndView("addDonor", model);
	}
	
	
	
	@RequestMapping(value = "/lookupDonor", method = RequestMethod.GET)
	public ModelAndView lookup(@ModelAttribute("command")  DonorBean donorBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("donor", null);
		model.put("donors",  prepareListofBean(donorServiceInterface.listDonors()));
		return new ModelAndView("donor", model);
	}
	
	@RequestMapping(value = "/lookup", method = RequestMethod.GET)
	public ModelAndView lookupDonor(@ModelAttribute("command") DonorBean bean,
			BindingResult result) 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("donor", donorServiceInterface.getDonor(bean.getId()));
		return new ModelAndView("donor", model);
	}
	
	
	
	private Donor prepareModel(DonorBean donorBean){
		Donor donor = new Donor();
		donor.setD_Address(donorBean.getAddress());
		donor.setD_Amount(donorBean.getAmount());
		donor.setD_Name(donorBean.getName());
		donor.setD_Number(donorBean.getNumber());
		donor.setD_Id(donorBean.getId());
		donor.setD_Date(donorBean.getDdate());
		donorBean.setId(null);
		return donor;
	}
	
	private List<DonorBean> prepareListofBean(List<Donor> donors){
		List<DonorBean> beans = null;
		if(donors != null && !donors.isEmpty()){
			beans = new ArrayList<DonorBean>();
			DonorBean bean = null;
			for(Donor donor : donors){
				bean = new DonorBean();
				bean.setName(donor.getD_Name());
				bean.setId(donor.getD_Id());
				bean.setAddress(donor.getD_Address());
				bean.setNumber(donor.getD_Number());
				bean.setDdate(donor.getD_Date());
				bean.setAmount(donor.getD_Amount());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private DonorBean prepareDonorBean(Donor donor){
		DonorBean bean = new DonorBean();
		bean.setAddress(donor.getD_Address());
		bean.setAmount(donor.getD_Amount());
		bean.setName(donor.getD_Name());
		bean.setNumber(donor.getD_Number());
		bean.setDdate(donor.getD_Date());
		bean.setId(donor.getD_Id());
		return bean;
	}
}
