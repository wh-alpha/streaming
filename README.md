Question 1:
Consider a tree structure, which can have a variable number of levels. At each level n there are n nodes. This tree structure is depicted below for a 5 level tree.
Please write the code for the constructor and the function index .
● The constructor should allocate an array of nodes, and store the number of levels passed in.
○ new Tree(5) will allocate the structure shown above.
● The index function should return a reference to the specified node (actual node if your language doesn’t support references or pointers)
○ index(4,2) should return a reference to node Y and index(5,3) should return a reference to node Z (node as a int here).

Question 2:
Please write a function which transforms a URLencoded
string into a JSON string. If there are two parameters with the same name, the values should be stacked as an array.
● Example
○ input: a=1&b=2&a=hello&apple=9&apple=digital output: { "a": ["1","hello"], "b": "2", "apple": ["9","digital"] }

Question 3:
Please write a function which is passed two strings and returns true if one is a permutation (has the same number of each character) of the other. Optimize for running time over everything else (e.g. code modularity, memory footprint).
● Example
○ input: (“debit card”, ”bad credit ”) output: true
