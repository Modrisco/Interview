/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode curr = listNode;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        while (!stack.isEmpty()) {
            nodes.add(stack.pop());
        }
        return nodes;
    }
}
