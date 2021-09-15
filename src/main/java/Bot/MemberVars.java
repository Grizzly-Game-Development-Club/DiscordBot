package Bot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberVars implements Serializable {

    long memberId;
    String firstName;
    String lastName;
    String schoolEmail;
    List<Event> eventsAttended;

    public MemberVars(long memberId) {
        this.memberId = memberId;
        eventsAttended = new ArrayList<>();
    }

    public long getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public List<Event> getEventsAttended() {
        return eventsAttended;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public void addEventAttended(Event event) {
        eventsAttended.add(event);
    }

    @Override
    public String toString() {
        return "MemberVars{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", schoolEmail='" + schoolEmail + '\'' +
                ", eventsAttended=" + eventsAttended +
                '}';
    }
}
