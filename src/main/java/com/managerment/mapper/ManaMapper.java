package com.managerment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.managerment.model.ManaModel;

public class ManaMapper implements RowMapper<ManaModel> {
	@Override
	public ManaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		int oderId = rs.getInt("ORDER_ID");
		String content = rs.getString("CONTENT");
		float money = rs.getFloat("MONEY");
		String status = rs.getString("STATUS");
		String bank = rs.getString("BANK");
		String typePay = rs.getString("TYPE_PAY");
		String ipAddr = rs.getString("IP_ADDR");
		String createDate = rs.getString("CREATE_DATE");
		String language = rs.getString("LANGUAGE");
		return new ManaModel(oderId, content, money, status, bank, typePay, ipAddr, createDate, language);
	}

}
