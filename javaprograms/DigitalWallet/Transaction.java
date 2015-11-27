import java.util.Date;

public class Transaction {
	private String type;
	private double amount;
	private String desc;
	private String merchant;
	private Date date = new Date();
  public void setType(String type) {
  	this.type = type;
  }
  public void setAmount(double amount) {
  	this.amount = amount;
  }
  public void setDate(Date date) {
  	this.date = date;
  }
  public void setDescription(String desc) {
  	this.desc = desc;
  }
  public void setMerchant(String merchant) {
  	this.merchant = merchant;
  }
  public String getType() {
  	return type;
  }
  public double getAmount() {
  	return amount;
  }
  public Date getDate() {
  	return date;
  }
  public String getDescription() {
  	return desc;
  }
  public String getMerchant() {
  	return merchant;
  }
}