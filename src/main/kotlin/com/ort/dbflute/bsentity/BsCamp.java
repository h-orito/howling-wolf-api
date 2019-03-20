package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.allcommon.CDef;
import com.ort.dbflute.exentity.*;

/**
 * The entity of CAMP as TABLE. <br>
 * 陣営
 * <pre>
 * [primary-key]
 *     CAMP_CODE
 *
 * [column]
 *     CAMP_CODE, CAMP_NAME
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
 *     SKILL, VILLAGE
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     skillList, villageList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String campCode = entity.getCampCode();
 * String campName = entity.getCampName();
 * entity.setCampCode(campCode);
 * entity.setCampName(campName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCamp extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} */
    protected String _campCode;

    /** CAMP_NAME: {NotNull, VARCHAR(20)} */
    protected String _campName;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "camp";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_campCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of campCode as the classification of Camp. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Camp getCampCodeAsCamp() {
        return CDef.Camp.codeOf(getCampCode());
    }

    /**
     * Set the value of campCode as the classification of Camp. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setCampCodeAsCamp(CDef.Camp cdef) {
        setCampCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of campCode as 狐陣営 (FOX). <br>
     * 狐陣営
     */
    public void setCampCode_狐陣営() {
        setCampCodeAsCamp(CDef.Camp.狐陣営);
    }

    /**
     * Set the value of campCode as 村人陣営 (VILLAGER). <br>
     * 村人陣営
     */
    public void setCampCode_村人陣営() {
        setCampCodeAsCamp(CDef.Camp.村人陣営);
    }

    /**
     * Set the value of campCode as 人狼陣営 (WEREWOLF). <br>
     * 人狼陣営
     */
    public void setCampCode_人狼陣営() {
        setCampCodeAsCamp(CDef.Camp.人狼陣営);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of campCode 狐陣営? <br>
     * 狐陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isCampCode狐陣営() {
        CDef.Camp cdef = getCampCodeAsCamp();
        return cdef != null ? cdef.equals(CDef.Camp.狐陣営) : false;
    }

    /**
     * Is the value of campCode 村人陣営? <br>
     * 村人陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isCampCode村人陣営() {
        CDef.Camp cdef = getCampCodeAsCamp();
        return cdef != null ? cdef.equals(CDef.Camp.村人陣営) : false;
    }

    /**
     * Is the value of campCode 人狼陣営? <br>
     * 人狼陣営
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isCampCode人狼陣営() {
        CDef.Camp cdef = getCampCodeAsCamp();
        return cdef != null ? cdef.equals(CDef.Camp.人狼陣営) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** SKILL by CAMP_CODE, named 'skillList'. */
    protected List<Skill> _skillList;

    /**
     * [get] SKILL by CAMP_CODE, named 'skillList'.
     * @return The entity list of referrer property 'skillList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Skill> getSkillList() {
        if (_skillList == null) { _skillList = newReferrerList(); }
        return _skillList;
    }

    /**
     * [set] SKILL by CAMP_CODE, named 'skillList'.
     * @param skillList The entity list of referrer property 'skillList'. (NullAllowed)
     */
    public void setSkillList(List<Skill> skillList) {
        _skillList = skillList;
    }

    /** VILLAGE by WIN_CAMP_CODE, named 'villageList'. */
    protected List<Village> _villageList;

    /**
     * [get] VILLAGE by WIN_CAMP_CODE, named 'villageList'.
     * @return The entity list of referrer property 'villageList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Village> getVillageList() {
        if (_villageList == null) { _villageList = newReferrerList(); }
        return _villageList;
    }

    /**
     * [set] VILLAGE by WIN_CAMP_CODE, named 'villageList'.
     * @param villageList The entity list of referrer property 'villageList'. (NullAllowed)
     */
    public void setVillageList(List<Village> villageList) {
        _villageList = villageList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsCamp) {
            BsCamp other = (BsCamp)obj;
            if (!xSV(_campCode, other._campCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _campCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_skillList != null) { for (Skill et : _skillList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "skillList")); } } }
        if (_villageList != null) { for (Village et : _villageList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_campCode));
        sb.append(dm).append(xfND(_campName));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_skillList != null && !_skillList.isEmpty())
        { sb.append(dm).append("skillList"); }
        if (_villageList != null && !_villageList.isEmpty())
        { sb.append(dm).append("villageList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Camp clone() {
        return (Camp)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営コード
     * @return The value of the column 'CAMP_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getCampCode() {
        checkSpecifiedProperty("campCode");
        return convertEmptyToNull(_campCode);
    }

    /**
     * [set] CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営コード
     * @param campCode The value of the column 'CAMP_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setCampCode(String campCode) {
        checkClassificationCode("CAMP_CODE", CDef.DefMeta.Camp, campCode);
        registerModifiedProperty("campCode");
        _campCode = campCode;
    }

    /**
     * [get] CAMP_NAME: {NotNull, VARCHAR(20)} <br>
     * 陣営名
     * @return The value of the column 'CAMP_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getCampName() {
        checkSpecifiedProperty("campName");
        return convertEmptyToNull(_campName);
    }

    /**
     * [set] CAMP_NAME: {NotNull, VARCHAR(20)} <br>
     * 陣営名
     * @param campName The value of the column 'CAMP_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setCampName(String campName) {
        registerModifiedProperty("campName");
        _campName = campName;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param campCode The value of the column 'CAMP_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingCampCode(String campCode) {
        setCampCode(campCode);
    }
}
