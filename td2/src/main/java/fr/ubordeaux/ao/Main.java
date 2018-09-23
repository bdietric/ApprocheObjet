package fr.ubordeaux.ao;
import java.util.Date;

public class Main
{
    private static  final int MAX = 3;

    public static void main(String[] args)
    {Date date=new Date();
      Account Brian=new Account("582","Dietrich");
      for(int i=0;i<400;i++){
          Transaction tr=new Transaction("test numéro"+i,i);
          Brian.addTransaction(tr);
      }

     System.out.println(Brian.getTransactionSince(date));
      System.out.println("fin de la date 1\n");
      Date date2=new Date();
      System.out.println(Brian.getTransactionSince(date2));
      System.out.println("Pas de transaction\n");
      Transaction tr=new Transaction("test numéro",666);
      Brian.addTransaction(tr);
      System.out.println(Brian.getTransactionSince(date2));
      Transaction tr1=new Transaction("test numéro",6669);
      Brian.addTransaction(tr1);
      Brian.removeTransaction(date2,"test numéro",666);
      System.out.println(Brian.getTransactionSince(date2));






    }
}
