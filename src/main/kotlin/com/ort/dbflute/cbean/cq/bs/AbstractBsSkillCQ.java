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
 * The abstract condition-query of skill.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsSkillCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsSkillCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "skill";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     * @param skillCode The value of skillCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_Equal(String skillCode) {
        doSetSkillCode_Equal(fRES(skillCode));
    }

    /**
     * Equal(=). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill} <br>
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
     * Equal(=). As 探偵 (DETECTIVE). And OnlyOnceRegistered. <br>
     * 探偵
     */
    public void setSkillCode_Equal_探偵() {
        setSkillCode_Equal_AsSkill(CDef.Skill.探偵);
    }

    /**
     * Equal(=). As 魔神官 (EVILMEDIUM). And OnlyOnceRegistered. <br>
     * 魔神官
     */
    public void setSkillCode_Equal_魔神官() {
        setSkillCode_Equal_AsSkill(CDef.Skill.魔神官);
    }

    /**
     * Equal(=). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setSkillCode_Equal_狂信者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * Equal(=). As おまかせ足音職 (FOOTSTEPS). And OnlyOnceRegistered. <br>
     * おまかせ（足音職）
     */
    public void setSkillCode_Equal_おまかせ足音職() {
        setSkillCode_Equal_AsSkill(CDef.Skill.おまかせ足音職);
    }

    /**
     * Equal(=). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setSkillCode_Equal_妖狐() {
        setSkillCode_Equal_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * Equal(=). As おまかせ役職窓あり (FRIENDS). And OnlyOnceRegistered. <br>
     * おまかせ（役職窓あり）
     */
    public void setSkillCode_Equal_おまかせ役職窓あり() {
        setSkillCode_Equal_AsSkill(CDef.Skill.おまかせ役職窓あり);
    }

    /**
     * Equal(=). As 導師 (GURU). And OnlyOnceRegistered. <br>
     * 導師
     */
    public void setSkillCode_Equal_導師() {
        setSkillCode_Equal_AsSkill(CDef.Skill.導師);
    }

    /**
     * Equal(=). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setSkillCode_Equal_狩人() {
        setSkillCode_Equal_AsSkill(CDef.Skill.狩人);
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
     * Equal(=). As 共鳴者 (MASON). And OnlyOnceRegistered. <br>
     * 共鳴者
     */
    public void setSkillCode_Equal_共鳴者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.共鳴者);
    }

    /**
     * Equal(=). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setSkillCode_Equal_霊能者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * Equal(=). As おまかせ人外 (NOVILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（人外）
     */
    public void setSkillCode_Equal_おまかせ人外() {
        setSkillCode_Equal_AsSkill(CDef.Skill.おまかせ人外);
    }

    /**
     * Equal(=). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setSkillCode_Equal_占い師() {
        setSkillCode_Equal_AsSkill(CDef.Skill.占い師);
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

    /**
     * Equal(=). As 賢者 (WISE). And OnlyOnceRegistered. <br>
     * 賢者
     */
    public void setSkillCode_Equal_賢者() {
        setSkillCode_Equal_AsSkill(CDef.Skill.賢者);
    }

    protected void doSetSkillCode_Equal(String skillCode) {
        regSkillCode(CK_EQ, skillCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     * @param skillCode The value of skillCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_NotEqual(String skillCode) {
        doSetSkillCode_NotEqual(fRES(skillCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill} <br>
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
     * NotEqual(&lt;&gt;). As 探偵 (DETECTIVE). And OnlyOnceRegistered. <br>
     * 探偵
     */
    public void setSkillCode_NotEqual_探偵() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.探偵);
    }

    /**
     * NotEqual(&lt;&gt;). As 魔神官 (EVILMEDIUM). And OnlyOnceRegistered. <br>
     * 魔神官
     */
    public void setSkillCode_NotEqual_魔神官() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.魔神官);
    }

    /**
     * NotEqual(&lt;&gt;). As 狂信者 (FANATIC). And OnlyOnceRegistered. <br>
     * 狂信者
     */
    public void setSkillCode_NotEqual_狂信者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.狂信者);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ足音職 (FOOTSTEPS). And OnlyOnceRegistered. <br>
     * おまかせ（足音職）
     */
    public void setSkillCode_NotEqual_おまかせ足音職() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ足音職);
    }

    /**
     * NotEqual(&lt;&gt;). As 妖狐 (FOX). And OnlyOnceRegistered. <br>
     * 妖狐
     */
    public void setSkillCode_NotEqual_妖狐() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.妖狐);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ役職窓あり (FRIENDS). And OnlyOnceRegistered. <br>
     * おまかせ（役職窓あり）
     */
    public void setSkillCode_NotEqual_おまかせ役職窓あり() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ役職窓あり);
    }

    /**
     * NotEqual(&lt;&gt;). As 導師 (GURU). And OnlyOnceRegistered. <br>
     * 導師
     */
    public void setSkillCode_NotEqual_導師() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.導師);
    }

    /**
     * NotEqual(&lt;&gt;). As 狩人 (HUNTER). And OnlyOnceRegistered. <br>
     * 狩人
     */
    public void setSkillCode_NotEqual_狩人() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.狩人);
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
     * NotEqual(&lt;&gt;). As 共鳴者 (MASON). And OnlyOnceRegistered. <br>
     * 共鳴者
     */
    public void setSkillCode_NotEqual_共鳴者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.共鳴者);
    }

    /**
     * NotEqual(&lt;&gt;). As 霊能者 (MEDIUM). And OnlyOnceRegistered. <br>
     * 霊能者
     */
    public void setSkillCode_NotEqual_霊能者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.霊能者);
    }

    /**
     * NotEqual(&lt;&gt;). As おまかせ人外 (NOVILLAGERS). And OnlyOnceRegistered. <br>
     * おまかせ（人外）
     */
    public void setSkillCode_NotEqual_おまかせ人外() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.おまかせ人外);
    }

    /**
     * NotEqual(&lt;&gt;). As 占い師 (SEER). And OnlyOnceRegistered. <br>
     * 占い師
     */
    public void setSkillCode_NotEqual_占い師() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.占い師);
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

    /**
     * NotEqual(&lt;&gt;). As 賢者 (WISE). And OnlyOnceRegistered. <br>
     * 賢者
     */
    public void setSkillCode_NotEqual_賢者() {
        setSkillCode_NotEqual_AsSkill(CDef.Skill.賢者);
    }

    protected void doSetSkillCode_NotEqual(String skillCode) {
        regSkillCode(CK_NES, skillCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     * @param skillCodeList The collection of skillCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_InScope(Collection<String> skillCodeList) {
        doSetSkillCode_InScope(skillCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill} <br>
     * 役職
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillCode_InScope_AsSkill(Collection<CDef.Skill> cdefList) {
        doSetSkillCode_InScope(cTStrL(cdefList));
    }

    protected void doSetSkillCode_InScope(Collection<String> skillCodeList) {
        regINS(CK_INS, cTL(skillCodeList), xgetCValueSkillCode(), "SKILL_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     * @param skillCodeList The collection of skillCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_NotInScope(Collection<String> skillCodeList) {
        doSetSkillCode_NotInScope(skillCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill} <br>
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
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select SKILL_CODE from message_restriction where ...)} <br>
     * message_restriction by SKILL_CODE, named 'messageRestrictionAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsMessageRestriction</span>(restrictionCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     restrictionCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of MessageRestrictionList for 'exists'. (NotNull)
     */
    public void existsMessageRestriction(SubQuery<MessageRestrictionCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        MessageRestrictionCB cb = new MessageRestrictionCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_ExistsReferrer_MessageRestrictionList(cb.query());
        registerExistsReferrer(cb.query(), "SKILL_CODE", "SKILL_CODE", pp, "messageRestrictionList");
    }
    public abstract String keepSkillCode_ExistsReferrer_MessageRestrictionList(MessageRestrictionCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select REQUEST_SKILL_CODE from village_player where ...)} <br>
     * village_player by REQUEST_SKILL_CODE, named 'villagePlayerByRequestSkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillagePlayerByRequestSkillCode</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerByRequestSkillCodeList for 'exists'. (NotNull)
     */
    public void existsVillagePlayerByRequestSkillCode(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList(cb.query());
        registerExistsReferrer(cb.query(), "SKILL_CODE", "REQUEST_SKILL_CODE", pp, "villagePlayerByRequestSkillCodeList");
    }
    public abstract String keepSkillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select SECOND_REQUEST_SKILL_CODE from village_player where ...)} <br>
     * village_player by SECOND_REQUEST_SKILL_CODE, named 'villagePlayerBySecondRequestSkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillagePlayerBySecondRequestSkillCode</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerBySecondRequestSkillCodeList for 'exists'. (NotNull)
     */
    public void existsVillagePlayerBySecondRequestSkillCode(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(cb.query());
        registerExistsReferrer(cb.query(), "SKILL_CODE", "SECOND_REQUEST_SKILL_CODE", pp, "villagePlayerBySecondRequestSkillCodeList");
    }
    public abstract String keepSkillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select SKILL_CODE from village_player where ...)} <br>
     * village_player by SKILL_CODE, named 'villagePlayerBySkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillagePlayerBySkillCode</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerBySkillCodeList for 'exists'. (NotNull)
     */
    public void existsVillagePlayerBySkillCode(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_ExistsReferrer_VillagePlayerBySkillCodeList(cb.query());
        registerExistsReferrer(cb.query(), "SKILL_CODE", "SKILL_CODE", pp, "villagePlayerBySkillCodeList");
    }
    public abstract String keepSkillCode_ExistsReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select SKILL_CODE from message_restriction where ...)} <br>
     * message_restriction by SKILL_CODE, named 'messageRestrictionAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsMessageRestriction</span>(restrictionCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     restrictionCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of SkillCode_NotExistsReferrer_MessageRestrictionList for 'not exists'. (NotNull)
     */
    public void notExistsMessageRestriction(SubQuery<MessageRestrictionCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        MessageRestrictionCB cb = new MessageRestrictionCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_NotExistsReferrer_MessageRestrictionList(cb.query());
        registerNotExistsReferrer(cb.query(), "SKILL_CODE", "SKILL_CODE", pp, "messageRestrictionList");
    }
    public abstract String keepSkillCode_NotExistsReferrer_MessageRestrictionList(MessageRestrictionCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select REQUEST_SKILL_CODE from village_player where ...)} <br>
     * village_player by REQUEST_SKILL_CODE, named 'villagePlayerByRequestSkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayerByRequestSkillCode</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of SkillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayerByRequestSkillCode(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList(cb.query());
        registerNotExistsReferrer(cb.query(), "SKILL_CODE", "REQUEST_SKILL_CODE", pp, "villagePlayerByRequestSkillCodeList");
    }
    public abstract String keepSkillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select SECOND_REQUEST_SKILL_CODE from village_player where ...)} <br>
     * village_player by SECOND_REQUEST_SKILL_CODE, named 'villagePlayerBySecondRequestSkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayerBySecondRequestSkillCode</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of SkillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayerBySecondRequestSkillCode(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(cb.query());
        registerNotExistsReferrer(cb.query(), "SKILL_CODE", "SECOND_REQUEST_SKILL_CODE", pp, "villagePlayerBySecondRequestSkillCodeList");
    }
    public abstract String keepSkillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select SKILL_CODE from village_player where ...)} <br>
     * village_player by SKILL_CODE, named 'villagePlayerBySkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayerBySkillCode</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of SkillCode_NotExistsReferrer_VillagePlayerBySkillCodeList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayerBySkillCode(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepSkillCode_NotExistsReferrer_VillagePlayerBySkillCodeList(cb.query());
        registerNotExistsReferrer(cb.query(), "SKILL_CODE", "SKILL_CODE", pp, "villagePlayerBySkillCodeList");
    }
    public abstract String keepSkillCode_NotExistsReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq);

    public void xsderiveMessageRestrictionList(String fn, SubQuery<MessageRestrictionCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageRestrictionCB cb = new MessageRestrictionCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSkillCode_SpecifyDerivedReferrer_MessageRestrictionList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "SKILL_CODE", "SKILL_CODE", pp, "messageRestrictionList", al, op);
    }
    public abstract String keepSkillCode_SpecifyDerivedReferrer_MessageRestrictionList(MessageRestrictionCQ sq);

    public void xsderiveVillagePlayerByRequestSkillCodeList(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSkillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "SKILL_CODE", "REQUEST_SKILL_CODE", pp, "villagePlayerByRequestSkillCodeList", al, op);
    }
    public abstract String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq);

    public void xsderiveVillagePlayerBySecondRequestSkillCodeList(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "SKILL_CODE", "SECOND_REQUEST_SKILL_CODE", pp, "villagePlayerBySecondRequestSkillCodeList", al, op);
    }
    public abstract String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq);

    public void xsderiveVillagePlayerBySkillCodeList(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "SKILL_CODE", "SKILL_CODE", pp, "villagePlayerBySkillCodeList", al, op);
    }
    public abstract String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from message_restriction where ...)} <br>
     * message_restriction by SKILL_CODE, named 'messageRestrictionAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedMessageRestriction()</span>.<span style="color: #CC4747">max</span>(restrictionCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     restrictionCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     restrictionCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MessageRestrictionCB> derivedMessageRestriction() {
        return xcreateQDRFunctionMessageRestrictionList();
    }
    protected HpQDRFunction<MessageRestrictionCB> xcreateQDRFunctionMessageRestrictionList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveMessageRestrictionList(fn, sq, rd, vl, op));
    }
    public void xqderiveMessageRestrictionList(String fn, SubQuery<MessageRestrictionCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageRestrictionCB cb = new MessageRestrictionCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepSkillCode_QueryDerivedReferrer_MessageRestrictionList(cb.query()); String prpp = keepSkillCode_QueryDerivedReferrer_MessageRestrictionListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "SKILL_CODE", "SKILL_CODE", sqpp, "messageRestrictionList", rd, vl, prpp, op);
    }
    public abstract String keepSkillCode_QueryDerivedReferrer_MessageRestrictionList(MessageRestrictionCQ sq);
    public abstract String keepSkillCode_QueryDerivedReferrer_MessageRestrictionListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_player where ...)} <br>
     * village_player by REQUEST_SKILL_CODE, named 'villagePlayerByRequestSkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillagePlayerByRequestSkillCode()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     playerCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerCB> derivedVillagePlayerByRequestSkillCode() {
        return xcreateQDRFunctionVillagePlayerByRequestSkillCodeList();
    }
    protected HpQDRFunction<VillagePlayerCB> xcreateQDRFunctionVillagePlayerByRequestSkillCodeList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillagePlayerByRequestSkillCodeList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillagePlayerByRequestSkillCodeList(String fn, SubQuery<VillagePlayerCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList(cb.query()); String prpp = keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "SKILL_CODE", "REQUEST_SKILL_CODE", sqpp, "villagePlayerByRequestSkillCodeList", rd, vl, prpp, op);
    }
    public abstract String keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq);
    public abstract String keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_player where ...)} <br>
     * village_player by SECOND_REQUEST_SKILL_CODE, named 'villagePlayerBySecondRequestSkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillagePlayerBySecondRequestSkillCode()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     playerCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerCB> derivedVillagePlayerBySecondRequestSkillCode() {
        return xcreateQDRFunctionVillagePlayerBySecondRequestSkillCodeList();
    }
    protected HpQDRFunction<VillagePlayerCB> xcreateQDRFunctionVillagePlayerBySecondRequestSkillCodeList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillagePlayerBySecondRequestSkillCodeList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillagePlayerBySecondRequestSkillCodeList(String fn, SubQuery<VillagePlayerCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(cb.query()); String prpp = keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "SKILL_CODE", "SECOND_REQUEST_SKILL_CODE", sqpp, "villagePlayerBySecondRequestSkillCodeList", rd, vl, prpp, op);
    }
    public abstract String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq);
    public abstract String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_player where ...)} <br>
     * village_player by SKILL_CODE, named 'villagePlayerBySkillCodeAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillagePlayerBySkillCode()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     playerCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerCB> derivedVillagePlayerBySkillCode() {
        return xcreateQDRFunctionVillagePlayerBySkillCodeList();
    }
    protected HpQDRFunction<VillagePlayerCB> xcreateQDRFunctionVillagePlayerBySkillCodeList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillagePlayerBySkillCodeList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillagePlayerBySkillCodeList(String fn, SubQuery<VillagePlayerCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList(cb.query()); String prpp = keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "SKILL_CODE", "SKILL_CODE", sqpp, "villagePlayerBySkillCodeList", rd, vl, prpp, op);
    }
    public abstract String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq);
    public abstract String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     */
    public void setSkillCode_IsNull() { regSkillCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     */
    public void setSkillCode_IsNotNull() { regSkillCode(CK_ISNN, DOBJ); }

    protected void regSkillCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSkillCode(), "SKILL_CODE"); }
    protected abstract ConditionValue xgetCValueSkillCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_Equal(String skillName) {
        doSetSkillName_Equal(fRES(skillName));
    }

    protected void doSetSkillName_Equal(String skillName) {
        regSkillName(CK_EQ, skillName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_NotEqual(String skillName) {
        doSetSkillName_NotEqual(fRES(skillName));
    }

    protected void doSetSkillName_NotEqual(String skillName) {
        regSkillName(CK_NES, skillName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_GreaterThan(String skillName) {
        regSkillName(CK_GT, fRES(skillName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_LessThan(String skillName) {
        regSkillName(CK_LT, fRES(skillName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_GreaterEqual(String skillName) {
        regSkillName(CK_GE, fRES(skillName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_LessEqual(String skillName) {
        regSkillName(CK_LE, fRES(skillName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillNameList The collection of skillName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_InScope(Collection<String> skillNameList) {
        doSetSkillName_InScope(skillNameList);
    }

    protected void doSetSkillName_InScope(Collection<String> skillNameList) {
        regINS(CK_INS, cTL(skillNameList), xgetCValueSkillName(), "SKILL_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillNameList The collection of skillName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSkillName_NotInScope(Collection<String> skillNameList) {
        doSetSkillName_NotInScope(skillNameList);
    }

    protected void doSetSkillName_NotInScope(Collection<String> skillNameList) {
        regINS(CK_NINS, cTL(skillNameList), xgetCValueSkillName(), "SKILL_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setSkillName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param skillName The value of skillName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setSkillName_LikeSearch(String skillName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setSkillName_LikeSearch(skillName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setSkillName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param skillName The value of skillName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setSkillName_LikeSearch(String skillName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(skillName), xgetCValueSkillName(), "SKILL_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setSkillName_NotLikeSearch(String skillName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setSkillName_NotLikeSearch(skillName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @param skillName The value of skillName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setSkillName_NotLikeSearch(String skillName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(skillName), xgetCValueSkillName(), "SKILL_NAME", likeSearchOption);
    }

    protected void regSkillName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSkillName(), "SKILL_NAME"); }
    protected abstract ConditionValue xgetCValueSkillName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp}
     * @param campCode The value of campCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_Equal(String campCode) {
        doSetCampCode_Equal(fRES(campCode));
    }

    /**
     * Equal(=). As Camp. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 陣営
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setCampCode_Equal_AsCamp(CDef.Camp cdef) {
        doSetCampCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 狐陣営 (FOX). And OnlyOnceRegistered. <br>
     * 狐陣営
     */
    public void setCampCode_Equal_狐陣営() {
        setCampCode_Equal_AsCamp(CDef.Camp.狐陣営);
    }

    /**
     * Equal(=). As 村人陣営 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人陣営
     */
    public void setCampCode_Equal_村人陣営() {
        setCampCode_Equal_AsCamp(CDef.Camp.村人陣営);
    }

    /**
     * Equal(=). As 人狼陣営 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼陣営
     */
    public void setCampCode_Equal_人狼陣営() {
        setCampCode_Equal_AsCamp(CDef.Camp.人狼陣営);
    }

    protected void doSetCampCode_Equal(String campCode) {
        regCampCode(CK_EQ, campCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp}
     * @param campCode The value of campCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_NotEqual(String campCode) {
        doSetCampCode_NotEqual(fRES(campCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Camp. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 陣営
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setCampCode_NotEqual_AsCamp(CDef.Camp cdef) {
        doSetCampCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 狐陣営 (FOX). And OnlyOnceRegistered. <br>
     * 狐陣営
     */
    public void setCampCode_NotEqual_狐陣営() {
        setCampCode_NotEqual_AsCamp(CDef.Camp.狐陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 村人陣営 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人陣営
     */
    public void setCampCode_NotEqual_村人陣営() {
        setCampCode_NotEqual_AsCamp(CDef.Camp.村人陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 人狼陣営 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼陣営
     */
    public void setCampCode_NotEqual_人狼陣営() {
        setCampCode_NotEqual_AsCamp(CDef.Camp.人狼陣営);
    }

    protected void doSetCampCode_NotEqual(String campCode) {
        regCampCode(CK_NES, campCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp}
     * @param campCodeList The collection of campCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_InScope(Collection<String> campCodeList) {
        doSetCampCode_InScope(campCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Camp. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 陣営
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampCode_InScope_AsCamp(Collection<CDef.Camp> cdefList) {
        doSetCampCode_InScope(cTStrL(cdefList));
    }

    protected void doSetCampCode_InScope(Collection<String> campCodeList) {
        regINS(CK_INS, cTL(campCodeList), xgetCValueCampCode(), "CAMP_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp}
     * @param campCodeList The collection of campCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_NotInScope(Collection<String> campCodeList) {
        doSetCampCode_NotInScope(campCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Camp. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 陣営
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampCode_NotInScope_AsCamp(Collection<CDef.Camp> cdefList) {
        doSetCampCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetCampCode_NotInScope(Collection<String> campCodeList) {
        regINS(CK_NINS, cTL(campCodeList), xgetCValueCampCode(), "CAMP_CODE");
    }

    protected void regCampCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCampCode(), "CAMP_CODE"); }
    protected abstract ConditionValue xgetCValueCampCode();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_Equal(Integer dispOrder) {
        doSetDispOrder_Equal(dispOrder);
    }

    protected void doSetDispOrder_Equal(Integer dispOrder) {
        regDispOrder(CK_EQ, dispOrder);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_NotEqual(Integer dispOrder) {
        doSetDispOrder_NotEqual(dispOrder);
    }

    protected void doSetDispOrder_NotEqual(Integer dispOrder) {
        regDispOrder(CK_NES, dispOrder);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_GreaterThan(Integer dispOrder) {
        regDispOrder(CK_GT, dispOrder);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_LessThan(Integer dispOrder) {
        regDispOrder(CK_LT, dispOrder);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_GreaterEqual(Integer dispOrder) {
        regDispOrder(CK_GE, dispOrder);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_LessEqual(Integer dispOrder) {
        regDispOrder(CK_LE, dispOrder);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDispOrder_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDispOrder_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDispOrder_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDispOrder(), "DISP_ORDER", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrderList The collection of dispOrder as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDispOrder_InScope(Collection<Integer> dispOrderList) {
        doSetDispOrder_InScope(dispOrderList);
    }

    protected void doSetDispOrder_InScope(Collection<Integer> dispOrderList) {
        regINS(CK_INS, cTL(dispOrderList), xgetCValueDispOrder(), "DISP_ORDER");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrderList The collection of dispOrder as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDispOrder_NotInScope(Collection<Integer> dispOrderList) {
        doSetDispOrder_NotInScope(dispOrderList);
    }

    protected void doSetDispOrder_NotInScope(Collection<Integer> dispOrderList) {
        regINS(CK_NINS, cTL(dispOrderList), xgetCValueDispOrder(), "DISP_ORDER");
    }

    protected void regDispOrder(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDispOrder(), "DISP_ORDER"); }
    protected abstract ConditionValue xgetCValueDispOrder();

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
    public HpSLCFunction<SkillCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, SkillCB.class);
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
    public HpSLCFunction<SkillCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, SkillCB.class);
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
    public HpSLCFunction<SkillCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, SkillCB.class);
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
    public HpSLCFunction<SkillCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, SkillCB.class);
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
    public HpSLCFunction<SkillCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, SkillCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;SkillCB&gt;() {
     *     public void query(SkillCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SkillCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, SkillCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        SkillCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(SkillCQ sq);

    protected SkillCB xcreateScalarConditionCB() {
        SkillCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected SkillCB xcreateScalarConditionPartitionByCB() {
        SkillCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<SkillCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SkillCB cb = new SkillCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "SKILL_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(SkillCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<SkillCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(SkillCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SkillCB cb = new SkillCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "SKILL_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(SkillCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<SkillCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        SkillCB cb = new SkillCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(SkillCQ sq);

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
    protected SkillCB newMyCB() {
        return new SkillCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return SkillCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
