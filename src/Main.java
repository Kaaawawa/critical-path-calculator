import java.util.*;

import main.java.graph.ProjectGraph;
import main.java.model.Task;

public class Main {
    public static void main(String[] args) {
        ProjectGraph graph = new ProjectGraph();

        graph.addTask("A", "要件定義", 3);
        graph.addTask("B", "画面設計", 5);
        graph.addTask("C", "DB設計", 4);
        graph.addTask("D", "実装", 6);

        graph.addDependency("A", "B");
        graph.addDependency("A", "C");
        graph.addDependency("B", "D");
        graph.addDependency("C", "D");

        for (Task task : graph.getAllTasks()) {
            System.out.println(task);
            System.out.println("  先行タスク: " + task.getPredecessors());
            System.out.println("  後続タスク: " + task.getSuccessors());
        }
    }
}
    //     // グラフ: A -> B, A -> C, B -> D, C -> D
    //     Map<String, List<String>> graph = new HashMap<>();
    //     graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
    //     graph.put("B", new ArrayList<>(Arrays.asList("D")));
    //     graph.put("C", new ArrayList<>(Arrays.asList("D")));
    //     graph.put("D", new ArrayList<>());

    //     List<String> result = topologicalSort(graph);
    //     System.out.println(result); // 例: [A, B, C, D] または [A, C, B, D]
    // }

    // public static List<String> topologicalSort(Map<String, List<String>> graph) {
    //     Map<String, Integer> indegree = new HashMap<>();

    //     // 全ノードの入次数を0で初期化
    //     for (String node : graph.keySet()) {
    //         indegree.put(node, 0);
    //     }

    //     // 各辺を見て、行先ノードの入次数を増やす
    //     for (String node : graph.keySet()) {
    //         for (String neighbor : graph.get(node)) {
    //             indegree.put(neighbor, indegree.get(neighbor) + 1);
    //         }
    //     }

    //     // 入次数が0のノードをキューに追加
    //     Queue<String> queue = new LinkedList<>();
    //     for (String node : indegree.keySet()) {
    //         if (indegree.get(node) == 0) {
    //             queue.offer(node);
    //         }
    //     }

    //     // 順番に取り出して結果へ追加し、隣接ノードの入次数を減らす
    //     List<String> result = new ArrayList<>();
    //     while (!queue.isEmpty()) {
    //         String node = queue.poll();
    //         result.add(node);

    //         // 隣接ノードの入次数を減らす
    //         for (String neighbor : graph.get(node)) {
    //             indegree.put(neighbor, indegree.get(neighbor) - 1);
    //             if (indegree.get(neighbor) == 0) {
    //                 queue.offer(neighbor);
    //             }
    //         }
    //     }

    //     // 結果のサイズがグラフのノード数と一致しない場合、サイクルが存在する
    //     if (result.size() != graph.size()) {
    //         throw new IllegalStateException("このグラフにはサイクルが存在します。トポロジカルソートは不可能です。");
    //     }

    //     return result;