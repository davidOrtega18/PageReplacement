package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] referenceStringSizes = {10, 15, 20};
        int[] pageFrameCounts = {3, 5, 7};


        for (int rss : referenceStringSizes) {
            for (int npf : pageFrameCounts) {
                System.out.println("Reference String Size: " + rss);
                System.out.println("Number of Page Frames: " + npf);

                // Generate random reference string
                List<Integer> referenceString = generateRandomReferenceString(rss);

                // FIFO Algorithm
                PageReplacementInterface fifoAlgorithm = new FIFO(npf);
                runPageReplacementAlgorithm(fifoAlgorithm, referenceString);
                fifoAlgorithm.printPages();
                System.out.println();



                // OPT Algorithm
                PageReplacementInterface optAlgorithm = new OPT(npf);
                runPageReplacementAlgorithm(optAlgorithm, referenceString);
                optAlgorithm.printPages();
                System.out.println();



                // LRU Algorithm
                PageReplacementInterface lruAlgorithm = new LRU(npf);
                runPageReplacementAlgorithm(lruAlgorithm, referenceString);
                lruAlgorithm.printPages();
                System.out.println();




            }
        }
    }

    private static List<Integer> generateRandomReferenceString(int size) {
        List<Integer> referenceString = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            referenceString.add(random.nextInt(10)); // Generating random page numbers from 0 to 9
        }
        return referenceString;
    }

    private static void runPageReplacementAlgorithm(PageReplacementInterface algorithm, List<Integer> referenceString) {
        for (int pageNumber : referenceString) {
            algorithm.referencePage(pageNumber);
        }
        List<Integer> pageFrames = algorithm.getPageFrames();

        System.out.println("Page Frames: " + pageFrames);
    }
}