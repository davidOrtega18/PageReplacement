package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageReplacementTest {


    @Test
    public void testFIFOAlgorithm(){
        List<Integer> referenceString = Arrays.asList(1,2, 3, 4, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3);
        int pageFrames = 4;

        PageReplacementInterface fifo = new FIFO(pageFrames);
        runPageReplacement(fifo, referenceString);

        assertEquals(11, fifo.getFaults());
        assertEquals(3, fifo.getHits());

    }

    @Test
    public void testLRU(){
        List<Integer> referenceString = Arrays.asList(1,2, 3, 4, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3);
        int pageFrames = 4;

        PageReplacementInterface lru = new LRU(pageFrames);
        runPageReplacement(lru, referenceString);

        assertEquals(10, lru.getFaults());
        assertEquals(4, lru.getHits());

    }

    @Test
    public void testOPT(){
        List<Integer> referenceString = Arrays.asList(1,2, 3, 4, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3);
        int pageFrames = 4;

        PageReplacementInterface opt = new OPT(pageFrames);
        runPageReplacement(opt, referenceString);

        assertEquals(7, opt.getFaults());
        assertEquals(7, opt.getHits());

    }


    private void runPageReplacement(PageReplacementInterface pageReplacementInterface, List<Integer> referenceString){
        for(int pageNumber : referenceString){
            pageReplacementInterface.referencePage(pageNumber);
        }
    }

}
