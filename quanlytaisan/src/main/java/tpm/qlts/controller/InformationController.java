package tpm.qlts.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tpm.qlts.entitys.ChucVu;
import tpm.qlts.entitys.NhanVien;
import tpm.qlts.entitys.PhongBan;
import tpm.qlts.entitys.TinhTrang;
import tpm.qlts.services.ChucVuService;
import tpm.qlts.services.NhanVienService;
import tpm.qlts.services.PhongBanService;
import tpm.qlts.services.TinhTrangService;

@Controller
@RestController
@RequestMapping("infor")
public class InformationController {
	@Autowired 
	private PhongBanService phongBanService;
	
	@Autowired
	private NhanVienService nhanVienService;
	
	@Autowired 
	private ChucVuService chucVuService;
	
	@Autowired
	private TinhTrangService tinhTrangService;
	
	@GetMapping(value="listAllPhongBan")
	public List<PhongBan> getPhongBan()
	{
		List<PhongBan> listPhongBan = phongBanService.findAll();
		return listPhongBan;
	}
	
	@PostMapping(value="add-phongban")
	public PhongBan addPhongBan(@RequestBody PhongBan phongBan)
	{
		PhongBan resPhongBan = phongBanService.update(phongBan);
		return resPhongBan;
	}
	
	@GetMapping(value="listAllChucVu")
	public List<ChucVu> getChucVu()
	{
		List<ChucVu> listChucVu = chucVuService.findAll();
		return listChucVu;
	}
	
	@PostMapping("add-ChucVu")
	public ChucVu addChucVu(@RequestBody ChucVu chucVu)
	{
		ChucVu resChucVu = chucVuService.update(chucVu);
		return resChucVu;
	}
	
	@GetMapping(value="listAllNhanVien")
	public List<NhanVien> getNhanVien()
	{
		List<NhanVien> listNhanVien = nhanVienService.findAll();
		return listNhanVien;
	}
	
	@PostMapping(value="add-employee")
	public NhanVien addEmployee(@RequestBody NhanVien nhanVien) {
		NhanVien resNhanVien= nhanVienService.save(nhanVien);
		return resNhanVien;
	}
	
	@RequestMapping(value = "update-employee", method = RequestMethod.PUT)
	public NhanVien updateNhanVien(@RequestBody NhanVien nhanVien)
	{
		if (nhanVienService.existsById(nhanVien.getMaNhanVien())) {
			NhanVien resNhanVien= nhanVienService.save(nhanVien);
			return resNhanVien;
		}
		return null;
	}
	
	@DeleteMapping(value="delete-employee/{id}")
	public void deleteNhanVien(@PathVariable String id)
	{
		nhanVienService.deleteById(id);
	}
	
	@GetMapping(value="list-employeeId/{id}")
	public NhanVien getNhanVienById(@PathVariable String id)
	{
		Optional<NhanVien> nhanVien = nhanVienService.findById(id);
		return nhanVien.get();
	}
	
	@GetMapping(value="list-employeeByName/{ten}")
	public List<NhanVien> listNhanVienByName(@PathVariable("ten") String ten)
	{
		return nhanVienService.findNhanVienByName(ten);
	}
	
	@GetMapping("list-tinhtrang")
	public List<TinhTrang> getTinhTrang()
	{
		List<TinhTrang> resTinhTrang = tinhTrangService.findAll();
		return resTinhTrang;
	}
	
	@PostMapping(value="add-tinhtrang")
	public TinhTrang addTinhTrang(@RequestBody TinhTrang tinhTrang)
	{
		TinhTrang resTinhTrang = tinhTrangService.update(tinhTrang);
		return resTinhTrang;
	}
	
	@PutMapping(value="update-tinhtrang")
	public TinhTrang updateTinhTrang(@RequestBody TinhTrang tinhTrang)
	{
		if (tinhTrangService.exitstsById(tinhTrang.getMaTinhTrang())) {
			TinhTrang resTinhTrang = tinhTrangService.update(tinhTrang);
			return resTinhTrang;
		}
		return null;
	}
	
	@DeleteMapping(value="delete-tinhtrang")
	public void deleteTinhTrang(@PathVariable String id)
	{
		tinhTrangService.deleteById(id);
	}
	
}
