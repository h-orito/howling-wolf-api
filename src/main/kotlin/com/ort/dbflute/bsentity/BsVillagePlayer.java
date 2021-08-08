package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.ort.dbflute.allcommon.EntityDefinedCommonColumn;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.allcommon.CDef;
import com.ort.dbflute.exentity.*;

/**
 * The entity of VILLAGE_PLAYER as TABLE. <br>
 * 村参加者
 * <pre>
 * [primary-key]
 *     VILLAGE_PLAYER_ID
 *
 * [column]
 *     VILLAGE_PLAYER_ID, VILLAGE_ID, PLAYER_ID, CHARA_ID, SKILL_CODE, REQUEST_SKILL_CODE, SECOND_REQUEST_SKILL_CODE, IS_DEAD, IS_SPECTATOR, DEAD_REASON_CODE, DEAD_VILLAGE_DAY_ID, IS_GONE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     VILLAGE_PLAYER_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     CHARA, DEAD_REASON, VILLAGE_DAY, PLAYER, SKILL, VILLAGE
 *
 * [referrer table]
 *     ABILITY, COMING_OUT, COMMIT, VOTE
 *
 * [foreign property]
 *     chara, deadReason, villageDay, player, skillByRequestSkillCode, skillBySecondRequestSkillCode, skillBySkillCode, village
 *
 * [referrer property]
 *     abilityByTargetVillagePlayerIdList, abilityByVillagePlayerIdList, comingOutList, commitList, voteByTargetVillagePlayerIdList, voteByVillagePlayerIdList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villagePlayerId = entity.getVillagePlayerId();
 * Integer villageId = entity.getVillageId();
 * Integer playerId = entity.getPlayerId();
 * Integer charaId = entity.getCharaId();
 * String skillCode = entity.getSkillCode();
 * String requestSkillCode = entity.getRequestSkillCode();
 * String secondRequestSkillCode = entity.getSecondRequestSkillCode();
 * Boolean isDead = entity.getIsDead();
 * Boolean isSpectator = entity.getIsSpectator();
 * String deadReasonCode = entity.getDeadReasonCode();
 * Integer deadVillageDayId = entity.getDeadVillageDayId();
 * Boolean isGone = entity.getIsGone();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillagePlayerId(villagePlayerId);
 * entity.setVillageId(villageId);
 * entity.setPlayerId(playerId);
 * entity.setCharaId(charaId);
 * entity.setSkillCode(skillCode);
 * entity.setRequestSkillCode(requestSkillCode);
 * entity.setSecondRequestSkillCode(secondRequestSkillCode);
 * entity.setIsDead(isDead);
 * entity.setIsSpectator(isSpectator);
 * entity.setDeadReasonCode(deadReasonCode);
 * entity.setDeadVillageDayId(deadVillageDayId);
 * entity.setIsGone(isGone);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillagePlayer extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _villagePlayerId;

    /** VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE} */
    protected Integer _villageId;

    /** PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to PLAYER} */
    protected Integer _playerId;

    /** CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to CHARA} */
    protected Integer _charaId;

    /** SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} */
    protected String _skillCode;

    /** REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} */
    protected String _requestSkillCode;

    /** SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} */
    protected String _secondRequestSkillCode;

    /** IS_DEAD: {NotNull, BIT} */
    protected Boolean _isDead;

    /** IS_SPECTATOR: {NotNull, BIT} */
    protected Boolean _isSpectator;

    /** DEAD_REASON_CODE: {IX, VARCHAR(20), FK to DEAD_REASON, classification=DeadReason} */
    protected String _deadReasonCode;

    /** DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to VILLAGE_DAY} */
    protected Integer _deadVillageDayId;

    /** IS_GONE: {NotNull, BIT} */
    protected Boolean _isGone;

    /** REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** REGISTER_TRACE: {NotNull, VARCHAR(64)} */
    protected String _registerTrace;

    /** UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** UPDATE_TRACE: {NotNull, VARCHAR(64)} */
    protected String _updateTrace;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "VILLAGE_PLAYER";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villagePlayerId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of skillCode as the classification of Skill. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Skill getSkillCodeAsSkill() {
        return CDef.Skill.codeOf(getSkillCode());
    }

    /**
     * Set the value of skillCode as the classification of Skill. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setSkillCodeAsSkill(CDef.Skill cdef) {
        setSkillCode(cdef != null ? cdef.code() : null);
    }

    /**
     * Get the value of requestSkillCode as the classification of Skill. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Skill getRequestSkillCodeAsSkill() {
        return CDef.Skill.codeOf(getRequestSkillCode());
    }

    /**
     * Set the value of requestSkillCode as the classification of Skill. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setRequestSkillCodeAsSkill(CDef.Skill cdef) {
        setRequestSkillCode(cdef != null ? cdef.code() : null);
    }

    /**
     * Get the value of secondRequestSkillCode as the classification of Skill. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Skill getSecondRequestSkillCodeAsSkill() {
        return CDef.Skill.codeOf(getSecondRequestSkillCode());
    }

    /**
     * Set the value of secondRequestSkillCode as the classification of Skill. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setSecondRequestSkillCodeAsSkill(CDef.Skill cdef) {
        setSecondRequestSkillCode(cdef != null ? cdef.code() : null);
    }

    /**
     * Get the value of deadReasonCode as the classification of DeadReason. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to DEAD_REASON, classification=DeadReason} <br>
     * 死亡理由
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.DeadReason getDeadReasonCodeAsDeadReason() {
        return CDef.DeadReason.codeOf(getDeadReasonCode());
    }

    /**
     * Set the value of deadReasonCode as the classification of DeadReason. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to DEAD_REASON, classification=DeadReason} <br>
     * 死亡理由
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setDeadReasonCodeAsDeadReason(CDef.DeadReason cdef) {
        setDeadReasonCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of skillCode as C国狂人 (CMADMAN). <br>
     * C国狂人
     */
    public void setSkillCode_C国狂人() {
        setSkillCodeAsSkill(CDef.Skill.C国狂人);
    }

    /**
     * Set the value of skillCode as 妖狐 (FOX). <br>
     * 妖狐
     */
    public void setSkillCode_妖狐() {
        setSkillCodeAsSkill(CDef.Skill.妖狐);
    }

    /**
     * Set the value of skillCode as 狩人 (HUNTER). <br>
     * 狩人
     */
    public void setSkillCode_狩人() {
        setSkillCodeAsSkill(CDef.Skill.狩人);
    }

    /**
     * Set the value of skillCode as おまかせ (LEFTOVER). <br>
     * おまかせ
     */
    public void setSkillCode_おまかせ() {
        setSkillCodeAsSkill(CDef.Skill.おまかせ);
    }

    /**
     * Set the value of skillCode as 狂人 (MADMAN). <br>
     * 狂人
     */
    public void setSkillCode_狂人() {
        setSkillCodeAsSkill(CDef.Skill.狂人);
    }

    /**
     * Set the value of skillCode as 共有者 (MASON). <br>
     * 共有者
     */
    public void setSkillCode_共有者() {
        setSkillCodeAsSkill(CDef.Skill.共有者);
    }

    /**
     * Set the value of skillCode as 霊能者 (MEDIUM). <br>
     * 霊能者
     */
    public void setSkillCode_霊能者() {
        setSkillCodeAsSkill(CDef.Skill.霊能者);
    }

    /**
     * Set the value of skillCode as 占い師 (SEER). <br>
     * 占い師
     */
    public void setSkillCode_占い師() {
        setSkillCodeAsSkill(CDef.Skill.占い師);
    }

    /**
     * Set the value of skillCode as 村人 (VILLAGER). <br>
     * 村人
     */
    public void setSkillCode_村人() {
        setSkillCodeAsSkill(CDef.Skill.村人);
    }

    /**
     * Set the value of skillCode as おまかせ村人陣営 (VILLAGERS). <br>
     * おまかせ（村人陣営）
     */
    public void setSkillCode_おまかせ村人陣営() {
        setSkillCodeAsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * Set the value of skillCode as 人狼 (WEREWOLF). <br>
     * 人狼
     */
    public void setSkillCode_人狼() {
        setSkillCodeAsSkill(CDef.Skill.人狼);
    }

    /**
     * Set the value of skillCode as おまかせ人狼陣営 (WEREWOLFS). <br>
     * おまかせ（人狼陣営）
     */
    public void setSkillCode_おまかせ人狼陣営() {
        setSkillCodeAsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    /**
     * Set the value of requestSkillCode as C国狂人 (CMADMAN). <br>
     * C国狂人
     */
    public void setRequestSkillCode_C国狂人() {
        setRequestSkillCodeAsSkill(CDef.Skill.C国狂人);
    }

    /**
     * Set the value of requestSkillCode as 妖狐 (FOX). <br>
     * 妖狐
     */
    public void setRequestSkillCode_妖狐() {
        setRequestSkillCodeAsSkill(CDef.Skill.妖狐);
    }

    /**
     * Set the value of requestSkillCode as 狩人 (HUNTER). <br>
     * 狩人
     */
    public void setRequestSkillCode_狩人() {
        setRequestSkillCodeAsSkill(CDef.Skill.狩人);
    }

    /**
     * Set the value of requestSkillCode as おまかせ (LEFTOVER). <br>
     * おまかせ
     */
    public void setRequestSkillCode_おまかせ() {
        setRequestSkillCodeAsSkill(CDef.Skill.おまかせ);
    }

    /**
     * Set the value of requestSkillCode as 狂人 (MADMAN). <br>
     * 狂人
     */
    public void setRequestSkillCode_狂人() {
        setRequestSkillCodeAsSkill(CDef.Skill.狂人);
    }

    /**
     * Set the value of requestSkillCode as 共有者 (MASON). <br>
     * 共有者
     */
    public void setRequestSkillCode_共有者() {
        setRequestSkillCodeAsSkill(CDef.Skill.共有者);
    }

    /**
     * Set the value of requestSkillCode as 霊能者 (MEDIUM). <br>
     * 霊能者
     */
    public void setRequestSkillCode_霊能者() {
        setRequestSkillCodeAsSkill(CDef.Skill.霊能者);
    }

    /**
     * Set the value of requestSkillCode as 占い師 (SEER). <br>
     * 占い師
     */
    public void setRequestSkillCode_占い師() {
        setRequestSkillCodeAsSkill(CDef.Skill.占い師);
    }

    /**
     * Set the value of requestSkillCode as 村人 (VILLAGER). <br>
     * 村人
     */
    public void setRequestSkillCode_村人() {
        setRequestSkillCodeAsSkill(CDef.Skill.村人);
    }

    /**
     * Set the value of requestSkillCode as おまかせ村人陣営 (VILLAGERS). <br>
     * おまかせ（村人陣営）
     */
    public void setRequestSkillCode_おまかせ村人陣営() {
        setRequestSkillCodeAsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * Set the value of requestSkillCode as 人狼 (WEREWOLF). <br>
     * 人狼
     */
    public void setRequestSkillCode_人狼() {
        setRequestSkillCodeAsSkill(CDef.Skill.人狼);
    }

    /**
     * Set the value of requestSkillCode as おまかせ人狼陣営 (WEREWOLFS). <br>
     * おまかせ（人狼陣営）
     */
    public void setRequestSkillCode_おまかせ人狼陣営() {
        setRequestSkillCodeAsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    /**
     * Set the value of secondRequestSkillCode as C国狂人 (CMADMAN). <br>
     * C国狂人
     */
    public void setSecondRequestSkillCode_C国狂人() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.C国狂人);
    }

    /**
     * Set the value of secondRequestSkillCode as 妖狐 (FOX). <br>
     * 妖狐
     */
    public void setSecondRequestSkillCode_妖狐() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.妖狐);
    }

    /**
     * Set the value of secondRequestSkillCode as 狩人 (HUNTER). <br>
     * 狩人
     */
    public void setSecondRequestSkillCode_狩人() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.狩人);
    }

    /**
     * Set the value of secondRequestSkillCode as おまかせ (LEFTOVER). <br>
     * おまかせ
     */
    public void setSecondRequestSkillCode_おまかせ() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.おまかせ);
    }

    /**
     * Set the value of secondRequestSkillCode as 狂人 (MADMAN). <br>
     * 狂人
     */
    public void setSecondRequestSkillCode_狂人() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.狂人);
    }

    /**
     * Set the value of secondRequestSkillCode as 共有者 (MASON). <br>
     * 共有者
     */
    public void setSecondRequestSkillCode_共有者() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.共有者);
    }

    /**
     * Set the value of secondRequestSkillCode as 霊能者 (MEDIUM). <br>
     * 霊能者
     */
    public void setSecondRequestSkillCode_霊能者() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.霊能者);
    }

    /**
     * Set the value of secondRequestSkillCode as 占い師 (SEER). <br>
     * 占い師
     */
    public void setSecondRequestSkillCode_占い師() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.占い師);
    }

    /**
     * Set the value of secondRequestSkillCode as 村人 (VILLAGER). <br>
     * 村人
     */
    public void setSecondRequestSkillCode_村人() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.村人);
    }

    /**
     * Set the value of secondRequestSkillCode as おまかせ村人陣営 (VILLAGERS). <br>
     * おまかせ（村人陣営）
     */
    public void setSecondRequestSkillCode_おまかせ村人陣営() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.おまかせ村人陣営);
    }

    /**
     * Set the value of secondRequestSkillCode as 人狼 (WEREWOLF). <br>
     * 人狼
     */
    public void setSecondRequestSkillCode_人狼() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.人狼);
    }

    /**
     * Set the value of secondRequestSkillCode as おまかせ人狼陣営 (WEREWOLFS). <br>
     * おまかせ（人狼陣営）
     */
    public void setSecondRequestSkillCode_おまかせ人狼陣営() {
        setSecondRequestSkillCodeAsSkill(CDef.Skill.おまかせ人狼陣営);
    }

    /**
     * Set the value of deadReasonCode as 襲撃 (ATTACK). <br>
     * 襲撃
     */
    public void setDeadReasonCode_襲撃() {
        setDeadReasonCodeAsDeadReason(CDef.DeadReason.襲撃);
    }

    /**
     * Set the value of deadReasonCode as 呪殺 (DIVINED). <br>
     * 呪殺
     */
    public void setDeadReasonCode_呪殺() {
        setDeadReasonCodeAsDeadReason(CDef.DeadReason.呪殺);
    }

    /**
     * Set the value of deadReasonCode as 処刑 (EXECUTE). <br>
     * 処刑
     */
    public void setDeadReasonCode_処刑() {
        setDeadReasonCodeAsDeadReason(CDef.DeadReason.処刑);
    }

    /**
     * Set the value of deadReasonCode as 突然 (SUDDEN). <br>
     * 突然
     */
    public void setDeadReasonCode_突然() {
        setDeadReasonCodeAsDeadReason(CDef.DeadReason.突然);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of skillCode C国狂人? <br>
     * C国狂人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCodeC国狂人() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.C国狂人) : false;
    }

    /**
     * Is the value of skillCode 妖狐? <br>
     * 妖狐
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode妖狐() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.妖狐) : false;
    }

    /**
     * Is the value of skillCode 狩人? <br>
     * 狩人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode狩人() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.狩人) : false;
    }

    /**
     * Is the value of skillCode おまかせ? <br>
     * おまかせ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCodeおまかせ() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ) : false;
    }

    /**
     * Is the value of skillCode 狂人? <br>
     * 狂人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode狂人() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.狂人) : false;
    }

    /**
     * Is the value of skillCode 共有者? <br>
     * 共有者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode共有者() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.共有者) : false;
    }

    /**
     * Is the value of skillCode 霊能者? <br>
     * 霊能者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode霊能者() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.霊能者) : false;
    }

    /**
     * Is the value of skillCode 占い師? <br>
     * 占い師
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode占い師() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.占い師) : false;
    }

    /**
     * Is the value of skillCode 村人? <br>
     * 村人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode村人() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.村人) : false;
    }

    /**
     * Is the value of skillCode おまかせ村人陣営? <br>
     * おまかせ（村人陣営）
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCodeおまかせ村人陣営() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ村人陣営) : false;
    }

    /**
     * Is the value of skillCode 人狼? <br>
     * 人狼
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCode人狼() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.人狼) : false;
    }

    /**
     * Is the value of skillCode おまかせ人狼陣営? <br>
     * おまかせ（人狼陣営）
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSkillCodeおまかせ人狼陣営() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ人狼陣営) : false;
    }

    /**
     * 囁きを見られる <br>
     * The group elements:[人狼, C国狂人]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_ViewableWerewolfSay() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isViewableWerewolfSay();
    }

    /**
     * 囁き可能 <br>
     * The group elements:[人狼, C国狂人]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_AvailableWerewolfSay() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isAvailableWerewolfSay();
    }

    /**
     * 襲撃対象に選べない <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_NotSelectableAttack() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isNotSelectableAttack();
    }

    /**
     * 占い結果が人狼になる <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_DivineResultWolf() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isDivineResultWolf();
    }

    /**
     * 霊能結果が人狼になる <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_PsychicResultWolf() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isPsychicResultWolf();
    }

    /**
     * 襲撃能力を持つ <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_HasAttackAbility() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isHasAttackAbility();
    }

    /**
     * 占い能力を持つ <br>
     * The group elements:[占い師]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_HasDivineAbility() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isHasDivineAbility();
    }

    /**
     * 護衛能力を持つ <br>
     * The group elements:[狩人]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_HasGuardAbility() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isHasGuardAbility();
    }

    /**
     * 霊能能力を持つ <br>
     * The group elements:[霊能者]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_HasPsychicAbility() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isHasPsychicAbility();
    }

    /**
     * 勝敗判定時狼にカウントする <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_CountWolf() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isCountWolf();
    }

    /**
     * 勝敗判定時に人間としてカウントしない <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_NoCount() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isNoCount();
    }

    /**
     * おまかせ系 <br>
     * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_SomeoneSkill() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isSomeoneSkill();
    }

    /**
     * 共有系としてお互いに認知できる <br>
     * The group elements:[共有者]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_RecognizableEachMason() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isRecognizableEachMason();
    }

    /**
     * 襲撃耐性を持つ <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_NoDeadByAttack() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isNoDeadByAttack();
    }

    /**
     * 占いにより死亡する <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isSkillCode_DeadByDivine() {
        CDef.Skill cdef = getSkillCodeAsSkill();
        return cdef != null && cdef.isDeadByDivine();
    }

    /**
     * Is the value of requestSkillCode C国狂人? <br>
     * C国狂人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCodeC国狂人() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.C国狂人) : false;
    }

    /**
     * Is the value of requestSkillCode 妖狐? <br>
     * 妖狐
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode妖狐() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.妖狐) : false;
    }

    /**
     * Is the value of requestSkillCode 狩人? <br>
     * 狩人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode狩人() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.狩人) : false;
    }

    /**
     * Is the value of requestSkillCode おまかせ? <br>
     * おまかせ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCodeおまかせ() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ) : false;
    }

    /**
     * Is the value of requestSkillCode 狂人? <br>
     * 狂人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode狂人() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.狂人) : false;
    }

    /**
     * Is the value of requestSkillCode 共有者? <br>
     * 共有者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode共有者() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.共有者) : false;
    }

    /**
     * Is the value of requestSkillCode 霊能者? <br>
     * 霊能者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode霊能者() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.霊能者) : false;
    }

    /**
     * Is the value of requestSkillCode 占い師? <br>
     * 占い師
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode占い師() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.占い師) : false;
    }

    /**
     * Is the value of requestSkillCode 村人? <br>
     * 村人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode村人() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.村人) : false;
    }

    /**
     * Is the value of requestSkillCode おまかせ村人陣営? <br>
     * おまかせ（村人陣営）
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCodeおまかせ村人陣営() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ村人陣営) : false;
    }

    /**
     * Is the value of requestSkillCode 人狼? <br>
     * 人狼
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode人狼() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.人狼) : false;
    }

    /**
     * Is the value of requestSkillCode おまかせ人狼陣営? <br>
     * おまかせ（人狼陣営）
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCodeおまかせ人狼陣営() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ人狼陣営) : false;
    }

    /**
     * 囁きを見られる <br>
     * The group elements:[人狼, C国狂人]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_ViewableWerewolfSay() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isViewableWerewolfSay();
    }

    /**
     * 囁き可能 <br>
     * The group elements:[人狼, C国狂人]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_AvailableWerewolfSay() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isAvailableWerewolfSay();
    }

    /**
     * 襲撃対象に選べない <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_NotSelectableAttack() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isNotSelectableAttack();
    }

    /**
     * 占い結果が人狼になる <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_DivineResultWolf() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isDivineResultWolf();
    }

    /**
     * 霊能結果が人狼になる <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_PsychicResultWolf() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isPsychicResultWolf();
    }

    /**
     * 襲撃能力を持つ <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_HasAttackAbility() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasAttackAbility();
    }

    /**
     * 占い能力を持つ <br>
     * The group elements:[占い師]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_HasDivineAbility() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasDivineAbility();
    }

    /**
     * 護衛能力を持つ <br>
     * The group elements:[狩人]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_HasGuardAbility() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasGuardAbility();
    }

    /**
     * 霊能能力を持つ <br>
     * The group elements:[霊能者]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_HasPsychicAbility() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasPsychicAbility();
    }

    /**
     * 勝敗判定時狼にカウントする <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_CountWolf() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isCountWolf();
    }

    /**
     * 勝敗判定時に人間としてカウントしない <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_NoCount() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isNoCount();
    }

    /**
     * おまかせ系 <br>
     * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_SomeoneSkill() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isSomeoneSkill();
    }

    /**
     * 共有系としてお互いに認知できる <br>
     * The group elements:[共有者]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_RecognizableEachMason() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isRecognizableEachMason();
    }

    /**
     * 襲撃耐性を持つ <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_NoDeadByAttack() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isNoDeadByAttack();
    }

    /**
     * 占いにより死亡する <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isRequestSkillCode_DeadByDivine() {
        CDef.Skill cdef = getRequestSkillCodeAsSkill();
        return cdef != null && cdef.isDeadByDivine();
    }

    /**
     * Is the value of secondRequestSkillCode C国狂人? <br>
     * C国狂人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCodeC国狂人() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.C国狂人) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 妖狐? <br>
     * 妖狐
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode妖狐() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.妖狐) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 狩人? <br>
     * 狩人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode狩人() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.狩人) : false;
    }

    /**
     * Is the value of secondRequestSkillCode おまかせ? <br>
     * おまかせ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCodeおまかせ() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 狂人? <br>
     * 狂人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode狂人() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.狂人) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 共有者? <br>
     * 共有者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode共有者() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.共有者) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 霊能者? <br>
     * 霊能者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode霊能者() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.霊能者) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 占い師? <br>
     * 占い師
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode占い師() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.占い師) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 村人? <br>
     * 村人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode村人() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.村人) : false;
    }

    /**
     * Is the value of secondRequestSkillCode おまかせ村人陣営? <br>
     * おまかせ（村人陣営）
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCodeおまかせ村人陣営() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ村人陣営) : false;
    }

    /**
     * Is the value of secondRequestSkillCode 人狼? <br>
     * 人狼
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode人狼() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.人狼) : false;
    }

    /**
     * Is the value of secondRequestSkillCode おまかせ人狼陣営? <br>
     * おまかせ（人狼陣営）
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCodeおまかせ人狼陣営() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null ? cdef.equals(CDef.Skill.おまかせ人狼陣営) : false;
    }

    /**
     * 囁きを見られる <br>
     * The group elements:[人狼, C国狂人]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_ViewableWerewolfSay() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isViewableWerewolfSay();
    }

    /**
     * 囁き可能 <br>
     * The group elements:[人狼, C国狂人]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_AvailableWerewolfSay() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isAvailableWerewolfSay();
    }

    /**
     * 襲撃対象に選べない <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_NotSelectableAttack() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isNotSelectableAttack();
    }

    /**
     * 占い結果が人狼になる <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_DivineResultWolf() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isDivineResultWolf();
    }

    /**
     * 霊能結果が人狼になる <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_PsychicResultWolf() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isPsychicResultWolf();
    }

    /**
     * 襲撃能力を持つ <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_HasAttackAbility() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasAttackAbility();
    }

    /**
     * 占い能力を持つ <br>
     * The group elements:[占い師]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_HasDivineAbility() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasDivineAbility();
    }

    /**
     * 護衛能力を持つ <br>
     * The group elements:[狩人]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_HasGuardAbility() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasGuardAbility();
    }

    /**
     * 霊能能力を持つ <br>
     * The group elements:[霊能者]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_HasPsychicAbility() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isHasPsychicAbility();
    }

    /**
     * 勝敗判定時狼にカウントする <br>
     * The group elements:[人狼]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_CountWolf() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isCountWolf();
    }

    /**
     * 勝敗判定時に人間としてカウントしない <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_NoCount() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isNoCount();
    }

    /**
     * おまかせ系 <br>
     * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_SomeoneSkill() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isSomeoneSkill();
    }

    /**
     * 共有系としてお互いに認知できる <br>
     * The group elements:[共有者]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_RecognizableEachMason() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isRecognizableEachMason();
    }

    /**
     * 襲撃耐性を持つ <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_NoDeadByAttack() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isNoDeadByAttack();
    }

    /**
     * 占いにより死亡する <br>
     * The group elements:[妖狐]
     * @return The determination, true or false.
     */
    public boolean isSecondRequestSkillCode_DeadByDivine() {
        CDef.Skill cdef = getSecondRequestSkillCodeAsSkill();
        return cdef != null && cdef.isDeadByDivine();
    }

    /**
     * Is the value of deadReasonCode 襲撃? <br>
     * 襲撃
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isDeadReasonCode襲撃() {
        CDef.DeadReason cdef = getDeadReasonCodeAsDeadReason();
        return cdef != null ? cdef.equals(CDef.DeadReason.襲撃) : false;
    }

    /**
     * Is the value of deadReasonCode 呪殺? <br>
     * 呪殺
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isDeadReasonCode呪殺() {
        CDef.DeadReason cdef = getDeadReasonCodeAsDeadReason();
        return cdef != null ? cdef.equals(CDef.DeadReason.呪殺) : false;
    }

    /**
     * Is the value of deadReasonCode 処刑? <br>
     * 処刑
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isDeadReasonCode処刑() {
        CDef.DeadReason cdef = getDeadReasonCodeAsDeadReason();
        return cdef != null ? cdef.equals(CDef.DeadReason.処刑) : false;
    }

    /**
     * Is the value of deadReasonCode 突然? <br>
     * 突然
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isDeadReasonCode突然() {
        CDef.DeadReason cdef = getDeadReasonCodeAsDeadReason();
        return cdef != null ? cdef.equals(CDef.DeadReason.突然) : false;
    }

    /**
     * 無惨な死 <br>
     * The group elements:[襲撃, 呪殺]
     * @return The determination, true or false.
     */
    public boolean isDeadReasonCode_MiserableDeath() {
        CDef.DeadReason cdef = getDeadReasonCodeAsDeadReason();
        return cdef != null && cdef.isMiserableDeath();
    }

    /**
     * 霊能判定可能な死因 <br>
     * The group elements:[処刑, 突然]
     * @return The determination, true or false.
     */
    public boolean isDeadReasonCode_PsychicableDeath() {
        CDef.DeadReason cdef = getDeadReasonCodeAsDeadReason();
        return cdef != null && cdef.isPsychicableDeath();
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** CHARA by my CHARA_ID, named 'chara'. */
    protected OptionalEntity<Chara> _chara;

    /**
     * [get] CHARA by my CHARA_ID, named 'chara'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'chara'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Chara> getChara() {
        if (_chara == null) { _chara = OptionalEntity.relationEmpty(this, "chara"); }
        return _chara;
    }

    /**
     * [set] CHARA by my CHARA_ID, named 'chara'.
     * @param chara The entity of foreign property 'chara'. (NullAllowed)
     */
    public void setChara(OptionalEntity<Chara> chara) {
        _chara = chara;
    }

    /** DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'. */
    protected OptionalEntity<DeadReason> _deadReason;

    /**
     * [get] DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'deadReason'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<DeadReason> getDeadReason() {
        if (_deadReason == null) { _deadReason = OptionalEntity.relationEmpty(this, "deadReason"); }
        return _deadReason;
    }

    /**
     * [set] DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'.
     * @param deadReason The entity of foreign property 'deadReason'. (NullAllowed)
     */
    public void setDeadReason(OptionalEntity<DeadReason> deadReason) {
        _deadReason = deadReason;
    }

    /** VILLAGE_DAY by my DEAD_VILLAGE_DAY_ID, named 'villageDay'. */
    protected OptionalEntity<VillageDay> _villageDay;

    /**
     * [get] VILLAGE_DAY by my DEAD_VILLAGE_DAY_ID, named 'villageDay'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villageDay'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillageDay> getVillageDay() {
        if (_villageDay == null) { _villageDay = OptionalEntity.relationEmpty(this, "villageDay"); }
        return _villageDay;
    }

    /**
     * [set] VILLAGE_DAY by my DEAD_VILLAGE_DAY_ID, named 'villageDay'.
     * @param villageDay The entity of foreign property 'villageDay'. (NullAllowed)
     */
    public void setVillageDay(OptionalEntity<VillageDay> villageDay) {
        _villageDay = villageDay;
    }

    /** PLAYER by my PLAYER_ID, named 'player'. */
    protected OptionalEntity<Player> _player;

    /**
     * [get] PLAYER by my PLAYER_ID, named 'player'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'player'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Player> getPlayer() {
        if (_player == null) { _player = OptionalEntity.relationEmpty(this, "player"); }
        return _player;
    }

    /**
     * [set] PLAYER by my PLAYER_ID, named 'player'.
     * @param player The entity of foreign property 'player'. (NullAllowed)
     */
    public void setPlayer(OptionalEntity<Player> player) {
        _player = player;
    }

    /** SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'. */
    protected OptionalEntity<Skill> _skillByRequestSkillCode;

    /**
     * [get] SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'skillByRequestSkillCode'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Skill> getSkillByRequestSkillCode() {
        if (_skillByRequestSkillCode == null) { _skillByRequestSkillCode = OptionalEntity.relationEmpty(this, "skillByRequestSkillCode"); }
        return _skillByRequestSkillCode;
    }

    /**
     * [set] SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'.
     * @param skillByRequestSkillCode The entity of foreign property 'skillByRequestSkillCode'. (NullAllowed)
     */
    public void setSkillByRequestSkillCode(OptionalEntity<Skill> skillByRequestSkillCode) {
        _skillByRequestSkillCode = skillByRequestSkillCode;
    }

    /** SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'. */
    protected OptionalEntity<Skill> _skillBySecondRequestSkillCode;

    /**
     * [get] SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'skillBySecondRequestSkillCode'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Skill> getSkillBySecondRequestSkillCode() {
        if (_skillBySecondRequestSkillCode == null) { _skillBySecondRequestSkillCode = OptionalEntity.relationEmpty(this, "skillBySecondRequestSkillCode"); }
        return _skillBySecondRequestSkillCode;
    }

    /**
     * [set] SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'.
     * @param skillBySecondRequestSkillCode The entity of foreign property 'skillBySecondRequestSkillCode'. (NullAllowed)
     */
    public void setSkillBySecondRequestSkillCode(OptionalEntity<Skill> skillBySecondRequestSkillCode) {
        _skillBySecondRequestSkillCode = skillBySecondRequestSkillCode;
    }

    /** SKILL by my SKILL_CODE, named 'skillBySkillCode'. */
    protected OptionalEntity<Skill> _skillBySkillCode;

    /**
     * [get] SKILL by my SKILL_CODE, named 'skillBySkillCode'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'skillBySkillCode'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Skill> getSkillBySkillCode() {
        if (_skillBySkillCode == null) { _skillBySkillCode = OptionalEntity.relationEmpty(this, "skillBySkillCode"); }
        return _skillBySkillCode;
    }

    /**
     * [set] SKILL by my SKILL_CODE, named 'skillBySkillCode'.
     * @param skillBySkillCode The entity of foreign property 'skillBySkillCode'. (NullAllowed)
     */
    public void setSkillBySkillCode(OptionalEntity<Skill> skillBySkillCode) {
        _skillBySkillCode = skillBySkillCode;
    }

    /** VILLAGE by my VILLAGE_ID, named 'village'. */
    protected OptionalEntity<Village> _village;

    /**
     * [get] VILLAGE by my VILLAGE_ID, named 'village'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'village'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Village> getVillage() {
        if (_village == null) { _village = OptionalEntity.relationEmpty(this, "village"); }
        return _village;
    }

    /**
     * [set] VILLAGE by my VILLAGE_ID, named 'village'.
     * @param village The entity of foreign property 'village'. (NullAllowed)
     */
    public void setVillage(OptionalEntity<Village> village) {
        _village = village;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'. */
    protected List<Ability> _abilityByTargetVillagePlayerIdList;

    /**
     * [get] ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'.
     * @return The entity list of referrer property 'abilityByTargetVillagePlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Ability> getAbilityByTargetVillagePlayerIdList() {
        if (_abilityByTargetVillagePlayerIdList == null) { _abilityByTargetVillagePlayerIdList = newReferrerList(); }
        return _abilityByTargetVillagePlayerIdList;
    }

    /**
     * [set] ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'.
     * @param abilityByTargetVillagePlayerIdList The entity list of referrer property 'abilityByTargetVillagePlayerIdList'. (NullAllowed)
     */
    public void setAbilityByTargetVillagePlayerIdList(List<Ability> abilityByTargetVillagePlayerIdList) {
        _abilityByTargetVillagePlayerIdList = abilityByTargetVillagePlayerIdList;
    }

    /** ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'. */
    protected List<Ability> _abilityByVillagePlayerIdList;

    /**
     * [get] ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'.
     * @return The entity list of referrer property 'abilityByVillagePlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Ability> getAbilityByVillagePlayerIdList() {
        if (_abilityByVillagePlayerIdList == null) { _abilityByVillagePlayerIdList = newReferrerList(); }
        return _abilityByVillagePlayerIdList;
    }

    /**
     * [set] ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'.
     * @param abilityByVillagePlayerIdList The entity list of referrer property 'abilityByVillagePlayerIdList'. (NullAllowed)
     */
    public void setAbilityByVillagePlayerIdList(List<Ability> abilityByVillagePlayerIdList) {
        _abilityByVillagePlayerIdList = abilityByVillagePlayerIdList;
    }

    /** COMING_OUT by VILLAGE_PLAYER_ID, named 'comingOutList'. */
    protected List<ComingOut> _comingOutList;

    /**
     * [get] COMING_OUT by VILLAGE_PLAYER_ID, named 'comingOutList'.
     * @return The entity list of referrer property 'comingOutList'. (NotNull: even if no loading, returns empty list)
     */
    public List<ComingOut> getComingOutList() {
        if (_comingOutList == null) { _comingOutList = newReferrerList(); }
        return _comingOutList;
    }

    /**
     * [set] COMING_OUT by VILLAGE_PLAYER_ID, named 'comingOutList'.
     * @param comingOutList The entity list of referrer property 'comingOutList'. (NullAllowed)
     */
    public void setComingOutList(List<ComingOut> comingOutList) {
        _comingOutList = comingOutList;
    }

    /** COMMIT by VILLAGE_PLAYER_ID, named 'commitList'. */
    protected List<Commit> _commitList;

    /**
     * [get] COMMIT by VILLAGE_PLAYER_ID, named 'commitList'.
     * @return The entity list of referrer property 'commitList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Commit> getCommitList() {
        if (_commitList == null) { _commitList = newReferrerList(); }
        return _commitList;
    }

    /**
     * [set] COMMIT by VILLAGE_PLAYER_ID, named 'commitList'.
     * @param commitList The entity list of referrer property 'commitList'. (NullAllowed)
     */
    public void setCommitList(List<Commit> commitList) {
        _commitList = commitList;
    }

    /** VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'. */
    protected List<Vote> _voteByTargetVillagePlayerIdList;

    /**
     * [get] VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'.
     * @return The entity list of referrer property 'voteByTargetVillagePlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Vote> getVoteByTargetVillagePlayerIdList() {
        if (_voteByTargetVillagePlayerIdList == null) { _voteByTargetVillagePlayerIdList = newReferrerList(); }
        return _voteByTargetVillagePlayerIdList;
    }

    /**
     * [set] VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'.
     * @param voteByTargetVillagePlayerIdList The entity list of referrer property 'voteByTargetVillagePlayerIdList'. (NullAllowed)
     */
    public void setVoteByTargetVillagePlayerIdList(List<Vote> voteByTargetVillagePlayerIdList) {
        _voteByTargetVillagePlayerIdList = voteByTargetVillagePlayerIdList;
    }

    /** VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'. */
    protected List<Vote> _voteByVillagePlayerIdList;

    /**
     * [get] VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'.
     * @return The entity list of referrer property 'voteByVillagePlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Vote> getVoteByVillagePlayerIdList() {
        if (_voteByVillagePlayerIdList == null) { _voteByVillagePlayerIdList = newReferrerList(); }
        return _voteByVillagePlayerIdList;
    }

    /**
     * [set] VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'.
     * @param voteByVillagePlayerIdList The entity list of referrer property 'voteByVillagePlayerIdList'. (NullAllowed)
     */
    public void setVoteByVillagePlayerIdList(List<Vote> voteByVillagePlayerIdList) {
        _voteByVillagePlayerIdList = voteByVillagePlayerIdList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVillagePlayer) {
            BsVillagePlayer other = (BsVillagePlayer)obj;
            if (!xSV(_villagePlayerId, other._villagePlayerId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villagePlayerId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_chara != null && _chara.isPresent())
        { sb.append(li).append(xbRDS(_chara, "chara")); }
        if (_deadReason != null && _deadReason.isPresent())
        { sb.append(li).append(xbRDS(_deadReason, "deadReason")); }
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(li).append(xbRDS(_villageDay, "villageDay")); }
        if (_player != null && _player.isPresent())
        { sb.append(li).append(xbRDS(_player, "player")); }
        if (_skillByRequestSkillCode != null && _skillByRequestSkillCode.isPresent())
        { sb.append(li).append(xbRDS(_skillByRequestSkillCode, "skillByRequestSkillCode")); }
        if (_skillBySecondRequestSkillCode != null && _skillBySecondRequestSkillCode.isPresent())
        { sb.append(li).append(xbRDS(_skillBySecondRequestSkillCode, "skillBySecondRequestSkillCode")); }
        if (_skillBySkillCode != null && _skillBySkillCode.isPresent())
        { sb.append(li).append(xbRDS(_skillBySkillCode, "skillBySkillCode")); }
        if (_village != null && _village.isPresent())
        { sb.append(li).append(xbRDS(_village, "village")); }
        if (_abilityByTargetVillagePlayerIdList != null) { for (Ability et : _abilityByTargetVillagePlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "abilityByTargetVillagePlayerIdList")); } } }
        if (_abilityByVillagePlayerIdList != null) { for (Ability et : _abilityByVillagePlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "abilityByVillagePlayerIdList")); } } }
        if (_comingOutList != null) { for (ComingOut et : _comingOutList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "comingOutList")); } } }
        if (_commitList != null) { for (Commit et : _commitList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "commitList")); } } }
        if (_voteByTargetVillagePlayerIdList != null) { for (Vote et : _voteByTargetVillagePlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "voteByTargetVillagePlayerIdList")); } } }
        if (_voteByVillagePlayerIdList != null) { for (Vote et : _voteByVillagePlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "voteByVillagePlayerIdList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villagePlayerId));
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_playerId));
        sb.append(dm).append(xfND(_charaId));
        sb.append(dm).append(xfND(_skillCode));
        sb.append(dm).append(xfND(_requestSkillCode));
        sb.append(dm).append(xfND(_secondRequestSkillCode));
        sb.append(dm).append(xfND(_isDead));
        sb.append(dm).append(xfND(_isSpectator));
        sb.append(dm).append(xfND(_deadReasonCode));
        sb.append(dm).append(xfND(_deadVillageDayId));
        sb.append(dm).append(xfND(_isGone));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerTrace));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateTrace));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_chara != null && _chara.isPresent())
        { sb.append(dm).append("chara"); }
        if (_deadReason != null && _deadReason.isPresent())
        { sb.append(dm).append("deadReason"); }
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(dm).append("villageDay"); }
        if (_player != null && _player.isPresent())
        { sb.append(dm).append("player"); }
        if (_skillByRequestSkillCode != null && _skillByRequestSkillCode.isPresent())
        { sb.append(dm).append("skillByRequestSkillCode"); }
        if (_skillBySecondRequestSkillCode != null && _skillBySecondRequestSkillCode.isPresent())
        { sb.append(dm).append("skillBySecondRequestSkillCode"); }
        if (_skillBySkillCode != null && _skillBySkillCode.isPresent())
        { sb.append(dm).append("skillBySkillCode"); }
        if (_village != null && _village.isPresent())
        { sb.append(dm).append("village"); }
        if (_abilityByTargetVillagePlayerIdList != null && !_abilityByTargetVillagePlayerIdList.isEmpty())
        { sb.append(dm).append("abilityByTargetVillagePlayerIdList"); }
        if (_abilityByVillagePlayerIdList != null && !_abilityByVillagePlayerIdList.isEmpty())
        { sb.append(dm).append("abilityByVillagePlayerIdList"); }
        if (_comingOutList != null && !_comingOutList.isEmpty())
        { sb.append(dm).append("comingOutList"); }
        if (_commitList != null && !_commitList.isEmpty())
        { sb.append(dm).append("commitList"); }
        if (_voteByTargetVillagePlayerIdList != null && !_voteByTargetVillagePlayerIdList.isEmpty())
        { sb.append(dm).append("voteByTargetVillagePlayerIdList"); }
        if (_voteByVillagePlayerIdList != null && !_voteByVillagePlayerIdList.isEmpty())
        { sb.append(dm).append("voteByVillagePlayerIdList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VillagePlayer clone() {
        return (VillagePlayer)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * 村参加者ID
     * @return The value of the column 'VILLAGE_PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillagePlayerId() {
        checkSpecifiedProperty("villagePlayerId");
        return _villagePlayerId;
    }

    /**
     * [set] VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * 村参加者ID
     * @param villagePlayerId The value of the column 'VILLAGE_PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillagePlayerId(Integer villagePlayerId) {
        registerModifiedProperty("villagePlayerId");
        _villagePlayerId = villagePlayerId;
    }

    /**
     * [get] VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE} <br>
     * 村ID
     * @return The value of the column 'VILLAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageId() {
        checkSpecifiedProperty("villageId");
        return _villageId;
    }

    /**
     * [set] VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE} <br>
     * 村ID
     * @param villageId The value of the column 'VILLAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageId(Integer villageId) {
        registerModifiedProperty("villageId");
        _villageId = villageId;
    }

    /**
     * [get] PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to PLAYER} <br>
     * プレイヤーID
     * @return The value of the column 'PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getPlayerId() {
        checkSpecifiedProperty("playerId");
        return _playerId;
    }

    /**
     * [set] PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to PLAYER} <br>
     * プレイヤーID
     * @param playerId The value of the column 'PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPlayerId(Integer playerId) {
        registerModifiedProperty("playerId");
        _playerId = playerId;
    }

    /**
     * [get] CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to CHARA} <br>
     * キャラクターID
     * @return The value of the column 'CHARA_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCharaId() {
        checkSpecifiedProperty("charaId");
        return _charaId;
    }

    /**
     * [set] CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to CHARA} <br>
     * キャラクターID
     * @param charaId The value of the column 'CHARA_ID'. (basically NotNull if update: for the constraint)
     */
    public void setCharaId(Integer charaId) {
        registerModifiedProperty("charaId");
        _charaId = charaId;
    }

    /**
     * [get] SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職コード
     * @return The value of the column 'SKILL_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getSkillCode() {
        checkSpecifiedProperty("skillCode");
        return convertEmptyToNull(_skillCode);
    }

    /**
     * [set] SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 役職コード
     * @param skillCode The value of the column 'SKILL_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    protected void setSkillCode(String skillCode) {
        checkClassificationCode("SKILL_CODE", CDef.DefMeta.Skill, skillCode);
        registerModifiedProperty("skillCode");
        _skillCode = skillCode;
    }

    /**
     * [get] REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 希望役職コード
     * @return The value of the column 'REQUEST_SKILL_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getRequestSkillCode() {
        checkSpecifiedProperty("requestSkillCode");
        return convertEmptyToNull(_requestSkillCode);
    }

    /**
     * [set] REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 希望役職コード
     * @param requestSkillCode The value of the column 'REQUEST_SKILL_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    protected void setRequestSkillCode(String requestSkillCode) {
        checkClassificationCode("REQUEST_SKILL_CODE", CDef.DefMeta.Skill, requestSkillCode);
        registerModifiedProperty("requestSkillCode");
        _requestSkillCode = requestSkillCode;
    }

    /**
     * [get] SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 第二希望役職コード
     * @return The value of the column 'SECOND_REQUEST_SKILL_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getSecondRequestSkillCode() {
        checkSpecifiedProperty("secondRequestSkillCode");
        return convertEmptyToNull(_secondRequestSkillCode);
    }

    /**
     * [set] SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill} <br>
     * 第二希望役職コード
     * @param secondRequestSkillCode The value of the column 'SECOND_REQUEST_SKILL_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    protected void setSecondRequestSkillCode(String secondRequestSkillCode) {
        checkClassificationCode("SECOND_REQUEST_SKILL_CODE", CDef.DefMeta.Skill, secondRequestSkillCode);
        registerModifiedProperty("secondRequestSkillCode");
        _secondRequestSkillCode = secondRequestSkillCode;
    }

    /**
     * [get] IS_DEAD: {NotNull, BIT} <br>
     * 死亡しているか
     * @return The value of the column 'IS_DEAD'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsDead() {
        checkSpecifiedProperty("isDead");
        return _isDead;
    }

    /**
     * [set] IS_DEAD: {NotNull, BIT} <br>
     * 死亡しているか
     * @param isDead The value of the column 'IS_DEAD'. (basically NotNull if update: for the constraint)
     */
    public void setIsDead(Boolean isDead) {
        registerModifiedProperty("isDead");
        _isDead = isDead;
    }

    /**
     * [get] IS_SPECTATOR: {NotNull, BIT} <br>
     * 見学者か
     * @return The value of the column 'IS_SPECTATOR'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsSpectator() {
        checkSpecifiedProperty("isSpectator");
        return _isSpectator;
    }

    /**
     * [set] IS_SPECTATOR: {NotNull, BIT} <br>
     * 見学者か
     * @param isSpectator The value of the column 'IS_SPECTATOR'. (basically NotNull if update: for the constraint)
     */
    public void setIsSpectator(Boolean isSpectator) {
        registerModifiedProperty("isSpectator");
        _isSpectator = isSpectator;
    }

    /**
     * [get] DEAD_REASON_CODE: {IX, VARCHAR(20), FK to DEAD_REASON, classification=DeadReason} <br>
     * 死亡理由コード
     * @return The value of the column 'DEAD_REASON_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getDeadReasonCode() {
        checkSpecifiedProperty("deadReasonCode");
        return convertEmptyToNull(_deadReasonCode);
    }

    /**
     * [set] DEAD_REASON_CODE: {IX, VARCHAR(20), FK to DEAD_REASON, classification=DeadReason} <br>
     * 死亡理由コード
     * @param deadReasonCode The value of the column 'DEAD_REASON_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    protected void setDeadReasonCode(String deadReasonCode) {
        checkClassificationCode("DEAD_REASON_CODE", CDef.DefMeta.DeadReason, deadReasonCode);
        registerModifiedProperty("deadReasonCode");
        _deadReasonCode = deadReasonCode;
    }

    /**
     * [get] DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to VILLAGE_DAY} <br>
     * 何日目に死亡したか
     * @return The value of the column 'DEAD_VILLAGE_DAY_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getDeadVillageDayId() {
        checkSpecifiedProperty("deadVillageDayId");
        return _deadVillageDayId;
    }

    /**
     * [set] DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to VILLAGE_DAY} <br>
     * 何日目に死亡したか
     * @param deadVillageDayId The value of the column 'DEAD_VILLAGE_DAY_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setDeadVillageDayId(Integer deadVillageDayId) {
        registerModifiedProperty("deadVillageDayId");
        _deadVillageDayId = deadVillageDayId;
    }

    /**
     * [get] IS_GONE: {NotNull, BIT} <br>
     * 退村済みか
     * @return The value of the column 'IS_GONE'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsGone() {
        checkSpecifiedProperty("isGone");
        return _isGone;
    }

    /**
     * [set] IS_GONE: {NotNull, BIT} <br>
     * 退村済みか
     * @param isGone The value of the column 'IS_GONE'. (basically NotNull if update: for the constraint)
     */
    public void setIsGone(Boolean isGone) {
        registerModifiedProperty("isGone");
        _isGone = isGone;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * 登録トレース
     * @return The value of the column 'REGISTER_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterTrace() {
        checkSpecifiedProperty("registerTrace");
        return convertEmptyToNull(_registerTrace);
    }

    /**
     * [set] REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * 登録トレース
     * @param registerTrace The value of the column 'REGISTER_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterTrace(String registerTrace) {
        registerModifiedProperty("registerTrace");
        _registerTrace = registerTrace;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * 更新トレース
     * @return The value of the column 'UPDATE_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateTrace() {
        checkSpecifiedProperty("updateTrace");
        return convertEmptyToNull(_updateTrace);
    }

    /**
     * [set] UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * 更新トレース
     * @param updateTrace The value of the column 'UPDATE_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateTrace(String updateTrace) {
        registerModifiedProperty("updateTrace");
        _updateTrace = updateTrace;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param skillCode The value of the column 'SKILL_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void mynativeMappingSkillCode(String skillCode) {
        setSkillCode(skillCode);
    }

    /**
     * For framework so basically DON'T use this method.
     * @param requestSkillCode The value of the column 'REQUEST_SKILL_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void mynativeMappingRequestSkillCode(String requestSkillCode) {
        setRequestSkillCode(requestSkillCode);
    }

    /**
     * For framework so basically DON'T use this method.
     * @param secondRequestSkillCode The value of the column 'SECOND_REQUEST_SKILL_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void mynativeMappingSecondRequestSkillCode(String secondRequestSkillCode) {
        setSecondRequestSkillCode(secondRequestSkillCode);
    }

    /**
     * For framework so basically DON'T use this method.
     * @param deadReasonCode The value of the column 'DEAD_REASON_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void mynativeMappingDeadReasonCode(String deadReasonCode) {
        setDeadReasonCode(deadReasonCode);
    }
}
