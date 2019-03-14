package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.TinhTrangRefThietBiRepository;
import tpm.qlts.entitys.TinhTrangRefThietBi;
import tpm.qlts.entitys.TinhTrangRefThietBiPK;

@Service("tinhTrangRefThietBiService")
public class TinhTrangRefThietBiService {

	@Autowired
	private TinhTrangRefThietBiRepository tinhTrangRefThietBiRepository;
	
	public Iterable<TinhTrangRefThietBi> findAll()
	{
		return tinhTrangRefThietBiRepository.findAll();
	}
	public Optional<TinhTrangRefThietBi> findByID(TinhTrangRefThietBiPK ID)
	{
		return tinhTrangRefThietBiRepository.findById(ID);
	}
	public TinhTrangRefThietBi update(TinhTrangRefThietBi tt_tb)
	{
		return tinhTrangRefThietBiRepository.save(tt_tb);
	}
	public void delete(TinhTrangRefThietBiPK ID)
	{
		tinhTrangRefThietBiRepository.deleteById(ID);
	}
	
}
