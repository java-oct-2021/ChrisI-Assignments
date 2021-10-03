public class AccountTest {
	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount();
		BankAccount ba2 = new BankAccount();
		BankAccount ba3 = new BankAccount();
		System.out.println("\n");
		ba1.deposit("savings", 1000).deposit("checking", 1500);
		ba2.deposit("savings", 2000).deposit("checking", 2500);
		ba3.deposit("savings", 3000).deposit("checking", 3500);
		System.out.println("\n");
		ba1.getAccountBalances();
		ba2.getAccountBalances();
		ba3.getAccountBalances();
		System.out.println("\n");
		BankAccount.getAccountCount();
		BankAccount.getAllAccountValue();
		ba1.withdraw("savings", 10).withdraw("checking", 15);
		ba2.withdraw("savings", 20).withdraw("checking", 25);
		ba3.withdraw("savings", 30).withdraw("checking", 35);
		System.out.println("\n");
		ba1.getAccountBalances();
		ba2.getAccountBalances();
		ba3.getAccountBalances();
		System.out.println("\n");
		BankAccount.getAccountCount();
		BankAccount.getAllAccountValue();
	}
}