package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of ABILITY as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfAbility {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Ability> _selectedList;
    protected BehaviorSelector _selector;
    protected AbilityBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAbility ready(List<Ability> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AbilityBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AbilityBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfAbilityType _foreignAbilityTypeLoader;
    public LoaderOfAbilityType pulloutAbilityType() {
        if (_foreignAbilityTypeLoader == null)
        { _foreignAbilityTypeLoader = new LoaderOfAbilityType().ready(myBhv().pulloutAbilityType(_selectedList), _selector); }
        return _foreignAbilityTypeLoader;
    }

    protected LoaderOfVillagePlayer _foreignVillagePlayerByTargetVillagePlayerIdLoader;
    public LoaderOfVillagePlayer pulloutVillagePlayerByTargetVillagePlayerId() {
        if (_foreignVillagePlayerByTargetVillagePlayerIdLoader == null)
        { _foreignVillagePlayerByTargetVillagePlayerIdLoader = new LoaderOfVillagePlayer().ready(myBhv().pulloutVillagePlayerByTargetVillagePlayerId(_selectedList), _selector); }
        return _foreignVillagePlayerByTargetVillagePlayerIdLoader;
    }

    protected LoaderOfVillageDay _foreignVillageDayLoader;
    public LoaderOfVillageDay pulloutVillageDay() {
        if (_foreignVillageDayLoader == null)
        { _foreignVillageDayLoader = new LoaderOfVillageDay().ready(myBhv().pulloutVillageDay(_selectedList), _selector); }
        return _foreignVillageDayLoader;
    }

    protected LoaderOfVillagePlayer _foreignVillagePlayerByVillagePlayerIdLoader;
    public LoaderOfVillagePlayer pulloutVillagePlayerByVillagePlayerId() {
        if (_foreignVillagePlayerByVillagePlayerIdLoader == null)
        { _foreignVillagePlayerByVillagePlayerIdLoader = new LoaderOfVillagePlayer().ready(myBhv().pulloutVillagePlayerByVillagePlayerId(_selectedList), _selector); }
        return _foreignVillagePlayerByVillagePlayerIdLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Ability> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
