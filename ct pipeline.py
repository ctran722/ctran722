reference_sequence = "ATCGATTACCGAGCAGGA"
patient1_sequence = "ATCGACTACCGAGCAGGT"
patient2_sequence = "ATCGATTACGGAGCAGGA"

class Patient:
    def __init__(self, name, mutations):
        self.name = name
        self.mutation = mutations

    def mutation_count(self):
        # Set the initial position to 1
        position = 1
        # Flag variable to track mutations
        mutations_found = False
        mutation_count = 0

        for normal_base in reference_sequence:
            # Check if the normal and mutant bases are different
            if normal_base != self.mutation[position - 1]:
                # If they are different, print out the position of the mutation
                print("Mutation found at position:", position)
                # Increment the mutation count
                mutation_count += 1
                # Set the flag to True since a mutation was found
                mutations_found = True
            # Increment the position counter
            position += 1

        # If no mutations found
        if not mutations_found:
            print("No mutations detected at any position.")

        return mutation_count

Sample = []
Sample.append(Patient('Bob', patient1_sequence))
Sample.append(Patient("Amy",patient2_sequence))

for obj in Sample:
    print(obj.name, 'has a sequence of', obj.mutation)
    mutation_count = obj.mutation_count()
    print(obj.name, 'has', mutation_count, 'mutations.')