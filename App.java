package lab11;

import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        try {


            File file = new File("/Users/sonia/Desktop/Files/mediumG.txt");

            Scanner input = new Scanner(file);

            int num_vertices = input.nextInt();
            int edges = input.nextInt();

            System.out.println(num_vertices);
            Graph g = new Graph(num_vertices);


            while (input.hasNextInt()) {
                int u = input.nextInt();
                int v = input.nextInt();
                g.edge_addition(u, v);
            }
            input.close();

            g.print_graph(num_vertices);

            g.breadth_first_search(0, 39);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


