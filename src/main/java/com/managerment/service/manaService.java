package com.managerment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managerment.dao.OrderManagerMentDao;
import com.managerment.entity.Order;
import com.managerment.model.ManaModel;

@Service
@Transactional
public class manaService {
	@Autowired
	private OrderManagerMentDao manaDao;
	
	public List<ManaModel> findAll() {
	    return manaDao.findAll();
	  }
	
	public void save(Order orderEntity) {
		manaDao.save(orderEntity);
	}
	
	public ManaModel findById(int orderId) {
		return manaDao.findById(orderId);
	}
	
	public void update(Order orderEntity) {
		manaDao.update(orderEntity);
	}
}
