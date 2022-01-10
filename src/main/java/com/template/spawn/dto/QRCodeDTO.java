package com.template.spawn.dto;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QRCodeDTO {
	@Schema(description = "title text", defaultValue = "Hey You,")
	private String title;
	
	@NotNull(message = "content cannot be null.")
	@Schema(description = "content text", required = true, defaultValue = "Smile =)", example = "Smile =)",minLength = 3, maxLength = 1000)
	private String content;
	
	private OffsetDateTime createdDate;
}
