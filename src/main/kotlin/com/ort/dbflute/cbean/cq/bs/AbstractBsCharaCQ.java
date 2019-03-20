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
 * The abstract condition-query of chara.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsCharaCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsCharaCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "chara";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
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
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
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
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaId The value of charaId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_GreaterThan(Integer charaId) {
        regCharaId(CK_GT, charaId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaId The value of charaId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_LessThan(Integer charaId) {
        regCharaId(CK_LT, charaId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaId The value of charaId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_GreaterEqual(Integer charaId) {
        regCharaId(CK_GE, charaId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaId The value of charaId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_LessEqual(Integer charaId) {
        regCharaId(CK_LE, charaId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
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
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCharaId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCharaId(), "CHARA_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
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
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaIdList The collection of charaId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaId_NotInScope(Collection<Integer> charaIdList) {
        doSetCharaId_NotInScope(charaIdList);
    }

    protected void doSetCharaId_NotInScope(Collection<Integer> charaIdList) {
        regINS(CK_NINS, cTL(charaIdList), xgetCValueCharaId(), "CHARA_ID");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CHARA_ID from ability where ...)} <br>
     * ability by CHARA_ID, named 'abilityByCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsAbilityByCharaId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityByCharaIdList for 'exists'. (NotNull)
     */
    public void existsAbilityByCharaId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_ExistsReferrer_AbilityByCharaIdList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "abilityByCharaIdList");
    }
    public abstract String keepCharaId_ExistsReferrer_AbilityByCharaIdList(AbilityCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select TARGET_CHARA_ID from ability where ...)} <br>
     * ability by TARGET_CHARA_ID, named 'abilityByTargetCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsAbilityByTargetCharaId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityByTargetCharaIdList for 'exists'. (NotNull)
     */
    public void existsAbilityByTargetCharaId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_ExistsReferrer_AbilityByTargetCharaIdList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_ID", "TARGET_CHARA_ID", pp, "abilityByTargetCharaIdList");
    }
    public abstract String keepCharaId_ExistsReferrer_AbilityByTargetCharaIdList(AbilityCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CHARA_ID from chara_image where ...)} <br>
     * chara_image by CHARA_ID, named 'charaImageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsCharaImage</span>(imageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     imageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaImageList for 'exists'. (NotNull)
     */
    public void existsCharaImage(SubQuery<CharaImageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_ExistsReferrer_CharaImageList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "charaImageList");
    }
    public abstract String keepCharaId_ExistsReferrer_CharaImageList(CharaImageCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CHARA_ID from village_player where ...)} <br>
     * village_player by CHARA_ID, named 'villagePlayerAsOne'.
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
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_ExistsReferrer_VillagePlayerList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "villagePlayerList");
    }
    public abstract String keepCharaId_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CHARA_ID from vote where ...)} <br>
     * vote by CHARA_ID, named 'voteByCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVoteByCharaId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VoteByCharaIdList for 'exists'. (NotNull)
     */
    public void existsVoteByCharaId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_ExistsReferrer_VoteByCharaIdList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "voteByCharaIdList");
    }
    public abstract String keepCharaId_ExistsReferrer_VoteByCharaIdList(VoteCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VOTE_CHARA_ID from vote where ...)} <br>
     * vote by VOTE_CHARA_ID, named 'voteByVoteCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVoteByVoteCharaId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VoteByVoteCharaIdList for 'exists'. (NotNull)
     */
    public void existsVoteByVoteCharaId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_ExistsReferrer_VoteByVoteCharaIdList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_ID", "VOTE_CHARA_ID", pp, "voteByVoteCharaIdList");
    }
    public abstract String keepCharaId_ExistsReferrer_VoteByVoteCharaIdList(VoteCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CHARA_ID from ability where ...)} <br>
     * ability by CHARA_ID, named 'abilityByCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsAbilityByCharaId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaId_NotExistsReferrer_AbilityByCharaIdList for 'not exists'. (NotNull)
     */
    public void notExistsAbilityByCharaId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_NotExistsReferrer_AbilityByCharaIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "abilityByCharaIdList");
    }
    public abstract String keepCharaId_NotExistsReferrer_AbilityByCharaIdList(AbilityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select TARGET_CHARA_ID from ability where ...)} <br>
     * ability by TARGET_CHARA_ID, named 'abilityByTargetCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsAbilityByTargetCharaId</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaId_NotExistsReferrer_AbilityByTargetCharaIdList for 'not exists'. (NotNull)
     */
    public void notExistsAbilityByTargetCharaId(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_NotExistsReferrer_AbilityByTargetCharaIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_ID", "TARGET_CHARA_ID", pp, "abilityByTargetCharaIdList");
    }
    public abstract String keepCharaId_NotExistsReferrer_AbilityByTargetCharaIdList(AbilityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CHARA_ID from chara_image where ...)} <br>
     * chara_image by CHARA_ID, named 'charaImageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsCharaImage</span>(imageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     imageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaId_NotExistsReferrer_CharaImageList for 'not exists'. (NotNull)
     */
    public void notExistsCharaImage(SubQuery<CharaImageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_NotExistsReferrer_CharaImageList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "charaImageList");
    }
    public abstract String keepCharaId_NotExistsReferrer_CharaImageList(CharaImageCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CHARA_ID from village_player where ...)} <br>
     * village_player by CHARA_ID, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaId_NotExistsReferrer_VillagePlayerList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayer(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_NotExistsReferrer_VillagePlayerList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "villagePlayerList");
    }
    public abstract String keepCharaId_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CHARA_ID from vote where ...)} <br>
     * vote by CHARA_ID, named 'voteByCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVoteByCharaId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaId_NotExistsReferrer_VoteByCharaIdList for 'not exists'. (NotNull)
     */
    public void notExistsVoteByCharaId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_NotExistsReferrer_VoteByCharaIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_ID", "CHARA_ID", pp, "voteByCharaIdList");
    }
    public abstract String keepCharaId_NotExistsReferrer_VoteByCharaIdList(VoteCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VOTE_CHARA_ID from vote where ...)} <br>
     * vote by VOTE_CHARA_ID, named 'voteByVoteCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVoteByVoteCharaId</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaId_NotExistsReferrer_VoteByVoteCharaIdList for 'not exists'. (NotNull)
     */
    public void notExistsVoteByVoteCharaId(SubQuery<VoteCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VoteCB cb = new VoteCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaId_NotExistsReferrer_VoteByVoteCharaIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_ID", "VOTE_CHARA_ID", pp, "voteByVoteCharaIdList");
    }
    public abstract String keepCharaId_NotExistsReferrer_VoteByVoteCharaIdList(VoteCQ sq);

    public void xsderiveAbilityByCharaIdList(String fn, SubQuery<AbilityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaId_SpecifyDerivedReferrer_AbilityByCharaIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", pp, "abilityByCharaIdList", al, op);
    }
    public abstract String keepCharaId_SpecifyDerivedReferrer_AbilityByCharaIdList(AbilityCQ sq);

    public void xsderiveAbilityByTargetCharaIdList(String fn, SubQuery<AbilityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaId_SpecifyDerivedReferrer_AbilityByTargetCharaIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_ID", "TARGET_CHARA_ID", pp, "abilityByTargetCharaIdList", al, op);
    }
    public abstract String keepCharaId_SpecifyDerivedReferrer_AbilityByTargetCharaIdList(AbilityCQ sq);

    public void xsderiveCharaImageList(String fn, SubQuery<CharaImageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaId_SpecifyDerivedReferrer_CharaImageList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", pp, "charaImageList", al, op);
    }
    public abstract String keepCharaId_SpecifyDerivedReferrer_CharaImageList(CharaImageCQ sq);

    public void xsderiveVillagePlayerList(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaId_SpecifyDerivedReferrer_VillagePlayerList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", pp, "villagePlayerList", al, op);
    }
    public abstract String keepCharaId_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq);

    public void xsderiveVoteByCharaIdList(String fn, SubQuery<VoteCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaId_SpecifyDerivedReferrer_VoteByCharaIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", pp, "voteByCharaIdList", al, op);
    }
    public abstract String keepCharaId_SpecifyDerivedReferrer_VoteByCharaIdList(VoteCQ sq);

    public void xsderiveVoteByVoteCharaIdList(String fn, SubQuery<VoteCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaId_SpecifyDerivedReferrer_VoteByVoteCharaIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_ID", "VOTE_CHARA_ID", pp, "voteByVoteCharaIdList", al, op);
    }
    public abstract String keepCharaId_SpecifyDerivedReferrer_VoteByVoteCharaIdList(VoteCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from ability where ...)} <br>
     * ability by CHARA_ID, named 'abilityByCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedAbilityByCharaId()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     abilityCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<AbilityCB> derivedAbilityByCharaId() {
        return xcreateQDRFunctionAbilityByCharaIdList();
    }
    protected HpQDRFunction<AbilityCB> xcreateQDRFunctionAbilityByCharaIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveAbilityByCharaIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveAbilityByCharaIdList(String fn, SubQuery<AbilityCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaId_QueryDerivedReferrer_AbilityByCharaIdList(cb.query()); String prpp = keepCharaId_QueryDerivedReferrer_AbilityByCharaIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", sqpp, "abilityByCharaIdList", rd, vl, prpp, op);
    }
    public abstract String keepCharaId_QueryDerivedReferrer_AbilityByCharaIdList(AbilityCQ sq);
    public abstract String keepCharaId_QueryDerivedReferrer_AbilityByCharaIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from ability where ...)} <br>
     * ability by TARGET_CHARA_ID, named 'abilityByTargetCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedAbilityByTargetCharaId()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     abilityCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<AbilityCB> derivedAbilityByTargetCharaId() {
        return xcreateQDRFunctionAbilityByTargetCharaIdList();
    }
    protected HpQDRFunction<AbilityCB> xcreateQDRFunctionAbilityByTargetCharaIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveAbilityByTargetCharaIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveAbilityByTargetCharaIdList(String fn, SubQuery<AbilityCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaId_QueryDerivedReferrer_AbilityByTargetCharaIdList(cb.query()); String prpp = keepCharaId_QueryDerivedReferrer_AbilityByTargetCharaIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_ID", "TARGET_CHARA_ID", sqpp, "abilityByTargetCharaIdList", rd, vl, prpp, op);
    }
    public abstract String keepCharaId_QueryDerivedReferrer_AbilityByTargetCharaIdList(AbilityCQ sq);
    public abstract String keepCharaId_QueryDerivedReferrer_AbilityByTargetCharaIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from chara_image where ...)} <br>
     * chara_image by CHARA_ID, named 'charaImageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedCharaImage()</span>.<span style="color: #CC4747">max</span>(imageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     imageCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     imageCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<CharaImageCB> derivedCharaImage() {
        return xcreateQDRFunctionCharaImageList();
    }
    protected HpQDRFunction<CharaImageCB> xcreateQDRFunctionCharaImageList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveCharaImageList(fn, sq, rd, vl, op));
    }
    public void xqderiveCharaImageList(String fn, SubQuery<CharaImageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaId_QueryDerivedReferrer_CharaImageList(cb.query()); String prpp = keepCharaId_QueryDerivedReferrer_CharaImageListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", sqpp, "charaImageList", rd, vl, prpp, op);
    }
    public abstract String keepCharaId_QueryDerivedReferrer_CharaImageList(CharaImageCQ sq);
    public abstract String keepCharaId_QueryDerivedReferrer_CharaImageListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_player where ...)} <br>
     * village_player by CHARA_ID, named 'villagePlayerAsOne'.
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
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaId_QueryDerivedReferrer_VillagePlayerList(cb.query()); String prpp = keepCharaId_QueryDerivedReferrer_VillagePlayerListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", sqpp, "villagePlayerList", rd, vl, prpp, op);
    }
    public abstract String keepCharaId_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq);
    public abstract String keepCharaId_QueryDerivedReferrer_VillagePlayerListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from vote where ...)} <br>
     * vote by CHARA_ID, named 'voteByCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVoteByCharaId()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     voteCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VoteCB> derivedVoteByCharaId() {
        return xcreateQDRFunctionVoteByCharaIdList();
    }
    protected HpQDRFunction<VoteCB> xcreateQDRFunctionVoteByCharaIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVoteByCharaIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveVoteByCharaIdList(String fn, SubQuery<VoteCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaId_QueryDerivedReferrer_VoteByCharaIdList(cb.query()); String prpp = keepCharaId_QueryDerivedReferrer_VoteByCharaIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_ID", "CHARA_ID", sqpp, "voteByCharaIdList", rd, vl, prpp, op);
    }
    public abstract String keepCharaId_QueryDerivedReferrer_VoteByCharaIdList(VoteCQ sq);
    public abstract String keepCharaId_QueryDerivedReferrer_VoteByCharaIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from vote where ...)} <br>
     * vote by VOTE_CHARA_ID, named 'voteByVoteCharaIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVoteByVoteCharaId()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     voteCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     voteCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VoteCB> derivedVoteByVoteCharaId() {
        return xcreateQDRFunctionVoteByVoteCharaIdList();
    }
    protected HpQDRFunction<VoteCB> xcreateQDRFunctionVoteByVoteCharaIdList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVoteByVoteCharaIdList(fn, sq, rd, vl, op));
    }
    public void xqderiveVoteByVoteCharaIdList(String fn, SubQuery<VoteCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VoteCB cb = new VoteCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaId_QueryDerivedReferrer_VoteByVoteCharaIdList(cb.query()); String prpp = keepCharaId_QueryDerivedReferrer_VoteByVoteCharaIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_ID", "VOTE_CHARA_ID", sqpp, "voteByVoteCharaIdList", rd, vl, prpp, op);
    }
    public abstract String keepCharaId_QueryDerivedReferrer_VoteByVoteCharaIdList(VoteCQ sq);
    public abstract String keepCharaId_QueryDerivedReferrer_VoteByVoteCharaIdListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setCharaId_IsNull() { regCharaId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setCharaId_IsNotNull() { regCharaId(CK_ISNN, DOBJ); }

    protected void regCharaId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaId(), "CHARA_ID"); }
    protected abstract ConditionValue xgetCValueCharaId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_Equal(String charaName) {
        doSetCharaName_Equal(fRES(charaName));
    }

    protected void doSetCharaName_Equal(String charaName) {
        regCharaName(CK_EQ, charaName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_NotEqual(String charaName) {
        doSetCharaName_NotEqual(fRES(charaName));
    }

    protected void doSetCharaName_NotEqual(String charaName) {
        regCharaName(CK_NES, charaName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_GreaterThan(String charaName) {
        regCharaName(CK_GT, fRES(charaName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_LessThan(String charaName) {
        regCharaName(CK_LT, fRES(charaName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_GreaterEqual(String charaName) {
        regCharaName(CK_GE, fRES(charaName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_LessEqual(String charaName) {
        regCharaName(CK_LE, fRES(charaName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaNameList The collection of charaName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_InScope(Collection<String> charaNameList) {
        doSetCharaName_InScope(charaNameList);
    }

    protected void doSetCharaName_InScope(Collection<String> charaNameList) {
        regINS(CK_INS, cTL(charaNameList), xgetCValueCharaName(), "CHARA_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaNameList The collection of charaName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaName_NotInScope(Collection<String> charaNameList) {
        doSetCharaName_NotInScope(charaNameList);
    }

    protected void doSetCharaName_NotInScope(Collection<String> charaNameList) {
        regINS(CK_NINS, cTL(charaNameList), xgetCValueCharaName(), "CHARA_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)} <br>
     * <pre>e.g. setCharaName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param charaName The value of charaName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaName_LikeSearch(String charaName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaName_LikeSearch(charaName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)} <br>
     * <pre>e.g. setCharaName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param charaName The value of charaName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setCharaName_LikeSearch(String charaName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(charaName), xgetCValueCharaName(), "CHARA_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaName_NotLikeSearch(String charaName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaName_NotLikeSearch(charaName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @param charaName The value of charaName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setCharaName_NotLikeSearch(String charaName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(charaName), xgetCValueCharaName(), "CHARA_NAME", likeSearchOption);
    }

    protected void regCharaName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaName(), "CHARA_NAME"); }
    protected abstract ConditionValue xgetCValueCharaName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_Equal(String charaShortName) {
        doSetCharaShortName_Equal(fRES(charaShortName));
    }

    protected void doSetCharaShortName_Equal(String charaShortName) {
        regCharaShortName(CK_EQ, charaShortName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_NotEqual(String charaShortName) {
        doSetCharaShortName_NotEqual(fRES(charaShortName));
    }

    protected void doSetCharaShortName_NotEqual(String charaShortName) {
        regCharaShortName(CK_NES, charaShortName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_GreaterThan(String charaShortName) {
        regCharaShortName(CK_GT, fRES(charaShortName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_LessThan(String charaShortName) {
        regCharaShortName(CK_LT, fRES(charaShortName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_GreaterEqual(String charaShortName) {
        regCharaShortName(CK_GE, fRES(charaShortName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_LessEqual(String charaShortName) {
        regCharaShortName(CK_LE, fRES(charaShortName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortNameList The collection of charaShortName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_InScope(Collection<String> charaShortNameList) {
        doSetCharaShortName_InScope(charaShortNameList);
    }

    protected void doSetCharaShortName_InScope(Collection<String> charaShortNameList) {
        regINS(CK_INS, cTL(charaShortNameList), xgetCValueCharaShortName(), "CHARA_SHORT_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortNameList The collection of charaShortName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaShortName_NotInScope(Collection<String> charaShortNameList) {
        doSetCharaShortName_NotInScope(charaShortNameList);
    }

    protected void doSetCharaShortName_NotInScope(Collection<String> charaShortNameList) {
        regINS(CK_NINS, cTL(charaShortNameList), xgetCValueCharaShortName(), "CHARA_SHORT_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)} <br>
     * <pre>e.g. setCharaShortName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param charaShortName The value of charaShortName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaShortName_LikeSearch(String charaShortName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaShortName_LikeSearch(charaShortName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)} <br>
     * <pre>e.g. setCharaShortName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param charaShortName The value of charaShortName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setCharaShortName_LikeSearch(String charaShortName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(charaShortName), xgetCValueCharaShortName(), "CHARA_SHORT_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaShortName_NotLikeSearch(String charaShortName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaShortName_NotLikeSearch(charaShortName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @param charaShortName The value of charaShortName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setCharaShortName_NotLikeSearch(String charaShortName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(charaShortName), xgetCValueCharaShortName(), "CHARA_SHORT_NAME", likeSearchOption);
    }

    protected void regCharaShortName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaShortName(), "CHARA_SHORT_NAME"); }
    protected abstract ConditionValue xgetCValueCharaShortName();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupId The value of charaGroupId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_Equal(Integer charaGroupId) {
        doSetCharaGroupId_Equal(charaGroupId);
    }

    protected void doSetCharaGroupId_Equal(Integer charaGroupId) {
        regCharaGroupId(CK_EQ, charaGroupId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupId The value of charaGroupId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_NotEqual(Integer charaGroupId) {
        doSetCharaGroupId_NotEqual(charaGroupId);
    }

    protected void doSetCharaGroupId_NotEqual(Integer charaGroupId) {
        regCharaGroupId(CK_NES, charaGroupId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupId The value of charaGroupId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_GreaterThan(Integer charaGroupId) {
        regCharaGroupId(CK_GT, charaGroupId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupId The value of charaGroupId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_LessThan(Integer charaGroupId) {
        regCharaGroupId(CK_LT, charaGroupId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupId The value of charaGroupId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_GreaterEqual(Integer charaGroupId) {
        regCharaGroupId(CK_GE, charaGroupId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupId The value of charaGroupId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_LessEqual(Integer charaGroupId) {
        regCharaGroupId(CK_LE, charaGroupId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param minNumber The min number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setCharaGroupId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setCharaGroupId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param minNumber The min number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCharaGroupId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCharaGroupId(), "CHARA_GROUP_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupIdList The collection of charaGroupId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupId_InScope(Collection<Integer> charaGroupIdList) {
        doSetCharaGroupId_InScope(charaGroupIdList);
    }

    protected void doSetCharaGroupId_InScope(Collection<Integer> charaGroupIdList) {
        regINS(CK_INS, cTL(charaGroupIdList), xgetCValueCharaGroupId(), "CHARA_GROUP_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param charaGroupIdList The collection of charaGroupId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupId_NotInScope(Collection<Integer> charaGroupIdList) {
        doSetCharaGroupId_NotInScope(charaGroupIdList);
    }

    protected void doSetCharaGroupId_NotInScope(Collection<Integer> charaGroupIdList) {
        regINS(CK_NINS, cTL(charaGroupIdList), xgetCValueCharaGroupId(), "CHARA_GROUP_ID");
    }

    protected void regCharaGroupId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaGroupId(), "CHARA_GROUP_ID"); }
    protected abstract ConditionValue xgetCValueCharaGroupId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_Equal(String defaultJoinMessage) {
        doSetDefaultJoinMessage_Equal(fRES(defaultJoinMessage));
    }

    protected void doSetDefaultJoinMessage_Equal(String defaultJoinMessage) {
        regDefaultJoinMessage(CK_EQ, defaultJoinMessage);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_NotEqual(String defaultJoinMessage) {
        doSetDefaultJoinMessage_NotEqual(fRES(defaultJoinMessage));
    }

    protected void doSetDefaultJoinMessage_NotEqual(String defaultJoinMessage) {
        regDefaultJoinMessage(CK_NES, defaultJoinMessage);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_GreaterThan(String defaultJoinMessage) {
        regDefaultJoinMessage(CK_GT, fRES(defaultJoinMessage));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_LessThan(String defaultJoinMessage) {
        regDefaultJoinMessage(CK_LT, fRES(defaultJoinMessage));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_GreaterEqual(String defaultJoinMessage) {
        regDefaultJoinMessage(CK_GE, fRES(defaultJoinMessage));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_LessEqual(String defaultJoinMessage) {
        regDefaultJoinMessage(CK_LE, fRES(defaultJoinMessage));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessageList The collection of defaultJoinMessage as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_InScope(Collection<String> defaultJoinMessageList) {
        doSetDefaultJoinMessage_InScope(defaultJoinMessageList);
    }

    protected void doSetDefaultJoinMessage_InScope(Collection<String> defaultJoinMessageList) {
        regINS(CK_INS, cTL(defaultJoinMessageList), xgetCValueDefaultJoinMessage(), "DEFAULT_JOIN_MESSAGE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessageList The collection of defaultJoinMessage as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultJoinMessage_NotInScope(Collection<String> defaultJoinMessageList) {
        doSetDefaultJoinMessage_NotInScope(defaultJoinMessageList);
    }

    protected void doSetDefaultJoinMessage_NotInScope(Collection<String> defaultJoinMessageList) {
        regINS(CK_NINS, cTL(defaultJoinMessageList), xgetCValueDefaultJoinMessage(), "DEFAULT_JOIN_MESSAGE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)} <br>
     * <pre>e.g. setDefaultJoinMessage_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param defaultJoinMessage The value of defaultJoinMessage as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDefaultJoinMessage_LikeSearch(String defaultJoinMessage, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDefaultJoinMessage_LikeSearch(defaultJoinMessage, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)} <br>
     * <pre>e.g. setDefaultJoinMessage_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param defaultJoinMessage The value of defaultJoinMessage as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setDefaultJoinMessage_LikeSearch(String defaultJoinMessage, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(defaultJoinMessage), xgetCValueDefaultJoinMessage(), "DEFAULT_JOIN_MESSAGE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDefaultJoinMessage_NotLikeSearch(String defaultJoinMessage, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDefaultJoinMessage_NotLikeSearch(defaultJoinMessage, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @param defaultJoinMessage The value of defaultJoinMessage as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setDefaultJoinMessage_NotLikeSearch(String defaultJoinMessage, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(defaultJoinMessage), xgetCValueDefaultJoinMessage(), "DEFAULT_JOIN_MESSAGE", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     */
    public void setDefaultJoinMessage_IsNull() { regDefaultJoinMessage(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     */
    public void setDefaultJoinMessage_IsNullOrEmpty() { regDefaultJoinMessage(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     */
    public void setDefaultJoinMessage_IsNotNull() { regDefaultJoinMessage(CK_ISNN, DOBJ); }

    protected void regDefaultJoinMessage(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDefaultJoinMessage(), "DEFAULT_JOIN_MESSAGE"); }
    protected abstract ConditionValue xgetCValueDefaultJoinMessage();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_Equal(String defaultFirstdayMessage) {
        doSetDefaultFirstdayMessage_Equal(fRES(defaultFirstdayMessage));
    }

    protected void doSetDefaultFirstdayMessage_Equal(String defaultFirstdayMessage) {
        regDefaultFirstdayMessage(CK_EQ, defaultFirstdayMessage);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_NotEqual(String defaultFirstdayMessage) {
        doSetDefaultFirstdayMessage_NotEqual(fRES(defaultFirstdayMessage));
    }

    protected void doSetDefaultFirstdayMessage_NotEqual(String defaultFirstdayMessage) {
        regDefaultFirstdayMessage(CK_NES, defaultFirstdayMessage);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_GreaterThan(String defaultFirstdayMessage) {
        regDefaultFirstdayMessage(CK_GT, fRES(defaultFirstdayMessage));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_LessThan(String defaultFirstdayMessage) {
        regDefaultFirstdayMessage(CK_LT, fRES(defaultFirstdayMessage));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_GreaterEqual(String defaultFirstdayMessage) {
        regDefaultFirstdayMessage(CK_GE, fRES(defaultFirstdayMessage));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_LessEqual(String defaultFirstdayMessage) {
        regDefaultFirstdayMessage(CK_LE, fRES(defaultFirstdayMessage));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessageList The collection of defaultFirstdayMessage as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_InScope(Collection<String> defaultFirstdayMessageList) {
        doSetDefaultFirstdayMessage_InScope(defaultFirstdayMessageList);
    }

    protected void doSetDefaultFirstdayMessage_InScope(Collection<String> defaultFirstdayMessageList) {
        regINS(CK_INS, cTL(defaultFirstdayMessageList), xgetCValueDefaultFirstdayMessage(), "DEFAULT_FIRSTDAY_MESSAGE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessageList The collection of defaultFirstdayMessage as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDefaultFirstdayMessage_NotInScope(Collection<String> defaultFirstdayMessageList) {
        doSetDefaultFirstdayMessage_NotInScope(defaultFirstdayMessageList);
    }

    protected void doSetDefaultFirstdayMessage_NotInScope(Collection<String> defaultFirstdayMessageList) {
        regINS(CK_NINS, cTL(defaultFirstdayMessageList), xgetCValueDefaultFirstdayMessage(), "DEFAULT_FIRSTDAY_MESSAGE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)} <br>
     * <pre>e.g. setDefaultFirstdayMessage_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDefaultFirstdayMessage_LikeSearch(String defaultFirstdayMessage, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDefaultFirstdayMessage_LikeSearch(defaultFirstdayMessage, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)} <br>
     * <pre>e.g. setDefaultFirstdayMessage_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setDefaultFirstdayMessage_LikeSearch(String defaultFirstdayMessage, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(defaultFirstdayMessage), xgetCValueDefaultFirstdayMessage(), "DEFAULT_FIRSTDAY_MESSAGE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDefaultFirstdayMessage_NotLikeSearch(String defaultFirstdayMessage, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDefaultFirstdayMessage_NotLikeSearch(defaultFirstdayMessage, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @param defaultFirstdayMessage The value of defaultFirstdayMessage as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setDefaultFirstdayMessage_NotLikeSearch(String defaultFirstdayMessage, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(defaultFirstdayMessage), xgetCValueDefaultFirstdayMessage(), "DEFAULT_FIRSTDAY_MESSAGE", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     */
    public void setDefaultFirstdayMessage_IsNull() { regDefaultFirstdayMessage(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     */
    public void setDefaultFirstdayMessage_IsNullOrEmpty() { regDefaultFirstdayMessage(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     */
    public void setDefaultFirstdayMessage_IsNotNull() { regDefaultFirstdayMessage(CK_ISNN, DOBJ); }

    protected void regDefaultFirstdayMessage(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDefaultFirstdayMessage(), "DEFAULT_FIRSTDAY_MESSAGE"); }
    protected abstract ConditionValue xgetCValueDefaultFirstdayMessage();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidth The value of displayWidth as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayWidth_Equal(Integer displayWidth) {
        doSetDisplayWidth_Equal(displayWidth);
    }

    protected void doSetDisplayWidth_Equal(Integer displayWidth) {
        regDisplayWidth(CK_EQ, displayWidth);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidth The value of displayWidth as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayWidth_NotEqual(Integer displayWidth) {
        doSetDisplayWidth_NotEqual(displayWidth);
    }

    protected void doSetDisplayWidth_NotEqual(Integer displayWidth) {
        regDisplayWidth(CK_NES, displayWidth);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidth The value of displayWidth as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayWidth_GreaterThan(Integer displayWidth) {
        regDisplayWidth(CK_GT, displayWidth);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidth The value of displayWidth as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayWidth_LessThan(Integer displayWidth) {
        regDisplayWidth(CK_LT, displayWidth);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidth The value of displayWidth as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayWidth_GreaterEqual(Integer displayWidth) {
        regDisplayWidth(CK_GE, displayWidth);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidth The value of displayWidth as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayWidth_LessEqual(Integer displayWidth) {
        regDisplayWidth(CK_LE, displayWidth);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of displayWidth. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of displayWidth. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDisplayWidth_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDisplayWidth_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of displayWidth. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of displayWidth. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDisplayWidth_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDisplayWidth(), "DISPLAY_WIDTH", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidthList The collection of displayWidth as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDisplayWidth_InScope(Collection<Integer> displayWidthList) {
        doSetDisplayWidth_InScope(displayWidthList);
    }

    protected void doSetDisplayWidth_InScope(Collection<Integer> displayWidthList) {
        regINS(CK_INS, cTL(displayWidthList), xgetCValueDisplayWidth(), "DISPLAY_WIDTH");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @param displayWidthList The collection of displayWidth as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDisplayWidth_NotInScope(Collection<Integer> displayWidthList) {
        doSetDisplayWidth_NotInScope(displayWidthList);
    }

    protected void doSetDisplayWidth_NotInScope(Collection<Integer> displayWidthList) {
        regINS(CK_NINS, cTL(displayWidthList), xgetCValueDisplayWidth(), "DISPLAY_WIDTH");
    }

    protected void regDisplayWidth(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDisplayWidth(), "DISPLAY_WIDTH"); }
    protected abstract ConditionValue xgetCValueDisplayWidth();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeight The value of displayHeight as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayHeight_Equal(Integer displayHeight) {
        doSetDisplayHeight_Equal(displayHeight);
    }

    protected void doSetDisplayHeight_Equal(Integer displayHeight) {
        regDisplayHeight(CK_EQ, displayHeight);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeight The value of displayHeight as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayHeight_NotEqual(Integer displayHeight) {
        doSetDisplayHeight_NotEqual(displayHeight);
    }

    protected void doSetDisplayHeight_NotEqual(Integer displayHeight) {
        regDisplayHeight(CK_NES, displayHeight);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeight The value of displayHeight as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayHeight_GreaterThan(Integer displayHeight) {
        regDisplayHeight(CK_GT, displayHeight);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeight The value of displayHeight as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayHeight_LessThan(Integer displayHeight) {
        regDisplayHeight(CK_LT, displayHeight);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeight The value of displayHeight as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayHeight_GreaterEqual(Integer displayHeight) {
        regDisplayHeight(CK_GE, displayHeight);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeight The value of displayHeight as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDisplayHeight_LessEqual(Integer displayHeight) {
        regDisplayHeight(CK_LE, displayHeight);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of displayHeight. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of displayHeight. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDisplayHeight_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDisplayHeight_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of displayHeight. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of displayHeight. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDisplayHeight_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDisplayHeight(), "DISPLAY_HEIGHT", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeightList The collection of displayHeight as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDisplayHeight_InScope(Collection<Integer> displayHeightList) {
        doSetDisplayHeight_InScope(displayHeightList);
    }

    protected void doSetDisplayHeight_InScope(Collection<Integer> displayHeightList) {
        regINS(CK_INS, cTL(displayHeightList), xgetCValueDisplayHeight(), "DISPLAY_HEIGHT");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @param displayHeightList The collection of displayHeight as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDisplayHeight_NotInScope(Collection<Integer> displayHeightList) {
        doSetDisplayHeight_NotInScope(displayHeightList);
    }

    protected void doSetDisplayHeight_NotInScope(Collection<Integer> displayHeightList) {
        regINS(CK_NINS, cTL(displayHeightList), xgetCValueDisplayHeight(), "DISPLAY_HEIGHT");
    }

    protected void regDisplayHeight(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDisplayHeight(), "DISPLAY_HEIGHT"); }
    protected abstract ConditionValue xgetCValueDisplayHeight();

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
    public HpSLCFunction<CharaCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, CharaCB.class);
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
    public HpSLCFunction<CharaCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, CharaCB.class);
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
    public HpSLCFunction<CharaCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, CharaCB.class);
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
    public HpSLCFunction<CharaCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, CharaCB.class);
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
    public HpSLCFunction<CharaCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, CharaCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;CharaCB&gt;() {
     *     public void query(CharaCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<CharaCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, CharaCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(CharaCQ sq);

    protected CharaCB xcreateScalarConditionCB() {
        CharaCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected CharaCB xcreateScalarConditionPartitionByCB() {
        CharaCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<CharaCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaCB cb = new CharaCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "CHARA_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(CharaCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<CharaCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(CharaCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaCB cb = new CharaCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "CHARA_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(CharaCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<CharaCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaCB cb = new CharaCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(CharaCQ sq);

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
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
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
    protected CharaCB newMyCB() {
        return new CharaCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return CharaCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
