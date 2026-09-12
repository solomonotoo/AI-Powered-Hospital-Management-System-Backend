package com.ai_powered_hms_backend.identity.infrastructure.rest.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
public record CreateRoleRequest(
		@NotBlank String name,
		String description,
		@NotEmpty Set<String> permissionCodes
		) {

}
