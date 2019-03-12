package tpm.qlts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import tpm.qlts.entitys.NhaCungCap;
import tpm.qlts.services.NhaCungCapService;

@Controller
@RestController
@RequestMapping("home")
public class HomeController {
	@Autowired private NhaCungCapService nhaCungCapService;
	
	@RequestMapping(value = "addncc", method = RequestMethod.GET)
	public NhaCungCap addNhaCC() {
		NhaCungCap ncc = new NhaCungCap("NV", "jsbbajksda", "ahksbdha");
		return nhaCungCapService.capNhat(ncc);
	}
	
	@RequestMapping(value = "getncc", method = RequestMethod.GET)
	public Iterable<NhaCungCap> getNcc() {
		return nhaCungCapService.findAll();
	}
	
}
