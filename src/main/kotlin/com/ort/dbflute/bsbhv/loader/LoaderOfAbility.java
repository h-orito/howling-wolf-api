package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of ABILITY as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_ID, DAY, CHARA_ID, ABILITY_TYPE_CODE
 *
 * [column]
 *     VILLAGE_ID, DAY, CHARA_ID, TARGET_CHARA_ID, ABILITY_TYPE_CODE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     ABILITY_TYPE, CHARA, VILLAGE_DAY
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     abilityType, charaByCharaId, charaByTargetCharaId, villageDay
 *
 * [referrer property]
 *     
 * </pre>
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

    protected LoaderOfChara _foreignCharaByCharaIdLoader;
    public LoaderOfChara pulloutCharaByCharaId() {
        if (_foreignCharaByCharaIdLoader == null)
        { _foreignCharaByCharaIdLoader = new LoaderOfChara().ready(myBhv().pulloutCharaByCharaId(_selectedList), _selector); }
        return _foreignCharaByCharaIdLoader;
    }

    protected LoaderOfChara _foreignCharaByTargetCharaIdLoader;
    public LoaderOfChara pulloutCharaByTargetCharaId() {
        if (_foreignCharaByTargetCharaIdLoader == null)
        { _foreignCharaByTargetCharaIdLoader = new LoaderOfChara().ready(myBhv().pulloutCharaByTargetCharaId(_selectedList), _selector); }
        return _foreignCharaByTargetCharaIdLoader;
    }

    protected LoaderOfVillageDay _foreignVillageDayLoader;
    public LoaderOfVillageDay pulloutVillageDay() {
        if (_foreignVillageDayLoader == null)
        { _foreignVillageDayLoader = new LoaderOfVillageDay().ready(myBhv().pulloutVillageDay(_selectedList), _selector); }
        return _foreignVillageDayLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Ability> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
