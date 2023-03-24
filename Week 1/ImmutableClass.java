
public final class ImmutableClass {
    private final String firstName;
    private final String lastName;

    public ImmutableClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
