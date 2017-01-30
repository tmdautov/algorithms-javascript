
#Algorithm
The algorithm for topological sorting is similar to the algorithm for depth-first
search. However, instead of immediately printing a vertex as it is visited, the algorithm
visits all the adjacent vertices to the current vertex, and once that list is exhausted, we
push the current vertex onto a stack.
