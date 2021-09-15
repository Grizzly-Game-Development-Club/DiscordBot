package Bot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Event implements Serializable {

    private final String search;
    private final String name;
    private final List<Long> membersAttended;
    private final HashMap<Long, String> membersAttended1;
    private final int year;

    public Event(String name, int year, String name1) {
        this.search = name;
        this.name = name1;
        membersAttended = new ArrayList<>();
        membersAttended1 = new HashMap<>();
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getSearch() {
        return search;
    }

    public String getNameFancy() {
        return name + "\n" + year;
    }

    public List<Long> getMembersAttended() {
        return membersAttended;
    }

    public HashMap<Long, String> getMembersAttended1() {
        return membersAttended1;
    }

    public void addMemberAttended(Long memberId, String role) {
        membersAttended.add(memberId);
        membersAttended1.put(memberId,role);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", membersAttended=" + membersAttended +
                '}';
    }
}
