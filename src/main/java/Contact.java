public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNubmer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNubmer;
    }

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void validateFirstName(){
        if (this.firstName.isBlank()) throw new RuntimeException("First Name can't be null or empty");
    }
    public void validateSecondName(){
        if (this.lastName.isBlank()) throw new RuntimeException("Last Name can't be null or empty");

    }
    public void validatePhoneNumber(){
        if (this.phoneNumber.isBlank()){
            throw new RuntimeException("Phone Name can't be null or empty");
        } else if (this.phoneNumber.length()!=10) {
            throw new RuntimeException("Phone Number should be 10 digits in lenght");

        }else if (!this.phoneNumber.matches("\\d+")){
            throw new RuntimeException("Phone number contain only digits");
        }else if (!this.phoneNumber.startsWith("0")){
            throw new RuntimeException("Invalid Phone Number");
        }

    }
}
