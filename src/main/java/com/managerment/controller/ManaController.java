package com.managerment.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.managerment.entity.Order;
import com.managerment.model.ManaModel;
import com.managerment.service.manaService;

@Controller
public class ManaController {
	
	@Autowired
	private manaService manaService;
	
	@RequestMapping(value = "/")
	public String list(Model model) {
	    model.addAttribute("orderManagerment", manaService.findAll());
	    return "index";		
	}
	
	@RequestMapping(value = "/add-order")
	public String save(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("date", "Thanh toan don hang thoi gian: "+ dtf.format(now));
		model.addAttribute("orderManagerment", new Order());
		return "addOrder";
	}

	@RequestMapping("/save-order")
	public String doSave(@ModelAttribute("order") Order orderEntity, Model model) throws UnknownHostException {
		String ip = InetAddress.getLocalHost().toString();
		orderEntity.setIpAddress(ip);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		orderEntity.setCreateDate(dtf.format(now));
		
		manaService.save(orderEntity);
		model.addAttribute("orderManagerment", manaService.findAll());
		return "redirect:/";
	}
	
	@RequestMapping("/order-view/{id}")
	public String findById(@PathVariable int id, Model model) throws UnknownHostException {
		ManaModel orderManagerment = manaService.findById(id);
		model.addAttribute("orderManagerment", orderManagerment);
		return "viewOrder";
	}
	
	@RequestMapping("/update-order/{id}")
	public String showUpdate(@PathVariable int id, Model model) throws UnknownHostException {
		ManaModel orderManagerment = manaService.findById(id);
		Map<String,String> bankArray = new HashMap<>();
		bankArray.put("VNPAYQR", "VNPAYQR");
		bankArray.put("VNBANK", "LOCAL BANK");
		bankArray.put("IB", "INTERNET BANKING");
		bankArray.put("ATM", "ATM CARD");
		bankArray.put("INTCARD", "INTERNATIONAL CARD");
		bankArray.put("VISA", "VISA");
		bankArray.put("MASTERCARD", "MASTERCARD");
		bankArray.put("JCB", "JCB");
		bankArray.put("UPI", "UPI");
		bankArray.put("VIB", "VIB");
		bankArray.put("VIETCAPITALBANK", "VIETCAPITALBANK");
		bankArray.put("SCB", "Ngan hang SCB");
		bankArray.put("NCB", "Ngan hang NCB");
		bankArray.put("SACOMBANK", "Ngan hang SacomBank");
		bankArray.put("EXIMBANK", "Ngan hang EximBank");
		bankArray.put("MSBANK", "Ngan hang MSBANK");
		bankArray.put("NAMABANK", "Ngan hang NamABank");
		bankArray.put("VNMART", "Vi dien tu VnMart");
		bankArray.put("VIETINBANK", "Ngan hang Vietinbank");
		bankArray.put("VIETCOMBANK", "Ngan hang VCB");
		bankArray.put("HDBANK", "Ngan hang HDBank");
		bankArray.put("DONGABANK", "Ngan hang Dong A");
		bankArray.put("TPBANK", "Ngân hàng TPBank");
		bankArray.put("OJB", "Ngân hàng OceanBank");
		bankArray.put("BIDV", "Ngân hàng BIDV ");
		bankArray.put("TECHCOMBANK", "Ngân hàng Techcombank");
		bankArray.put("VPBANK", "Ngan hang VPBank");
		bankArray.put("AGRIBANK", "Ngan hang Agribank");
		bankArray.put("MBBANK", "Ngan hang MBBank");
		bankArray.put("ACB", "Ngan hang ACB");
		bankArray.put("OCB", "Ngan hang OCB");
		bankArray.put("IVB", "Ngan hang IVB");
		bankArray.put("SHB", "Ngan hang SHB");
		model.addAttribute("bankArray", bankArray);
		
		Map<String,String> langArray = new HashMap<>();
		langArray.put("vn", "Tiếng Việt");
		langArray.put("en", "English");
		model.addAttribute("langArray", langArray);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("date", "Thanh toan don hang thoi gian: "+ dtf.format(now));
		
		model.addAttribute("orderManagerment", orderManagerment);
		return "update";
	}
	
	@RequestMapping("/save-update")
	public String doUpdate(@ModelAttribute("updateOrder") Order orderEntity, Model model) throws UnknownHostException {
		String ip = InetAddress.getLocalHost().toString();
		orderEntity.setIpAddress(ip);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		orderEntity.setCreateDate(dtf.format(now));
		manaService.update(orderEntity);
	    model.addAttribute("listCustomer", manaService.findAll());
	    return "redirect:/";
	}
}
