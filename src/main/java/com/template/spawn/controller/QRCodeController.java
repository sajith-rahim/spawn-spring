package com.template.spawn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.template.spawn.api.QRCodeApi;
import com.template.spawn.dto.QRCodeDTO;
import com.template.spawn.service.QRCodeService;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.OffsetDateTime;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/qr")
public class QRCodeController implements QRCodeApi {
	
	private final QRCodeService qrService;
	
	@Override
	@CrossOrigin
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createQR(
			@Valid @RequestBody(required = true) final QRCodeDTO qrCodeDTO,
			final HttpServletResponse httpServletResponse
			) throws Exception{
		// flushing to response
		qrService.generate(qrCodeDTO, httpServletResponse);
	}
	
	@GetMapping("/sample")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> sample(){
		 QRCodeDTO sampleQR = new QRCodeDTO().builder()
				.title("test")
				.content("test-content")
				.createdDate(OffsetDateTime.now())
				.build();
		return new ResponseEntity<QRCodeDTO>(sampleQR,HttpStatus.OK);
	}
	

}
