import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception{
        String line = "";  
        String splitBy = ",";
        List<String[]> games=new ArrayList<String[]>();  
        try {
            BufferedReader br = new BufferedReader(new FileReader("games.csv"));

            while ((line = br.readLine()) != null) {  
                
                String[] game = line.split(splitBy);    // use comma as separator  
                games.add(game);
            }
            List<String> listOfNames = new ArrayList<String>();
            listOfNames.add(games.get(0)[1]);
            List<Game> bestGames = new ArrayList<Game>();  
            for (String[] game : games) {
                String name = game[1];
                String price = game[7];
                String positive = game[23];
                String negative = game[24];
                Game newGame = new Game(name, price, positive, negative);
                if(listOfNames.contains(name) && !name.equals(games.get(0)[1])){
                    continue;
                }
                listOfNames.add(name);

                bestGames.add(newGame);
                
                
                
                
                

            }
            int numberOfFails = 0;
            for (int i = 1; i < bestGames.size(); i++) {
                try {
                    double price = Double.parseDouble(bestGames.get(i).getPrice());
                    int positive = Integer.parseInt(bestGames.get(i).getPositive());
                    int negative = Integer.parseInt(bestGames.get(i).getNegative());
                    if(price >= 5.0 && (positive + negative >= 20)){
                        double score = (positive)/(price + negative);
                        bestGames.get(i).setScore(score);
                    }
                } catch (Exception e) {
                    numberOfFails++;
                }

            }
            Collections.sort(bestGames);


            File bestGamesFile = new File("C:\\Users\\guybo\\Java_Data_Projects\\Main.java\\bestGames.txt");
            FileWriter myWriter = new FileWriter("bestGames.txt");
            int numberOfBestGames = 50;
            for(int i = 0; i < numberOfBestGames; i++){
                String name = bestGames.get(i).getName();
                String price = bestGames.get(i).getPrice();
                myWriter.write(name + "\n" + price + "$" + "\n" + "\n");
            }

            myWriter.close();

            



        } catch (Exception e) {
            e.getMessage();
        }  
    }
}