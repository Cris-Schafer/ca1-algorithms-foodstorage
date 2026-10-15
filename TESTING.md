# Manual test log

Each scenario was run against the console app (`ca1.CA1`) by feeding the
listed inputs and checking the printed output. All 20 passed with no code
changes needed.

| # | Scenario | Input | Expected | Result |
|---|---|---|---|---|
| 1 | Add 8 items, then a 9th | fill to capacity, select Add again | "Storage is full (capacity 8)." | Pass |
| 2 | Best-before date = today | e.g. 2026-10-15 | accepted | Pass |
| 3 | Best-before date = today + 14 days | e.g. 2026-10-29 | accepted | Pass |
| 4 | Best-before date = today + 15 days | e.g. 2026-10-30 | "cannot have a best-before date more than 14 day(s)..." | Pass |
| 5 | Best-before date = yesterday | e.g. 2026-10-14 | "cannot be in the past." | Pass |
| 6 | Weight = 0 | `0` | "Weight must be greater than 0 grams." | Pass |
| 7 | Weight negative | `-50` | "Weight must be greater than 0 grams." | Pass |
| 8 | Weight blank / non-numeric | empty line | "Weight must be greater than 0 grams." | Pass |
| 9 | Name blank | empty line | "Food name cannot be empty." | Pass |
| 10 | Name whitespace-only | `"   "` | "Food name cannot be empty." | Pass |
| 11 | Best-before date non-date text | `abc` | "Best-before date is required." | Pass |
| 12 | Food type out of range | `0` | "Please choose a food type between 1 and 5." | Pass |
| 13 | Search, case-insensitive | add "Cheese Burger", search "cheese burger" | match found | Pass |
| 14 | Search, no match | search a name never added | "No item named ... was found." | Pass |
| 15 | Remove from empty storage | remove with 0 items | "Storage is empty. Nothing to remove." | Pass |
| 16 | Peek with empty storage | peek with 0 items | "Storage is empty." | Pass |
| 17 | Display all with empty storage | display with 0 items | "Storage is empty." | Pass |
| 18 | Invalid removal mode | `9` | "Please choose 1 or 2." | Pass |
| 19 | Invalid main menu option | letters or out-of-range number | "Please choose a number between 1 and 6." | Pass |
| 20 | Removal order (stack vs queue) | add A then B, remove front vs rear | front returns B (newest), rear returns A (oldest) | Pass |
