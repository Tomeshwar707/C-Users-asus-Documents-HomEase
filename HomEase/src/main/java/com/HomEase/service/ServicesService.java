package com.HomEase.service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HomEase.entity.Services;
import com.HomEase.repo.ServicesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("service")
public class ServicesService {
	
	@Autowired
	ServicesRepository repository;

	public List<Services> getServices() {
		return (List<Services>) repository.findAll();
	}

	public Services getServices(Long id) {
		Services services=null;
		try {
		services=repository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return services;
	}

	public Services insertServices(Services ut) {
		Services services=null;
		try {
			services=repository.save(ut);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return services;
	}


	public Services updateServices(Long id, Services ut) {
		Services services=null;
		if(ut.getServiceId()==id) {
		Services oldServices = repository.findById(id).get();
		oldServices.setServiceId(ut.getServiceId());
		oldServices.setCustomer(ut.getCustomer());
		oldServices.setProvider(ut.getProvider());
		oldServices.setServiceType(ut.getServiceType());
		oldServices.setDescription(ut.getDescription());
		oldServices.setScheduledDate(ut.getScheduledDate());
		oldServices.setScheduledTime(ut.getScheduledTime());
		
		return repository.save(oldServices);
		}
		return services;
	}

	public Services deleteServices(Long id) {
		Services services=null;
		try {
		services=repository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(services !=null)
		{
			repository.deleteById(id);
		}
	return services;
	}

}
