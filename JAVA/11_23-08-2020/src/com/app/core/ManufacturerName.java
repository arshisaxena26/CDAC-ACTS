package com.app.core;

public enum ManufacturerName {
	MARUTI, HONDA, HYUNDAI;

	// Overriding toString to return Manufacturer Name
	@Override
	public String toString() {
		return name();
	}
}
