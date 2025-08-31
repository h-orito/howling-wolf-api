package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of VILLAGE_SETTING as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVillageSetting {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<VillageSetting> _selectedList;
    protected BehaviorSelector _selector;
    protected VillageSettingBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVillageSetting ready(List<VillageSetting> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VillageSettingBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VillageSettingBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfVillage _foreignVillageLoader;
    public LoaderOfVillage pulloutVillage() {
        if (_foreignVillageLoader == null)
        { _foreignVillageLoader = new LoaderOfVillage().ready(myBhv().pulloutVillage(_selectedList), _selector); }
        return _foreignVillageLoader;
    }

    protected LoaderOfVillageSettingItem _foreignVillageSettingItemLoader;
    public LoaderOfVillageSettingItem pulloutVillageSettingItem() {
        if (_foreignVillageSettingItemLoader == null)
        { _foreignVillageSettingItemLoader = new LoaderOfVillageSettingItem().ready(myBhv().pulloutVillageSettingItem(_selectedList), _selector); }
        return _foreignVillageSettingItemLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<VillageSetting> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
