package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private Long accountNumber;

	public Bank() {
		// complete the function
		accountNumber = 0L;
		accounts = new LinkedHashMap<Long,Account>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		accountNumber = accountNumber+1;
		Account account = new CommercialAccount(company,accountNumber,pin,startingDeposit);
		accounts.put(accountNumber,account);

        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		accountNumber++;
		Account account = new ConsumerAccount(person,accountNumber,pin,startingDeposit);
		accounts.put(accountNumber,account);
        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		if(accounts.get(accountNumber).validatePin(pin))
        return true;
		return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber).getBalance();

	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		if(accounts.get(accountNumber).getBalance() >=amount) {
			accounts.get(accountNumber).debitAccount(amount);
			return true;
		}
		else
			return false;
	}
}
