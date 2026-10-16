# Time complexity

`FoodStorageDeque` is a doubly linked list of `Node` objects, with direct
pointers to both ends (`front`, `rear`) and a running `size` counter.
`n` below is the number of items currently stored (max 8, fixed by the
brief).

| Operation | Method | Time | Why |
|---|---|---|---|
| Add (front) | `addFront` | O(1) | Creates one node and relinks it as the new front. No traversal, regardless of `n`. |
| Remove (front, stack mode) | `removeFront` | O(1) | The node after the old front becomes the new front. No traversal. |
| Remove (rear, queue mode) | `removeRear` | O(1) | Only possible this cheaply because the list is **doubly** linked: `rear.prev` jumps straight to the node before it. A singly linked list has no `prev`, so removing the rear would need an O(n) walk from `front` to find the node just before it. |
| Peek front | `peekFront` | O(1) | Reads `front.item` directly. |
| Display all | `displayAll` | O(n) | Has to visit every node once, front to rear, to build the list it returns. Can't be done in less than O(n) since every item must be read. |
| Search by name | `search` | O(n) worst case | Linear scan from front to rear comparing names. The list isn't sorted, so there's no way to do better than O(n) (no binary search possible). |
| isEmpty / isFull / size | — | O(1) | `size` is a counter updated on every add/remove, so these never need to walk the list to count anything. |

**Space:** O(n) for the nodes themselves, but since the brief caps
capacity at 8, that is a fixed O(1) upper bound in this application —
the storage can never grow unbounded.

**Why this matters for the data structure choice:** the brief describes
the chef needing O(1) removal from *either* end (stack mode from the
front, queue mode from the rear). A singly linked list gives O(1) at the
front but only O(n) at the rear. The doubly linked list is what makes
both ends O(1), which is the actual justification for picking it over a
simpler structure.
