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
 * The abstract condition-query of village_player.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVillagePlayerCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVillagePlayerCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "village_player";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerId The value of villagePlayerId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_Equal(Integer villagePlayerId) {
        doSetVillagePlayerId_Equal(villagePlayerId);
    }

    protected void doSetVillagePlayerId_Equal(Integer villagePlayerId) {
        regVillagePlayerId(CK_EQ, villagePlayerId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerId The value of villagePlayerId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_NotEqual(Integer villagePlayerId) {
        doSetVillagePlayerId_NotEqual(villagePlayerId);
    }

    protected void doSetVillagePlayerId_NotEqual(Integer villagePlayerId) {
        regVillagePlayerId(CK_NES, villagePlayerId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerId The value of villagePlayerId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_GreaterThan(Integer villagePlayerId) {
        regVillagePlayerId(CK_GT, villagePlayerId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerId The value of villagePlayerId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_LessThan(Integer villagePlayerId) {
        regVillagePlayerId(CK_LT, villagePlayerId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerId The value of villagePlayerId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_GreaterEqual(Integer villagePlayerId) {
        regVillagePlayerId(CK_GE, villagePlayerId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerId The value of villagePlayerId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_LessEqual(Integer villagePlayerId) {
        regVillagePlayerId(CK_LE, villagePlayerId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of villagePlayerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villagePlayerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVillagePlayerId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVillagePlayerId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of villagePlayerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villagePlayerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillagePlayerId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerIdList The collection of villagePlayerId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillagePlayerId_InScope(Collection<Integer> villagePlayerIdList) {
        doSetVillagePlayerId_InScope(villagePlayerIdList);
    }

    protected void doSetVillagePlayerId_InScope(Collection<Integer> villagePlayerIdList) {
        regINS(CK_INS, cTL(villagePlayerIdList), xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param villagePlayerIdList The collection of villagePlayerId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillagePlayerId_NotInScope(Collection<Integer> villagePlayerIdList) {
        doSetVillagePlayerId_NotInScope(villagePlayerIdList);
    }

    protected void doSetVillagePlayerId_NotInScope(Collection<Integer> villagePlayerIdList) {
        regINS(CK_NINS, cTL(villagePlayerIdList), xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select TARGET_VILLAGE_PLAYER_ID from ability where ...)} <br>
     * ability by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsAbilityByTargetVillagePlayerId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityByTargetVillagePlayerIdList for 'exists'. (NotNull)
     */
    public void existsAbilityByTargetVillagePlayerId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", pp, "abilityByTargetVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_PLAYER_ID from ability where ...)} <br>
     * ability by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsAbilityByVillagePlayerId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityByVillagePlayerIdList for 'exists'. (NotNull)
     */
    public void existsAbilityByVillagePlayerId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "abilityByVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_PLAYER_ID from coming_out where ...)} <br>
     * coming_out by VILLAGE_PLAYER_ID, named 'comingOutAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsComingOut</span>(outCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     outCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of ComingOutList for 'exists'. (NotNull)
     */
    public void existsComingOut(SubQuery<ComingOutCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        ComingOutCB cb = new ComingOutCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_ComingOutList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "comingOutList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_ComingOutList(ComingOutCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_PLAYER_ID from commit where ...)} <br>
     * commit by VILLAGE_PLAYER_ID, named 'commitAsOne'.
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
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_CommitList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "commitList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_CommitList(CommitCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_PLAYER_ID from village_player_access_info where ...)} <br>
     * village_player_access_info by VILLAGE_PLAYER_ID, named 'villagePlayerAccessInfoAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillagePlayerAccessInfo</span>(infoCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     infoCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerAccessInfoList for 'exists'. (NotNull)
     */
    public void existsVillagePlayerAccessInfo(SubQuery<VillagePlayerAccessInfoCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerAccessInfoCB cb = new VillagePlayerAccessInfoCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_VillagePlayerAccessInfoList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "villagePlayerAccessInfoList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_VillagePlayerAccessInfoList(VillagePlayerAccessInfoCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select TARGET_VILLAGE_PLAYER_ID from vote where ...)} <br>
     * vote by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVoteByTargetVillagePlayerId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VoteByTargetVillagePlayerIdList for 'exists'. (NotNull)
     */
    public void existsVoteByTargetVillagePlayerId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", pp, "voteByTargetVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_PLAYER_ID from vote where ...)} <br>
     * vote by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVoteByVillagePlayerId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VoteByVillagePlayerIdList for 'exists'. (NotNull)
     */
    public void existsVoteByVillagePlayerId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "voteByVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList(VoteCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select TARGET_VILLAGE_PLAYER_ID from ability where ...)} <br>
     * ability by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsAbilityByTargetVillagePlayerId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList for 'not exists'. (NotNull)
     */
    public void notExistsAbilityByTargetVillagePlayerId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", pp, "abilityByTargetVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_PLAYER_ID from ability where ...)} <br>
     * ability by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsAbilityByVillagePlayerId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList for 'not exists'. (NotNull)
     */
    public void notExistsAbilityByVillagePlayerId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "abilityByVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_PLAYER_ID from coming_out where ...)} <br>
     * coming_out by VILLAGE_PLAYER_ID, named 'comingOutAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsComingOut</span>(outCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     outCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_ComingOutList for 'not exists'. (NotNull)
     */
    public void notExistsComingOut(SubQuery<ComingOutCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        ComingOutCB cb = new ComingOutCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_ComingOutList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "comingOutList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_ComingOutList(ComingOutCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_PLAYER_ID from commit where ...)} <br>
     * commit by VILLAGE_PLAYER_ID, named 'commitAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsCommit</span>(commitCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     commitCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_CommitList for 'not exists'. (NotNull)
     */
    public void notExistsCommit(SubQuery<CommitCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CommitCB cb = new CommitCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_CommitList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "commitList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_CommitList(CommitCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_PLAYER_ID from village_player_access_info where ...)} <br>
     * village_player_access_info by VILLAGE_PLAYER_ID, named 'villagePlayerAccessInfoAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayerAccessInfo</span>(infoCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     infoCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_VillagePlayerAccessInfoList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayerAccessInfo(SubQuery<VillagePlayerAccessInfoCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerAccessInfoCB cb = new VillagePlayerAccessInfoCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_VillagePlayerAccessInfoList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "villagePlayerAccessInfoList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_VillagePlayerAccessInfoList(VillagePlayerAccessInfoCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select TARGET_VILLAGE_PLAYER_ID from vote where ...)} <br>
     * vote by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVoteByTargetVillagePlayerId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList for 'not exists'. (NotNull)
     */
    public void notExistsVoteByTargetVillagePlayerId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", pp, "voteByTargetVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_PLAYER_ID from vote where ...)} <br>
     * vote by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVoteByVillagePlayerId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList for 'not exists'. (NotNull)
     */
    public void notExistsVoteByVillagePlayerId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "voteByVillagePlayerIdList");
    }
    public abstract String keepVillagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList(VoteCQ sq);

    public void xsderiveAbilityByTargetVillagePlayerIdList(String fn, SubQuery<AbilityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", pp, "abilityByTargetVillagePlayerIdList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq);

    public void xsderiveAbilityByVillagePlayerIdList(String fn, SubQuery<AbilityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "abilityByVillagePlayerIdList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq);

    public void xsderiveComingOutList(String fn, SubQuery<ComingOutCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ComingOutCB cb = new ComingOutCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_ComingOutList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "comingOutList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_ComingOutList(ComingOutCQ sq);

    public void xsderiveCommitList(String fn, SubQuery<CommitCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CommitCB cb = new CommitCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_CommitList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "commitList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_CommitList(CommitCQ sq);

    public void xsderiveVillagePlayerAccessInfoList(String fn, SubQuery<VillagePlayerAccessInfoCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerAccessInfoCB cb = new VillagePlayerAccessInfoCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_VillagePlayerAccessInfoList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "villagePlayerAccessInfoList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_VillagePlayerAccessInfoList(VillagePlayerAccessInfoCQ sq);

    public void xsderiveVoteByTargetVillagePlayerIdList(String fn, SubQuery<VoteCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", pp, "voteByTargetVillagePlayerIdList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq);

    public void xsderiveVoteByVillagePlayerIdList(String fn, SubQuery<VoteCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", pp, "voteByVillagePlayerIdList", al, op);
    }
    public abstract String keepVillagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList(VoteCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from ability where ...)} <br>
     * ability by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedAbilityByTargetVillagePlayerId()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     abilityCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<AbilityCB> derivedAbilityByTargetVillagePlayerId() {
        return xcreateQDRFunctionAbilityByTargetVillagePlayerIdList();
    }
    protected HpQDRFunction<AbilityCB> xcreateQDRFunctionAbilityByTargetVillagePlayerIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveAbilityByTargetVillagePlayerIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveAbilityByTargetVillagePlayerIdList(String fn, SubQuery<AbilityCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", sqpp, "abilityByTargetVillagePlayerIdList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from ability where ...)} <br>
     * ability by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedAbilityByVillagePlayerId()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     abilityCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<AbilityCB> derivedAbilityByVillagePlayerId() {
        return xcreateQDRFunctionAbilityByVillagePlayerIdList();
    }
    protected HpQDRFunction<AbilityCB> xcreateQDRFunctionAbilityByVillagePlayerIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveAbilityByVillagePlayerIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveAbilityByVillagePlayerIdList(String fn, SubQuery<AbilityCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", sqpp, "abilityByVillagePlayerIdList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from coming_out where ...)} <br>
     * coming_out by VILLAGE_PLAYER_ID, named 'comingOutAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedComingOut()</span>.<span style="color: #CC4747">max</span>(outCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     outCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     outCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<ComingOutCB> derivedComingOut() {
        return xcreateQDRFunctionComingOutList();
    }
    protected HpQDRFunction<ComingOutCB> xcreateQDRFunctionComingOutList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveComingOutList(fn, sq, rd, vl, op));
    }
    public void xqderiveComingOutList(String fn, SubQuery<ComingOutCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ComingOutCB cb = new ComingOutCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_ComingOutList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_ComingOutListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", sqpp, "comingOutList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_ComingOutList(ComingOutCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_ComingOutListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from commit where ...)} <br>
     * commit by VILLAGE_PLAYER_ID, named 'commitAsOne'.
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
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_CommitList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_CommitListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", sqpp, "commitList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_CommitList(CommitCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_CommitListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_player_access_info where ...)} <br>
     * village_player_access_info by VILLAGE_PLAYER_ID, named 'villagePlayerAccessInfoAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillagePlayerAccessInfo()</span>.<span style="color: #CC4747">max</span>(infoCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     infoCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     infoCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerAccessInfoCB> derivedVillagePlayerAccessInfo() {
        return xcreateQDRFunctionVillagePlayerAccessInfoList();
    }
    protected HpQDRFunction<VillagePlayerAccessInfoCB> xcreateQDRFunctionVillagePlayerAccessInfoList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillagePlayerAccessInfoList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillagePlayerAccessInfoList(String fn, SubQuery<VillagePlayerAccessInfoCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerAccessInfoCB cb = new VillagePlayerAccessInfoCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_VillagePlayerAccessInfoList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_VillagePlayerAccessInfoListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", sqpp, "villagePlayerAccessInfoList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_VillagePlayerAccessInfoList(VillagePlayerAccessInfoCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_VillagePlayerAccessInfoListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from vote where ...)} <br>
     * vote by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVoteByTargetVillagePlayerId()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     voteCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VoteCB> derivedVoteByTargetVillagePlayerId() {
        return xcreateQDRFunctionVoteByTargetVillagePlayerIdList();
    }
    protected HpQDRFunction<VoteCB> xcreateQDRFunctionVoteByTargetVillagePlayerIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVoteByTargetVillagePlayerIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveVoteByTargetVillagePlayerIdList(String fn, SubQuery<VoteCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", sqpp, "voteByTargetVillagePlayerIdList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from vote where ...)} <br>
     * vote by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVoteByVillagePlayerId()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     voteCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VoteCB> derivedVoteByVillagePlayerId() {
        return xcreateQDRFunctionVoteByVillagePlayerIdList();
    }
    protected HpQDRFunction<VoteCB> xcreateQDRFunctionVoteByVillagePlayerIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVoteByVillagePlayerIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveVoteByVillagePlayerIdList(String fn, SubQuery<VoteCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList(cb.query()); String prpp = keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", sqpp, "voteByVillagePlayerIdList", rd, vl, prpp, op);
    }
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList(VoteCQ sq);
    public abstract String keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setVillagePlayerId_IsNull() { regVillagePlayerId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setVillagePlayerId_IsNotNull() { regVillagePlayerId(CK_ISNN, DOBJ); }

    protected void regVillagePlayerId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID"); }
    protected abstract ConditionValue xgetCValueVillagePlayerId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
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
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
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
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterThan(Integer villageId) {
        regVillageId(CK_GT, villageId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessThan(Integer villageId) {
        regVillageId(CK_LT, villageId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterEqual(Integer villageId) {
        regVillageId(CK_GE, villageId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessEqual(Integer villageId) {
        regVillageId(CK_LE, villageId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
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
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @param minNumber The min number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillageId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillageId(), "VILLAGE_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
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
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
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
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerId The value of playerId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_Equal(Integer playerId) {
        doSetPlayerId_Equal(playerId);
    }

    protected void doSetPlayerId_Equal(Integer playerId) {
        regPlayerId(CK_EQ, playerId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerId The value of playerId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_NotEqual(Integer playerId) {
        doSetPlayerId_NotEqual(playerId);
    }

    protected void doSetPlayerId_NotEqual(Integer playerId) {
        regPlayerId(CK_NES, playerId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerId The value of playerId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_GreaterThan(Integer playerId) {
        regPlayerId(CK_GT, playerId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerId The value of playerId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_LessThan(Integer playerId) {
        regPlayerId(CK_LT, playerId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerId The value of playerId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_GreaterEqual(Integer playerId) {
        regPlayerId(CK_GE, playerId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerId The value of playerId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_LessEqual(Integer playerId) {
        regPlayerId(CK_LE, playerId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param minNumber The min number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setPlayerId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setPlayerId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param minNumber The min number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setPlayerId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValuePlayerId(), "PLAYER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerIdList The collection of playerId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setPlayerId_InScope(Collection<Integer> playerIdList) {
        doSetPlayerId_InScope(playerIdList);
    }

    protected void doSetPlayerId_InScope(Collection<Integer> playerIdList) {
        regINS(CK_INS, cTL(playerIdList), xgetCValuePlayerId(), "PLAYER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @param playerIdList The collection of playerId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setPlayerId_NotInScope(Collection<Integer> playerIdList) {
        doSetPlayerId_NotInScope(playerIdList);
    }

    protected void doSetPlayerId_NotInScope(Collection<Integer> playerIdList) {
        regINS(CK_NINS, cTL(playerIdList), xgetCValuePlayerId(), "PLAYER_ID");
    }

    protected void regPlayerId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValuePlayerId(), "PLAYER_ID"); }
    protected abstract ConditionValue xgetCValuePlayerId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaId The value of charaId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_Equal(Integer charaId) {
        doSetCharaId_Equal(charaId);
    }

    protected void doSetCharaId_Equal(Integer charaId) {
        regCharaId(CK_EQ, charaId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaId The value of charaId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_NotEqual(Integer charaId) {
        doSetCharaId_NotEqual(charaId);
    }

    protected void doSetCharaId_NotEqual(Integer charaId) {
        regCharaId(CK_NES, charaId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaId The value of charaId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_GreaterThan(Integer charaId) {
        regCharaId(CK_GT, charaId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaId The value of charaId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_LessThan(Integer charaId) {
        regCharaId(CK_LT, charaId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaId The value of charaId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_GreaterEqual(Integer charaId) {
        regCharaId(CK_GE, charaId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaId The value of charaId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_LessEqual(Integer charaId) {
        regCharaId(CK_LE, charaId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param minNumber The min number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setCharaId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setCharaId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param minNumber The min number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCharaId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCharaId(), "CHARA_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaIdList The collection of charaId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaId_InScope(Collection<Integer> charaIdList) {
        doSetCharaId_InScope(charaIdList);
    }

    protected void doSetCharaId_InScope(Collection<Integer> charaIdList) {
        regINS(CK_INS, cTL(charaIdList), xgetCValueCharaId(), "CHARA_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @param charaIdList The collection of charaId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaId_NotInScope(Collection<Integer> charaIdList) {
        doSetCharaId_NotInScope(charaIdList);
    }

    protected void doSetCharaId_NotInScope(Collection<Integer> charaIdList) {
        regINS(CK_NINS, cTL(charaIdList), xgetCValueCharaId(), "CHARA_ID");
    }

    protected void regCharaId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaId(), "CHARA_ID"); }
    protected abstract ConditionValue xgetCValueCharaId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param skillCode The value of skillCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_Equal(String skillCode) {
        doSetSkillCode_Equal(fRES(skillCode));
    }

    /**
     * Equal(=). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setSkillCode_Equal_AsSkill(CDef.Skill cdef) {
        doSetSkillCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As C国狂人 (CMADMAN). And OnlyOnceRegistered. <br>
     * C国狂人
     */
    public void setSkillCode_Equal_C国狂人() {
        setSkillCode_Equal_AsSkill(CDef.Skill.C国狂人);
    }

    /**
     * Equal(=). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setSkillCode_Equal_狂信者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * Equal(=). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setSkillCode_Equal_妖狐() {
        setSkillCode_Equal_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * Equal(=). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setSkillCode_Equal_狩人() {
        setSkillCode_Equal_AsSkill(CDef.Skill.狩人);
    }

    /**
     * Equal(=). As 背徳者 (IMMORAL). And OnlyOnceRegistered. <br>
     * 背徳者
     */
    public void setSkillCode_Equal_背徳者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.背徳者);
    }

    /**
     * Equal(=). As おまかせ (LEFTOVER). And OnlyOnceRegistered. <br>
     * おまかせ
     */
    public void setSkillCode_Equal_おまかせ() {
        setSkillCode_Equal_AsSkill(CDef.Skill.おまかせ);
    }

    /**
     * Equal(=). As 狂人 (MADMAN). And OnlyOnceRegistered. <br>
     * 狂人
     */
    public void setSkillCode_Equal_狂人() {
        setSkillCode_Equal_AsSkill(CDef.Skill.狂人);
    }

    /**
     * Equal(=). As 共有者 (MASON). And OnlyOnceRegistered. <br>
     * 共有者
     */
    public void setSkillCode_Equal_共有者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.共有者);
    }

    /**
     * Equal(=). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setSkillCode_Equal_霊能者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * Equal(=). As 猫又 (MONSTERCAT). And OnlyOnceRegistered. <br>
     * 猫又
     */
    public void setSkillCode_Equal_猫又() {
        setSkillCode_Equal_AsSkill(CDef.Skill.猫又);
    }

    /**
     * Equal(=). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setSkillCode_Equal_占い師() {
        setSkillCode_Equal_AsSkill(CDef.Skill.占い師);
    }

    /**
     * Equal(=). As 聖痕者 (STIGMATA). And OnlyOnceRegistered. <br>
     * 聖痕者
     */
    public void setSkillCode_Equal_聖痕者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.聖痕者);
    }

    /**
     * Equal(=). As 村人 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人
     */
    public void setSkillCode_Equal_村人() {
        setSkillCode_Equal_AsSkill(CDef.Skill.村人);
    }

    /**
     * Equal(=). As おまかせ村人陣営 (VILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（村人陣営）
     */
    public void setSkillCode_Equal_おまかせ村人陣営() {
        setSkillCode_Equal_AsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * Equal(=). As 人狼 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼
     */
    public void setSkillCode_Equal_人狼() {
        setSkillCode_Equal_AsSkill(CDef.Skill.人狼);
    }

    /**
     * Equal(=). As おまかせ人狼陣営 (WEREWOLFS). And OnlyOnceRegistered. <br>
     * おまかせ（人狼陣営）
     */
    public void setSkillCode_Equal_おまかせ人狼陣営() {
        setSkillCode_Equal_AsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    protected void doSetSkillCode_Equal(String skillCode) {
        regSkillCode(CK_EQ, skillCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param skillCode The value of skillCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_NotEqual(String skillCode) {
        doSetSkillCode_NotEqual(fRES(skillCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setSkillCode_NotEqual_AsSkill(CDef.Skill cdef) {
        doSetSkillCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As C国狂人 (CMADMAN). And OnlyOnceRegistered. <br>
     * C国狂人
     */
    public void setSkillCode_NotEqual_C国狂人() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.C国狂人);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setSkillCode_NotEqual_狂信者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * NotEqual(&lt;&gt;). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setSkillCode_NotEqual_妖狐() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * NotEqual(&lt;&gt;). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setSkillCode_NotEqual_狩人() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.狩人);
    }

    /**
     * NotEqual(&lt;&gt;). As 背徳者 (IMMORAL). And OnlyOnceRegistered. <br>
     * 背徳者
     */
    public void setSkillCode_NotEqual_背徳者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.背徳者);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ (LEFTOVER). And OnlyOnceRegistered. <br>
     * おまかせ
     */
    public void setSkillCode_NotEqual_おまかせ() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂人 (MADMAN). And OnlyOnceRegistered. <br>
     * 狂人
     */
    public void setSkillCode_NotEqual_狂人() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.狂人);
    }

    /**
     * NotEqual(&lt;&gt;). As 共有者 (MASON). And OnlyOnceRegistered. <br>
     * 共有者
     */
    public void setSkillCode_NotEqual_共有者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.共有者);
    }

    /**
     * NotEqual(&lt;&gt;). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setSkillCode_NotEqual_霊能者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * NotEqual(&lt;&gt;). As 猫又 (MONSTERCAT). And OnlyOnceRegistered. <br>
     * 猫又
     */
    public void setSkillCode_NotEqual_猫又() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.猫又);
    }

    /**
     * NotEqual(&lt;&gt;). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setSkillCode_NotEqual_占い師() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.占い師);
    }

    /**
     * NotEqual(&lt;&gt;). As 聖痕者 (STIGMATA). And OnlyOnceRegistered. <br>
     * 聖痕者
     */
    public void setSkillCode_NotEqual_聖痕者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.聖痕者);
    }

    /**
     * NotEqual(&lt;&gt;). As 村人 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人
     */
    public void setSkillCode_NotEqual_村人() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.村人);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ村人陣営 (VILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（村人陣営）
     */
    public void setSkillCode_NotEqual_おまかせ村人陣営() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 人狼 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼
     */
    public void setSkillCode_NotEqual_人狼() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.人狼);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ人狼陣営 (WEREWOLFS). And OnlyOnceRegistered. <br>
     * おまかせ（人狼陣営）
     */
    public void setSkillCode_NotEqual_おまかせ人狼陣営() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    protected void doSetSkillCode_NotEqual(String skillCode) {
        regSkillCode(CK_NES, skillCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param skillCodeList The collection of skillCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_InScope(Collection<String> skillCodeList) {
        doSetSkillCode_InScope(skillCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillCode_InScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetSkillCode_InScope(cTStrL(cdefList));
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 囁きを見られる <br>
     * The group elements:[人狼, C国狂人]
     */
    public void setSkillCode_InScope_ViewableWerewolfSay() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfViewableWerewolfSay());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 囁き可能 <br>
     * The group elements:[人狼, C国狂人]
     */
    public void setSkillCode_InScope_AvailableWerewolfSay() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfAvailableWerewolfSay());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃対象に選べない <br>
     * The group elements:[人狼]
     */
    public void setSkillCode_InScope_NotSelectableAttack() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfNotSelectableAttack());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占い結果が人狼になる <br>
     * The group elements:[人狼]
     */
    public void setSkillCode_InScope_DivineResultWolf() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfDivineResultWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 霊能結果が人狼になる <br>
     * The group elements:[人狼]
     */
    public void setSkillCode_InScope_PsychicResultWolf() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfPsychicResultWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃能力を持つ <br>
     * The group elements:[人狼]
     */
    public void setSkillCode_InScope_HasAttackAbility() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfHasAttackAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占い能力を持つ <br>
     * The group elements:[占い師]
     */
    public void setSkillCode_InScope_HasDivineAbility() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfHasDivineAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 護衛能力を持つ <br>
     * The group elements:[狩人]
     */
    public void setSkillCode_InScope_HasGuardAbility() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfHasGuardAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 霊能能力を持つ <br>
     * The group elements:[霊能者]
     */
    public void setSkillCode_InScope_HasPsychicAbility() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfHasPsychicAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 勝敗判定時狼にカウントする <br>
     * The group elements:[人狼]
     */
    public void setSkillCode_InScope_CountWolf() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfCountWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 勝敗判定時に人間としてカウントしない <br>
     * The group elements:[妖狐]
     */
    public void setSkillCode_InScope_NoCount() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfNoCount());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * おまかせ系 <br>
     * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
     */
    public void setSkillCode_InScope_SomeoneSkill() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfSomeoneSkill());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 共有系としてお互いに認知できる <br>
     * The group elements:[共有者]
     */
    public void setSkillCode_InScope_RecognizableEachMason() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableEachMason());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 人狼を認知できる <br>
     * The group elements:[狂信者]
     */
    public void setSkillCode_InScope_RecognizableWolf() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 妖狐を認知できる <br>
     * The group elements:[妖狐, 背徳者]
     */
    public void setSkillCode_InScope_RecognizableFox() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableFox());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃耐性を持つ <br>
     * The group elements:[妖狐]
     */
    public void setSkillCode_InScope_NoDeadByAttack() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfNoDeadByAttack());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占いにより死亡する <br>
     * The group elements:[妖狐]
     */
    public void setSkillCode_InScope_DeadByDivine() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfDeadByDivine());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 死亡時道連れにする <br>
     * The group elements:[猫又]
     */
    public void setSkillCode_InScope_ForceDoubleSuicide() {
        setSkillCode_InScope_AsSkill(CDef.Skill.listOfForceDoubleSuicide());
    }

    protected void doSetSkillCode_InScope(Collection<String> skillCodeList) {
        regINS(CK_INS, cTL(skillCodeList), xgetCValueSkillCode(), "SKILL_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param skillCodeList The collection of skillCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_NotInScope(Collection<String> skillCodeList) {
        doSetSkillCode_NotInScope(skillCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillCode_NotInScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetSkillCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetSkillCode_NotInScope(Collection<String> skillCodeList) {
        regINS(CK_NINS, cTL(skillCodeList), xgetCValueSkillCode(), "SKILL_CODE");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setSkillCode_IsNull() { regSkillCode(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setSkillCode_IsNullOrEmpty() { regSkillCode(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setSkillCode_IsNotNull() { regSkillCode(CK_ISNN, DOBJ); }

    protected void regSkillCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSkillCode(), "SKILL_CODE"); }
    protected abstract ConditionValue xgetCValueSkillCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param requestSkillCode The value of requestSkillCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setRequestSkillCode_Equal(String requestSkillCode) {
        doSetRequestSkillCode_Equal(fRES(requestSkillCode));
    }

    /**
     * Equal(=). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setRequestSkillCode_Equal_AsSkill(CDef.Skill cdef) {
        doSetRequestSkillCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As C国狂人 (CMADMAN). And OnlyOnceRegistered. <br>
     * C国狂人
     */
    public void setRequestSkillCode_Equal_C国狂人() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.C国狂人);
    }

    /**
     * Equal(=). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setRequestSkillCode_Equal_狂信者() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * Equal(=). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setRequestSkillCode_Equal_妖狐() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * Equal(=). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setRequestSkillCode_Equal_狩人() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.狩人);
    }

    /**
     * Equal(=). As 背徳者 (IMMORAL). And OnlyOnceRegistered. <br>
     * 背徳者
     */
    public void setRequestSkillCode_Equal_背徳者() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.背徳者);
    }

    /**
     * Equal(=). As おまかせ (LEFTOVER). And OnlyOnceRegistered. <br>
     * おまかせ
     */
    public void setRequestSkillCode_Equal_おまかせ() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.おまかせ);
    }

    /**
     * Equal(=). As 狂人 (MADMAN). And OnlyOnceRegistered. <br>
     * 狂人
     */
    public void setRequestSkillCode_Equal_狂人() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.狂人);
    }

    /**
     * Equal(=). As 共有者 (MASON). And OnlyOnceRegistered. <br>
     * 共有者
     */
    public void setRequestSkillCode_Equal_共有者() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.共有者);
    }

    /**
     * Equal(=). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setRequestSkillCode_Equal_霊能者() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * Equal(=). As 猫又 (MONSTERCAT). And OnlyOnceRegistered. <br>
     * 猫又
     */
    public void setRequestSkillCode_Equal_猫又() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.猫又);
    }

    /**
     * Equal(=). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setRequestSkillCode_Equal_占い師() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.占い師);
    }

    /**
     * Equal(=). As 聖痕者 (STIGMATA). And OnlyOnceRegistered. <br>
     * 聖痕者
     */
    public void setRequestSkillCode_Equal_聖痕者() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.聖痕者);
    }

    /**
     * Equal(=). As 村人 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人
     */
    public void setRequestSkillCode_Equal_村人() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.村人);
    }

    /**
     * Equal(=). As おまかせ村人陣営 (VILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（村人陣営）
     */
    public void setRequestSkillCode_Equal_おまかせ村人陣営() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * Equal(=). As 人狼 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼
     */
    public void setRequestSkillCode_Equal_人狼() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.人狼);
    }

    /**
     * Equal(=). As おまかせ人狼陣営 (WEREWOLFS). And OnlyOnceRegistered. <br>
     * おまかせ（人狼陣営）
     */
    public void setRequestSkillCode_Equal_おまかせ人狼陣営() {
        setRequestSkillCode_Equal_AsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    protected void doSetRequestSkillCode_Equal(String requestSkillCode) {
        regRequestSkillCode(CK_EQ, requestSkillCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param requestSkillCode The value of requestSkillCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setRequestSkillCode_NotEqual(String requestSkillCode) {
        doSetRequestSkillCode_NotEqual(fRES(requestSkillCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setRequestSkillCode_NotEqual_AsSkill(CDef.Skill cdef) {
        doSetRequestSkillCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As C国狂人 (CMADMAN). And OnlyOnceRegistered. <br>
     * C国狂人
     */
    public void setRequestSkillCode_NotEqual_C国狂人() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.C国狂人);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setRequestSkillCode_NotEqual_狂信者() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * NotEqual(&lt;&gt;). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setRequestSkillCode_NotEqual_妖狐() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * NotEqual(&lt;&gt;). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setRequestSkillCode_NotEqual_狩人() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.狩人);
    }

    /**
     * NotEqual(&lt;&gt;). As 背徳者 (IMMORAL). And OnlyOnceRegistered. <br>
     * 背徳者
     */
    public void setRequestSkillCode_NotEqual_背徳者() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.背徳者);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ (LEFTOVER). And OnlyOnceRegistered. <br>
     * おまかせ
     */
    public void setRequestSkillCode_NotEqual_おまかせ() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂人 (MADMAN). And OnlyOnceRegistered. <br>
     * 狂人
     */
    public void setRequestSkillCode_NotEqual_狂人() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.狂人);
    }

    /**
     * NotEqual(&lt;&gt;). As 共有者 (MASON). And OnlyOnceRegistered. <br>
     * 共有者
     */
    public void setRequestSkillCode_NotEqual_共有者() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.共有者);
    }

    /**
     * NotEqual(&lt;&gt;). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setRequestSkillCode_NotEqual_霊能者() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * NotEqual(&lt;&gt;). As 猫又 (MONSTERCAT). And OnlyOnceRegistered. <br>
     * 猫又
     */
    public void setRequestSkillCode_NotEqual_猫又() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.猫又);
    }

    /**
     * NotEqual(&lt;&gt;). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setRequestSkillCode_NotEqual_占い師() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.占い師);
    }

    /**
     * NotEqual(&lt;&gt;). As 聖痕者 (STIGMATA). And OnlyOnceRegistered. <br>
     * 聖痕者
     */
    public void setRequestSkillCode_NotEqual_聖痕者() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.聖痕者);
    }

    /**
     * NotEqual(&lt;&gt;). As 村人 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人
     */
    public void setRequestSkillCode_NotEqual_村人() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.村人);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ村人陣営 (VILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（村人陣営）
     */
    public void setRequestSkillCode_NotEqual_おまかせ村人陣営() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 人狼 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼
     */
    public void setRequestSkillCode_NotEqual_人狼() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.人狼);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ人狼陣営 (WEREWOLFS). And OnlyOnceRegistered. <br>
     * おまかせ（人狼陣営）
     */
    public void setRequestSkillCode_NotEqual_おまかせ人狼陣営() {
        setRequestSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    protected void doSetRequestSkillCode_NotEqual(String requestSkillCode) {
        regRequestSkillCode(CK_NES, requestSkillCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param requestSkillCodeList The collection of requestSkillCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setRequestSkillCode_InScope(Collection<String> requestSkillCodeList) {
        doSetRequestSkillCode_InScope(requestSkillCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRequestSkillCode_InScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetRequestSkillCode_InScope(cTStrL(cdefList));
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 囁きを見られる <br>
     * The group elements:[人狼, C国狂人]
     */
    public void setRequestSkillCode_InScope_ViewableWerewolfSay() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfViewableWerewolfSay());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 囁き可能 <br>
     * The group elements:[人狼, C国狂人]
     */
    public void setRequestSkillCode_InScope_AvailableWerewolfSay() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfAvailableWerewolfSay());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃対象に選べない <br>
     * The group elements:[人狼]
     */
    public void setRequestSkillCode_InScope_NotSelectableAttack() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfNotSelectableAttack());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占い結果が人狼になる <br>
     * The group elements:[人狼]
     */
    public void setRequestSkillCode_InScope_DivineResultWolf() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfDivineResultWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 霊能結果が人狼になる <br>
     * The group elements:[人狼]
     */
    public void setRequestSkillCode_InScope_PsychicResultWolf() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfPsychicResultWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃能力を持つ <br>
     * The group elements:[人狼]
     */
    public void setRequestSkillCode_InScope_HasAttackAbility() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasAttackAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占い能力を持つ <br>
     * The group elements:[占い師]
     */
    public void setRequestSkillCode_InScope_HasDivineAbility() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasDivineAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 護衛能力を持つ <br>
     * The group elements:[狩人]
     */
    public void setRequestSkillCode_InScope_HasGuardAbility() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasGuardAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 霊能能力を持つ <br>
     * The group elements:[霊能者]
     */
    public void setRequestSkillCode_InScope_HasPsychicAbility() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasPsychicAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 勝敗判定時狼にカウントする <br>
     * The group elements:[人狼]
     */
    public void setRequestSkillCode_InScope_CountWolf() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfCountWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 勝敗判定時に人間としてカウントしない <br>
     * The group elements:[妖狐]
     */
    public void setRequestSkillCode_InScope_NoCount() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfNoCount());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * おまかせ系 <br>
     * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
     */
    public void setRequestSkillCode_InScope_SomeoneSkill() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfSomeoneSkill());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 共有系としてお互いに認知できる <br>
     * The group elements:[共有者]
     */
    public void setRequestSkillCode_InScope_RecognizableEachMason() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableEachMason());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 人狼を認知できる <br>
     * The group elements:[狂信者]
     */
    public void setRequestSkillCode_InScope_RecognizableWolf() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 妖狐を認知できる <br>
     * The group elements:[妖狐, 背徳者]
     */
    public void setRequestSkillCode_InScope_RecognizableFox() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableFox());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃耐性を持つ <br>
     * The group elements:[妖狐]
     */
    public void setRequestSkillCode_InScope_NoDeadByAttack() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfNoDeadByAttack());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占いにより死亡する <br>
     * The group elements:[妖狐]
     */
    public void setRequestSkillCode_InScope_DeadByDivine() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfDeadByDivine());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 死亡時道連れにする <br>
     * The group elements:[猫又]
     */
    public void setRequestSkillCode_InScope_ForceDoubleSuicide() {
        setRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfForceDoubleSuicide());
    }

    protected void doSetRequestSkillCode_InScope(Collection<String> requestSkillCodeList) {
        regINS(CK_INS, cTL(requestSkillCodeList), xgetCValueRequestSkillCode(), "REQUEST_SKILL_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param requestSkillCodeList The collection of requestSkillCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setRequestSkillCode_NotInScope(Collection<String> requestSkillCodeList) {
        doSetRequestSkillCode_NotInScope(requestSkillCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRequestSkillCode_NotInScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetRequestSkillCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetRequestSkillCode_NotInScope(Collection<String> requestSkillCodeList) {
        regINS(CK_NINS, cTL(requestSkillCodeList), xgetCValueRequestSkillCode(), "REQUEST_SKILL_CODE");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setRequestSkillCode_IsNull() { regRequestSkillCode(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setRequestSkillCode_IsNullOrEmpty() { regRequestSkillCode(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setRequestSkillCode_IsNotNull() { regRequestSkillCode(CK_ISNN, DOBJ); }

    protected void regRequestSkillCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRequestSkillCode(), "REQUEST_SKILL_CODE"); }
    protected abstract ConditionValue xgetCValueRequestSkillCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param secondRequestSkillCode The value of secondRequestSkillCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSecondRequestSkillCode_Equal(String secondRequestSkillCode) {
        doSetSecondRequestSkillCode_Equal(fRES(secondRequestSkillCode));
    }

    /**
     * Equal(=). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill cdef) {
        doSetSecondRequestSkillCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As C国狂人 (CMADMAN). And OnlyOnceRegistered. <br>
     * C国狂人
     */
    public void setSecondRequestSkillCode_Equal_C国狂人() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.C国狂人);
    }

    /**
     * Equal(=). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setSecondRequestSkillCode_Equal_狂信者() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * Equal(=). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setSecondRequestSkillCode_Equal_妖狐() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * Equal(=). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setSecondRequestSkillCode_Equal_狩人() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.狩人);
    }

    /**
     * Equal(=). As 背徳者 (IMMORAL). And OnlyOnceRegistered. <br>
     * 背徳者
     */
    public void setSecondRequestSkillCode_Equal_背徳者() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.背徳者);
    }

    /**
     * Equal(=). As おまかせ (LEFTOVER). And OnlyOnceRegistered. <br>
     * おまかせ
     */
    public void setSecondRequestSkillCode_Equal_おまかせ() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.おまかせ);
    }

    /**
     * Equal(=). As 狂人 (MADMAN). And OnlyOnceRegistered. <br>
     * 狂人
     */
    public void setSecondRequestSkillCode_Equal_狂人() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.狂人);
    }

    /**
     * Equal(=). As 共有者 (MASON). And OnlyOnceRegistered. <br>
     * 共有者
     */
    public void setSecondRequestSkillCode_Equal_共有者() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.共有者);
    }

    /**
     * Equal(=). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setSecondRequestSkillCode_Equal_霊能者() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * Equal(=). As 猫又 (MONSTERCAT). And OnlyOnceRegistered. <br>
     * 猫又
     */
    public void setSecondRequestSkillCode_Equal_猫又() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.猫又);
    }

    /**
     * Equal(=). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setSecondRequestSkillCode_Equal_占い師() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.占い師);
    }

    /**
     * Equal(=). As 聖痕者 (STIGMATA). And OnlyOnceRegistered. <br>
     * 聖痕者
     */
    public void setSecondRequestSkillCode_Equal_聖痕者() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.聖痕者);
    }

    /**
     * Equal(=). As 村人 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人
     */
    public void setSecondRequestSkillCode_Equal_村人() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.村人);
    }

    /**
     * Equal(=). As おまかせ村人陣営 (VILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（村人陣営）
     */
    public void setSecondRequestSkillCode_Equal_おまかせ村人陣営() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * Equal(=). As 人狼 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼
     */
    public void setSecondRequestSkillCode_Equal_人狼() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.人狼);
    }

    /**
     * Equal(=). As おまかせ人狼陣営 (WEREWOLFS). And OnlyOnceRegistered. <br>
     * おまかせ（人狼陣営）
     */
    public void setSecondRequestSkillCode_Equal_おまかせ人狼陣営() {
        setSecondRequestSkillCode_Equal_AsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    protected void doSetSecondRequestSkillCode_Equal(String secondRequestSkillCode) {
        regSecondRequestSkillCode(CK_EQ, secondRequestSkillCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param secondRequestSkillCode The value of secondRequestSkillCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSecondRequestSkillCode_NotEqual(String secondRequestSkillCode) {
        doSetSecondRequestSkillCode_NotEqual(fRES(secondRequestSkillCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill cdef) {
        doSetSecondRequestSkillCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As C国狂人 (CMADMAN). And OnlyOnceRegistered. <br>
     * C国狂人
     */
    public void setSecondRequestSkillCode_NotEqual_C国狂人() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.C国狂人);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setSecondRequestSkillCode_NotEqual_狂信者() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * NotEqual(&lt;&gt;). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setSecondRequestSkillCode_NotEqual_妖狐() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * NotEqual(&lt;&gt;). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setSecondRequestSkillCode_NotEqual_狩人() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.狩人);
    }

    /**
     * NotEqual(&lt;&gt;). As 背徳者 (IMMORAL). And OnlyOnceRegistered. <br>
     * 背徳者
     */
    public void setSecondRequestSkillCode_NotEqual_背徳者() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.背徳者);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ (LEFTOVER). And OnlyOnceRegistered. <br>
     * おまかせ
     */
    public void setSecondRequestSkillCode_NotEqual_おまかせ() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂人 (MADMAN). And OnlyOnceRegistered. <br>
     * 狂人
     */
    public void setSecondRequestSkillCode_NotEqual_狂人() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.狂人);
    }

    /**
     * NotEqual(&lt;&gt;). As 共有者 (MASON). And OnlyOnceRegistered. <br>
     * 共有者
     */
    public void setSecondRequestSkillCode_NotEqual_共有者() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.共有者);
    }

    /**
     * NotEqual(&lt;&gt;). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setSecondRequestSkillCode_NotEqual_霊能者() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * NotEqual(&lt;&gt;). As 猫又 (MONSTERCAT). And OnlyOnceRegistered. <br>
     * 猫又
     */
    public void setSecondRequestSkillCode_NotEqual_猫又() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.猫又);
    }

    /**
     * NotEqual(&lt;&gt;). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setSecondRequestSkillCode_NotEqual_占い師() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.占い師);
    }

    /**
     * NotEqual(&lt;&gt;). As 聖痕者 (STIGMATA). And OnlyOnceRegistered. <br>
     * 聖痕者
     */
    public void setSecondRequestSkillCode_NotEqual_聖痕者() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.聖痕者);
    }

    /**
     * NotEqual(&lt;&gt;). As 村人 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人
     */
    public void setSecondRequestSkillCode_NotEqual_村人() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.村人);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ村人陣営 (VILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（村人陣営）
     */
    public void setSecondRequestSkillCode_NotEqual_おまかせ村人陣営() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 人狼 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼
     */
    public void setSecondRequestSkillCode_NotEqual_人狼() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.人狼);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ人狼陣営 (WEREWOLFS). And OnlyOnceRegistered. <br>
     * おまかせ（人狼陣営）
     */
    public void setSecondRequestSkillCode_NotEqual_おまかせ人狼陣営() {
        setSecondRequestSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    protected void doSetSecondRequestSkillCode_NotEqual(String secondRequestSkillCode) {
        regSecondRequestSkillCode(CK_NES, secondRequestSkillCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param secondRequestSkillCodeList The collection of secondRequestSkillCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSecondRequestSkillCode_InScope(Collection<String> secondRequestSkillCodeList) {
        doSetSecondRequestSkillCode_InScope(secondRequestSkillCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSecondRequestSkillCode_InScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetSecondRequestSkillCode_InScope(cTStrL(cdefList));
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 囁きを見られる <br>
     * The group elements:[人狼, C国狂人]
     */
    public void setSecondRequestSkillCode_InScope_ViewableWerewolfSay() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfViewableWerewolfSay());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 囁き可能 <br>
     * The group elements:[人狼, C国狂人]
     */
    public void setSecondRequestSkillCode_InScope_AvailableWerewolfSay() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfAvailableWerewolfSay());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃対象に選べない <br>
     * The group elements:[人狼]
     */
    public void setSecondRequestSkillCode_InScope_NotSelectableAttack() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfNotSelectableAttack());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占い結果が人狼になる <br>
     * The group elements:[人狼]
     */
    public void setSecondRequestSkillCode_InScope_DivineResultWolf() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfDivineResultWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 霊能結果が人狼になる <br>
     * The group elements:[人狼]
     */
    public void setSecondRequestSkillCode_InScope_PsychicResultWolf() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfPsychicResultWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃能力を持つ <br>
     * The group elements:[人狼]
     */
    public void setSecondRequestSkillCode_InScope_HasAttackAbility() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasAttackAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占い能力を持つ <br>
     * The group elements:[占い師]
     */
    public void setSecondRequestSkillCode_InScope_HasDivineAbility() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasDivineAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 護衛能力を持つ <br>
     * The group elements:[狩人]
     */
    public void setSecondRequestSkillCode_InScope_HasGuardAbility() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasGuardAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 霊能能力を持つ <br>
     * The group elements:[霊能者]
     */
    public void setSecondRequestSkillCode_InScope_HasPsychicAbility() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfHasPsychicAbility());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 勝敗判定時狼にカウントする <br>
     * The group elements:[人狼]
     */
    public void setSecondRequestSkillCode_InScope_CountWolf() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfCountWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 勝敗判定時に人間としてカウントしない <br>
     * The group elements:[妖狐]
     */
    public void setSecondRequestSkillCode_InScope_NoCount() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfNoCount());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * おまかせ系 <br>
     * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
     */
    public void setSecondRequestSkillCode_InScope_SomeoneSkill() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfSomeoneSkill());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 共有系としてお互いに認知できる <br>
     * The group elements:[共有者]
     */
    public void setSecondRequestSkillCode_InScope_RecognizableEachMason() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableEachMason());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 人狼を認知できる <br>
     * The group elements:[狂信者]
     */
    public void setSecondRequestSkillCode_InScope_RecognizableWolf() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableWolf());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 妖狐を認知できる <br>
     * The group elements:[妖狐, 背徳者]
     */
    public void setSecondRequestSkillCode_InScope_RecognizableFox() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfRecognizableFox());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 襲撃耐性を持つ <br>
     * The group elements:[妖狐]
     */
    public void setSecondRequestSkillCode_InScope_NoDeadByAttack() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfNoDeadByAttack());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 占いにより死亡する <br>
     * The group elements:[妖狐]
     */
    public void setSecondRequestSkillCode_InScope_DeadByDivine() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfDeadByDivine());
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 役職 <br>
     * 死亡時道連れにする <br>
     * The group elements:[猫又]
     */
    public void setSecondRequestSkillCode_InScope_ForceDoubleSuicide() {
        setSecondRequestSkillCode_InScope_AsSkill(CDef.Skill.listOfForceDoubleSuicide());
    }

    protected void doSetSecondRequestSkillCode_InScope(Collection<String> secondRequestSkillCodeList) {
        regINS(CK_INS, cTL(secondRequestSkillCodeList), xgetCValueSecondRequestSkillCode(), "SECOND_REQUEST_SKILL_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @param secondRequestSkillCodeList The collection of secondRequestSkillCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSecondRequestSkillCode_NotInScope(Collection<String> secondRequestSkillCodeList) {
        doSetSecondRequestSkillCode_NotInScope(secondRequestSkillCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSecondRequestSkillCode_NotInScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetSecondRequestSkillCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetSecondRequestSkillCode_NotInScope(Collection<String> secondRequestSkillCodeList) {
        regINS(CK_NINS, cTL(secondRequestSkillCodeList), xgetCValueSecondRequestSkillCode(), "SECOND_REQUEST_SKILL_CODE");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setSecondRequestSkillCode_IsNull() { regSecondRequestSkillCode(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setSecondRequestSkillCode_IsNullOrEmpty() { regSecondRequestSkillCode(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     */
    public void setSecondRequestSkillCode_IsNotNull() { regSecondRequestSkillCode(CK_ISNN, DOBJ); }

    protected void regSecondRequestSkillCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSecondRequestSkillCode(), "SECOND_REQUEST_SKILL_CODE"); }
    protected abstract ConditionValue xgetCValueSecondRequestSkillCode();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_DEAD: {NotNull, BIT}
     * @param isDead The value of isDead as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsDead_Equal(Boolean isDead) {
        regIsDead(CK_EQ, isDead);
    }

    protected void regIsDead(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsDead(), "IS_DEAD"); }
    protected abstract ConditionValue xgetCValueIsDead();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_SPECTATOR: {NotNull, BIT}
     * @param isSpectator The value of isSpectator as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsSpectator_Equal(Boolean isSpectator) {
        regIsSpectator(CK_EQ, isSpectator);
    }

    protected void regIsSpectator(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsSpectator(), "IS_SPECTATOR"); }
    protected abstract ConditionValue xgetCValueIsSpectator();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     * @param deadReasonCode The value of deadReasonCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_Equal(String deadReasonCode) {
        doSetDeadReasonCode_Equal(fRES(deadReasonCode));
    }

    /**
     * Equal(=). As DeadReason. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason} <br>
     * 死亡理由
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason cdef) {
        doSetDeadReasonCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 襲撃 (ATTACK). And OnlyOnceRegistered. <br>
     * 襲撃
     */
    public void setDeadReasonCode_Equal_襲撃() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.襲撃);
    }

    /**
     * Equal(=). As 呪殺 (DIVINED). And OnlyOnceRegistered. <br>
     * 呪殺
     */
    public void setDeadReasonCode_Equal_呪殺() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.呪殺);
    }

    /**
     * Equal(=). As 処刑 (EXECUTE). And OnlyOnceRegistered. <br>
     * 処刑
     */
    public void setDeadReasonCode_Equal_処刑() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.処刑);
    }

    /**
     * Equal(=). As 突然 (SUDDEN). And OnlyOnceRegistered. <br>
     * 突然
     */
    public void setDeadReasonCode_Equal_突然() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.突然);
    }

    /**
     * Equal(=). As 後追 (SUICIDE). And OnlyOnceRegistered. <br>
     * 後追
     */
    public void setDeadReasonCode_Equal_後追() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.後追);
    }

    protected void doSetDeadReasonCode_Equal(String deadReasonCode) {
        regDeadReasonCode(CK_EQ, deadReasonCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     * @param deadReasonCode The value of deadReasonCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_NotEqual(String deadReasonCode) {
        doSetDeadReasonCode_NotEqual(fRES(deadReasonCode));
    }

    /**
     * NotEqual(&lt;&gt;). As DeadReason. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason} <br>
     * 死亡理由
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason cdef) {
        doSetDeadReasonCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 襲撃 (ATTACK). And OnlyOnceRegistered. <br>
     * 襲撃
     */
    public void setDeadReasonCode_NotEqual_襲撃() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.襲撃);
    }

    /**
     * NotEqual(&lt;&gt;). As 呪殺 (DIVINED). And OnlyOnceRegistered. <br>
     * 呪殺
     */
    public void setDeadReasonCode_NotEqual_呪殺() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.呪殺);
    }

    /**
     * NotEqual(&lt;&gt;). As 処刑 (EXECUTE). And OnlyOnceRegistered. <br>
     * 処刑
     */
    public void setDeadReasonCode_NotEqual_処刑() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.処刑);
    }

    /**
     * NotEqual(&lt;&gt;). As 突然 (SUDDEN). And OnlyOnceRegistered. <br>
     * 突然
     */
    public void setDeadReasonCode_NotEqual_突然() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.突然);
    }

    /**
     * NotEqual(&lt;&gt;). As 後追 (SUICIDE). And OnlyOnceRegistered. <br>
     * 後追
     */
    public void setDeadReasonCode_NotEqual_後追() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.後追);
    }

    protected void doSetDeadReasonCode_NotEqual(String deadReasonCode) {
        regDeadReasonCode(CK_NES, deadReasonCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     * @param deadReasonCodeList The collection of deadReasonCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_InScope(Collection<String> deadReasonCodeList) {
        doSetDeadReasonCode_InScope(deadReasonCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As DeadReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason} <br>
     * 死亡理由
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonCode_InScope_AsDeadReason(Collection<CDef.DeadReason> cdefList) {
        doSetDeadReasonCode_InScope(cTStrL(cdefList));
    }

    /**
     * InScope {in ('a', 'b')}. As DeadReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 死亡理由 <br>
     * 無惨な死 <br>
     * The group elements:[襲撃, 呪殺]
     */
    public void setDeadReasonCode_InScope_MiserableDeath() {
        setDeadReasonCode_InScope_AsDeadReason(CDef.DeadReason.listOfMiserableDeath());
    }

    /**
     * InScope {in ('a', 'b')}. As DeadReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * 死亡理由 <br>
     * 霊能判定可能な死因 <br>
     * The group elements:[処刑, 突然]
     */
    public void setDeadReasonCode_InScope_PsychicableDeath() {
        setDeadReasonCode_InScope_AsDeadReason(CDef.DeadReason.listOfPsychicableDeath());
    }

    protected void doSetDeadReasonCode_InScope(Collection<String> deadReasonCodeList) {
        regINS(CK_INS, cTL(deadReasonCodeList), xgetCValueDeadReasonCode(), "DEAD_REASON_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     * @param deadReasonCodeList The collection of deadReasonCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_NotInScope(Collection<String> deadReasonCodeList) {
        doSetDeadReasonCode_NotInScope(deadReasonCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As DeadReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason} <br>
     * 死亡理由
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonCode_NotInScope_AsDeadReason(Collection<CDef.DeadReason> cdefList) {
        doSetDeadReasonCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetDeadReasonCode_NotInScope(Collection<String> deadReasonCodeList) {
        regINS(CK_NINS, cTL(deadReasonCodeList), xgetCValueDeadReasonCode(), "DEAD_REASON_CODE");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     */
    public void setDeadReasonCode_IsNull() { regDeadReasonCode(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     */
    public void setDeadReasonCode_IsNullOrEmpty() { regDeadReasonCode(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     */
    public void setDeadReasonCode_IsNotNull() { regDeadReasonCode(CK_ISNN, DOBJ); }

    protected void regDeadReasonCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDeadReasonCode(), "DEAD_REASON_CODE"); }
    protected abstract ConditionValue xgetCValueDeadReasonCode();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayId The value of deadVillageDayId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_Equal(Integer deadVillageDayId) {
        doSetDeadVillageDayId_Equal(deadVillageDayId);
    }

    protected void doSetDeadVillageDayId_Equal(Integer deadVillageDayId) {
        regDeadVillageDayId(CK_EQ, deadVillageDayId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayId The value of deadVillageDayId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_NotEqual(Integer deadVillageDayId) {
        doSetDeadVillageDayId_NotEqual(deadVillageDayId);
    }

    protected void doSetDeadVillageDayId_NotEqual(Integer deadVillageDayId) {
        regDeadVillageDayId(CK_NES, deadVillageDayId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayId The value of deadVillageDayId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_GreaterThan(Integer deadVillageDayId) {
        regDeadVillageDayId(CK_GT, deadVillageDayId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayId The value of deadVillageDayId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_LessThan(Integer deadVillageDayId) {
        regDeadVillageDayId(CK_LT, deadVillageDayId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayId The value of deadVillageDayId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_GreaterEqual(Integer deadVillageDayId) {
        regDeadVillageDayId(CK_GE, deadVillageDayId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayId The value of deadVillageDayId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_LessEqual(Integer deadVillageDayId) {
        regDeadVillageDayId(CK_LE, deadVillageDayId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param minNumber The min number of deadVillageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of deadVillageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDeadVillageDayId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDeadVillageDayId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param minNumber The min number of deadVillageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of deadVillageDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDeadVillageDayId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDeadVillageDayId(), "DEAD_VILLAGE_DAY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayIdList The collection of deadVillageDayId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_InScope(Collection<Integer> deadVillageDayIdList) {
        doSetDeadVillageDayId_InScope(deadVillageDayIdList);
    }

    protected void doSetDeadVillageDayId_InScope(Collection<Integer> deadVillageDayIdList) {
        regINS(CK_INS, cTL(deadVillageDayIdList), xgetCValueDeadVillageDayId(), "DEAD_VILLAGE_DAY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @param deadVillageDayIdList The collection of deadVillageDayId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadVillageDayId_NotInScope(Collection<Integer> deadVillageDayIdList) {
        doSetDeadVillageDayId_NotInScope(deadVillageDayIdList);
    }

    protected void doSetDeadVillageDayId_NotInScope(Collection<Integer> deadVillageDayIdList) {
        regINS(CK_NINS, cTL(deadVillageDayIdList), xgetCValueDeadVillageDayId(), "DEAD_VILLAGE_DAY_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     */
    public void setDeadVillageDayId_IsNull() { regDeadVillageDayId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     */
    public void setDeadVillageDayId_IsNotNull() { regDeadVillageDayId(CK_ISNN, DOBJ); }

    protected void regDeadVillageDayId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDeadVillageDayId(), "DEAD_VILLAGE_DAY_ID"); }
    protected abstract ConditionValue xgetCValueDeadVillageDayId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_GONE: {NotNull, BIT}
     * @param isGone The value of isGone as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsGone_Equal(Boolean isGone) {
        regIsGone(CK_EQ, isGone);
    }

    protected void regIsGone(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsGone(), "IS_GONE"); }
    protected abstract ConditionValue xgetCValueIsGone();

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
    public HpSLCFunction<VillagePlayerCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, VillagePlayerCB.class);
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
    public HpSLCFunction<VillagePlayerCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, VillagePlayerCB.class);
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
    public HpSLCFunction<VillagePlayerCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, VillagePlayerCB.class);
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
    public HpSLCFunction<VillagePlayerCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, VillagePlayerCB.class);
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
    public HpSLCFunction<VillagePlayerCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, VillagePlayerCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VillagePlayerCB&gt;() {
     *     public void query(VillagePlayerCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillagePlayerCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, VillagePlayerCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(VillagePlayerCQ sq);

    protected VillagePlayerCB xcreateScalarConditionCB() {
        VillagePlayerCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VillagePlayerCB xcreateScalarConditionPartitionByCB() {
        VillagePlayerCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "VILLAGE_PLAYER_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VillagePlayerCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VillagePlayerCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VILLAGE_PLAYER_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VillagePlayerCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VillagePlayerCQ sq);

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
    protected VillagePlayerCB newMyCB() {
        return new VillagePlayerCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return VillagePlayerCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
