#create array
Color_Array= ["Red","Blue","Green"]

color1=Color_Array[0]
color2=Color_Array[1]
color3=Color_Array[2]


# create function to call
def f1():
    print("Red Called")

def f2():
    print("Green Called")

# create dictionary
color = {}

# add colors in dictionary
color["Red"] = f1
color["Green"] = f2

# create loop to search for color and call
for fn in color:
    print(fn)
    color[fn]()

print("Done")

#add class and definition
#edge cases
# add stats at the end?