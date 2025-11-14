# Implementation summary
#### The Knuth–Morris–Pratt (KMP) algorithm for string matching is implemented in the KMP.java class. The implementation consists of two main functions:
1) computeLPSArray: This is the preprocessing step. It computes the LPS array. The LPS array, for any index i, stores the length of the longest proper prefix of the pattern that is also a suffix of the pattern's sub-string ending at index i. This array dictates how much the pattern pointer should shift upon a mismatch
2) KMPSearch: This is the searching step. It uses the precomputed LPS array to efficiently scan the text. When a mismatch occurs, instead of restarting the pattern search from the beginning of the text, the algorithm uses the LPS value to move the pattern pointer forward, ensuring the text pointer never moves backward

# Testing results
#### The tests confirmed the algorithm's correctness across various scenarios:

- Exact Match: Successfully finds the single correct index
- Multiple Matches: Correctly identifies all starting indices of the pattern
- No Match: Returns an empty list, confirming no false positives or infinite loops
- Repetitive Patterns: Handles self-overlapping patterns efficiently due to the LPS array