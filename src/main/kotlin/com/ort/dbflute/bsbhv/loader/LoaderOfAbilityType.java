package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of ABILITY_TYPE as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfAbilityType {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<AbilityType> _selectedList;
    protected BehaviorSelector _selector;
    protected AbilityTypeBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAbilityType ready(List<AbilityType> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AbilityTypeBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AbilityTypeBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Ability> _referrerAbility;

    /**
     * Load referrer of abilityList by the set-upper of referrer. <br>
     * ABILITY by ABILITY_TYPE_CODE, named 'abilityList'.
     * <pre>
     * <span style="color: #0000C0">abilityTypeBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">abilityTypeList</span>, <span style="color: #553000">typeLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">typeLoader</span>.<span style="color: #CC4747">loadAbility</span>(<span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">abilityCB</span>.setupSelect...
     *         <span style="color: #553000">abilityCB</span>.query().set...
     *         <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">abilityLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    abilityLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (AbilityType abilityType : <span style="color: #553000">abilityTypeList</span>) {
     *     ... = abilityType.<span style="color: #CC4747">getAbilityList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setAbilityTypeCode_InScope(pkList);
     * cb.query().addOrderBy_AbilityTypeCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAbility> loadAbility(ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        myBhv().loadAbility(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAbility = refLs);
        return hd -> hd.handle(new LoaderOfAbility().ready(_referrerAbility, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<AbilityType> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
