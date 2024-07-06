package org.ravi.boot.rewardpoints.controller;

import org.ravi.boot.rewardpoints.dto.RewardPointsSummary;
import org.ravi.boot.rewardpoints.service.RewardPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardPointsController {

	@Autowired
	private RewardPointsService rewardPointsService;

	@GetMapping("/points")
	public RewardPointsSummary greeting(@RequestParam String customerId, @RequestParam String monthList, String year) {
		return rewardPointsService.getRewardPointsByIdAndMonth(customerId, monthList, year);
	}

}
