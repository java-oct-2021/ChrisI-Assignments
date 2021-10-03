import java.util.ArrayList;
public class BankAccount {
	private static ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();;
	private double checkingBalance;
	private double savingsBalance;
	private String accountNumber;
	public BankAccount() {
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		this.accountNumber = StringGen.generateString(12);
		bankAccounts.add(this);
	}
	public BankAccount getCheckingBalance() {
		System.out.println("Checking Balance ("+this.accountNumber+"): "+this.checkingBalance);
		return this;
	}
	public BankAccount getSavingsBalance() {
		System.out.println("Savings Balance ("+this.accountNumber+"): "+this.savingsBalance);
		return this;
	}
	public BankAccount deposit(String accountType,double amount) {
		if(accountType.toLowerCase() == "checking"){
			this.checkingBalance += amount;
			System.out.println("Deposited: "+amount);
			getCheckingBalance();
		} else if(accountType.toLowerCase() == "savings") {
			this.savingsBalance += amount;
			System.out.println("Deposited: "+amount);
			getSavingsBalance();
		}
		return this;
	}
	public BankAccount withdraw(String accountType, double amount) {
		if(accountType.toLowerCase() == "checking"){
			if (amount > this.checkingBalance) {
				System.out.println("Insufficient funds!");
				amount = 0;
			} else {
				this.checkingBalance -= amount;
			}
			System.out.println("Withdrawn: "+amount);
			getCheckingBalance();
		} else if(accountType.toLowerCase() == "savings") {
			if (amount > this.savingsBalance) {
				System.out.println("Insufficient funds!");
				amount = 0;
			} else {
				this.savingsBalance -= amount;
			}
			System.out.println("Withdrawn: "+amount);
			getSavingsBalance();
		}
		return this;
	}
	public BankAccount getAccountBalances() {
		getCheckingBalance();
		getSavingsBalance();
		System.out.println("Total Balance ("+this.accountNumber+"): "+(this.checkingBalance +this.savingsBalance));
		return this;
	}
	public static int getAccountCount() {
		int count = bankAccounts.size();
		System.out.println("Number of accounts: "+count);
		return count;
	}
	public static double getAllAccountValue() {
		double total = 0;
		for (BankAccount bankAccount : bankAccounts) {
			total += bankAccount.checkingBalance;
			total += bankAccount.savingsBalance;
		}
		System.out.println("Total value of all accounts: "+total);
		return total;
	}
}