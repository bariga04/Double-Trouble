import java.util.Scanner;
import java.util.Random;


//Author: Bhargavram Ariga      bariga

/**
 * class that contains variables and method for the game
 */
public class Game {

    int green = 3;
    int yellow = 7;
    int orange = 5;


    public Game(){}

    /**
     * method to run game
     */
    public void runGame(){

        boolean win = false;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Double Trouble!\n");
        System.out.println("The real name of the game used in this program is Nim.\n" +
                "It was solved by Charles L. Bouton around 1901.\n" +
                "Variations of this game have show up in video games like Pokemon Black and White.");
        System.out.println("");
        System.out.println("Do you want to go first? Answer using y/n");

        String answer = keyboard.next().toLowerCase();

        if(answer.equals("n")) {


            while ((green + yellow + orange) > 0) {

                System.out.println("The following markers remain:");
                System.out.println("Yellow: " + yellow + " Green: " + green + " Orange: " + orange);
                System.out.println("My turn! Making a move...");

                if (yellow > (green ^ orange) && (green ^ orange) >= 0) {

                    yellow -= yellow - (green ^ orange);
                }
                else if (green > (yellow ^ orange) && (yellow ^ orange) >= 0) {

                    green -= green - (yellow ^ orange);
                }
                else if (orange > (green ^ yellow) && (green ^ yellow) >= 0) {

                    orange -= orange - (green ^ yellow);
                }

                if(yellow + green + orange == 0) {

                    win = false;
                    continue;
                }

                boolean error = true;

                while(error){

                    System.out.println("Your turn! The following markers remain:");
                    System.out.println("Yellow: " + yellow + " Green: " + green + " Orange: " + orange);
                    System.out.println("Please choose what color you want to pick (case insensitive)");

                    String color = keyboard.next().toLowerCase();

                    if (!color.equals("yellow") && !color.equals("orange") && !color.equals("green")) {

                        System.out.println("That is not an available color, please try again");
                        continue;
                    }



                    System.out.println("Please choose how many you want to take, (Can't take zero or negative markers :))");

                    int num = keyboard.nextInt();

                    if(num <= 0){
                        System.out.println("Stop cheating! Pick again");
                    }
                    else if(color.equals("yellow") && (num > yellow)){
                        System.out.println("There are either no more markers in that color " +
                                "or you picked more markers than there are left. Please try again ");
                    }
                    else if(color.equals("green") && (num > green)){
                        System.out.println("There are either no more markers in that color " +
                                "or you picked more markers than there are left. Please try again ");
                    }
                    else if(color.equals("orange") && (num > orange)){
                        System.out.println("There are either no more markers in that color " +
                                "or you picked more markers than there are left. Please try again ");
                    }
                    else if(color.equals("yellow")){ yellow -= num; error = false;}
                    else if(color.equals("green")){ green -= num; error = false;}
                    else if(color.equals("orange")){ orange -= num; error = false;}

                }

                if(yellow + green + orange == 0) {

                    win = true;
                    continue;
                }
            }
        }


        if(answer.equals("y")) {

            while ((green + yellow + orange) > 0) {

                boolean error = true;

                while(error){

                    System.out.println("Your turn! The following markers remain:");
                    System.out.println("Yellow: " + yellow + " Green: " + green + " Orange: " + orange);
                    System.out.println("Please choose what color you want to pick (case insensitive)");

                    String color = keyboard.next().toLowerCase();

                    if (!color.equals("yellow") && !color.equals("orange") && !color.equals("green")) {

                        System.out.println("That is not an available color, please try again");
                        continue;
                    }



                    System.out.println("Please choose how many you want to take, (Can't take zero or negative markers :))");

                    int num = keyboard.nextInt();

                    if(num <= 0){
                        System.out.println("Stop cheating! Pick again");
                    }
                    else if(color.equals("yellow") && (num > yellow)){
                        System.out.println("There are either no more markers in that color " +
                                "or you picked more markers than there are left. Please try again ");
                    }
                    else if(color.equals("green") && (num > green)){
                        System.out.println("There are either no more markers in that color " +
                                "or you picked more markers than there are left. Please try again ");
                    }
                    else if(color.equals("orange") && (num > orange)){
                        System.out.println("There are either no more markers in that color " +
                                "or you picked more markers than there are left. Please try again ");
                    }
                    else if(color.equals("yellow")){ yellow -= num; error = false;}
                    else if(color.equals("green")){ green -= num; error = false;}
                    else if(color.equals("orange")){ orange -= num; error = false;}

                }

                if(yellow + green + orange == 0) {

                    win = true;
                    continue;
                }

                System.out.println("The following markers remain:");
                System.out.println("Yellow: " + yellow + " Green: " + green + " Orange: " + orange);
                System.out.println("My turn! Making a move...");

                if (yellow > (green ^ orange) && (green ^ orange) >= 0) {

                    yellow -= yellow - (green ^ orange);
                }
                else if (green > (yellow ^ orange) && (yellow ^ orange) >= 0) {

                    green -= green - (yellow ^ orange);
                }
                else if (orange > (green ^ yellow) && (green ^ yellow) >= 0) {

                    orange -= orange - (green ^ yellow);
                }
                else{

                    Random random = new Random();

                    int color = random.nextInt(4);

                    if(color == 1){

                        if(yellow > 0){yellow -= random.nextInt(yellow + 1);}
                        else if(green > 0){green -=random.nextInt(green + 1);}
                        else if(orange > 0){orange -=random.nextInt(orange + 1);}
                    }
                    else if(color == 2){

                        if(green > 0){green -=random.nextInt(green + 1);}
                        else if(yellow > 0){yellow -= random.nextInt(yellow + 1);}
                        else if(orange > 0){orange -=random.nextInt(orange + 1);}
                    }
                    else if(color == 3){

                        if(orange > 0){orange -=random.nextInt(orange + 1);}
                        else if(green > 0){green -=random.nextInt(green + 1);}
                        else if(yellow > 0){yellow -= random.nextInt(yellow + 1);}
                    }
                }
                if(yellow + green + orange == 0) {

                    win = false;
                    continue;
                }
            }
        }

        if(win){

            System.out.println("\nYou won, congrats!");
        }
        else{

            System.out.println("\nYou lost, all the markers were removed :)");
        }
    }
}

