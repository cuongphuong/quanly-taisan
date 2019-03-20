package tpm.qlts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.GroupRefFunction;
import tpm.qlts.entitys.GroupRefFunctionPK;
import tpm.qlts.repositorys.GroupRefFunctionRepository;

@Service(value = "groupRefFunctionService")
public class GroupRefFunctionService {
	@Autowired
	private GroupRefFunctionRepository groupRefFunctionRepository;

	public void deleteById(GroupRefFunctionPK id) {
		groupRefFunctionRepository.deleteById(id);
	}

	public GroupRefFunction update(GroupRefFunction groupRefFunction) {
		return groupRefFunctionRepository.save(groupRefFunction);
	}

	public Optional<GroupRefFunction> findById(GroupRefFunctionPK id) {
		return groupRefFunctionRepository.findById(id);
	}

	public List<GroupRefFunction> findAll() {
		return (List<GroupRefFunction>) groupRefFunctionRepository.findAll();
	}

	public void deleteByList(Iterable<GroupRefFunction> entities) {
		groupRefFunctionRepository.deleteAll(entities);
	}

	public Iterable<GroupRefFunction> saveAllByList(Iterable<GroupRefFunction> lst) {
		return groupRefFunctionRepository.saveAll(lst);
	}

}
