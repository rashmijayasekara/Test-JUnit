import org.junit.jupiter.api.*;



class ContactManagerTest {
    ContactManager contactManager;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Should print before all tests. This method is static because creating the instance otherwise Junit can't execute this method");
       }

    @BeforeEach
    public void setup(){
        contactManager = new ContactManager();
    }
    @Test
    public void shouldCreateContact(){
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John","Doe","0773376993");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should not create contact when the first name is null")  // provides a customized name to the test method
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact(null,"Jayasekara","0773376993");
        });
    }

    @Test
    @DisplayName("Should not create a contact when the last name is null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){


        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi",null,"0773376993");
        });
    }

    @Test
    @DisplayName("should not create contact when phone number is null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){

        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Jayasekara",null);
        });
    }

    @Test
    @DisplayName("should not create contact when phone number is invalid")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsInvalid(){

        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Jayasekara"," ");
        });
    }

    @Test
    @DisplayName("should not create contact when the phone number does not starts with a zero")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberDoesNotStartsWithZero(){

        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Jayasekara","7733769937");
        });
    }

    @Test
    @DisplayName("should not create the contact when the contact number does not contains all numbers")
    public void shouldThrowRuntimeExceptionWhenthePhoneNumberDoesNotContainAllntegers(){

        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Rashmi","Nishani","077defghijkl");
        });
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should execute after each test");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Should execute after all tests");
    }

}