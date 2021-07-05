package com.vnpay.restController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.vnpay.model.ModelService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/v1")
public class RestController {
	private List<ModelService> listData = new ArrayList<>();
	
	@GetMapping("/todo")
	public HashMap<String, List<ModelService>> getList(@RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
									  @RequestParam(name = "pageSize", defaultValue = "5") final int pageSize,UriComponentsBuilder uriBuilder,
									  HttpServletResponse response){
	    HashMap<String, List<ModelService>> lstHashMap = null;
        try {
            Connection conn = DriverManager.getConnection(	
                    "jdbc:oracle:thin:@10.22.7.24:1521:VNPTEST", "VNAPGW", "vnapgw");
            CallableStatement callableStatement = conn.prepareCall("{ call HOAKGKM_ORDER_MNGT.GET_ALL(?, ?, ?, ?) }");
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, OracleTypes.INTEGER);
            callableStatement.setInt(3, pageNumber);
            callableStatement.setInt(4, pageSize);
            callableStatement.execute();
            ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
            listData.removeAll(listData);
            
            while (resultSet.next()) {
            	ModelService order = new ModelService();
                order.setOrderId(resultSet.getInt("ORDER_ID"));
                order.setMoney(resultSet.getInt("MONEY"));
                order.setContent(resultSet.getString("CONTENT"));
                order.setCreateDate(resultSet.getDate("CREATE_DATE"));
                order.setStatus(resultSet.getString("STATUS"));
                order.setIpAddr(resultSet.getString("IP_ADDR"));
                listData.add(order);
            }
            
            lstHashMap = new HashMap<String, List<ModelService>>();
            lstHashMap.put("tmp", listData);
            
            
        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.format("SQL State: %s", e.getMessage("Lỗi kết nối"));
            e.printStackTrace();
        }
        return lstHashMap;
	}

	@GetMapping("/todo/{id}")
	public ModelService getData(@PathVariable(name = "id") Integer Id, Model model) {
		ModelService order = new ModelService();
		try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.22.7.24:1521:VNPTEST", "VNAPGW", "vnapgw");
            CallableStatement callableStatement = conn.prepareCall("{ call HOAKGKM_ORDER_MNGT.GET_BY_ID(?, ?) }");
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.setInt(2, Id);
            callableStatement.execute();
            ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

            while (resultSet.next()) {
                order.setOrderId(resultSet.getInt("ORDER_ID"));
                order.setMoney(resultSet.getInt("MONEY"));
                order.setContent(resultSet.getString("CONTENT"));
                order.setStatus(resultSet.getString("MC_RESPONSE"));
            }

        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.format("SQL State: %s", e.getMessage());
            e.printStackTrace();
        }
		return order;
		
	}
	
	@PostMapping("/todo/{id}")
	public ModelService editData(@PathVariable(name = "id" ) Integer Id, @RequestBody ModelService model) {
		try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.22.7.24:1521:VNPTEST", "VNAPGW", "vnapgw");
            CallableStatement callableStatement = conn.prepareCall("{ call HOAKGKM_ORDER_MNGT.UPDATE_ORDER(?, ?, ?, ?, ?, ?, TO_DATE(?, 'MM/dd/yyyy'), ?, ?) }");
            callableStatement.setInt(1, Id);
            callableStatement.setString(2, model.getContent());
            callableStatement.setString(3, model.getStatus());
            callableStatement.setString(4, model.getIpAddr());
            callableStatement.setString(5, model.getTypePay());
            callableStatement.setFloat(6, model.getMoney());
            callableStatement.setDate(7, model.getCreateDate());
            callableStatement.setString(8, model.getBank());
            callableStatement.setString(9, model.getLanguage());
            callableStatement.execute();

        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.format("SQL State: %s", e.getMessage());
            e.printStackTrace();
        }
		return model;
	}
	
	@PostMapping("/todo")
	public ResponseEntity<ModelService> addData(@RequestBody ModelService model) {
		try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.22.7.24:1521:VNPTEST", "VNAPGW", "vnapgw");
            CallableStatement callableStatement = conn.prepareCall("{ call HOAKGKM_ORDER_MNGT.INSERT_ORDER( ?, ?, ?, ?, ?, TO_DATE(?, 'MM/dd/yyyy'), ?, ?) }");
            callableStatement.setString(1, model.getContent());
            callableStatement.setString(2, model.getStatus());
            callableStatement.setString(3, model.getIpAddr());
            callableStatement.setString(4, model.getTypePay());
            callableStatement.setFloat(5, model.getMoney());
            callableStatement.setDate(6, model.getCreateDate());
            callableStatement.setString(7, model.getBank());
            callableStatement.setString(8, model.getLanguage());
            callableStatement.execute(); 
        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.format("SQL State: %s", e.getMessage());
            e.printStackTrace();
        }
		return ResponseEntity.ok().body(model);
	}
}
