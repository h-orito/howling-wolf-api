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
 * The abstract condition-query of COMING_OUT.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsComingOutCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsComingOutCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "COMING_OUT";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
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
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
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
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @param villagePlayerId The value of villagePlayerId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_GreaterThan(Integer villagePlayerId) {
        regVillagePlayerId(CK_GT, villagePlayerId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @param villagePlayerId The value of villagePlayerId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_LessThan(Integer villagePlayerId) {
        regVillagePlayerId(CK_LT, villagePlayerId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @param villagePlayerId The value of villagePlayerId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_GreaterEqual(Integer villagePlayerId) {
        regVillagePlayerId(CK_GE, villagePlayerId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @param villagePlayerId The value of villagePlayerId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillagePlayerId_LessEqual(Integer villagePlayerId) {
        regVillagePlayerId(CK_LE, villagePlayerId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
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
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @param minNumber The min number of villagePlayerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villagePlayerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillagePlayerId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
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
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @param villagePlayerIdList The collection of villagePlayerId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillagePlayerId_NotInScope(Collection<Integer> villagePlayerIdList) {
        doSetVillagePlayerId_NotInScope(villagePlayerIdList);
    }

    protected void doSetVillagePlayerId_NotInScope(Collection<Integer> villagePlayerIdList) {
        regINS(CK_NINS, cTL(villagePlayerIdList), xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     */
    public void setVillagePlayerId_IsNull() { regVillagePlayerId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     */
    public void setVillagePlayerId_IsNotNull() { regVillagePlayerId(CK_ISNN, DOBJ); }

    protected void regVillagePlayerId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillagePlayerId(), "VILLAGE_PLAYER_ID"); }
    protected abstract ConditionValue xgetCValueVillagePlayerId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     * @param skillCode The value of skillCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_Equal(String skillCode) {
        doSetSkillCode_Equal(fRES(skillCode));
    }

    /**
     * Equal(=). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill} <br>
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
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     * @param skillCode The value of skillCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_NotEqual(String skillCode) {
        doSetSkillCode_NotEqual(fRES(skillCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Skill. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill} <br>
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
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     * @param skillCodeList The collection of skillCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_InScope(Collection<String> skillCodeList) {
        doSetSkillCode_InScope(skillCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill} <br>
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
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     * @param skillCodeList The collection of skillCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setSkillCode_NotInScope(Collection<String> skillCodeList) {
        doSetSkillCode_NotInScope(skillCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Skill. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill} <br>
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
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     */
    public void setSkillCode_IsNull() { regSkillCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     */
    public void setSkillCode_IsNotNull() { regSkillCode(CK_ISNN, DOBJ); }

    protected void regSkillCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSkillCode(), "SKILL_CODE"); }
    protected abstract ConditionValue xgetCValueSkillCode();

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
    public HpSLCFunction<ComingOutCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, ComingOutCB.class);
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
    public HpSLCFunction<ComingOutCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, ComingOutCB.class);
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
    public HpSLCFunction<ComingOutCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, ComingOutCB.class);
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
    public HpSLCFunction<ComingOutCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, ComingOutCB.class);
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
    public HpSLCFunction<ComingOutCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, ComingOutCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;ComingOutCB&gt;() {
     *     public void query(ComingOutCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<ComingOutCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, ComingOutCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        ComingOutCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(ComingOutCQ sq);

    protected ComingOutCB xcreateScalarConditionCB() {
        ComingOutCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected ComingOutCB xcreateScalarConditionPartitionByCB() {
        ComingOutCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

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
    protected ComingOutCB newMyCB() {
        return new ComingOutCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return ComingOutCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
