import java.util.ArrayList;

public class DigitalWallet {
  ArrayList<Transaction> trans = new ArrayList<Transaction>();
  ArrayList<Transaction> rewardTrans = new ArrayList<Transaction>();
  private String name;
  private double wallet;
  /* Store all the Add Money, Pay and Reward transactions as transaction objects */

  /* implement all the methods given below */

  /* Default constructor */
  public DigitalWallet(String name ) {
    this.name = name;
    wallet = 0;
  }

  /* Add money to the wallet */
  public boolean addMoney(Transaction tx) {
    if((tx.getAmount() >= 0) && (tx.getAmount() <= 5000)) {
      trans.add(tx);
      wallet = wallet + tx.getAmount();
      return true;
    }
    return false;
  }

  /* Return the balance in the wallet */
  public double getBalance() {
    return wallet;
  }

  /* Make a payment */
  public boolean pay(Transaction tx) {
    if(tx.getAmount() < wallet) {
      trans.add(tx);
      wallet = wallet - tx.getAmount();
      int temp = (int)(tx.getAmount() / 100) * 10 ;
      if(temp >= 10) {
        Transaction newtrans = new Transaction();
        newtrans.setDate(tx.getDate());
        newtrans.setDescription(tx.getDescription());
        newtrans.setType("Reward");
        newtrans.setAmount(temp);
        newtrans.setMerchant(tx.getMerchant());
        rewardTrans.add(newtrans);
        trans.add(newtrans);
      }
      wallet = wallet + temp;
      return true;
    }
    return false;
  }

  /* print statement */
  public void printStatement() {
    for(Transaction temp2 : trans ) {
      System.out.print(temp2.getType() + "\t");
      System.out.print(temp2.getAmount() + "\t");
      System.out.print(temp2.getDate() + "\t");
      System.out.print(temp2.getDescription() + "\t");
      System.out.println(temp2.getMerchant());
    }
  }

  /* Return the list of reward transactions */
  public Transaction[] getRewardTransactions() {
    Transaction[] array = new Transaction[rewardTrans.size()];
    for(int j = 0 ; j < rewardTrans.size() ; j++) {
      array[j] = rewardTrans.get(j);
    }
    return array;
  }

  /* Return all the transactions */
  public Transaction[] getAllTransactions() {
    Transaction[] transarray = new Transaction[trans.size()];
    for(int i = 0 ; i < trans.size() ; i ++ ) {
      transarray[i] = trans.get(i);
    }
    return transarray;
  }

  /* Return the transactions that match the merchant name */
  public Transaction[] getTransactions(String merchantName) {
    int count = 0;
    for(Transaction temp : trans) {
      if(temp.getMerchant().compareTo(merchantName) == 0) {
        if(temp.getType().compareTo("Payment") == 0) {
          count++ ;
        }
      }
    }
    Transaction[] transarray = new Transaction[count];
    int j = 0;
    for(int i = 0 ; i < trans.size() ; i ++ ) {
      if(trans.get(i).getMerchant().compareTo(merchantName) == 0) {
        if(trans.get(i).getType().compareTo("Payment") == 0) {
          transarray[j] = trans.get(i);
          j++;
        }
      }
    }
    return transarray;
  }

}