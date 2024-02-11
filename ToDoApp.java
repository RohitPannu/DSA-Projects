package todoproject;

import java.util.Scanner;

class ToDoApp {
    private ToDoList todoList;

    public ToDoApp() {
        this.todoList = new ToDoList();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    searchTask(scanner);
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    markTaskAsCompleted(scanner);
                    break;
                case 5:
                    organizeByNumberWise();
                    break;
                case 6:
                    prioritizeTasks();
                    break;
                case 7:
                    trackProgress();
                    break;
                case 9:
                    System.out.println("Exiting the Project. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n------ ToDo List Menu ------");
        System.out.println("1. Add Task");
        System.out.println("2. Search Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. Organize by Number Wise");
        System.out.println("6. Prioritize Tasks");
        System.out.println("7. Track Progress");
        System.out.println("9. Exit");
    }

    private void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task priority: ");
        int priority = scanner.nextInt();

        Task task = new Task(name, priority);
        todoList.addTask(task);
        System.out.println("Task added successfully.");
    }

    private void searchTask(Scanner scanner) {
        System.out.print("Enter task name to search: ");
        String taskName = scanner.nextLine();
        todoList.searchTask(taskName);
    }

    private void removeTask(Scanner scanner) {
        System.out.print("Enter task name to remove: ");
        String taskName = scanner.nextLine();
        if (todoList.removeTask(taskName)) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found. Removal unsuccessful.");
        }
    }

    private void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter task name to mark as completed: ");
        String taskName = scanner.nextLine();
        todoList.markTaskAsCompleted(taskName);
        System.out.println("Task marked as completed.");
    }

    private void organizeByNumberWise() {
        // Assuming number-wise organization is the same as displaying tasks
        System.out.println("\nOrganized by Number Wise:");
        todoList.displayTasks();
    }

    private void prioritizeTasks() {
        System.out.println("\nOrganizing tasks by priority:");
        todoList.organizeByPriority();
        todoList.displayTasks();
    }

    private void trackProgress() {
        System.out.println("\nTracking Progress:");
        todoList.trackProgress();
    }
}



