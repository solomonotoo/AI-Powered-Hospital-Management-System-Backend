package com.ai_powered_hms_backend.staff.application.service;

import org.springframework.stereotype.Service;

import com.ai_powered_hms_backend.staff.application.command.UpdateStaffCommand;
import com.ai_powered_hms_backend.staff.application.port.in.UpdateStaffUseCase;
import com.ai_powered_hms_backend.staff.application.port.out.StaffRepository;
import com.ai_powered_hms_backend.staff.domain.model.StaffProfile;

@Service
public class UpdateStaffService implements UpdateStaffUseCase {
	
	private final StaffRepository staffRepository;
	

	public UpdateStaffService(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}


	@Override
	public void update(UpdateStaffCommand command) {
		// get staff by id
		//StaffProfile
		
	}

}
