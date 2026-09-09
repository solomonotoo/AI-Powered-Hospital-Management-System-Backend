package com.ai_powered_hms_backend.identity.application.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai_powered_hms_backend.identity.application.command.CreateRoleCommand;
import com.ai_powered_hms_backend.identity.application.port.in.CreateRoleUseCase;
import com.ai_powered_hms_backend.identity.application.port.out.PermissionRepository;
import com.ai_powered_hms_backend.identity.application.port.out.RoleRepository;
import com.ai_powered_hms_backend.identity.domain.model.Permission;
import com.ai_powered_hms_backend.identity.domain.model.Role;
import com.ai_powered_hms_backend.shared_kernel.ids.RoleId;

@Service
public class CreateRoleService implements CreateRoleUseCase {

	private final RoleRepository roleRepository;
	private final PermissionRepository permissionRepository;
	
	public CreateRoleService(RoleRepository roleRepository, PermissionRepository permissionRepository) {
		super();
		this.roleRepository = roleRepository;
		this.permissionRepository = permissionRepository;
	}


	@Override
	@Transactional
	public RoleId create(CreateRoleCommand command) {
		if(roleRepository.existsByName(command.name())) {
			throw new DuplicateRoleException("Role name already exists: " + command.name());
		}
		
		Set<String> validCodes = permissionRepository.findAll().stream()
				.map(Permission :: code)
				.collect(Collectors.toSet());
		
		Set<String> unknown = command.permissionCode().stream()
				.filter(code -> !validCodes.contains(code))
				.collect(Collectors.toSet());
		
		if(!unknown.isEmpty()) {
			throw new IllegalAccessError("Unknown permission code(s): " + unknown);
		}
		
		// Role.create(...) sets systemDefined=false internally — admin-created
        // roles are always editable/deletable, unlike the seeded ones.
		Role role = Role.create(command.name(), command.description(), command.permissionCode(), command.createdBy());
		roleRepository.save(role);
		
		return role.roleId();
	}

}
