package com.rays.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BroadCastDTO;

public class BroadCastForm extends BaseForm {

	@NotEmpty(message = "boardcastCode is required")
	private String boardcastCode;

	@NotEmpty(message = "messageTitle is required")
	private String messageTitle;

	@NotEmpty(message = "messageContent is required")
	private String messageContent;

	@NotNull(message = "boardcastTime is required")
	private LocalDateTime boardcastTime;

	@NotEmpty(message = "boardcastStatus is required")
	private String boardcastStatus;

	public String getBoardcastCode() {
		return boardcastCode;
	}

	public void setBoardcastCode(String boardcastCode) {
		this.boardcastCode = boardcastCode;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public LocalDateTime getBoardcastTime() {
		return boardcastTime;
	}

	public void setBoardcastTime(LocalDateTime boardcastTime) {
		this.boardcastTime = boardcastTime;
	}

	public String getBoardcastStatus() {
		return boardcastStatus;
	}

	public void setBoardcastStatus(String boardcastStatus) {
		this.boardcastStatus = boardcastStatus;
	}
	
	@Override
	public BaseDTO getDto() {
		BroadCastDTO dto=initDTO(new BroadCastDTO());
		
		dto.setBoardcastCode(boardcastCode);
		dto.setMessageTitle(messageTitle);
		dto.setMessageContent(messageContent);
		dto.setBoardcastTime(boardcastTime);
		dto.setBoardcastStatus(boardcastStatus);
		return dto;
	}

}
