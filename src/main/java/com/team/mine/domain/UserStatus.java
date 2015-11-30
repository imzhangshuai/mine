package com.team.mine.domain;

public enum UserStatus {
	ENABLED("ENABLED"), BLACKLIST("BLACKLIST"), DISABLED("DISABLED");

	private String status;

	UserStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
