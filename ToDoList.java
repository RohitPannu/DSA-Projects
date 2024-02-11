package todoproject;

class ToDoList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean removeTask(String taskName) {
        Node current = head;
        Node prev = null;

        while (current != null && !current.task.name.equals(taskName)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                head = current.next;
            }
            return true;
        }
        return false;
    }

    

    public void markTaskAsCompleted(String taskName) {
        Node current = head;
        while (current != null) {
            if (current.task.name.equals(taskName)) {
                current.task.completed = true;
                break;
            }
            current = current.next;
        }
    }

    public void displayTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void organizeByPriority() {
        
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            Node current = head;
            Node previous = null;
            swapped = false;

            while (current.next != null) {
                Node nextNode = current.next;
                if (current.task.priority > nextNode.task.priority) {
                    if (previous != null) {
                        previous.next = nextNode;
                    } else {
                        head = nextNode;
                    }

                    current.next = nextNode.next;
                    nextNode.next = current;
                    previous = nextNode;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    public void searchTask(String taskName) {
        Node current = head;
        boolean found = false;
        int count = 1;
        while (current != null) {
            if (current.task.name.equals(taskName)) {
                found = true;
                System.out.println("Task found at position: " + count);
                System.out.println(current.task);
                break;
            }
            current = current.next;
            count++;
        }
        if (!found) {
            System.out.println("Task not found.");
        }
    }

    public void trackProgress() {
        Node current = head;
        int totalTasks = 0;
        int completedTasks = 0;
        while (current != null) {
            totalTasks++;
            if (current.task.completed) {
                completedTasks++;
            }
            current = current.next;
        }
        double progress = (double) completedTasks / totalTasks * 100;
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Progress: " + progress + "%");
    }
}
