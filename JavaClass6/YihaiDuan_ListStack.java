package assignment6;

public class ListStack<T>  implements MyStack <T>{
	private static final int MAX_NUM = 100;
	private class myNode{
		public T value;
		public myNode next;
		public myNode() {
		}
		public myNode(T t) {
			this.value = t;
		}
	}
	private myNode node = new myNode();

	private int num;
	private myNode nodeTemps;
	public ListStack() {
		num = 0;
		node.value = null;
		node.next = null;
	}
	@Override
	public boolean isEmpty() {
		return num == 0;
	}

	@Override
	public T peek() {
		myNode nodeTemp = this.node;
		while (nodeTemp.next != null) {
			nodeTemp = nodeTemp.next;
		}
		return  nodeTemp.value;
	}

	@Override
	public void push(T c) {
		if(num == MAX_NUM)
			return;
		myNode nodeTemp = this.node;	
		while (nodeTemp.next != null)
			nodeTemp = nodeTemp.next;
		myNode newNode = new myNode(c);
//		System.out.println("push " + newNode.value);
		nodeTemp.next = newNode;
		num++;
		return;
	}

	@Override
	public T pop() {
		if(this.isEmpty())
			return (T) null;
		myNode nodeTemp = this.node;
		while (nodeTemp.next.next != null)
			nodeTemp = nodeTemp.next;
		T pop = nodeTemp.next.value;
		nodeTemp.next = null;
		num--;
		//System.out.println("pop "+ pop);
		return pop;
	}
	
}
