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
    res = []
    for char in prefix:
      if char not in current.children:
        return False
      current = current.children[char]

    if current.is_end_of_word: res.append(prefix)

    def helper(current, word):
      for key, value in current.children:
        helper(value, word + key)
      if current.is_end_of_word:
        res.append(word)
      
    helper(current, prefix)