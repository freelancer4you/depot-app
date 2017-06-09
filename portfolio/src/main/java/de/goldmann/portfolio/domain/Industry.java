package de.goldmann.portfolio.domain;

public enum Industry {
	FINANCIAL_SECTOR("Finanzsektor"),
	DIVERSE("Diverse"),
	TELECOMMUNICATION("Telekommunikation"),
	CONSUMER_GOODS("Konsumgüter"),
	CHEMESTRY("Chemie / Pharma"),
	AUTOMOBILE_INDUSTRY("Kraftfahrzeugindustrie"),
	TRANSPORTATION("Transport / Verkehr"),
	SUPPLIER("Versorger"),
	CONSTRUCTION_INDUSTRY("Bauindustrie"),
	TECHNOLOGY("Technologie"),
	INDUSTRY("Industrie"),
	ENTERTAINMENT("Medien / Entertainment"),
	SOFTWARE("Software"),
	ENERGY("Energie / Rohstoffe"),
	COMMERCE("Handel"),
	INFORMATIONTECHNOLOGY("Informationstechnologie"),
	UNDEFINED("");

	private final String caption;

	Industry(final String caption) {
		this.caption = caption;
	}

}
