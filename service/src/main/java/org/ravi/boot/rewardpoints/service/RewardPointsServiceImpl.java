package org.ravi.boot.rewardpoints.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.ravi.boot.rewardpoints.dto.RewardPointsSummary;
import org.ravi.boot.rewardpoints.entity.Transaction;
import org.ravi.boot.rewardpoints.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardPointsServiceImpl implements RewardPointsService{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public RewardPointsSummary getRewardPointsByIdAndMonth(String customerId, String months, String year) {
		String[] monthArray = months.split(",");
		List<Transaction> transactions = transactionRepository.getByCustomerId(customerId, year, monthArray[0], monthArray[1], monthArray[2]);
		Map<Integer, List<Transaction>> transactionsByMonth = transactions.stream().collect(Collectors.groupingBy(e-> e.getTransactionDate().getMonth()));
		int month1Points = getPointsByMonth(transactionsByMonth.get(Integer.valueOf(monthArray[0])));
		int month2Points = getPointsByMonth(transactionsByMonth.get(Integer.valueOf(monthArray[1])));
		int month3Points = getPointsByMonth(transactionsByMonth.get(Integer.valueOf(monthArray[2])));
		RewardPointsSummary rewardPointsSummary = new RewardPointsSummary(customerId, "", month1Points,month2Points,month3Points, month1Points+month2Points+month3Points); 
		return rewardPointsSummary;
	}
	
	
	private Integer getPointsByMonth(List<Transaction> transactions) {
		return transactions.stream().mapToInt(transaction->getPointsByTransaction(transaction)).sum();
		
	}
	
	private Integer getPointsByTransaction(Transaction transaction) {
		Float transactionUpto100=0.0f;
		Float transactionAfter100=0.0f;
		Float totalAmount = transaction.getTransactionAmount();
		transactionUpto100=totalAmount%100;
		transactionAfter100=totalAmount-transactionUpto100;
		return (transactionUpto100.intValue() * 1) + (transactionAfter100.intValue() * 2);
	}
	

}
