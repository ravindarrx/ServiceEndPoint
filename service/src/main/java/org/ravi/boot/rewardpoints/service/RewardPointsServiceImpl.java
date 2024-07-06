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

	@SuppressWarnings("deprecation")
	@Override
	public RewardPointsSummary getRewardPointsByIdAndMonth(String customerId, String months, String year) {
		String[] monthArray = months.split(",");
		List<Transaction> transactions = transactionRepository.getByCustomerId(customerId, year, monthArray[0], monthArray[1], monthArray[2]);
		// TODO : fix deprecation
		Map<Integer, List<Transaction>> transactionsByMonth = transactions.stream().collect(Collectors.groupingBy(e-> e.getTransactionDate().getMonth()+1));
		int month1Points = getPointsByMonth(transactionsByMonth.get(Integer.valueOf(monthArray[0])));
		int month2Points = getPointsByMonth(transactionsByMonth.get(Integer.valueOf(monthArray[1])));
		int month3Points = getPointsByMonth(transactionsByMonth.get(Integer.valueOf(monthArray[2])));
		RewardPointsSummary rewardPointsSummary = new RewardPointsSummary(customerId, transactions.get(0).getCustomerName(), month1Points,month2Points,month3Points, month1Points+month2Points+month3Points); 
		return rewardPointsSummary;
	}
	
	
	private Integer getPointsByMonth(List<Transaction> transactions) {
		return transactions.stream().mapToInt(transaction->getPointsByTransaction(transaction)).sum();
		
	}
	
	private Integer getPointsByTransaction(Transaction transaction) {
		int transactionAmount = (int)transaction.getTransactionAmount();
		if (transactionAmount < 50 )
			return 0;
		else if( transactionAmount >= 50 && transactionAmount <= 100 )
			return transactionAmount-50;
		else 
			return 2 * (transactionAmount-100) + 50;
	}
	

}
