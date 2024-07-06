package org.ravi.boot.rewardpoints.dto;

public class RewardPointsSummary {

	private String customerId;
	private String name;
	private long month1Points;
	private long month2Points;
	private long month3Points;
	private long totlPoints;
	
	public RewardPointsSummary(String customerId, String name, long month1Points, long month2Points, long month3Points,
			long totlPoints) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.month1Points = month1Points;
		this.month2Points = month2Points;
		this.month3Points = month3Points;
		this.totlPoints = totlPoints;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMonth1Points() {
		return month1Points;
	}

	public void setMonth1Points(long month1Points) {
		this.month1Points = month1Points;
	}

	public long getMonth2Points() {
		return month2Points;
	}

	public void setMonth2Points(long month2Points) {
		this.month2Points = month2Points;
	}

	public long getMonth3Points() {
		return month3Points;
	}

	public void setMonth3Points(long month3Points) {
		this.month3Points = month3Points;
	}

	public long getTotlPoints() {
		return totlPoints;
	}

	public void setTotlPoints(long totlPoints) {
		this.totlPoints = totlPoints;
	}
	
	

	
	
}
