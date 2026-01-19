public class ToDoList {
    private Node head;
    private Node tail;
    private int size;
    
    public ToDoList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Add task at the end of the list
    public void addTask(String description, int priority) {
        Task newTask = new Task(description, priority);
        Node newNode = new Node(newTask);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Task added successfully!");
    }
    
    // Add task at the beginning of the list
    public void addTaskAtBeginning(String description, int priority) {
        Task newTask = new Task(description, priority);
        Node newNode = new Node(newTask);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Task added at the beginning!");
    }
    
    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        
        System.out.println("\n========== TO-DO LIST ==========");
        Node current = head;
        int index = 1;
        
        while (current != null) {
            System.out.println(index + ". " + current.task);
            current = current.next;
            index++;
        }
        System.out.println("================================");
        System.out.println("Total tasks: " + size);
    }
    
    // Display tasks in reverse order
    public void displayTasksReverse() {
        if (tail == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        
        System.out.println("\n====== TO-DO LIST (REVERSE) ======");
        Node current = tail;
        int index = size;
        
        while (current != null) {
            System.out.println(index + ". " + current.task);
            current = current.prev;
            index--;
        }
        System.out.println("==================================");
    }
    
    // Mark task as completed by position
    public void completeTask(int position) {
        Node node = getNodeAtPosition(position);
        if (node != null) {
            node.task.markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid position!");
        }
    }
    
    // Delete task by position
    public void deleteTask(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        
        Node nodeToDelete = getNodeAtPosition(position);
        
        if (nodeToDelete == null) {
            return;
        }
        
        // If it's the only node
        if (head == tail) {
            head = tail = null;
        }
        // If it's the head
        else if (nodeToDelete == head) {
            head = head.next;
            head.prev = null;
        }
        // If it's the tail
        else if (nodeToDelete == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // If it's in the middle
        else {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
        
        size--;
        System.out.println("Task deleted successfully!");
    }
    
    // Get node at specific position
    private Node getNodeAtPosition(int position) {
        if (position < 1 || position > size) {
            return null;
        }
        
        Node current;
        
        // Optimize: start from head or tail depending on position
        if (position <= size / 2) {
            current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i > position; i--) {
                current = current.prev;
            }
        }
        
        return current;
    }
    
    // Display only completed tasks
    public void displayCompletedTasks() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        
        System.out.println("\n===== COMPLETED TASKS =====");
        Node current = head;
        int index = 1;
        boolean found = false;
        
        while (current != null) {
            if (current.task.isCompleted()) {
                System.out.println(index + ". " + current.task);
                found = true;
            }
            current = current.next;
            index++;
        }
        
        if (!found) {
            System.out.println("No completed tasks!");
        }
        System.out.println("===========================");
    }
    
    // Display only pending tasks
    public void displayPendingTasks() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        
        System.out.println("\n===== PENDING TASKS =====");
        Node current = head;
        int index = 1;
        boolean found = false;
        
        while (current != null) {
            if (!current.task.isCompleted()) {
                System.out.println(index + ". " + current.task);
                found = true;
            }
            current = current.next;
            index++;
        }
        
        if (!found) {
            System.out.println("No pending tasks!");
        }
        System.out.println("=========================");
    }
    
    // Search tasks by keyword
    public void searchTasks(String keyword) {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        
        System.out.println("\n===== SEARCH RESULTS =====");
        Node current = head;
        int index = 1;
        boolean found = false;
        
        while (current != null) {
            if (current.task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(index + ". " + current.task);
                found = true;
            }
            current = current.next;
            index++;
        }
        
        if (!found) {
            System.out.println("No tasks found with keyword: " + keyword);
        }
        System.out.println("==========================");
    }
    
    // Get the size of the list
    public int getSize() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Clear all tasks
    public void clearAll() {
        head = tail = null;
        size = 0;
        System.out.println("All tasks cleared!");
    }
}
