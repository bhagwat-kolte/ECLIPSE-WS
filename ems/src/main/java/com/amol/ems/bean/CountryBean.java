package com.amol.ems.bean;

public class CountryBean{
	
	private String countryId;
	
	private String countryName;
	
	private RegionBean region;
	
	public CountryBean() {
	}

	/**
	 * @return the countryId
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the region
	 */
	public RegionBean getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(RegionBean region) {
		this.region = region;
	}
}