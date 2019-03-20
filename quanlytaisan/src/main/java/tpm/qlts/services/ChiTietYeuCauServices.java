package tpm.qlts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.ChiTietYeuCau;
import tpm.qlts.repositorys.ChiTietYeuCauRepository;

@Service("ChiTietYeuCauServices")
public class ChiTietYeuCauServices {
	@Autowired
	private ChiTietYeuCauRepository chiTietYeuCauRepository;
	
	public ChiTietYeuCau update(ChiTietYeuCau ctyc)
	{
		return chiTietYeuCauRepository.save(ctyc);
	}
	
	public void delete(Integer id)
	{
		chiTietYeuCauRepository.deleteById(id);
	}
	public Iterable<ChiTietYeuCau> findAll()
	{
		return chiTietYeuCauRepository.findAll();
	}
	
	public Optional<ChiTietYeuCau> findById(Integer id)
	{
		return chiTietYeuCauRepository.findById(id);
	}
}
