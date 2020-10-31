package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acct_id")
	private Integer accountId;

	@Enumerated(EnumType.STRING)
	@Column(name = "acct_type", length = 15)
	private Type accountType;

	private double balance;

	@ManyToOne
	@JoinColumn(name = "vendor_id", nullable = false)
	private Vendor accountHolder;

	public BankAccount() {
		// default Constructor
	}

	// Parameterized Constructor
	public BankAccount(Type accountType, double balance) {
		super();
		this.accountType = accountType;
		this.balance = balance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Type getAccountType() {
		return accountType;
	}

	public void setAccountType(Type accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Vendor getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Vendor vendor) {
		this.accountHolder = vendor;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
}
