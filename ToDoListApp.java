import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     WELCOME TO TO-DO LIST MANAGER      ║");
        System.out.println("║   (Doubly Linked List Implementation)  ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        while (running) {
            displayMenu();
            
            System.out.print("\nEnter your choice: ");
            int choice = getIntInput(scanner);
            
            switch (choice) {
                case 1:
                    addNewTask(scanner, todoList, false);
                    break;
                case 2:
                    addNewTask(scanner, todoList, true);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    todoList.displayTasksReverse();
                    break;
                case 5:
                    markTaskComplete(scanner, todoList);
                    break;
                case 6:
                    deleteTask(scanner, todoList);
                    break;
                case 7:
                    todoList.displayCompletedTasks();
                    break;
                case 8:
                    todoList.displayPendingTasks();
                    break;
                case 9:
                    searchTasks(scanner, todoList);
                    break;
                case 10:
                    clearAllTasks(scanner, todoList);
                    break;
                case 0:
                    running = false;
                    System.out.println("\nThank you for using To-Do List Manager!");
                    System.out.println("Goodbye! 👋");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (running && choice != 0) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n┌────────────────────────────────────────┐");
        System.out.println("│              MAIN MENU                 │");
        System.out.println("├────────────────────────────────────────┤");
        System.out.println("│ 1. Add Task (at end)                   │");
        System.out.println("│ 2. Add Task (at beginning)             │");
        System.out.println("│ 3. Display All Tasks                   │");
        System.out.println("│ 4. Display Tasks (Reverse)             │");
        System.out.println("│ 5. Mark Task as Completed              │");
        System.out.println("│ 6. Delete Task                         │");
        System.out.println("│ 7. View Completed Tasks                │");
        System.out.println("│ 8. View Pending Tasks                  │");
        System.out.println("│ 9. Search Tasks                        │");
        System.out.println("│ 10. Clear All Tasks                    │");
        System.out.println("│ 0. Exit                                │");
        System.out.println("└────────────────────────────────────────┘");
    }
    
    private static void addNewTask(Scanner scanner, ToDoList todoList, boolean atBeginning) {
        System.out.print("\nEnter task description: ");
        String description = scanner.nextLine();
        
        System.out.println("Select priority:");
        System.out.println("1. HIGH");
        System.out.println("2. MEDIUM");
        System.out.println("3. LOW");
        System.out.print("Enter priority (1-3): ");
        int priority = getIntInput(scanner);
        
        if (priority < 1 || priority > 3) {
            priority = 2; // Default to MEDIUM
            System.out.println("Invalid priority! Defaulting to MEDIUM.");
        }
        
        if (atBeginning) {
            todoList.addTaskAtBeginning(description, priority);
        } else {
            todoList.addTask(description, priority);
        }
    }
    
    private static void markTaskComplete(Scanner scanner, ToDoList todoList) {
        if (todoList.isEmpty()) {
            System.out.println("\nNo tasks to mark as completed!");
            return;
        }
        
        todoList.displayTasks();
        System.out.print("\nEnter task number to mark as completed: ");
        int position = getIntInput(scanner);
        todoList.completeTask(position);
    }
    
    private static void deleteTask(Scanner scanner, ToDoList todoList) {
        if (todoList.isEmpty()) {
            System.out.println("\nNo tasks to delete!");
            return;
        }
        
        todoList.displayTasks();
        System.out.print("\nEnter task number to delete: ");
        int position = getIntInput(scanner);
        todoList.deleteTask(position);
    }
    
    private static void searchTasks(Scanner scanner, ToDoList todoList) {
        if (todoList.isEmpty()) {
            System.out.println("\nNo tasks to search!");
            return;
        }
        
        System.out.print("\nEnter keyword to search: ");
        String keyword = scanner.nextLine();
        todoList.searchTasks(keyword);
    }
    
    private static void clearAllTasks(Scanner scanner, ToDoList todoList) {
        if (todoList.isEmpty()) {
            System.out.println("\nNo tasks to clear!");
            return;
        }
        
        System.out.print("\nAre you sure you want to clear all tasks? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            todoList.clearAll();
        } else {
            System.out.println("Operation cancelled.");
        }
    }
    
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input! Please enter a number: ");
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }
}
