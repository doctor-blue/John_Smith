package java_code;

public enum Day {
    MON("MONDAY"),
    TUE("TUESDAY"),
    WED("WEDNESDAY"),
    THU("THURSDAY"),
    FRI("FRIDAY"),
    SAT("SATURDAY"),
    SUN("SUNDAY");

    private String fullName;

    Day(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
