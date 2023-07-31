# Store the normal and patient sequences as strings
reference_sequence = "ATCGATTACCGAGCAGGA"
patient1_sequence = "ATCGACTACCGAGCAGGT"
patient2_sequence = "ATCGATTACGGAGCAGGA"
patient3_sequence = "ATCGATTACCGAGCAGGA"

# create patient
class Patient:
    def __init__(self, name, mutations):
        self.name = name
        self.mutation = mutations

    # create mutation position calling
    def mutation_count(self):
        # Set the initial position to 1
        position = 1
        # Flag variable to track mutations
        mutations_found = False
        mutation_count = 0
        # loop through each name with reference sequence with patient
        for normal_base in reference_sequence:
            # Check if the normal and patient bases are different
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
        # return variable
        return mutation_count
   

# create list
Sample = []
# append each patient in dictionary
Sample.append(Patient('Bob', patient1_sequence))
Sample.append(Patient("Amy",patient2_sequence))
Sample.append(Patient('Rich', patient3_sequence))

# create loop to go through each patient
for obj in Sample:
    # pritn sequence of patient
    print(obj.name, 'has a sequence of', obj.mutation)
    # set mutation count as variable to call amount of mutations detected
    mutation_count = obj.mutation_count()
    # print mutations of patient
    print(obj.name, 'has', mutation_count, 'mutations.' "\n")