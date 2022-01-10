package com.template.spawn.api;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.template.spawn.dto.QRCodeDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


public interface QRCodeApi {

	@Operation(summary = "generate a QR code for the provided information")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Success", 
			    content = { @Content }),
			  @ApiResponse(responseCode = "400", description = "Invalid")
	})
	void createQR(@Valid QRCodeDTO qrCodeDTO, HttpServletResponse httpServletResponse) throws Exception;

}