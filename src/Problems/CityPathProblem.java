package Problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by eisak on 2018-12-23.
 */
public class CityPathProblem implements Problem {

    public class State extends Problem.State {

        public State previousState;

        public String cityName;

        public State(String name) {
            previousState = null;
            cost = 0;
            levelNo = 0;
            gn = 0;
            fn = 0;
            cityName = name;
        }

        @Override
        public boolean equalStates(Problem.State state) {

            State newState = (State) state;

            if (newState.cityName == cityName)
                return true;
            return false;
        }

        @Override
        public void updateState(Problem.State parent, Problem.State state, float movementCost) {
            previousState = (State) parent;
            State child = (State) state;
            cost = movementCost;
            gn = previousState.gn + movementCost;
            levelNo = previousState.levelNo + 1;
            fn = gn + heuristic(child);
        }
    }

    public class Action extends Problem.Action {

        public String from;
        public String to;

        public Action(String first, String second) {
            from = first;
            to = second;
        }
    }


    @Override
    public State initialState() {
        State instate = new State("Arad");
        return instate;
    }

    @Override
    public Problem.State finalState() {
        return new State("Bucharest");

    }

    @Override
    public ArrayList<Problem.Action> actions(Problem.State state) {
        State input = (State) state;
        ArrayList<Problem.Action> options = new ArrayList<>();

        if (input.cityName.equals("Arad")) {
            options.add(new Action("Arad", "Zerind"));
            options.add(new Action("Arad", "Sibiu"));
            options.add(new Action("Arad", "Timisoara"));

        }
        if (input.cityName.equals("Zerind")) {
            options.add(new Action("Zerind", "Oradea"));
            options.add(new Action("Zerind", "Arad"));
        }
        if (input.cityName.equals("Oradea")) {
            options.add(new Action("Oradea", "Zerind"));
            options.add(new Action("Oradea", "Sibiu"));
        }
        if (input.cityName.equals("Sibiu")) {
            options.add(new Action("Sibiu", "Oradea"));
            options.add(new Action("Sibiu", "Arad"));
            options.add(new Action("Sibiu", "Fagaras"));
            options.add(new Action("Sibiu", "Rimnicu Vilcea"));
        }
        if (input.cityName.equals("Timisoara")) {
            options.add(new Action("Timisoara", "Arad"));
            options.add(new Action("Timisoara", "Lugoj"));
        }
        if (input.cityName.equals("Fagaras")) {
            options.add(new Action("Fagaras", "Sibiu"));
            options.add(new Action("Fagaras", "Bucharest"));
        }
        if (input.cityName.equals("Rimnicu Vilcea")) {
            options.add(new Action("Rimnicu Vilcea", "Sibiu"));
            options.add(new Action("Rimnicu Vilcea", "Craiova"));
            options.add(new Action("Rimnicu Vilcea", "Pitesti"));
        }
        if (input.cityName.equals("Lugoj")) {
            options.add(new Action("Lugoj", "Timisoara"));
            options.add(new Action("Lugoj", "Mehadia"));
        }
        if (input.cityName.equals("Mehadia")) {
            options.add(new Action("Mehadia", "Lugoj"));
            options.add(new Action("Mehadia", "Dobreta"));
        }
        if (input.cityName.equals("Dobreta")) {
            options.add(new Action("Dobreta", "Mehadia"));
            options.add(new Action("Dobreta", "Craiova"));
        }
        if (input.cityName.equals("Craiova")) {
            options.add(new Action("Craiova", "Dobreta"));
            options.add(new Action("Craiova", "Pitesti"));
        }
        if (input.cityName.equals("Pitesti")) {
            options.add(new Action("Pitesti", "Craiova"));
            options.add(new Action("Pitesti", "Rimnicu Vilcea"));
            options.add(new Action("Pitesti", "Bucharest"));
        }
        if (input.cityName.equals("Bucharest")) {
            options.add(new Action("Bucharest", "Pitesti"));
            options.add(new Action("Bucharest", "Fagaras"));
            options.add(new Action("Bucharest", "Giurgiu"));
            options.add(new Action("Bucharest", "Urziceni"));
        }
        if (input.cityName.equals("Giurgiu")) {
            options.add(new Action("Giurgiu", "Bucharest"));
        }
        if (input.cityName.equals("Urziceni")) {
            options.add(new Action("Urziceni", "Hirsova"));
            options.add(new Action("Urziceni", "Bucharest"));
            options.add(new Action("Urziceni", "Vaslui"));
        }
        if (input.cityName.equals("Hirsova")) {
            options.add(new Action("Hirsova", "Urziceni"));
            options.add(new Action("Hirsova", "Eforie"));
        }
        if (input.cityName.equals("Eforie")) {
            options.add(new Action("Eforie", "Hirsova"));
        }
        if (input.cityName.equals("Vaslui")) {
            options.add(new Action("Vaslui", "Urziceni"));
            options.add(new Action("Vaslui", "Iasi"));
        }
        if (input.cityName.equals("Iasi")) {
            options.add(new Action("Iasi", "Vaslui"));
            options.add(new Action("Iasi", "Neamt"));
        }
        if (input.cityName.equals("Neamt")) {
            options.add(new Action("Neamt", "Iasi"));
        }
        return options;
    }

