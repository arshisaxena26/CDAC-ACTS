package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IVendorService vendorService;

	@GetMapping("/list")
	public String showVendorsListPage(Model modelMap) {
		modelMap.addAttribute("vendor_list", vendorService.getVendorList());
		return "/admin/list";
	}

	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vendorId) {
		System.out.println(vendorService.deleteVendor(vendorId));
		return "redirect:/admin/list";
	}

	@GetMapping("/add")
	public String showVendorRegistrationForm(Vendor v) {
		return "/admin/add";
	}

	@PostMapping("/add")
	public String addNewVendor(Vendor v) {
		System.out.println(vendorService.addNewVendor(v));
		return "redirect:/admin/list";
	}

	@GetMapping("/update")
	public String showUpdateVendorForm(Vendor v) {
		return "/admin/update";
	}

	@PostMapping("/update")
	public String updateVendorDetails(Vendor v, @RequestParam int vendorId) {
		System.out.println(vendorService.updateVendorDetails(v, vendorId));
		return "redirect:/admin/list";
	}

}
