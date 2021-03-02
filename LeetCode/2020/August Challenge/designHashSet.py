class MyHashSet:

    def __init__(self):
        self.myHash = [0]*1000001
        """
        Initialize your data structure here.
        """
        

    def add(self, key: int) -> None:
        self.myHash[key] = 1

    def remove(self, key: int) -> None:
        self.myHash[key] = 0

    def contains(self, key: int) -> bool:
        return self.myHash[key] == 1
        """
        Returns true if this set contains the specified element
        """
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)