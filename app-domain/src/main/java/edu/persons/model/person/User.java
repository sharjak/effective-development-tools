package edu.persons.model.person;

import java.util.Objects;

public class User {
    private String userName;
    private String personId;
    private Role role;

    public User(String userName, String personId, Role role) {
        this.userName = userName;
        this.personId = personId;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(personId,
                user.personId) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, personId, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", personId='" + personId + '\'' +
                ", role=" + role +
                '}';
    }

    public enum Role {
        CLIENT,
        OFFICIAL,
        EXTERNAL_OFFICIAL
    }

    public static void main(String[] args) {

        User officer = new User("officer", "123", Role.OFFICIAL);
        officer.setUserName(officer.getUserName() + "2");
        officer.setPersonId( "0");
        officer.setRole(Role.CLIENT);

        System.out.println("Username: " + officer.getUserName() + ", personId: " + officer.getPersonId() + ", " +
                "role: " + officer.getRole());
        System.out.println(officer);
    }
}
