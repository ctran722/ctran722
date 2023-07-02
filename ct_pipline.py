#create array
Color_Array= ["Red","Blue","Green"]

color1=Color_Array[0]
color2=Color_Array[1]
color3=Color_Array[2]


# create function to call
# def f1():
#     print("Red Called")

# def f2():
#     print("Green Called")

# # create dictionary
# color = {}

# # add colors in dictionary
# color["Red"] = f1
# color["Green"] = f2

# # create loop to search for color and call
# for fn in color:
#     print(fn)
#     color[fn]()

# print("Done")

#add class and definition
#edge cases
# add stats at the end?

# give name and age
# from datetime import date

# class Student:
#     def __init__(self, name, age):
#         self.name = name
#         self.age = age

#     @classmethod
#     def calculate_age(cls, name, birth_year):
#         # calculate age an set it as a age
#         # return new object
#         return cls(name, date.today().year - birth_year)

#     def show(self):
#         print(self.name + "'s age is: " + str(self.age))

# jessa = Student('Jessa', 20)
# jessa.show()

# # create new object using the factory method
# joy = Student.calculate_age("Joy", 1995)
# joy.show()

# give favorite color
# Create class and function within class
class Colors:
    def __init__(self, name, color):
        self.name = name
        self.color = color
 
# creating list
list = []
 
# appending instances to list
list.append(Colors('Bob', "Red"))
list.append(Colors('Julie',"Green"))
list.append(Colors('Ralph', 'White'))
list.append(Colors('Pearl', 'Blue'))
 
# Accessing object value using a for loop
for obj in list:
    print(obj.name,'favorite color is', obj.color, sep=' ')
 
# print("")
# # Accessing individual elements
# print(list[0].color)
# print(list[1].name)
# print(list[2].name)
# print(list[3].name)