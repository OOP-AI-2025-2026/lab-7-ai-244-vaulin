package ua.opnu;

class Student {
    private final String name;
    private final String group;
    private final int[] marks;

    public Student(String name, String group, int[] marks) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    public int[] getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}
