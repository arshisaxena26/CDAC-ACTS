package com.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private IVendorService vendorService;

	@GetMapping("/details")
	public String showVendorDetails(Model modelMap, HttpSession session) {
		Vendor vendor = (Vendor) session.getAttribute("user_credentials");
		modelMap.addAttribute("vendor_account_list", vendorService.getVendorBankAccounts(vendor.getId()));
		return "/vendor/details";
	}

	@GetMapping("/create_account")
	public String showBankAccountCreationPage(BankAccount b) {
		return "/vendor/create";
	}

	@PostMapping("/create_account")
	public String createVendorBankAccount(BankAccount account, HttpSession session, RedirectAttributes flashMap) {
		Vendor vendor = (Vendor) session.getAttribute("user_credentials");
		System.out.println(vendorService.addVendorBankAccount(vendor.getId(), account));
		return "redirect:/vendor/details";
	}

}
