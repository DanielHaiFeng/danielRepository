package com.xa.dt.mode.principle.isp;

/**
 * @author DangTing[dangting@boco.com.cn]
 * @date 2019-11-04 09:39
 * @version: 1.0
 * @description: TODO
 */
public class Searcher extends AbstractSearcher {

    public PettyGirl pettyGirl;

    public Searcher(PettyGirl pettyGirl) {
        this.pettyGirl = pettyGirl;
    }

    @Override
    void show() {
        pettyGirl.goodLooking();
        pettyGirl.niceFigure();
        pettyGirl.greatTemperament();
    }
}

