package tpm.qlts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpm.qlts.custommodels.ThietBiByLoaiTB;
import tpm.qlts.custommodels.ThietBiChiTiet;
import tpm.qlts.entitys.LoaiTB;
import tpm.qlts.entitys.ThietBi;
import tpm.qlts.services.LoaiThietBiServiceByManhGa;
import tpm.qlts.services.ThietBiServiceByManhGa;

@Controller
@RestController
@RequestMapping("thietbi")
public class ThietBiController {

	@Autowired
	private ThietBiServiceByManhGa thietBiServices;
	@Autowired
	private LoaiThietBiServiceByManhGa loaiThietBiService;

	@GetMapping("listtb")
	public List<ThietBi> getalltb() {
		return (List<ThietBi>) thietBiServices.findAll();
	}

	// get thiet bi theo nha cung cap
	@GetMapping("get-tb-by-ncc/{maNCC}")
	public List<ThietBiByLoaiTB> layThietBiTheoNhaCungCap(@PathVariable String maNCC) {
		List<ThietBiByLoaiTB> lstThietBiGroupByLoai = new ArrayList<ThietBiByLoaiTB>();
		List<ThietBi> lstThietBi = thietBiServices.getThietBiByNhaCungCap(maNCC);

		for (ThietBi tb : lstThietBi) {
			LoaiTB loaiTB = loaiThietBiService.getLoaiThietBiFromThietBiCon(tb.getMaLoai());
			LoaiTB loaiTBCon = loaiThietBiService.findByID(tb.getMaLoai());
			ThietBiChiTiet tbs = new ThietBiChiTiet("" + maNCC + loaiTB.getMaLoai() + tb.getMaThietBi(),
					loaiTBCon.getTenLoai(), tb.getBaoHanh(), tb.getGiaTri(), tb.getKhauHao(), tb.getMaLoai(),
					tb.getNgayNhap(), "xx");
			int check = checkInList(lstThietBiGroupByLoai, loaiTB.getMaLoai());
			if (check != -1) {

				lstThietBiGroupByLoai.get(check).getLstThietBi().add(tbs);
			} else {
				ThietBiByLoaiTB newItem = new ThietBiByLoaiTB(loaiTB.getMaLoai(), loaiTB.getTenLoai(),
						new ArrayList<ThietBiChiTiet>());

				newItem.getLstThietBi().add(tbs);
				lstThietBiGroupByLoai.add(newItem);
			}
		}

		return lstThietBiGroupByLoai;
	}

	public int checkInList(List<ThietBiByLoaiTB> lst, String maLoai) {
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).getMaLoaiTB().equals(maLoai)) {
				return i;
			}
		}
		return -1;
	}

}
