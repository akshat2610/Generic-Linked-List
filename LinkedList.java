package linked;

public class LinkedList<T>{
	private Node<T> 	head;
	private Node<T>		tail;
	private int 		size;

	private class Node<T>{
		private T 		data;
		private Node<T>	next;

		Node(T data){
			this.data 	= data;
			next 		= null;
		}

		void set_next(Node<T> next) {
			this.next 	= next;
		}
		Node<T> get_next(){
			return next;
		}
		T get_data() {
			return data;
		}
	}

	public LinkedList() {
		head 			= null;
		tail 			= null;
	}

	//Helper method
	private Node<T> find(T data){
		Node<T> temp 		= head;	

		while (temp != null && !temp.get_data().equals(data))
			temp 			= temp.get_next();

		if (temp == tail && !temp.get_data().equals(data))
			return null;
		
		return temp;		
	}

	public void print() {
		if (head == null) {
			System.out.println("Head is null");
			System.out.println("Tail is null");

			return;
		}

		Node<T> temp 		= head;

		System.out.println("Head is " + head.get_data());
		System.out.println("Tail is " + tail.get_data());
		System.out.println("*******************");
		while (temp != null) {
			System.out.println(temp.get_data());
			temp 			= temp.get_next();
		}
		System.out.println("___________________");
	}

	public Node<T> get_head(){
		return head;
	}

	public Node<T> get_tail(){
		return tail;
	}

	public int get_size() {
		return size;
	}
	
	/**
	 * Appends the data at the end of the list. If list is empty, creates a new node and sets heads equal to it
	 * @param data
	 * @return true if data is not null. 
	 */
	public boolean append(T data) {
		if (data == null)
			return false;

		Node<T> new_node = new Node<>(data);

		//if list is empty, set both head and tail to this new node
		if (null == head) {
			head 		 = new_node;
			tail		 = new_node;
		}

		//else if list is not empty, vanilla append.
		else {
			tail.set_next(new_node);
			new_node.set_next(null);
			tail = new_node;
		}

		size++;
		return true;
	}

	/**
	 * Returns the node containing the required data. If not found, it returns null
	 * @param data
	 * @return node containing data equal to argument data or null.
	 */
	public Node<T> search(T data){
		return find(data);
	}

	/**
	 * Inserts a new node with data == new_data after the node with data == data.
	 * @param data
	 * @param new_data
	 * @return true if insertion is successful. Else, return false
	 */
	public boolean insert_after(T data, T new_data) {
		Node<T> node = find(data);

		if (null == node)
			return false;
		
		else if (node == tail) {
			Node<T> new_node= new Node<>(new_data);
			tail.set_next(new_node);
			tail = new_node;
		}
		
		else {
		Node<T> old_next 	= node.get_next();
		Node<T> new_node 	= new Node<>(new_data);
		node.set_next(new_node);
		new_node.set_next(old_next);
		}

		size++;
		return true;
	}

	/**
	 * Inserts a new node with data == new_data before the node with data == data.
	 * @param data
	 * @param new_data
	 * @return true if insertion is successful. Else, return false
	 */
	public boolean insert_before(T data, T new_data) {
		//with singly linked list, this might cause a problem because we will have to code the same algorithm as that of find() with
		//a minor modification where it returns the node before the node with data == data. The problem arises because we do not have a 
		//previous reference. 
		Node<T> temp 		= head;
		Node<T>	before_temp = head;

		//if insertion needs to be before the head
		if (head.get_data().equals(data)) {
			Node<T> new_node= new Node<>(new_data);
			new_node.set_next(head);
			head 			= new_node;

			size++;
			return true;
		}

		while (temp != null && !temp.get_data().equals(data)) {
			before_temp		= temp;
			temp 			= temp.get_next();
		}

		if (temp == null)
			return false;

		Node<T> old_next 	= before_temp.get_next();
		Node<T> new_node 	= new Node<>(new_data);
		before_temp.set_next(new_node);
		new_node.set_next(old_next);

		size++;
		return true;
	}
	
	/**
	 * deletes the node with data == argument data
	 * @param data
	 * @return the deleted node if it existed in the list otherwise returns null.
	 */
	public Node<T> delete(T data){
		Node<T> node  		= find(data);
		if (null == node)
			return null;

		Node<T> temp 		= head;

		if (head.get_data().equals(data))
			head 			= head.get_next();

		else {
			while (temp != tail && !temp.get_next().get_data().equals(data))
				temp			= temp.get_next();

			if (tail.get_data().equals(data)) {
				tail		= temp;
				tail.set_next(null);
			}
			else
				temp.set_next(node.get_next());
		}
		size--;
		return node;
	}
}
