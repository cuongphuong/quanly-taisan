package tpm.qlts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.ThietBi;
import tpm.qlts.repository.ThietBiRepository;

@Service("ThietBiServices")
public class ThietBiServices {
	@Autowired
	private ThietBiRepository thietBiRepository;
	
	public ThietBi update(ThietBi tb)
	{
		return thietBiRepository.save(tb);
	}
	
	public void delete(Long id)
	{
		thietBiRepository.deleteById(id);
	}
	public Iterable<ThietBi> findAll()
	{
		return thietBiRepository.findAll();
	}
	public Optional<ThietBi> findById(Long id)
	{
		return thietBiRepository.findById(id);
	}
}
