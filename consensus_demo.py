import random

class Validator:
    def __init__(self, name, stake_or_power):
        self.name = name
        self.stake_or_power = stake_or_power

def run_pow(miners):
    print("\nPoW: Competing miners...")
    winner = random.choice(miners)
    print(f"Winner: {winner.name}")
    return winner

def run_pos(stakers):
    print("\nPoS: Weighted selection based on stake...")
    total_stake = sum(v.stake_or_power for v in stakers)
    r = random.uniform(0, total_stake)
    cumulative = 0
    for v in stakers:
        cumulative += v.stake_or_power
        if r <= cumulative:
            print(f"Winner: {v.name}")
            return v

def run_dpos(delegates, votes):
    print("\nDPoS: Delegate with most votes...")
    winner = max(delegates, key=lambda d: votes.get(d.name, 0))
    print(f"Winner: {winner.name}")
    return winner

pow_miners = [
    Validator("Miner1", 100),
    Validator("Miner2", 150),
    Validator("Miner3", 120)
]

pos_stakers = [
    Validator("Alice", 30000),
    Validator("Bob", 20000),
    Validator("Charlie", 50000)
]

dpos_delegates = [
    Validator("Delegate1", 0),
    Validator("Delegate2", 0),
    Validator("Delegate3", 0)
]
votes = {
    "Delegate1": 12000,
    "Delegate2": 25000,
    "Delegate3": 18000
}

run_pow(pow_miners)
run_pos(pos_stakers)
run_dpos(dpos_delegates, votes)