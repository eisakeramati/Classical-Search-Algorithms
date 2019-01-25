import Algorithms.Astar.As_Graph;
import Algorithms.Astar.As_Tree;
import Algorithms.BFS.BFS_Graph;
import Algorithms.BFS.BFS_Tree;
import Algorithms.Bidirectional.Bidirectional_Graph;
import Algorithms.Bidirectional.Bidirectional_Tree;
import Algorithms.DFS.dfs.DFS_Graph;
import Algorithms.DFS.dfs.DFS_Tree;
import Algorithms.DFS.iterativeDeepening.DFS_iterativeDeepening_Graph;
import Algorithms.DFS.iterativeDeepening.DFS_iterativeDeepening_Tree;
import Algorithms.DFS.limitDepth.DFS_limitDepth_Graph;
import Algorithms.DFS.limitDepth.DFS_limitDepth_Tree;
import Algorithms.Greedy.Greedy_Graph;
import Algorithms.UniformCostSearch.UCS_Graph;
import Algorithms.UniformCostSearch.UCS_Tree;
import Problems.CityPathProblem;

public class main {
    public static void main(String[] args){

//        int [][] start = {
//                {2, 1, 1 , 0},
//                {0, 0, 1 , 1},
//                {1, 1, 1 , 0},
//                {0, 1, 0 , 1},
//                {1, 1 ,0 , 0},
//                {1, 1 ,1 , 1}
//        };
//        Problem3 problem = new Problem3(start);
//        new Bidirectional_Tree(problem);
        CityPathProblem c = new CityPathProblem();
      //  new BFS_Graph(c);
      //  new BFS_Tree(c);
       // new DFS_Graph(c);
       // new DFS_Tree(c);
       // new As_Tree(c);
        //new As_Graph(c);
       //new Bidirectional_Graph(c);
      // new Bidirectional_Tree(c);
       // new UCS_Graph(c);
        new Greedy_Graph(c);
       // new UCS_Tree(c);
       // new DFS_iterativeDeepening_Graph(c,3);
       // new DFS_iterativeDeepening_Tree(c, 3);
        //new DFS_limitDepth_Graph(c, 3);
       // new DFS_limitDepth_Tree(c,2);
    }
}
