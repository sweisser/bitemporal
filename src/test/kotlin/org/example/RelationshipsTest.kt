package org.example

import org.junit.Test
import kotlin.test.assertEquals


class RelationshipsTest {
    @Test
    fun testHasStartsTrue() {
        // [starts] [starts^-1]
        //
        // [starts A E]
        //  A  |---|
        //  E  |-------|
        //
        // [starts^-1 A E]
        //  A  |-------|
        //  E  |---|
        //
        val a = Range("2019-01-01", "2019-06-01")
        val b = Range("2019-01-01", "2020-01-01")
        assertEquals(true, RelationShips.hasStarts(a, b))
    }

    @Test
    fun testHasStartsFalse1() {
        val a = Range("2019-01-01", "2019-06-01")
        val b = Range("2019-02-01", "2019-06-01")
        assertEquals(false, RelationShips.hasStarts(a, b))
    }

    @Test
    fun testHasStartsFalse2() {
        val a = Range("2019-02-01", "2019-06-01")
        val b = Range("2019-02-01", "2019-06-01")
        assertEquals(false, RelationShips.hasStarts(a, b))
    }

    @Test
    fun testFinishesTrue() {
        val a = Range("2019-01-01", "2019-06-01")
        val b = Range("2019-02-01", "2019-06-01")
        assertEquals(true, RelationShips.hasFinishes(a, b))
    }

