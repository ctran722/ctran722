#!/bin/bash

# Define the sample data
fastq_content="@Rosalind_0049_1\nGCAGAGACCAGTAGATGTGTTTGCGGACGGTCGGGCTCCATGTGACACAG\n+\nFD@@;C<AI?4BA:=>C<G=:AE=><A??>764A8B797@A:58:527+,\n@Rosalind_0049_2\nAATGGGGGGGGGAGACAAAATACGGCTAAGGCAGGGGTCCTTGATGTCAT\n+\n1<<65:793967<4:92568-34:.>1;2752)24')*15;1,.3*3+*!\n@Rosalind_0049_3\nACCCCATACGGCGAGCGTCAGCATCTGATATCCTCTTTCAATCCTAGCTA\n+\nB:EI>JDB5=>DA?E6B@@CA?C;=;@@C:6D:3=@49;@87;::;;?8+"

# Save the sample data to a FASTQ file
echo -e "$fastq_content" > input.fastq

echo "FASTQ file 'input.fastq' created successfully."
