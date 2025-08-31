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
 * The entity of PLAYER as TABLE. <br>
 * プレイヤー
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPlayer extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _playerId;

    /** UID: {UQ, NotNull, VARCHAR(100)} */
    protected String _uid;

    /** NICKNAME: {NotNull, VARCHAR(50)} */
    protected String _nickname;

    /** AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority} */
    protected String _authorityCode;

    /** IS_RESTRICTED_PARTICIPATION: {NotNull, BIT} */
    protected Boolean _isRestrictedParticipation;

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
        return "player";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_playerId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param uid : UQ, NotNull, VARCHAR(100). (NotNull)
     */
    public void uniqueBy(String uid) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("uid");
        setUid(uid);
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of authorityCode as the classification of Authority. <br>
     * AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority} <br>
     * 権限
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Authority getAuthorityCodeAsAuthority() {
        return CDef.Authority.of(getAuthorityCode()).orElse(null);
    }

    /**
     * Set the value of authorityCode as the classification of Authority. <br>
     * AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority} <br>
     * 権限
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setAuthorityCodeAsAuthority(CDef.Authority cdef) {
        setAuthorityCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of authorityCode as 管理者 (ROLE_ADMIN). <br>
     * 管理者
     */
    public void setAuthorityCode_管理者() {
        setAuthorityCodeAsAuthority(CDef.Authority.管理者);
    }

    /**
     * Set the value of authorityCode as プレイヤー (ROLE_PLAYER). <br>
     * プレイヤー
     */
    public void setAuthorityCode_プレイヤー() {
        setAuthorityCodeAsAuthority(CDef.Authority.プレイヤー);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of authorityCode 管理者? <br>
     * 管理者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAuthorityCode管理者() {
        CDef.Authority cdef = getAuthorityCodeAsAuthority();
        return cdef != null ? cdef.equals(CDef.Authority.管理者) : false;
    }

    /**
     * Is the value of authorityCode プレイヤー? <br>
     * プレイヤー
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAuthorityCodeプレイヤー() {
        CDef.Authority cdef = getAuthorityCodeAsAuthority();
        return cdef != null ? cdef.equals(CDef.Authority.プレイヤー) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** AUTHORITY by my AUTHORITY_CODE, named 'authority'. */
    protected OptionalEntity<Authority> _authority;

    /**
     * [get] AUTHORITY by my AUTHORITY_CODE, named 'authority'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'authority'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Authority> getAuthority() {
        if (_authority == null) { _authority = OptionalEntity.relationEmpty(this, "authority"); }
        return _authority;
    }

    /**
     * [set] AUTHORITY by my AUTHORITY_CODE, named 'authority'.
     * @param authority The entity of foreign property 'authority'. (NullAllowed)
     */
    public void setAuthority(OptionalEntity<Authority> authority) {
        _authority = authority;
    }

    /** player_detail by PLAYER_ID, named 'playerDetailAsOne'. */
    protected OptionalEntity<PlayerDetail> _playerDetailAsOne;

    /**
     * [get] player_detail by PLAYER_ID, named 'playerDetailAsOne'.
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return the entity of foreign property(referrer-as-one) 'playerDetailAsOne'. (NotNull, EmptyAllowed: when e.g. no data, no setupSelect)
     */
    public OptionalEntity<PlayerDetail> getPlayerDetailAsOne() {
        if (_playerDetailAsOne == null) { _playerDetailAsOne = OptionalEntity.relationEmpty(this, "playerDetailAsOne"); }
        return _playerDetailAsOne;
    }

    /**
     * [set] player_detail by PLAYER_ID, named 'playerDetailAsOne'.
     * @param playerDetailAsOne The entity of foreign property(referrer-as-one) 'playerDetailAsOne'. (NullAllowed)
     */
    public void setPlayerDetailAsOne(OptionalEntity<PlayerDetail> playerDetailAsOne) {
        _playerDetailAsOne = playerDetailAsOne;
    }

    /** twitter_user by player_id, named 'twitterUserAsOne'. */
    protected OptionalEntity<TwitterUser> _twitterUserAsOne;

    /**
     * [get] twitter_user by player_id, named 'twitterUserAsOne'.
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return the entity of foreign property(referrer-as-one) 'twitterUserAsOne'. (NotNull, EmptyAllowed: when e.g. no data, no setupSelect)
     */
    public OptionalEntity<TwitterUser> getTwitterUserAsOne() {
        if (_twitterUserAsOne == null) { _twitterUserAsOne = OptionalEntity.relationEmpty(this, "twitterUserAsOne"); }
        return _twitterUserAsOne;
    }

    /**
     * [set] twitter_user by player_id, named 'twitterUserAsOne'.
     * @param twitterUserAsOne The entity of foreign property(referrer-as-one) 'twitterUserAsOne'. (NullAllowed)
     */
    public void setTwitterUserAsOne(OptionalEntity<TwitterUser> twitterUserAsOne) {
        _twitterUserAsOne = twitterUserAsOne;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** BLACKLIST_PLAYER by FROM_PLAYER_ID, named 'blacklistPlayerByFromPlayerIdList'. */
    protected List<BlacklistPlayer> _blacklistPlayerByFromPlayerIdList;

    /**
     * [get] BLACKLIST_PLAYER by FROM_PLAYER_ID, named 'blacklistPlayerByFromPlayerIdList'.
     * @return The entity list of referrer property 'blacklistPlayerByFromPlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<BlacklistPlayer> getBlacklistPlayerByFromPlayerIdList() {
        if (_blacklistPlayerByFromPlayerIdList == null) { _blacklistPlayerByFromPlayerIdList = newReferrerList(); }
        return _blacklistPlayerByFromPlayerIdList;
    }

    /**
     * [set] BLACKLIST_PLAYER by FROM_PLAYER_ID, named 'blacklistPlayerByFromPlayerIdList'.
     * @param blacklistPlayerByFromPlayerIdList The entity list of referrer property 'blacklistPlayerByFromPlayerIdList'. (NullAllowed)
     */
    public void setBlacklistPlayerByFromPlayerIdList(List<BlacklistPlayer> blacklistPlayerByFromPlayerIdList) {
        _blacklistPlayerByFromPlayerIdList = blacklistPlayerByFromPlayerIdList;
    }

    /** BLACKLIST_PLAYER by TO_PLAYER_ID, named 'blacklistPlayerByToPlayerIdList'. */
    protected List<BlacklistPlayer> _blacklistPlayerByToPlayerIdList;

    /**
     * [get] BLACKLIST_PLAYER by TO_PLAYER_ID, named 'blacklistPlayerByToPlayerIdList'.
     * @return The entity list of referrer property 'blacklistPlayerByToPlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<BlacklistPlayer> getBlacklistPlayerByToPlayerIdList() {
        if (_blacklistPlayerByToPlayerIdList == null) { _blacklistPlayerByToPlayerIdList = newReferrerList(); }
        return _blacklistPlayerByToPlayerIdList;
    }

    /**
     * [set] BLACKLIST_PLAYER by TO_PLAYER_ID, named 'blacklistPlayerByToPlayerIdList'.
     * @param blacklistPlayerByToPlayerIdList The entity list of referrer property 'blacklistPlayerByToPlayerIdList'. (NullAllowed)
     */
    public void setBlacklistPlayerByToPlayerIdList(List<BlacklistPlayer> blacklistPlayerByToPlayerIdList) {
        _blacklistPlayerByToPlayerIdList = blacklistPlayerByToPlayerIdList;
    }

    /** PLAYER_INTRODUCE by FROM_PLAYER_ID, named 'playerIntroduceByFromPlayerIdList'. */
    protected List<PlayerIntroduce> _playerIntroduceByFromPlayerIdList;

    /**
     * [get] PLAYER_INTRODUCE by FROM_PLAYER_ID, named 'playerIntroduceByFromPlayerIdList'.
     * @return The entity list of referrer property 'playerIntroduceByFromPlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<PlayerIntroduce> getPlayerIntroduceByFromPlayerIdList() {
        if (_playerIntroduceByFromPlayerIdList == null) { _playerIntroduceByFromPlayerIdList = newReferrerList(); }
        return _playerIntroduceByFromPlayerIdList;
    }

    /**
     * [set] PLAYER_INTRODUCE by FROM_PLAYER_ID, named 'playerIntroduceByFromPlayerIdList'.
     * @param playerIntroduceByFromPlayerIdList The entity list of referrer property 'playerIntroduceByFromPlayerIdList'. (NullAllowed)
     */
    public void setPlayerIntroduceByFromPlayerIdList(List<PlayerIntroduce> playerIntroduceByFromPlayerIdList) {
        _playerIntroduceByFromPlayerIdList = playerIntroduceByFromPlayerIdList;
    }

    /** PLAYER_INTRODUCE by TO_PLAYER_ID, named 'playerIntroduceByToPlayerIdList'. */
    protected List<PlayerIntroduce> _playerIntroduceByToPlayerIdList;

    /**
     * [get] PLAYER_INTRODUCE by TO_PLAYER_ID, named 'playerIntroduceByToPlayerIdList'.
     * @return The entity list of referrer property 'playerIntroduceByToPlayerIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<PlayerIntroduce> getPlayerIntroduceByToPlayerIdList() {
        if (_playerIntroduceByToPlayerIdList == null) { _playerIntroduceByToPlayerIdList = newReferrerList(); }
        return _playerIntroduceByToPlayerIdList;
    }

    /**
     * [set] PLAYER_INTRODUCE by TO_PLAYER_ID, named 'playerIntroduceByToPlayerIdList'.
     * @param playerIntroduceByToPlayerIdList The entity list of referrer property 'playerIntroduceByToPlayerIdList'. (NullAllowed)
     */
    public void setPlayerIntroduceByToPlayerIdList(List<PlayerIntroduce> playerIntroduceByToPlayerIdList) {
        _playerIntroduceByToPlayerIdList = playerIntroduceByToPlayerIdList;
    }

    /** VILLAGE by CREATE_PLAYER_ID, named 'villageList'. */
    protected List<Village> _villageList;

    /**
     * [get] VILLAGE by CREATE_PLAYER_ID, named 'villageList'.
     * @return The entity list of referrer property 'villageList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Village> getVillageList() {
        if (_villageList == null) { _villageList = newReferrerList(); }
        return _villageList;
    }

    /**
     * [set] VILLAGE by CREATE_PLAYER_ID, named 'villageList'.
     * @param villageList The entity list of referrer property 'villageList'. (NullAllowed)
     */
    public void setVillageList(List<Village> villageList) {
        _villageList = villageList;
    }

    /** VILLAGE_PLAYER by PLAYER_ID, named 'villagePlayerList'. */
    protected List<VillagePlayer> _villagePlayerList;

    /**
     * [get] VILLAGE_PLAYER by PLAYER_ID, named 'villagePlayerList'.
     * @return The entity list of referrer property 'villagePlayerList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillagePlayer> getVillagePlayerList() {
        if (_villagePlayerList == null) { _villagePlayerList = newReferrerList(); }
        return _villagePlayerList;
    }

    /**
     * [set] VILLAGE_PLAYER by PLAYER_ID, named 'villagePlayerList'.
     * @param villagePlayerList The entity list of referrer property 'villagePlayerList'. (NullAllowed)
     */
    public void setVillagePlayerList(List<VillagePlayer> villagePlayerList) {
        _villagePlayerList = villagePlayerList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsPlayer) {
            BsPlayer other = (BsPlayer)obj;
            if (!xSV(_playerId, other._playerId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _playerId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_authority != null && _authority.isPresent())
        { sb.append(li).append(xbRDS(_authority, "authority")); }
        if (_playerDetailAsOne != null && _playerDetailAsOne.isPresent())
        { sb.append(li).append(xbRDS(_playerDetailAsOne, "playerDetailAsOne")); }
        if (_twitterUserAsOne != null && _twitterUserAsOne.isPresent())
        { sb.append(li).append(xbRDS(_twitterUserAsOne, "twitterUserAsOne")); }
        if (_blacklistPlayerByFromPlayerIdList != null) { for (BlacklistPlayer et : _blacklistPlayerByFromPlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "blacklistPlayerByFromPlayerIdList")); } } }
        if (_blacklistPlayerByToPlayerIdList != null) { for (BlacklistPlayer et : _blacklistPlayerByToPlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "blacklistPlayerByToPlayerIdList")); } } }
        if (_playerIntroduceByFromPlayerIdList != null) { for (PlayerIntroduce et : _playerIntroduceByFromPlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "playerIntroduceByFromPlayerIdList")); } } }
        if (_playerIntroduceByToPlayerIdList != null) { for (PlayerIntroduce et : _playerIntroduceByToPlayerIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "playerIntroduceByToPlayerIdList")); } } }
        if (_villageList != null) { for (Village et : _villageList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageList")); } } }
        if (_villagePlayerList != null) { for (VillagePlayer et : _villagePlayerList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villagePlayerList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_playerId));
        sb.append(dm).append(xfND(_uid));
        sb.append(dm).append(xfND(_nickname));
        sb.append(dm).append(xfND(_authorityCode));
        sb.append(dm).append(xfND(_isRestrictedParticipation));
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
        if (_authority != null && _authority.isPresent())
        { sb.append(dm).append("authority"); }
        if (_playerDetailAsOne != null && _playerDetailAsOne.isPresent())
        { sb.append(dm).append("playerDetailAsOne"); }
        if (_twitterUserAsOne != null && _twitterUserAsOne.isPresent())
        { sb.append(dm).append("twitterUserAsOne"); }
        if (_blacklistPlayerByFromPlayerIdList != null && !_blacklistPlayerByFromPlayerIdList.isEmpty())
        { sb.append(dm).append("blacklistPlayerByFromPlayerIdList"); }
        if (_blacklistPlayerByToPlayerIdList != null && !_blacklistPlayerByToPlayerIdList.isEmpty())
        { sb.append(dm).append("blacklistPlayerByToPlayerIdList"); }
        if (_playerIntroduceByFromPlayerIdList != null && !_playerIntroduceByFromPlayerIdList.isEmpty())
        { sb.append(dm).append("playerIntroduceByFromPlayerIdList"); }
        if (_playerIntroduceByToPlayerIdList != null && !_playerIntroduceByToPlayerIdList.isEmpty())
        { sb.append(dm).append("playerIntroduceByToPlayerIdList"); }
        if (_villageList != null && !_villageList.isEmpty())
        { sb.append(dm).append("villageList"); }
        if (_villagePlayerList != null && !_villagePlayerList.isEmpty())
        { sb.append(dm).append("villagePlayerList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Player clone() {
        return (Player)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * プレイヤーID
     * @return The value of the column 'PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getPlayerId() {
        checkSpecifiedProperty("playerId");
        return _playerId;
    }

    /**
     * [set] PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * プレイヤーID
     * @param playerId The value of the column 'PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPlayerId(Integer playerId) {
        registerModifiedProperty("playerId");
        _playerId = playerId;
    }

    /**
     * [get] UID: {UQ, NotNull, VARCHAR(100)} <br>
     * ユーザID
     * @return The value of the column 'UID'. (basically NotNull if selected: for the constraint)
     */
    public String getUid() {
        checkSpecifiedProperty("uid");
        return convertEmptyToNull(_uid);
    }

    /**
     * [set] UID: {UQ, NotNull, VARCHAR(100)} <br>
     * ユーザID
     * @param uid The value of the column 'UID'. (basically NotNull if update: for the constraint)
     */
    public void setUid(String uid) {
        registerModifiedProperty("uid");
        _uid = uid;
    }

    /**
     * [get] NICKNAME: {NotNull, VARCHAR(50)} <br>
     * ニックネーム
     * @return The value of the column 'NICKNAME'. (basically NotNull if selected: for the constraint)
     */
    public String getNickname() {
        checkSpecifiedProperty("nickname");
        return convertEmptyToNull(_nickname);
    }

    /**
     * [set] NICKNAME: {NotNull, VARCHAR(50)} <br>
     * ニックネーム
     * @param nickname The value of the column 'NICKNAME'. (basically NotNull if update: for the constraint)
     */
    public void setNickname(String nickname) {
        registerModifiedProperty("nickname");
        _nickname = nickname;
    }

    /**
     * [get] AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority} <br>
     * 権限コード
     * @return The value of the column 'AUTHORITY_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getAuthorityCode() {
        checkSpecifiedProperty("authorityCode");
        return convertEmptyToNull(_authorityCode);
    }

    /**
     * [set] AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority} <br>
     * 権限コード
     * @param authorityCode The value of the column 'AUTHORITY_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setAuthorityCode(String authorityCode) {
        checkClassificationCode("AUTHORITY_CODE", CDef.DefMeta.Authority, authorityCode);
        registerModifiedProperty("authorityCode");
        _authorityCode = authorityCode;
    }

    /**
     * [get] IS_RESTRICTED_PARTICIPATION: {NotNull, BIT} <br>
     * 入村制限されているか
     * @return The value of the column 'IS_RESTRICTED_PARTICIPATION'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsRestrictedParticipation() {
        checkSpecifiedProperty("isRestrictedParticipation");
        return _isRestrictedParticipation;
    }

    /**
     * [set] IS_RESTRICTED_PARTICIPATION: {NotNull, BIT} <br>
     * 入村制限されているか
     * @param isRestrictedParticipation The value of the column 'IS_RESTRICTED_PARTICIPATION'. (basically NotNull if update: for the constraint)
     */
    public void setIsRestrictedParticipation(Boolean isRestrictedParticipation) {
        registerModifiedProperty("isRestrictedParticipation");
        _isRestrictedParticipation = isRestrictedParticipation;
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
     * @param authorityCode The value of the column 'AUTHORITY_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingAuthorityCode(String authorityCode) {
        setAuthorityCode(authorityCode);
    }
}
