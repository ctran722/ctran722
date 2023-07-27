# Store the normal and mutant sequences as strings
reference_sequence = "ATCGATTACCGAGCAT"
mutant_sequence = "ATCGACTACCGAGCAT"
# mutant_sequence = "ATCGATTACCGAGCAT"
# create patient
class Patient:
    def __init__(self, name, mutations):
        self.name = name
        self.mutation = mutations
    

# Set the initial position to 1
position = 1
# Flag variable to track mutations
mutations_found = False  

# def mutation_count(mutant_sequence):
#     for normal_base in reference_sequence:
#         # Check if the normal and mutant bases are different
#         if normal_base != mutant_sequence[position-1]:
#         # If they are different, print out the position of the mutation
#             print("Mutation found at position:", position)
#         # Set the flag to True since a mutation was found
#             mutations_found = True  
#     # Increment the position counter
#         position += 1
    
# # If no mutations found
#     if not mutations_found:
#         print("No mutations detected.")





# Loop through each character in the normal sequence
for normal_base in reference_sequence:
    # Check if the normal and mutant bases are different
    if normal_base != mutant_sequence[position-1]:
        # If they are different, print out the position of the mutation
        print("Mutation found at position:", position)
        # Set the flag to True since a mutation was found
        mutations_found = True  
    # Increment the position counter
    position += 1
    
# If no mutations found
if not mutations_found:
    print("No mutations detected.")





        