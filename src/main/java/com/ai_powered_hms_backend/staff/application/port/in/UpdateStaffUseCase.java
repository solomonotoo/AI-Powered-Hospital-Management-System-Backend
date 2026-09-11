package com.ai_powered_hms_backend.staff.application.port.in;

import com.ai_powered_hms_backend.staff.application.command.UpdateStaffCommand;

public interface UpdateStaffUseCase {
	void update(UpdateStaffCommand command);
}
