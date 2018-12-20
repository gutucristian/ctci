from collections import Counter
from functools import reduce

def is_permutation_1(a, b):
  return Counter(a) == Counter(b)

def is_permutation(s1, s2):
  if (len(s1) != len(s2)):
    return False
     
  content = [0] * 128
  for char in s1:
    content[ord(char)] += 1
  for char in s2:
    content[ord(char)] -= 1
  return reduce(lambda x, y: x + y, content) == 0

def is_permutation_3(a, b):
  return sorted(a) == sorted(b)
