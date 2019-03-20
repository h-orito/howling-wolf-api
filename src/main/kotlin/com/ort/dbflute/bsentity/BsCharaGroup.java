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
import com.ort.dbflute.exentity.*;

/**
 * The entity of CHARA_GROUP as TABLE. <br>
 * キャラクターグループ
 * <pre>
 * [primary-key]
 *     CHARA_GROUP_ID
 *
 * [column]
 *     CHARA_GROUP_ID, CHARA_GROUP_NAME, DESIGNER_ID, DESCRIPTION_URL, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     CHARA_GROUP_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     DESIGNER
 *
 * [referrer table]
 *     CHARA, VILLAGE_SETTINGS
 *
 * [foreign property]
 *     designer
 *
 * [referrer property]
 *     charaList, villageSettingsList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer charaGroupId = entity.getCharaGroupId();
 * String charaGroupName = entity.getCharaGroupName();
 * Integer designerId = entity.getDesignerId();
 * String descriptionUrl = entity.getDescriptionUrl();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setCharaGroupId(charaGroupId);
 * entity.setCharaGroupName(charaGroupName);
 * entity.setDesignerId(designerId);
 * entity.setDescriptionUrl(descriptionUrl);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCharaGroup extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _charaGroupId;

    /** CHARA_GROUP_NAME: {NotNull, VARCHAR(40)} */
    protected String _charaGroupName;

    /** DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer} */
    protected Integer _designerId;

    /** DESCRIPTION_URL: {TEXT(65535)} */
    protected String _descriptionUrl;

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
        return "chara_group";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_charaGroupId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** DESIGNER by my DESIGNER_ID, named 'designer'. */
    protected OptionalEntity<Designer> _designer;

    /**
     * [get] DESIGNER by my DESIGNER_ID, named 'designer'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'designer'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Designer> getDesigner() {
        if (_designer == null) { _designer = OptionalEntity.relationEmpty(this, "designer"); }
        return _designer;
    }

    /**
     * [set] DESIGNER by my DESIGNER_ID, named 'designer'.
     * @param designer The entity of foreign property 'designer'. (NullAllowed)
     */
    public void setDesigner(OptionalEntity<Designer> designer) {
        _designer = designer;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** CHARA by CHARA_GROUP_ID, named 'charaList'. */
    protected List<Chara> _charaList;

    /**
     * [get] CHARA by CHARA_GROUP_ID, named 'charaList'.
     * @return The entity list of referrer property 'charaList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Chara> getCharaList() {
        if (_charaList == null) { _charaList = newReferrerList(); }
        return _charaList;
    }

    /**
     * [set] CHARA by CHARA_GROUP_ID, named 'charaList'.
     * @param charaList The entity list of referrer property 'charaList'. (NullAllowed)
     */
    public void setCharaList(List<Chara> charaList) {
        _charaList = charaList;
    }

    /** VILLAGE_SETTINGS by CHARACTER_GROUP_ID, named 'villageSettingsList'. */
    protected List<VillageSettings> _villageSettingsList;

    /**
     * [get] VILLAGE_SETTINGS by CHARACTER_GROUP_ID, named 'villageSettingsList'.
     * @return The entity list of referrer property 'villageSettingsList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillageSettings> getVillageSettingsList() {
        if (_villageSettingsList == null) { _villageSettingsList = newReferrerList(); }
        return _villageSettingsList;
    }

    /**
     * [set] VILLAGE_SETTINGS by CHARACTER_GROUP_ID, named 'villageSettingsList'.
     * @param villageSettingsList The entity list of referrer property 'villageSettingsList'. (NullAllowed)
     */
    public void setVillageSettingsList(List<VillageSettings> villageSettingsList) {
        _villageSettingsList = villageSettingsList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsCharaGroup) {
            BsCharaGroup other = (BsCharaGroup)obj;
            if (!xSV(_charaGroupId, other._charaGroupId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _charaGroupId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_designer != null && _designer.isPresent())
        { sb.append(li).append(xbRDS(_designer, "designer")); }
        if (_charaList != null) { for (Chara et : _charaList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "charaList")); } } }
        if (_villageSettingsList != null) { for (VillageSettings et : _villageSettingsList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageSettingsList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_charaGroupId));
        sb.append(dm).append(xfND(_charaGroupName));
        sb.append(dm).append(xfND(_designerId));
        sb.append(dm).append(xfND(_descriptionUrl));
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
        if (_designer != null && _designer.isPresent())
        { sb.append(dm).append("designer"); }
        if (_charaList != null && !_charaList.isEmpty())
        { sb.append(dm).append("charaList"); }
        if (_villageSettingsList != null && !_villageSettingsList.isEmpty())
        { sb.append(dm).append("villageSettingsList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public CharaGroup clone() {
        return (CharaGroup)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * キャラクターグループID
     * @return The value of the column 'CHARA_GROUP_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCharaGroupId() {
        checkSpecifiedProperty("charaGroupId");
        return _charaGroupId;
    }

    /**
     * [set] CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * キャラクターグループID
     * @param charaGroupId The value of the column 'CHARA_GROUP_ID'. (basically NotNull if update: for the constraint)
     */
    public void setCharaGroupId(Integer charaGroupId) {
        registerModifiedProperty("charaGroupId");
        _charaGroupId = charaGroupId;
    }

    /**
     * [get] CHARA_GROUP_NAME: {NotNull, VARCHAR(40)} <br>
     * キャラクターグループ名
     * @return The value of the column 'CHARA_GROUP_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getCharaGroupName() {
        checkSpecifiedProperty("charaGroupName");
        return convertEmptyToNull(_charaGroupName);
    }

    /**
     * [set] CHARA_GROUP_NAME: {NotNull, VARCHAR(40)} <br>
     * キャラクターグループ名
     * @param charaGroupName The value of the column 'CHARA_GROUP_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setCharaGroupName(String charaGroupName) {
        registerModifiedProperty("charaGroupName");
        _charaGroupName = charaGroupName;
    }

    /**
     * [get] DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer} <br>
     * デザイナーID
     * @return The value of the column 'DESIGNER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDesignerId() {
        checkSpecifiedProperty("designerId");
        return _designerId;
    }

    /**
     * [set] DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer} <br>
     * デザイナーID
     * @param designerId The value of the column 'DESIGNER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setDesignerId(Integer designerId) {
        registerModifiedProperty("designerId");
        _designerId = designerId;
    }

    /**
     * [get] DESCRIPTION_URL: {TEXT(65535)} <br>
     * キャラチップURL : キャラチップの利用規約や配布サイトのURL
     * @return The value of the column 'DESCRIPTION_URL'. (NullAllowed even if selected: for no constraint)
     */
    public String getDescriptionUrl() {
        checkSpecifiedProperty("descriptionUrl");
        return convertEmptyToNull(_descriptionUrl);
    }

    /**
     * [set] DESCRIPTION_URL: {TEXT(65535)} <br>
     * キャラチップURL : キャラチップの利用規約や配布サイトのURL
     * @param descriptionUrl The value of the column 'DESCRIPTION_URL'. (NullAllowed: null update allowed for no constraint)
     */
    public void setDescriptionUrl(String descriptionUrl) {
        registerModifiedProperty("descriptionUrl");
        _descriptionUrl = descriptionUrl;
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
}
