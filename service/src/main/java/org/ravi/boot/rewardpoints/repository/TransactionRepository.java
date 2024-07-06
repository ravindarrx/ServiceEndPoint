package org.ravi.boot.rewardpoints.repository;

import java.util.List;

import org.ravi.boot.rewardpoints.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	
	@Query(value = "from Transaction t WHERE customerId = :customerId and YEAR(transactionDate) = :year and ( MONTH(transactionDate) =  (:month1) or MONTH(transactionDate) =  (:month2) or MONTH(transactionDate) =  (:month3) )")
	public List<Transaction> getByCustomerId(@Param("customerId") String customerId,@Param("year") String year, @Param("month1") String month1,@Param("month2") String month2,@Param("month3") String month3);
	
	

}
