package com.ai_powered_hms_backend.identity.application.port.in;

import com.ai_powered_hms_backend.identity.application.command.CreateRoleCommand;
import com.ai_powered_hms_backend.shared_kernel.ids.RoleId;

public interface CreateRoleUseCase {
	RoleId create(CreateRoleCommand command);
}
