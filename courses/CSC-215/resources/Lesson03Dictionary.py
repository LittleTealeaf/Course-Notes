"""
   Author: Christian Duncan
   Example Program to use the Dictionary ADT in Python
"""

fruit = { "Apples": 1.29, "Bananas": 0.49, "Pears": 1.45, "Kiwi":3.45 }

print(fruit["Pears"])      # Searching
fruit["Oranges"] = 1.35    # Insertion
fruit["Apples"] = 1.39     # Ins. with Replacement
del fruit["Kiwi"]          # Deletion
for f,p in fruit.items():  # Iteration
    print(f,p)
