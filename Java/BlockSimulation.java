import java.util.ArrayList;

public class BlockSimulation {
    public static void main(String[] args) {
        Blockchain myBlockchain = new Blockchain();
        myBlockchain.addBlock(new Block(1, "Block 1 Data", ""));
        myBlockchain.addBlock(new Block(2, "Block 2 Data", ""));
        myBlockchain.displayChain();
    }
}

class Blockchain {
    public ArrayList<Block> chain = new ArrayList<>();
    public int difficulty = 3;

    public Blockchain() {
        chain.add(createGenesisBlock());
    }

    public Block createGenesisBlock() {
        return new Block(0, "Genesis Block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.previousHash = getLatestBlock().hash;
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public void displayChain() {
        for (Block block : chain) {
            System.out.println("\n\n----- Block -----");
            System.out.println("Index: " + block.index);
            System.out.println("Timestamp: " + block.timestamp);
            System.out.println("Data: " + block.data);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Hash: " + block.hash);
            System.out.println("Nonce: " + block.nonce);
        }
    }
}