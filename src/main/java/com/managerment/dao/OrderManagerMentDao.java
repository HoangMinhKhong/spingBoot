package com.managerment.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.managerment.entity.Order;
import com.managerment.mapper.ManaMapper;
import com.managerment.model.ManaModel;

@Repository
public class OrderManagerMentDao extends JdbcDaoSupport {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public OrderManagerMentDao(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<ManaModel> findAll(){
		String sql = "SELECT * FROM ORDER_HOANGKM ORDER BY order_id DESC";
		List<ManaModel> listData = jdbcTemplate.query(sql, new ManaMapper());
	    return listData;
	}
	
	 public void save(Order orderEntity) {
	    String sql = "INSERT INTO ORDER_HOANGKM (type_pay, money, content, bank, ip_addr, create_date, status, language) VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'MM/dd/yyyy'), ?, ?)";
	    jdbcTemplate.update(sql, orderEntity.gettylePay(), orderEntity.getMoney(), orderEntity.getContent(), orderEntity.getBank(), orderEntity.getIpAddress(), orderEntity.getCreateDate(), orderEntity.getStatus(), orderEntity.getLanguage());
	 }
	 
	public ManaModel findById(int oderId) {
		String sql = "SELECT * FROM ORDER_HOANGKM WHERE ORDER_ID = ?";
		ManaModel streetName = jdbcTemplate.queryForObject(sql, new ManaMapper(), oderId);
		return streetName;
	}
	
	public void update(Order orderEntity) {
		String sql = "update ORDER_HOANGKM set type_pay = ?, money = ?, content = ?, bank = ?, ip_addr = ?, language = ? where order_id = ?";
		jdbcTemplate.update(sql, orderEntity.gettylePay(), orderEntity.getMoney(), orderEntity.getContent(), orderEntity.getBank(), orderEntity.getIpAddress(), orderEntity.getLanguage(), orderEntity.getOrderId());
	}
}

