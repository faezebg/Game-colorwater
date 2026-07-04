import java.util.Random;
public class WaterSortGame {
    int pourUndo;
    int pourUndoSelect;
    int Undo = 0;
    String f = "";
    String s = "";
    public int U = 0;
    public Number number;
    public static int check = 0;
    public int MaxBottleSize;
    public String[] colors;
    public int N ;
    public int select;
    public Node<Integer> p = null;

    Random rand = new Random();
    public WaterSortGame(String[] colors , int MaxBottleSize){

        String[] colorsRandom = new String[N * MaxBottleSize];
        int randomSize = colorsRandom.length;
        int k = 0;
        this.colors = colors;
        this.MaxBottleSize = MaxBottleSize;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < MaxBottleSize; j++) {
                colorsRandom[k] = colors[i];
                k++;
            }
        }
        for (int i = 0 ; i< N+1 ; i++){
            number.insert(i , N);
            for(int j = 0; j< MaxBottleSize ; j++){
                p = getNode(i);
                k = rand.nextInt(randomSize);
                p.up.push(colorsRandom[k]);
                colorsRandom[k] = colorsRandom[randomSize - 1];
                randomSize --;
            }
        }
   }
    //*************************************
    public Node<Integer> getNode(int x){
        p = number.last;
        Node<Integer> temp = null;
        while (p.next != p){
            if(p.data == x){
                temp = p;
            }
        }
        return temp;
    }
    public Node<Integer> getSelected(){
        p = number.last;
        Node<Integer> temp = null;
        while (p.next != p){
            if(p.up.selectedBottle == true){
                temp = p;
            }
        }
        return temp;
    }
    public void getColor(int x){
        p = number.last;
        Node<String> color = p.up.topColor;
        int n = 0;
        while (n != x) {
            while (p.next!= p){
                try {
                    System.out.println(color + " ");
                }catch (NullPointerException exception){
                    System.out.println("Empty");
                }
                System.out.println('\n');
            }
            color = color.next;
            n++;
        }
    }
    public boolean doneBottle(int bottleNumber) { // چک مبکنه بطری کامل شده یا نه
        int sameColor = 1;
        p = getNode(bottleNumber);
        Node<String> temp = p.up.topColor;
        while(temp.next != null) {
            if (temp.data == temp.next.data) {
                sameColor++;
            }
            temp = temp.getNext();
        }
        if (sameColor == MaxBottleSize) {
            return true;
        }
        else return false;
    }
    //********************************
    public void display(){
        getColor( MaxBottleSize);
        for (int i = 1 ; i<= N +1 ; i++){
            if(getNode(i).up.selectedBottle == true)
                System.out.println("--#--");
            else System.out.println("     ");
        }
    }
    //**********************************
    public boolean select(int bottleNumber){
        p = number.last;
        if(p.up == null && doneBottle(bottleNumber) == true) {
            return false;
        }
        while(p.next != p){
            if(p.data == bottleNumber){
                U = 1;
                deselect();
                p.up.selectedBottle = true;
                select = p.data;
                return true;
            }
            p = p.next;
        }
        return false;
    }
    //******************************
    public void deselect(){
        p = number.last;
        while(p.next != p) {
            if (p.up.selectedBottle == true) {
                select = p.data;
                U = 2;
                p.up.selectedBottle = false;
            }
        }
    }
    //******************************
    public void selectNext(){
        p = number.last;
        while(p.next != p){
            if(p.up.selectedBottle == true){
                p.up.selectedBottle = false;
                if(p.next.up.isEmpty("Empty") == true){
                    System.out.println("you cant select");
                    return;
                }
                p = p.next;
                U = 3;
                p.up.selectedBottle = true;
                select = p.data;
            }
        }
    }
    //*******************************
    public void selectPrev(){
        p = number.last;
        while(p.next != p){
            if(p.up.selectedBottle == true){
                p.up.selectedBottle = false;
                if(p.prev.up.isEmpty("Empty") == true){
                    System.out.println("you cant select");
                    return;
                }
                p = p.prev;
                U = 4;
                p.up.selectedBottle = true;
                select = p.data;
            }
        }

    }
    //*******************************
    public boolean pour(int bottleNumber){
        pourUndo = bottleNumber;
        pourUndoSelect = getSelected().data;
        boolean full = false;
        Stack stack1 = new Stack(N);
        Stack stack2 = new Stack(N);
        Node<String> color = stack2.topColor;
        p = number.last;
        while(p.next != p){
            if(p.up.selectedBottle == true){
                stack1 = p.up;
            }
            if(p.data == bottleNumber){
                if(p.data == N + 2)
                    full =stack2.isFull(N/2);
                else
                    full = stack2.isFull(N);
                stack2 = p.up;
            }
        }

        while (color.next != null){
            if(stack1.topColor.equals(color) && full!=true || stack2.isEmpty("Empty")){
                stack1.push(color.data);
                stack2.pop();
            }
            color = color.next;
        }
        if(Undo == 1){
            stack2.push(color.data);
            stack1.pop();
        }
        U = 5;
        return true;
    }
    //*********************************
    public void swap(int bottleNumber){
        Undo = bottleNumber;
      Stack t;
        p = number.last;
        t = getNode(bottleNumber).up;
        getNode(bottleNumber).up = getSelected().up;
        getSelected().up = t;
        U = 6;
    }
   //***********************************
    public void replaceColor(String firstColor , String secondColor){
         f = firstColor ;
         s = secondColor ;
        p = number.last;
        Node<String> c = p.up.topColor;
        for(int i = 0 ; i < N ; i++){
            if (colors[i].equals(secondColor)){
                return ;
            }
        }
        while (p.next != p) {
            while (c.next != null) {
                if (c.data.equals(firstColor)) {
                    c.data = secondColor;
                }
                c = c.next;
            }
            p = p.next;
        }
        U = 7;
    }
    //**********************************
    public void aadEmptyColor(){
        if(check == 0) {
            number.insert(N+1 ,(N - 1 )/2);
        }
         check = 1;
        U = 8;
    }
    //*********************************
    public boolean hasWon(){
        int w = 0;
        for(int i = 0 ; i< N + 1 ; i++){
            if(doneBottle(i) == true)
                w ++;
        }
        if(w == MaxBottleSize)
            return true;
        return false;
    }
    //**************************
    public void undo(){
        switch (U){
            case 1:
                deselect();
                break;
            case 2:
                select(select);
                break;
            case 3:
                selectPrev();
                break;
            case 4:
                selectNext();
                break;
            case 5:
                Undo = 1;
                select(pourUndo);
                pour(pourUndoSelect);
                select(pourUndoSelect);
                break;
            case 6:
                swap(Undo);
                break;
            case 7:
                replaceColor(s , f );
            case 8:
                number.delete();
                break;
        }

    }
    //**********************************
    public void redo(){
        switch (U){
            case 1:
                select(select);
                break;
            case 2:
                deselect();
                break;
            case 3:
                selectNext();
                break;
            case 4:
                selectPrev();
                break;
            case 5:
                pour(pourUndo);
                break;
            case 6:
                swap(Undo);
                break;
            case 7:
                replaceColor(f , s);
                break;
            case 8:
                aadEmptyColor();
                break;
        }


    }
}
