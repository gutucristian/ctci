class TrieNode:
  def __init__(self):
    self.children = {}
    self.is_end_of_word = False

class Trie:
  def __init__(self):
    self.root = TrieNode()

  def insert(self, word):
    current = self.root

    for char in word:
      if char not in current.children:
        current.children[char] = TrieNode()
      current = current.children[char]
    current.is_end_of_word = True

    return self

  def search(self, word):
    current = self.root

    for char in word:
      if char not in current.children:
        return False
      current = current.children[char]

    return current.is_end_of_word

  def starts_with(self, prefix):
    current = self.root

    for char in prefix:
      if char not in current.children:
        return False
      current = current.children[char]

    return True

  def auto_complete(self, prefix):
    current = self.root
    words = []

    for char in prefix:
      if char not in current.children:
        return False
      current = current.children[char]

    if current.is_end_of_word: words.append(prefix)

    def helper(current, string):
      for key, value in current.children.items():
        helper(value, string + key)
      if current.is_end_of_word:
        words.append(string)
      
    helper(current, prefix)
    return words

  def __str__(self):
    words = []
    
    def helper(current, string):
      for key, value in current.children.items():
        helper(value, string + [key])
      if current.is_end_of_word:
        words.append(''.join(string))

    helper(self.root, [])
    return ','.join(words)

trie = Trie()
trie.insert('ball').insert('bat').insert('doll').insert('dork').insert('dorm').insert('send').insert('sense')
print(trie)
# print(trie.auto_complete('b'))