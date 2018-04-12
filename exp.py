from collections import Counter
from functools import reduce

# ctci 1.1
def is_unique(str):
  s = set()
  for char in str:
    if char in s: 
      return False 
    else:       
      s.add(char)
  return True

# ctci 1.1
def is_unique(str):
  str = sorted(str)
  for i in range(1, len(str)):
    if str[i] == str[i-1]:
      return False
  return True      

# ctci 1.2
def is_permutation(a, b):
  # counts char frequencies and puts in dictionary, then compares if frequencies are same for a and b
  # time complexity: O(n)
  # space complexity: O(n + n)
  return Counter(a) == Counter(b)

# ctci 1.2
def is_permutation(a, b):
  # sorts a and b, then checks if resulting lists are same
  # time complexity: O(nlogn)
  # space complexity: O(1)
  return sorted(a) == sorted(b)

def URLify(str):
  lst = str.split(' ') # O(n) space  
  return ''.join([word + '%20' for word in lst]) # O(n) space and time

def URLify(str):
  lst = str.split(' ')
  return reduce(lambda acc, cur: acc + '%20' + cur, lst)

def has_palindrome_permutation(str):
  count = Counter(str)  
  for tuple in count.most_common():
    

print(has_palindrome_permutation('My name is bob'))