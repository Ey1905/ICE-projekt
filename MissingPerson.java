public class MissingPerson {
    private static int idCounter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private double height;
    private String lastSeenLocation;
    private String missingSince;
    private String additionalInfomation;
    private String status;

    // Konstruktør for initialiserer en missingPerson
    public MissingPerson(String firstName, String lastName, int age, double height, String gender, String lastSeenLocation, String missingSince, String additionalInfo, String status) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = Math.max(age, 0); // For at sikre de positive værdier
        this.height = Math.max(height, 0); // For at sikre de positive værdier
        this.gender = gender;
        this.lastSeenLocation = lastSeenLocation;
        this.missingSince = missingSince;
        this.additionalInfomation = additionalInfo;
        this.status = status;
    }

    // Getter
    public int getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public String getLastSeenLocation() {
        return lastSeenLocation;
    }

    public String getMissingSince() {
        return missingSince;
    }

    public String getAdditionalInfo() {
        return additionalInfomation;
    }

    public String getStatus() {
        return status;
    }

    // Markere at de er fundet
    public void markAsFound() {
        System.out.println(firstName + lastName + " Has been found.");
    }

    @Override
    public String toString() {
        return "MissingPerson [ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age + ", Height: " + (height * 1) + " cm "
                + ", Gender: " + gender + ", Last seen: " + lastSeenLocation + ", Missing Since: " + missingSince
                + ", Additional Info: " + additionalInfomation + ", Status: " + status + "]";
    }
}