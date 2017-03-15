package cs401.k142109.a1p1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

class Node{
    int x;
    int y;
    Node(int x , int y){
        this.x = x;
        this.y = y;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    void setX(int x){
        this.x = x;
    }
    void setY(int y){
        this.y = y;
    }
}

public class CS401K142109A1P1 {
    public static void main(String[] args) {
        int x = 0, y = 0, sx = 0, sy = 0, fx = 0, fy = 0;
          int maze[][] = null;
          String words[];
          Node size = null;
          Node start = null;
          Node goal = null;
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"), charset);
             FileWriter out = new FileWriter("CS401-K142109-A1P1Output.txt");
            ) {
            String line = null;
            int i = 0;
            while((line = reader.readLine()) != null){
                switch(i){
                    case 0:
                        words = line.split(" ");
                        x = Integer.parseInt(words[0]);
                        y = Integer.parseInt(words[1]);
                        if(x > 500 || y > 500){
                            System.out.println("Maze out of size");
                        }
                        else{
                            maze = new int[x][y];
                            size = new Node(x,y);
                            System.out.println("The Maze is of size " + x + " rows and " + y + " columns: maze[" + x + "][" + y + "]");
                            out.write(x + " " + y + "\n");                
                        }
                        i++;
                        break;
                    case 1:
                        words = line.split(" ");
                        sx = Integer.parseInt(words[0]);
                        sy = Integer.parseInt(words[1]);
                        System.out.println("Starting state of Maze is maze[" + sx + "][" + sy + "]");
                        i++;
                        start = new Node(sx, sy);
                        out.write(sx + " " + sy + "\n");                
                        break;
                    case 2:
                        words = line.split(" ");
                        fx = Integer.parseInt(words[0]);
                        fy = Integer.parseInt(words[1]);
                        System.out.println("Goal state of Maze is maze[" + fx + "][" + fy + "]"); 
                        goal = new Node(fx,fy);
                        out.write(fx + " " + fy + "\n"); 
                        i++;
                        break;
                    default:
                        words = line.split(" ");
                        for(int j=0; j<y; j++){
                            maze[i-3][j] = Integer.parseInt(words[j]);
                            out.write(words[j] + " ");
                        }
                        out.write("\n");
                        i++;
                        break;
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
       for (int k=0;k<x;k++){
           for(int l=0;l<y;l++){
               System.out.print(maze[k][l] + " ");
           }
           System.out.println("");
       }
    }
    
}
