def string_compression(x):  
  count = 1
  res = [] #O(n)
  i = 0

  #O(n-1)
  while i < len(x)-1:
    if x[i] == x[i+1]:
      count += 1
    else:
      res.append(x[i] + str(count))
      count = 1  
    i += 1     
  
  if i > 0: 
    res.append(x[i] + str(count)) 
    
  if len(res) < len(x):
    return ''.join(res)
  return x

print(string_compression('aabcccccaaa'))