    @Override
    public ArrayList<Problem.Action> reverseActions(Problem.State state) {
        State s = (State) state;
        String cityName = s.cityName;
        ArrayList<Problem.Action> rev = new ArrayList<>();

//        if (cityName.equals("Neamt"))
//            rev.add(new Action("Iasi", "Neamt"));
//        else if (cityName.equals("Iasi")) {
//            rev.add(new Action("Vaslui", "Iasi"));
//            rev.add(new Action("Neamt", "Iasi"));
//        } else if (cityName.equals("Vaslui")) {
//            rev.add(new Action("Urziceni", "Vaslui"));
//            rev.add(new Action("Iasi", "Vaslui"));
//        } else if (cityName.equals("Urziceni")) {
//            rev.add(new Action("Bucharest", "Urziceni"));
//            rev.add(new Action("Hirsova", "Urziceni"));
//            rev.add(new Action("Vaslui", "Urziceni"));
//        } else if (cityName.equals("Hirsova")) {
//            rev.add(new Action("Urziceni", "Hirsova"));
//            rev.add(new Action("Eforie", "Hirsova"));
//        } else if (cityName.equals("Eforie"))
//            rev.add(new Action("Hirsova", "Eforie"));
//        else if (cityName.equals("Bucharest")) {
//            rev.add(new Action("Pitesti", "Bucharest"));
//            rev.add(new Action("Fagaras", "Bucharest"));
//            rev.add(new Action("Giurgiu", "Bucharest"));
//        } else if (cityName.equals("Giurgiu"))
//            rev.add(new Action("Bucharest", "Giurgiu"));
//        else if (cityName.equals("Pitesti")) {
//            rev.add(new Action("Bucharest", "Pitesti"));
//            rev.add(new Action("Craiova", "Pitesti"));
//            rev.add(new Action("Rimnicu Vilcea", "Pitesti"));
//        } else if (cityName.equals("Fagaras")) {
//            rev.add(new Action("Bucharest", "Fagaras"));
//            rev.add(new Action("Sibiu", "Fagaras"));
//        } else if (cityName.equals("Craiova")) {
//            rev.add(new Action("Pitesti", "Craiova"));
//            rev.add(new Action("Rimnicu Vilcea", "Craiova"));
//            rev.add(new Action("Dobreta", "Craiova"));
//        } else if (cityName.equals("Rimnicu Vilcea")) {
//            rev.add(new Action("Pitesti", "Rimnicu Vilcea"));
//            rev.add(new Action("Craiova", "Rimnicu Vilcea"));
//            rev.add(new Action("Sibiu", "Rimnicu Vilcea"));
//        } else if (cityName.equals("Dobreta")) {
//            rev.add(new Action("Craiova", "Dobreta"));
//            rev.add(new Action("Mehadia", "Dobreta"));
//        } else if (cityName.equals("Mehadia")) {
//            rev.add(new Action("Dobreta", "Mehadia"));
//            rev.add(new Action("Lugoj", "Mehadia"));
//        } else if (cityName.equals("Sibiu")) {
//            rev.add(new Action("Rimnicu Vlicea", "Sibiu"));
//            rev.add(new Action("Fagaras", "Sibiu"));
//            rev.add(new Action("Oradea", "Sibiu"));
//            rev.add(new Action("Arad", "Sibiu"));
//        } else if (cityName.equals("Lugoj")) {
//            rev.add(new Action("Mehadia", "Lugoj"));
//            rev.add(new Action("Timisoara", "Lugoj"));
//        } else if (cityName.equals("Timisoara")) {
//            rev.add(new Action("Lugoj", "Timisoara"));
//            rev.add(new Action("Arad", "Timisoara"));
//        } else if (cityName.equals("Oradea")) {
//            rev.add(new Action("Sibiu", "Oradea"));
//            rev.add(new Action("Zerind", "Oradea"));
//        } else if (cityName.equals("Zerind")) {
//            rev.add(new Action("Oradea", "Zerind"));
//            rev.add(new Action("Arad", "Zerind"));
//        } else if (cityName.equals("Arad")) {
//            rev.add(new Action("Zerind", "Arad"));
//            rev.add(new Action("Sibiu", "Arad"));
//            rev.add(new Action("Timisoara", "Arad"));
//        }


        if (cityName.equals("Neamt"))
            rev.add(new Action("Neamt", "Iasi"));
        else if (cityName.equals("Iasi")) {
            rev.add(new Action("Iasi", "Vaslui"));
            rev.add(new Action("Iasi", "Neamt"));
        } else if (cityName.equals("Vaslui")) {
            rev.add(new Action("Vaslui", "Urziceni"));
            rev.add(new Action("Vaslui", "Iasi"));
        } else if (cityName.equals("Urziceni")) {
            rev.add(new Action("Urziceni", "Bucharest"));
            rev.add(new Action("Urziceni", "Hirsova"));
            rev.add(new Action("Urziceni", "Vaslui"));
        } else if (cityName.equals("Hirsova")) {
            rev.add(new Action("Hirsova", "Urziceni"));
            rev.add(new Action("Hirsova", "Eforie"));
        } else if (cityName.equals("Eforie"))
            rev.add(new Action("Eforie", "Hirsova"));
        else if (cityName.equals("Bucharest")) {
            rev.add(new Action("Bucharest", "Pitesti"));
            rev.add(new Action("Bucharest", "Fagaras"));
            rev.add(new Action("Bucharest", "Giurgiu"));
        } else if (cityName.equals("Giurgiu"))
            rev.add(new Action("Giurgiu", "Bucharest"));
        else if (cityName.equals("Pitesti")) {
            rev.add(new Action("Pitesti", "Bucharest"));
            rev.add(new Action("Pitesti", "Craiova"));
            rev.add(new Action("Pitesti", "Rimnicu Vilcea"));
        } else if (cityName.equals("Fagaras")) {
            rev.add(new Action("Fagaras", "Bucharest"));
            rev.add(new Action("Fagaras", "Sibiu"));
        } else if (cityName.equals("Craiova")) {
            rev.add(new Action("Craiova", "Pitesti"));
            rev.add(new Action("Craiova", "Rimnicu Vilcea"));
            rev.add(new Action("Craiova", "Dobreta"));
        } else if (cityName.equals("Rimnicu Vilcea")) {
            rev.add(new Action("Rimnicu Vilcea", "Pitesti"));
            rev.add(new Action("Rimnicu Vilcea", "Craiova"));
            rev.add(new Action("Rimnicu Vilcea", "Sibiu"));
        } else if (cityName.equals("Dobreta")) {
            rev.add(new Action("Dobreta", "Craiova"));
            rev.add(new Action("Dobreta", "Mehadia"));
        } else if (cityName.equals("Mehadia")) {
            rev.add(new Action("Mehadia", "Dobreta"));
            rev.add(new Action("Mehadia", "Lugoj"));
        } else if (cityName.equals("Sibiu")) {
            rev.add(new Action("Sibiu", "Rimnicu Vilcea"));
            rev.add(new Action("Sibiu", "Fagaras"));
            rev.add(new Action("Sibiu", "Oradea"));
            rev.add(new Action("Sibiu", "Arad"));
        } else if (cityName.equals("Lugoj")) {
            rev.add(new Action("Lugoj", "Mehadia"));
            rev.add(new Action("Lugoj", "Timisoara"));
        } else if (cityName.equals("Timisoara")) {
            rev.add(new Action("Timisoara", "Lugoj"));
            rev.add(new Action("Timisoara", "Arad"));
        } else if (cityName.equals("Oradea")) {
            rev.add(new Action("Oradea", "Sibiu"));
            rev.add(new Action("Oradea", "Zerind"));
        } else if (cityName.equals("Zerind")) {
            rev.add(new Action("Zerind", "Oradea"));
            rev.add(new Action("Zerind", "Arad"));
        } else if (cityName.equals("Arad")) {
            rev.add(new Action("Arad", "Zerind"));
            rev.add(new Action("Arad", "Sibiu"));
            rev.add(new Action("Arad", "Timisoara"));
        }
        return rev;
    }

