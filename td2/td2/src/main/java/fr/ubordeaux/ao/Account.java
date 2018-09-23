package fr.ubordeaux.ao;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Account {
    private double balance;/*peux changer*/
    private String id;
    private String name;
    private Set<Transaction> transactions;/*peux changer car on peut ajouter des éléments*/

    public Account(String id, String name) {
        this.balance = 0;
        transactions = new HashSet<Transaction>();
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.balance+=transaction.getAmount();
    }
    public void removeTransaction(Date date,String Title,int montant) {
     Transaction tr=null;
      for(Transaction operations : transactions){
        if((operations.getAmount()==montant)&&(operations.getTitle().equals(Title))) {
          if((operations.getTransactionDate().compareTo(date))==0){
            this.balance-=operations.getAmount();
            tr=operations.clone();
          }
        }
      }
      transactions.remove(tr);
    }
    public Set<Transaction> getTransactionSince(Date date) {
      Set<Transaction> operations = new HashSet<Transaction>();
      for(Transaction ops : transactions){
        if( ops.getTransactionDate().after(date)){
          operations.add(ops.clone());
        }
      }
      return operations;
    }



    @Override
    public boolean equals(Object other) {
        if (other instanceof Account) {
            Account otherAccount = (Account) other;
            return this.id.compareTo(otherAccount.id) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Account "+this.name+" (id="+this.id+"), balance = "+this.balance;
    }

}
