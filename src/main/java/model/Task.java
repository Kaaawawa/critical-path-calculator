package main.java.model;
import java.util.List;
import java.util.ArrayList;


// 1タスクを表すクラス
public class Task {
    private String id;
    private String name;
    private int duration; // タスクの所要日数
    private List<Task> predecessors; // 先行タスク
    private List<Task> successors; // 後続タスク

    // 初期化用のコンストラクタ
    public Task() {
    }

    // タスクのID、名前、所要日数を指定して初期化するコンストラクタ
    public Task(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.predecessors = new ArrayList<>();
        this.successors = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public List<Task> getPredecessors() {
        return predecessors;
    }

    public List<Task> getSuccessors() {
        return successors;
    }

    public void addPredecessor(Task task) {
        this.predecessors.add(task);
    }

    public void addSuccessor(Task task) {
        this.successors.add(task);
    }

    // タスクの情報を文字列として返すためのtoStringメソッド
    @Override
    public String toString() {
        return id + " (" + name + ", " + duration + "日)";
    }
}
