class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev ;
    Stack up ;

    public Node(T data) {
        setData(data);
        setNext(null);
        setPrev(null);
        setUp(null);
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node<T> getNext() {
        return next;
    }

    public void setPrev(Node<T> prev){
        this.prev = prev;
    }
    public Node<T> getPrev(){
        return prev;
    }
    public void setUp(Stack up) {
        this.up = up;
    }
    public Stack getUp() {
        return up;
    }

}
