package org.example;

import java.util.*;

public class FIFO implements PageReplacementInterface{
    private final int capacity;
    private final ArrayList<Integer> pages;
    private final Deque<Integer> frames;
    private int hits;
    private int faults;

    public FIFO(int capacity) {
        this.capacity = capacity;
        this.pages = new ArrayList<>();
        this.frames = new ArrayDeque<>();
        this.hits = 0;
        this.faults = 0;
    }

    @Override
    public void referencePage(int pageNumber) {
        if (pages.contains(pageNumber)) {
            hits++;
        } else {
            faults++;
            if (frames.size() >= capacity) {
                int removedPage = frames.poll();
                pages.remove(Integer.valueOf(removedPage));
            }
            frames.offer(pageNumber);
            pages.add(pageNumber);
        }
    }

    @Override
    public List<Integer> getPageFrames() {
        return new ArrayList<>(frames);
    }

    public int getHits() {
        return hits;
    }

    public int getFaults() {
        return faults;
    }

    public void printPages(){
        System.out.println("Pages " + pages + "\t" +
                "Frames " + frames + "\t" +
                "Faults " + faults + "\t" +
                "Hits " + hits);
    }


}
