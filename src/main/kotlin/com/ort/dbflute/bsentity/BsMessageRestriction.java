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
 * The entity of MESSAGE_RESTRICTION as TABLE. <br>
 * 発言制限 : レコードなしの場合は無制限
 * <pre>
 * [primary-key]
 *     VILLAGE_ID, MESSAGE_TYPE_CODE
 *
 * [column]
 *     VILLAGE_ID, MESSAGE_TYPE_CODE, MESSAGE_MAX_NUM, MESSAGE_MAX_LENGTH, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     MESSAGE_TYPE, VILLAGE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     messageType, village
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageId = entity.getVillageId();
 * String messageTypeCode = entity.getMessageTypeCode();
 * Integer messageMaxNum = entity.getMessageMaxNum();
 * Integer messageMaxLength = entity.getMessageMaxLength();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageId(villageId);
 * entity.setMessageTypeCode(messageTypeCode);
 * entity.setMessageMaxNum(messageMaxNum);
 * entity.setMessageMaxLength(messageMaxLength);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMessageRestriction extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

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

    /** MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to MESSAGE_TYPE, classification=MessageType} */
    protected String _messageTypeCode;

    /** MESSAGE_MAX_NUM: {NotNull, INT UNSIGNED(10)} */
    protected Integer _messageMaxNum;

    /** MESSAGE_MAX_LENGTH: {NotNull, INT UNSIGNED(10)} */
    protected Integer _messageMaxLength;

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
        return "MESSAGE_RESTRICTION";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageId == null) { return false; }
        if (_messageTypeCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of messageTypeCode as the classification of MessageType. <br>
     * MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to MESSAGE_TYPE, classification=MessageType} <br>
     * メッセージ種別
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.MessageType getMessageTypeCodeAsMessageType() {
        return CDef.MessageType.codeOf(getMessageTypeCode());
    }

    /**
     * Set the value of messageTypeCode as the classification of MessageType. <br>
     * MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to MESSAGE_TYPE, classification=MessageType} <br>
     * メッセージ種別
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setMessageTypeCodeAsMessageType(CDef.MessageType cdef) {
        setMessageTypeCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of messageTypeCode as 村建て発言 (CREATOR_SAY). <br>
     * 村建て発言
     */
    public void setMessageTypeCode_村建て発言() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.村建て発言);
    }

    /**
     * Set the value of messageTypeCode as 死者の呻き (GRAVE_SAY). <br>
     * 死者の呻き
     */
    public void setMessageTypeCode_死者の呻き() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.死者の呻き);
    }

    /**
     * Set the value of messageTypeCode as 共鳴発言 (MASON_SAY). <br>
     * 共鳴発言
     */
    public void setMessageTypeCode_共鳴発言() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.共鳴発言);
    }

    /**
     * Set the value of messageTypeCode as 独り言 (MONOLOGUE_SAY). <br>
     * 独り言
     */
    public void setMessageTypeCode_独り言() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.独り言);
    }

    /**
     * Set the value of messageTypeCode as 通常発言 (NORMAL_SAY). <br>
     * 通常発言
     */
    public void setMessageTypeCode_通常発言() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.通常発言);
    }

    /**
     * Set the value of messageTypeCode as 参加者一覧 (PARTICIPANTS). <br>
     * 参加者一覧
     */
    public void setMessageTypeCode_参加者一覧() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.参加者一覧);
    }

    /**
     * Set the value of messageTypeCode as 共有相互確認メッセージ (PRIVATE_MASON). <br>
     * 共有相互確認メッセージ
     */
    public void setMessageTypeCode_共有相互確認メッセージ() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.共有相互確認メッセージ);
    }

    /**
     * Set the value of messageTypeCode as 白黒霊視結果 (PRIVATE_PSYCHIC). <br>
     * 白黒霊視結果
     */
    public void setMessageTypeCode_白黒霊視結果() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.白黒霊視結果);
    }

    /**
     * Set the value of messageTypeCode as 白黒占い結果 (PRIVATE_SEER). <br>
     * 白黒占い結果
     */
    public void setMessageTypeCode_白黒占い結果() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.白黒占い結果);
    }

    /**
     * Set the value of messageTypeCode as 非公開システムメッセージ (PRIVATE_SYSTEM). <br>
     * 非公開システムメッセージ
     */
    public void setMessageTypeCode_非公開システムメッセージ() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.非公開システムメッセージ);
    }

    /**
     * Set the value of messageTypeCode as 襲撃結果 (PRIVATE_WEREWOLF). <br>
     * 襲撃結果
     */
    public void setMessageTypeCode_襲撃結果() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.襲撃結果);
    }

    /**
     * Set the value of messageTypeCode as 公開システムメッセージ (PUBLIC_SYSTEM). <br>
     * 公開システムメッセージ
     */
    public void setMessageTypeCode_公開システムメッセージ() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.公開システムメッセージ);
    }

    /**
     * Set the value of messageTypeCode as 秘話 (SECRET_SAY). <br>
     * 秘話
     */
    public void setMessageTypeCode_秘話() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.秘話);
    }

    /**
     * Set the value of messageTypeCode as 見学発言 (SPECTATE_SAY). <br>
     * 見学発言
     */
    public void setMessageTypeCode_見学発言() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.見学発言);
    }

    /**
     * Set the value of messageTypeCode as 人狼の囁き (WEREWOLF_SAY). <br>
     * 人狼の囁き
     */
    public void setMessageTypeCode_人狼の囁き() {
        setMessageTypeCodeAsMessageType(CDef.MessageType.人狼の囁き);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of messageTypeCode 村建て発言? <br>
     * 村建て発言
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode村建て発言() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.村建て発言) : false;
    }

    /**
     * Is the value of messageTypeCode 死者の呻き? <br>
     * 死者の呻き
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode死者の呻き() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.死者の呻き) : false;
    }

    /**
     * Is the value of messageTypeCode 共鳴発言? <br>
     * 共鳴発言
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode共鳴発言() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.共鳴発言) : false;
    }

    /**
     * Is the value of messageTypeCode 独り言? <br>
     * 独り言
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode独り言() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.独り言) : false;
    }

    /**
     * Is the value of messageTypeCode 通常発言? <br>
     * 通常発言
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode通常発言() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.通常発言) : false;
    }

    /**
     * Is the value of messageTypeCode 参加者一覧? <br>
     * 参加者一覧
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode参加者一覧() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.参加者一覧) : false;
    }

    /**
     * Is the value of messageTypeCode 共有相互確認メッセージ? <br>
     * 共有相互確認メッセージ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode共有相互確認メッセージ() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.共有相互確認メッセージ) : false;
    }

    /**
     * Is the value of messageTypeCode 白黒霊視結果? <br>
     * 白黒霊視結果
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode白黒霊視結果() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.白黒霊視結果) : false;
    }

    /**
     * Is the value of messageTypeCode 白黒占い結果? <br>
     * 白黒占い結果
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode白黒占い結果() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.白黒占い結果) : false;
    }

    /**
     * Is the value of messageTypeCode 非公開システムメッセージ? <br>
     * 非公開システムメッセージ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode非公開システムメッセージ() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.非公開システムメッセージ) : false;
    }

    /**
     * Is the value of messageTypeCode 襲撃結果? <br>
     * 襲撃結果
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode襲撃結果() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.襲撃結果) : false;
    }

    /**
     * Is the value of messageTypeCode 公開システムメッセージ? <br>
     * 公開システムメッセージ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode公開システムメッセージ() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.公開システムメッセージ) : false;
    }

    /**
     * Is the value of messageTypeCode 秘話? <br>
     * 秘話
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode秘話() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.秘話) : false;
    }

    /**
     * Is the value of messageTypeCode 見学発言? <br>
     * 見学発言
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode見学発言() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.見学発言) : false;
    }

    /**
     * Is the value of messageTypeCode 人狼の囁き? <br>
     * 人狼の囁き
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMessageTypeCode人狼の囁き() {
        CDef.MessageType cdef = getMessageTypeCodeAsMessageType();
        return cdef != null ? cdef.equals(CDef.MessageType.人狼の囁き) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** MESSAGE_TYPE by my MESSAGE_TYPE_CODE, named 'messageType'. */
    protected OptionalEntity<MessageType> _messageType;

    /**
     * [get] MESSAGE_TYPE by my MESSAGE_TYPE_CODE, named 'messageType'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'messageType'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<MessageType> getMessageType() {
        if (_messageType == null) { _messageType = OptionalEntity.relationEmpty(this, "messageType"); }
        return _messageType;
    }

    /**
     * [set] MESSAGE_TYPE by my MESSAGE_TYPE_CODE, named 'messageType'.
     * @param messageType The entity of foreign property 'messageType'. (NullAllowed)
     */
    public void setMessageType(OptionalEntity<MessageType> messageType) {
        _messageType = messageType;
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
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsMessageRestriction) {
            BsMessageRestriction other = (BsMessageRestriction)obj;
            if (!xSV(_villageId, other._villageId)) { return false; }
            if (!xSV(_messageTypeCode, other._messageTypeCode)) { return false; }
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
        hs = xCH(hs, _messageTypeCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_messageType != null && _messageType.isPresent())
        { sb.append(li).append(xbRDS(_messageType, "messageType")); }
        if (_village != null && _village.isPresent())
        { sb.append(li).append(xbRDS(_village, "village")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_messageTypeCode));
        sb.append(dm).append(xfND(_messageMaxNum));
        sb.append(dm).append(xfND(_messageMaxLength));
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
        if (_messageType != null && _messageType.isPresent())
        { sb.append(dm).append("messageType"); }
        if (_village != null && _village.isPresent())
        { sb.append(dm).append("village"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public MessageRestriction clone() {
        return (MessageRestriction)super.clone();
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
     * [get] MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to MESSAGE_TYPE, classification=MessageType} <br>
     * メッセージ種別コード
     * @return The value of the column 'MESSAGE_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getMessageTypeCode() {
        checkSpecifiedProperty("messageTypeCode");
        return convertEmptyToNull(_messageTypeCode);
    }

    /**
     * [set] MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to MESSAGE_TYPE, classification=MessageType} <br>
     * メッセージ種別コード
     * @param messageTypeCode The value of the column 'MESSAGE_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setMessageTypeCode(String messageTypeCode) {
        checkClassificationCode("MESSAGE_TYPE_CODE", CDef.DefMeta.MessageType, messageTypeCode);
        registerModifiedProperty("messageTypeCode");
        _messageTypeCode = messageTypeCode;
    }

    /**
     * [get] MESSAGE_MAX_NUM: {NotNull, INT UNSIGNED(10)} <br>
     * 最大発言回数
     * @return The value of the column 'MESSAGE_MAX_NUM'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMessageMaxNum() {
        checkSpecifiedProperty("messageMaxNum");
        return _messageMaxNum;
    }

    /**
     * [set] MESSAGE_MAX_NUM: {NotNull, INT UNSIGNED(10)} <br>
     * 最大発言回数
     * @param messageMaxNum The value of the column 'MESSAGE_MAX_NUM'. (basically NotNull if update: for the constraint)
     */
    public void setMessageMaxNum(Integer messageMaxNum) {
        registerModifiedProperty("messageMaxNum");
        _messageMaxNum = messageMaxNum;
    }

    /**
     * [get] MESSAGE_MAX_LENGTH: {NotNull, INT UNSIGNED(10)} <br>
     * 最大文字数
     * @return The value of the column 'MESSAGE_MAX_LENGTH'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMessageMaxLength() {
        checkSpecifiedProperty("messageMaxLength");
        return _messageMaxLength;
    }

    /**
     * [set] MESSAGE_MAX_LENGTH: {NotNull, INT UNSIGNED(10)} <br>
     * 最大文字数
     * @param messageMaxLength The value of the column 'MESSAGE_MAX_LENGTH'. (basically NotNull if update: for the constraint)
     */
    public void setMessageMaxLength(Integer messageMaxLength) {
        registerModifiedProperty("messageMaxLength");
        _messageMaxLength = messageMaxLength;
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
     * @param messageTypeCode The value of the column 'MESSAGE_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingMessageTypeCode(String messageTypeCode) {
        setMessageTypeCode(messageTypeCode);
    }
}
