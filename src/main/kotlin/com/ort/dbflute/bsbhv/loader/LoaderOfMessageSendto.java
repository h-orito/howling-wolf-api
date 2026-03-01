package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of MESSAGE_SENDTO as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMessageSendto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<MessageSendto> _selectedList;
    protected BehaviorSelector _selector;
    protected MessageSendtoBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMessageSendto ready(List<MessageSendto> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MessageSendtoBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MessageSendtoBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfVillagePlayer _foreignVillagePlayerLoader;
    public LoaderOfVillagePlayer pulloutVillagePlayer() {
        if (_foreignVillagePlayerLoader == null)
        { _foreignVillagePlayerLoader = new LoaderOfVillagePlayer().ready(myBhv().pulloutVillagePlayer(_selectedList), _selector); }
        return _foreignVillagePlayerLoader;
    }

    protected LoaderOfMessage _foreignMessageLoader;
    public LoaderOfMessage pulloutMessage() {
        if (_foreignMessageLoader == null)
        { _foreignMessageLoader = new LoaderOfMessage().ready(myBhv().pulloutMessage(_selectedList), _selector); }
        return _foreignMessageLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<MessageSendto> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
