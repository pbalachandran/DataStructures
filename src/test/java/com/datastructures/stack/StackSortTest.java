package com.datastructures.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StackSortTest {

    @Test
    public void sort_shouldSortAscendingOrderedList() {
        List<Number> list = new ArrayList<>();
        list.add(41);
        list.add(31);
        list.add(21);
        list.add(11);
        list.add(1);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(1, sorted.pop());
        assertEquals(11, sorted.pop());
        assertEquals(21, sorted.pop());
        assertEquals(31, sorted.pop());
        assertEquals(41, sorted.pop());
    }

    @Test
    public void sort_shouldSortdescendingOrderedList() {
        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(21);
        list.add(31);
        list.add(41);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(1, sorted.pop());
        assertEquals(11, sorted.pop());
        assertEquals(21, sorted.pop());
        assertEquals(31, sorted.pop());
        assertEquals(41, sorted.pop());
    }

    @Test
    public void sort_shouldSortZeroElementsList() {
        List<Number> list = new ArrayList<>();
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(0, sorted.size());
    }

    @Test
    public void sort_shouldSortSingleElementsList() {
        List<Number> list = new ArrayList<>();
        list.add(12);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(12, sorted.pop());
    }

    @Test
    public void sort_shouldSortDoubleElementsList() {
        List<Number> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(11, sorted.pop());
        assertEquals(12, sorted.pop());
    }

    @Test
    public void sort_shouldSortSameElementsList() {
        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
    }

    @Test
    public void sort_shouldSortAssortedElementsList1() {
        List<Number> list = new ArrayList<>();
        list.add(11);
        list.add(13);
        list.add(12);
        list.add(14);
        list.add(16);
        list.add(15);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(11, sorted.pop());
        assertEquals(12, sorted.pop());
        assertEquals(13, sorted.pop());
        assertEquals(14, sorted.pop());
        assertEquals(15, sorted.pop());
        assertEquals(16, sorted.pop());
    }

    @Test
    public void sort_shouldSortAssortedElementsList2() {
        List<Number> list = new ArrayList<>();
        list.add(54);
        list.add(1);
        list.add(111);
        list.add(17);
        list.add(16);
        list.add(109);
        list.add(243);
        list.add(0);
        list.add(4);
        list.add(1);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(0, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(4, sorted.pop());
        assertEquals(16, sorted.pop());
        assertEquals(17, sorted.pop());
        assertEquals(54, sorted.pop());
        assertEquals(109, sorted.pop());
        assertEquals(111, sorted.pop());
        assertEquals(243, sorted.pop());
    }

    @Test
    public void sort_shouldSortAssortedElementsList3() {
        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(3);
        Stack<Number> sorted = StackSort.sort(list);

        assertEquals(0, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(1, sorted.pop());
        assertEquals(2, sorted.pop());
        assertEquals(2, sorted.pop());
        assertEquals(3, sorted.pop());
        assertEquals(3, sorted.pop());
        assertEquals(4, sorted.pop());
        assertEquals(5, sorted.pop());
        assertEquals(6, sorted.pop());
    }
}