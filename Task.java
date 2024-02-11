package todoproject;

class Task {
    String name;
    boolean completed;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.completed = false;
    }

    @Override
    public String toString() {
        return "Task: " + name +      " Priority: " + priority +     " Completed: " + completed;
    }
}

