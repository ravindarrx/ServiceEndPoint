package org.ravi.boot.rewardpoints.service;

import org.ravi.boot.rewardpoints.dto.RewardPointsSummary;

public interface RewardPointsService {
	
	
	public RewardPointsSummary getRewardPointsByIdAndMonth(String customerId, String monthList, String year);

}
