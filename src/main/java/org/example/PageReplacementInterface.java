package org.example;
import java.util.List;


public interface PageReplacementInterface {

    /**
     * Reference a page
     * @param pageNumber the page number to reference
     */

    void referencePage(int pageNumber);

    /**
     * Get the page frames
     * @return the page frames
     */

    List<Integer> getPageFrames();

    /**
     * Get the number of hits and faults
     * @return the number of hits and faults
     */
    int getHits();

    /**
     * Get the number of faults
     * @return the number of faults
     */
    int getFaults();

    /**
     * Print the pages, frames, faults, and hits
     */

    void printPages();


}
