package tpm.qlts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.DonMuaHang;
import tpm.qlts.repositorys.DonMuaHangRepository;

@Service("DonMuaHangServices")
public class DonMuaHangServices {
	@Autowired
	private DonMuaHangRepository donMuaHangRepository;
	
	public DonMuaHang update(DonMuaHang dm)
	{
		return donMuaHangRepository.save(dm);
	}
	
	public void delete(Integer id)
	{
		donMuaHangRepository.deleteById(id);
	}
	
	public Iterable<DonMuaHang> findAll()
	{
		return donMuaHangRepository.findAll();
	}
	
	public Optional<DonMuaHang> findByID(Integer id)
	{
		return donMuaHangRepository.findById(id);
	}
}
