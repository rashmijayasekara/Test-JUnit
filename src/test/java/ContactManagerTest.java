import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Repeatable;


class ContactManagerTest {

    @Test
    public void shouldCreateContact(){
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John","Doe","0773376993");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should not create contact when the first name is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact(null,"Jayasekara","0773376993");
        });
    }

    @Test
    @DisplayName("Should not create a contact when the last name is null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){

        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi",null,"0773376993");
        });
    }

    @Test
    @DisplayName("should not create contact when phone number is null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Jayasekara",null);
        });
    }

    @Test
    @DisplayName("should not create contact when phone number is invalid")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsInvalid(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Jayasekara"," ");
        });
    }

    @Test
    @DisplayName("should not create contact when the phone number does not starts with a zero")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberDoesNotStartsWithZero(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Jayasekara","7733769937");
        });
    }

    @Test
    @DisplayName("should not create the contact when the contact number does not contains all numbers")
    public void shouldThrowRuntimeExceptionWhenthePhoneNumberDoesNotContainAllntegers(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Nishani","077defghijkl");
        });
    }

}