package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Long id, PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		
		return list.map(x -> new UserDTO(x));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional <User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAcessException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integridade" + id);
		}
	}
	
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setcpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBrithDate(dto.getBrithDate());
		entity.setChildren(dto.getChildren());
		
		//verificar se precisa do getUsers().clear();
		
	}
}
