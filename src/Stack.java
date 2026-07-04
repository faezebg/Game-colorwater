public class Stack {
    public Node<String> topColor;
    public int size;
    boolean selectedBottle = false;

    public Stack(int size) {
        this.topColor = null;
        this.size = 0;
    }
    public boolean isEmpty(String s){
        int r = 0;
        Node<String> q = topColor;
        while (q.next != null){
            if (!q.equals(s))
               return false;
        }
        return true;
    }
    public boolean isFull(int x){
        int r = 0;
        Node<String> q = topColor;
        while (q.next != null){
            r++;
            q = q.next;
        }
        if(r == x)
            return true;
        else
            return false;
    }

    public void push(String color){
        Node<String> q = null;
        q.data = color;
        q.next = null;
        if(topColor != null){
            topColor = q;
        }
        else{
            q.next = topColor;
            topColor = q;
        }

    }
    public String pop(){
       String x = topColor.data;
       topColor = topColor.next;
       return x;
    }


}