    @Override
    public State result(Problem.State state, Problem.Action action) {
        State newState = (State) state;
        Action newAction = (Action) action;
        return new State(newAction.to);
    }

    @Override
    public boolean goalTest(Problem.State state) {
        State newState = (State) state;
        if (newState.cityName.equals("Bucharest"))
            return true;
        return false;
    }

    @Override
    public float stepCost(Problem.State parent, Problem.State state, Problem.Action action) {
        State p = (State) parent;
        State s = (State) state;
        String s1 = p.cityName;
        String s2 = s.cityName;
        if (s1.equals("Arad") && s2.equals("Zerind"))
            return 75;
        else if (s1.equals("Zerind") && s2.equals("Ordea"))
            return 71;
        else if (s1.equals("Arad") && s2.equals("Timisoara"))
            return 118;
        else if (s1.equals("Oradea") && s2.equals("Sibiu"))
            return 151;
        else if (s1.equals("Arad") && s2.equals("Sibiu"))
            return 140;
        else if (s1.equals("Timisoara") && s2.equals("Lugoj"))
            return 111;
        else if (s1.equals("Lugoj") && s2.equals("Mehadia"))
            return 70;
        else if (s1.equals("Mehadia") && s2.equals("Dobreta"))
            return 75;
        else if (s1.equals("Dobreta") && s2.equals("Craiova"))
            return 120;
        else if (s1.equals("Sibiu") && s2.equals("Fagaras"))
            return 99;
        else if (s1.equals("Sibiu") && s2.equals("Rimnicu Vilcea"))
            return 80;
        else if (s1.equals("Rimnicu Vilcea") && s2.equals("Craiova"))
            return 146;
        else if (s1.equals("Rimnicu Vilcea") && s2.equals("Pitesti"))
            return 97;
        else if (s1.equals("Craiova") && s2.equals("Pitesti"))
            return 138;
        else if (s1.equals("Fagaras") && s2.equals("Bucharest"))
            return 211;
        else if (s1.equals("Pitesti") && s2.equals("Bucharest"))
            return 101;
        else if (s1.equals("Bucharest") && s2.equals("Giugiu"))
            return 90;
        else if (s1.equals("Bucharest") && s2.equals("Urziceni"))
            return 85;
        else if (s1.equals("Urziceni") && s2.equals("Hirsova"))
            return 98;
        else if (s1.equals("Hirsova") && s2.equals("Eforie"))
            return 86;
        else if (s1.equals("Urziceni") && s2.equals("Vaslui"))
            return 142;
        else if (s1.equals("Vaslui") && s2.equals("Iasi"))
            return 92;
        else if (s1.equals("Iasi") && s2.equals("Neamt"))
            return 87;
        return 0;
    }

