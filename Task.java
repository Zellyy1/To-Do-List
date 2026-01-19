import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private boolean isCompleted;
    private LocalDateTime createdAt;
    private int priority; // 1 = High, 2 = Medium, 3 = Low
    
    public Task(String description, int priority) {
        this.description = description;
        this.isCompleted = false;
        this.createdAt = LocalDateTime.now();
        this.priority = priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    public void markCompleted() {
        this.isCompleted = true;
    }
    
    public void markIncomplete() {
        this.isCompleted = false;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public String getPriorityString() {
        switch(priority) {
            case 1: return "HIGH";
            case 2: return "MEDIUM";
            case 3: return "LOW";
            default: return "UNKNOWN";
        }
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String status = isCompleted ? "[✓]" : "[ ]";
        return String.format("%s %s - Priority: %s (Created: %s)", 
            status, description, getPriorityString(), createdAt.format(formatter));
    }
}
