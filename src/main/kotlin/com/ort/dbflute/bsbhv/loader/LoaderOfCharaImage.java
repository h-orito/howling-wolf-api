package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of CHARA_IMAGE as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfCharaImage {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<CharaImage> _selectedList;
    protected BehaviorSelector _selector;
    protected CharaImageBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfCharaImage ready(List<CharaImage> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected CharaImageBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(CharaImageBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfChara _foreignCharaLoader;
    public LoaderOfChara pulloutChara() {
        if (_foreignCharaLoader == null)
        { _foreignCharaLoader = new LoaderOfChara().ready(myBhv().pulloutChara(_selectedList), _selector); }
        return _foreignCharaLoader;
    }

    protected LoaderOfFaceType _foreignFaceTypeLoader;
    public LoaderOfFaceType pulloutFaceType() {
        if (_foreignFaceTypeLoader == null)
        { _foreignFaceTypeLoader = new LoaderOfFaceType().ready(myBhv().pulloutFaceType(_selectedList), _selector); }
        return _foreignFaceTypeLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<CharaImage> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
