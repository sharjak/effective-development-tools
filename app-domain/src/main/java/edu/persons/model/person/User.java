package edu.persons.model.person;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private String userName;
    private String personId;
    private Role role;

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
