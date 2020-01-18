package org.example

object RelationShips {
    // TODO Infix notation (easy).
    fun hasStarts(a: Range, b: Range) : Boolean {
        return a.start == b.start && a.end != b.end
    }

    fun hasFinishes(a: Range, b: Range): Boolean {
        return a.start != b.start && a.end == b.end
    }

    fun equals(a: Range, b: Range): Boolean {
        return a.start == b.start && a.end == b.end
    }

    fun during(a: Range, b: Range): Boolean {
        return a.start > b.start && a.end < b.end
    }

    fun isContainedIn(a: Range, b: Range): Boolean {
        return during(b, a)
    }

    fun hasDuring(a: Range, b: Range): Boolean {
        return during(b, a) || during(b, a)
    }

    fun overlaps(a: Range, b: Range): Boolean {
        return a.start < b.start && a.end > b.start && a.end < b.end
    }

    fun hasOverlaps(a: Range, b: Range): Boolean {
        return overlaps(a, b) || overlaps(b, a)
    }

    fun isBefore(a: Range, b: Range): Boolean {
        return a.end < b.start
    }

    fun isAfter(a: Range, b: Range): Boolean {
        return b.end < a.start
    }

    fun hasBefore(a: Range, b: Range): Boolean {
        return isBefore(a, b) || isAfter(a, b)
    }

    fun isMeets(a: Range, b: Range): Boolean {
        return a.end == b.start
    }

    fun isIncludes(a: Range, b: Range): Boolean {
        // fst(a) = fst(b) or snd(a) = snd(b) or
        //        (snd(a) <= snd(b) and (fst(a) >= fst(b) or fst(b) < snd(a))) or
        //        (snd(a) >= snd(b) and (fst(a) < snd(b) or fst(a) <= fst(b)));
        return a.start == b.start || a.end == b.end ||
                (a.end <= b.end && (a.start >= b.start || b.start < a.end)) ||
                (a.end >= b.end && (a.start < b.end || a.start <= b.start))
    }

    fun hasContains(a: Range, b: Range): Boolean {
        // fst(a) = fst(b) or snd(a) = snd(b) or
        //       (snd(a) < snd(b) and fst(a) > fst(b)) or
        //       (snd(b) < snd(a) and fst(b) > fst(a));
        return a.start == b.start || a.end == b.end ||
                (a.end < b.end && a.start > b.start) ||
                (b.end < a.end && b.start > a.start)
    }

    fun hasAlignsWith(a: Range, b: Range): Boolean {
        return (a.start == b.start) xor (a.end == b.end)
    }

    fun hasEncloses(a: Range, b: Range): Boolean {
        return hasDuring(a, b) || hasAlignsWith(a, b)
    }

    fun hasExcludes(a: Range, b: Range): Boolean {
        // fst(a) >= snd(b) or fst(b) >= snd(a)
        return a.start >= b.end || b.start >= a.end
    }
}