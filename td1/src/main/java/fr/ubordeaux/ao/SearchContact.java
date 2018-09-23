package fr.ubordeaux.ao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchContact
{
  public static ArrayList<Contact> getContactByNameAndFirstName(Contacts contacts, String search)
  {
    ArrayList<Contact> listContacts = new ArrayList<Contact>();
    Set<Contact> listeContacts = contacts.getContacts(0, contacts.size());

    for (Contact contact : listeContacts)
      if (withSearchFunction(contact, search))
        listContacts.add(contact);

    return listContacts;
  }

  private static boolean withSearchFunction(Contact contact, String search)
  {
    return search.contains(contact.getFirstName()) || search.contains(contact.getSecondName());
  }
}
