package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of MESSAGE_TYPE as TABLE. <br>
 * <pre>
 * [primary key]
 *     MESSAGE_TYPE_CODE
 *
 * [column]
 *     MESSAGE_TYPE_CODE, MESSAGE_TYPE_NAME
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
 *     
 *
 * [referrer table]
 *     MESSAGE_RESTRICTION
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     messageRestrictionList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMessageType {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<MessageType> _selectedList;
    protected BehaviorSelector _selector;
    protected MessageTypeBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMessageType ready(List<MessageType> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MessageTypeBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MessageTypeBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<MessageRestriction> _referrerMessageRestriction;

    /**
     * Load referrer of messageRestrictionList by the set-upper of referrer. <br>
     * MESSAGE_RESTRICTION by MESSAGE_TYPE_CODE, named 'messageRestrictionList'.
     * <pre>
     * <span style="color: #0000C0">messageTypeBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">messageTypeList</span>, <span style="color: #553000">typeLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">typeLoader</span>.<span style="color: #CC4747">loadMessageRestriction</span>(<span style="color: #553000">restrictionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">restrictionCB</span>.setupSelect...
     *         <span style="color: #553000">restrictionCB</span>.query().set...
     *         <span style="color: #553000">restrictionCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">restrictionLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    restrictionLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (MessageType messageType : <span style="color: #553000">messageTypeList</span>) {
     *     ... = messageType.<span style="color: #CC4747">getMessageRestrictionList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setMessageTypeCode_InScope(pkList);
     * cb.query().addOrderBy_MessageTypeCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfMessageRestriction> loadMessageRestriction(ReferrerConditionSetupper<MessageRestrictionCB> refCBLambda) {
        myBhv().loadMessageRestriction(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerMessageRestriction = refLs);
        return hd -> hd.handle(new LoaderOfMessageRestriction().ready(_referrerMessageRestriction, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<MessageType> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
