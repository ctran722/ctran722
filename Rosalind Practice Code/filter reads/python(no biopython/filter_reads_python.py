def filter_reads(input_file, output_file, quality_threshold, percentage_bases):
    filtered_reads = []

    with open(input_file, "r") as in_handle, open(output_file, "w") as out_handle:
        while True:
            # Read four lines at a time (representing one read entry)
            header = in_handle.readline().strip()
            sequence = in_handle.readline().strip()
            plus_line = in_handle.readline().strip()
            quality = in_handle.readline().strip()

            # Check if reached the end of the file
            if not header:
                break

            # Calculate percentage of bases above the quality threshold
            above_threshold_count = sum(1 for q in quality if ord(q) - 33 >= quality_threshold)
            percentage_above_threshold = (above_threshold_count / len(quality)) * 100

            # Check if the read passes the quality filter
            if percentage_above_threshold >= percentage_bases:
                filtered_reads.extend([header, sequence, plus_line, quality])

        # Write filtered reads to the output file
        out_handle.write("\n".join(filtered_reads))

if __name__ == "__main__":
    # Set input parameters
    input_fastq = "input.fastq"
    output_fastq = "output.fastq"
    quality_threshold = 20
    percentage_bases = 90

    # Filter reads
    filter_reads(input_fastq, output_fastq, quality_threshold, percentage_bases)

    # Count filtered reads
    with open(output_fastq, "r") as handle:
        filtered_read_count = sum(1 for line in handle if line.startswith('@'))

    # Output the result
    print(filtered_read_count)
