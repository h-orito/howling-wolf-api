package com.ort.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of VILLAGE_DAY.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVillageDayCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVillageDayCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "VILLAGE_DAY";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayId The value of villageDayId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageDayId_Equal(Integer villageDayId) {
        doSetVillageDayId_Equal(villageDayId);
    }

    protected void doSetVillageDayId_Equal(Integer villageDayId) {
        regVillageDayId(CK_EQ, villageDayId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayId The value of villageDayId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageDayId_NotEqual(Integer villageDayId) {
        doSetVillageDayId_NotEqual(villageDayId);
    }

    protected void doSetVillageDayId_NotEqual(Integer villageDayId) {
        regVillageDayId(CK_NES, villageDayId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayId The value of villageDayId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageDayId_GreaterThan(Integer villageDayId) {
        regVillageDayId(CK_GT, villageDayId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayId The value of villageDayId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageDayId_LessThan(Integer villageDayId) {
        regVillageDayId(CK_LT, villageDayId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayId The value of villageDayId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageDayId_GreaterEqual(Integer villageDayId) {
        regVillageDayId(CK_GE, villageDayId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayId The value of villageDayId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageDayId_LessEqual(Integer villageDayId) {
        regVillageDayId(CK_LE, villageDayId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of villageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVillageDayId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVillageDayId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of villageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillageDayId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillageDayId(), "VILLAGE_DAY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayIdList The collection of villageDayId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageDayId_InScope(Collection<Integer> villageDayIdList) {
        doSetVillageDayId_InScope(villageDayIdList);
    }

    protected void doSetVillageDayId_InScope(Collection<Integer> villageDayIdList) {
        regINS(CK_INS, cTL(villageDayIdList), xgetCValueVillageDayId(), "VILLAGE_DAY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villageDayIdList The collection of villageDayId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageDayId_NotInScope(Collection<Integer> villageDayIdList) {
        doSetVillageDayId_NotInScope(villageDayIdList);
    }

    protected void doSetVillageDayId_NotInScope(Collection<Integer> villageDayIdList) {
        regINS(CK_NINS, cTL(villageDayIdList), xgetCValueVillageDayId(), "VILLAGE_DAY_ID");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_DAY_ID from ABILITY where ...)} <br>
     * ABILITY by VILLAGE_DAY_ID, named 'abilityAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsAbility</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityList for 'exists'. (NotNull)
     */
    public void existsAbility(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_ExistsReferrer_AbilityList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "abilityList");
    }
    public abstract String keepVillageDayId_ExistsReferrer_AbilityList(AbilityCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_DAY_ID from COMMIT where ...)} <br>
     * COMMIT by VILLAGE_DAY_ID, named 'commitAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsCommit</span>(commitCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     commitCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CommitList for 'exists'. (NotNull)
     */
    public void existsCommit(SubQuery<CommitCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CommitCB cb = new CommitCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_ExistsReferrer_CommitList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "commitList");
    }
    public abstract String keepVillageDayId_ExistsReferrer_CommitList(CommitCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select DEAD_VILLAGE_DAY_ID from VILLAGE_PLAYER where ...)} <br>
     * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillagePlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerList for 'exists'. (NotNull)
     */
    public void existsVillagePlayer(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_ExistsReferrer_VillagePlayerList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "DEAD_VILLAGE_DAY_ID", pp, "villagePlayerList");
    }
    public abstract String keepVillageDayId_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_DAY_ID from VOTE where ...)} <br>
     * VOTE by VILLAGE_DAY_ID, named 'voteAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVote</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VoteList for 'exists'. (NotNull)
     */
    public void existsVote(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_ExistsReferrer_VoteList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "voteList");
    }
    public abstract String keepVillageDayId_ExistsReferrer_VoteList(VoteCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_DAY_ID from ABILITY where ...)} <br>
     * ABILITY by VILLAGE_DAY_ID, named 'abilityAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsAbility</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageDayId_NotExistsReferrer_AbilityList for 'not exists'. (NotNull)
     */
    public void notExistsAbility(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_NotExistsReferrer_AbilityList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "abilityList");
    }
    public abstract String keepVillageDayId_NotExistsReferrer_AbilityList(AbilityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_DAY_ID from COMMIT where ...)} <br>
     * COMMIT by VILLAGE_DAY_ID, named 'commitAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsCommit</span>(commitCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     commitCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageDayId_NotExistsReferrer_CommitList for 'not exists'. (NotNull)
     */
    public void notExistsCommit(SubQuery<CommitCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CommitCB cb = new CommitCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_NotExistsReferrer_CommitList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "commitList");
    }
    public abstract String keepVillageDayId_NotExistsReferrer_CommitList(CommitCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select DEAD_VILLAGE_DAY_ID from VILLAGE_PLAYER where ...)} <br>
     * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageDayId_NotExistsReferrer_VillagePlayerList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayer(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_NotExistsReferrer_VillagePlayerList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "DEAD_VILLAGE_DAY_ID", pp, "villagePlayerList");
    }
    public abstract String keepVillageDayId_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_DAY_ID from VOTE where ...)} <br>
     * VOTE by VILLAGE_DAY_ID, named 'voteAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVote</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageDayId_NotExistsReferrer_VoteList for 'not exists'. (NotNull)
     */
    public void notExistsVote(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageDayId_NotExistsReferrer_VoteList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "voteList");
    }
    public abstract String keepVillageDayId_NotExistsReferrer_VoteList(VoteCQ sq);

    public void xsderiveAbilityList(String fn, SubQuery<AbilityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillageDayId_SpecifyDerivedReferrer_AbilityList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "abilityList", al, op);
    }
    public abstract String keepVillageDayId_SpecifyDerivedReferrer_AbilityList(AbilityCQ sq);

    public void xsderiveCommitList(String fn, SubQuery<CommitCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CommitCB cb = new CommitCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillageDayId_SpecifyDerivedReferrer_CommitList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "commitList", al, op);
    }
    public abstract String keepVillageDayId_SpecifyDerivedReferrer_CommitList(CommitCQ sq);

    public void xsderiveVillagePlayerList(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillageDayId_SpecifyDerivedReferrer_VillagePlayerList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "DEAD_VILLAGE_DAY_ID", pp, "villagePlayerList", al, op);
    }
    public abstract String keepVillageDayId_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq);

    public void xsderiveVoteList(String fn, SubQuery<VoteCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillageDayId_SpecifyDerivedReferrer_VoteList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", pp, "voteList", al, op);
    }
    public abstract String keepVillageDayId_SpecifyDerivedReferrer_VoteList(VoteCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from ABILITY where ...)} <br>
     * ABILITY by VILLAGE_DAY_ID, named 'abilityAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedAbility()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     abilityCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<AbilityCB> derivedAbility() {
        return xcreateQDRFunctionAbilityList();
    }
    protected HpQDRFunction<AbilityCB> xcreateQDRFunctionAbilityList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveAbilityList(fn, sq, rd, vl, op));
    }
    public void xqderiveAbilityList(String fn, SubQuery<AbilityCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillageDayId_QueryDerivedReferrer_AbilityList(cb.query()); String prpp = keepVillageDayId_QueryDerivedReferrer_AbilityListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", sqpp, "abilityList", rd, vl, prpp, op);
    }
    public abstract String keepVillageDayId_QueryDerivedReferrer_AbilityList(AbilityCQ sq);
    public abstract String keepVillageDayId_QueryDerivedReferrer_AbilityListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from COMMIT where ...)} <br>
     * COMMIT by VILLAGE_DAY_ID, named 'commitAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedCommit()</span>.<span style="color: #CC4747">max</span>(commitCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     commitCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     commitCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<CommitCB> derivedCommit() {
        return xcreateQDRFunctionCommitList();
    }
    protected HpQDRFunction<CommitCB> xcreateQDRFunctionCommitList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveCommitList(fn, sq, rd, vl, op));
    }
    public void xqderiveCommitList(String fn, SubQuery<CommitCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CommitCB cb = new CommitCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillageDayId_QueryDerivedReferrer_CommitList(cb.query()); String prpp = keepVillageDayId_QueryDerivedReferrer_CommitListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", sqpp, "commitList", rd, vl, prpp, op);
    }
    public abstract String keepVillageDayId_QueryDerivedReferrer_CommitList(CommitCQ sq);
    public abstract String keepVillageDayId_QueryDerivedReferrer_CommitListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from VILLAGE_PLAYER where ...)} <br>
     * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillagePlayer()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     playerCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerCB> derivedVillagePlayer() {
        return xcreateQDRFunctionVillagePlayerList();
    }
    protected HpQDRFunction<VillagePlayerCB> xcreateQDRFunctionVillagePlayerList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillagePlayerList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillagePlayerList(String fn, SubQuery<VillagePlayerCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillageDayId_QueryDerivedReferrer_VillagePlayerList(cb.query()); String prpp = keepVillageDayId_QueryDerivedReferrer_VillagePlayerListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "DEAD_VILLAGE_DAY_ID", sqpp, "villagePlayerList", rd, vl, prpp, op);
    }
    public abstract String keepVillageDayId_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq);
    public abstract String keepVillageDayId_QueryDerivedReferrer_VillagePlayerListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from VOTE where ...)} <br>
     * VOTE by VILLAGE_DAY_ID, named 'voteAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVote()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     voteCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VoteCB> derivedVote() {
        return xcreateQDRFunctionVoteList();
    }
    protected HpQDRFunction<VoteCB> xcreateQDRFunctionVoteList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVoteList(fn, sq, rd, vl, op));
    }
    public void xqderiveVoteList(String fn, SubQuery<VoteCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillageDayId_QueryDerivedReferrer_VoteList(cb.query()); String prpp = keepVillageDayId_QueryDerivedReferrer_VoteListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_DAY_ID", "VILLAGE_DAY_ID", sqpp, "voteList", rd, vl, prpp, op);
    }
    public abstract String keepVillageDayId_QueryDerivedReferrer_VoteList(VoteCQ sq);
    public abstract String keepVillageDayId_QueryDerivedReferrer_VoteListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setVillageDayId_IsNull() { regVillageDayId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setVillageDayId_IsNotNull() { regVillageDayId(CK_ISNN, DOBJ); }

    protected void regVillageDayId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageDayId(), "VILLAGE_DAY_ID"); }
    protected abstract ConditionValue xgetCValueVillageDayId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_Equal(Integer villageId) {
        doSetVillageId_Equal(villageId);
    }

    protected void doSetVillageId_Equal(Integer villageId) {
        regVillageId(CK_EQ, villageId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_NotEqual(Integer villageId) {
        doSetVillageId_NotEqual(villageId);
    }

    protected void doSetVillageId_NotEqual(Integer villageId) {
        regVillageId(CK_NES, villageId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterThan(Integer villageId) {
        regVillageId(CK_GT, villageId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessThan(Integer villageId) {
        regVillageId(CK_LT, villageId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterEqual(Integer villageId) {
        regVillageId(CK_GE, villageId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessEqual(Integer villageId) {
        regVillageId(CK_LE, villageId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param minNumber The min number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVillageId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVillageId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param minNumber The min number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillageId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillageId(), "VILLAGE_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageIdList The collection of villageId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageId_InScope(Collection<Integer> villageIdList) {
        doSetVillageId_InScope(villageIdList);
    }

    protected void doSetVillageId_InScope(Collection<Integer> villageIdList) {
        regINS(CK_INS, cTL(villageIdList), xgetCValueVillageId(), "VILLAGE_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageIdList The collection of villageId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageId_NotInScope(Collection<Integer> villageIdList) {
        doSetVillageId_NotInScope(villageIdList);
    }

    protected void doSetVillageId_NotInScope(Collection<Integer> villageIdList) {
        regINS(CK_NINS, cTL(villageIdList), xgetCValueVillageId(), "VILLAGE_ID");
    }

    protected void regVillageId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageId(), "VILLAGE_ID"); }
    protected abstract ConditionValue xgetCValueVillageId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param day The value of day as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDay_Equal(Integer day) {
        doSetDay_Equal(day);
    }

    protected void doSetDay_Equal(Integer day) {
        regDay(CK_EQ, day);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param day The value of day as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDay_NotEqual(Integer day) {
        doSetDay_NotEqual(day);
    }

    protected void doSetDay_NotEqual(Integer day) {
        regDay(CK_NES, day);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param day The value of day as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDay_GreaterThan(Integer day) {
        regDay(CK_GT, day);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param day The value of day as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDay_LessThan(Integer day) {
        regDay(CK_LT, day);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param day The value of day as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDay_GreaterEqual(Integer day) {
        regDay(CK_GE, day);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param day The value of day as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDay_LessEqual(Integer day) {
        regDay(CK_LE, day);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of day. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of day. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDay_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDay_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of day. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of day. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDay_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDay(), "DAY", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param dayList The collection of day as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDay_InScope(Collection<Integer> dayList) {
        doSetDay_InScope(dayList);
    }

    protected void doSetDay_InScope(Collection<Integer> dayList) {
        regINS(CK_INS, cTL(dayList), xgetCValueDay(), "DAY");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @param dayList The collection of day as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDay_NotInScope(Collection<Integer> dayList) {
        doSetDay_NotInScope(dayList);
    }

    protected void doSetDay_NotInScope(Collection<Integer> dayList) {
        regINS(CK_NINS, cTL(dayList), xgetCValueDay(), "DAY");
    }

    protected void regDay(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDay(), "DAY"); }
    protected abstract ConditionValue xgetCValueDay();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight}
     * @param noonnightCode The value of noonnightCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_Equal(String noonnightCode) {
        doSetNoonnightCode_Equal(fRES(noonnightCode));
    }

    /**
     * Equal(=). As Noonnight. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight} <br>
     * 昼夜
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight cdef) {
        doSetNoonnightCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 夜 (NIGHT). And OnlyOnceRegistered. <br>
     * 夜
     */
    public void setNoonnightCode_Equal_夜() {
        setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight.夜);
    }

    /**
     * Equal(=). As 昼 (NOON). And OnlyOnceRegistered. <br>
     * 昼
     */
    public void setNoonnightCode_Equal_昼() {
        setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight.昼);
    }

    protected void doSetNoonnightCode_Equal(String noonnightCode) {
        regNoonnightCode(CK_EQ, noonnightCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight}
     * @param noonnightCode The value of noonnightCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_NotEqual(String noonnightCode) {
        doSetNoonnightCode_NotEqual(fRES(noonnightCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Noonnight. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight} <br>
     * 昼夜
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setNoonnightCode_NotEqual_AsNoonnight(CDef.Noonnight cdef) {
        doSetNoonnightCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 夜 (NIGHT). And OnlyOnceRegistered. <br>
     * 夜
     */
    public void setNoonnightCode_NotEqual_夜() {
        setNoonnightCode_NotEqual_AsNoonnight(CDef.Noonnight.夜);
    }

    /**
     * NotEqual(&lt;&gt;). As 昼 (NOON). And OnlyOnceRegistered. <br>
     * 昼
     */
    public void setNoonnightCode_NotEqual_昼() {
        setNoonnightCode_NotEqual_AsNoonnight(CDef.Noonnight.昼);
    }

    protected void doSetNoonnightCode_NotEqual(String noonnightCode) {
        regNoonnightCode(CK_NES, noonnightCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight}
     * @param noonnightCodeList The collection of noonnightCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_InScope(Collection<String> noonnightCodeList) {
        doSetNoonnightCode_InScope(noonnightCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Noonnight. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight} <br>
     * 昼夜
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightCode_InScope_AsNoonnight(Collection<CDef.Noonnight> cdefList) {
        doSetNoonnightCode_InScope(cTStrL(cdefList));
    }

    protected void doSetNoonnightCode_InScope(Collection<String> noonnightCodeList) {
        regINS(CK_INS, cTL(noonnightCodeList), xgetCValueNoonnightCode(), "NOONNIGHT_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight}
     * @param noonnightCodeList The collection of noonnightCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_NotInScope(Collection<String> noonnightCodeList) {
        doSetNoonnightCode_NotInScope(noonnightCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Noonnight. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight} <br>
     * 昼夜
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightCode_NotInScope_AsNoonnight(Collection<CDef.Noonnight> cdefList) {
        doSetNoonnightCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetNoonnightCode_NotInScope(Collection<String> noonnightCodeList) {
        regINS(CK_NINS, cTL(noonnightCodeList), xgetCValueNoonnightCode(), "NOONNIGHT_CODE");
    }

    protected void regNoonnightCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueNoonnightCode(), "NOONNIGHT_CODE"); }
    protected abstract ConditionValue xgetCValueNoonnightCode();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @param daychangeDatetime The value of daychangeDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDaychangeDatetime_Equal(java.time.LocalDateTime daychangeDatetime) {
        regDaychangeDatetime(CK_EQ,  daychangeDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @param daychangeDatetime The value of daychangeDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDaychangeDatetime_GreaterThan(java.time.LocalDateTime daychangeDatetime) {
        regDaychangeDatetime(CK_GT,  daychangeDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @param daychangeDatetime The value of daychangeDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDaychangeDatetime_LessThan(java.time.LocalDateTime daychangeDatetime) {
        regDaychangeDatetime(CK_LT,  daychangeDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @param daychangeDatetime The value of daychangeDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDaychangeDatetime_GreaterEqual(java.time.LocalDateTime daychangeDatetime) {
        regDaychangeDatetime(CK_GE,  daychangeDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @param daychangeDatetime The value of daychangeDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDaychangeDatetime_LessEqual(java.time.LocalDateTime daychangeDatetime) {
        regDaychangeDatetime(CK_LE, daychangeDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setDaychangeDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of daychangeDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of daychangeDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setDaychangeDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setDaychangeDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setDaychangeDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of daychangeDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of daychangeDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setDaychangeDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "DAYCHANGE_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueDaychangeDatetime(), nm, op);
    }

    protected void regDaychangeDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDaychangeDatetime(), "DAYCHANGE_DATETIME"); }
    protected abstract ConditionValue xgetCValueDaychangeDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_Equal(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GT,  registerDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LT,  registerDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GE,  registerDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LE, registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setRegisterDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "REGISTER_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueRegisterDatetime(), nm, op);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterDatetime(), "REGISTER_DATETIME"); }
    protected abstract ConditionValue xgetCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_Equal(String registerTrace) {
        doSetRegisterTrace_Equal(fRES(registerTrace));
    }

    protected void doSetRegisterTrace_Equal(String registerTrace) {
        regRegisterTrace(CK_EQ, registerTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_NotEqual(String registerTrace) {
        doSetRegisterTrace_NotEqual(fRES(registerTrace));
    }

    protected void doSetRegisterTrace_NotEqual(String registerTrace) {
        regRegisterTrace(CK_NES, registerTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_GreaterThan(String registerTrace) {
        regRegisterTrace(CK_GT, fRES(registerTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_LessThan(String registerTrace) {
        regRegisterTrace(CK_LT, fRES(registerTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_GreaterEqual(String registerTrace) {
        regRegisterTrace(CK_GE, fRES(registerTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_LessEqual(String registerTrace) {
        regRegisterTrace(CK_LE, fRES(registerTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTraceList The collection of registerTrace as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_InScope(Collection<String> registerTraceList) {
        doSetRegisterTrace_InScope(registerTraceList);
    }

    protected void doSetRegisterTrace_InScope(Collection<String> registerTraceList) {
        regINS(CK_INS, cTL(registerTraceList), xgetCValueRegisterTrace(), "REGISTER_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTraceList The collection of registerTrace as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_NotInScope(Collection<String> registerTraceList) {
        doSetRegisterTrace_NotInScope(registerTraceList);
    }

    protected void doSetRegisterTrace_NotInScope(Collection<String> registerTraceList) {
        regINS(CK_NINS, cTL(registerTraceList), xgetCValueRegisterTrace(), "REGISTER_TRACE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setRegisterTrace_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerTrace The value of registerTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterTrace_LikeSearch(String registerTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterTrace_LikeSearch(registerTrace, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setRegisterTrace_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerTrace The value of registerTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterTrace_LikeSearch(String registerTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerTrace), xgetCValueRegisterTrace(), "REGISTER_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterTrace_NotLikeSearch(String registerTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterTrace_NotLikeSearch(registerTrace, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterTrace_NotLikeSearch(String registerTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerTrace), xgetCValueRegisterTrace(), "REGISTER_TRACE", likeSearchOption);
    }

    protected void regRegisterTrace(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterTrace(), "REGISTER_TRACE"); }
    protected abstract ConditionValue xgetCValueRegisterTrace();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_Equal(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GT,  updateDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LT,  updateDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GE,  updateDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LE, updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setUpdateDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "UPDATE_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueUpdateDatetime(), nm, op);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue xgetCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_Equal(String updateTrace) {
        doSetUpdateTrace_Equal(fRES(updateTrace));
    }

    protected void doSetUpdateTrace_Equal(String updateTrace) {
        regUpdateTrace(CK_EQ, updateTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_NotEqual(String updateTrace) {
        doSetUpdateTrace_NotEqual(fRES(updateTrace));
    }

    protected void doSetUpdateTrace_NotEqual(String updateTrace) {
        regUpdateTrace(CK_NES, updateTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_GreaterThan(String updateTrace) {
        regUpdateTrace(CK_GT, fRES(updateTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_LessThan(String updateTrace) {
        regUpdateTrace(CK_LT, fRES(updateTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_GreaterEqual(String updateTrace) {
        regUpdateTrace(CK_GE, fRES(updateTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_LessEqual(String updateTrace) {
        regUpdateTrace(CK_LE, fRES(updateTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTraceList The collection of updateTrace as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_InScope(Collection<String> updateTraceList) {
        doSetUpdateTrace_InScope(updateTraceList);
    }

    protected void doSetUpdateTrace_InScope(Collection<String> updateTraceList) {
        regINS(CK_INS, cTL(updateTraceList), xgetCValueUpdateTrace(), "UPDATE_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTraceList The collection of updateTrace as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_NotInScope(Collection<String> updateTraceList) {
        doSetUpdateTrace_NotInScope(updateTraceList);
    }

    protected void doSetUpdateTrace_NotInScope(Collection<String> updateTraceList) {
        regINS(CK_NINS, cTL(updateTraceList), xgetCValueUpdateTrace(), "UPDATE_TRACE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setUpdateTrace_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateTrace The value of updateTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateTrace_LikeSearch(String updateTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateTrace_LikeSearch(updateTrace, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setUpdateTrace_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateTrace The value of updateTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateTrace_LikeSearch(String updateTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateTrace), xgetCValueUpdateTrace(), "UPDATE_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateTrace_NotLikeSearch(String updateTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateTrace_NotLikeSearch(updateTrace, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateTrace_NotLikeSearch(String updateTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateTrace), xgetCValueUpdateTrace(), "UPDATE_TRACE", likeSearchOption);
    }

    protected void regUpdateTrace(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateTrace(), "UPDATE_TRACE"); }
    protected abstract ConditionValue xgetCValueUpdateTrace();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageDayCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, VillageDayCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageDayCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, VillageDayCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageDayCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, VillageDayCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageDayCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, VillageDayCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageDayCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, VillageDayCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VillageDayCB&gt;() {
     *     public void query(VillageDayCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageDayCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, VillageDayCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageDayCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(VillageDayCQ sq);

    protected VillageDayCB xcreateScalarConditionCB() {
        VillageDayCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VillageDayCB xcreateScalarConditionPartitionByCB() {
        VillageDayCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VillageDayCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "VILLAGE_DAY_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VillageDayCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VillageDayCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VillageDayCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VILLAGE_DAY_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VillageDayCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<VillageDayCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VillageDayCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected VillageDayCB newMyCB() {
        return new VillageDayCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return VillageDayCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
