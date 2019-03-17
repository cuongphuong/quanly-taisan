package tpm.qlts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.PhieuYeuCauThietBi;
import tpm.qlts.repository.PhieuYeuCauThietBiRepository;

@Service("PhieuYeuCauThietBiServices")
public class PhieuYeuCauThietBiServices {
	@Autowired
	private PhieuYeuCauThietBiRepository phieuYeuCauThietBiRepository;
	
	public PhieuYeuCauThietBi update(PhieuYeuCauThietBi pyc)
	{
		return phieuYeuCauThietBiRepository.save(pyc);
	}
	
	public void delete(Integer id)
	{
		phieuYeuCauThietBiRepository.deleteById(id);
	}
	
	public Iterable<PhieuYeuCauThietBi> findAll()
	{
		return phieuYeuCauThietBiRepository.findAll();
	}
	
	public Optional<PhieuYeuCauThietBi> finById(Integer id)
	{
		return phieuYeuCauThietBiRepository.findById(id);
	}
}
