def average_quality(quality_string):
    """Calculate the average quality score for a given quality string."""
    return sum(ord(char) - 33 for char in quality_string) / len(quality_string)

def count_low_quality_reads(quality_threshold, fastq_entries):
    """Count the number of reads with average quality below the threshold."""
    low_quality_count = 0

    for i in range(0, len(fastq_entries), 4):
        quality_string = fastq_entries[i + 3].strip()
        avg_quality = average_quality(quality_string)

        if avg_quality < quality_threshold:
            low_quality_count += 1

    return low_quality_count

if __name__ == "__main__":
    # Sample input
    quality_threshold = 28
    fastq_entries = [
        "@Rosalind_0041",
        "GGCCGGTCTATTTACGTTCTCACCCGACGTGACGTACGGTCC",
        "+",
        "6.3536354;.151<211/0?::6/-2051)-*\"40/.,+%)",
        "@Rosalind_0041",
        "TCGTATGCGTAGCACTTGGTACAGGAAGTGAACATCCAGGAT",
        "+",
        "AH@FGGGJ<GB<<9:GD=D@GG9=?A@DC=;:?>839/4856",
        "@Rosalind_0041",
        "ATTCGGTAATTGGCGTGAATCTGTTCTGACTGATAGAGACAA",
        "+",
        "@DJEJEA?JHJ@8?F?IA3=;8@C95=;=?;>D/:;74792."
    ]

    # Count low-quality reads
    result = count_low_quality_reads(quality_threshold, fastq_entries)

    # Print the result
    print(result)