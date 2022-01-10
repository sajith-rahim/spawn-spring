package com.template.spawn.service;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.template.spawn.dto.QRCodeDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QRCodeService {
	
	private final ObjectMapper objectMapper;
	//private final QRCodeWriter writer;
	
	private Logger logger = LoggerFactory.getLogger(QRCodeService.class);
	
	public void generate(final QRCodeDTO qrCodeDto,
			final HttpServletResponse httpServletResponse) 
	throws IOException, WriterException {
		
		final var outputStream = new BufferedOutputStream(httpServletResponse.getOutputStream());
		
		
		String fileName = qrCodeDto.toString().trim().replace(" ", "_");
		httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachment;filename=" + fileName + ".png");
		
		QRCodeWriter writer = new QRCodeWriter();

		BitMatrix bitMatrix = writer.encode(objectMapper.writeValueAsString(qrCodeDto),
				BarcodeFormat.QR_CODE, 350, 350);
		
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
		
		outputStream.flush();
	}
}
