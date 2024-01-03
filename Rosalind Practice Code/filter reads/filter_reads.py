from Bio import SeqIO
from io import StringIO  # Import StringIO

def filter_reads(records, quality_threshold, percentage_bases):
    filtered_records = []

    for record in records:
        # Calculate the number of bases with quality above the threshold
        above_threshold = sum(1 for q in record.letter_annotations["phred_quality"] if q >= quality_threshold)

        # Calculate the percentage of bases above the threshold
        percentage_above_threshold = (above_threshold / len(record.seq)) * 100

        # Add the record to filtered_records if it passes the quality filter
        if percentage_above_threshold >= percentage_bases:
            filtered_records.append(record)

    return filtered_records

def count_reads(filtered_records):
    # Count the number of reads in the filtered records
    return len(filtered_records)

if __name__ == "__main__":
    # Hardcoded sample dataset
    sample_dataset = """20 90
@Rosalind_0049_1
GCAGAGACCAGTAGATGTGTTTGCGGACGGTCGGGCTCCATGTGACACAG
+
FD@@;C<AI?4BA:=>C<G=:AE=><A??>764A8B797@A:58:527+,
@Rosalind_0049_2
AATGGGGGGGGGAGACAAAATACGGCTAAGGCAGGGGTCCTTGATGTCAT
+
1<<65:793967<4:92568-34:.>1;2752)24')*15;1,.3*3+*!
@Rosalind_0049_3
ACCCCATACGGCGAGCGTCAGCATCTGATATCCTCTTTCAATCCTAGCTA
+
B:EI>JDB5=>DA?E6B@@CA?C;=;@@C:6D:3=@49;@87;::;;?8+
"""

    # Extract parameters from the first line of the sample dataset
    params_line, *seq_lines = sample_dataset.split('\n')
    quality_threshold, percentage_bases = map(int, params_line.split())

    # Parse the sample dataset into Biopython SeqIO records
    records = list(SeqIO.parse(StringIO('\n'.join(seq_lines)), "fastq"))

    # Filter the records using the specified parameters
    filtered_records = filter_reads(records, quality_threshold, percentage_bases)

    # Count the number of reads in the filtered records
    num_reads = count_reads(filtered_records)

    # Print the result
    print("Number of reads in filtered FASTQ entries:", num_reads)
