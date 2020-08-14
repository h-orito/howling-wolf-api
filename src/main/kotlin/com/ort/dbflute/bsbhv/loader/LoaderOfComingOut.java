package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of COMING_OUT as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_PLAYER_ID, SKILL_CODE
 *
 * [column]
 *     VILLAGE_PLAYER_ID, SKILL_CODE
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
 *     SKILL, VILLAGE_PLAYER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     skill, villagePlayer
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfComingOut {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<ComingOut> _selectedList;
    protected BehaviorSelector _selector;
    protected ComingOutBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfComingOut ready(List<ComingOut> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected ComingOutBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(ComingOutBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfSkill _foreignSkillLoader;
    public LoaderOfSkill pulloutSkill() {
        if (_foreignSkillLoader == null)
        { _foreignSkillLoader = new LoaderOfSkill().ready(myBhv().pulloutSkill(_selectedList), _selector); }
        return _foreignSkillLoader;
    }

    protected LoaderOfVillagePlayer _foreignVillagePlayerLoader;
    public LoaderOfVillagePlayer pulloutVillagePlayer() {
        if (_foreignVillagePlayerLoader == null)
        { _foreignVillagePlayerLoader = new LoaderOfVillagePlayer().ready(myBhv().pulloutVillagePlayer(_selectedList), _selector); }
        return _foreignVillagePlayerLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<ComingOut> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
