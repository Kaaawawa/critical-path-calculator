package main.java.graph;
import main.java.model.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

// 全体のプロジェクトのグラフを管理するクラス
public class ProjectGraph {
    private Map<String, Task> tasks;

    public ProjectGraph() {
        this.tasks = new HashMap<>();
    }

    public void addTask(String id, String name, int duration) {
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("タスクIDが重複しています: " + id);
        }
        tasks.put(id, new Task(id, name, duration));
    }

    // タスク間の依存関係を追加
    // 例: addDependency("A", "B") はAが終わったらBができる（BはAに依存する）
    public void addDependency(String fromId, String toId) {
        Task from = tasks.get(fromId);
        Task to = tasks.get(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("ぞんざいしないタスクIDがしていされています");
        }

        from.addSuccessor(to);
        to.addPredecessor(from);
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }

    public Collection<Task> getAllTasks() {
        return tasks.values();
    }

}
