from Bio import SeqIO
def count_nucleotides(dna_sequence):
    counts = {'A': 0, 'C': 0, 'G': 0, 'T': 0}

    for nucleotide in dna_sequence:
        counts[nucleotide] += 1

    return counts

if __name__ == "__main__":
    # Specify the path to the input file
    input_file_path = "rosalind_dna.txt"

    # Read the DNA sequence from the file
    with open(input_file_path, "r") as file:
        dna_sequence = file.read().strip()

    # Count nucleotides
    nucleotide_counts = count_nucleotides(dna_sequence)

    # Print the result in the specified format
    result = f"{nucleotide_counts['A']} {nucleotide_counts['C']} {nucleotide_counts['G']} {nucleotide_counts['T']}"
    print(result)

