package com.rays.dto;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_boardcast")
public class BroadCastDTO extends BaseDTO {

	@Column(name = "Boardcastcode")
	private String boardcastCode;

	@Column(name = "MessageTitle")
	private String messageTitle;

	@Column(name = "MessageContent")
	private String messageContent;

	@Column(name = "BoardcastTime")
	private LocalDateTime boardcastTime;

	@Column(name = "BoardcastStatus")
	private String boardcastStatus;

	@Override
	public String getUniqueKey() {
		return "boardcastCode";
	}

	@Override
	public String getUniqueValue() {
		return boardcastCode;
	}

	@Override
	public String getLabel() {
		return "boardcast Code";
	}

	@Override
	public String getTableName() {
		return "Boardcast";
	}

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

}
