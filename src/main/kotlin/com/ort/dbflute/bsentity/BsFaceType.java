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
 * The entity of FACE_TYPE as TABLE. <br>
 * 表情種別
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsFaceType extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} */
    protected String _faceTypeCode;

    /** FACE_TYPE_NAME: {NotNull, VARCHAR(20)} */
    protected String _faceTypeName;

    /** DISP_ORDER: {NotNull, INT UNSIGNED(10)} */
    protected Integer _dispOrder;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "face_type";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_faceTypeCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of faceTypeCode as the classification of FaceType. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.FaceType getFaceTypeCodeAsFaceType() {
        return CDef.FaceType.of(getFaceTypeCode()).orElse(null);
    }

    /**
     * Set the value of faceTypeCode as the classification of FaceType. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setFaceTypeCodeAsFaceType(CDef.FaceType cdef) {
        setFaceTypeCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of faceTypeCode as 墓下 (GRAVE). <br>
     * 墓下
     */
    public void setFaceTypeCode_墓下() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.墓下);
    }

    /**
     * Set the value of faceTypeCode as 恋人 (LOVER). <br>
     * 恋人
     */
    public void setFaceTypeCode_恋人() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.恋人);
    }

    /**
     * Set the value of faceTypeCode as 共鳴 (MASON). <br>
     * 共鳴
     */
    public void setFaceTypeCode_共鳴() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.共鳴);
    }

    /**
     * Set the value of faceTypeCode as 独り言 (MONOLOGUE). <br>
     * 独り言
     */
    public void setFaceTypeCode_独り言() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.独り言);
    }

    /**
     * Set the value of faceTypeCode as 通常 (NORMAL). <br>
     * 通常
     */
    public void setFaceTypeCode_通常() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.通常);
    }

    /**
     * Set the value of faceTypeCode as 秘話 (SECRET). <br>
     * 秘話
     */
    public void setFaceTypeCode_秘話() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.秘話);
    }

    /**
     * Set the value of faceTypeCode as 囁き (WEREWOLF). <br>
     * 囁き
     */
    public void setFaceTypeCode_囁き() {
        setFaceTypeCodeAsFaceType(CDef.FaceType.囁き);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of faceTypeCode 墓下? <br>
     * 墓下
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode墓下() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.墓下) : false;
    }

    /**
     * Is the value of faceTypeCode 恋人? <br>
     * 恋人
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode恋人() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.恋人) : false;
    }

    /**
     * Is the value of faceTypeCode 共鳴? <br>
     * 共鳴
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode共鳴() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.共鳴) : false;
    }

    /**
     * Is the value of faceTypeCode 独り言? <br>
     * 独り言
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode独り言() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.独り言) : false;
    }

    /**
     * Is the value of faceTypeCode 通常? <br>
     * 通常
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode通常() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.通常) : false;
    }

    /**
     * Is the value of faceTypeCode 秘話? <br>
     * 秘話
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode秘話() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.秘話) : false;
    }

    /**
     * Is the value of faceTypeCode 囁き? <br>
     * 囁き
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isFaceTypeCode囁き() {
        CDef.FaceType cdef = getFaceTypeCodeAsFaceType();
        return cdef != null ? cdef.equals(CDef.FaceType.囁き) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** CHARA_IMAGE by FACE_TYPE_CODE, named 'charaImageList'. */
    protected List<CharaImage> _charaImageList;

    /**
     * [get] CHARA_IMAGE by FACE_TYPE_CODE, named 'charaImageList'.
     * @return The entity list of referrer property 'charaImageList'. (NotNull: even if no loading, returns empty list)
     */
    public List<CharaImage> getCharaImageList() {
        if (_charaImageList == null) { _charaImageList = newReferrerList(); }
        return _charaImageList;
    }

    /**
     * [set] CHARA_IMAGE by FACE_TYPE_CODE, named 'charaImageList'.
     * @param charaImageList The entity list of referrer property 'charaImageList'. (NullAllowed)
     */
    public void setCharaImageList(List<CharaImage> charaImageList) {
        _charaImageList = charaImageList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsFaceType) {
            BsFaceType other = (BsFaceType)obj;
            if (!xSV(_faceTypeCode, other._faceTypeCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _faceTypeCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_charaImageList != null) { for (CharaImage et : _charaImageList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "charaImageList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_faceTypeCode));
        sb.append(dm).append(xfND(_faceTypeName));
        sb.append(dm).append(xfND(_dispOrder));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_charaImageList != null && !_charaImageList.isEmpty())
        { sb.append(dm).append("charaImageList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public FaceType clone() {
        return (FaceType)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別コード
     * @return The value of the column 'FACE_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getFaceTypeCode() {
        checkSpecifiedProperty("faceTypeCode");
        return convertEmptyToNull(_faceTypeCode);
    }

    /**
     * [set] FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別コード
     * @param faceTypeCode The value of the column 'FACE_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setFaceTypeCode(String faceTypeCode) {
        checkClassificationCode("FACE_TYPE_CODE", CDef.DefMeta.FaceType, faceTypeCode);
        registerModifiedProperty("faceTypeCode");
        _faceTypeCode = faceTypeCode;
    }

    /**
     * [get] FACE_TYPE_NAME: {NotNull, VARCHAR(20)} <br>
     * 表情種別名
     * @return The value of the column 'FACE_TYPE_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getFaceTypeName() {
        checkSpecifiedProperty("faceTypeName");
        return convertEmptyToNull(_faceTypeName);
    }

    /**
     * [set] FACE_TYPE_NAME: {NotNull, VARCHAR(20)} <br>
     * 表情種別名
     * @param faceTypeName The value of the column 'FACE_TYPE_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setFaceTypeName(String faceTypeName) {
        registerModifiedProperty("faceTypeName");
        _faceTypeName = faceTypeName;
    }

    /**
     * [get] DISP_ORDER: {NotNull, INT UNSIGNED(10)} <br>
     * 並び順
     * @return The value of the column 'DISP_ORDER'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDispOrder() {
        checkSpecifiedProperty("dispOrder");
        return _dispOrder;
    }

    /**
     * [set] DISP_ORDER: {NotNull, INT UNSIGNED(10)} <br>
     * 並び順
     * @param dispOrder The value of the column 'DISP_ORDER'. (basically NotNull if update: for the constraint)
     */
    public void setDispOrder(Integer dispOrder) {
        registerModifiedProperty("dispOrder");
        _dispOrder = dispOrder;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param faceTypeCode The value of the column 'FACE_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingFaceTypeCode(String faceTypeCode) {
        setFaceTypeCode(faceTypeCode);
    }
}
