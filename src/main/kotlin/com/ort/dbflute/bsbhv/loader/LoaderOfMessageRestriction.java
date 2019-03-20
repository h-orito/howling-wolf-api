package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of MESSAGE_RESTRICTION as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_ID, SKILL_CODE, MESSAGE_TYPE_CODE
 *
 * [column]
 *     VILLAGE_ID, SKILL_CODE, MESSAGE_TYPE_CODE, MESSAGE_MAX_NUM, MESSAGE_MAX_LENGTH, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     MESSAGE_TYPE, SKILL, VILLAGE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     messageType, skill, village
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMessageRestriction {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<MessageRestriction> _selectedList;
    protected BehaviorSelector _selector;
    protected MessageRestrictionBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMessageRestriction ready(List<MessageRestriction> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MessageRestrictionBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MessageRestrictionBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMessageType _foreignMessageTypeLoader;
    public LoaderOfMessageType pulloutMessageType() {
        if (_foreignMessageTypeLoader == null)
        { _foreignMessageTypeLoader = new LoaderOfMessageType().ready(myBhv().pulloutMessageType(_selectedList), _selector); }
        return _foreignMessageTypeLoader;
    }

    protected LoaderOfSkill _foreignSkillLoader;
    public LoaderOfSkill pulloutSkill() {
        if (_foreignSkillLoader == null)
        { _foreignSkillLoader = new LoaderOfSkill().ready(myBhv().pulloutSkill(_selectedList), _selector); }
        return _foreignSkillLoader;
    }

    protected LoaderOfVillage _foreignVillageLoader;
    public LoaderOfVillage pulloutVillage() {
        if (_foreignVillageLoader == null)
        { _foreignVillageLoader = new LoaderOfVillage().ready(myBhv().pulloutVillage(_selectedList), _selector); }
        return _foreignVillageLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<MessageRestriction> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
