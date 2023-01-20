
import java.util.Scanner;
import java.util.Random;

public class MillionaireGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        boolean nextQ = true;
        int level = 1;
        int i = 0;
        boolean[] chosen = {true,false,false,false,false,false,false,false,false
          ,false,false,false,false,false,false,false,false,false,false,false,false
          ,false,false,false,false,false,false,false,false,false,false};
        int userResponce = 0;
        int answer = 0;
        int userAnswer = -1;

        boolean availableHalf = true;
        boolean availableFriend = true;
        boolean availableAudience = true;
        while (!done) {
            if (level == 16) {
                done = true;
                System.out.println("Congratulations! You are a millionaire!");
            } else {
                if (nextQ) {
                    getWinnings(level);
                    int max = 30;
                    int min = 1;
                    int range = max - min + 1;
                    i = (int)(Math.random() * range) + min;
                    while (chosen[i] == true) {
                        i = (int)(Math.random() * range) + min;
                    }
                    chosen[i]= true;
                }
                System.out.println("");
                System.out.println("level: " + level);
                answer = displayQuestion(i);
                displayMenu();
                userResponce = input.nextInt();
            }
            if(!done){
                if (userResponce==1){
                    System.out.println("OK. Please provide answer (1-4): ");
                    System.out.println("Answer is: " + answer);
                    userAnswer = input.nextInt();
                    if (userAnswer==answer){
                        System.out.println("Correct!");
                        System.out.println("You curently have: $" + getWinnings(level));
                        level++;
                        nextQ = true;
                        answer = 0;
                    } else {
                        done = true;
                        if (level>10){
                            System.out.println("Sorry, that is incorrect. You won: $32000");
                        } else if (level>5){
                            System.out.println("Sorry, that is incorrect. You won: $1000");
                        }else{
                            System.out.println("Sorry, that is incorrect. You lost");
                        }
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
                    if (availableFriend){
                        System.out.println("Ask a friend Lifeline");
                        provideHint(answer);
                        availableFriend = false;
                        nextQ = false;
                    } else {
                        System.out.println("You have already used this lifeline");
                        nextQ = false;
                    }
                  }
                  else if (userResponce==4) {
                    if (availableAudience){
                        System.out.println("Ask a audience Lifeline");
                        provideHint(answer);
                        availableAudience = false;
                        nextQ = false;
                    } else {
                        System.out.println("You have already used this lifeline");
                        nextQ = false;
                    }
                  }
                  else if (userResponce==5) {
                    nextQ = false;
                    done = true;
                    System.out.println("Bye. You won: $" + getWinnings(level-1));
                  }else{
                    System.out.println("Invalid input. Please try again");
                    nextQ = false;
                  }
            }
            }
    }
        public static void displayMenu(){
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
            //make loop that generate numbers until 2 are different from answer
            while (true) {
                Random r = new Random();
                int i = r.nextInt(4-1+1)+1;
                int j = r.nextInt(4-1+1)+1;
                if (i!=answer && j!=answer && i!=j){
                    System.out.println("HINT: Answer is " + i + " is wrong");
                    System.out.println("HINT: Answer is " + j + " is wrong");
                    break;
                }
            }
        }

        public static void provideHint(int answer){
            //hint have 75% chance of being correct
            Random r = new Random();
            int j;
            int i;
            i = r.nextInt(4-1+1)+1;
            j = r.nextInt(4-1+1)+1;
            while (j==answer ) {
                j = r.nextInt(4-1+1)+1;
            }
            if (i==1 || i==2 || i==3){
                System.out.println("HINT: Answer is " + answer);
            } else {
                System.out.println("HINT: Answer is " + j);
            }
        }

        public static int displayQuestion(int i){
            int answer = 0;
            if (i==1){
                System.out.println("What is the capitol of France?");
                System.out.println("Paris *");
                System.out.println("Nice");
                System.out.println("Marseille");
                System.out.println("Toulouse");
                answer=1;
            }
                //Venezuela,Colombia,Egypt,Nigeria,South Africa,Pakistan,India,Finland,Spain,Peru,Mexio,South Korea,Brazil,Germany,Hungary,Czech Republic,Australia,Iran,Estonia,Latvia,Lithuania,China,Japan,Ukraine,United States,Poland,Canada,Italy
            else if (i==2){
                System.out.println("What is the capitol of Venezuela?");
                System.out.println("Caracas *");
                System.out.println("Maracaibo");
                System.out.println("Barquisimeto");
                System.out.println("Valencia");
                answer=1;
            }
            else if (i==3){
                System.out.println("What is the capitol of Colombia?");
                System.out.println("Bogota *");
                System.out.println("Medellin");
                System.out.println("Cali");
                System.out.println("Barranquilla");
                answer=1;
            }
            else if (i==4){
                System.out.println("What is the capitol of Egypt?");
                System.out.println("Cairo *");
                System.out.println("Alexandria");
                System.out.println("Giza");
                System.out.println("Shubra El Kheima");
                answer=1;
            }
            else if (i==5){
                System.out.println("What is the capitol of Nigeria?");
                System.out.println("Abuja *");
                System.out.println("Lagos");
                System.out.println("Kano");
                System.out.println("Ibadan");
                answer=1;
            }
            else if (i==6){
                System.out.println("What is the capitol of South Africa?");
                System.out.println("Pretoria *");
                System.out.println("Johannesburg");
                System.out.println("Cape Town");
                System.out.println("Durban");
                answer=1;
            }
            else if (i==7){
                System.out.println("What is the capitol of Pakistan?");
                System.out.println("Islamabad *");
                System.out.println("Karachi");
                System.out.println("Lahore");
                System.out.println("Faisalabad");
                answer=1;
            }
            else if (i==8){
                System.out.println("What is the capitol of India?");
                System.out.println("New Delhi *");
                System.out.println("Mumbai");
                System.out.println("Kolkata");
                System.out.println("Bangalore");
                answer=1;
            }
            else if (i==9){
                System.out.println("What is the capitol of Finland?");
                System.out.println("Helsinki *");
                System.out.println("Espoo");
                System.out.println("Tampere");
                System.out.println("Vantaa");
                answer=1;
            }
            else if (i==10){
                System.out.println("What is the capitol of Spain?");
                System.out.println("Madrid *");
                System.out.println("Barcelona");
                System.out.println("Valencia");
                System.out.println("Seville");
                answer=1;
            }
            else if (i==11){
                System.out.println("What is the capitol of Peru?");
                System.out.println("Lima *");
                System.out.println("Arequipa");
                System.out.println("Trujillo");
                System.out.println("Chiclayo");
                answer=1;
            }
            else if (i==12){
                System.out.println("What is the capitol of Mexico?");
                System.out.println("Mexico City *");
                System.out.println("Guadalajara");
                System.out.println("Ecatepec de Morelos");
                System.out.println("Puebla");
                answer=1;
            }
            else if (i==13){
                System.out.println("What is the capitol of South Korea?");
                System.out.println("Seoul *");
                System.out.println("Busan");
                System.out.println("Incheon");
                System.out.println("Daegu");
                answer=1;
            }
            else if (i==14){
                System.out.println("What is the capitol of Brazil?");
                System.out.println("Brasilia *");
                System.out.println("Sao Paulo");
                System.out.println("Rio de Janeiro");
                System.out.println("Salvador");
                answer=1;
            }
            else if (i==15){
                System.out.println("What is the capitol of Germany?");
                System.out.println("Berlin *");
                System.out.println("Hamburg");
                System.out.println("Munich");
                System.out.println("Cologne");
                answer=1;
            }
            else if (i==16){
                System.out.println("What is the capitol of Hungary?");
                System.out.println("Budapest *");
                System.out.println("Debrecen");
                System.out.println("Szeged");
                System.out.println("Miskolc");
                answer=1;
            }
            else if (i==17){
                System.out.println("What is the capitol of Czech Republic?");
                System.out.println("Prague *");
                System.out.println("Brno");
                System.out.println("Ostrava");
                System.out.println("Plzen");
                answer=1;
            }
            else if (i==18){
                System.out.println("What is the capitol of Australia?");
                System.out.println("Canberra *");
                System.out.println("Sydney");
                System.out.println("Melbourne");
                System.out.println("Brisbane");
                answer=1;
            }   
            else if (i==19){
                System.out.println("What is the capitol of Iran?");
                System.out.println("Tehran *");
                System.out.println("Mashhad");
                System.out.println("Esfahan");
                System.out.println("Tabriz");
                answer=1;
            }
            else if (i==20){
                System.out.println("What is the capitol of Estonia?");
                System.out.println("Tallinn *");
                System.out.println("Tartu");
                System.out.println("Narva");
                System.out.println("Parnu");
                answer=1;
            }
            else if (i==21){
                System.out.println("What is the capitol of Latvia?");
                System.out.println("Riga *");
                System.out.println("Daugavpils");
                System.out.println("Liepaja");
                System.out.println("Jelgava");
                answer=1;
            }
            else if (i==22){
                System.out.println("What is the capitol of Lithuania?");
                System.out.println("Vilnius *");
                System.out.println("Kaunas");
                System.out.println("Klaipeda");
                System.out.println("Siauliai");
                answer=1;
            }
            else if (i==23){
                System.out.println("What is the capitol of China?");
                System.out.println("Beijing *");
                System.out.println("Shanghai");
                System.out.println("Guangzhou");
                System.out.println("Shenzhen");
                answer=1;
            }
            else if (i==24){
                System.out.println("What is the capitol of Japan?");
                System.out.println("Tokyo *");
                System.out.println("Yokohama");
                System.out.println("Osaka");
                System.out.println("Nagoya");
                answer=1;
            }
            else if (i==25){
                System.out.println("What is the capitol of Ukraine?");
                System.out.println("Kiev *");
                System.out.println("Kharkiv");
                System.out.println("Dnipro");
                System.out.println("Odessa");
                answer=1;
            }
            else if (i==26){
                System.out.println("What is the capitol of United States?");
                System.out.println("Washington, D.C. *");
                System.out.println("New York City");
                System.out.println("Los Angeles");
                System.out.println("Chicago");
                answer=1;
            }
            else if (i==27){
                System.out.println("What is the capitol of Poland?");
                System.out.println("Warsaw *");
                System.out.println("Krakow");
                System.out.println("Lodz");
                System.out.println("Wroclaw");
                answer=1;
            }
            else if (i==28){
                System.out.println("What is the capitol of Canada?");
                System.out.println("Ottawa *");
                System.out.println("Toronto");
                System.out.println("Montreal");
                System.out.println("Calgary");
                answer=1;
            }
            else if (i==29){
                System.out.println("What is the capitol of Italy?");
                System.out.println("Rome *");
                System.out.println("Milan");
                System.out.println("Naples");
                System.out.println("Turin");
                answer=1;
            }
            else if (i==30){
                System.out.println("What is the capitol of Chile?");
                System.out.println("Santiago *");
                System.out.println("Valparaiso");
                System.out.println("Concepcion");
                System.out.println("Antofagasta");
                answer=1;
            }
              return (answer);
        }
}