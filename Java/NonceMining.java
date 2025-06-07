public class NonceMining {
    public static void main(String[] args) {
        int[] difficulties = {1, 2, 3, 4};

        for (int difficulty : difficulties) {
            System.out.println("\n\nMining block at difficulty " + difficulty + "...");
            Block block = new Block(1, "Test Data", "0");
            long start = System.currentTimeMillis();
            block.mineBlock(difficulty);
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) / 1000.0 + " seconds");
        }
    }
}