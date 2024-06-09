package address.data;

public class AddressEntry {
    
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String ZIP;
    private String phoneNumber;
    private String emailAddress;
    
    public AddressEntry(String firstName, String lastName, String street, String city, String state, String ZIP, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.ZIP = ZIP;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getZIP(){
        return ZIP;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZIP(String ZIP){
        this.ZIP = ZIP;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" 
        + street + ", " + city + ", " + state + " " + ZIP + "\n" 
        + phoneNumber + "\n" 
        + emailAddress;
        }
}
