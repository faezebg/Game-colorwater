public class Number {
    public Node<Integer> last;
    Node<Integer> q = null;
    public Number(){
        this.last = null;
    }
    public void insert(int x , int y){
        Stack s = new Stack(y);
        q.data = x;
        q.next = last.next;
        q.prev = last;
        last.next.prev = q;
        last.next = q;
        q.up = s;
    }
    public void delete(){
        Node<Integer> p ;
        q = last;
        p = last.prev;
        p.next = q.next;
        q.next.prev = p;
        last = p;
    }


}
