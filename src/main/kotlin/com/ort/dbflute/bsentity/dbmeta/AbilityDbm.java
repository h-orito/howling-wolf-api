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
        setupEpg(_epgMap, et -> ((Ability)et).getVillageId(), (et, vl) -> ((Ability)et).setVillageId(cti(vl)), "villageId");
        setupEpg(_epgMap, et -> ((Ability)et).getDay(), (et, vl) -> ((Ability)et).setDay(cti(vl)), "day");
        setupEpg(_epgMap, et -> ((Ability)et).getCharaId(), (et, vl) -> ((Ability)et).setCharaId(cti(vl)), "charaId");
        setupEpg(_epgMap, et -> ((Ability)et).getTargetCharaId(), (et, vl) -> ((Ability)et).setTargetCharaId(cti(vl)), "targetCharaId");
        setupEpg(_epgMap, et -> ((Ability)et).getAbilityTypeCode(), (et, vl) -> {
            CDef.AbilityType cls = (CDef.AbilityType)gcls(et, columnAbilityTypeCode(), vl);
            if (cls != null) {
                ((Ability)et).setAbilityTypeCodeAsAbilityType(cls);
            } else {
                ((Ability)et).mynativeMappingAbilityTypeCode((String)vl);
            }
        }, "abilityTypeCode");
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
        setupEfpg(_efpgMap, et -> ((Ability)et).getCharaByCharaId(), (et, vl) -> ((Ability)et).setCharaByCharaId((OptionalEntity<Chara>)vl), "charaByCharaId");
        setupEfpg(_efpgMap, et -> ((Ability)et).getCharaByTargetCharaId(), (et, vl) -> ((Ability)et).setCharaByTargetCharaId((OptionalEntity<Chara>)vl), "charaByTargetCharaId");
        setupEfpg(_efpgMap, et -> ((Ability)et).getVillageDay(), (et, vl) -> ((Ability)et).setVillageDay((OptionalEntity<VillageDay>)vl), "villageDay");
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
    protected final ColumnInfo _columnVillageId = cci("VILLAGE_ID", "VILLAGE_ID", null, null, Integer.class, "villageId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villageDay", null, null, false);
    protected final ColumnInfo _columnDay = cci("DAY", "DAY", null, null, Integer.class, "day", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villageDay", null, null, false);
    protected final ColumnInfo _columnCharaId = cci("CHARA_ID", "CHARA_ID", null, null, Integer.class, "charaId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "charaByCharaId", null, null, false);
    protected final ColumnInfo _columnTargetCharaId = cci("TARGET_CHARA_ID", "TARGET_CHARA_ID", null, null, Integer.class, "targetCharaId", null, false, false, false, "INT UNSIGNED", 10, 0, null, null, false, null, null, "charaByTargetCharaId", null, null, false);
    protected final ColumnInfo _columnAbilityTypeCode = cci("ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", null, null, String.class, "abilityTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "abilityType", null, CDef.DefMeta.AbilityType, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageId() { return _columnVillageId; }
    /**
     * DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDay() { return _columnDay; }
    /**
     * CHARA_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaId() { return _columnCharaId; }
    /**
     * TARGET_CHARA_ID: {IX, INT UNSIGNED(10), FK to chara}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTargetCharaId() { return _columnTargetCharaId; }
    /**
     * ABILITY_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAbilityTypeCode() { return _columnAbilityTypeCode; }
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
        ls.add(columnVillageId());
        ls.add(columnDay());
        ls.add(columnCharaId());
        ls.add(columnTargetCharaId());
        ls.add(columnAbilityTypeCode());
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
        ls.add(columnVillageId());
        ls.add(columnDay());
        ls.add(columnCharaId());
        ls.add(columnAbilityTypeCode());
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
     * CHARA by my CHARA_ID, named 'charaByCharaId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCharaByCharaId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaId(), CharaDbm.getInstance().columnCharaId());
        return cfi("FK_ABILITY_CHARA", "charaByCharaId", this, CharaDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityByCharaIdList", false);
    }
    /**
     * CHARA by my TARGET_CHARA_ID, named 'charaByTargetCharaId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCharaByTargetCharaId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnTargetCharaId(), CharaDbm.getInstance().columnCharaId());
        return cfi("FK_ABILITY_CHARA_TARGET", "charaByTargetCharaId", this, CharaDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityByTargetCharaIdList", false);
    }
    /**
     * VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillageDay() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMapSized(4);
        mp.put(columnVillageId(), VillageDayDbm.getInstance().columnVillageId());
        mp.put(columnDay(), VillageDayDbm.getInstance().columnDay());
        return cfi("FK_ABILITY_VILLAGE_DAY", "villageDay", this, VillageDayDbm.getInstance(), mp, 3, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "abilityList", false);
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
