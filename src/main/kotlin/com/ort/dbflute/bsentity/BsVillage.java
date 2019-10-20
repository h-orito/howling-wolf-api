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
 * The entity of VILLAGE as TABLE. <br>
 * 村
 * <pre>
 * [primary-key]
 *     VILLAGE_ID
 *
 * [column]
 *     VILLAGE_ID, VILLAGE_DISPLAY_NAME, CREATE_PLAYER_NAME, VILLAGE_STATUS_CODE, EPILOGUE_DAY, WIN_CAMP_CODE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     VILLAGE_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     VILLAGE_STATUS, CAMP
 *
 * [referrer table]
 *     MESSAGE_RESTRICTION, VILLAGE_DAY, VILLAGE_PLAYER, VILLAGE_SETTING
 *
 * [foreign property]
 *     villageStatus, camp
 *
 * [referrer property]
 *     messageRestrictionList, villageDayList, villagePlayerList, villageSettingList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageId = entity.getVillageId();
 * String villageDisplayName = entity.getVillageDisplayName();
 * String createPlayerName = entity.getCreatePlayerName();
 * String villageStatusCode = entity.getVillageStatusCode();
 * Integer epilogueDay = entity.getEpilogueDay();
 * String winCampCode = entity.getWinCampCode();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageId(villageId);
 * entity.setVillageDisplayName(villageDisplayName);
 * entity.setCreatePlayerName(createPlayerName);
 * entity.setVillageStatusCode(villageStatusCode);
 * entity.setEpilogueDay(epilogueDay);
 * entity.setWinCampCode(winCampCode);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillage extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _villageId;

    /** VILLAGE_DISPLAY_NAME: {NotNull, VARCHAR(40)} */
    protected String _villageDisplayName;

    /** CREATE_PLAYER_NAME: {NotNull, VARCHAR(12)} */
    protected String _createPlayerName;

    /** VILLAGE_STATUS_CODE: {IX, NotNull, VARCHAR(20), FK to village_status, classification=VillageStatus} */
    protected String _villageStatusCode;

    /** EPILOGUE_DAY: {INT UNSIGNED(10)} */
    protected Integer _epilogueDay;

    /** WIN_CAMP_CODE: {IX, VARCHAR(20), FK to camp, classification=Camp} */
    protected String _winCampCode;

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
        return "village";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of villageStatusCode as the classification of VillageStatus. <br>
     * VILLAGE_STATUS_CODE: {IX, NotNull, VARCHAR(20), FK to village_status, classification=VillageStatus} <br>
     * 村ステータス
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.VillageStatus getVillageStatusCodeAsVillageStatus() {
        return CDef.VillageStatus.codeOf(getVillageStatusCode());
    }

    /**
     * Set the value of villageStatusCode as the classification of VillageStatus. <br>
     * VILLAGE_STATUS_CODE: {IX, NotNull, VARCHAR(20), FK to village_status, classification=VillageStatus} <br>
     * 村ステータス
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setVillageStatusCodeAsVillageStatus(CDef.VillageStatus cdef) {
        setVillageStatusCode(cdef != null ? cdef.code() : null);
    }

    /**
     * Get the value of winCampCode as the classification of Camp. <br>
     * WIN_CAMP_CODE: {IX, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Camp getWinCampCodeAsCamp() {
        return CDef.Camp.codeOf(getWinCampCode());
    }

    /**
     * Set the value of winCampCode as the classification of Camp. <br>
     * WIN_CAMP_CODE: {IX, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 陣営
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setWinCampCodeAsCamp(CDef.Camp cdef) {
        setWinCampCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of villageStatusCode as 廃村 (CANCEL). <br>
     * 廃村
     */
    public void setVillageStatusCode_廃村() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.廃村);
    }

    /**
     * Set the value of villageStatusCode as 終了 (COMPLETED). <br>
     * 終了
     */
    public void setVillageStatusCode_終了() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.終了);
    }

    /**
     * Set the value of villageStatusCode as エピローグ (EPILOGUE). <br>
     * エピローグ
     */
    public void setVillageStatusCode_エピローグ() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.エピローグ);
    }

    /**
     * Set the value of villageStatusCode as 募集中 (IN_PREPARATION). <br>
     * 募集中
     */
    public void setVillageStatusCode_募集中() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.募集中);
    }

    /**
     * Set the value of villageStatusCode as 進行中 (IN_PROGRESS). <br>
     * 進行中
     */
    public void setVillageStatusCode_進行中() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.進行中);
    }

    /**
     * Set the value of villageStatusCode as 開始待ち (WAITING). <br>
     * 開始待ち
     */
    public void setVillageStatusCode_開始待ち() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.開始待ち);
    }

    /**
     * Set the value of winCampCode as 狐陣営 (FOX). <br>
     * 狐陣営
     */
    public void setWinCampCode_狐陣営() {
        setWinCampCodeAsCamp(CDef.Camp.狐陣営);
    }

    /**
     * Set the value of winCampCode as 村人陣営 (VILLAGER). <br>
     * 村人陣営
     */
    public void setWinCampCode_村人陣営() {
        setWinCampCodeAsCamp(CDef.Camp.村人陣営);
    }

    /**
     * Set the value of winCampCode as 人狼陣営 (WEREWOLF). <br>
     * 人狼陣営
     */
    public void setWinCampCode_人狼陣営() {
        setWinCampCodeAsCamp(CDef.Camp.人狼陣営);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of villageStatusCode 廃村? <br>
     * 廃村
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode廃村() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.廃村) : false;
    }

    /**
     * Is the value of villageStatusCode 終了? <br>
     * 終了
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode終了() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.終了) : false;
    }

    /**
     * Is the value of villageStatusCode エピローグ? <br>
     * エピローグ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCodeエピローグ() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.エピローグ) : false;
    }

    /**
     * Is the value of villageStatusCode 募集中? <br>
     * 募集中
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode募集中() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.募集中) : false;
    }

    /**
     * Is the value of villageStatusCode 進行中? <br>
     * 進行中
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode進行中() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.進行中) : false;
    }

    /**
     * Is the value of villageStatusCode 開始待ち? <br>
     * 開始待ち
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode開始待ち() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.開始待ち) : false;
    }

    /**
     * 決着がついた村 <br>
     * The group elements:[エピローグ, 廃村, 終了]
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode_FinishedVillage() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null && cdef.isFinishedVillage();
    }

    /**
     * Is the value of winCampCode 狐陣営? <br>
     * 狐陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isWinCampCode狐陣営() {
        CDef.Camp cdef = getWinCampCodeAsCamp();
        return cdef != null ? cdef.equals(CDef.Camp.狐陣営) : false;
    }

    /**
     * Is the value of winCampCode 村人陣営? <br>
     * 村人陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isWinCampCode村人陣営() {
        CDef.Camp cdef = getWinCampCodeAsCamp();
        return cdef != null ? cdef.equals(CDef.Camp.村人陣営) : false;
    }

    /**
     * Is the value of winCampCode 人狼陣営? <br>
     * 人狼陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isWinCampCode人狼陣営() {
        CDef.Camp cdef = getWinCampCodeAsCamp();
        return cdef != null ? cdef.equals(CDef.Camp.人狼陣営) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** VILLAGE_STATUS by my VILLAGE_STATUS_CODE, named 'villageStatus'. */
    protected OptionalEntity<VillageStatus> _villageStatus;

    /**
     * [get] VILLAGE_STATUS by my VILLAGE_STATUS_CODE, named 'villageStatus'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villageStatus'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillageStatus> getVillageStatus() {
        if (_villageStatus == null) { _villageStatus = OptionalEntity.relationEmpty(this, "villageStatus"); }
        return _villageStatus;
    }

    /**
     * [set] VILLAGE_STATUS by my VILLAGE_STATUS_CODE, named 'villageStatus'.
     * @param villageStatus The entity of foreign property 'villageStatus'. (NullAllowed)
     */
    public void setVillageStatus(OptionalEntity<VillageStatus> villageStatus) {
        _villageStatus = villageStatus;
    }

    /** CAMP by my WIN_CAMP_CODE, named 'camp'. */
    protected OptionalEntity<Camp> _camp;

    /**
     * [get] CAMP by my WIN_CAMP_CODE, named 'camp'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'camp'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Camp> getCamp() {
        if (_camp == null) { _camp = OptionalEntity.relationEmpty(this, "camp"); }
        return _camp;
    }

    /**
     * [set] CAMP by my WIN_CAMP_CODE, named 'camp'.
     * @param camp The entity of foreign property 'camp'. (NullAllowed)
     */
    public void setCamp(OptionalEntity<Camp> camp) {
        _camp = camp;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** MESSAGE_RESTRICTION by VILLAGE_ID, named 'messageRestrictionList'. */
    protected List<MessageRestriction> _messageRestrictionList;

    /**
     * [get] MESSAGE_RESTRICTION by VILLAGE_ID, named 'messageRestrictionList'.
     * @return The entity list of referrer property 'messageRestrictionList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MessageRestriction> getMessageRestrictionList() {
        if (_messageRestrictionList == null) { _messageRestrictionList = newReferrerList(); }
        return _messageRestrictionList;
    }

    /**
     * [set] MESSAGE_RESTRICTION by VILLAGE_ID, named 'messageRestrictionList'.
     * @param messageRestrictionList The entity list of referrer property 'messageRestrictionList'. (NullAllowed)
     */
    public void setMessageRestrictionList(List<MessageRestriction> messageRestrictionList) {
        _messageRestrictionList = messageRestrictionList;
    }

    /** VILLAGE_DAY by VILLAGE_ID, named 'villageDayList'. */
    protected List<VillageDay> _villageDayList;

    /**
     * [get] VILLAGE_DAY by VILLAGE_ID, named 'villageDayList'.
     * @return The entity list of referrer property 'villageDayList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillageDay> getVillageDayList() {
        if (_villageDayList == null) { _villageDayList = newReferrerList(); }
        return _villageDayList;
    }

    /**
     * [set] VILLAGE_DAY by VILLAGE_ID, named 'villageDayList'.
     * @param villageDayList The entity list of referrer property 'villageDayList'. (NullAllowed)
     */
    public void setVillageDayList(List<VillageDay> villageDayList) {
        _villageDayList = villageDayList;
    }

    /** VILLAGE_PLAYER by VILLAGE_ID, named 'villagePlayerList'. */
    protected List<VillagePlayer> _villagePlayerList;

    /**
     * [get] VILLAGE_PLAYER by VILLAGE_ID, named 'villagePlayerList'.
     * @return The entity list of referrer property 'villagePlayerList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillagePlayer> getVillagePlayerList() {
        if (_villagePlayerList == null) { _villagePlayerList = newReferrerList(); }
        return _villagePlayerList;
    }

    /**
     * [set] VILLAGE_PLAYER by VILLAGE_ID, named 'villagePlayerList'.
     * @param villagePlayerList The entity list of referrer property 'villagePlayerList'. (NullAllowed)
     */
    public void setVillagePlayerList(List<VillagePlayer> villagePlayerList) {
        _villagePlayerList = villagePlayerList;
    }

    /** VILLAGE_SETTING by VILLAGE_ID, named 'villageSettingList'. */
    protected List<VillageSetting> _villageSettingList;

    /**
     * [get] VILLAGE_SETTING by VILLAGE_ID, named 'villageSettingList'.
     * @return The entity list of referrer property 'villageSettingList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillageSetting> getVillageSettingList() {
        if (_villageSettingList == null) { _villageSettingList = newReferrerList(); }
        return _villageSettingList;
    }

    /**
     * [set] VILLAGE_SETTING by VILLAGE_ID, named 'villageSettingList'.
     * @param villageSettingList The entity list of referrer property 'villageSettingList'. (NullAllowed)
     */
    public void setVillageSettingList(List<VillageSetting> villageSettingList) {
        _villageSettingList = villageSettingList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVillage) {
            BsVillage other = (BsVillage)obj;
            if (!xSV(_villageId, other._villageId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_villageStatus != null && _villageStatus.isPresent())
        { sb.append(li).append(xbRDS(_villageStatus, "villageStatus")); }
        if (_camp != null && _camp.isPresent())
        { sb.append(li).append(xbRDS(_camp, "camp")); }
        if (_messageRestrictionList != null) { for (MessageRestriction et : _messageRestrictionList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "messageRestrictionList")); } } }
        if (_villageDayList != null) { for (VillageDay et : _villageDayList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageDayList")); } } }
        if (_villagePlayerList != null) { for (VillagePlayer et : _villagePlayerList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villagePlayerList")); } } }
        if (_villageSettingList != null) { for (VillageSetting et : _villageSettingList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageSettingList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_villageDisplayName));
        sb.append(dm).append(xfND(_createPlayerName));
        sb.append(dm).append(xfND(_villageStatusCode));
        sb.append(dm).append(xfND(_epilogueDay));
        sb.append(dm).append(xfND(_winCampCode));
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
        if (_villageStatus != null && _villageStatus.isPresent())
        { sb.append(dm).append("villageStatus"); }
        if (_camp != null && _camp.isPresent())
        { sb.append(dm).append("camp"); }
        if (_messageRestrictionList != null && !_messageRestrictionList.isEmpty())
        { sb.append(dm).append("messageRestrictionList"); }
        if (_villageDayList != null && !_villageDayList.isEmpty())
        { sb.append(dm).append("villageDayList"); }
        if (_villagePlayerList != null && !_villagePlayerList.isEmpty())
        { sb.append(dm).append("villagePlayerList"); }
        if (_villageSettingList != null && !_villageSettingList.isEmpty())
        { sb.append(dm).append("villageSettingList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Village clone() {
        return (Village)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * 村ID
     * @return The value of the column 'VILLAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageId() {
        checkSpecifiedProperty("villageId");
        return _villageId;
    }

    /**
     * [set] VILLAGE_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * 村ID
     * @param villageId The value of the column 'VILLAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageId(Integer villageId) {
        registerModifiedProperty("villageId");
        _villageId = villageId;
    }

    /**
     * [get] VILLAGE_DISPLAY_NAME: {NotNull, VARCHAR(40)} <br>
     * 村表示名
     * @return The value of the column 'VILLAGE_DISPLAY_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageDisplayName() {
        checkSpecifiedProperty("villageDisplayName");
        return convertEmptyToNull(_villageDisplayName);
    }

    /**
     * [set] VILLAGE_DISPLAY_NAME: {NotNull, VARCHAR(40)} <br>
     * 村表示名
     * @param villageDisplayName The value of the column 'VILLAGE_DISPLAY_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setVillageDisplayName(String villageDisplayName) {
        registerModifiedProperty("villageDisplayName");
        _villageDisplayName = villageDisplayName;
    }

    /**
     * [get] CREATE_PLAYER_NAME: {NotNull, VARCHAR(12)} <br>
     * 村作成プレイヤー名
     * @return The value of the column 'CREATE_PLAYER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getCreatePlayerName() {
        checkSpecifiedProperty("createPlayerName");
        return convertEmptyToNull(_createPlayerName);
    }

    /**
     * [set] CREATE_PLAYER_NAME: {NotNull, VARCHAR(12)} <br>
     * 村作成プレイヤー名
     * @param createPlayerName The value of the column 'CREATE_PLAYER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setCreatePlayerName(String createPlayerName) {
        registerModifiedProperty("createPlayerName");
        _createPlayerName = createPlayerName;
    }

    /**
     * [get] VILLAGE_STATUS_CODE: {IX, NotNull, VARCHAR(20), FK to village_status, classification=VillageStatus} <br>
     * 村ステータスコード
     * @return The value of the column 'VILLAGE_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageStatusCode() {
        checkSpecifiedProperty("villageStatusCode");
        return convertEmptyToNull(_villageStatusCode);
    }

    /**
     * [set] VILLAGE_STATUS_CODE: {IX, NotNull, VARCHAR(20), FK to village_status, classification=VillageStatus} <br>
     * 村ステータスコード
     * @param villageStatusCode The value of the column 'VILLAGE_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setVillageStatusCode(String villageStatusCode) {
        checkClassificationCode("VILLAGE_STATUS_CODE", CDef.DefMeta.VillageStatus, villageStatusCode);
        registerModifiedProperty("villageStatusCode");
        _villageStatusCode = villageStatusCode;
    }

    /**
     * [get] EPILOGUE_DAY: {INT UNSIGNED(10)} <br>
     * エピローグ日
     * @return The value of the column 'EPILOGUE_DAY'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getEpilogueDay() {
        checkSpecifiedProperty("epilogueDay");
        return _epilogueDay;
    }

    /**
     * [set] EPILOGUE_DAY: {INT UNSIGNED(10)} <br>
     * エピローグ日
     * @param epilogueDay The value of the column 'EPILOGUE_DAY'. (NullAllowed: null update allowed for no constraint)
     */
    public void setEpilogueDay(Integer epilogueDay) {
        registerModifiedProperty("epilogueDay");
        _epilogueDay = epilogueDay;
    }

    /**
     * [get] WIN_CAMP_CODE: {IX, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 勝利陣営コード
     * @return The value of the column 'WIN_CAMP_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getWinCampCode() {
        checkSpecifiedProperty("winCampCode");
        return convertEmptyToNull(_winCampCode);
    }

    /**
     * [set] WIN_CAMP_CODE: {IX, VARCHAR(20), FK to camp, classification=Camp} <br>
     * 勝利陣営コード
     * @param winCampCode The value of the column 'WIN_CAMP_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    protected void setWinCampCode(String winCampCode) {
        checkClassificationCode("WIN_CAMP_CODE", CDef.DefMeta.Camp, winCampCode);
        registerModifiedProperty("winCampCode");
        _winCampCode = winCampCode;
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
     * @param villageStatusCode The value of the column 'VILLAGE_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingVillageStatusCode(String villageStatusCode) {
        setVillageStatusCode(villageStatusCode);
    }

    /**
     * For framework so basically DON'T use this method.
     * @param winCampCode The value of the column 'WIN_CAMP_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void mynativeMappingWinCampCode(String winCampCode) {
        setWinCampCode(winCampCode);
    }
}
