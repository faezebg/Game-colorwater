import java.util.Scanner;

public class Main {
    public static int MaxBottleSize;
    public static String[] colors;
    public static int N = 0;
    public static String s = "";

    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
//        System.out.println("Are you ready?");
//         do
//             s = n.next();
//        while(!s.equals("start"));

        System.out.println("Enter the colors you want:");
        colors = n.nextLine().split(" ");

        System.out.println("Enter the Max size of Bottles:");
        MaxBottleSize = n.nextInt();

        WaterSortGame waterSortGame = new WaterSortGame(colors , MaxBottleSize);
        for(int i = 0 ; i< colors.length ; i++){
            waterSortGame.colors[i] = colors[i];
        }
        String order = "";
        while(true) {
            waterSortGame.display();
            order = n.next();

            switch (order) {
                case "select":
                    int bottleNumber = n.nextInt();
                    waterSortGame.select(bottleNumber);
                    System.out.println("you selected" + waterSortGame.select);
                    break;
                case "nextSelect":
                    waterSortGame.selectNext();
                    System.out.println("you selected next bottle"+ waterSortGame.select);
                    break;
                case "deSelect":
                    waterSortGame.deselect();
                    System.out.println("you deselected"+ waterSortGame.select);
                    break;
                case "selectPrev":
                    waterSortGame.selectPrev();
                    System.out.println("you selected previous bottle"+ waterSortGame.select);
                    break;
                case "pour":
                    int bottleNumber2 = n.nextInt();
                    waterSortGame.pour(bottleNumber2);
                    System.out.println("you played");
                    break;
                case "swap":
                    int bottleNumber3 = n.nextInt();
                    waterSortGame.swap(bottleNumber3);
                    System.out.println("you replaced" + waterSortGame.select + "and" + bottleNumber3);
                    break;
                case "replaceColor":
                    String firstColor = n.next();
                    String secondColor = n.next();
                    waterSortGame.replaceColor(firstColor , secondColor);
                    System.out.println("you replaced" + firstColor + "with" + secondColor);
                    break;
                case "addEmptyBottle":
                    waterSortGame.aadEmptyColor();
                    System.out.println("you use your chance");
                    break;
                case "hasWon":
                    if (waterSortGame.hasWon() == true)
                        System.out.println("you win");
                    else
                        System.out.println("you dont win");
                    break;
                case "undo":
                    waterSortGame.undo();
                    break;
                case "redo":
                    waterSortGame.redo();
                    break;
            }
        }

    }
}
