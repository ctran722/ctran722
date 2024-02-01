import random

def generate_reference_sequence(length):
    return ''.join(random.choice('ACGT') for _ in range(length))

def simulate_reads(reference, num_reads, read_length):
    reads = []
    for _ in range(num_reads):
        start_position = random.randint(0, len(reference) - read_length)
        read = reference[start_position : start_position + read_length]
        reads.append((start_position, read))
    return reads

def calculate_coverage(reference, reads):
    coverage = [0] * len(reference)
    for start_position, read in reads:
        for i in range(len(read)):
            coverage[start_position + i] += 1
    return coverage

def calculate_average_depth(coverage):
    total_coverage = sum(coverage)
    total_positions = len(coverage)
    return total_coverage / total_positions

def main():
    random.seed(42)  # For reproducibility

    reference_sequence = generate_reference_sequence(12)
    print("Reference sequence:", reference_sequence)

    num_reads = 3
    read_length = 6
    simulated_reads = simulate_reads(reference_sequence, num_reads, read_length)
    print("Simulated reads:", simulated_reads)

    coverage = calculate_coverage(reference_sequence, simulated_reads)
    print("Coverage at each position:", coverage)

    average_depth = calculate_average_depth(coverage)
    print("Average depth of coverage:", average_depth)

if __name__ == "__main__":
    main()
