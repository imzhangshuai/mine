package com.team.mine.domain;

public enum TradeNature {

	GOODS("GOODS"), SERVICES("SERVICES");

	private String tradeNature;

	TradeNature(String tradeNature) {
		this.tradeNature = tradeNature;
	}

	public String getTradeNature() {
		return tradeNature;
	}

	public void setTradeNature(String tradeNature) {
		this.tradeNature = tradeNature;
	}
	
	public static TradeNature getTradeNature(String nature) {
		for (TradeNature n : TradeNature.values()) {
			if (n.name().equals(nature)) {
				return n;
			}
		}
		return null;
	}
}
