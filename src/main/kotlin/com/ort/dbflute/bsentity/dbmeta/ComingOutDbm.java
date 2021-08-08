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
 * The DB meta of COMING_OUT. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class ComingOutDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final ComingOutDbm _instance = new ComingOutDbm();
    private ComingOutDbm() {}
    public static ComingOutDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((ComingOut)et).getVillagePlayerId(), (et, vl) -> ((ComingOut)et).setVillagePlayerId(cti(vl)), "villagePlayerId");
        setupEpg(_epgMap, et -> ((ComingOut)et).getSkillCode(), (et, vl) -> {
            CDef.Skill cls = (CDef.Skill)gcls(et, columnSkillCode(), vl);
            if (cls != null) {
                ((ComingOut)et).setSkillCodeAsSkill(cls);
            } else {
                ((ComingOut)et).mynativeMappingSkillCode((String)vl);
            }
        }, "skillCode");
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
        setupEfpg(_efpgMap, et -> ((ComingOut)et).getSkill(), (et, vl) -> ((ComingOut)et).setSkill((OptionalEntity<Skill>)vl), "skill");
        setupEfpg(_efpgMap, et -> ((ComingOut)et).getVillagePlayer(), (et, vl) -> ((ComingOut)et).setVillagePlayer((OptionalEntity<VillagePlayer>)vl), "villagePlayer");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "COMING_OUT";
    protected final String _tableDispName = "COMING_OUT";
    protected final String _tablePropertyName = "comingOut";
    protected final TableSqlName _tableSqlName = new TableSqlName("COMING_OUT", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillagePlayerId = cci("VILLAGE_PLAYER_ID", "VILLAGE_PLAYER_ID", null, null, Integer.class, "villagePlayerId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villagePlayer", null, null, false);
    protected final ColumnInfo _columnSkillCode = cci("SKILL_CODE", "SKILL_CODE", null, null, String.class, "skillCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "skill", null, CDef.DefMeta.Skill, false);

    /**
     * VILLAGE_PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE_PLAYER}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillagePlayerId() { return _columnVillagePlayerId; }
    /**
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to SKILL, classification=Skill}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnSkillCode() { return _columnSkillCode; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnVillagePlayerId());
        ls.add(columnSkillCode());
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
        ls.add(columnVillagePlayerId());
        ls.add(columnSkillCode());
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
     * SKILL by my SKILL_CODE, named 'skill'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignSkill() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnSkillCode(), SkillDbm.getInstance().columnSkillCode());
        return cfi("FK_COMING_OUT_SKILL", "skill", this, SkillDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "comingOutList", false);
    }
    /**
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayer'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillagePlayer() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillagePlayerId(), VillagePlayerDbm.getInstance().columnVillagePlayerId());
        return cfi("FK_COMING_OUT_VILLAGE_PLAYER", "villagePlayer", this, VillagePlayerDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "comingOutList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.ComingOut"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.ComingOutCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.ComingOutBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<ComingOut> getEntityType() { return ComingOut.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public ComingOut newEntity() { return new ComingOut(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((ComingOut)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((ComingOut)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
