package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of MESSAGE as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMessage {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Message> _selectedList;
    protected BehaviorSelector _selector;
    protected MessageBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMessage ready(List<Message> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MessageBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MessageBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<MessageSendto> _referrerMessageSendto;

    /**
     * Load referrer of messageSendtoList by the set-upper of referrer. <br>
     * MESSAGE_SENDTO by VILLAGE_ID, MESSAGE_TYPE_CODE, MESSAGE_NUMBER, named 'messageSendtoList'.
     * <pre>
     * <span style="color: #0000C0">messageBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">messageList</span>, <span style="color: #553000">messageLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">messageLoader</span>.<span style="color: #CC4747">loadMessageSendto</span>(<span style="color: #553000">sendtoCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">sendtoCB</span>.setupSelect...
     *         <span style="color: #553000">sendtoCB</span>.query().set...
     *         <span style="color: #553000">sendtoCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">sendtoLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    sendtoLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Message message : <span style="color: #553000">messageList</span>) {
     *     ... = message.<span style="color: #CC4747">getMessageSendtoList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().set[ForeignKey]_InScope(pkList);
     * cb.query().addOrderBy_[ForeignKey]_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfMessageSendto> loadMessageSendto(ReferrerConditionSetupper<MessageSendtoCB> refCBLambda) {
        myBhv().loadMessageSendto(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerMessageSendto = refLs);
        return hd -> hd.handle(new LoaderOfMessageSendto().ready(_referrerMessageSendto, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Message> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
