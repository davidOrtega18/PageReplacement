package org.example;

import java.util.*;

public class LRU implements PageReplacementInterface{

    private int capacity;
    private ArrayList<Integer> pages;
    private Queue<Integer> pageFrames;
    private int hits;
    private int faults;

    LRU(int capacity){
        this.capacity = capacity;
        this.pages = new ArrayList<>();
        this.pageFrames = new LinkedList<>();
        this.hits = 0;
        this.faults = 0;
    }
    @Override
    public void referencePage(int pageNumber) {
        if(pages.contains(pageNumber)) {
            hits++;
            pageFrames.remove(pageNumber);
        }else{
            faults++;
            if(pageFrames.size() >= capacity){
                int oldestPage = pageFrames.poll();
                pages.remove(Integer.valueOf(oldestPage));
            }
        }
        pages.add(pageNumber);
        pageFrames.add(pageNumber);
    }

    @Override
    public List<Integer> getPageFrames() {
        return new ArrayList<>(pageFrames);
    }

    public int getHits(){
        return hits;
    }

    public int getFaults(){
        return faults;
    }

    public void printPages(){
        System.out.println("Pages " + pages + "\t" +
                "Frames " + pageFrames + "\t" +
                "Faults " + faults + "\t" +
                "Hits " + hits);
    }

}
