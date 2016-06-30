/** * Created by Lord Daniel on 5/28/2016.
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents the classic recursive backtracking algorithm.
 * It has a solver that can take a valid BreadthFirst.CubeConfig and return a
 * solution, if one exists.
 *
 * This file comes from the backtracking lab. It should be useful
 * in this project. A second method has been added that you should
 * implement.
 *
 * @author Sean Strout @ RIT CS
 * @author James Heliotis @ RIT CS
 * @author Patrick Ly & Daniel Roy Barman
 */
public class BFSolver {

    public ArrayList<String> faces;
    public ArrayList<Character> directions;

    /**
     * Initialize a new backtracker.
     *
     */
    public BFSolver() {
        this.faces = new ArrayList<>();
        this.faces.add("front");
        this.faces.add("left");
        this.faces.add("right");
        this.faces.add("top");
        this.faces.add("bottom");
        this.faces.add("back");

        this.directions = new ArrayList<>();
        this.directions.add('c');
        this.directions.add('a');
    }


    public ArrayList<CubeConfig> getSuccessors(ArrayList<CubeConfig> configs){
        ArrayList<CubeConfig> successors = new ArrayList<>();

        for (CubeConfig c: configs){
            //do all possible operations with methods defined in cubeConfig
            for (String face:this.faces){
                for (char d:this.directions){
                    CubeConfig newCube = new CubeConfig(c);
                    newCube.move(face, d);
                    newCube.moves.add(face+" moved "+Character.toString(d));
                    if (newCube.isValid()) {
                        successors.add(newCube);
                    }
                }
            }
            //check if valid, then add to arraylist succ
        }
        //System.out.println(successors.size());
        return successors;
    }


    /**
     * Try find a solution, if one exists, for a given BreadthFirst.CubeConfig.
     *
     * @param configs A valid BreadthFirst.CubeConfig
     * @return A solution config, or null if no solution
     */
    public CubeConfig solve(ArrayList<CubeConfig> configs) {

        if (configs.size() == 0){
            return null;
        }
        int n=0;
        for (CubeConfig child : configs) {
            if (child.isGoal()) {
                System.out.println("Steps to Solution: ");
                for (String s:child.getMoves()){
                    System.out.println("    "+s);
                }
                System.out.println();
                return configs.get(n);
            }
            n += 1;
        }
        //if no solution found here
        ArrayList<CubeConfig> successors = getSuccessors(configs);
        return solve(successors);

    }

}


