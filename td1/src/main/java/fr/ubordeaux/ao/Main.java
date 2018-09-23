package fr.ubordeaux.ao;

import java.util.ArrayList;
import java.util.Set;

public class Main
{
    private static  final int MAX = 3;

    public static void main(String[] args)
    {
        Contacts contacts = new Contacts();

        for (int i = 0 ; i < MAX ; i++)
        {
            Town talence = new Town("Talence", 33405);
            Address address = new Address(351, "Cours de la libération", talence);
            Contact newContact = new Contact("John", "Do", address);
            contacts.addContact(newContact);
        }

        Town talence = new Town("Bordeaux", 33000);
        Address address = new Address(351, "Cours de la libération", talence);
        Contact newContact = new Contact("Bob", "Dupont", address);
        contacts.addContact(newContact);

        ArrayList<Contact> contactsListe = SearchContact.getContactByNameAndFirstName(contacts, "John Doe");

        System.out.println("Nombre contact trouvé : " + contactsListe.size());

        System.out.println(MAX + " contacts created !\n");

        TownFactory tf = new TownFactory();
        Towns towns = new Towns();

        for (int i = 0; i < 30; i++)
          towns.addTown(tf.getNextTown());

        Set<Town> townsSet = towns.getTowns(0, towns.size());
        for (Town town : townsSet)
          System.out.println(town.getName() + " " + town.getZipCode());

        try
        {
            Thread.sleep(200000);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
