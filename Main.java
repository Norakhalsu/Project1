
import java.util.*;

public class Main {

        static ArrayList<Integer> humanplace = new ArrayList<Integer>();
        static ArrayList<Integer> computerplace = new ArrayList<Integer>();
        public static void main(String[] args) {
            char[][] TicTacGame = {{' ', '|', ' ', '|', ' '},
                    {'-', '-', '-', '-', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '-', '-', '-', '-'},
                    {' ', '|', ' ', '|', ' '}};
                     show(TicTacGame);

            try {

                while (true) {
                   // int round=RoundGame();
                Scanner scanner = new Scanner(System.in);
                System.out.println("chose your place [from 1 to 9] ");
                   int chose = scanner.nextInt();
                while (humanplace.contains(chose) || computerplace.contains(chose)) {
                    System.out.println(" already taken, chose another place ");
                    chose = scanner.nextInt(); }

                choseCase("Human", chose,TicTacGame );
                String result = determinWinner();
                if (result.length() > 0) {
                    System.out.println("End The game: "+result);
                    break; }
               // generate random number
                Random rand = new Random();
                int computer = rand.nextInt(9) + 1;
                while (humanplace.contains(computer) || computerplace.contains(computer)) {
                computer = rand.nextInt(9) + 1;
                }
                choseCase("Computer", computer,TicTacGame );
                show(TicTacGame);
                result = determinWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }
                }
            }
        catch (InputMismatchException e){
            System.out.println("Wrong input , enter a number ");
        }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        public static void choseCase(String player, int chose, char[][] TicTacGame) throws Exception{
            char xo = ' ';
            if (player.equals("Human")) {
                xo='x';
                humanplace.add(chose);
            } else if (player.equals("Computer")) {
                xo='o';
                computerplace.add(chose); }

            switch (chose) {
                case 1:
                    TicTacGame[0][0] = xo;
                    break;
                case 2:
                    TicTacGame[0][2] = xo;
                    break;
                case 3:
                    TicTacGame[0][4] = xo;
                    break;
                case 4:
                    TicTacGame[2][0] = xo;
                    break;
                case 5:
                    TicTacGame[2][2] = xo;
                    break;
                case 6:
                    TicTacGame[2][4] = xo;
                    break;
                case 7:
                    TicTacGame[4][0] = xo;
                    break;
                case 8:
                    TicTacGame[4][2] = xo;
                    break;
                case 9:
                    TicTacGame[4][4] = xo;
                    break;
                default:
                    break;
            }
        if (chose > 9 || chose <1){
            throw new Exception("the number must between 1 and 9 ");
        }
        }
        public static String determinWinner() {
            List<Integer> fristRow = Arrays.asList(1, 2, 3);
            List<Integer> secondRow = Arrays.asList(4, 5, 6);
            List<Integer> lastRow = Arrays.asList(7, 8, 9);
            List<Integer> fristColom = Arrays.asList(1, 4, 7);
            List<Integer> secondColom = Arrays.asList(2, 5, 8);
            List<Integer> lastcolom = Arrays.asList(3, 6, 9);
            List<Integer> fristdigonal = Arrays.asList(1, 5, 9);
            List<Integer> seconddigonal = Arrays.asList(7, 5, 3);
            List<List<Integer>> winWay = new ArrayList<>();
            winWay.add(fristRow);
            winWay.add(secondRow);
            winWay.add(lastRow);
            winWay.add(fristColom);
            winWay.add(secondColom);
            winWay.add(lastcolom);
            winWay.add(fristdigonal);
            winWay.add(seconddigonal);



                for (List<Integer> way : winWay) {
                if (humanplace.containsAll(way)) {
                    return " you are the Winner ! ";
                }
                else if (computerplace.containsAll(way)) {
                    return " computer The winner ";
                }
                else if (humanplace.size()+computerplace.size()==9) {
                    return " tie!";
                }
                }
            return "";
        }



        public static void show(char[][] Game) {
            for (char[] currentRow : Game) {
                for (char character : currentRow) {
                    System.out.print(character);
                } System.out.println();
            }
        }

//    public static int RoundGame() throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Do you want 1 or 3 rounds?");
//        int round;
//        try {
//            round = scanner.nextInt();
//        } catch (InputMismatchException e) {
//            System.out.println("Wrong input, enter a number.");
//            return RoundGame();
//        }
//        if (round == 1 || round == 3) {
//            return round;
//        } else {
//            throw new Exception("The game has only 1 or 3 rounds.");
//        }







    }




