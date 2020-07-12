package com.ort.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.exentity.*;

/**
 * The DB meta of ability. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class AbilityDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final AbilityDbm _instance = new AbilityDbm();
    private AbilityDbm() {}
    public static AbilityDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((Ability)et).getAbilityTypeCode(), (et, vl) -> {
            CDef.AbilityType cls = (CDef.AbilityType)gcls(et, columnAbilityTypeCode(), vl);
            if (cls != null) {
                ((Ability)et).setAbilityTypeCodeAsAbilityType(cls);
            } else {
                ((Ability)et).mynativeMappingAbilityTypeCode((String)vl);
            }
        }, "abilityTypeCode");
        setupEpg(_epgMap, et -> ((Ability)et).getVillageDayId(), (et, vl) -> ((Ability)et).setVillageDayId(cti(vl)), "villageDayId");
        setupEpg(_epgMap, et -> ((Ability)et).getVillagePlayerId(), (et, vl) -> ((Ability)et).setVillagePlayerId(cti(vl)), "villagePlayerId");
        setupEpg(_epgMap, et -> ((Ability)et).getTargetVillagePlayerId(), (et, vl) -> ((Ability)et).setTargetVillagePlayerId(cti(vl)), "targetVillagePlayerId");
        setupEpg(_epgMap, et -> ((Ability)et).getRegisterDatetime(), (et, vl) -> ((Ability)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Ability)et).getRegisterTrace(), (et, vl) -> ((Ability)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((Ability)et).getUpdateDatetime(), (et, vl) -> ((Ability)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Ability)et).getUpdateTrace(), (et, vl) -> ((Ability)et).setUpdateTrace((String)vl), "updateTrace");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((Ability)et).getAbilityType(), (et, vl) -> ((Ability)et).setAbilityType((OptionalEntity<AbilityType>)vl), "abilityType");
        setupEfpg(_efpgMap, et -> ((Ability)et).getVillagePlayerByTargetVillagePlayerId(), (et, vl) -> ((Ability)et).setVillagePlayerByTargetVillagePlayerId((OptionalEntity<VillagePlayer>)vl), "villagePlayerByTargetVillagePlayerId");
        setupEfpg(_efpgMap, et -> ((Ability)et).getVillageDay(), (et, vl) -> ((Ability)et).setVillageDay((OptionalEntity<VillageDay>)vl), "villageDay");
        setupEfpg(_efpgMap, et -> ((Ability)et).getVillagePlayerByVillagePlayerId(), (et, vl) -> ((Ability)et).setVillagePlayerByVillagePlayerId((OptionalEntity<VillagePlayer>)vl), "villagePlayerByVillagePlayerId");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "ability";
    protected final String _tableDispName = "ABILITY";
    protected final String _tablePropertyName = "ability";
    protected final TableSqlName _tableSqlName = new TableSqlName("ABILITY", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnAbilityTypeCode = cci("ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", null, null, String.class, "abilityTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "abilityType", null, CDef.DefMeta.AbilityType, false);
    protected final ColumnInfo _columnVillageDayId = cci("VILLAGE_DAY_ID", "VILLAGE_DAY_ID", null, null, Integer.class, "villageDayId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villageDay", null, null, false);
    protected final ColumnInfo _columnVillagePlayerId = cci("VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", null, null, Integer.class, "villagePlayerId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villagePlayerByVillagePlayerId", null, null, false);
    protected final ColumnInfo _columnTargetVillagePlayerId = cci("TARGET_VILLAGE_PLAYER_ID", "TARGET_VILLAGE_PLAYER_ID", null, null, Integer.class, "targetVillagePlayerId", null, false, false, false, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villagePlayerByTargetVillagePlayerId", null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAbilityTypeCode() { return _columnAbilityTypeCode; }
    /**
     * VILLAGE_DAY_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageDayId() { return _columnVillageDayId; }
    /**
     * VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillagePlayerId() { return _columnVillagePlayerId; }
    /**
     * TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTargetVillagePlayerId() { return _columnTargetVillagePlayerId; }
    /**
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterTrace() { return _columnRegisterTrace; }
    /**
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateTrace() { return _columnUpdateTrace; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnAbilityTypeCode());
        ls.add(columnVillageDayId());
        ls.add(columnVillagePlayerId());
        ls.add(columnTargetVillagePlayerId());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterTrace());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateTrace());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnAbilityTypeCode());
        ls.add(columnVillageDayId());
        ls.add(columnVillagePlayerId());
        return hpcpui(ls);
    }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return true; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignAbilityType() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAbilityTypeCode(), AbilityTypeDbm.getInstance().columnAbilityTypeCode());
        return cfi("FK_ABILITY_ABILITY_TYPE", "abilityType", this, AbilityTypeDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityList", false);
    }
    /**
     * VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillagePlayerByTargetVillagePlayerId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnTargetVillagePlayerId(), VillagePlayerDbm.getInstance().columnVillagePlayerId());
        return cfi("FK_ABILITY_TARGET_VILLAGE_PLAYER", "villagePlayerByTargetVillagePlayerId", this, VillagePlayerDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityByTargetVillagePlayerIdList", false);
    }
    /**
     * VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillageDay() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageDayId(), VillageDayDbm.getInstance().columnVillageDayId());
        return cfi("FK_ABILITY_VILLAGE_DAY", "villageDay", this, VillageDayDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityList", false);
    }
    /**
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillagePlayerByVillagePlayerId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillagePlayerId(), VillagePlayerDbm.getInstance().columnVillagePlayerId());
        return cfi("FK_ABILITY_VILLAGE_PLAYER", "villagePlayerByVillagePlayerId", this, VillagePlayerDbm.getInstance(), mp, 3, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityByVillagePlayerIdList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterTrace(), columnUpdateDatetime(), columnUpdateTrace()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterTrace(), columnUpdateDatetime(), columnUpdateTrace()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateTrace()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Ability"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.AbilityCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.AbilityBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Ability> getEntityType() { return Ability.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Ability newEntity() { return new Ability(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Ability)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Ability)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
