package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.ort.dbflute.allcommon.EntityDefinedCommonColumn;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of AUTOGENERATE_ORGANIZE as TABLE. <br>
 * 自動生成編成
 * <pre>
 * [primary-key]
 *     VILLAGE_ID_MOD
 *
 * [column]
 *     VILLAGE_ID_MOD, ORGANIZATION, IS_AVAILABLE_DUMMY_SKILL, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageIdMod = entity.getVillageIdMod();
 * String organization = entity.getOrganization();
 * Boolean isAvailableDummySkill = entity.getIsAvailableDummySkill();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageIdMod(villageIdMod);
 * entity.setOrganization(organization);
 * entity.setIsAvailableDummySkill(isAvailableDummySkill);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAutogenerateOrganize extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_ID_MOD: {PK, NotNull, INT(10)} */
    protected Integer _villageIdMod;

    /** ORGANIZATION: {NotNull, VARCHAR(255)} */
    protected String _organization;

    /** IS_AVAILABLE_DUMMY_SKILL: {NotNull, BIT} */
    protected Boolean _isAvailableDummySkill;

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
        return "AUTOGENERATE_ORGANIZE";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageIdMod == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
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
        if (obj instanceof BsAutogenerateOrganize) {
            BsAutogenerateOrganize other = (BsAutogenerateOrganize)obj;
            if (!xSV(_villageIdMod, other._villageIdMod)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageIdMod);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageIdMod));
        sb.append(dm).append(xfND(_organization));
        sb.append(dm).append(xfND(_isAvailableDummySkill));
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
        return "";
    }

    @Override
    public AutogenerateOrganize clone() {
        return (AutogenerateOrganize)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_ID_MOD: {PK, NotNull, INT(10)} <br>
     * 余り
     * @return The value of the column 'VILLAGE_ID_MOD'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageIdMod() {
        checkSpecifiedProperty("villageIdMod");
        return _villageIdMod;
    }

    /**
     * [set] VILLAGE_ID_MOD: {PK, NotNull, INT(10)} <br>
     * 余り
     * @param villageIdMod The value of the column 'VILLAGE_ID_MOD'. (basically NotNull if update: for the constraint)
     */
    public void setVillageIdMod(Integer villageIdMod) {
        registerModifiedProperty("villageIdMod");
        _villageIdMod = villageIdMod;
    }

    /**
     * [get] ORGANIZATION: {NotNull, VARCHAR(255)} <br>
     * 編成
     * @return The value of the column 'ORGANIZATION'. (basically NotNull if selected: for the constraint)
     */
    public String getOrganization() {
        checkSpecifiedProperty("organization");
        return convertEmptyToNull(_organization);
    }

    /**
     * [set] ORGANIZATION: {NotNull, VARCHAR(255)} <br>
     * 編成
     * @param organization The value of the column 'ORGANIZATION'. (basically NotNull if update: for the constraint)
     */
    public void setOrganization(String organization) {
        registerModifiedProperty("organization");
        _organization = organization;
    }

    /**
     * [get] IS_AVAILABLE_DUMMY_SKILL: {NotNull, BIT} <br>
     * 役欠けありか
     * @return The value of the column 'IS_AVAILABLE_DUMMY_SKILL'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsAvailableDummySkill() {
        checkSpecifiedProperty("isAvailableDummySkill");
        return _isAvailableDummySkill;
    }

    /**
     * [set] IS_AVAILABLE_DUMMY_SKILL: {NotNull, BIT} <br>
     * 役欠けありか
     * @param isAvailableDummySkill The value of the column 'IS_AVAILABLE_DUMMY_SKILL'. (basically NotNull if update: for the constraint)
     */
    public void setIsAvailableDummySkill(Boolean isAvailableDummySkill) {
        registerModifiedProperty("isAvailableDummySkill");
        _isAvailableDummySkill = isAvailableDummySkill;
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
