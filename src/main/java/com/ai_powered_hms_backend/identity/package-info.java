@org.springframework.modulith.ApplicationModule(
		allowedDependencies = {
			"shared_kernel :: valueobjects",
			"shared_kernel :: enums",
			"shared_kernel :: ids",
			"shared_kernel :: base",
			"shared_kernel :: persistence",
			"shared_kernel :: security",
			"shared_kernel :: exceptions",
			"shared_kernel :: rest",
			"staff :: api"
		}
)
package com.ai_powered_hms_backend.identity;