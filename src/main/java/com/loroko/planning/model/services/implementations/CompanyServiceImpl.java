package com.loroko.planning.model.services.implementations;

import org.springframework.stereotype.Service;

import com.loroko.planning.model.entities.Company;
import com.loroko.planning.model.repositories.CompanyRepository;
import com.loroko.planning.model.services.CompanyService;

@Service
public class CompanyServiceImpl extends ServiceImpl<Long, Company, CompanyRepository> implements CompanyService { 

	@Override
	public Company edit(Long id, Company g) {
		return getRepository().findById(id).map(
				entity -> {
					entity.setName(g.getName());
					return getRepository().save(entity);
				}).orElseGet(()->{
					return getRepository().save(g);
				});
	}
	
	
}
