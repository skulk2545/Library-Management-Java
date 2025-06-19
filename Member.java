public class Member {
    private String memberId, name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getId() { return memberId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return memberId + "," + name;
    }

    public static Member fromString(String data) {
        String[] parts = data.split(",");
        return new Member(parts[0], parts[1]);
    }
}

