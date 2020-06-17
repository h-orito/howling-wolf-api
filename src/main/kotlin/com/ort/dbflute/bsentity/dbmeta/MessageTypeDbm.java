package com.ort.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.exentity.*;

/**
 * The DB meta of MESSAGE_TYPE. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MessageTypeDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MessageTypeDbm _instance = new MessageTypeDbm();
    private MessageTypeDbm() {}
    public static MessageTypeDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((MessageType)et).getMessageTypeCode(), (et, vl) -> {
            CDef.MessageType cls = (CDef.MessageType)gcls(et, columnMessageTypeCode(), vl);
            if (cls != null) {
                ((MessageType)et).setMessageTypeCodeAsMessageType(cls);
            } else {
                ((MessageType)et).mynativeMappingMessageTypeCode((String)vl);
            }
        }, "messageTypeCode");
        setupEpg(_epgMap, et -> ((MessageType)et).getMessageTypeName(), (et, vl) -> ((MessageType)et).setMessageTypeName((String)vl), "messageTypeName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MESSAGE_TYPE";
    protected final String _tableDispName = "MESSAGE_TYPE";
    protected final String _tablePropertyName = "messageType";
    protected final TableSqlName _tableSqlName = new TableSqlName("MESSAGE_TYPE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMessageTypeCode = cci("MESSAGE_TYPE_CODE", "MESSAGE_TYPE_CODE", null, null, String.class, "messageTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "messageRestrictionList", CDef.DefMeta.MessageType, false);
    protected final ColumnInfo _columnMessageTypeName = cci("MESSAGE_TYPE_NAME", "MESSAGE_TYPE_NAME", null, null, String.class, "messageTypeName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * MESSAGE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=MessageType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageTypeCode() { return _columnMessageTypeCode; }
    /**
     * MESSAGE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageTypeName() { return _columnMessageTypeName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMessageTypeCode());
        ls.add(columnMessageTypeName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnMessageTypeCode()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * MESSAGE_RESTRICTION by MESSAGE_TYPE_CODE, named 'messageRestrictionList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerMessageRestrictionList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMessageTypeCode(), MessageRestrictionDbm.getInstance().columnMessageTypeCode());
        return cri("FK_MESSAGE_RESTRICTION_MESSAGE_TYPE", "messageRestrictionList", this, MessageRestrictionDbm.getInstance(), mp, false, "messageType");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.MessageType"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.MessageTypeCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.MessageTypeBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MessageType> getEntityType() { return MessageType.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public MessageType newEntity() { return new MessageType(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((MessageType)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((MessageType)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
