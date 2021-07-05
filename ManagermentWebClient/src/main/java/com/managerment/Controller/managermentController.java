package com.managerment.Controller;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.managerment.managermentDTO.ManagermentDTO;
import com.managerment.service.manaService;

@Controller
public class managermentController {
	@Autowired
	private manaService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("orderManagerment", service.findAll());
        return "index";
    }

    @RequestMapping(value = "/order-view/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("orderManagerment", service.findById(id));
        return "viewOrder";
    }
    
    
    @RequestMapping("/update-order/{id}")
	public String showUpdate(@PathVariable int id, Model model) throws UnknownHostException {
    	ManagermentDTO orderManagerment = service.findById(id);
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

    @RequestMapping(value = "/save-update")
    public String updateOrder(ManagermentDTO manaDTO) {
        service.update(manaDTO);
        return "redirect:/";
    }

	@RequestMapping(value = "/add-order")
	public String save(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("date", "Thanh toan don hang thoi gian: "+ dtf.format(now));
		model.addAttribute("orderManagerment", new ManagermentDTO());
		return "addOrder";
	}
    
    @RequestMapping(method = RequestMethod.POST, value = "/save-order")
    public String create(@Validated @ModelAttribute("save-order") ManagermentDTO manaDTO) {
        service.create(manaDTO);
        return "redirect:/";
    }
}
