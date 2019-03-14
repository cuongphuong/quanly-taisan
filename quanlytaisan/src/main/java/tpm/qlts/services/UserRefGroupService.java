package tpm.qlts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.UserRefGroup;
import tpm.qlts.entitys.UserRefGroupPK;
import tpm.qlts.repositorys.UserRefGroupRepository;

@Service("userRefGroupService")
public class UserRefGroupService {
	@Autowired
	private UserRefGroupRepository userRefGroupRepository;
	
	public void deleteById(UserRefGroupPK id)
	{
		userRefGroupRepository.deleteById(id);
	}
	
	public UserRefGroup update(UserRefGroup userRefGroup)
	{
		return userRefGroupRepository.save(userRefGroup);
	}
	
	public List<UserRefGroup> findAll()
	{
		return (List<UserRefGroup>) userRefGroupRepository.findAll();
	}
	
	public Optional<UserRefGroup> findById(UserRefGroupPK id)
	{
		return userRefGroupRepository.findById(id);
	}
}
