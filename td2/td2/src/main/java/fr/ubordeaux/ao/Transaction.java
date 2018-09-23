package fr.ubordeaux.ao;
import java.util.Date;
public class Transaction {
    private Date date;
    private String title;
    private int amount;

    public Transaction(String title, int amount) {
        this.date=new Date();
        this.title = title;
        try{
          if(amount>0){
            this.amount = amount;
          }
        }
          catch(IllegalArgumentException e){
          }
  }

    public Date getTransactionDate() {
      Date copie=(Date)this.date.clone();/*Obligé de caster en Date pour pouvoir */
      return copie;               /*utiliser la méthode clone() de la class Date*/
    }
    public String getTitle() {
        return this.title;
    }

    public int getAmount() {
        return this.amount;
    }
      public Transaction clone(){
        return new Transaction(this.getTitle(),this.getAmount());
      }

      public String toString(){
        return "date  "+this.getTransactionDate().toString()+ " titre  "+this.getTitle()+" montant  "+this.getAmount();
      }
}
/*Dans la classe Account, la méthode addTransaction(Transaction transaction) peut-elle être changée par la méthode addTransaction(String titre, int montant) ?*/
/*Quelle différence cela fait-il ?*/
/*On peut la modifier cela évitera d'avoir à faire appel a getAmount() mais on devra appeler le constructeur de Transaction dans Account*/
