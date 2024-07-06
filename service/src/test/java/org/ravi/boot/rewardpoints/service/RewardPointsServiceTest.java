package org.ravi.boot.rewardpoints.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ravi.boot.rewardpoints.RewardPointsApplication;
import org.ravi.boot.rewardpoints.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RewardPointsApplication.class)
public class RewardPointsServiceTest {

	@Autowired
	private RewardPointsService rewardPointsService;
	
    @Test
    public void contextLoads() {
    }

    @Test
    public void returnsTransactionsByCustomerIdYearAndMonth() {
    //   List<Transaction> transactions = repository.getByCustomerId("1", "2024", "01", "02", "03");
       rewardPointsService.getRewardPointsByIdAndMonth("1", "01,02,03","2024");
      // Assertions.assertEquals(1,transactions.size());
    }
    
}


