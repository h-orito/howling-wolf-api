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
 * The entity of VILLAGE_SETTING as TABLE. <br>
 * 村設定
 * <pre>
 * [primary-key]
 *     VILLAGE_ID, VILLAGE_SETTING_ITEM_CODE
 *
 * [column]
 *     VILLAGE_ID, VILLAGE_SETTING_ITEM_CODE, VILLAGE_SETTING_TEXT, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     VILLAGE, VILLAGE_SETTING_ITEM
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     village, villageSettingItem
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageId = entity.getVillageId();
 * String villageSettingItemCode = entity.getVillageSettingItemCode();
 * String villageSettingText = entity.getVillageSettingText();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageId(villageId);
 * entity.setVillageSettingItemCode(villageSettingItemCode);
 * entity.setVillageSettingText(villageSettingText);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillageSetting extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE} */
    protected Integer _villageId;

    /** VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} */
    protected String _villageSettingItemCode;

    /** VILLAGE_SETTING_TEXT: {VARCHAR(1000)} */
    protected String _villageSettingText;

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
        return "VILLAGE_SETTING";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageId == null) { return false; }
        if (_villageSettingItemCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of villageSettingItemCode as the classification of VillageSettingItem. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.VillageSettingItem getVillageSettingItemCodeAsVillageSettingItem() {
        return CDef.VillageSettingItem.codeOf(getVillageSettingItemCode());
    }

    /**
     * Set the value of villageSettingItemCode as the classification of VillageSettingItem. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem cdef) {
        setVillageSettingItemCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of villageSettingItemCode as キャラクターグループid (character_group_id). <br>
     * キャラクターグループID
     */
    public void setVillageSettingItemCode_キャラクターグループid() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.キャラクターグループid);
    }

    /**
     * Set the value of villageSettingItemCode as 更新間隔秒 (day_change_interval_seconds). <br>
     * 更新間隔秒
     */
    public void setVillageSettingItemCode_更新間隔秒() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.更新間隔秒);
    }

    /**
     * Set the value of villageSettingItemCode as ダミーキャラid (dummy_chara_id). <br>
     * ダミーキャラID
     */
    public void setVillageSettingItemCode_ダミーキャラid() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.ダミーキャラid);
    }

    /**
     * Set the value of villageSettingItemCode as 自動生成村か (is_auto_generated). <br>
     * 自動生成村か
     */
    public void setVillageSettingItemCode_自動生成村か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.自動生成村か);
    }

    /**
     * Set the value of villageSettingItemCode as コミット可能か (is_available_commit). <br>
     * コミット可能か
     */
    public void setVillageSettingItemCode_コミット可能か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.コミット可能か);
    }

    /**
     * Set the value of villageSettingItemCode as 役職希望可能か (is_available_skill_request). <br>
     * 役職希望可能か
     */
    public void setVillageSettingItemCode_役職希望可能か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.役職希望可能か);
    }

    /**
     * Set the value of villageSettingItemCode as 見学可能か (is_available_spectate). <br>
     * 見学可能か
     */
    public void setVillageSettingItemCode_見学可能か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.見学可能か);
    }

    /**
     * Set the value of villageSettingItemCode as 突然死ありか (is_available_suddenly_death). <br>
     * 突然死ありか
     */
    public void setVillageSettingItemCode_突然死ありか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.突然死ありか);
    }

    /**
     * Set the value of villageSettingItemCode as 墓下役職公開ありか (is_open_skill_in_grave). <br>
     * 墓下役職公開ありか
     */
    public void setVillageSettingItemCode_墓下役職公開ありか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.墓下役職公開ありか);
    }

    /**
     * Set the value of villageSettingItemCode as 記名投票か (is_open_vote). <br>
     * 記名投票か
     */
    public void setVillageSettingItemCode_記名投票か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.記名投票か);
    }

    /**
     * Set the value of villageSettingItemCode as 墓下見学発言を生存者が見られるか (is_visible_grave_message). <br>
     * 墓下見学発言を生存者が見られるか
     */
    public void setVillageSettingItemCode_墓下見学発言を生存者が見られるか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.墓下見学発言を生存者が見られるか);
    }

    /**
     * Set the value of villageSettingItemCode as 入村パスワード (join_password). <br>
     * 入村パスワード
     */
    public void setVillageSettingItemCode_入村パスワード() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.入村パスワード);
    }

    /**
     * Set the value of villageSettingItemCode as 構成 (organize). <br>
     * 構成
     */
    public void setVillageSettingItemCode_構成() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.構成);
    }

    /**
     * Set the value of villageSettingItemCode as 最大人数 (person_max). <br>
     * 最大人数
     */
    public void setVillageSettingItemCode_最大人数() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.最大人数);
    }

    /**
     * Set the value of villageSettingItemCode as 最低人数 (person_min). <br>
     * 最低人数
     */
    public void setVillageSettingItemCode_最低人数() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.最低人数);
    }

    /**
     * Set the value of villageSettingItemCode as 沈黙時間 (silent_hours). <br>
     * 沈黙時間
     */
    public void setVillageSettingItemCode_沈黙時間() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.沈黙時間);
    }

    /**
     * Set the value of villageSettingItemCode as 開始予定日時 (start_datetime). <br>
     * 開始予定日時
     */
    public void setVillageSettingItemCode_開始予定日時() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.開始予定日時);
    }

    /**
     * Set the value of villageSettingItemCode as 期間形式 (term_type). <br>
     * 期間形式
     */
    public void setVillageSettingItemCode_期間形式() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.期間形式);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of villageSettingItemCode キャラクターグループid? <br>
     * キャラクターグループID
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCodeキャラクターグループid() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.キャラクターグループid) : false;
    }

    /**
     * Is the value of villageSettingItemCode 更新間隔秒? <br>
     * 更新間隔秒
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode更新間隔秒() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.更新間隔秒) : false;
    }

    /**
     * Is the value of villageSettingItemCode ダミーキャラid? <br>
     * ダミーキャラID
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCodeダミーキャラid() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.ダミーキャラid) : false;
    }

    /**
     * Is the value of villageSettingItemCode 自動生成村か? <br>
     * 自動生成村か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode自動生成村か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.自動生成村か) : false;
    }

    /**
     * Is the value of villageSettingItemCode コミット可能か? <br>
     * コミット可能か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCodeコミット可能か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.コミット可能か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 役職希望可能か? <br>
     * 役職希望可能か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode役職希望可能か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.役職希望可能か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 見学可能か? <br>
     * 見学可能か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode見学可能か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.見学可能か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 突然死ありか? <br>
     * 突然死ありか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode突然死ありか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.突然死ありか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 墓下役職公開ありか? <br>
     * 墓下役職公開ありか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode墓下役職公開ありか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.墓下役職公開ありか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 記名投票か? <br>
     * 記名投票か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode記名投票か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.記名投票か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 墓下見学発言を生存者が見られるか? <br>
     * 墓下見学発言を生存者が見られるか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode墓下見学発言を生存者が見られるか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.墓下見学発言を生存者が見られるか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 入村パスワード? <br>
     * 入村パスワード
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode入村パスワード() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.入村パスワード) : false;
    }

    /**
     * Is the value of villageSettingItemCode 構成? <br>
     * 構成
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode構成() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.構成) : false;
    }

    /**
     * Is the value of villageSettingItemCode 最大人数? <br>
     * 最大人数
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode最大人数() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.最大人数) : false;
    }

    /**
     * Is the value of villageSettingItemCode 最低人数? <br>
     * 最低人数
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode最低人数() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.最低人数) : false;
    }

    /**
     * Is the value of villageSettingItemCode 沈黙時間? <br>
     * 沈黙時間
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode沈黙時間() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.沈黙時間) : false;
    }

    /**
     * Is the value of villageSettingItemCode 開始予定日時? <br>
     * 開始予定日時
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode開始予定日時() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.開始予定日時) : false;
    }

    /**
     * Is the value of villageSettingItemCode 期間形式? <br>
     * 期間形式
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode期間形式() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.期間形式) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
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

    /** VILLAGE_SETTING_ITEM by my VILLAGE_SETTING_ITEM_CODE, named 'villageSettingItem'. */
    protected OptionalEntity<VillageSettingItem> _villageSettingItem;

    /**
     * [get] VILLAGE_SETTING_ITEM by my VILLAGE_SETTING_ITEM_CODE, named 'villageSettingItem'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villageSettingItem'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillageSettingItem> getVillageSettingItem() {
        if (_villageSettingItem == null) { _villageSettingItem = OptionalEntity.relationEmpty(this, "villageSettingItem"); }
        return _villageSettingItem;
    }

    /**
     * [set] VILLAGE_SETTING_ITEM by my VILLAGE_SETTING_ITEM_CODE, named 'villageSettingItem'.
     * @param villageSettingItem The entity of foreign property 'villageSettingItem'. (NullAllowed)
     */
    public void setVillageSettingItem(OptionalEntity<VillageSettingItem> villageSettingItem) {
        _villageSettingItem = villageSettingItem;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVillageSetting) {
            BsVillageSetting other = (BsVillageSetting)obj;
            if (!xSV(_villageId, other._villageId)) { return false; }
            if (!xSV(_villageSettingItemCode, other._villageSettingItemCode)) { return false; }
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
        hs = xCH(hs, _villageSettingItemCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_village != null && _village.isPresent())
        { sb.append(li).append(xbRDS(_village, "village")); }
        if (_villageSettingItem != null && _villageSettingItem.isPresent())
        { sb.append(li).append(xbRDS(_villageSettingItem, "villageSettingItem")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_villageSettingItemCode));
        sb.append(dm).append(xfND(_villageSettingText));
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
        if (_village != null && _village.isPresent())
        { sb.append(dm).append("village"); }
        if (_villageSettingItem != null && _villageSettingItem.isPresent())
        { sb.append(dm).append("villageSettingItem"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VillageSetting clone() {
        return (VillageSetting)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE} <br>
     * 村ID
     * @return The value of the column 'VILLAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageId() {
        checkSpecifiedProperty("villageId");
        return _villageId;
    }

    /**
     * [set] VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE} <br>
     * 村ID
     * @param villageId The value of the column 'VILLAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageId(Integer villageId) {
        registerModifiedProperty("villageId");
        _villageId = villageId;
    }

    /**
     * [get] VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目コード
     * @return The value of the column 'VILLAGE_SETTING_ITEM_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageSettingItemCode() {
        checkSpecifiedProperty("villageSettingItemCode");
        return convertEmptyToNull(_villageSettingItemCode);
    }

    /**
     * [set] VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目コード
     * @param villageSettingItemCode The value of the column 'VILLAGE_SETTING_ITEM_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setVillageSettingItemCode(String villageSettingItemCode) {
        checkClassificationCode("VILLAGE_SETTING_ITEM_CODE", CDef.DefMeta.VillageSettingItem, villageSettingItemCode);
        registerModifiedProperty("villageSettingItemCode");
        _villageSettingItemCode = villageSettingItemCode;
    }

    /**
     * [get] VILLAGE_SETTING_TEXT: {VARCHAR(1000)} <br>
     * 村設定項目内容
     * @return The value of the column 'VILLAGE_SETTING_TEXT'. (NullAllowed even if selected: for no constraint)
     */
    public String getVillageSettingText() {
        checkSpecifiedProperty("villageSettingText");
        return convertEmptyToNull(_villageSettingText);
    }

    /**
     * [set] VILLAGE_SETTING_TEXT: {VARCHAR(1000)} <br>
     * 村設定項目内容
     * @param villageSettingText The value of the column 'VILLAGE_SETTING_TEXT'. (NullAllowed: null update allowed for no constraint)
     */
    public void setVillageSettingText(String villageSettingText) {
        registerModifiedProperty("villageSettingText");
        _villageSettingText = villageSettingText;
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
     * @param villageSettingItemCode The value of the column 'VILLAGE_SETTING_ITEM_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingVillageSettingItemCode(String villageSettingItemCode) {
        setVillageSettingItemCode(villageSettingItemCode);
    }
}
