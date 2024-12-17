public class User {
    //Attributter
    private String username;
    private String password;
    private String role; //Borger eller politi
    private int age;

    //Constructor
    public User(String username, String password, String role, int age){
        this.username = username;
        this.password = password;
        this.role = role;
        this.age = age;
    }

    // Tjekker login oplysninger
    // inputUsername = Brugernavn som brugeren indtaster
    // inputPassword = Adgangskode som brugeren indtaster
    // Returnere true hvis det er rigtigt
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    //Tjekker om brugeren er over 18
    public boolean isOver18() {
        return this.age >= 18;
    }

    //Getter og setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
