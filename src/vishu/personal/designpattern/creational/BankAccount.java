package vishu.personal.designpattern.creational;

public class BankAccount {
	private long accountNumber;
	private String ownerName;
	private String branch;
	private double balance;
	private double interestRate;
	
	private BankAccount(){
		
	}
	
	/*private BankAccount(long accountNumber, String ownerName, String branch, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.branch = branch;
        this.balance = balance;
        this.interestRate = interestRate;
   }*/
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", ownerName=" + ownerName + ", branch=" + branch
				+ ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	
	public static class BankAccountBuilder {
		private long accountNumber;
		private String ownerName;
		private String branch;
		private double balance;
		private double interestRate;
		
		public BankAccountBuilder(long accountNumber){
			this.accountNumber = accountNumber;
		}
		
/*		public BankAccountBuilder setAccountNumber(long accountNumber){
			this.accountNumber = accountNumber;
			return this;
		}
*/		
		public BankAccountBuilder setownerName(String ownerName){
			this.ownerName = ownerName;
			return this;
		}
		
		public BankAccountBuilder setBranch(String branch){
			this.branch = branch;
			return this;
		}
		
		public BankAccountBuilder setBalance(double balance){
			this.balance = balance;
			return this;
		}
		
		public BankAccountBuilder setInterestRate(double interestRate){
			this.interestRate = interestRate;
			return this;
		}
		
		public BankAccount build(){
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAccountNumber(this.accountNumber);
			bankAccount.setOwnerName(this.ownerName);
			bankAccount.setBranch(this.branch);
			bankAccount.setBalance(this.balance);
			bankAccount.setInterestRate(this.interestRate);
			
			return bankAccount;
		}
	}
}