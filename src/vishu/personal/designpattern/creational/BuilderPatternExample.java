package vishu.personal.designpattern.creational;

public class BuilderPatternExample {
	public static void main(String[] args) {
		System.out.println("*******************CREATING BANK ACCOUNT*******************");
		BankAccount account1 = new BankAccount.BankAccountBuilder(1234L)
								.setownerName("Vishu")
								.setBranch("Doddathogur")
								.setBalance(10_000.00)
								.setInterestRate(3.5)
								.build();
		
		BankAccount account2 = new BankAccount.BankAccountBuilder(5678L)
								.setownerName("Giri")
								.setBranch("Mysore Infosys")
								.setBalance(99_999.00)
								.setInterestRate(4.0)
								.build();
		
		System.out.println(account1);
		System.out.println(account2);
	}
}

