package tpm.qlts.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpm.qlts.custommodels.BangiaoOptions;
import tpm.qlts.custommodels.Getthietbi;
import tpm.qlts.custommodels.option;
import tpm.qlts.entitys.LoaiTB;
import tpm.qlts.entitys.NhaCungCap;
import tpm.qlts.entitys.ThietBi;
import tpm.qlts.repositorys.ThietBiRepository;
import tpm.qlts.services.NhaCungCapService;
@Controller
@RestController
@RequestMapping("nhacungcap")
public class NhacungcapController {
	@Autowired
	private NhaCungCapService nhaCungCapService;
	

	@Autowired
	private ThietBiRepository thietBiRepository;
	
	@GetMapping("getall")
	public List<NhaCungCap> getAll()
	{
		return (List<NhaCungCap>)nhaCungCapService.findAll();
	}
	@PostMapping("add-nhacungcap")
	public NhaCungCap newNhaCungCap(@RequestBody NhaCungCap ncc)
	{
		return nhaCungCapService.update(ncc);
	}
	
	@PutMapping("update-nhacungcap")
	public NhaCungCap updateNhaCungCap(@RequestBody NhaCungCap ncc)
	{
		if(nhaCungCapService.existsById(ncc.getMaNCC()))
		{
			return nhaCungCapService.update(ncc);
		}
		else
			return null;
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteNhaCungCap(@PathVariable String id)
	{
		if(nhaCungCapService.existsById(id))
			nhaCungCapService.deleteById(id);
	}
	
	@DeleteMapping("delete-by-list")
	public int deletebylist(@RequestBody List<String> lstID)
	{
		int count = 0;
		for(String id : lstID) {
			if(nhaCungCapService.existsById(id))
				nhaCungCapService.deleteById(id);
			count ++;
		}
		return count;
	}
	@GetMapping("findbyID/{id}")
	public Optional<NhaCungCap> findByID(@PathVariable String id)
	{
		return nhaCungCapService.findById(id);
	}
	
	@GetMapping("listloaitb/{id}")
	public List<LoaiTB> getAllId(@PathVariable String id){
		return nhaCungCapService.getAllMaNCC(id);
	}
	
	@GetMapping("listoptionnhacungcap/{id}")
	public List<BangiaoOptions> getbangiaoOption(@PathVariable String id){
		List<BangiaoOptions> bangiaoOption = new ArrayList<BangiaoOptions>();
		List<LoaiTB> loaitb = nhaCungCapService.getAllMaNCC(id);
		for (LoaiTB loaiTB2 : loaitb) {
			BangiaoOptions bgoption = new BangiaoOptions();
			bgoption.setLabel(loaiTB2.getTenLoai());
			List<option> options = new ArrayList<option>();
			bgoption.setOptions(options);
			List<ThietBi> listTb = loaiTB2.getThietBis();
			for (ThietBi item : listTb) {
				option option2 = new option();
				option2.setLabel(loaiTB2.getTenLoai());
				option2.setValue(Long.toString(item.getMaThietBi()));
				options.add(option2);
			}
			bangiaoOption.add(bgoption);
		}
		return bangiaoOption;
	}
	
	@GetMapping("listalltb/{mancc}/{maloai}")
	public List<BangiaoOptions> getAllloaitb(@PathVariable String mancc, @PathVariable String maloai){
		
		List<LoaiTB> lstloaitb = nhaCungCapService.getAllloatb(mancc, maloai); // khai báo mảng có p/t cần lấy ra
		List<BangiaoOptions> lsttenloai = new ArrayList<BangiaoOptions>();// khi báo p/t cần lấy ra
		for(LoaiTB item: lstloaitb) {
			BangiaoOptions bgOption1 = new BangiaoOptions(); // phần lấy ra p/t mình cần là lsttenloai
			bgOption1.setLabel(item.getTenLoai());
			List<option> options1 = new ArrayList<option>();
			bgOption1.setOptions(options1);
			List<ThietBi> listb1 = item.getThietBis();
			for(ThietBi item1: listb1) {
				option chonlua2 = new option();
				chonlua2.setLabel(item.getTenLoai());
				chonlua2.setValue(Long.toString(item1.getMaThietBi()));
				options1.add(chonlua2);
			}
			lsttenloai.add(bgOption1);
		}
		return lsttenloai;
	}
	
	@GetMapping("gettenthietbi/{id}")
	public Getthietbi laythongtintb(@PathVariable long id) {
		if (thietBiRepository.existsById(id)== true) {
			Optional<ThietBi> thietBi = thietBiRepository.findById(id);
					ThietBi tb = null;
					if(thietBi.isPresent()) {
						tb = thietBi.get();
					}
			Getthietbi tttb = new Getthietbi(tb.getLoaiTb().getTenLoai(), tb.getMaThietBi(), tb.getBaoHanh(),
					tb.getGiaTri(), tb.getKhauHao(), tb.getNgayNhap());
			return tttb;
		}else {
			return null;
		}
	}
	
	

	
	
	
	
	
	
	
	
}