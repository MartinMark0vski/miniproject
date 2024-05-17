private static int taskIdCounter = 0;
    private int taskId;
    private String description;
    private LocalDate dueDate;
    private int priority;
    private boolean completed;
    public Task(String description, LocalDate dueDate, int priority) {
        this.taskId = ++taskIdCounter;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }
    public void markAsCompleted() {
        this.completed = true;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    @Override
    public String toString() {
        return "Task ID: " + taskId +
                ", Description: '" + description + '\'' +
                ", Due Date: " + dueDate +
                ", Priority: " + priority +
                ", Completed: " + completed;
    }
}
https://drive.google.com/file/d/1fiThmRnKRne8ZWo7rGtz5X6wyMb-0v7i/view?usp=shari
ng
The code above culd not compile correctly for some reason for the date so this is the
 real: 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDate;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Task> tasks = new ArrayList<>();


    public static void main(String[] args) {
        int choice;


        do {
            System.out.println("------------------");
            System.out.println("Task Manager Menu: ");
            System.out.println("1. Add New Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View All Tasks");
            System.out.println("4. Generate Report for Tasks Due Today");
            System.out.println("0. Exit");
            System.out.println();
            System.out.println("Please choose an option: ");
            choice = getIntInput();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    addTask();
                    System.out.println();
                    break;
                case 2:
                    markTaskAsCompleted();
                    System.out.println();
                    break;
                case 3:
                    viewAllTasks();
                    System.out.println();
                    break;
                case 4:
                    generateReportForTasksDueToday();
                    System.out.println();
                    break;
                default:
                    break;
            }
        } while (choice != 0);


        scanner.close();
    }


    private static void addTask() {
        System.out.println("Enter Task Description: ");
        String description = getStringInput();
        System.out.println("Enter Due Date (Day-Month-Year, e.g., 1-10-2024): ");
        LocalDate dueDate = getLocalDateInput();
        System.out.println("Enter Priority (1-5, 1 being the most urgent): ");
        int priority = getIntInput();
        Task task = new Task(description, dueDate, priority);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }


    private static void markTaskAsCompleted() {
        System.out.println("Enter the Index of the Task to Mark as Completed:");
        int index = getIntInput();
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid index.");
        }
    }


    private static void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ": " + tasks.get(i));
            }
        }
    }


    private static void generateReportForTasksDueToday() {
        LocalDate today = LocalDate.now();
        System.out.println("Tasks Due Today:");
        for (Task task : tasks) {
            if (task.getDueDate().isEqual(today)) {
                System.out.println(task);
            }
        }
    }


    private static int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Consumes the invalid input
            }
        }
    }


    private static String getStringInput() {
        return scanner.nextLine();
    }


    private static LocalDate getLocalDateInput() {
        while (true) {
            try {
                String[] parts = getStringInput().split("-");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Please enter a date in the format Day-Month-Year (e.g., 1-10-2024).");
                }
                int day = Integer.parseInt(parts[0].trim());
                int month = Integer.parseInt(parts[1].trim());
                int year = Integer.parseInt(parts[2].trim());
                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid date in the format Day-Month-Year (e.g., 1-10-2024).");
            }
        }
    }
}


class Task {
    private static int taskIdCounter = 0;
    private int taskId;
    private String description;
    private LocalDate dueDate;
    private int priority;
    private boolean completed;


    public Task(String description, LocalDate dueDate, int priority) {
        this.taskId = ++taskIdCounter;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }


    public void markAsCompleted() {
        this.completed = true;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }


    @Override
    public String toString() {
        return "Task ID: " + taskId +
                ", Description: '" + description + '\'' +
                ", Due Date: " + dueDate +
                ", Priority: " + priority +
                ", Completed: " + completed;
    }
}