    @Override
    public float[] bestPath(Problem.State finalState) {
        ArrayList<Problem.State> path = new ArrayList<>();
        State nextState = (State) finalState;
        path.add(nextState);
        while (nextState.previousState != null) {
            nextState = nextState.previousState;
            path.add(nextState);
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            State state = (State) path.get(i);
            System.out.println("(" + state.cityName + ")");
        }

        float[] out = new float[2];
        out[0] = path.size();
        out[1] = pathCost(path);

        return out;
    }

    @Override
    public float pathCost(ArrayList<Problem.State> path) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++)
            cost += path.get(i).cost;
        return cost;
    }

    @Override
    public float heuristic(Problem.State state) {
        State newS = (State) state;
        String s = newS.cityName;
        if (s.equals("Arad"))
            return 366;
        else if (s.equals("Bucharest"))
            return 0;
        else if (s.equals("Craiova"))
            return 160;
        else if (s.equals("Dobreta"))
            return 242;
        else if (s.equals("Eforie"))
            return 161;
        else if (s.equals("Fagaras"))
            return 178;
        else if (s.equals("Giurgiu"))
            return 77;
        else if (s.equals("Hirsova"))
            return 151;
        else if (s.equals("Iasi"))
            return 226;
        else if (s.equals("Lugoj"))
            return 244;
        else if (s.equals("Mehadia"))
            return 241;
        else if (s.equals("Neamt"))
            return 234;
        else if (s.equals("Oradea"))
            return 380;
        else if (s.equals("Pitesti"))
            return 98;
        else if (s.equals("Rimnicu Vilcea"))
            return 193;
        else if (s.equals("Sibiu"))
            return 253;
        else if (s.equals("Timisoara"))
            return 329;
        else if (s.equals("Urziceni"))
            return 80;
        else if (s.equals("Vaslui"))
            return 199;
        else if (s.equals("Zerind"))
            return 374;
        return 0;
    }
}
