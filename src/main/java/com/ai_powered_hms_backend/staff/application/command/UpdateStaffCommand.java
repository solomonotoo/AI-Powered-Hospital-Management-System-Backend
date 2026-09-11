package com.ai_powered_hms_backend.staff.application.command;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.ai_powered_hms_backend.shared_kernel.valueobjects.Email;
import com.ai_powered_hms_backend.shared_kernel.valueobjects.PersonName;
import com.ai_powered_hms_backend.shared_kernel.valueobjects.PhoneNumber;
import com.ai_powered_hms_backend.staff.domain.enums.StaffRole;
import com.ai_powered_hms_backend.staff.domain.valueobjects.EmployeeNumber;

public record UpdateStaffCommand(
		EmployeeNumber employeeNumber,
		PersonName fullName, 
		StaffRole role,
		String specialisation, 
		String department, 
		Email workEmail, 
		PhoneNumber phone, 
		String licenseNumber,
		String qualifications,
		LocalDate joiningDate,
		String workingHours,
		BigDecimal consultationFee,
		UUID modifiedBy	
		) {

}
