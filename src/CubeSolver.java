
import javax.security.auth.login.Configuration;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lord Daniel on 5/28/2016.
 */
public class CubeSolver {
    public static void main(String[] args) throws FileNotFoundException {
        CubeConfig init = new CubeConfig(args[0]);
        BFSolver BFS = new BFSolver();
        double start = System.currentTimeMillis(); // start the clock
        ArrayList<CubeConfig> ar = new ArrayList<>();
        ar.add(init);
        CubeConfig solution = BFS.solve(ar); // attempt to solve the puzzle
        if (solution == null){
            System.out.println("No solution found");
        }
        else{
            System.out.println("SOLVED");
        }
        // compute the elapsed time
        System.out.println("Elapsed time: " +
                (System.currentTimeMillis() - start)/1000.0 + " seconds");
    }
}
