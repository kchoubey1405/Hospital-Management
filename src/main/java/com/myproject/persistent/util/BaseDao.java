package com.myproject.persistent.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.utill.ServicesUtil;

@Repository
public abstract class BaseDao<E extends BaseDo, D extends BaseDto> {

	@Autowired
	EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	protected abstract E importDto(D fromDto);
	protected abstract D exportDto(E entity);
	
	public D create(D dto) {
		E importDto = importDto(dto);
		persist(importDto);
		return exportDto(importDto);
	}

	public D createOrUpdate(D dto){
		E importDto = importDto(dto);
		getSession().saveOrUpdate(importDto);
		return exportDto(importDto);
	}
	
	public void delete(D dto) {
		getSession().delete(importDto(dto));
	}

	protected void persist(E pojo){
		try {
			getSession().persist(pojo);
		} catch (Exception e) {
			//
		}
	}
	
	protected List<D> exportDtoList(Collection<E> listDo) {
		List<D> returnDtos = null;
		if (!ServicesUtil.isEmpty(listDo)) {
			returnDtos = new ArrayList<D>(listDo.size());
			for (Iterator<E> iterator = listDo.iterator(); iterator.hasNext();) {
				returnDtos.add(exportDto(iterator.next()));
			}
		}
		return returnDtos;
	}

	

}
