# block.py
import hashlib, time

class Block:
    def __init__(self, index, data, prev_hash='0', difficulty=0):
        self.index = index
        self.data = data
        self.timestamp = time.time()  # Use float timestamp
        self.prev_hash = prev_hash
        self.nonce = 0
        self.hash = self.calc_hash()

        if difficulty > 0:
            self.mine(difficulty)

    def calc_hash(self):
        text = f"{self.index}{self.timestamp}{self.data}{self.prev_hash}{self.nonce}"
        return hashlib.sha256(text.encode()).hexdigest()

    def mine(self, diff):
        while not self.hash.startswith('0' * diff):
            self.nonce += 1
            self.hash = self.calc_hash()
        print(f"Block {self.index} mined: {self.hash}")