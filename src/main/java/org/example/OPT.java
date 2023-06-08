package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OPT implements PageReplacementInterface{
    private int capacity;
    private ArrayList<Integer> pages;
    private List<Integer> frames;
    private int hits;
    private int faults;

    public OPT(int capacity) {
        this.capacity = capacity;
        this.pages = new ArrayList<>();
        this.frames = new ArrayList<>();
        this.hits = 0;
        this.faults = 0;
    }

    @Override
    public void referencePage(int pageNumber) {
        if (frames.contains(pageNumber)) {
            hits++;
        } else {
            if (frames.size() >= capacity) {
                int pageToReplace = findPageToReplace(pageNumber);
                frames.set(pageToReplace, pageNumber);
            } else {
                frames.add(pageNumber);

            }
            faults++;
        }

        pages.add(pageNumber);
    }

    @Override
    public List<Integer> getPageFrames() {
        return frames;
    }

    public int getHits() {
        return hits;
    }

    public int getFaults() {
        return faults;
    }

    private int findPageToReplace(int pageNumber) {
        int index = -1;
        int farthestIndex = 0;

        Set<Integer> futurePages = new HashSet<>(pages.subList(pages.indexOf(pageNumber) + 1, pages.size()));

        for (int i = 0; i < frames.size(); i++) {
            int currentFrame = frames.get(i);
            if (!futurePages.contains(currentFrame)) {
                return i;
            } else {
                int futureIndex = pages.indexOf(currentFrame + 1);
                if (futureIndex > farthestIndex) {
                    farthestIndex = futureIndex;
                    index = i;
                }
            }
        }

        return index == -1 ? 0 : index;
    }

    public void printPages(){
        System.out.println("Pages " + pages + "\t" +
                           "Frames " + frames + "\t" +
                           "Faults " + faults + "\t" +
                           "Hits " + hits);
    }

}
