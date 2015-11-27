import java.util.Date;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class DigitalWalletHidden {

  public static void main(String[] args) {
    //Test Case #1
    boolean flag = false;
      double availableBalance = 0;
      Transaction tx = null;
      Date txDate = null;
      int score = 0;
      String tcPassed = "";
      ArrayList<Transaction> merTx= new ArrayList<>();
      /* Create an object of digital wallet for Praveen */
      DigitalWallet wallet = new DigitalWallet("Praveen");

      /* 
      * Add money to wallet
      * Cannot add less than 0 or more than 5000
      */

      /* Create an Transaction object and set the details using setter methods */
      txDate = new Date();
      tx = new Transaction();

      //TC 4
      availableBalance = wallet.getBalance();
      if (availableBalance == 0) {
        tcPassed += "TC4:Passed,";
          score++;
      } else {
          tcPassed += "TC4:Failed,";
      }

      //TC 1
      /* Based on the nature of transaction its type should be set to Add Money or Payment or Reward */
      tx.setType("Add Money");
      tx.setAmount(1560);
      tx.setDate(txDate);
      tx.setDescription("TC1");
      tx.setMerchant("NA");
      flag = wallet.addMoney(tx);
      if(flag) {
          tcPassed += "TC1:Passed,";
          score++;
      } else {
          tcPassed += "TC1:Failed,";
      }

      //TC 2
      tx.setType("Add Money");
      tx.setAmount(-1000);
      tx.setDate(txDate);
      tx.setDescription("TC2");
      tx.setMerchant("NA");
      flag = wallet.addMoney(tx);
      if(!flag) {
          tcPassed += "TC2:Passed,";
          score++;
      } else {
          tcPassed += "TC2:Failed,";
      }

      //TC 3
      tx.setType("Add Money");
      tx.setAmount(10000);
      tx.setDate(txDate);
      tx.setDescription("TC3");
      tx.setMerchant("NA");
      flag = wallet.addMoney(tx);
      if(!flag) {
          tcPassed += "TC3:Passed,";
          score++;
      } else {
          tcPassed += "TC3:Failed,";
      }

      //TC 5
      availableBalance = wallet.getBalance();
      if (availableBalance == 1560) {
        tcPassed += "TC5:Passed,";
          score++;
      } else {
          tcPassed += "TC5:Failed,";
          wallet = new DigitalWallet("VV");
        tx.setType("Add Money");
        tx.setAmount(1560);
        tx.setDate(txDate);
        tx.setDescription("TC1");
        tx.setMerchant("NA");
        flag = wallet.addMoney(tx);
      }

      //TC6
      tx.setType("Pay SC");
      tx.setAmount(380);
      tx.setDate(txDate);
      tx.setDescription("TC6");
      tx.setMerchant("SC");
      merTx.add(tx);
      flag = wallet.pay(tx);
      if(flag) {
          tcPassed += "TC6:Passed,";
          score++;
      } else {
          tcPassed += "TC6:Failed,";
      }

      //TC7
      availableBalance = wallet.getBalance();
      if (availableBalance == 1210) {
        tcPassed += "TC7:Passed,";
          score++;
      } else {
          tcPassed += "TC7:Failed,";
      }

      //TC8
      tx.setType("Pay SC1");
      tx.setAmount(3180);
      tx.setDate(txDate);
      tx.setDescription("TC8");
      tx.setMerchant("SC1");
      flag = wallet.pay(tx);
      if(!flag) {
          tcPassed += "TC8:Passed,";
          score++;
      } else {
          tcPassed += "TC8:Failed; ";
      }

      //TC 9
      tx.setType("Pay SC");
      tx.setAmount(80);
      tx.setDate(txDate);
      tx.setDescription("TC9");
      tx.setMerchant("SC");
      merTx.add(tx);
      flag = wallet.pay(tx);
      if(flag) {
          tcPassed += "TC9:Passed,";
          score++;
      } else {
          tcPassed += "TC9:Failed,";
      }

      //TC10
      availableBalance = wallet.getBalance();
      if (availableBalance == 1130) {
        tcPassed += "TC10:Passed,";
          score++;
      } else {
          tcPassed += "TC10:Failed,";
      }

      //TC11
      Transaction[] merTxn = wallet.getTransactions("SC");
    //  System.out.println("L : " + merTxn.length);
    //  System.out.println(merTx.contains(merTxn[0]));
     // System.out.println(merTx.contains(merTxn[1]));
      if (merTxn.length == 2 && merTx.contains(merTxn[0]) && merTx.contains(merTxn[1])) {
        tcPassed += "TC11:Passed,";
        score++;
      } else {
        tcPassed += "TC11:Failed,";
      }

      tcPassed += "Score:" + score;

      fileWrite(tcPassed);
  }

  private static void fileWrite(String fileContent) {
      try {
          File newFile = new File("Result.txt");
          newFile.createNewFile();
          FileWriter writer = new FileWriter(newFile);
          writer.write(fileContent);
          writer.flush();
          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}