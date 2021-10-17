package chapter09;

import java.util.Comparator;

/**
 * Node
 * Created by park on 2021/10/13.
 */
class Node implements Comparator<Node> {

  private int index;
  private int distance;

  public Node(int index, int distance) {
    this.index = index;
    this.distance = distance;
  }

  public int getIndex() {
    return this.index;
  }

  public int getDistance() {
    return this.distance;
  }

  // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
  @Override
  public int compare(Node node1, Node node2) {
//    return Integer.compare(node1.distance, node2.distance);

    if (node1.distance < node2.distance) {
      return -1;
    } else if (node1.distance == node2.distance) {
      return 0;
    } else {
      return 1;
    }
  }

}