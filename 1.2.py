from collections import Counter
from functools import reduce

def is_permutation_1(a, b):
  return Counter(a) == Counter(b)

def is_permutation_2(a, b):
  if len(a) != len(b):
    return False
  counter = Counter() # Counter is a dict subclass for counting hashable objects. It is an unordered collection where elements are stored as dictionary keys and their counts are stored as dictionary values.
  for char in a:    
    counter[char] += 1
  for char in b:
    if counter[char] == 0:
      return False
    counter[char] -= 1
  return True

def is_permutation_3(a, b):
  return sorted(a) == sorted(b)

print(is_permutation_2('abc', 'aac'))