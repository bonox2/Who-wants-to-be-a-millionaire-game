
import java.util.Scanner;
import java.util.Random;

public class MillionaireGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        boolean done = false;
        boolean nextQ = true;
        int level = 0;
        int i = r.nextInt(30-1+1)+1;
        boolean[] chosen = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
        int userResponce = 0;
        int answer = 0;
        int userAnswer = 0;

        boolean availableHalf = true;
        while (done == false) {
            if (level > 14) {
                System.out.println("Congratulations! You are a millionaire");
                done = true;
            } else {
                if (nextQ) { // write code that chesck if nextQ is true
                    level++; // increment level
                    getWinnings(level);
                    i = r.nextInt(4-1+1)+1;
                    while (chosen[i]) {
                        i = r.nextInt(4-1+1)+1;
                    }
                    chosen[i]= true;
                }
                System.out.println("");
                System.out.println("level: " + level);
                answer = displayQuestion(i);
                displayMenu();
            }
            userResponce = input.nextInt();
            if (userResponce==1){
                System.out.println("OK. Please provide answer (1-4): ");
                System.out.println("Answer is: " + answer);
                userAnswer = input.nextInt();
                if (userAnswer==answer){
                    System.out.println("Correct!");
                    System.out.println("You curently have: $" + getWinnings(level));
                    nextQ = true;
                } else {
                    done = true;
                    System.out.println("Sorry, that is incorrect. You won: $" + getWinnings(level));
                }
              } else if (userResponce==2) {
                    if (availableHalf){
                        remove2Wrong(answer);
                        availableHalf = false;
                        nextQ = false;
                    } else {
                        System.out.println("You have already used this lifeline");
                        nextQ = false;
                    }
              }
              else if (userResponce==3) {
                provideHint(answer);
              }
              else if (userResponce==4) {
                
              }
              else if (userResponce==5) {
                
              }
        }
    }
        public static void displayMenu(){
            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("1. Answer the question");
            System.out.println("2. Use 50/50 Lifeline");
            System.out.println("3. Ask a friend Lifeline");
            System.out.println("4. Ask the audience Lifeline");
            System.out.println("5. Quit");
        }
        public static double getWinnings(int level){
            double prize = 0;
            switch (level) {
                case 1:
                    prize = 100;
                    break;
                case 2:
                    prize = 200;
                    break;
                case 3:
                    prize = 300;
                    break;
                case 4:
                    prize = 500;
                    break;
                case 5:
                    prize = 1000;
                    break;
                case 6:
                    prize = 2000;
                    break;
                case 7:
                    prize = 4000;
                    break;
                case 8:
                    prize = 8000;
                    break;
                case 9:
                    prize = 16000;
                    break;
                case 10:
                    prize = 32000;
                    break;
                case 11:
                    prize = 64000;
                    break;
                case 12:
                    prize = 125000;
                    break;
                case 13:
                    prize = 250000;
                    break;
                case 14:
                    prize = 500000;
                    break;
                case 15:
                    prize = 1000000;
                    break;
                default:
                    break;
            }
            return prize;
        }

        public static void remove2Wrong(int answer){
            System.out.println("Use 50/50 Lifeline");
            System.out.println("");
            int wrong= 0;
            int i = 0;
            while ( i<2){
                while (wrong!=answer) {
                    wrong = (int)(Math.random()*4+1);
                    
                System.out.println("HINT: The answer "+ wrong + " is wrong");
                }
                i++;
            }
        }

        public static void provideHint(int answer){
            //provide a hint with 75% chance of being correct

        }

        public static int displayQuestion(int i){
            int answer = 0;
            if (i==1){
                System.out.println("Whose image appears on the British 5 pound note?");
                System.out.println("1. Prime Minister Winston Churchill");
                System.out.println("2. Novelist Jane Austen");
                System.out.println("3. Artist J. M. W. Turner");
                System.out.println("4. Computer Scientist Alan Turing");
                answer=1;
                                  
              } else if (i==2) {
                System.out.println("Whose image appears on the British 10 pound note?");
                System.out.println("1. Prime Minister Winston Churchill");
                System.out.println("2. Novelist Jane Austen");
                System.out.println("3. Artist J. M. W. Turner");
                System.out.println("4. Computer Scientist Alan Turing");
                answer=2;
              }else if (i==3) {
                System.out.println("Whose image appears on the British 20 pound note?");
                System.out.println("1. Prime Minister Winston Churchill");
                System.out.println("2. Novelist Jane Austen");
                System.out.println("3. Artist J. M. W. Turner");
                System.out.println("4. Computer Scientist Alan Turing");
                answer=3;
              }else if (i==4) {
                System.out.println("Whose image appears on the British 50 pound note?");
                System.out.println("1. Prime Minister Winston Churchill");
                System.out.println("2. Novelist Jane Austen");
                System.out.println("3. Artist J. M. W. Turner");
                System.out.println("4. Computer Scientist Alan Turing");
                answer=4; 
              }
              return (answer);
        }
}