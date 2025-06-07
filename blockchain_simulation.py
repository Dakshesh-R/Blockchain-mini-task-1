from block import Block

class Blockchain:
    def __init__(self, diff=3):
        self.diff = diff
        self.chain = [Block(0, "Genesis")]

    def add_block(self, data):
        prev = self.chain[-1]
        block = Block(len(self.chain), data, prev.hash)
        block.mine(self.diff)
        self.chain.append(block)

    def show(self):
        for b in self.chain:
            print("\n\n----- Block -----")
            print(f"Index: {b.index}")
            print(f"Timestamp: {b.timestamp}")
            print(f"Data: {b.data}")
            print(f"Previous Hash: {b.prev_hash}")
            print(f"Hash: {b.hash}")
            print(f"Nonce: {b.nonce}")


bc = Blockchain()
bc.add_block("Data 1")
bc.add_block("Data 2")
bc.show()