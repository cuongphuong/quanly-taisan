package tpm.qlts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpm.qlts.entitys.LoaiTB;
import tpm.qlts.services.LoaiTBService;

@Controller
@RestController
@RequestMapping("loaitb")
public class LoaiTBController {
	
	@Autowired
	private LoaiTBService loaiTBService;
	
	@GetMapping("listtb")
	public List<LoaiTB> getallloaitb(){
		return (List<LoaiTB>)loaiTBService.findAll();
	}
}
