import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {
    Map<String , Contact> contactList=new ConcurrentHashMap<String, Contact>();
// using a concurrent hash map to store data in memory because it's a thread safe implementation of the hash map

    public void addContact(String firstName, String lastName, String phoneNumber){
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        validateContact(contact);
        checkIfContactAlreadyExists(contact);
        contactList.put(generateKey(contact),contact);
    }

    public Collection<Contact> getAllContacts(){return contactList.values();}

    private void checkIfContactAlreadyExists(Contact contact){
        if (contactList.containsKey(generateKey(contact)))
            throw new RuntimeException("Contact Already Exists");
    }

    private void validateContact(Contact contact){
        contact.validateFirstName();
        contact.validateSecondName();
        contact.validatePhoneNumber();
    }

    private String generateKey(Contact contact){
        return String.format("%s-%s",contact.getFirstName(),contact.getLastName());
    }
}
