package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of VOTE as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_ID, DAY, CHARA_ID
 *
 * [column]
 *     VILLAGE_ID, DAY, CHARA_ID, VOTE_CHARA_ID, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     CHARA, VILLAGE_DAY
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     charaByCharaId, villageDay, charaByVoteCharaId
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVote {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Vote> _selectedList;
    protected BehaviorSelector _selector;
    protected VoteBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVote ready(List<Vote> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VoteBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VoteBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfChara _foreignCharaByCharaIdLoader;
    public LoaderOfChara pulloutCharaByCharaId() {
        if (_foreignCharaByCharaIdLoader == null)
        { _foreignCharaByCharaIdLoader = new LoaderOfChara().ready(myBhv().pulloutCharaByCharaId(_selectedList), _selector); }
        return _foreignCharaByCharaIdLoader;
    }

    protected LoaderOfVillageDay _foreignVillageDayLoader;
    public LoaderOfVillageDay pulloutVillageDay() {
        if (_foreignVillageDayLoader == null)
        { _foreignVillageDayLoader = new LoaderOfVillageDay().ready(myBhv().pulloutVillageDay(_selectedList), _selector); }
        return _foreignVillageDayLoader;
    }

    protected LoaderOfChara _foreignCharaByVoteCharaIdLoader;
    public LoaderOfChara pulloutCharaByVoteCharaId() {
        if (_foreignCharaByVoteCharaIdLoader == null)
        { _foreignCharaByVoteCharaIdLoader = new LoaderOfChara().ready(myBhv().pulloutCharaByVoteCharaId(_selectedList), _selector); }
        return _foreignCharaByVoteCharaIdLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Vote> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
