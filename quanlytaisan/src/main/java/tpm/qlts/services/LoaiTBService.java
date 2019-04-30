package tpm.qlts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.LoaiTB;
import tpm.qlts.repositorys.LoaiTBRepository;

@Service("loaiTBService")
public class LoaiTBService {
	@Autowired
	LoaiTBRepository loaiTBRepository;

	public LoaiTB save(LoaiTB loaiTB) {
		return loaiTBRepository.save(loaiTB);
	}

	public List<LoaiTB> getLoaiTBSub() {
		return loaiTBRepository.getLoaiTBSub();
	}

	public List<LoaiTB> getLoaiTBCha() {
		return loaiTBRepository.getLoaiTBCha();
	}

	public LoaiTB findByID(String id) {
		Optional<LoaiTB> x = loaiTBRepository.findById(id);
		if (x.isPresent()) {
			return x.get();
		}
		return null;
	}

	public List<LoaiTB> findAll() {
		return (List<LoaiTB>) loaiTBRepository.findAll();
	}

	public List<LoaiTB> getAllByIdPhongBan(String id) {
		return loaiTBRepository.getAllByIdPhongBan(id);
	}

	public List<LoaiTB> getAllThietBimaLoai(String maPhongBan, String maLoai) {
		return loaiTBRepository.getAllThietBimaLoai(maPhongBan, maLoai);
	}
}
