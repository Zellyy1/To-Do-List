# To-Do List Application using Doubly Linked List

A fully-featured To-Do List application implemented in Java using a **Doubly Linked List** data structure.

## Features

✅ Add tasks at the end or beginning of the list

✅ Mark tasks as completed

✅ Delete tasks by position

✅ View all tasks (forward and reverse)

✅ Filter completed and pending tasks

✅ Search tasks by keyword

✅ Priority levels (High, Medium, Low)

✅ Timestamp tracking for each task

✅ Clear all tasks functionality

## Project Structure

```
├── Task.java           - Task data model with properties
├── Node.java           - Node class for doubly linked list
├── ToDoList.java       - Core doubly linked list implementation
└── ToDoListApp.java    - Main application with interactive menu
```

## Data Structure: Doubly Linked List

### Why Doubly Linked List?

- **Bidirectional traversal**: Can traverse forward and backward
- **Efficient deletion**: O(1) deletion when node reference is known
- **Flexible insertion**: Can insert at both ends efficiently
- **Better for UI**: Easy to implement undo/redo operations

### Structure:
```
      ┌──────┐      ┌──────┐      ┌──────┐
HEAD ─┤ Task ├─────▶│ Task ├─────▶│ Task │◀─── TAIL
      │      │◀─────│      │◀─────│      │
      └──────┘      └──────┘      └──────┘
        prev  next   prev  next   prev  next
```

## How to Compile and Run

### Step 1: Compile all Java files
```bash
javac Task.java Node.java ToDoList.java ToDoListApp.java
```

### Step 2: Run the application
```bash
java ToDoListApp
```

## Usage Guide

### Main Menu Options

1. **Add Task (at end)** - Adds a new task at the end of the list
2. **Add Task (at beginning)** - Adds a new task at the beginning
3. **Display All Tasks** - Shows all tasks with their status
4. **Display Tasks (Reverse)** - Shows tasks in reverse order (demonstrates doubly linked list)
5. **Mark Task as Completed** - Marks a specific task as done
6. **Delete Task** - Removes a task from the list
7. **View Completed Tasks** - Shows only completed tasks
8. **View Pending Tasks** - Shows only pending tasks
9. **Search Tasks** - Search tasks by keyword
10. **Clear All Tasks** - Removes all tasks (with confirmation)
0. **Exit** - Close the application

### Example Workflow

1. Add a task: "Buy groceries" with HIGH priority
2. Add a task: "Call dentist" with MEDIUM priority
3. Display all tasks to see your list
4. Mark task #1 as completed
5. View pending tasks to see what's left

## Code Highlights

### Task Class
- Stores task description, completion status, creation timestamp, and priority
- Provides formatted string representation

### Node Class
- Contains a Task object
- Has references to both previous and next nodes

### ToDoList Class (Core Implementation)
- `addTask()`: O(1) - Adds at tail
- `addTaskAtBeginning()`: O(1) - Adds at head
- `deleteTask()`: O(n) - Deletes by position
- `getNodeAtPosition()`: O(n/2) - Optimized traversal from nearest end
- `displayTasks()`: O(n) - Forward traversal
- `displayTasksReverse()`: O(n) - Backward traversal (unique to doubly linked list)

## Time Complexity

| Operation | Time Complexity |
|-----------|----------------|
| Add at end | O(1) |
| Add at beginning | O(1) |
| Delete by position | O(n) |
| Search | O(n) |
| Display | O(n) |
| Mark complete | O(n) |

## Space Complexity

- **O(n)** where n is the number of tasks
- Each node stores: Task object + 2 references (prev, next)

## Sample Output

```
╔════════════════════════════════════════╗
║     WELCOME TO TO-DO LIST MANAGER      ║
║   (Doubly Linked List Implementation)  ║
╚════════════════════════════════════════╝

========== TO-DO LIST ==========
1. [ ] Buy groceries - Priority: HIGH (Created: 2026-01-19 10:30)
2. [✓] Call dentist - Priority: MEDIUM (Created: 2026-01-19 10:31)
3. [ ] Finish project - Priority: HIGH (Created: 2026-01-19 10:32)
================================
Total tasks: 3
```

## Learning Objectives

This project demonstrates:
- Implementation of doubly linked list from scratch
- Node-based data structure manipulation
- Memory management with references
- Object-oriented design principles
- User interaction and menu-driven programs

## Advantages of This Implementation

1. **No size limitations** - Grows dynamically
2. **Efficient insertion/deletion** at both ends
3. **Bidirectional traversal** - Can go forward or backward
4. **Memory efficient** - Only allocates memory as needed
5. **Flexible** - Easy to add new features

## Possible Enhancements

- Save tasks to file (persistence)
- Sort tasks by priority or date
- Set due dates and reminders
- Categories/tags for tasks
- Undo/redo functionality
- Export to CSV/JSON

## Author

Built as a demonstration of Doubly Linked List data structure in Java.

## License

Free to use for educational purposes.
