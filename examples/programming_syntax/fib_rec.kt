fun recFibN(n: Int): Long = if (n < 2) n.toLong() else this[n - 1] + this[n - 2]
