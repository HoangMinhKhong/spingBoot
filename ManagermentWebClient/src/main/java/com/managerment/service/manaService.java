package com.managerment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.managerment.managermentDTO.ManagermentDTO;

@Service
public class manaService {	
	@Value("${resource}")
	private String resource;
	@Value("${resource}/{id}")
	private String idResource;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<ManagermentDTO> findAll() {
		List<ManagermentDTO> listArr = new ArrayList<ManagermentDTO>();
		listArr = Arrays.stream(restTemplate.getForObject(resource, ManagermentDTO[].class)).collect(Collectors.toList());
	    return listArr;
	}
	
	public ManagermentDTO findById(int id) {
		ManagermentDTO response = restTemplate.getForObject(resource +"/"+ id, ManagermentDTO.class);
		return response;
		
	}
	
	public ManagermentDTO update(ManagermentDTO modelDTO) {
	    return restTemplate.exchange(resource+"/"+ modelDTO.getOrderId(), HttpMethod.POST, new HttpEntity<>(modelDTO), ManagermentDTO.class, modelDTO.getOrderId()).getBody();
	}
	
	public ManagermentDTO create(ManagermentDTO manaDTO) {
	    return restTemplate.postForObject(resource, manaDTO, ManagermentDTO.class);
	}
}
