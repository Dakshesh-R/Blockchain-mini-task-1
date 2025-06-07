import java.util.*;

class Validator {
    String name;
    double stakeOrPower;

    Validator(String name, double stakeOrPower) {
        this.name = name;
        this.stakeOrPower = stakeOrPower;
    }
}

public class ConsensusMechanism {
    static Random rand = new Random();

    static Validator runPoW(List<Validator> miners) {
        System.out.println("\nPoW: Competing miners...");
        Validator winner = miners.get(rand.nextInt(miners.size()));
        System.out.println("Winner: " + winner.name);
        return winner;
    }

    static Validator runPoS(List<Validator> stakers) {
        System.out.println("\nPoS: Weighted selection based on stake...");
        double totalStake = stakers.stream().mapToDouble(v -> v.stakeOrPower).sum();
        double r = rand.nextDouble() * totalStake;
        double cumulative = 0;
        for (Validator v : stakers) {
            cumulative += v.stakeOrPower;
            if (r <= cumulative) {
                System.out.println("Winner: " + v.name);
                return v;
            }
        }
        return null;
    }

    static Validator runDPoS(List<Validator> delegates, Map<String, Integer> votes) {
        System.out.println("\nDPoS: Delegate with most votes...");
        return Collections.max(delegates, Comparator.comparingInt(d -> votes.getOrDefault(d.name, 0)));
    }

    public static void main(String[] args) {
        List<Validator> powMiners = Arrays.asList(
            new Validator("Miner1", 100), new Validator("Miner2", 150), new Validator("Miner3", 120)
        );

        List<Validator> posStakers = Arrays.asList(
            new Validator("Alice", 30000), new Validator("Bob", 20000), new Validator("Charlie", 50000)
        );

        List<Validator> dposDelegates = Arrays.asList(
            new Validator("Delegate1", 0), new Validator("Delegate2", 0), new Validator("Delegate3", 0)
        );
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Delegate1", 12000);
        votes.put("Delegate2", 25000);
        votes.put("Delegate3", 18000);

        runPoW(powMiners);
        runPoS(posStakers);
        Validator dposWinner = runDPoS(dposDelegates, votes);
        System.out.println("Winner: " + dposWinner.name);

        

        System.out.println("\nSummary:");
        System.out.println("PoW: Competition by power");
        System.out.println("PoS: Random weighted by stake");
        System.out.println("DPoS: Voting based selection");
    }
}