    @Test
    fun testFinishesFalse1() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-02-01", "2019-06-01")
        assertEquals(false, RelationShips.hasFinishes(a, b))
    }

    @Test
    fun testFinishesFalse2() {
        val a = Range("2019-01-01", "2019-06-01")
        val b = Range("2019-01-01", "2019-06-01")
        assertEquals(false, RelationShips.hasFinishes(a, b))
    }

    @Test
    fun testEqualsTrue() {
        val a = Range("2019-01-01", "2019-06-01")
        val b = Range("2019-01-01", "2019-06-01")
        assertEquals(true, RelationShips.equals(a, b))
    }

    @Test
    fun testEqualsFalse1() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-01-01", "2019-06-01")
        assertEquals(false, RelationShips.equals(a, b))
    }

    @Test
    fun testEqualsFalse2() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-02-01", "2019-05-01")
        assertEquals(false, RelationShips.equals(a, b))
    }

    //
    // [during]
    //
    // [during A E]
    //  A    |---|
    //  E  |-------|
    //
    @Test
    fun testDuringTrue() {
        val a = Range("2019-02-01", "2019-05-01")
        val b = Range("2019-01-01", "2019-12-01")
        assertEquals(true, RelationShips.during(a, b))
    }

    @Test
    fun testDuringFalse1() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-01-01", "2019-12-01")
        assertEquals(false, RelationShips.during(a, b))
    }

    @Test
    fun testIsContainedInTrue() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-05-01")
        assertEquals(true, RelationShips.isContainedIn(a, b))
    }

    @Test
    fun testHasDuringTrue() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-05-01")
        assertEquals(true, RelationShips.hasDuring(a, b))
    }

    @Test
    fun testHasDuringFalse() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2020-05-01")
        assertEquals(false, RelationShips.hasDuring(a, b))
    }

    @Test
    fun testOverlapsTrue() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2020-05-01")
        assertEquals(true, RelationShips.overlaps(a, b))
    }

    @Test
    fun testOverlapsFalse() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-05-01")
        assertEquals(false, RelationShips.overlaps(a, b))
    }

    @Test
    fun testHasOverlapsTrue1() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2020-05-01")
        assertEquals(true, RelationShips.hasOverlaps(a, b))
    }

    @Test
    fun testHasOverlapsTrue2() {
        val a = Range("2019-02-01", "2020-05-01")
        val b = Range("2019-01-01", "2019-12-01")
        assertEquals(true, RelationShips.hasOverlaps(a, b))
    }

    @Test
    fun testHasOverlapsFalse() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-05-01")
        assertEquals(false, RelationShips.hasOverlaps(a, b))
    }

    @Test
    fun testIsBeforeTrue() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-06-01", "2019-12-01")
        assertEquals(true, RelationShips.isBefore(a, b))
    }

    @Test
    fun testIsBeforeFalse() {
        val a = Range("2019-01-01", "2019-07-01")
        val b = Range("2019-06-01", "2019-12-01")
        assertEquals(false, RelationShips.isBefore(a, b))
    }

    @Test
    fun testIsAfterTrue() {
        val a = Range("2019-06-01", "2019-12-01")
        val b = Range("2019-01-01", "2019-05-01")
        assertEquals(true, RelationShips.isAfter(a, b))
    }

    @Test
    fun testIsAfterFalse() {
        val a = Range("2019-06-01", "2019-12-01")
        val b = Range("2019-01-01", "2019-07-01")
        assertEquals(false, RelationShips.isAfter(a, b))
    }

    @Test
    fun testHasBeforeTrue1() {
        val a = Range("2019-06-01", "2019-12-01")
        val b = Range("2019-01-01", "2019-05-01")
        assertEquals(true, RelationShips.hasBefore(a, b))
    }

    @Test
    fun testHasBeforeTrue2() {
        val b = Range("2019-01-01", "2019-05-01")
        val a = Range("2019-06-01", "2019-12-01")
        assertEquals(true, RelationShips.hasBefore(a, b))
    }

    @Test
    fun testHasBeforeFalse() {
        val b = Range("2019-01-01", "2019-07-01")
        val a = Range("2019-06-01", "2019-12-01")
        assertEquals(false, RelationShips.hasBefore(a, b))
    }

    @Test
    fun testIsMeetsTrue() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-05-01", "2019-12-01")
        assertEquals(true, RelationShips.isMeets(a, b))
    }

    @Test
    fun testIsMeetsFalse() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-05-02", "2019-12-01")
        assertEquals(false, RelationShips.isMeets(a, b))
    }


    //
    // [Includes]
    //     [Contains] or [Overlaps]
    @Test
    fun testIncludesTrue1() {
        val a = Range("2019-01-01", "2019-05-01")
        val b = Range("2019-02-01", "2019-03-01")
        assertEquals(true, RelationShips.isIncludes(a, b))
    }

    @Test
    fun testIncludesFalse() {
        val a = Range("2019-03-01", "2019-05-01")
        val b = Range("2019-01-01", "2019-02-01")
        assertEquals(false, RelationShips.isIncludes(a, b))
    }


    //
    // [Contains]
    //    [Encloses] or [Equals]
    @Test
    fun testHasContainsTrue1() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-11-01")
        assertEquals(true, RelationShips.hasContains(a, b))
    }

    @Test
    fun testHasContainsTrue2() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-01-01", "2019-12-01")
        assertEquals(true, RelationShips.hasContains(a, b))
    }

    @Test
    fun testHasContainsFalse() {
        val a = Range("2019-01-01", "2019-03-01")
        val b = Range("2019-04-01", "2019-12-01")
        assertEquals(false, RelationShips.hasContains(a, b))
    }

    //
    // [Aligns With]
    //   [Starts] or [Finishes]
    //
    @Test
    fun testHasAlignsWithTrue1() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-12-01")
        assertEquals(true, RelationShips.hasAlignsWith(a, b))
    }

    @Test
    fun testHasAlignsWithTrue2() {
        val a = Range("2019-01-01", "2019-11-01")
        val b = Range("2019-01-01", "2019-12-01")
        assertEquals(true, RelationShips.hasAlignsWith(a, b))
    }

    @Test
    fun testHasAlignsWithFalse() {
        val a = Range("2019-01-01", "2019-11-01")
        val b = Range("2019-02-01", "2019-12-01")
        assertEquals(false, RelationShips.hasAlignsWith(a, b))
    }

    //
    // [Encloses]
    //   [Aligns With] or [During]
    //
    @Test
    fun testHasEnclosesTrue() {
        val a = Range("2019-01-01", "2019-12-01")
        val b = Range("2019-02-01", "2019-12-01")
        assertEquals(true, RelationShips.hasEncloses(a, b))
    }

    @Test
    fun testHasEnclosesFalse() {
        val a = Range("2019-01-01", "2019-11-01")
        val b = Range("2019-02-01", "2019-12-01")
        assertEquals(false, RelationShips.hasEncloses(a, b))
    }

    //
    // [Excludes]
    //   [Before] or [Meets]
    //
    @Test
    fun testHasExcludesTrue1() {
        val a = Range("2019-01-01", "2019-03-01")
        val b = Range("2019-04-01", "2019-12-01")
        assertEquals(true, RelationShips.hasExcludes(a, b))
    }

    @Test
    fun testHasExcludesTrue2() {
        val a = Range("2019-01-01", "2019-03-01")
        val b = Range("2019-03-01", "2019-12-01")
        assertEquals(true, RelationShips.hasExcludes(a, b))
    }

}