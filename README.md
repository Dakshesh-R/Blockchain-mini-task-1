# Blockchain-mini-task-1
## 1. Block Simulation in Code

Objective: Build a basic blockchain with 3 linked blocks using code.

Task:
Create a Block class with:
index, timestamp, data, previousHash, hash, and nonce
Implement a simple hash generator using SHA-256
Link 3 blocks by chaining their previousHash
Display all blocks with their hashes

Challenge:
Change the data of Block 1 and recalculate its hash.
Observe how all following blocks become invalid unless hashes are recomputed.

Goal: Understand how tampering one block affects the entire chain.

## 2.  Nonce Mining Simulation

Objective: Simulate Proof-of-Work by mining a block that satisfies a difficulty condition.

Task:
Modify your Block class to include a mineBlock(difficulty) function
Set difficulty (e.g., hash must start with "0000")
In mineBlock(), repeatedly increment the nonce until the hash meets the difficulty condition

Output:
Print how many nonce attempts were needed
Measure time taken using a timer

Goal: Experience how computational effort increases with difficulty

## 3.  Consensus Mechanism Simulation

Objective: Simulate and compare PoW, PoS, and DPoS logic in code.

Task:
Create mock objects for 3 validators:
miner = {power: random value} for PoW
staker = {stake: random value} for PoS
voters = [3 mock accounts voting] for DPoS
Simulate:
For PoW: Select validator with highest power
For PoS: Select validator with highest stake
For DPoS: Randomly choose a delegate based on most votes

Output:
Print selected validator and consensus method used
Include a console.log explanation of the selection logic

Goal: Compare decision-making in various consensus mechanisms
