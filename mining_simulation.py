from block import Block
import time

class Blockchain:
    def __init__(self, difficulty):
        self.chain = []
        self.difficulty = difficulty
        self.create_genesis()

    def create_genesis(self):
        self.chain.append(Block(0, "Genesis Block", "0", 0))

    def add_block(self, data):
        prev = self.chain[-1]
        block = Block(len(self.chain), data, prev.hash, self.difficulty)
        self.chain.append(block)

    def display(self):
        for b in self.chain:
            print("\n----- Block -----")
            print(f"Index: {b.index}")
            print(f"Timestamp: {time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(b.timestamp))}")
            print(f"Data: {b.data}")
            print(f"Previous Hash: {b.prev_hash}")
            print(f"Hash: {b.hash}")
            print(f"Nonce: {b.nonce:,}")

bc = Blockchain(difficulty=4)
bc.add_block("Alice pays Bob")
bc.add_block("Bob pays Charlie")
bc.display()